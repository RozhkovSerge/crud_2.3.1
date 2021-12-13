package edu.segeyrozhkov.crud.app.controllers;

import edu.segeyrozhkov.crud.app.model.User;
import edu.segeyrozhkov.crud.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers(Model model) { //done
        model.addAttribute("user", new User());
        model.addAttribute("userList", userService.userList());
        model.addAttribute("title", "Add user");
        return "users";
    }

    @GetMapping("/{id}/edit")
    String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("title", "Edit user");
        return "/edit";
    }

    @PostMapping("/{id}")
    public String add(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.add(user);
        return "redirect:/users";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable(name = "id") int id) {
        userService.removeUser(id);
        return "redirect:/users";
    }

}
