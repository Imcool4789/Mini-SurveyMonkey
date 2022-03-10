package com.group5.MiniSurveyMonkey.Login;

import com.group5.MiniSurveyMonkey.Survey.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController
{
    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/")
    public String localLogin(@ModelAttribute("localUser") LocalUser user, Model model)
    {
        if (user.login())
        {
            userRepository.save(user);
            model.addAttribute("localUser", user);
            String redirectURL = user.getAccessType() + "Index";
            return redirectURL;
        }
        else return "index";
    }
}
