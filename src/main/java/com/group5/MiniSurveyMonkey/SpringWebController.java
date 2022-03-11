package com.group5.MiniSurveyMonkey;

import com.group5.MiniSurveyMonkey.Login.LocalUser;
import com.group5.MiniSurveyMonkey.Login.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class SpringWebController
{
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String returnIndex(Model model)
    {
        LocalUser user = userRepository.findById(1);
        if (user != null)
        {
            String redirectURL = user.getAccessType() + "Index";
            model.addAttribute("localUser", user);
            return "forward:/" + redirectURL;
        }
        else model.addAttribute("localUser", new LocalUser());
        return "index";
    }
}

