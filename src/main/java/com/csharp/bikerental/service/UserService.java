package com.csharp.bikerental.service;

import com.csharp.bikerental.persistence.model.*;
import com.csharp.bikerental.persistence.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean buySubcription(Long userId,Payment payment, SubscriptionEnum subscriptionEnum){
        Customer u = (Customer) userRepository.findById(userId).get();
        if(u==null) return false;
        Subscription subscription = null;

        //TODO change to Factory method
        switch (subscriptionEnum){
            case AnnualSubscription:
                subscription = new AnnualSubscription(new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()+31536000000l));
                break;
            case PayAsYouGo:
                subscription = new PayAsYouGoSubscription();
                break;
        }
        u.addSubscription(subscription);
        userRepository.save(u);
        return false;
    }
    public boolean rentBike(Long userId){
        User u = userRepository.findById(userId).get();
        boolean result = u.rentbike();
        userRepository.save(u);
        return  result;
    }
    public void saveUser(User u){
        userRepository.save(u);
    }
    public User getUser(Long id){
        return  userRepository.findById(id).get();
    }
    public void removeUser(Long id){

         userRepository.deleteById(id);
    }

}
