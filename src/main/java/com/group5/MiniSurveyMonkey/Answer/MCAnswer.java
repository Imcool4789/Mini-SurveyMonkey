package com.group5.MiniSurveyMonkey.Answer;

import com.group5.MiniSurveyMonkey.Question.QuestionModel;
import com.group5.MiniSurveyMonkey.Survey.SurveyModel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.HashMap;
import java.util.Map;

@Entity
@DiscriminatorValue("MCAnswer")
public class MCAnswer extends AnswerModel{
    @ElementCollection
    private Map<String, Boolean> map;

    private String quest;
    private Boolean ans;

    public MCAnswer(){
        super();
        map = new HashMap<String, Boolean>();
        quest = "";
        ans = false;
    }

    public MCAnswer(String quest, Boolean ans, SurveyModel survey, QuestionModel question){
        super();
        map = new HashMap<String, Boolean>();
        this.quest = quest;
        this.ans = ans;
        map.put(quest,ans);
        super.setSurvey(survey);
        super.setQuestion(question);
    }

    public void setAns(String quest, Boolean ans){
        map.put(quest,ans);
    }

    public Boolean getAns(){
        return ans;
    }

    public Map<String, Boolean> getQuestAns(){
        return map;
    }


}
