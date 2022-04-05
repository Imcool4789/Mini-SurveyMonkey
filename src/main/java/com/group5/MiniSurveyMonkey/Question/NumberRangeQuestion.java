package com.group5.MiniSurveyMonkey.Question;

import com.group5.MiniSurveyMonkey.Answer.NumberRangeAnswer;
import com.group5.MiniSurveyMonkey.Survey.SurveyModel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.HashMap;
import java.util.Map;

@Entity
@DiscriminatorValue("NumberRangeQuestion")
public class NumberRangeQuestion extends QuestionModel {
    private int min;
    private int max;
    private int num;

    @ElementCollection
    private Map<String, Integer> responseMap;

    public NumberRangeQuestion() {
        super();
        this.min = 0;
        this.max = 10;
        this.num = 0;
        this.responseMap = new HashMap<>();
    }

    public NumberRangeQuestion(String name, SurveyModel survey, int min, int max) {
        super();
        this.min = min;
        this.max = max;
        this.num = 0;
        this.responseMap = new HashMap<>();
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

    public void addResponse(NumberRangeAnswer response) {
        super.getResponses().add(response);
    }

    public Map<String, Integer> getResponseMap() {
        return responseMap;
    }

    public void setResponseMap(Map<String, Integer> responseMap) {
        this.responseMap = responseMap;
    }

    public Object[][] convertTo2DArray() {
        Object[][] newArr = new Object[responseMap.size()][2];
        int i = 0;
        for (Map.Entry<String, Integer> entry : responseMap.entrySet()) {
            newArr[i][0] = entry.getKey();
            newArr[i][1] = entry.getValue();
            i++;
        }
        return newArr;
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
