package com.group5.MiniSurveyMonkey.test.SurveyTest;

import com.group5.MiniSurveyMonkey.Answer.AnswerModel;
import com.group5.MiniSurveyMonkey.Question.QuestionModel;
import com.group5.MiniSurveyMonkey.Survey.SurveyModel;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SurveyAnswerCreationTest {

    @Test
    public void TestAddAnswer() {
        SurveyModel s = new SurveyModel();
        QuestionModel q = new QuestionModel("Test");
        AnswerModel a = new AnswerModel("Answer1");

        s.addQuestion(q);
        s.addAnswer(a);

        assertEquals(s.getSurveyAnswers().get(0).getAnswer(), "Answer1");
    }
}
