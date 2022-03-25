package com.group5.MiniSurveyMonkey.Question;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class MCQuestion extends QuestionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ElementCollection
    private List<String> opt = new ArrayList<>();

    private String mc1;
    private String mc2;
    private String mc3;
    private String mc4;


    public MCQuestion()
    {

    }

    public void setOpt(List<String> opt) {
        this.opt = opt;
    }

    public List<String> getOpt() {
        return opt;
    }
    public String getMc1() {
        return mc1;
    }

    public void setMc1(String mc1) {
        this.mc1 = mc1;
    }

    public String getMc2() {
        return mc2;
    }

    public void setMc2(String mc2) {
        this.mc2 = mc2;
    }

    public String getMc3() {
        return mc3;
    }

    public void setMc3(String mc3) {
        this.mc3 = mc3;
    }

    public String getMc4() {
        return mc4;
    }

    public void setMc4(String mc4) {
        this.mc4 = mc4;
    }

    public void addOpt() {
        opt.add(mc1);
        opt.add(mc2);
        opt.add(mc3);
        opt.add(mc4);
    }

    @Override
    public String toString() {
        return "MCQuestion{" + "options=" + opt + '}';
    }
}
