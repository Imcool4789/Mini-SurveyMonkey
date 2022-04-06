package com.group5.MiniSurveyMonkey.test.AnswerTest;

import com.group5.MiniSurveyMonkey.Answer.AnswerController;
import com.group5.MiniSurveyMonkey.Answer.AnswerRepository;
import com.group5.MiniSurveyMonkey.Answer.ResultsController;
import com.group5.MiniSurveyMonkey.Login.LoginController;
import com.group5.MiniSurveyMonkey.Login.SurveyorController;
import com.group5.MiniSurveyMonkey.Login.UserRepository;
import com.group5.MiniSurveyMonkey.Question.QuestionController;
import com.group5.MiniSurveyMonkey.Question.QuestionRepository;
import com.group5.MiniSurveyMonkey.Survey.SurveyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {LoginController.class, SurveyorController.class, QuestionController.class, AnswerController.class, ResultsController.class,})
@AutoConfigureMockMvc
public class ResultControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionRepository questionRepository;

    @MockBean
    private SurveyRepository surveyRepository;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private AnswerRepository answerRepository;

    @Test
    public void testRangeResultsPage() throws Exception {
        mockMvc.perform(post("/")
                        .param("user", "surveyor")
                        .param("password", "surveyor"))
                .andDo(print()).andExpect(status().isOk());

        mockMvc.perform(post("/surveyorIndex/createQuestion")
                        .param("name", "Question")
                        .param("type", "NumberRangeQuestion")
                        .param("mc1", "")
                        .param("mc2", "")
                        .param("mc3", "")
                        .param("mc4", "")
                        .param("min", "0")
                        .param("max", "10"))
                .andDo(print()).andExpect(status().isFound());
        mockMvc.perform(get("/surveyorIndex/Result")).andDo(print()).andExpect(status().isOk());

    }

}
