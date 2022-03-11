package com.group5.MiniSurveyMonkey.Question;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class QuestionModel {
    @Id
    private long id;
    private String type;
    private String name;

    public QuestionModel(){

    }

    public QuestionModel(long id, String type, String name) {
        this.id = id;
        this.type = type;
        this.name = name;
    }

    public QuestionModel(String type, String name){
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "QuestionModel{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
