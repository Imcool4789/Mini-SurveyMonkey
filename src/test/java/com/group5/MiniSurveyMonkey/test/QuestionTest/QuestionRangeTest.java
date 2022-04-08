package com.group5.MiniSurveyMonkey.test.QuestionTest;

import com.group5.MiniSurveyMonkey.Question.NumberRangeQuestion;
import com.group5.MiniSurveyMonkey.Survey.SurveyModel;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionRangeTest {

    @Test
    public void TestAddGetQuestion() {
        SurveyModel surveyModel = new SurveyModel();
        NumberRangeQuestion rangeQuestion = new NumberRangeQuestion("qr", surveyModel, 1, 10);
        assertEquals(rangeQuestion.getMin(), 1);
        assertEquals(rangeQuestion.getMax(), 10);
        assertEquals(rangeQuestion.getNum(), 0);

        NumberRangeQuestion rangeQuestionTwo = new NumberRangeQuestion("q2", surveyModel, 1, 10);
        rangeQuestionTwo.setMax(5);
        rangeQuestionTwo.setMin(1);
        rangeQuestionTwo.setNum(2);
        assertEquals(rangeQuestionTwo.getMin(), 1);
        assertEquals(rangeQuestionTwo.getMax(), 5);
        assertEquals(rangeQuestionTwo.getNum(), 2);

    }
}
