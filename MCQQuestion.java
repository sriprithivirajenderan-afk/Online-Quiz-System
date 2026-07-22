package com.quizapp.model;

import java.util.List;

/**
 * Multiple choice question.
 * Demonstrates ArrayList/List usage and String handling (trim + case-insensitive compare).
 * LSP: can be used anywhere a Question is expected, fully honoring the base contract.
 */
public class MCQQuestion extends Question {
    private final List<String> options; // holds an ArrayList passed in from the caller
    private final String correctOption; // e.g. "A", "B", "C", "D"

    public MCQQuestion(String id, String questionText, int points,
                        List<String> options, String correctOption) {
        super(id, questionText, points);
        this.options = options;
        this.correctOption = correctOption;
    }

    @Override
    public boolean isCorrect(String userAnswer) {
        if (userAnswer == null) return false;
        // String Foundations: trim whitespace + case-insensitive comparison
        return userAnswer.trim().equalsIgnoreCase(correctOption.trim());
    }

    @Override
    public String display() {
        StringBuilder sb = new StringBuilder();
        sb.append(getQuestionText()).append(" [").append(getPoints()).append(" pts]\n");
        char label = 'A';
        for (String option : options) {
            sb.append("   ").append(label).append(") ").append(option).append("\n");
            label++;
        }
        return sb.toString();
    }
}
