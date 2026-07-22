package com.quizapp.service;

import com.quizapp.model.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * SRP: this class's only responsibility is storing the questions the admin creates.
 */
public class QuestionBank {
    private final List<Question> questions = new ArrayList<>();

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getAllQuestions() {
        return new ArrayList<>(questions);
    }

    public int size() {
        return questions.size();
    }

    public boolean isEmpty() {
        return questions.isEmpty();
    }

    /** Finds a question by its id, or null if no question has that id. */
    public Question findById(String id) {
        for (Question q : questions) {
            if (q.getId().equalsIgnoreCase(id)) {
                return q;
            }
        }
        return null;
    }

    /**
     * Replaces the question with the given id with a newly-built one.
     * Returns true if a matching question was found and replaced.
     */
    public boolean updateQuestion(String id, Question updated) {
        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).getId().equalsIgnoreCase(id)) {
                questions.set(i, updated);
                return true;
            }
        }
        return false;
    }
}
