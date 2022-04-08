package com.group5.MiniSurveyMonkey.test.AnswerTest;

import com.group5.MiniSurveyMonkey.Answer.MCAnswer;
import com.group5.MiniSurveyMonkey.Question.MCQuestion;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AnswerMCTest {
    private MCAnswer mc;

    @Test
    public void TestSetAnswer() {
        MCQuestion mcQ = new MCQuestion();
        mcQ.setMc1("Q1");
        mcQ.setMc2("Q2");
        mcQ.setMc3("Q3");
        mcQ.setMc4("Q4");
        mc = new MCAnswer("option1",mcQ);
        mc.setAnswer("Q2");

        assertEquals("Q2", mc.getAnswer());
    }
}
