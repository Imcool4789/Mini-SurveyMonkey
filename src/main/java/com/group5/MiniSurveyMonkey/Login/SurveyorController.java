package com.group5.MiniSurveyMonkey.Login;

import com.group5.MiniSurveyMonkey.Survey.SurveyModel;
import com.group5.MiniSurveyMonkey.Survey.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        LocalUser user = userRepository.findById(1);
        model.addAttribute("localUser", user);
        return "surveyorIndex";
    }

    @GetMapping("/surveyorIndex/viewSurvey")
    public String viewSurvey(Model model)
    {
        LocalUser user = userRepository.findById(1);
        SurveyModel surveyModel = surveyRepository.findById(1);
        if (surveyModel == null)
        {
            surveyModel = new SurveyModel();
            surveyRepository.save(surveyModel);
        }
        String surveyTitle = "Questions for " + surveyModel.getName() + "[id =" + surveyModel.getId() + "]";

        model.addAttribute("surveyTitle", surveyTitle);
        model.addAttribute("localUser", user);
        model.addAttribute("surveyModel", surveyModel);
        return "viewSurvey";
    }

    @GetMapping("/surveyorIndex/closeSurvey")
    public String closeSurvey(Model model)
    {
        SurveyModel surveyModel = surveyRepository.findById(1);
        if (surveyModel != null)
        {
            surveyModel.setClosed(true);
            surveyRepository.delete(surveyModel);
        }
        model.addAttribute("survey", surveyModel);
        return "closeSurvey";
    }
}