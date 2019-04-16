package com.csharp.bikerental.service;

import com.csharp.bikerental.persistence.model.*;
import com.csharp.bikerental.persistence.model.Employee;
import org.springframework.security.core.userdetails.User.UserBuilder;
import com.csharp.bikerental.persistence.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    Payment payments;

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
        //Adding payment stub
        payments.setAmount(1000);
        payments.setUserId(userId);
        
        
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        UserBuilder builder = null;
        builder = org.springframework.security.core.userdetails.User.withUsername(username);
        //builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
        builder.password(user.getPassword());
        //TODO Replace with something more dynamic
        if (user instanceof Customer){
            builder.authorities("ROLE_USER");
        }
        else{
            builder.authorities("ROLE_ADMIN");
        }

        return builder.build();
    }
}
