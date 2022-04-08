package com.group5.MiniSurveyMonkey.test.LoginTest;

import com.group5.MiniSurveyMonkey.Login.DBUserDetailsService;
import com.group5.MiniSurveyMonkey.Login.LoginController;
import com.group5.MiniSurveyMonkey.Login.UserController;
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

@WebMvcTest(controllers = {SpringWebController.class, LoginController.class, UserController.class})
@AutoConfigureMockMvc
public class UserControllerTest {
    @MockBean
    DBUserDetailsService dbUserDetailsService;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SurveyRepository surveyRepository;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void successfulUserLogin() throws Exception {
        mockMvc.perform(post("/login")
                        .param("user", "user")
                        .param("password", "user"))
                .andDo(print()).andExpect(status().isFound());
    }

    @Test
    public void shouldReturnUserIndex() throws Exception {
        mockMvc.perform(post("/login")
                        .param("user", "user")
                        .param("password", "user"))
                .andDo(print()).andExpect(status().isFound());

        mockMvc.perform(get("/userIndex"))
                .andDo(print()).andExpect(status().isFound());
    }

    @Test
    public void viewSurveyAsUser() throws Exception {
        mockMvc.perform(post("/login")
                        .param("user", "user")
                        .param("password", "user"))
                .andDo(print()).andExpect(status().isFound());

        mockMvc.perform(get("/userIndex/viewSurvey"))
                .andDo(print()).andExpect(status().isFound());
    }
}
