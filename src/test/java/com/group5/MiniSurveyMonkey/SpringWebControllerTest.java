package com.group5.MiniSurveyMonkey;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = SpringWebController.class)
@AutoConfigureMockMvc
public class SpringWebControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnIndex() throws Exception
    {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
    }
}
