package com.group5.MiniSurveyMonkey.Question;

import com.group5.MiniSurveyMonkey.Answer.AnswerModel;
import com.group5.MiniSurveyMonkey.Survey.SurveyModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Question")
@Table(name="question")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType = DiscriminatorType.STRING)
public class QuestionModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private SurveyModel survey;

    @OneToMany(mappedBy = "question", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<AnswerModel> responses;

    public QuestionModel()
    {
        this.id = 1;
        responses = new ArrayList<>();
    }

    public QuestionModel(String name)
    {
        this.id = 1;
        this.name = name;
        responses = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SurveyModel getSurvey() {
        return survey;
    }

    public void setSurvey(SurveyModel survey) {
        this.survey = survey;
    }

    public List<AnswerModel> getResponses() {
        return responses;
    }

    public void setResponses(List<AnswerModel> responses) {
        this.responses = responses;
    }

    @Override
    public String toString() {
        return "QuestionModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
