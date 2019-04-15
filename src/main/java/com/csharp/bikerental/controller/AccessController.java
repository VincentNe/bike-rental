package com.csharp.bikerental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccessController {

    @GetMapping("/login")
    public String StationOverview(Model model){
        return "login";
    }

    @GetMapping("/home")
    public String homePage(Model model){
        return "index";
    }
}
