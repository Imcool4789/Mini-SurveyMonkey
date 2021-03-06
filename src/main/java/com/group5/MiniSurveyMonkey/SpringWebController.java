package com.group5.MiniSurveyMonkey;

import com.group5.MiniSurveyMonkey.Login.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringWebController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/index")
    public String returnHome(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
            return "redirect:/surveyorIndex";
        else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER")))
            return "redirect:/userIndex";
        return "index";
    }

    @GetMapping("/viewSurvey")
    public String showSurvey(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
            return "redirect:/surveyorIndex/viewSurvey";
        else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER")))
            return "redirect:/userIndex/viewSurvey";
        return "index";
    }

}
