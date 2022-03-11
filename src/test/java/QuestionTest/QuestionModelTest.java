package QuestionTest;

import com.group5.MiniSurveyMonkey.Question.QuestionModel;
import com.group5.MiniSurveyMonkey.Question.QuestionType;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuestionModelTest {

    private QuestionModel q;

    @Test
    public void TestId(){
        q = new QuestionModel();
        q.setId(1);
        assertEquals(q.getId(),1);
    }

    @Test
    public void TestType(){
        q = new QuestionModel();
        q.setType(QuestionType.MC);
        assertEquals(q.getType(),"Multiple Choice");
    }

    @Test
    public void TestName(){
        q = new QuestionModel();
        q.setName("com.group5.MiniSurveyMonkey.Question 1");
        assertEquals(q.getName(),"com.group5.MiniSurveyMonkey.Question 1");
    }

    @Test
    public void TestConstructor(){
        q = new QuestionModel(1, QuestionType.MC,"Q1");
        assertEquals(q.getId(),1);
        assertEquals(q.getType(),"Multiple Choice");
        assertEquals(q.getName(),"Q1");
    }
}
