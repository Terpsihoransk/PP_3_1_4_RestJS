package com.example.pp_3_1_4_restjs.controllers;

import com.example.pp_3_1_4_restjs.models.User;
import com.example.pp_3_1_4_restjs.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/porn")
public class PornRestController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public PornRestController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }


//    @GetMapping
//    public String checkAge(Model model, User user) {
//        model.addAttribute("user", userServiceImpl.findByUsername(userServiceImpl.getCurrentUsername()));
//        return "/porn";
//    }

    @GetMapping("/porn/{age}")
    public String checkAge(@PathVariable("age") int age, User user, Model model) {
        model.addAttribute("user", userServiceImpl.findByUsername(userServiceImpl.getCurrentUsername()));
        String str = userServiceImpl.getCurrentUsername();
        return "porn";
    }
}
