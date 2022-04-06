package com.group5.MiniSurveyMonkey.Question;

import com.group5.MiniSurveyMonkey.Answer.NumberRangeAnswer;
import com.group5.MiniSurveyMonkey.Answer.OpenAnswer;
import com.group5.MiniSurveyMonkey.Survey.SurveyModel;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Document("NumberRangeQuestion")
@Entity
@DiscriminatorValue("NumberRangeQuestion")
public class NumberRangeQuestion extends QuestionModel
{
    private int min;
    private int max;
    private int num;

    public NumberRangeQuestion()
    {
        super();
        this.min = 0;
        this.max = 10;
        this.num = 0;
    }

    public NumberRangeQuestion(int min, int max, int num, String name, SurveyModel survey)
    {
        super();
        this.min = min;
        this.max = max;
        this.num = num;
        super.setName(name);
        super.setSurvey(survey);
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

    public void addResponse (NumberRangeAnswer response){
        super.getResponses().add(response);
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
