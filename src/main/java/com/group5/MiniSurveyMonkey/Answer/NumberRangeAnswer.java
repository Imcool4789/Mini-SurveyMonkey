package com.group5.MiniSurveyMonkey.Answer;

import com.group5.MiniSurveyMonkey.Question.NumberRangeQuestion;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Map;

@Entity
@DiscriminatorValue("NumberRangeAnswer")
public class NumberRangeAnswer extends AnswerModel {
    private int num;

    public NumberRangeAnswer() {
        super();
        this.num = 1;
    }

    public NumberRangeAnswer(int num, NumberRangeQuestion question) {
        super();
        this.num = num;
        //super.setSurvey(question.getSurvey());
        super.setQuestion(question);
        this.updateResponses(num, question);
        question.addResponse(this);
    }

    public NumberRangeAnswer(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void updateResponses(int num, NumberRangeQuestion question) {
        Map<String, Integer> questionResponses = question.getResponseMap();
        questionResponses.put(String.valueOf(num), questionResponses.getOrDefault(String.valueOf(num), 0) + 1);
    }

}
