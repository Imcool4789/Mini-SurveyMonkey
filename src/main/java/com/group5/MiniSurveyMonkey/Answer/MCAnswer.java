package com.group5.MiniSurveyMonkey.Answer;

import com.group5.MiniSurveyMonkey.Question.MCQuestion;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Map;

@Entity
@DiscriminatorValue("MCAnswer")
public class MCAnswer extends AnswerModel {

    private String answer;

    public MCAnswer() {
        super();
        answer = "";
    }

    public MCAnswer(String answer, MCQuestion question) {
        super();
        this.answer = answer;
        super.setSurvey(question.getSurvey());
        super.setQuestion(question);
        updateResponses(answer, question);
        question.addResponse(this);
        updateResponses(answer, question);
    }

    public void updateResponses(String answer, MCQuestion question) {
        Map<String, Integer> questionResponses = question.getResponseMap();
        questionResponses.put(answer, questionResponses.getOrDefault(answer, 0) + 1);
    }

}
