package QuestionTests;
import Question.QuestionController;
import Question.QuestionModel;
import Question.QuestionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;


import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(controllers = QuestionController.class)
//@WebMvcTest(QuestionController.class)
@AutoConfigureMockMvc
public class QuestionControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private QuestionRepository rep;

    @Test
    public void TestCreateMockMVC(){
        mvc = MockMvcBuilders.standaloneSetup(new QuestionController(rep)).build();
        assertNotNull(mvc);
    }

    @Test
    public void TestQuestion() throws Exception {
       mvc = MockMvcBuilders.standaloneSetup(new QuestionController(rep)).build();
       // List<QuestionModel> test = new ArrayList<>();
       // when(rep.findAll()).thenReturn(test);
        mvc.perform(get("/questions")).andDo(print()).andExpect(status().isOk());
    }
}
