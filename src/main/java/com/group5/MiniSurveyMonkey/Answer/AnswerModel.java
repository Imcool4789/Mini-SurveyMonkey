package com.group5.MiniSurveyMonkey.Answer;

import com.group5.MiniSurveyMonkey.Question.QuestionModel;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AnswerModel {

    @Id
    private long id;
    private String answer;

    @ManyToOne(fetch = FetchType.LAZY)
    private QuestionModel q;

    public AnswerModel(){

    }

    public AnswerModel(Long id,String answer) {
        this.id = id;
        this.answer = answer;
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
