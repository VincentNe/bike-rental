package com.csharp.bikerental.config;

import com.csharp.bikerental.persistence.model.Customer;
import com.csharp.bikerental.persistence.model.Employee;
import com.csharp.bikerental.persistence.model.Subscriptions.SubscriptionEnum;
import com.csharp.bikerental.service.SubscriptionService.*;

import com.csharp.bikerental.persistence.model.Employee;

import com.csharp.bikerental.service.UserService.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DemoData {

    @Qualifier("userServiceFacadeImpl")
    @Autowired
    private UserServiceFacadeInterface userRepo;

    @Qualifier("subscriptionServiceFacadeImpl")
    @Autowired
    private SubscriptionServiceFacadeInterface subscriptionService;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {

        userRepo.saveUser(new Customer("Customer Name","custy","pass"));
        userRepo.saveUser(new Employee("Employer Name","employe","pass"));

        subscriptionService.buySubcription("custy",null, SubscriptionEnum.PayAsYouGo);
        subscriptionService.buySubcription("custy",null, SubscriptionEnum.AnnualSubscription);
        subscriptionService.buySubcription("custy",null, SubscriptionEnum.MonthSubscription);

    }
}
