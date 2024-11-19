package com.huapii.survey.models.survey;

import com.huapii.survey.enums.QuestionType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class SingleChoiceQuestion extends Question {

    @ElementCollection
    private List<String> options;

    public SingleChoiceQuestion() {}

    public SingleChoiceQuestion(String questionText, List<String> options) {
        super(questionText, QuestionType.SINGLE_CHOICE);
        this.options = options;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

}
