package com.group5.MiniSurveyMonkey.Answer;

import com.group5.MiniSurveyMonkey.Question.QuestionModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class AnswerModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String answer;


    private QuestionModel q;

    public AnswerModel(){
        this.id = 1;
        this.answer = "";
        q = new QuestionModel();
    }

    public AnswerModel(Long id,String answer, QuestionModel q) {
        this.id = id;
        this.answer = answer;
        this.q = q;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setQuestion(QuestionModel q) {
        this.q = q;
    }



    public QuestionModel getQuestion(){
        return q;
    }

    @Override
    public String toString() {
        return "AnswerModel{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
                ", question=" + getQuestion() +
                '}';
    }
}
