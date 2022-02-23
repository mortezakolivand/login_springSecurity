package com.mk.login.controller;

import com.mk.login.model.User;
import com.mk.login.repository.UserRepository;
import com.mk.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private UserService userService;


    @GetMapping("")
    public String viewHomePage(Model model){
        model.addAttribute("user" , new User());
        return "index";
    }

    @GetMapping("/register")
    public String showingSignUpForm(Model model){
    model.addAttribute("user" , new User());
    return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(User user){
       userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/list_users")
    public String viewUsersList(Model model){
        List<User> listUsers =   userService.findAll();
        model.addAttribute("listUsers",listUsers);
        return "users" ;
    }

}
