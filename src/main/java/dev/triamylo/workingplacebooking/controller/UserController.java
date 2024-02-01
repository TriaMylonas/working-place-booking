package dev.triamylo.workingplacebooking.controller;

import dev.triamylo.workingplacebooking.model.User;
import dev.triamylo.workingplacebooking.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/user/create")
    public String createUserFormula(Model model){
        //initialise one user object, so that the form in the html can bind with it.
        User initUser = new User();
        //I send the User in the html through Thymeleaf template generator.
        model.addAttribute("user", initUser);
        //then return the template
        return "user/userFormula";
    }

    @PostMapping("/user/add")
    public String addUser(@ModelAttribute("user") User user){
        userService.add(user);
        return "redirect:/user/list";
    }



    @GetMapping("/user/list")
    public String getUserList(Model model){
        //first I take the list from the DB
        List<User> users = userService.list();
        //then I give it to the template
        model.addAttribute("users", users);

        return "user/userList";
    }
}
