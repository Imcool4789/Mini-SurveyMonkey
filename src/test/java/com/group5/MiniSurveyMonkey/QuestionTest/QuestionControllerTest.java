package com.group5.MiniSurveyMonkey.QuestionTest;

import com.group5.MiniSurveyMonkey.Question.QuestionController;
import com.group5.MiniSurveyMonkey.Question.QuestionRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(QuestionController.class)
@AutoConfigureMockMvc
public class QuestionControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private QuestionRepository rep;

    @Test
    public void TestQuestion() throws Exception {
        //  mvc = MockMvcBuilders.standaloneSetup(new QuestionController(rep)).build();
        // List<QuestionModel> test = new ArrayList<>();
        // when(rep.findAll()).thenReturn(test);
        //   mvc.perform(get("/questions")).andDo(print()).andExpect(status().isOk());
    }
}
