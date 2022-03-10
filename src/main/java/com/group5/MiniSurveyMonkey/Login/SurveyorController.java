package com.group5.MiniSurveyMonkey.Login;

import com.group5.MiniSurveyMonkey.Survey.SurveyModel;
import com.group5.MiniSurveyMonkey.Survey.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@Controller
public class SurveyorController
{
    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/surveyorIndex")
    public String localLogin(Model model)
    {
        if (!userRepository.findAll().iterator().hasNext())
        {
            LocalUser user = new LocalUser("surveyor", "surveyor");
            userRepository.save(user);
        }
        Iterator<LocalUser> iterUser = userRepository.findAll().iterator();
        LocalUser user = iterUser.next();

        model.addAttribute("localUser", user);
        return "surveyorIndex";
    }

    @GetMapping("/surveyorIndex/create")
    public String createSurvey(Model model)
    {
        LocalUser user = userRepository.findAll().iterator().next();
        SurveyModel surveyModel = new SurveyModel();
        surveyRepository.save(surveyModel);

        model.addAttribute("localUser", user);
        model.addAttribute("surveyModel", surveyModel);
        return "surveyorIndex";
    }

    @GetMapping("/surveyorIndex/viewSurvey")
    public String viewSurvey(Model model)
    {
        LocalUser user = userRepository.findAll().iterator().next();

        if (!surveyRepository.findAll().iterator().hasNext())
        {
            SurveyModel surveyModel = new SurveyModel();
            surveyRepository.save(surveyModel);
        }
        SurveyModel surveyModel = surveyRepository.findAll().iterator().next();

        model.addAttribute("localUser", user);
        model.addAttribute("surveyModel", surveyModel);
        return "viewSurvey";
    }
}