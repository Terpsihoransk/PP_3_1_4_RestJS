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

    @GetMapping
    public String allUsers () {
        return "user";
    }


}
