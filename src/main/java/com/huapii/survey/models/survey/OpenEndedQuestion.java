package com.huapii.survey.models.survey;

import com.huapii.survey.enums.QuestionType;
import jakarta.persistence.Entity;

@Entity
public class OpenEndedQuestion extends Question {

    public OpenEndedQuestion() {}

    public OpenEndedQuestion(String questionText) {
        super(questionText, QuestionType.OPEN_ENDED);
    }

}
