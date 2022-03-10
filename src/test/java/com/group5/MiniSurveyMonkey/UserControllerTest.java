package com.group5.MiniSurveyMonkey;

import com.group5.MiniSurveyMonkey.Login.LocalUser;
import com.group5.MiniSurveyMonkey.Login.LoginController;
import com.group5.MiniSurveyMonkey.Login.UserController;
import com.group5.MiniSurveyMonkey.Login.UserRepository;
import com.group5.MiniSurveyMonkey.Survey.SurveyModel;
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

@WebMvcTest(controllers = {LoginController.class, UserController.class})
@AutoConfigureMockMvc
public class UserControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SurveyRepository surveyRepository;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void successfulUserLogin() throws Exception
    {
        this.mockMvc.perform(post("/")
                        .param("user", "user1")
                        .param("password", "password"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldReturnUserIndex() throws Exception
    {
        this.mockMvc.perform(post("/")
                        .param("user", "user1")
                        .param("password", "password"))
                .andDo(print()).andExpect(status().isOk());
        this.mockMvc.perform(get("/userIndex"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void viewSurveyAsUser() throws Exception
    {
        this.mockMvc.perform(post("/")
                        .param("user", "user1")
                        .param("password", "password"))
                .andDo(print()).andExpect(status().isOk());
        this.mockMvc.perform(get("/userIndex/viewSurvey"))
                .andDo(print()).andExpect(status().isOk());
    }
}
