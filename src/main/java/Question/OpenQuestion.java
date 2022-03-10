package Question;

import javax.persistence.Entity;

@Entity
public class OpenQuestion extends QuestionModel{

    public OpenQuestion (){
        setType(QuestionType.OPEN);
    }
}
