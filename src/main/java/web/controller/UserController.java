package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = {"/", "/index"})
    public String login (Model model) {
        model.addAttribute("usersList", userService.getAllUsers());
        return "index";
    }

    @GetMapping(value = {"/admin"})
    public String index (Model model) {
        model.addAttribute("usersList", userService.getAllUsers());
        return "index";
    }

    @DeleteMapping("/admin/{id}")
    public String deleteUser (@PathVariable(value = "id") long id) {
        userService.removeUserById(id);
        return "redirect:/admin";
    }

    @PatchMapping("/admin/{id}")
    public String updateUser (@PathVariable(value = "id") long id, @ModelAttribute("User") User user) {
        userService.update(user, id);
        return "redirect:/admin";
    }

    @GetMapping("/admin/{id}/update")
    public String getUser (@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "update";
    }

    @GetMapping("/admin/user")
    public String newUser (Model model) {
        model.addAttribute("user", new User());
        return "user";
    }

    @PostMapping("/admin/user")
    public String saveUser (@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/user")
    public String userInfo (@CurrentSecurityContext(
            expression = "authentication.principal") User principal, Model model) {
        model.addAttribute("user", principal);
        return "user-info";
    }
}
