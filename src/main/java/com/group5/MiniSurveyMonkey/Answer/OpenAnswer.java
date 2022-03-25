package com.group5.MiniSurveyMonkey.Answer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OpenAnswer extends AnswerModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String answer;

    public OpenAnswer (){
        this.answer = "";
    }

    public OpenAnswer (String answer){
        this.answer = answer;
    }

    public String getAnswer (){
        return answer;
    }

    public void setAnswer(String answer){
        this.answer = answer;
    }
}
