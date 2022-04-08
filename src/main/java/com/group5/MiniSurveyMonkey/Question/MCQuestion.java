package com.group5.MiniSurveyMonkey.Question;

import com.group5.MiniSurveyMonkey.Answer.MCAnswer;
import com.group5.MiniSurveyMonkey.Survey.SurveyModel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.LinkedHashMap;
import java.util.Map;

@Entity
@DiscriminatorValue("MCQuestion")
public class MCQuestion extends QuestionModel {

    @ElementCollection
    private Map<String, Integer> responseMap;

    private String mc1;
    private String mc2;
    private String mc3;
    private String mc4;

    public MCQuestion() {
        super();
        responseMap = new LinkedHashMap<>();
    }

    public MCQuestion(String name, SurveyModel survey) {
        super();
        super.setName(name);
        super.setSurvey(survey);
        survey.addQuestion(this);
        responseMap = new LinkedHashMap<>();

    }

    public String getMc1() {
        return mc1;
    }

    public void setMc1(String mc1) {
        this.mc1 = mc1;
    }

    public String getMc2() {
        return mc2;
    }

    public void setMc2(String mc2) {
        this.mc2 = mc2;
    }

    public String getMc3() {
        return mc3;
    }

    public void setMc3(String mc3) {
        this.mc3 = mc3;
    }

    public String getMc4() {
        return mc4;
    }

    public void setMc4(String mc4) {
        this.mc4 = mc4;
    }

    public void addResponse(MCAnswer response) {
        super.getResponses().add(response);
    }

    public void addOpt() {
        responseMap.put(mc1, 0);
        responseMap.put(mc2, 0);
        responseMap.put(mc3, 0);
        responseMap.put(mc4, 0);
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
        return "MCQuestion{" +
                "mc1='" + mc1 + '\'' +
                ", mc2='" + mc2 + '\'' +
                ", mc3='" + mc3 + '\'' +
                ", mc4='" + mc4 + '\'' +
                '}';
    }
}
