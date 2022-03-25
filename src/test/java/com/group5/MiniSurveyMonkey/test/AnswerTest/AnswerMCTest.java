package com.group5.MiniSurveyMonkey.test.AnswerTest;

import com.group5.MiniSurveyMonkey.Answer.MCAnswer;
import com.group5.MiniSurveyMonkey.Answer.OpenAnswer;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnswerMCTest {

    @Test
    public void TestConstructor(){
        MCAnswer mc = new MCAnswer("option1",false);
        assertEquals(mc.getAns(),false);
    }

    @Test
    public void TestSet(){
        MCAnswer mc = new MCAnswer();
        mc.setAns("option1", true);
        assertEquals(mc.getQuestAns().containsValue(true),true);
    }
}
