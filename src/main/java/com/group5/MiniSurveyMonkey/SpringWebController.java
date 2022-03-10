package com.group5.MiniSurveyMonkey;

import com.group5.MiniSurveyMonkey.Login.LocalUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class SpringWebController
{
    @GetMapping("/")
    public String returnIndex(Model model)
    {
        model.addAttribute("localUser", new LocalUser());
        return "index";
    }
}

