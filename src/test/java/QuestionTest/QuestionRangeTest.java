package QuestionTest;

import Question.MCQuestion;
import Question.NumberRangeQuestion;
import Question.OpenQuestion;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
