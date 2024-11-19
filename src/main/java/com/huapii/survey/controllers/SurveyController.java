package com.huapii.survey.controllers;

import com.huapii.survey.models.survey.Survey;
import com.huapii.survey.models.survey.SurveyResponse;
import com.huapii.survey.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = {"/api/surveys"})
public class SurveyController {

    private final SurveyService surveyService;

    @Autowired
    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping(path = {"/all"})
    public Iterable<Survey> getSurveys() {
        return surveyService.getSurveys();
    }

    @GetMapping("/{id}")
    public Optional<Survey> getSurvey(@PathVariable Long id) {
        return surveyService.getSurveyById(id);
    }

    /**
     * Management endpoint to create a new Survey.
     * @param survey
     * @return
     */
    @PostMapping
    public Survey createSurvey(@RequestBody Survey survey) {
        return surveyService.createSurvey(survey);
    }

    /**
     * Management endpoint to delete a survey.
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteSurvey(@PathVariable Long id) {
        surveyService.deleteSurvey(id);
    }

    // ******************************************
    // ******************************************
    // ******************************************

    @PostMapping("/respond")
    public SurveyResponse respondToSurvey(@RequestBody SurveyResponse surveyResponse) {
        return surveyService.respondToSurvey(surveyResponse);
    }

    @GetMapping(path = {"/bySurvey/{surveyId}"})
    public List<SurveyResponse> findBySurvey(@PathVariable Long surveyId) {
        return surveyService.findBySurveyId(surveyId);
    }

    @GetMapping(path = {"/bySurvey/{userId}"})
    public List<SurveyResponse> findByUserId(@PathVariable Long userId) {
        return surveyService.findByUserId(userId);
    }
}
