package com.csharp.bikerental.Service;

import com.csharp.bikerental.BikeRentalApplication;
import com.csharp.bikerental.persistence.model.*;
import com.csharp.bikerental.persistence.model.Subscriptions.*;
import com.csharp.bikerental.service.SubscriptionService.SubscriptionServiceFacadeInterface;
import com.csharp.bikerental.service.UserService.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@RunWith(SpringRunner.class)
//@ContextConfiguration(classes=Application.class)
//@SpringBootTest(classes = { BikeRentalApplication.class })
@DataJpaTest
public class SubscriptionServiceTest {


    @Qualifier("userServiceFacadeImpl")
    @Autowired
    public UserServiceFacadeInterface userServiceFacadeInterface;

    @Autowired
    public SubscriptionServiceFacadeInterface subscriptionServiceFacadeInterface;

    private User u;


    @Before
    public void setup(){
        u = new Customer("Customer1","UsernameExample","pass");
        userServiceFacadeInterface.saveUser(u);
    }
    @Test
    public void buyAPayAsYouGoSubscriptionAsACustomer(){
        subscriptionServiceFacadeInterface.buySubcription(u.getUsername(),new Payment(),SubscriptionEnum.PayAsYouGo);
        List<Subscription> subscriptions = subscriptionServiceFacadeInterface.getUserSubscriptions(u.getUsername());
        AtomicBoolean containsSubscription = new AtomicBoolean(false);
        subscriptions.forEach(subscription ->  {
            if(subscription instanceof PayAsYouGoSubscription){
                containsSubscription.set(true);
            }
        });
        Boolean result = containsSubscription.get();
        Assert.assertTrue(result);
    }
/*
    @Test
    public void buyAPayAsYouGoSubscriptionAsACustomer(){


        userService.buySubcription(u.getUsername(),new Payment(), SubscriptionEnum.PayAsYouGo);
        Long userId   = u.getId();
        User u = userService.getUser(userId);
        Customer customer = (Customer) u;
        Subscriptions subscriptions = customer.getSubscriptions();
        AtomicBoolean containsSubscription = new AtomicBoolean(false);
        subscriptions.getSubscriptions().forEach(subscription ->  {
            if(subscription instanceof PayAsYouGoSubscription){
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
            if(subscription instanceof AnnualSubscription){
                containsSubscription.set(true);
            }
        });
        Assert.assertTrue(containsSubscription.get());
    }
    */
    @After
    public void remove(){
        userServiceFacadeInterface.removeUser(u.getId());
    }
}
