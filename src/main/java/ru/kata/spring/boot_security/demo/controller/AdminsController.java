package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.service.RoleServiceImp;
import ru.kata.spring.boot_security.demo.service.UserServiceImp;

//import javax.validation.Valid;

//@Controller
//@RequestMapping(value = "/users")
@Controller
@RequestMapping("/admin")
public class AdminsController {

    private final UserServiceImp userService;
    private final RoleServiceImp roleService;

    @Autowired
    public AdminsController(UserServiceImp userService, RoleServiceImp roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

//    @GetMapping(value = "")
//    public String authenticatedUserPage(){
//        return "user";
//    }


    @GetMapping(value = "")
    public String printUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());

        return "users";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.removeUserById(id);
        return "redirect:/admin";
    }

    @GetMapping("/update")
    public String updateUser(@RequestParam("id") Long id, Model model ){
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.getAllRoles());
        return "userupdate";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            model.addAttribute("roles", roleService.getAllRoles());
            return "userupdate";
        }
        user.setPassword(user.getPassword());userService.editUserById(user);
        return "redirect:/admin";
    }

//    @GetMapping("/admin/edit")
//    public String editUserById(@RequestParam(value = "id") Long id, Model model) {
//        model.addAttribute("user", userService.findUserById(id));
//        model.addAttribute("roles", roleService.getListOfRoles());
//        return "edit";
//    }
//
//    @PostMapping("/admin/save")
//    public String saveUser(@ModelAttribute("user") @Valid User user,
//                           BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("user", user);
//            model.addAttribute("roles", roleService.getListOfRoles());
//            return "edit";
//        }
//        user.setPassword(user.getPassword());
//        userService.editUserById(user);
//        return "redirect:/admin";
//    }

    @GetMapping("/add")
    public String addUser(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.getAllRoles());
        return "useradd";
    }

    @PostMapping("/add")
    public String addNewUser(@ModelAttribute("user") User user,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            model.addAttribute("roles", roleService.getAllRoles());
            return "useradd";
        }
        user.setPassword(user.getPassword());
        userService.addUser(user);
        return "redirect:/admin";
    }

//    @GetMapping("/admin/new")
//    public String createUserFrom(Model model) {
//        model.addAttribute("user", new User());
//        model.addAttribute("roles", roleService.getListOfRoles());
//        return "new";
//    }
//
//    @PostMapping("/admin/addUser")
//    public String addUser(@ModelAttribute("user") @Valid User user,
//                          BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("user", user);
//            model.addAttribute("roles", roleService.getListOfRoles());
//            return "new";
//        }
//        user.setPassword(user.getPassword());
//        userService.addUser(user);
//        return "redirect:/admin";
//    }
}
