package com.csharp.bikerental.config;

import com.csharp.bikerental.persistence.model.Customer;
import com.csharp.bikerental.persistence.model.Employee;
import com.csharp.bikerental.persistence.model.Employee;
import com.csharp.bikerental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DemoData {

    @Autowired
    private UserService userRepo;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {

        userRepo.saveUser(new Customer("Customer Name","custy","pass"));
        userRepo.saveUser(new Employee("Employer Name","employe","pass"));
    }
}
