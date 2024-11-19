package com.huapii.survey.services.impl;

import com.huapii.survey.models.survey.Survey;
import com.huapii.survey.models.survey.SurveyResponse;
import com.huapii.survey.repos.SurveyRepository;
import com.huapii.survey.repos.SurveyResponseRepository;
import com.huapii.survey.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyServiceImpl implements SurveyService {

    private final SurveyRepository surveyRepository;
    private final SurveyResponseRepository responseRepository;

    @Autowired // Autowired is optional when using constructor injection.
    public SurveyServiceImpl(SurveyRepository surveyRepository, SurveyResponseRepository responseRepository) {
        this.surveyRepository = surveyRepository;
        this.responseRepository = responseRepository;
    }

    @Override
    public Iterable<Survey> getSurveys() {
        return surveyRepository.findAll();
    }

    @Override
    public Optional<Survey> getSurveyById(Long id) {
        return surveyRepository.findById(id);
    }

    @Override
    public Survey createSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    @Override
    public void deleteSurvey(Long id) {
        surveyRepository.deleteById(id);
    }

    public Long updateSurvey(Survey survey) {
        // TODO
        return 0L;
    }

    // ******************************************

    @Override
    public SurveyResponse respondToSurvey(SurveyResponse surveyResponse) {
        return responseRepository.save(surveyResponse);
    }

    @Override
    public List<SurveyResponse> findBySurveyId(Long surveyId) {
        return responseRepository.findBySurveyId(surveyId);
    }

    @Override
    public List<SurveyResponse> findByUserId(Long userId) {
        return responseRepository.findByUserId(userId);
    }
}
