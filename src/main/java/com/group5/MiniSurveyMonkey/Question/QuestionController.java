package com.group5.MiniSurveyMonkey.Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping("/surveyorIndex/createQuestion")
    public String addQuestion(@ModelAttribute("question") QuestionModel question, Model model) {
        model.addAttribute("question", question);
        questionRepository.save(question);
        return "viewSurvey";
    }

    @GetMapping("/surveyorIndex/createQuestion")
    public String showQuestionForm(Model model){
        return "createQuestion";
    }

    @PostMapping(value = "deleteQuestion")
    public String deleteQuestion(@RequestParam("id") long id) {
        questionRepository.deleteById(id);
        return "deleteQuestion";
    }

}