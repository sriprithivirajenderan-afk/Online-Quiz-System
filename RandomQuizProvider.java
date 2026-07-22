package com.quizapp.service;

import com.quizapp.enums.QuestionType;
import com.quizapp.factory.IQuestionFactory;
import com.quizapp.model.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * SRP: supplies a ready-made pool of default questions so a player can take
 * a quiz even when no admin has created one yet. Questions are shuffled
 * (Collections.shuffle) so each random quiz feels different, then trimmed
 * to however many the player asked for.
 */
public class RandomQuizProvider {
    private final List<Question> pool = new ArrayList<>();

    public RandomQuizProvider(IQuestionFactory factory) {
        pool.add(factory.createQuestion(QuestionType.MCQ, "R1",
                "What is the capital of France?", 10,
                Arrays.asList("Berlin", "Madrid", "Paris", "Rome"), "C"));
        pool.add(factory.createQuestion(QuestionType.TRUE_FALSE, "R2",
                "Java source code is compiled to bytecode before it runs.", 5,
                null, "true"));
        pool.add(factory.createQuestion(QuestionType.MCQ, "R3",
                "Which data structure processes elements First-In-First-Out?", 10,
                Arrays.asList("Stack", "Queue", "Tree", "Graph"), "B"));
        pool.add(factory.createQuestion(QuestionType.MCQ, "R4",
                "Which Java collection maps unique keys to values?", 10,
                Arrays.asList("ArrayList", "HashMap", "Queue", "Stack"), "B"));
        pool.add(factory.createQuestion(QuestionType.TRUE_FALSE, "R5",
                "A HashMap allows duplicate keys.", 5,
                null, "false"));
        pool.add(factory.createQuestion(QuestionType.MCQ, "R6",
                "Which keyword is used to inherit a class in Java?", 10,
                Arrays.asList("implements", "extends", "inherits", "super"), "B"));
        pool.add(factory.createQuestion(QuestionType.MCQ, "R7",
                "Which SOLID principle says a class should have only one reason to change?", 10,
                Arrays.asList("Open/Closed", "Liskov Substitution", "Single Responsibility", "Dependency Inversion"), "C"));
        pool.add(factory.createQuestion(QuestionType.TRUE_FALSE, "R8",
                "The Factory Pattern centralizes object creation logic.", 5,
                null, "true"));
    }

    /** Returns up to 'count' random questions from the pool, order shuffled each time. */
    public List<Question> getRandomQuestions(int count) {
        List<Question> shuffled = new ArrayList<>(pool);
        Collections.shuffle(shuffled);
        int limit = Math.min(Math.max(count, 1), shuffled.size());
        return new ArrayList<>(shuffled.subList(0, limit));
    }

    public int poolSize() {
        return pool.size();
    }
}
