package com.group5.MiniSurveyMonkey.Answer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AnswerController {

    private AnswerRepository rep;

    public AnswerController(AnswerRepository rep){
        this.rep = rep;
    }

    @GetMapping(value = "/answers")
    public List<AnswerModel> getAll(){
        return (List<AnswerModel>) rep.findAll();
    }
}
