package com.group5.MiniSurveyMonkey.Answer;

import com.sun.org.apache.xpath.internal.operations.Bool;

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
        this.quest = quest;
        this.ans = ans;
    }

    public void setAns(){
        map.put(quest,ans);
    }

    public Boolean getAns(){
        return ans;
    }


}
