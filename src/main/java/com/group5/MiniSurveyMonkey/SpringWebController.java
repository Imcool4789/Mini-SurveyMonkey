package com.group5.MiniSurveyMonkey;

import com.group5.MiniSurveyMonkey.Login.LocalUser;
import com.group5.MiniSurveyMonkey.Login.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringWebController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String returnIndex(Model model) {
        LocalUser user = userRepository.findById(1);
        if (user != null) {
            String redirectURL = user.getAccessType() + "Index";
            model.addAttribute("localUser", user);
            return "redirect:/" + redirectURL;
        } else
            model.addAttribute("localUser", new LocalUser());
        return "index";
    }

    @GetMapping("/viewSurvey")
    public String showSurvey(Model model) {
        LocalUser user = userRepository.findById(1);
        if (user != null) {
            String redirectURL = user.getAccessType() + "Index" + "/viewSurvey";
            model.addAttribute("localUser", user);
            return "redirect:/" + redirectURL;
        } else
            model.addAttribute("localUser", new LocalUser());
        return "index";
    }

}
