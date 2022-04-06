package com.group5.MiniSurveyMonkey.Answer;

import com.group5.MiniSurveyMonkey.Question.QuestionModel;
import com.group5.MiniSurveyMonkey.Survey.SurveyModel;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;

@Document("AnswerModel")
@Entity(name = "Answer")
@Table(name = "answer")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType = DiscriminatorType.STRING)
public class AnswerModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String answer;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private QuestionModel question;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private SurveyModel survey;

    public AnswerModel(){
        this.id = 1;
        this.answer = "";
    }

    public AnswerModel(String answer) {
        this.id = 1;
        this.answer = answer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setQuestion(QuestionModel question) {
        this.question = question;
    }

    public QuestionModel getQuestion(){
        return question;
    }

    public SurveyModel getSurvey() {
        return survey;
    }

    public void setSurvey(SurveyModel survey) {
        this.survey = survey;
    }

    @Override
    public String toString() {
        return "AnswerModel{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
                '}';
    }
}
