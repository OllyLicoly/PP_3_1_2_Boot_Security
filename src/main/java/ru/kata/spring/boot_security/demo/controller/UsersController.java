package ru.kata.spring.boot_security.demo.controller;

import ru.kata.spring.boot_security.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;
import ru.kata.spring.boot_security.demo.service.UserService;

//@Controller
//@RequestMapping(value = "/users")
@RestController
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/authenticated")
    public String authenticatedUserPage(){
        return "user";
    }


//    @GetMapping
//    public String printUsers(ModelMap model) {
//        model.addAttribute("users", userService.getAllUsers());
//
//        return "users";
//    }
//
//    @GetMapping("/delete")
//    public String deleteUser(@RequestParam("id") Long id) {
//        userService.deleteUser(id);
//        return "redirect:/users";
//    }
//
//    @GetMapping("/update")
//    public String updateUser(@RequestParam("id") Long id, Model model ){
//        User user = userService.getUser(id);
//        model.addAttribute("user", user);
//        return "userupdate";
//    }
//
//    @PostMapping("/update")
//    public String updateUser(@ModelAttribute("user") User user) {
//        userService.save(user);
//        return "redirect:/users";
//    }
//
//    @GetMapping("/add")
//    public String addUser(@ModelAttribute("user") User user ){
//        return "useradd";
//    }
//
//    @PostMapping("/add")
//    public String addNewUser(@ModelAttribute("user") User user) {
//        userService.save(user);
//        return "redirect:/users";
//    }
}
