package com.group5.MiniSurveyMonkey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SpringWebController
{

    public SpringWebController(){}

    @RequestMapping ("/")
    public String returnIndex()
    {
        return "index";
    }
}
