package com.group5.MiniSurveyMonkey.Answer;

import com.group5.MiniSurveyMonkey.Question.*;
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
        NumberRangeQuestion numQuestion = null;
        MCQuestion mcQuestion = null;
        if(question.getClass().getSimpleName().equals("MCQuestion")){
            mcQuestion = (MCQuestion) surveyModel.getQuestion(questionId);
        }

        if(question.getClass().getSimpleName().equals("NumberRangeQuestion")){
            numQuestion = (NumberRangeQuestion) surveyModel.getQuestion(questionId);
        }
        

        model.addAttribute("questionModel", question);
        model.addAttribute("answerModel", answerModel);
        model.addAttribute("surveyModel", surveyModel);
        model.addAttribute("id", id);
        model.addAttribute("numRangeQuestion", numQuestion);
        model.addAttribute("mcQuestion",mcQuestion);


        if(question.getClass().getSimpleName().equals("MCQuestion")){
            return "mcAnswer";
        }
        else if (question.getClass().getSimpleName().equals("NumberRangeQuestion")){
            return "numAnswer";
        }

        return "OpenAnswer";
    }

    @PostMapping(value = "/surveyorIndex/Question/{id}")
    public String addNumAnswer(@PathVariable String id,
                                @RequestParam("answer") String answer, @RequestParam(value = "action", required = true) String action,
                                Model model) {
        SurveyModel surveyModel = surveyRepository.findById(1);
        if (surveyModel == null) {
            surveyModel = new SurveyModel();
            surveyRepository.save(surveyModel);
        }

        int questionID = Integer.parseInt(id) - 1;
        List<QuestionModel> questions = surveyModel.getSurveyQuestions();
        QuestionModel question = questions.get(questionID);
        String type = question.getClass().getSimpleName();
        List<AnswerModel> responses = null;

        switch (type){
            case "NumberRangeQuestion":
                NumberRangeQuestion numQuestion = (NumberRangeQuestion) questions.get(questionID);
                if(answer.equals("")){
                    answer = "0";
                }
                NumberRangeAnswer numAnswer = new NumberRangeAnswer(Integer.parseInt(answer), numQuestion);
                responses = numQuestion.getResponses();
                responses.add(numAnswer);
                answerRepository.save(numAnswer);
                questionRepository.save(numQuestion);
                break;
            case "MCQuestion":
                MCQuestion mcQuestion = (MCQuestion) questions.get(questionID);
                MCAnswer mcAnswer = new MCAnswer(answer,mcQuestion);
                responses = mcQuestion.getResponses();
                responses.add(mcAnswer);
                answerRepository.save(mcAnswer);
                questionRepository.save(mcQuestion);
                break;
            case "OpenQuestion":
                OpenQuestion openQuestion = (OpenQuestion) questions.get(questionID);
                OpenAnswer openAnswer = new OpenAnswer(answer, openQuestion);
                responses = openQuestion.getResponses();
                responses.add(openAnswer);
                answerRepository.save(openAnswer);
                questionRepository.save(openQuestion);
                break;
        }

        surveyRepository.save(surveyModel);

        model.addAttribute("surveyModel", surveyModel);
        model.addAttribute("questionModel", surveyModel.getSurveyQuestions());

        int next = Integer.parseInt(id) + 1;
        int prev = Integer.parseInt(id)-1;
        switch (action){
            case "Next":
                if(Integer.parseInt(id) < surveyModel.getQuestionNum()){
                    String str = "redirect:/surveyorIndex/Question/" + next;
                    return str;
                }
                else{
                    return "redirect:/surveyorIndex/Question/{id}/Result";
                }
            case "Previous":
                if(Integer.parseInt(id) > 1){
                    String str = "redirect:/surveyorIndex/Question/" + prev;
                    return str;
                }
                else{
                    return "redirect:/surveyorIndex/Question/{id}/Result";
                }
        }

        return "redirect:/surveyorIndex/Question/{id}/Result";
    }
}
