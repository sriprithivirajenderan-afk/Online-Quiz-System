package com.quizapp.service;

import com.quizapp.model.Player;
import com.quizapp.model.Question;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * SRP: administers one quiz session to one player, question by question.
 * Demonstrates Queue usage (FIFO delivery of questions) and depends only on
 * the Question abstraction, not on any concrete question class (DIP).
 */
public class QuizEngine {
    private final Queue<Question> questionQueue;

    public QuizEngine(List<Question> questions) {
        this.questionQueue = new LinkedList<>(questions); // Queue: LinkedList implements Queue
    }

    public void administer(Player player, Scanner scanner) {
        System.out.println("\n--- Quiz starting for " + player.getName() + " ---");
        int qNum = 1;
        while (!questionQueue.isEmpty()) {
            Question q = questionQueue.poll(); // dequeue next question
            System.out.println("\nQ" + qNum + ": " + q.display());
            System.out.print("Your answer: ");
            String answer = scanner.nextLine();

            if (q.isCorrect(answer)) {
                System.out.println("Correct! +" + q.getPoints() + " pts");
                player.addScore(q.getPoints());
            } else {
                System.out.println("Incorrect.");
            }
            qNum++;
        }
        System.out.println("\n" + player.getName() + " finished with " + player.getScore() + " points.");
    }
}
