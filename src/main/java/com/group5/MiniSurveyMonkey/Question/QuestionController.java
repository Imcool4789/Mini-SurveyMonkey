package com.group5.MiniSurveyMonkey.Question;

import com.group5.MiniSurveyMonkey.Survey.SurveyModel;
import com.group5.MiniSurveyMonkey.Survey.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class QuestionController {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping("/surveyorIndex/createQuestion")
    public String addQuestion(@ModelAttribute("question") QuestionModel question, Model model) {
        SurveyModel surveyModel = surveyRepository.findById(1);
        if (surveyModel == null)
        {
            surveyModel = new SurveyModel();
            surveyRepository.save(surveyModel);
        }

        questionRepository.save(question);
        surveyModel.addQuestion(question);
        surveyRepository.save(surveyModel);

        model.addAttribute("question", question);
        model.addAttribute("surveyQuestions", surveyModel);

        return "redirect:viewSurvey";
    }

    @GetMapping("/surveyorIndex/createQuestion")
    public String showQuestionForm(Model model)
    {
        model.addAttribute("question", new QuestionModel());
        return "createQuestion";
    }

    @PostMapping(value = "deleteQuestion")
    public String deleteQuestion(@RequestParam("id") long id, @ModelAttribute("question") QuestionModel question, Model model) {
        SurveyModel surveyModel = surveyRepository.findById(1);
        if (surveyModel == null)
        {
            surveyModel = new SurveyModel();
            surveyRepository.save(surveyModel);
        }
        surveyModel.removeQuestion((int)question.getId()-1);
        questionRepository.deleteById(id);

        model.addAttribute("question", question);
        model.addAttribute("surveyQuestions", surveyModel);

        return "deleteQuestion";
    }

}