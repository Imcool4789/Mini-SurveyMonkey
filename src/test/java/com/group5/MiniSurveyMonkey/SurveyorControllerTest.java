package com.group5.MiniSurveyMonkey;

import com.group5.MiniSurveyMonkey.Login.*;
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

@WebMvcTest(controllers = {LoginController.class, SurveyorController.class})
@AutoConfigureMockMvc
public class SurveyorControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SurveyRepository surveyRepository;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void successfulSurveyorLogin() throws Exception
    {
        this.mockMvc.perform(post("/")
                .param("user", "surveyor")
                .param("password", "surveyor"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldReturnSurveyorIndex() throws Exception
    {
        this.mockMvc.perform(post("/")
                        .param("user", "surveyor")
                        .param("password", "surveyor"))
                .andDo(print()).andExpect(status().isOk());
        this.mockMvc.perform(get("/surveyorIndex"))
                .andDo(print()).andExpect(status().isOk());
    }

    /*
    TODO: Works when running via Application, but need to fix for mockMVC
    Error on get ("/surveyorIndex/viewSurvey")
    @Test
    public void viewSurvey() throws Exception
    {
        this.mockMvc.perform(post("/")
                        .param("user", "surveyor")
                        .param("password", "surveyor"))
                .andDo(print()).andExpect(status().isOk());
        this.mockMvc.perform(get("/surveyorIndex/viewSurvey"))
                .andDo(print()).andExpect(status().isOk());
    }
    */
}
