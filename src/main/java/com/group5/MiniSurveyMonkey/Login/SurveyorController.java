package com.group5.MiniSurveyMonkey.Login;

import com.group5.MiniSurveyMonkey.Survey.SurveyModel;
import com.group5.MiniSurveyMonkey.Survey.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SurveyorController {
    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/surveyorIndex")
    public String localLogin(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.out.println(currentPrincipalName);
        return "surveyorIndex";
    }

    @GetMapping("/surveyorIndex/viewSurvey")
    public String viewSurvey(Model model) {
        SurveyModel surveyModel = surveyRepository.findById(1);

        if (surveyModel == null) {
            surveyModel = new SurveyModel();
            surveyRepository.save(surveyModel);
        }
        String surveyTitle = "Questions for " + surveyModel.getName() + "[id =" + surveyModel.getId() + "]";

        model.addAttribute("surveyTitle", surveyTitle);
        model.addAttribute("surveyModel", surveyModel);
        return "viewSurvey";
    }

    @GetMapping("/surveyorIndex/closeSurvey")
    public String closeSurvey(Model model) {
        SurveyModel surveyModel = surveyRepository.findById(1);
        if (surveyModel != null) {
            surveyModel.setClosed(true);
            surveyRepository.delete(surveyModel);
        }
        model.addAttribute("survey", surveyModel);
        return "closeSurvey";
    }
}