package com.group5.MiniSurveyMonkey.test.SurveyTest;

import com.group5.MiniSurveyMonkey.Survey.SurveyModel;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SurveyAnswerCreationTest {

    @Test
    public void TestAddAnswer(){
        SurveyModel s = new SurveyModel();
        //QuestionModel q = new QuestionModel("MC", "Test Question");
        //AnswerModel a = new AnswerModel(1L,"test", q);

       // s.addQuestion(q);
       // s.addAnswer(a);

        assertEquals(s.getSurveyAnswers().get(0).getAnswer(), "test");
    }
}
