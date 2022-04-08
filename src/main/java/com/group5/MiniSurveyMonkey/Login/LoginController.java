package com.group5.MiniSurveyMonkey.Login;

import com.group5.MiniSurveyMonkey.Survey.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String localLogin(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "/index";
    }

    @GetMapping("/logout")
    public String handleLogout(Model model) {
        userRepository.deleteAll();
        return "redirect:/";
    }
}
