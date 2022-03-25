package com.group5.MiniSurveyMonkey.Question;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OpenQuestion extends QuestionModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ElementCollection
    private List<String> responses;

    public OpenQuestion (){
        this.responses = new ArrayList<>();
    }

    public List<String> getResponses(){
        return responses;
    }

    public void setResponses(ArrayList<String> responses){
        this.responses = responses;
    }

    public void addResponse (String response){
        responses.add(response);
    }

    @Override
    public String toString() {
        return "OpenEndedQuestion{" +
                "responses=" + responses +
                '}';
    }
}
