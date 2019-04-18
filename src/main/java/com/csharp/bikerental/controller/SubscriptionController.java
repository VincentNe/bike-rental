package com.csharp.bikerental.controller;

import com.csharp.bikerental.persistence.model.Subscriptions.Subscription;
import com.csharp.bikerental.persistence.model.Subscriptions.SubscriptionEnum;
import com.csharp.bikerental.service.SubscriptionService.*;
import com.csharp.bikerental.service.UserService.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SubscriptionController {

    @Autowired
    private SubscriptionServiceFacadeInterface subscriptionService;

    @GetMapping("/Subscriptions")
    public String StationOverview(Model model){
        model.addAttribute("subscriptions", subscriptionService.getUserSubscriptions(getUsername()));
        return "subscription";
    }
    @PostMapping("/AddSubscription")
    public String addSubscription(@RequestParam(name = "subscription") String subscription, Model model){
        switch (subscription){
            case "Pay As You Go":
                subscriptionService.buySubcription(getUsername(),null, SubscriptionEnum.PayAsYouGo);
                break;
            case "Annual Subscription":
                subscriptionService.buySubcription(getUsername(),null, SubscriptionEnum.AnnualSubscription);
                break;
            case "Month Subscription":
                subscriptionService.buySubcription(getUsername(),null, SubscriptionEnum.MonthSubscription);
                break;
        }
        return StationOverview(model);
    }
    private String getUsername(){
        return ((UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
    }
}
