package com.quizapp.model;

/**
 * True/False question type.
 * Shows how easy OCP makes it to add new question kinds: no other class had
 * to change when this one was introduced.
 */
public class TrueFalseQuestion extends Question {
    private final boolean correctAnswer;

    public TrueFalseQuestion(String id, String questionText, int points, boolean correctAnswer) {
        super(id, questionText, points);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean isCorrect(String userAnswer) {
        if (userAnswer == null) return false;
        String normalized = userAnswer.trim().toLowerCase();
        boolean userBool = normalized.equals("true") || normalized.equals("t") || normalized.equals("yes");
        return userBool == correctAnswer;
    }

    @Override
    public String display() {
        return getQuestionText() + " [" + getPoints() + " pts]\n   (Answer: true / false)";
    }
}
