package com.quizapp.factory;

import com.quizapp.model.MCQQuestion;
import com.quizapp.model.Question;
import com.quizapp.model.TrueFalseQuestion;
import com.quizapp.enums.QuestionType;
import java.util.List;

/**
 * FACTORY PATTERN: centralizes the logic for constructing Question objects
 * so client code never calls "new MCQQuestion(...)" / "new TrueFalseQuestion(...)"
 * directly. Adding a new question type only means adding a case here plus a
 * new Question subclass - existing callers are untouched (Open/Closed Principle).
 */
public class QuestionFactory implements IQuestionFactory {

    @Override
    public Question createQuestion(QuestionType type,
                                    String id,
                                    String text,
                                    int points,
                                    List<String> options,
                                    String correctAnswer) {
        switch (type) {
            case MCQ:
                return new MCQQuestion(id, text, points, options, correctAnswer);
            case TRUE_FALSE:
                return new TrueFalseQuestion(id, text, points, Boolean.parseBoolean(correctAnswer));
            default:
                throw new IllegalArgumentException("Unsupported question type: " + type);
        }
    }
}
