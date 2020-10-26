package se.fortnox.mvc_thymelaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String getIndexPage(){
        return "index";
    }

    @GetMapping("/welcome")
    public String getWelcomePage(){
        return "welcome";
    }

}
