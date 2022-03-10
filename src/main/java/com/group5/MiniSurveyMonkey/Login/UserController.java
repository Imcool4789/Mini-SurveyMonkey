package com.group5.MiniSurveyMonkey.Login;

import com.group5.MiniSurveyMonkey.Survey.SurveyModel;
import com.group5.MiniSurveyMonkey.Survey.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Iterator;

public class UserController
{
    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/userIndex")
    public String localLogin(Model model)
    {
        if (!userRepository.findAll().iterator().hasNext())
        {
            LocalUser user = new LocalUser("user1", "password");
            userRepository.save(user);
        }
        Iterator<LocalUser> iterUser = userRepository.findAll().iterator();
        LocalUser user = iterUser.next();

        model.addAttribute("localUser", user);
        return "userIndex";
    }

    @GetMapping("/userIndex/viewSurvey")
    public String viewSurvey(Model model)
    {
        LocalUser user = userRepository.findAll().iterator().next();
        SurveyModel surveyModel = surveyRepository.findAll().iterator().next();

        model.addAttribute("localUser", user);
        model.addAttribute("surveyModel", surveyModel);
        return "viewSurvey";
    }
}
