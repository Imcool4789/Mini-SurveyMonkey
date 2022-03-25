package com.group5.MiniSurveyMonkey.Answer;



import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class MCAnswer extends AnswerModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ElementCollection
    private Map<String, Boolean> map;

    private String quest;
    private Boolean ans;

    public MCAnswer(){
        map = new HashMap<String, Boolean>();
        quest = "";
        ans = false;
    }

    public MCAnswer(String quest, Boolean ans){
        map = new HashMap<String, Boolean>();
        this.quest = quest;
        this.ans = ans;
        map.put(quest,ans);
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
