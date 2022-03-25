package com.group5.MiniSurveyMonkey.Answer;

import com.group5.MiniSurveyMonkey.Question.QuestionModel;
import com.group5.MiniSurveyMonkey.Survey.SurveyModel;
import com.group5.MiniSurveyMonkey.Survey.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AnswerController {
    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private AnswerRepository rep;

    public AnswerController(AnswerRepository rep){
        this.rep = rep;
    }

    @GetMapping(value = "/answers")
    public List<AnswerModel> getAll(){
        return (List<AnswerModel>) rep.findAll();
    }

    @GetMapping("/surveyorIndex/viewQuestion")
    public String showQuestionForm(Model model)
    {
        SurveyModel surveyModel = surveyRepository.findById(1);
        if (surveyModel == null)
        {
            surveyModel = new SurveyModel();
            surveyRepository.save(surveyModel);
        }
        model.addAttribute("answer", new AnswerModel());
        model.addAttribute("surveyModel", surveyModel);
        model.addAttribute("questionModel", surveyModel.getSurveyQuestions());
        return "viewQuestion";
    }

    @PostMapping("/surveyorIndex/viewQuestion")
    public String addAnswer(@ModelAttribute("answer") AnswerModel answer, Model model) {
        SurveyModel surveyModel = surveyRepository.findById(1);
        if (surveyModel == null)
        {
            surveyModel = new SurveyModel();
            surveyRepository.save(surveyModel);
        }

        rep.save(answer);
        surveyModel.addAnswer(answer);
        surveyRepository.save(surveyModel);

        model.addAttribute("answer", answer);
        model.addAttribute("surveyModel", surveyModel);
        model.addAttribute("questionModel", surveyModel.getSurveyQuestions());

        return "redirect:viewSurvey";
    }
}
