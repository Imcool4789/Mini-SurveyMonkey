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
    public String addQuestion(@RequestParam("type") String type,
                              @ModelAttribute("MCQuestion") MCQuestion mcQuestion,
                              @ModelAttribute("openEnded") OpenQuestion openQuestion,
                              @ModelAttribute("numberRange") NumberRangeQuestion numberRangeQuestion,
                              @ModelAttribute("question") QuestionModel question,
                              Model model) {
        SurveyModel surveyModel = surveyRepository.findById(1);
        if (surveyModel == null)
        {
            surveyModel = new SurveyModel();
            surveyRepository.save(surveyModel);
        }

        switch(type)
        {
            case "OpenQuestion":
                openQuestion.setId(question.getId());
                openQuestion.setName(question.getName());
                questionRepository.save(openQuestion);
                surveyModel.addQuestion(openQuestion);
                surveyRepository.save(surveyModel);
                break;
            case "MCQuestion":
                mcQuestion.setId(question.getId());
                mcQuestion.setName(question.getName());
                mcQuestion.addOpt();
                questionRepository.save(mcQuestion);
                surveyModel.addQuestion(mcQuestion);
                surveyRepository.save(surveyModel);
                break;
            case "NumberRangeQuestion":
                numberRangeQuestion.setId(question.getId());
                numberRangeQuestion.setName(question.getName());
                questionRepository.save(numberRangeQuestion);
                surveyModel.addQuestion(numberRangeQuestion);
                surveyRepository.save(surveyModel);
                break;
        }


        model.addAttribute("surveyQuestions", surveyModel);

        return "redirect:viewSurvey";
    }

    @GetMapping("/surveyorIndex/createQuestion")
    public String showQuestionForm(Model model)
    {
        model.addAttribute("MCQuestion", new MCQuestion());
        model.addAttribute("openEnded", new OpenQuestion());
        model.addAttribute("numberRange", new NumberRangeQuestion());
        model.addAttribute("question", new QuestionModel());
        return "createQuestion";
    }

    @PostMapping(value = "deleteQuestion")
    public String deleteQuestion(@RequestParam("id") long id) {
        questionRepository.deleteById(id);
        return "deleteQuestion";
    }

}