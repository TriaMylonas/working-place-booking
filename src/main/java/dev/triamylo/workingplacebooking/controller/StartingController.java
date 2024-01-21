package dev.triamylo.workingplacebooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartingController {
    @GetMapping(value="/booking")
    public String booking() {
        return "bookingDesk";
    }


    @GetMapping("/login")
    public String login(){return "customLogin";}

    @GetMapping("/home")
    public String home(){return "index";}

//    I need it only for developing reasons to create the html side
    @GetMapping("/addUser")
    public String userFormula(){return "userFormula";}
}