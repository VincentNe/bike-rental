package com.csharp.bikerental.service.UserService;

import com.csharp.bikerental.persistence.model.*;
import com.csharp.bikerental.persistence.model.Subscriptions.AnnualSubscription;
import com.csharp.bikerental.persistence.model.Subscriptions.PayAsYouGoSubscription;
import com.csharp.bikerental.persistence.model.Subscriptions.Subscription;
import com.csharp.bikerental.persistence.model.Subscriptions.SubscriptionEnum;
import com.csharp.bikerental.persistence.model.Employee;
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
public interface UserServiceFacadeInterface {
    public boolean rentBike(String Username,Long standId);
    public void saveUser(User u);
    public User getUser(Long id);
    public User getUserByUsername(String username);
    public void removeUser(Long id);
    public UserDetails loadUserByUsername(String username) ;

    public UserEdit editUser( String username);

    public UserEdit undoEdit( String username);

    void returnBike(String username, Long standId, String bikeId);
}
