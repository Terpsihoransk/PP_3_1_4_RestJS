package com.example.pp_3_1_4_restjs.controllers;

import com.example.pp_3_1_4_restjs.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    public final UserServiceImpl userServiceImpl;


    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }


    @GetMapping
    public String getUser(Principal principal, Model model) {
        model.addAttribute("user", userServiceImpl.findByUsername(userServiceImpl.getCurrentUsername()));
        return "user";
    }


}
