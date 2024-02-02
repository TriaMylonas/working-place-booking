package dev.triamylo.workingplacebooking.controller;

import dev.triamylo.workingplacebooking.model.Role;
import dev.triamylo.workingplacebooking.model.User;
import dev.triamylo.workingplacebooking.service.role.RoleService;
import dev.triamylo.workingplacebooking.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@Controller
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService)
    {
        this.roleService = roleService;
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

            List<Role> notAssignRoles = rolesThatTheUserDoNotHave(user);

            model.addAttribute("user", user);
            model.addAttribute("notAssignRoles",notAssignRoles);
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

    @PostMapping("/user/{id}/addRole")
    public String addUserRole(@PathVariable String id, @RequestParam String roleId){
        //get the user from the DB
        User user = userService.get(id);
        //get the selected role
        Role role = roleService.get(roleId);
        // add the role to the user
        user.addRole(role);
        //update the user with the new role
        userService.update(user);

        //redirect to the user update page
        return "redirect:/user/update/" + user.getId();
    }



    private List<Role> rolesThatTheUserDoNotHave(User user) {
        List<Role> allAvailableRoles = roleService.list();
        List<Role> userRoles = user.getRoles();

        return allAvailableRoles.stream().filter(role -> !userRoles.contains(role))
                .collect(Collectors.toList());
    }

}
