package com.quizapp;

import com.quizapp.factory.IQuestionFactory;
import com.quizapp.factory.QuestionFactory;
import com.quizapp.model.Player;
import com.quizapp.model.Question;
import com.quizapp.service.AdminPanel;
import com.quizapp.service.QuestionBank;
import com.quizapp.service.QuizEngine;
import com.quizapp.service.RandomQuizProvider;
import com.quizapp.service.ScoreBoard;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IQuestionFactory factory = new QuestionFactory();
        QuestionBank questionBank = new QuestionBank();
        AdminPanel adminPanel = new AdminPanel(factory, questionBank);
        RandomQuizProvider randomQuizProvider = new RandomQuizProvider(factory);
        ScoreBoard scoreBoard = new ScoreBoard();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== ONLINE QUIZ SYSTEM ===");

        boolean running = true;
        while (running) {
            System.out.println("\n1. Admin - Create Quiz");
            System.out.println("2. Admin - Update Question");
            System.out.println("3. Player - Take Quiz (admin questions)");
            System.out.println("4. Player - Take Random Quiz (no admin needed)");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    adminPanel.createQuiz(scanner);
                    break;

                case "2":
                    adminPanel.updateQuestion(scanner);
                    break;

                case "3":
                    if (questionBank.isEmpty()) {
                        System.out.println("No admin quiz available yet. Try option 4 for a random quiz instead.");
                        break;
                    }
                    playQuiz(questionBank.getAllQuestions(), scanner, scoreBoard);
                    break;

                case "4":
                    System.out.print("How many random questions would you like? ");
                    int count = readInt(scanner);
                    List<Question> randomQuestions = randomQuizProvider.getRandomQuestions(count);
                    playQuiz(randomQuestions, scanner, scoreBoard);
                    break;

                case "5":
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option, try again.");
            }
        }
        scanner.close();
    }

    private static void playQuiz(List<Question> questions, Scanner scanner, ScoreBoard scoreBoard) {
        System.out.print("Enter player name: ");
        Player player = new Player(scanner.nextLine());
        new QuizEngine(questions).administer(player, scanner);
        scoreBoard.record(player);
        scoreBoard.printLeaderboard();
    }

    private static int readInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
}
