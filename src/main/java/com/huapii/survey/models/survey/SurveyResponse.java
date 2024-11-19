package com.huapii.survey.models.survey;

import com.huapii.survey.models.users.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class SurveyResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "survey_id", nullable = false)
    private Survey survey; // The survey being responded to

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true) // Nullable for anonymous responses
    private User user;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "survey_response_id")
    private List<QuestionResponse> questionResponses; // List of responses for each question

    private boolean isAnonymous; // Indicates if the response is anonymous

    private Long timestamp; // Time when the survey was submitted

    public SurveyResponse() {}

    public SurveyResponse(Survey survey, User user, List<QuestionResponse> questionResponses, boolean isAnonymous, Long timestamp) {
        this.survey = survey;
        this.user = user;
        this.questionResponses = questionResponses;
        this.isAnonymous = isAnonymous;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<QuestionResponse> getQuestionResponses() {
        return questionResponses;
    }

    public void setQuestionResponses(List<QuestionResponse> questionResponses) {
        this.questionResponses = questionResponses;
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(boolean anonymous) {
        isAnonymous = anonymous;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

}
