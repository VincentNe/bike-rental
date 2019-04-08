package com.csharp.bikerental.service;

import com.csharp.bikerental.persistence.model.*;
import com.csharp.bikerental.persistence.model.Employe;
import org.springframework.security.core.userdetails.User.UserBuilder;
import com.csharp.bikerental.persistence.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    public boolean buySubcription(String username,Payment payment, SubscriptionEnum subscriptionEnum){
        Customer u = (Customer) userRepository.findByUsername(username);
        if(u==null) return false;
        Subscription subscription = null;

        //TODO change to Factory method or Prototype
        switch (subscriptionEnum){
            case AnnualSubscription:
                subscription = new AnnualSubscription(1,new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()+31536000000l));
                break;
            case PayAsYouGo:
                subscription = new PayAsYouGoSubscription(1);
                break;
            case MonthSubscription:
                subscription = new AnnualSubscription(1, new Date(18,8,1),new Date(18,9,1));
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


    public List<Subscription> getUserSubscriptions(String username) {
        User user = userRepository.findByUsername(username);
        Customer customer = null;
        try {
            customer = (Customer) user;
        }catch (ClassCastException e){
            System.out.println("Not a correct customer");
        }
        return customer.getSubscriptions().getSubscriptions();
    }
}
