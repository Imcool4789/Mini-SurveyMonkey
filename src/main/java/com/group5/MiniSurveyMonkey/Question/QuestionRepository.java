package com.group5.MiniSurveyMonkey.Question;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface QuestionRepository extends MongoRepository<QuestionModel, Long> {

        @Query("{id:'?0'}")
        QuestionModel findById(long id);
    }
