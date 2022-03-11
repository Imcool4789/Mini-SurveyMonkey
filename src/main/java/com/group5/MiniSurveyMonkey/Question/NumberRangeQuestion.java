package com.group5.MiniSurveyMonkey.Question;

import javax.persistence.Entity;

@Entity
public class NumberRangeQuestion extends QuestionModel
{
    private int min;
    private int max;
    private int num;

    public NumberRangeQuestion()
    {
        setType(QuestionType.RANGE);
        this.min = 0;
        this.max = 10;
        this.num = 0;
    }

    public NumberRangeQuestion(int min, int max, int num)
    {
        setType(QuestionType.RANGE);
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
