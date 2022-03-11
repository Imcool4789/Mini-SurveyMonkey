package com.group5.MiniSurveyMonkey.AnswerTest;

import com.group5.MiniSurveyMonkey.Answer.AnswerController;
import com.group5.MiniSurveyMonkey.Answer.AnswerRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@WebMvcTest(AnswerControllerTest.class)
@AutoConfigureMockMvc
public class AnswerControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AnswerRepository rep;

    @Test
    public void TestCreateMockMVC(){
        mvc = MockMvcBuilders.standaloneSetup(new AnswerController(rep)).build();
        assertNotNull(mvc);
    }
}
