package com.csharp.bikerental.controller;

import com.csharp.bikerental.service.SubscriptionService;
import com.csharp.bikerental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SubscriptionController {

    @Autowired
    UserService userService;

    @GetMapping("/Subscriptions")
    public String StationOverview(Model model){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("subscriptions", userService.getUserSubscriptions(userDetails.getUsername()));
        return "subscription";
    }
    @PostMapping("/AddSubscription")
    public String addSubscription(Model model){


        return "subscription";
    }
}
