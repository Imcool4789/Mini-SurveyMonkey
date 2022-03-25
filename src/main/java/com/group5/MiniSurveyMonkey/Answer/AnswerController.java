package com.group5.MiniSurveyMonkey.Answer;

import com.group5.MiniSurveyMonkey.Question.QuestionModel;
import com.group5.MiniSurveyMonkey.Question.QuestionRepository;
import com.group5.MiniSurveyMonkey.Survey.SurveyModel;
import com.group5.MiniSurveyMonkey.Survey.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AnswerController {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private AnswerRepository rep;


    @GetMapping(value = "/answers")
    public List<AnswerModel> getAll(){
        return (List<AnswerModel>) rep.findAll();
    }

    @GetMapping("/surveyorIndex/Question/{id}")
    public String showQuestionForm(@PathVariable String id, Model model)
    {
        SurveyModel surveyModel = surveyRepository.findById(1);

        //String redirectURL = "/surveyorIndex/Question/" + id + "/OpenAnswer";
        List<QuestionModel> lst = surveyModel.getSurveyQuestions();
        int questionId = Integer.parseInt(id) - 1;
        String type = lst.get(questionId).getClass().getSimpleName();
        System.out.println(type);
        if (surveyModel == null)
        {
            surveyModel = new SurveyModel();
            surveyRepository.save(surveyModel);
        }
        OpenAnswer oA = new OpenAnswer();
        surveyModel.addAnswer(oA);

        model.addAttribute("questionModel", lst.get(questionId));
        model.addAttribute("answerModel", oA);
        model.addAttribute("surveyModel", surveyModel);
        model.addAttribute("id", id);
        return "OpenAnswer";
    }

    @PostMapping("/surveyorIndex/Question/{id}/OpenAnswer")
    public String addOpenAnswer(@PathVariable String id,
                                @RequestParam ("answer") String answer, Model model) {
        SurveyModel surveyModel = surveyRepository.findById(1);
        System.out.println(answer.toString());
        if (surveyModel == null)
        {
            surveyModel = new SurveyModel();
            surveyRepository.save(surveyModel);
        }

        OpenAnswer oA = new OpenAnswer(answer);
        rep.save(oA);
        surveyModel.addAnswer(oA);
        surveyRepository.save(surveyModel);

        model.addAttribute("surveyModel", surveyModel);
        model.addAttribute("questionModel", surveyModel.getSurveyQuestions());
        return "redirect:/surveyorIndex/viewSurvey";
    }
}
