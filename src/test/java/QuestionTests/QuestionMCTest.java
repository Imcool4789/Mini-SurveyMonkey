package QuestionTests;

import Question.MCQuestion;
import Question.QuestionModel;
import Question.QuestionType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
