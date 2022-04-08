package com.group5.MiniSurveyMonkey.test.LoginTest;

import com.group5.MiniSurveyMonkey.Login.DBUserDetailsService;
import com.group5.MiniSurveyMonkey.Login.LoginController;
import com.group5.MiniSurveyMonkey.Login.SurveyorController;
import com.group5.MiniSurveyMonkey.Login.UserRepository;
import com.group5.MiniSurveyMonkey.SpringWebController;
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

@WebMvcTest(controllers = {SpringWebController.class, LoginController.class, SurveyorController.class})
@AutoConfigureMockMvc
public class SurveyorControllerTest {
    @MockBean
    DBUserDetailsService dbUserDetailsService;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SurveyRepository surveyRepository;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void successfulSurveyorLogin() throws Exception {
        mockMvc.perform(post("/login")
                        .param("user", "surveyor")
                        .param("password", "surveyor"))
                .andDo(print()).andExpect(status().isFound());
    }

    @Test
    public void shouldReturnSurveyorIndex() throws Exception {
        mockMvc.perform(post("/login")
                        .param("user", "surveyor")
                        .param("password", "surveyor"))
                .andDo(print()).andExpect(status().isFound());

        mockMvc.perform(get("/surveyorIndex"))
                .andDo(print()).andExpect(status().isFound());
    }

    @Test
    public void viewSurveyAsSurveyor() throws Exception {
        mockMvc.perform(post("/login")
                        .param("user", "surveyor")
                        .param("password", "surveyor"))
                .andDo(print()).andExpect(status().isFound());

        mockMvc.perform(get("/surveyorIndex/viewSurvey"))
                .andDo(print()).andExpect(status().isFound());
    }
}
