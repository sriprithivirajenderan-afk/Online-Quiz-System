package com.quizapp.model;

/**
 * Represents a quiz participant.
 * SRP: this class only tracks a player's identity and running score.
 */
public class Player {
    private final String name;
    private int score;

    public Player(String name) {
        this.name = (name == null || name.trim().isEmpty()) ? "Anonymous" : name.trim();
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int points) {
        this.score += points;
    }
}
