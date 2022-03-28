package com.group5.MiniSurveyMonkey.test.SurveyTest;

import com.group5.MiniSurveyMonkey.Question.MCQuestion;
import com.group5.MiniSurveyMonkey.Survey.SurveyModel;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SurveyModelTest {

    @Test
    public void TestConstructor(){
        SurveyModel surveyModel = new SurveyModel("Survey1");
        assertEquals(surveyModel.getName(), "Survey1");
        assertEquals(surveyModel.getId(), 1);
        assertEquals(surveyModel.getResponseCount(), 0);

        SurveyModel surveyModelTwo = new SurveyModel();
        assertEquals(surveyModelTwo.getName(), "Survey 1");
        assertEquals(surveyModelTwo.getId(), 1);
        assertEquals(surveyModelTwo.getResponseCount(), 0);
    }

    @Test
    public void TestAddRemoveQuestion(){
        SurveyModel surveyModel = new SurveyModel("Survey1");
      //  QuestionModel question = new QuestionModel(QuestionType.RANGE, "Question1");
      //  surveyModel.addQuestion(question);
        //assertEquals(surveyModel.getSurveyQuestions().get(0), question);

        MCQuestion question2 = new MCQuestion();
        surveyModel.addQuestion(question2);
        surveyModel.removeQuestion(0);
        assertEquals(surveyModel.getSurveyQuestions().get(0), question2);
    }

    @Test
    public void TestId(){
        SurveyModel surveyModel = new SurveyModel("Survey1");
        assertEquals(surveyModel.getId(), 1);
        surveyModel.setId(2);
        assertEquals(surveyModel.getId(), 2);
    }

    @Test
    public void TestName(){
        SurveyModel surveyModel = new SurveyModel("Survey1");
        assertEquals(surveyModel.getName(), "Survey1");
        surveyModel.setName("Survey2");
        assertEquals(surveyModel.getName(), "Survey2");
    }

    @Test
    public void TestResponseCount(){
        SurveyModel surveyModel = new SurveyModel("Survey1");
        assertEquals(surveyModel.getResponseCount(), 0);
        surveyModel.setResponseCount(30);
        assertEquals(surveyModel.getResponseCount(), 30);
    }

}
