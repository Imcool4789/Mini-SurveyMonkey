package com.group5.MiniSurveyMonkey.Survey;

import com.group5.MiniSurveyMonkey.Answer.AnswerModel;
import com.group5.MiniSurveyMonkey.Question.QuestionModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Entity
public class SurveyModel
{
    private final AtomicLong counter = new AtomicLong();

    @Id
    private long id;
    private String name;
    private int responseCount;
    private boolean isClosed;
    @Column(length = 10000000)
    private ArrayList<QuestionModel> surveyQuestions;

    public ArrayList<AnswerModel> getSurveyAnswers() {
        return surveyAnswers;
    }

    public void setSurveyAnswers(ArrayList<AnswerModel> surveyAnswers) {
        this.surveyAnswers = surveyAnswers;
    }

    @Column(length = 10000000)
    private ArrayList<AnswerModel> surveyAnswers;

    public SurveyModel()
    {
        this.id = 1;
        this.name = "Survey 1";
        this.responseCount = 0;
        surveyQuestions = new ArrayList<>();
        surveyAnswers = new ArrayList<>();
        isClosed = false;
    }

    public SurveyModel(String name)
    {
        this.id = 1;
        this.name = name;
        this.responseCount = 0;
        surveyQuestions = new ArrayList<>();
        isClosed = false;
    }

    public void addQuestion(QuestionModel newQuestion)
    {
        if(newQuestion != null)
        {
            newQuestion.setId(counter.incrementAndGet());
            surveyQuestions.add(newQuestion);
        }
    }

    public void addAnswer(AnswerModel answer){
        if(answer != null)
        {
            answer.setId(counter.incrementAndGet());
            surveyAnswers.add(answer);
        }
    }



    public void removeQuestion(int index)
    {
        if(index >= 0 && index < surveyQuestions.size())
        {
            surveyQuestions.remove(index);
        }
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

    public int getResponseCount() {
        return responseCount;
    }

    public void setResponseCount(int responseCount) {
        this.responseCount = responseCount;
    }

    public ArrayList<QuestionModel> getSurveyQuestions() {
        return surveyQuestions;
    }

    public boolean isClosed(){
        return isClosed;
    }

    public void setClosed(boolean isClosed){
        this.isClosed = isClosed;
    }

    @Override
    public String toString() {
        return "SurveyModel{" +
                "counter=" + counter +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", responseCount=" + responseCount +
                ", surveyQuestions=" + surveyQuestions +
                '}';
    }
}
