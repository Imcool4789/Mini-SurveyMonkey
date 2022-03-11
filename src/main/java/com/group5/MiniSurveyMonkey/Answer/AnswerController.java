package com.group5.MiniSurveyMonkey.Answer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
