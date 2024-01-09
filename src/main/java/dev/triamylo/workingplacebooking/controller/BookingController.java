package dev.triamylo.workingplacebooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookingController {
    @GetMapping(value="/booking")
    public String booking() {
        return "bookingDesk";
    }


    @GetMapping("/login")
    public String login(){return "customLogin";}
}