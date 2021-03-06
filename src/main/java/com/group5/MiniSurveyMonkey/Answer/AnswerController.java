package com.group5.MiniSurveyMonkey.Answer;


import com.group5.MiniSurveyMonkey.*;
import com.group5.MiniSurveyMonkey.Login.*;
import com.group5.MiniSurveyMonkey.Question.*;
import com.group5.MiniSurveyMonkey.Survey.*;
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
    private UserRepository userRepository;

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

    @GetMapping({"/surveyorIndex/Question/{id}", "/userIndex/Question/{id}"})
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

    @PostMapping({"/userIndex/Question/{id}", "/surveyorIndex/Question/{id}"})
    public String addNumAnswer(@PathVariable String id,
                               @RequestParam("answer") String answer, @RequestParam(value = "action", required = true) String action,
                               Model model) {
        SurveyModel surveyModel = surveyRepository.findById(1);
        if (surveyModel == null) {
            surveyModel = new SurveyModel();
            surveyRepository.save(surveyModel);
        }

        System.out.println(id);
        System.out.println(action);
        System.out.println(answer);

        int questionID = Integer.parseInt(id) - 1;
        List<QuestionModel> questions = surveyModel.getSurveyQuestions();
        QuestionModel question = questions.get(questionID);
        String type = question.getClass().getSimpleName();

        switch (type){
            case "NumberRangeQuestion":
                int temp = 0;
                boolean numeric = true;
                try {
                    Integer num = Integer.parseInt(answer);
                } catch (NumberFormatException e) {
                    numeric = false;
                }
                NumberRangeQuestion numQuestion = (NumberRangeQuestion) question;
                if(answer.equals("")){
                    temp = 0;
                }
                if(!numeric){
                    temp = numQuestion.getMin();
                }
                else {
                    temp = Integer.parseInt(answer);
                }

                if(temp > numQuestion.getMax()){
                    temp = numQuestion.getMax();
                }

                if(temp < numQuestion.getMin()){
                    temp = numQuestion.getMin();
                }
                NumberRangeAnswer numAnswer = new NumberRangeAnswer(temp, numQuestion);
                answerRepository.save(numAnswer);
                questionRepository.save(numQuestion);
                break;
            case "MCQuestion":
                MCQuestion mcQuestion = (MCQuestion) question;
                MCAnswer mcAnswer = new MCAnswer(answer,mcQuestion);
                System.out.println(answer);
                answerRepository.save(mcAnswer);
                questionRepository.save(mcQuestion);
                break;
            case "OpenQuestion":
                OpenQuestion openQuestion = (OpenQuestion) question;
                OpenAnswer openAnswer = new OpenAnswer(answer, openQuestion);
                answerRepository.save(openAnswer);
                questionRepository.save(openQuestion);
                break;
        }

        surveyRepository.save(surveyModel);

        model.addAttribute("surveyModel", surveyModel);
        model.addAttribute("questionModel", surveyModel.getSurveyQuestions());

        int next = Integer.parseInt(id) + 1;
        int prev = Integer.parseInt(id) - 1;
        switch (action){
            case "Next":
                if(Integer.parseInt(id) < surveyModel.getQuestionNum()){
                    String str = "redirect:/userIndex/Question/" + next;
                    return str;
                }
                else{
                    return "redirect:/userIndex/Result";
                }
            case "Previous":
                if(Integer.parseInt(id) > 1){
                    String str = "redirect:/userIndex/Question/" + prev;
                    return str;
                }
                else{
                    return "redirect:/userIndex/Question/{id}";
                }
        }

        return "redirect:/userIndex/Question/{id}/Result";
    }
}
