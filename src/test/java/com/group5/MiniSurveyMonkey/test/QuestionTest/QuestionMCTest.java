package com.group5.MiniSurveyMonkey.test.QuestionTest;

import com.group5.MiniSurveyMonkey.Question.MCQuestion;
import com.group5.MiniSurveyMonkey.Survey.SurveyModel;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class QuestionMCTest {

    MCQuestion mc;

    @Test
    public void TestAddGetQuestion() {
        mc = new MCQuestion();
        mc.setMc1("Q1");
        mc.setMc2("Q2");
        mc.setMc3("Q3");
        mc.setMc4("Q4");

        assertEquals("Q1", mc.getMc1());
        assertEquals("Q2", mc.getMc2());
        assertEquals("Q3", mc.getMc3());
        assertEquals("Q4", mc.getMc4());
    }

    @Test
    public void TestSurveyAdd() {
        String name = "Qustion1";
        SurveyModel surveyModel = new SurveyModel();
        surveyModel.setName("survey1");

        mc = new MCQuestion();
        mc.setMc1("Q1");
        mc.setMc2("Q2");
        mc.setMc3("Q3");
        mc.setMc4("Q4");

        surveyModel.addQuestion(mc);


        assertEquals("MCQuestion{mc1='Q1', mc2='Q2', mc3='Q3', mc4='Q4'}", surveyModel.getQuestion(0).toString());

    }
}