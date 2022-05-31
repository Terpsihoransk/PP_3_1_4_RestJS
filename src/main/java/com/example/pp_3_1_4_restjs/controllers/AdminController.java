package com.example.pp_3_1_4_restjs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public String allUsers () {
        return "admin";
    }

}
