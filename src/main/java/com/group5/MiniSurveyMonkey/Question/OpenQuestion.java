package com.group5.MiniSurveyMonkey.Question;

import com.group5.MiniSurveyMonkey.Answer.OpenAnswer;
import com.group5.MiniSurveyMonkey.Survey.SurveyModel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.LinkedHashMap;
import java.util.Map;

@Entity
@DiscriminatorValue("OpenQuestion")
public class OpenQuestion extends QuestionModel {
    @ElementCollection
    private Map<Integer, String> responseMap;

    public OpenQuestion() {
        super();
        responseMap = new LinkedHashMap<>();
    }

    public OpenQuestion(String name, SurveyModel survey) {
        super();
        super.setName(name);
        super.setSurvey(survey);
        survey.addQuestion(this);
        responseMap = new LinkedHashMap<>();
    }

    public Map<Integer, String> getResponseMap() {
        return responseMap;
    }

    public void setResponseMap(Map<Integer, String> responseMap) {
        this.responseMap = responseMap;
    }

    public void addResponse(OpenAnswer response) {
        super.getResponses().add(response);
    }

    public Object[][] convertTo2DArray() {
        Object[][] newArr = new Object[responseMap.size()][2];
        int i = 0;
        for (Map.Entry<Integer, String> entry : responseMap.entrySet()) {
            newArr[i][0] = entry.getKey();
            newArr[i][1] = entry.getValue();
            i++;
        }
        return newArr;
    }

    @Override
    public String toString() {
        return "OpenEndedQuestion{" +
                "responses=" + super.getResponses() +
                '}';
    }
}
