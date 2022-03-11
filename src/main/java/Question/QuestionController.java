package Question;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {

    private QuestionRepository rep;

    public QuestionController (QuestionRepository rep){
        this.rep = rep;

    }

    @PostMapping("/surveyorIndex/createQuestion")
    public String addQuestion(Model model, @ModelAttribute("question") QuestionModel q) {
        model.addAttribute("Question", q);
        rep.save(q);
        return "viewSurvey";
    }

    @PostMapping(value = "deleteQuestion")
    public String deleteQuestion(@RequestParam("id") long id) {
        rep.deleteById(id);
        return "deleteQuestion";
    }

    @GetMapping(value = "/question")
    public List<QuestionModel> getAll(){
        return (List<QuestionModel>) rep.findAll();
    }

}