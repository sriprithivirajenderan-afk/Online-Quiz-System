package com.quizapp.model;

/**
 * Abstract base class for all quiz questions.
 *
 * OOP: encapsulates common state (id, text, points) and behavior contract.
 * SOLID - Open/Closed Principle: new question types (e.g. FillInBlankQuestion)
 * can be added later by extending this class WITHOUT modifying any existing
 * code that already works with Question objects.
 */
public abstract class Question {
    private final String id;
    private final String questionText;
    private final int points;

    public Question(String id, String questionText, int points) {
        this.id = id;
        this.questionText = questionText;
        this.points = points;
    }

    public String getId() {
        return id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public int getPoints() {
        return points;
    }

    /** Every concrete question type decides for itself how to grade an answer. */
    public abstract boolean isCorrect(String userAnswer);

    /** Every concrete question type decides for itself how to render itself. */
    public abstract String display();
}
