package com.group5.MiniSurveyMonkey.Answer;

import com.group5.MiniSurveyMonkey.Question.OpenQuestion;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Map;

@Entity
@DiscriminatorValue("OpenAnswer")
public class OpenAnswer extends AnswerModel {


    private String answer;

    public OpenAnswer() {
        super();
        answer = answer;
    }

    public OpenAnswer(String answer, OpenQuestion question) {
        super();
        this.answer = answer;
        super.setQuestion(question);
        this.updateResponses(answer, question);
        question.addResponse(this);
        //super.setAnswer(answer);
    }

    @Override
    public String getAnswer() {
        return answer;
    }

    @Override
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void updateResponses(String answer, OpenQuestion question) {
        int index = question.getResponses().indexOf(this);
        Map<Integer, String> questionResponses = question.getResponseMap();
        questionResponses.put(index + 1, answer);
    }
}
