package com.group5.MiniSurveyMonkey.test.AnswerTest;

import com.group5.MiniSurveyMonkey.Answer.NumberRangeAnswer;
import com.group5.MiniSurveyMonkey.Question.NumberRangeQuestion;
import com.group5.MiniSurveyMonkey.Survey.SurveyModel;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ResultModelTest {
    @Test
    public void numberRangeSurveyResults() {
        SurveyModel surveyModel = new SurveyModel();
        NumberRangeQuestion question = new NumberRangeQuestion("Test Number", surveyModel, 0, 10);
        Map<String, Integer> responseMap = question.getResponseMap();
        assertFalse(responseMap.containsKey("1"));
        NumberRangeAnswer ans1 = new NumberRangeAnswer(1, question);
        NumberRangeAnswer ans2 = new NumberRangeAnswer(1, question);
        NumberRangeAnswer ans3 = new NumberRangeAnswer(1, question);
        NumberRangeAnswer ans4 = new NumberRangeAnswer(1, question);
        assertTrue(responseMap.containsKey("1"));
    }
}
