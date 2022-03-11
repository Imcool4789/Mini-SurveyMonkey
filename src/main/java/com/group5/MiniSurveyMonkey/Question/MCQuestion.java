package com.group5.MiniSurveyMonkey.Question;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MCQuestion extends QuestionModel{

    @ElementCollection
    private List<String> opt = new ArrayList<>();

    public MCQuestion() {
        setType(QuestionType.MC);
    }

    public void setOpt(List<String> opt){
        this.opt = opt;
    }

    public List<String> getOpt(){
        return opt;
    }

    @Override
    public String toString() {
        return "MCQuestion{" +
                "options=" + opt +
                '}';
    }
}
