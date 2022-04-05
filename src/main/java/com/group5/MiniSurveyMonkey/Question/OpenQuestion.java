package com.group5.MiniSurveyMonkey.Question;

import com.group5.MiniSurveyMonkey.Answer.OpenAnswer;
import com.group5.MiniSurveyMonkey.Survey.SurveyModel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("OpenQuestion")
public class OpenQuestion extends QuestionModel {

    public OpenQuestion() {
        super();
    }

    public OpenQuestion(String name, SurveyModel survey) {
        super();
        super.setName(name);
        super.setSurvey(survey);
    }

    public void addResponse(OpenAnswer response) {
        super.getResponses().add(response);
    }

    @Override
    public String toString() {
        return "OpenEndedQuestion{" +
                "responses=" + super.getResponses() +
                '}';
    }
}
