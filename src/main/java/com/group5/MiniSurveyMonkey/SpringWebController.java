package com.group5.MiniSurveyMonkey;

import com.group5.MiniSurveyMonkey.Login.LocalUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringWebController
{
    @RequestMapping ("/")
    public String returnIndex(@ModelAttribute("localUser") LocalUser user, Model model)
    {
        return "index";
    }
}
