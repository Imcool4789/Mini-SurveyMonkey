package com.group5.MiniSurveyMonkey.Answer;

import com.group5.MiniSurveyMonkey.Question.NumberRangeQuestion;
import com.group5.MiniSurveyMonkey.Survey.SurveyModel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("NumberRangeAnswer")
public class NumberRangeAnswer extends AnswerModel {
    private int num;

    public NumberRangeAnswer() {
        super();
        this.num = 1;
    }

    public NumberRangeAnswer(int num, SurveyModel survey, NumberRangeQuestion question) {
        super();
        this.num = 1;
        super.setSurvey(survey);
        super.setQuestion(question);
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

}
