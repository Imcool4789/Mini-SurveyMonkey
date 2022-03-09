package com.group5.MiniSurveyMonkey.Login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController
{
    @PostMapping("/")
    public String localLogin(@ModelAttribute("localUser") LocalUser user, Model model)
    {
        if (user.login())
        {
            String redirectURL = user.getAccessType() + "Index";
            return redirectURL;
        }
        return "index";
    }
}
