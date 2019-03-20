package com.csharp.bikerental.service;

import com.csharp.bikerental.persistence.model.Customer;
import com.csharp.bikerental.persistence.model.Subscription;
import com.csharp.bikerental.persistence.model.SubscriptionEnum;
import com.csharp.bikerental.persistence.model.User;
import com.csharp.bikerental.persistence.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService  {

    @Autowired
    private UserRepository userRepository;

    public boolean buySubcription(Long userId , Subscription Subscription) throws Exception {
        Customer u = (Customer) userRepository.findById(userId).get();
        if(u==null) throw  new Exception("User does not exist");
        
        u.addSubscription(Subscription);
        return false;
    }
    public void getSubscription(){

    }
    public void getValidSubscription(){
        //TODO get valid subscription
    }
}
