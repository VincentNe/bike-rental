package com.csharp.bikerental.Service;

import com.csharp.bikerental.BikeRentalApplication;
import com.csharp.bikerental.persistence.model.*;
import com.csharp.bikerental.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;
import javax.validation.constraints.AssertTrue;
import java.util.concurrent.atomic.AtomicBoolean;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { BikeRentalApplication.class })
public class SubscriptionServiceTest {

    @Autowired
    public UserService userService;

    private User u;


    @Before
    public void setup(){
        u = new Customer("Customer1","UsernameExample","pass");
        userService.saveUser(u);
    }


    @Test
    public void buyAPayAsYouGoSubscriptionAsACustomer(){


        userService.buySubcription(u.getUsername(),new Payment(), SubscriptionEnum.PayAsYouGo);
        Long userId   = u.getId();
        User u = userService.getUser(userId);
        Customer customer = (Customer) u;
        Subscriptions subscriptions = customer.getSubscriptions();
        AtomicBoolean containsSubscription = new AtomicBoolean(false);
        subscriptions.getSubscriptions().forEach(subscription ->  {
            if(subscription instanceof  PayAsYouGoSubscription){
                containsSubscription.set(true);
            }
        });
        Boolean result = containsSubscription.get();
        Assert.assertTrue(result);
    }

    @Test
    public void buyAAnnualSubscriptionAsACustomer(){
        userService.buySubcription(u.getUsername(),new Payment(), SubscriptionEnum.AnnualSubscription);

        Subscriptions subscriptions = ((Customer) userService.getUser(u.getId())).getSubscriptions();
        AtomicBoolean containsSubscription = new AtomicBoolean(false);
        subscriptions.getSubscriptions().forEach(subscription ->  {
            if(subscription instanceof  AnnualSubscription){
                containsSubscription.set(true);
            }
        });
        Assert.assertTrue(containsSubscription.get());
    }
    @After
    public void remove(){
        userService.removeUser(u.getId());
    }
}
