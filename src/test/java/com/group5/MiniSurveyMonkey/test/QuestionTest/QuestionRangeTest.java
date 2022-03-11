package com.group5.MiniSurveyMonkey.test.QuestionTest;

import com.group5.MiniSurveyMonkey.Question.NumberRangeQuestion;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionRangeTest {

    public NumberRangeQuestion rangeQuestion;

    @Test
    public void TestAddGetQuestion(){
        rangeQuestion = new NumberRangeQuestion(1, 10, 5);
        assertEquals(rangeQuestion.getMin(),1);
        assertEquals(rangeQuestion.getMax(),10);
        assertEquals(rangeQuestion.getNum(),5);

        NumberRangeQuestion rangeQuestionTwo = new NumberRangeQuestion();
        rangeQuestionTwo.setMax(5);
        rangeQuestionTwo.setMin(1);
        rangeQuestionTwo.setNum(2);
        assertEquals(rangeQuestionTwo.getMin(),1);
        assertEquals(rangeQuestionTwo.getMax(),5);
        assertEquals(rangeQuestionTwo.getNum(),2);

    }
}
