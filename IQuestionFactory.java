package com.quizapp.factory;

import com.quizapp.model.Question;
import com.quizapp.enums.QuestionType;
import java.util.List;

/**
 * SOLID - Dependency Inversion Principle: high-level code (Main, QuizEngine)
 * depends on this abstraction rather than on the concrete QuestionFactory class,
 * so the concrete factory can be swapped out (e.g. for a JSON-driven factory)
 * without touching client code.
 */
public interface IQuestionFactory {
    Question createQuestion(QuestionType type,
                             String id,
                             String text,
                             int points,
                             List<String> options,
                             String correctAnswer);
}
