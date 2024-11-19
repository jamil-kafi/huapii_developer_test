package com.huapii.survey.services;

import com.huapii.survey.models.survey.Survey;
import com.huapii.survey.models.survey.SurveyResponse;

import java.util.List;
import java.util.Optional;

public interface SurveyService {

    Iterable<Survey> getSurveys();
    Optional<Survey> getSurveyById(Long id);
    Survey createSurvey(Survey survey);
    void deleteSurvey(Long id);

    SurveyResponse respondToSurvey(SurveyResponse surveyResponse);
    List<SurveyResponse> findBySurveyId(Long surveyId);
    List<SurveyResponse> findByUserId(Long userId);
}
