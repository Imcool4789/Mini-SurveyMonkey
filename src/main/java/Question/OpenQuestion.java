package Question;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OpenQuestion extends QuestionModel{

    @ElementCollection
    private List<String> responses;

    public OpenQuestion (){
        setType(QuestionType.OPEN);
        this.responses = new ArrayList<>();
    }

    public List<String> getResponses(){
        return responses;
    }

    public void setResponses(ArrayList<String> responses){
        this.responses = responses;
    }

    public void addResponse (String response){
        responses.add(response);
    }

    @Override
    public String toString() {
        return "OpenEndedQuestion{" +
                "responses=" + responses +
                '}';
    }
}
