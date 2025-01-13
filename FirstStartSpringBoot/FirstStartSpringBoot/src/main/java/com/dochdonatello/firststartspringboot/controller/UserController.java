package com.dochdonatello.firststartspringboot.controller;

import com.dochdonatello.firststartspringboot.models.User;
import com.dochdonatello.firststartspringboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String index(Model model)
    {
        var listUser = userService.getAllUserActive();
        model.addAttribute("users", listUser);
        return "admin/user/index";
    }

    @GetMapping("/users/add")
    public String add(Model model)
    {
        model.addAttribute("user", new User());
        return "admin/user/form";
    }

    @PostMapping("/users/create")
    public String create(@ModelAttribute ("user") User user)
    {
        userService.insertAndUpdate(user);
        return "redirect:/admin/users";
    }
}
