package com.group5.MiniSurveyMonkey.Question;

import com.group5.MiniSurveyMonkey.Survey.SurveyModel;
import com.group5.MiniSurveyMonkey.Survey.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
                              Model model)
    {
        SurveyModel surveyModel = surveyRepository.findById(1);
        if (surveyModel == null)
        {
            surveyModel = new SurveyModel();
            surveyRepository.save(surveyModel);
        }

        switch(type)
        {
            case "OpenQuestion":
                openQuestion.setSurvey(surveyModel);
                openQuestion.setId(question.getId());
                openQuestion.setName(question.getName());
                surveyModel.addQuestion(openQuestion);
                questionRepository.save(openQuestion);
                surveyRepository.save(surveyModel);
                break;
            case "MCQuestion":
                mcQuestion.setSurvey(surveyModel);
                mcQuestion.setId(question.getId());
                mcQuestion.setName(question.getName());
                mcQuestion.addOpt();
                surveyModel.addQuestion(mcQuestion);
                questionRepository.save(mcQuestion);
                surveyRepository.save(surveyModel);
                break;
            case "NumberRangeQuestion":
                numberRangeQuestion.setSurvey(surveyModel);
                numberRangeQuestion.setId(question.getId());
                numberRangeQuestion.setName(question.getName());
                surveyModel.addQuestion(numberRangeQuestion);
                questionRepository.save(numberRangeQuestion);
                surveyRepository.save(surveyModel);
                break;
        }
        return "redirect:viewSurvey";
    }

    @GetMapping("/surveyorIndex/createQuestion")
    public String showQuestionForm(Model model)
    {
        MCQuestion mcQuestion = new MCQuestion();
        OpenQuestion openQuestion = new OpenQuestion();
        NumberRangeQuestion numberRangeQuestion = new NumberRangeQuestion();
        QuestionModel question = new QuestionModel();

        model.addAttribute("MCQuestion", mcQuestion);
        model.addAttribute("openEnded", openQuestion);
        model.addAttribute("numberRange", numberRangeQuestion);
        model.addAttribute("question", question);
        return "createQuestion";
    }

    @PostMapping(value = "deleteQuestion")
    public String deleteQuestion(@RequestParam("id") long id,
                                 @ModelAttribute("question") QuestionModel question,
                                 Model model)
    {
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