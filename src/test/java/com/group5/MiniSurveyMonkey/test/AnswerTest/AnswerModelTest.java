package com.group5.MiniSurveyMonkey.test.AnswerTest;

import com.group5.MiniSurveyMonkey.Answer.AnswerModel;
import com.group5.MiniSurveyMonkey.Question.QuestionModel;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnswerModelTest {

    private AnswerModel a;

    @Test
    public void testId(){
        a = new AnswerModel();
        a.setId(1);
        assertEquals(a.getId(), 1);
    }

    @Test
    public void TestAnswerSet(){
        a = new AnswerModel();
        a.setAnswer("Answer1");
        assertEquals(a.getAnswer(),"Answer1");
    }

    @Test
    public void TestQuestionSet(){
        a = new AnswerModel();
        QuestionModel q = new QuestionModel();
        q.setId(1);
        q.setName("Test1");
       // q.setType(QuestionType.MC);

        a.setQuestion(q);

        assertEquals(a.getQuestion().getId(), 1);
        assertEquals(a.getQuestion().getName(), "Test1");
        //assertEquals(a.getQuestion().getType(), QuestionType.MC);
    }
}
