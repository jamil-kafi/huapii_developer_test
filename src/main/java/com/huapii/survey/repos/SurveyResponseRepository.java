package com.huapii.survey.repos;

import com.huapii.survey.models.survey.SurveyResponse;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SurveyResponseRepository extends CrudRepository<SurveyResponse, Long> {

    List<SurveyResponse> findBySurveyId(Long surveyId);
    List<SurveyResponse> findByUserId(Long userId);

}
