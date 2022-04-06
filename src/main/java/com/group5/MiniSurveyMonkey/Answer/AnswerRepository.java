package com.group5.MiniSurveyMonkey.Answer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends MongoRepository<AnswerModel, Long>
{
    @Query("{id:'?0'}")
    AnswerModel findById(long id);

    @Query(value="{id:'?0'}", fields = "{name: 1}")
    List<AnswerModel> findAll(String id);
}


