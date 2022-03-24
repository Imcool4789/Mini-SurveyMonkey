package com.group5.MiniSurveyMonkey.Answer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NumberRangeAnswer extends AnswerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int num;

    public NumberRangeAnswer() {
        this.num = 1;
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
