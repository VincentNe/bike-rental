package com.csharp.bikerental.service.UserService;

import com.csharp.bikerental.persistence.model.*;
import com.csharp.bikerental.persistence.model.Subscriptions.AnnualSubscription;
import com.csharp.bikerental.persistence.model.Subscriptions.PayAsYouGoSubscription;
import com.csharp.bikerental.persistence.model.Subscriptions.Subscription;
import com.csharp.bikerental.persistence.model.Subscriptions.SubscriptionEnum;
import com.csharp.bikerental.persistence.model.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User.UserBuilder;
import com.csharp.bikerental.persistence.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("userServiceFacadeImpl")
public class UserServiceFacadeImpl implements UserDetailsService,UserServiceFacadeInterface {


    @Qualifier("userServiceImpl")
    @Autowired
    UserServiceInterface userService;

    public boolean rentBike(Long userId){
    	return userService.rentBike(userId);
    }
    public void saveUser(User u){
    	userService.saveUser(u);
    }
    public User getUser(Long id){
        return  userService.getUser(id);
    }
    public User getUserByUsername(String username){
        return  userService.getUserByUsername(username);
    }
    public void removeUser(Long id){

    	userService.removeUser(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        
        return userService.loadUserByUsername(username);
    }


    public UserEdit editUser( String username){
       
        return userService.editUser(username);

    }

    public UserEdit undoEdit( String username) {
        
        return userService.undoEdit(username) ;

    }

}
