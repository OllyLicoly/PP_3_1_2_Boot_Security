package ru.kata.spring.boot_security.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String showMainPage() {
        return "index";
    }

    @GetMapping("/login")
    public String logIn(){
        return "login";
    }

    @GetMapping("/logout")
    public String logOut(){
        return "logOut";
    }
}
