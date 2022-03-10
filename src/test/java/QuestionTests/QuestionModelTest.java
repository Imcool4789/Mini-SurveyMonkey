package QuestionTests;
import Question.QuestionModel;
import Question.QuestionType;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuestionModelTest {

    private QuestionModel q;

    @Test
    public void testId(){
        q = new QuestionModel();
        q.setId(1);
        assertEquals(q.getId(),1);
    }

    @Test
    public void testType(){
        q = new QuestionModel();
        q.setType(QuestionType.MC);
        assertEquals(q.getType(),"Multiple Choice");
    }

    @Test
    public void testName(){
        q = new QuestionModel();
        q.setName("Question 1");
        assertEquals(q.getName(),"Question 1");
    }

    @Test
    public void testConstructor(){
        q = new QuestionModel(1, QuestionType.MC,"Q1");
        assertEquals(q.getId(),1);
        assertEquals(q.getType(),"Multiple Choice");
        assertEquals(q.getName(),"Q1");
    }
}
