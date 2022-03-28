package com.group5.MiniSurveyMonkey.Answer;

import com.group5.MiniSurveyMonkey.Question.OpenQuestion;
import com.group5.MiniSurveyMonkey.Survey.SurveyModel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("OpenAnswer")
public class OpenAnswer extends AnswerModel{

    public OpenAnswer (){
        super();
    }

    public OpenAnswer (String answer, SurveyModel survey, OpenQuestion question){
        super();
        super.setAnswer(answer);
        super.setSurvey(survey);
        super.setQuestion(question);
    }
}
