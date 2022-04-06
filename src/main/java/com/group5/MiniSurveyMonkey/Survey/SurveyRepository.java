package com.group5.MiniSurveyMonkey.Survey;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends MongoRepository<SurveyModel, Long> {
    @Query("{id:'?0'}")
    SurveyModel findById (long id);
    SurveyModel findByName (String name);
}