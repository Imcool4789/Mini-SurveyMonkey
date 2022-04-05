package com.group5.MiniSurveyMonkey.test.AnswerTest;

import com.group5.MiniSurveyMonkey.Answer.NumberRangeAnswer;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnswerNumberRangeTest {

    @Test
    public void testingAnswerCreation() {
        NumberRangeAnswer numberRangeAnswer = new NumberRangeAnswer();
        assertEquals(numberRangeAnswer.getNum(), 1);

        NumberRangeAnswer numberRangeAnswer2 = new NumberRangeAnswer(22);
        assertEquals(numberRangeAnswer2.getNum(), 22);
    }

    @Test
    public void testAnswerEdit() {
        NumberRangeAnswer numberRangeAnswer = new NumberRangeAnswer();
        assertEquals(numberRangeAnswer.getNum(), 1);

        numberRangeAnswer.setNum(22);
        assertEquals(numberRangeAnswer.getNum(), 22);
    }
}