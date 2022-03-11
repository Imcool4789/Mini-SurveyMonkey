package com.group5.MiniSurveyMonkey.Question;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface QuestionRepository extends CrudRepository<QuestionModel, Long> {
        QuestionModel findById(long id);
    }
