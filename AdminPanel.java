package com.quizapp.service;

import com.quizapp.enums.QuestionType;
import com.quizapp.factory.IQuestionFactory;
import com.quizapp.model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * SRP: walks an admin through creating and updating quiz questions via the console.
 * DIP: depends on IQuestionFactory, not the concrete QuestionFactory.
 * Still routes all object creation through the Factory Pattern.
 */
public class AdminPanel {
    private final IQuestionFactory factory;
    private final QuestionBank questionBank;

    public AdminPanel(IQuestionFactory factory, QuestionBank questionBank) {
        this.factory = factory;
        this.questionBank = questionBank;
    }

    public void createQuiz(Scanner scanner) {
        System.out.println("\n--- ADMIN: CREATE QUIZ ---");
        System.out.print("How many questions do you want to add? ");
        int count = readInt(scanner);

        for (int i = 1; i <= count; i++) {
            System.out.println("\nQuestion " + i + ":");
            String id = "Q" + (questionBank.size() + 1);
            Question q = promptForQuestion(scanner, id);
            if (q == null) {
                i--; // invalid type entered, retry the same slot
                continue;
            }
            questionBank.addQuestion(q);
        }
        System.out.println("\n" + questionBank.size() + " question(s) now in the quiz bank.");
    }

    /**
     * Lets the admin pick an existing question by id and overwrite it with
     * freshly entered details. The id stays the same; everything else
     * (type, text, points, options, correct answer) can change.
     */
    public void updateQuestion(Scanner scanner) {
        System.out.println("\n--- ADMIN: UPDATE QUESTION ---");
        if (questionBank.isEmpty()) {
            System.out.println("There are no questions yet to update. Create one first.");
            return;
        }

        System.out.println("Current questions:");
        for (Question q : questionBank.getAllQuestions()) {
            System.out.println("  " + q.getId() + " - " + q.getQuestionText());
        }

        System.out.print("\nEnter the id of the question to update: ");
        String id = scanner.nextLine().trim();

        Question existing = questionBank.findById(id);
        if (existing == null) {
            System.out.println("No question found with id " + id + ".");
            return;
        }

        System.out.println("Editing " + id + " - enter the new details below.");
        Question updated = promptForQuestion(scanner, id);
        if (updated == null) {
            System.out.println("Update cancelled due to invalid input.");
            return;
        }

        questionBank.updateQuestion(id, updated);
        System.out.println(id + " updated successfully.");
    }

    /**
     * Shared prompt logic for building a single Question (used by both
     * create and update flows) so the input-gathering code isn't duplicated.
     * Returns null if the admin enters an invalid question type.
     */
    private Question promptForQuestion(Scanner scanner, String id) {
        System.out.print("Type (1 = Multiple Choice, 2 = True/False): ");
        String typeChoice = scanner.nextLine().trim();

        System.out.print("Enter question text: ");
        String text = scanner.nextLine().trim();

        System.out.print("Enter points for this question: ");
        int points = readInt(scanner);

        if (typeChoice.equals("1")) {
            List<String> options = new ArrayList<>();
            System.out.print("How many options? ");
            int optionCount = readInt(scanner);
            char label = 'A';
            for (int j = 0; j < optionCount; j++) {
                System.out.print("  Option " + label + ": ");
                options.add(scanner.nextLine().trim());
                label++;
            }
            System.out.print("Correct option letter (e.g. A): ");
            String correct = scanner.nextLine().trim();

            return factory.createQuestion(QuestionType.MCQ, id, text, points, options, correct);

        } else if (typeChoice.equals("2")) {
            System.out.print("Correct answer (true/false): ");
            String correct = scanner.nextLine().trim();

            return factory.createQuestion(QuestionType.TRUE_FALSE, id, text, points, null, correct);

        } else {
            System.out.println("Invalid type.");
            return null;
        }
    }

    private int readInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
}
