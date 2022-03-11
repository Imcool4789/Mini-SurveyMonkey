package com.group5.MiniSurveyMonkey.Answer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(path = "answers")
    public interface AnswerRepository extends CrudRepository <AnswerModel, Long> {
        AnswerModel findById(long id);
        List<AnswerModel> findAll();
    }


