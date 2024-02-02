package dev.triamylo.workingplacebooking.controller;

import dev.triamylo.workingplacebooking.model.Role;
import dev.triamylo.workingplacebooking.service.role.RoleServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RoleController {

    private final RoleServiceImpl roleService;

    public RoleController(RoleServiceImpl roleService) {
        this.roleService = roleService;
    }


    @GetMapping("/role/list")
    public String listRoles(Model model) {
        List<Role> roles = roleService.list();
        model.addAttribute("roles", roles);
        return "/role/roleList";
    }

    @GetMapping("/role/create")
    public String createRoleFormula(Model model) {
        // initialise a Role to give in the template
        Role role = new Role();
        //pass the role in the model and from that to the template
        model.addAttribute("role", role);
        return "/role/roleFormula";
    }

    @PostMapping("/role/save")
    public String saveRole(@ModelAttribute("role") Role role) {

        //if it's a new role
        if (role.getId() == null || role.getId().isEmpty()) {
            roleService.add(role);
        }
        //if it's existing we make update
        else {
            roleService.update(role);
        }

        return "redirect:/role/list";
    }

    @GetMapping("/role/delete/{id}")
    public String deleteRole(@PathVariable String id) {
        roleService.delete(roleService.get(id));
        return "redirect:/role/list";
    }

    @GetMapping("/role/update/{id}")
    public String updateRole(@PathVariable String id, Model model) {
        Role role = roleService.get(id);
        model.addAttribute("role", role);
        return "role/roleFormula";
    }

}
