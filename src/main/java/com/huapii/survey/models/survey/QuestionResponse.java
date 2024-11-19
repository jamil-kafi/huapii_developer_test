package com.huapii.survey.models.survey;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class QuestionResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question; // Link to the specific question

    // For single-choice and multiple-choice answers
    @ElementCollection
    private List<String> selectedOptions;

    // For open-ended answers
    @Column(columnDefinition = "TEXT")
    private String openEndedAnswer;

    // Constructors, Getters, and Setters
    public QuestionResponse() {}

    public QuestionResponse(Question question, List<String> selectedOptions, String openEndedAnswer) {
        this.question = question;
        this.selectedOptions = selectedOptions;
        this.openEndedAnswer = openEndedAnswer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<String> getSelectedOptions() {
        return selectedOptions;
    }

    public void setSelectedOptions(List<String> selectedOptions) {
        this.selectedOptions = selectedOptions;
    }

    public String getOpenEndedAnswer() {
        return openEndedAnswer;
    }

    public void setOpenEndedAnswer(String openEndedAnswer) {
        this.openEndedAnswer = openEndedAnswer;
    }

}
