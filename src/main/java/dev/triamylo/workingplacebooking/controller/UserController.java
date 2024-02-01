package dev.triamylo.workingplacebooking.controller;

import dev.triamylo.workingplacebooking.model.User;
import dev.triamylo.workingplacebooking.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/user/create")
    public String createUserFormula(Model model) {
        //initialise one user object, so that the form in the html can bind with it.
        User initUser = new User();
        //I send the User in the html through Thymeleaf template generator.
        model.addAttribute("user", initUser);
        //then return the template
        return "user/userFormula";
    }

    @PostMapping("/user/create")
    public String addUser(@ModelAttribute("user") User user) {
        //if is a new user save
        if (user.getId() == null || user.getId().isEmpty()) {
            userService.add(user);
        }
        //if the user already exist, update
        else {
            userService.update(user);
        }
        return "redirect:/user/list";
    }


    @GetMapping("/user/list")
    public String getUserList(Model model) {
        //first I take the list from the DB
        List<User> users = userService.list();
        //then I give it to the template
        model.addAttribute("users", users);

        return "user/userList";
    }


    @GetMapping("/user/update/{id}")
    public String updateUserFormula(Model model, @PathVariable String id) {

        //initialise the user with this id to send him in the template
        User user = userService.get(id);

        if (user != null) {
            model.addAttribute("user", user);
            return "user/userFormula";
        } else
            return "redirect:/user/list";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable String id, Model model) {
        // I find and take the user from the DB, and then I give it to delete method,
        // so that he will be erased from the DB.
        userService.delete(userService.get(id));
        return "redirect:/user/list";
    }

}
