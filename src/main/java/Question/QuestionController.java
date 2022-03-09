package Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {

    private QuestionRepository rep;

    public QuestionController (QuestionRepository rep){
        this.rep = rep;

    }

    @PostMapping(value = "addQuestion")
    public String addQuestion(@RequestBody QuestionModel q) {
        rep.save(q);
        return "addQuestion";
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
