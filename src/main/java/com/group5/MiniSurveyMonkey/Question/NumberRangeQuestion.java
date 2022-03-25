package com.group5.MiniSurveyMonkey.Question;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NumberRangeQuestion extends QuestionModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int min;
    private int max;
    private int num;

    public NumberRangeQuestion()
    {
        this.min = 0;
        this.max = 10;
        this.num = 0;
    }

    public NumberRangeQuestion(int min, int max, int num)
    {
        this.min = min;
        this.max = max;
        this.num = num;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "NumberRangeQuestion{" +
                "min=" + min +
                ", max=" + max +
                ", num=" + num +
                '}';
    }
}
