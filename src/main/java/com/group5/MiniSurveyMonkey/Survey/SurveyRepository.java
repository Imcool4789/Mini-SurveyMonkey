package com.group5.MiniSurveyMonkey.Survey;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends CrudRepository<SurveyModel, Long> {

    SurveyModel findById (long id);
}