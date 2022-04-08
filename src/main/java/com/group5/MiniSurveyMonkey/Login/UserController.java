package com.group5.MiniSurveyMonkey.Login;

import com.group5.MiniSurveyMonkey.Survey.SurveyModel;
import com.group5.MiniSurveyMonkey.Survey.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/userIndex")
    public String localLogin(Model model) {
        User user = userRepository.findById(1);
        model.addAttribute("User", user);
        return "userIndex";
    }

    @GetMapping("/userIndex/viewSurvey")
    public String viewSurvey(Model model) {
        User user = userRepository.findById(1);
        SurveyModel surveyModel = surveyRepository.findById(1);
        if (surveyModel == null) {
            surveyModel = new SurveyModel();
            surveyRepository.save(surveyModel);
        }
        String surveyTitle = "Questions for " + surveyModel.getName() + "[id =" + surveyModel.getId() + "]";

        model.addAttribute("surveyTitle", surveyTitle);
        model.addAttribute("User", user);
        model.addAttribute("surveyModel", surveyModel);
        return "viewSurvey";
    }


}
