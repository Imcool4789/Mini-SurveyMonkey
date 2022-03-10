package com.group5.MiniSurveyMonkey.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController
{
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/")
    public String localLogin(LocalUser user)
    {
        if (user.login())
        {
            userRepository.save(user);
            String redirectURL = user.getAccessType() + "Index";
            return redirectURL;
        }
        return "index";
    }
}
