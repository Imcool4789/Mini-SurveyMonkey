package com.group5.MiniSurveyMonkey.Answer;

import com.group5.MiniSurveyMonkey.Question.MCQuestion;
import com.group5.MiniSurveyMonkey.Question.NumberRangeQuestion;
import com.group5.MiniSurveyMonkey.Question.QuestionModel;
import com.group5.MiniSurveyMonkey.Survey.SurveyModel;
import com.group5.MiniSurveyMonkey.Survey.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
public class ResultsController {
    @Autowired
    private SurveyRepository surveyRepository;

    @GetMapping("/surveyorIndex/Question/{id}/Result")
    public String viewOpenResult(@PathVariable String id, Model model) {
        SurveyModel surveyModel = surveyRepository.findById(1);

        if (surveyModel == null) {
            surveyModel = new SurveyModel();
            surveyRepository.save(surveyModel);
        }

        int questionID = Integer.parseInt(id) - 1;
        List<QuestionModel> questions = surveyModel.getSurveyQuestions();
        QuestionModel question = questions.get(questionID);
        String type = question.getClass().getSimpleName();

        String questionTitle = "";
        String graphTitle = "Survey Results for Question: '" + question.getName() + "'";
        Random random = new Random();
        model.addAttribute("question", question);
        switch (type) {
            case "OpenQuestion":
                List<AnswerModel> responses = question.getResponses();
                questionTitle = "Responses for Question: " + question.getName() + "[id =" + id + "]";
                model.addAttribute("questionTitle", questionTitle);
                model.addAttribute("responses", responses);
                return "OpenResult";
            case "NumberRangeQuestion":
                NumberRangeQuestion numberRangeQuestion = (NumberRangeQuestion) question;
                /*TESTING*/
                int max = 10;
                int min = 1;
                for (int i = 0; i < 100; i++) {
                    int value = random.nextInt(max) + min;
                    NumberRangeAnswer answer = new NumberRangeAnswer(value, numberRangeQuestion);
                }
                questionTitle = "Responses for Question: " + question.getName() + "[id =" + id + "]";
                model.addAttribute("graphTitle", graphTitle);
                model.addAttribute("numberRangeData", numberRangeQuestion.convertTo2DArray());
                return "NumberRangeResult";
            case "MCQuestion":
                MCQuestion mcQuestion = (MCQuestion) question;
                Map<String, Integer> mcResponses = mcQuestion.getResponseMap();
                /*TESTING*/
                List<String> keys = new ArrayList<>(mcResponses.keySet());
                int maxIndex = keys.size();
                int minIndex = 0;
                for (int i = 0; i < 100; i++) {
                    int value = random.nextInt(maxIndex) + minIndex;
                    String randomAnswer = keys.get(value);
                    MCAnswer answer = new MCAnswer(randomAnswer, mcQuestion);
                }
                questionTitle = "Responses for Question: " + question.getName() + "[id =" + id + "]";
                model.addAttribute("graphTitle", graphTitle);
                model.addAttribute("MCData", mcQuestion.convertTo2DArray());
                return "MCResult";

        }
        return "viewSurvey";
    }
}
