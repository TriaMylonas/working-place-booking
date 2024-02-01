package dev.triamylo.workingplacebooking.controller;

import dev.triamylo.workingplacebooking.model.Role;
import dev.triamylo.workingplacebooking.service.role.RoleService;
import dev.triamylo.workingplacebooking.service.role.RoleServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RoleController {

    private final RoleServiceImpl roleService;
    public RoleController(RoleServiceImpl roleService){
        this.roleService = roleService;
    }


    @GetMapping("/role/list")
    public String listRoles(Model model) {
        List<Role> roles = roleService.list();
        model.addAttribute("roles", roles);
        return "/role/roleList";
    }

    @GetMapping("/role/create")
    public String createRoleFormula(Model model){
        // initialise a Role to give in the template
        Role role = new Role();
        //pass the role in the model and from that to the template
        model.addAttribute("role", role);
        return "/role/roleFormula";
    }

    @PostMapping("/role/save")
    public String saveRole(@ModelAttribute("role") Role role) {
        roleService.add(role);
        return "redirect:/role/list";
    }
}
