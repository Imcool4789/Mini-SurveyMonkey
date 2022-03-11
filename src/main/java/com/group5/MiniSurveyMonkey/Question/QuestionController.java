package com.group5.MiniSurveyMonkey.Question;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class QuestionController {

    private QuestionRepository rep;

    public QuestionController (QuestionRepository rep){
        this.rep = rep;
    }

    @PostMapping("/surveyorIndex/createQuestion")
    public String addQuestion(Model model, @ModelAttribute("question") QuestionModel q) {
        model.addAttribute("question", new QuestionModel());
        rep.save(q);
        return "viewSurvey";
    }

    @GetMapping("/surveyorIndex/createQuestion")
    public String showQuestionForm(Model model){
        model.addAttribute("question", new QuestionModel());
        return "createQuestion";
    }

    @PostMapping(value = "deleteQuestion")
    public String deleteQuestion(@RequestParam("id") long id) {
        rep.deleteById(id);
        return "deleteQuestion";
    }

    @GetMapping(value = "/question")
    public List<QuestionModel> getAll(){
        return (List<QuestionModel>) rep.findAll();
    }

}