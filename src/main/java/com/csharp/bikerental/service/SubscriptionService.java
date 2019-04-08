package com.csharp.bikerental.service;

import com.csharp.bikerental.persistence.model.Customer;
import com.csharp.bikerental.persistence.model.Subscription;
import com.csharp.bikerental.persistence.model.SubscriptionEnum;
import com.csharp.bikerental.persistence.model.User;
import com.csharp.bikerental.persistence.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService   {

    @Autowired
    private UserService userService;



}
