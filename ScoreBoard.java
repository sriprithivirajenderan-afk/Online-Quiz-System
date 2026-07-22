package com.quizapp.service;

import com.quizapp.model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SRP: this class's only responsibility is recording and ranking player scores.
 * Demonstrates HashMap usage and Sorting (Collections/List sort with a comparator).
 */
public class ScoreBoard {
    private final Map<String, Integer> scores = new HashMap<>();

    public void record(Player player) {
        scores.put(player.getName(), player.getScore());
    }

    /** Returns players ranked highest score first. */
    public List<Map.Entry<String, Integer>> getRankedLeaderboard() {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(scores.entrySet());
        entries.sort((a, b) -> b.getValue() - a.getValue()); // Sorting: descending by score
        return entries;
    }

    public void printLeaderboard() {
        System.out.println("\n===== LEADERBOARD =====");
        int rank = 1;
        for (Map.Entry<String, Integer> entry : getRankedLeaderboard()) {
            System.out.printf("%d. %-15s %d pts%n", rank++, entry.getKey(), entry.getValue());
        }
    }
}
