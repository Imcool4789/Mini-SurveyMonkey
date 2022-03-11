package com.group5.MiniSurveyMonkey.Question;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "questions")
    public interface QuestionRepository extends CrudRepository<QuestionModel, Long> {
        QuestionModel findById(long id);
        List<QuestionModel> findAll();
    }
