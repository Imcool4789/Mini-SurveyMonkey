package com.group5.MiniSurveyMonkey.QuestionTest;

import com.group5.MiniSurveyMonkey.Question.MCQuestion;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionMCTest {

    MCQuestion mc;

    @Test
    public void TestAddGetQuestion(){
        mc = new MCQuestion();
        List<String> lst = new ArrayList<>();
        lst.add("Q1");
        mc.setOpt(lst);
        assertEquals(mc.getOpt().get(0),"Q1");
    }
}