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
    public String showQuestionForm(@PathVariable int id, Model model)
    {
        SurveyModel surveyModel = surveyRepository.findById(1);

        String redirectURL = "/surveyorIndex/Question/" + id + "/OpenAnswer";
        List<QuestionModel> lst = surveyModel.getSurveyQuestions();
        String type = lst.get(id).getClass().getSimpleName();
        System.out.println(type);
        //switch ()
        if (surveyModel == null)
        {
            surveyModel = new SurveyModel();
            surveyRepository.save(surveyModel);
        }
        OpenAnswer oA = new OpenAnswer();
        surveyModel.addAnswer(oA);

        model.addAttribute("questionModel", lst.get(id));
        model.addAttribute("answerModel", oA);
        model.addAttribute("surveyModel", surveyModel);
        model.addAttribute("id", id);
        return "OpenAnswer";
    }
/**
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
 */
    @PostMapping("/surveyorIndex/Question/OpenAnswer")
    public String addOpenAnswer(@RequestParam ("answer") String answer, Model model) {
        SurveyModel surveyModel = surveyRepository.findById(1);
        System.out.println(answer.toString());
        if (surveyModel == null)
        {
            surveyModel = new SurveyModel();
            surveyRepository.save(surveyModel);
        }

        //rep.save(answer);
       // surveyModel.addAnswer(answer);
        surveyRepository.save(surveyModel);

     //   model.addAttribute("answer", answer);
        OpenAnswer oA = (OpenAnswer) surveyModel.getSurveyAnswers().get(0);
        rep.save(oA);
        surveyModel.addAnswer(oA);
        model.addAttribute("surveyModel", surveyModel);
        model.addAttribute("questionModel", surveyModel.getSurveyQuestions());
        return "redirect:viewSurvey";
    }
}
