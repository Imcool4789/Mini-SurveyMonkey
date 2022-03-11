package com.group5.MiniSurveyMonkey.Answer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends CrudRepository <AnswerModel, Long>
{
    AnswerModel findById(long id);
    List<AnswerModel> findAll();
}


