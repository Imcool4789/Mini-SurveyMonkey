package com.group5.MiniSurveyMonkey.Answer;

import com.group5.MiniSurveyMonkey.Question.OpenQuestion;
import com.group5.MiniSurveyMonkey.Question.QuestionModel;
import com.group5.MiniSurveyMonkey.Question.QuestionRepository;
import com.group5.MiniSurveyMonkey.Survey.SurveyModel;
import com.group5.MiniSurveyMonkey.Survey.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AnswerController {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @GetMapping(value = "/answers")
    public List<AnswerModel> getAll() {
        return answerRepository.findAll();
    }

    @GetMapping("/surveyorIndex/Question/{id}")
    public String showQuestionForm(@PathVariable String id,
                                   Model model) {
        SurveyModel surveyModel = surveyRepository.findById(1);
        if (surveyModel == null) {
            surveyModel = new SurveyModel();
            surveyRepository.save(surveyModel);
        }

        List<QuestionModel> questions = surveyModel.getSurveyQuestions();
        int questionId = Integer.parseInt(id) - 1;

        QuestionModel question = questions.get(questionId);
        AnswerModel answerModel = new AnswerModel();

        model.addAttribute("questionModel", question);
        model.addAttribute("answerModel", answerModel);
        model.addAttribute("surveyModel", surveyModel);
        model.addAttribute("id", id);
        return "OpenAnswer";
    }

    @PostMapping("/surveyorIndex/Question/{id}/OpenAnswer")
    public String addOpenAnswer(@PathVariable String id,
                                @RequestParam("answer") String answer,
                                Model model) {
        SurveyModel surveyModel = surveyRepository.findById(1);
        if (surveyModel == null) {
            surveyModel = new SurveyModel();
            surveyRepository.save(surveyModel);
        }

        int questionID = Integer.parseInt(id) - 1;
        List<QuestionModel> questions = surveyModel.getSurveyQuestions();
        OpenQuestion question = (OpenQuestion) questions.get(questionID);

        OpenAnswer openAnswer = new OpenAnswer(answer, question);

        List<AnswerModel> responses = question.getResponses();
        responses.add(openAnswer);

        answerRepository.save(openAnswer);
        questionRepository.save(question);
        surveyRepository.save(surveyModel);

        model.addAttribute("surveyModel", surveyModel);
        model.addAttribute("questionModel", surveyModel.getSurveyQuestions());
        return "redirect:/surveyorIndex/Question/{id}/Result";
    }
}
