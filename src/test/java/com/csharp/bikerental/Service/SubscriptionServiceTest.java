package com.csharp.bikerental.Service;

import com.csharp.bikerental.BikeRentalApplication;
import com.csharp.bikerental.dto.SubscriptionDto;
import com.csharp.bikerental.persistence.model.*;
import com.csharp.bikerental.persistence.model.Subscriptions.*;
import com.csharp.bikerental.service.SubscriptionService.SubscriptionServiceFacadeImpl;
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
@SpringBootTest(classes = { BikeRentalApplication.class })
public class SubscriptionServiceTest {

    @Autowired
    @Qualifier("userServiceFacadeImpl")
    private UserServiceFacadeInterface userServiceFacadeInterface = new UserServiceFacadeImpl();

    @Autowired
    private SubscriptionServiceFacadeInterface subscriptionServiceFacadeInterface = new SubscriptionServiceFacadeImpl();

    private User u;

    @Before
    public void setup(){
        u = new Customer("Customer1","UsernameExample","pass");
        userServiceFacadeInterface.saveUser(u);
    }
    @Test
    public void buyAPayAsYouGoSubscriptionAsACustomer(){
        subscriptionServiceFacadeInterface.buySubcription(u.getUsername(),new Payment(),SubscriptionEnum.PayAsYouGo);
        List<SubscriptionDto> subscriptions = subscriptionServiceFacadeInterface.getUserSubscriptions(u.getUsername());
        AtomicBoolean containsSubscription = new AtomicBoolean(false);
        subscriptions.forEach(subscription ->  {
            if(subscription.getName() == SubscriptionEnum.PayAsYouGo.name()){
                containsSubscription.set(true);
            }
        });
        Boolean result = containsSubscription.get();
        Assert.assertTrue(result);
    }

    @Test
    public void buyAAnnualSubscriptionAsACustomer(){
        subscriptionServiceFacadeInterface.buySubcription(u.getUsername(),new Payment(),SubscriptionEnum.AnnualSubscription);
        List<SubscriptionDto> subscriptions = subscriptionServiceFacadeInterface.getUserSubscriptions(u.getUsername());
        AtomicBoolean containsSubscription = new AtomicBoolean(false);
        subscriptions.forEach(subscription ->  {
            if(subscription.getName() == SubscriptionEnum.AnnualSubscription.name()){
                containsSubscription.set(true);
            }
        });
        Assert.assertTrue(containsSubscription.get());
    }
    @Test
    public void buyAMonthlySubscriptionAsACustomer(){
        subscriptionServiceFacadeInterface.buySubcription(u.getUsername(),new Payment(),SubscriptionEnum.MonthSubscription);
        List<SubscriptionDto> subscriptions = subscriptionServiceFacadeInterface.getUserSubscriptions(u.getUsername());
        AtomicBoolean containsSubscription = new AtomicBoolean(false);
        subscriptions.forEach(subscription ->  {
            if(subscription.getName() == SubscriptionEnum.MonthSubscription.name()){
                containsSubscription.set(true);
            }
        });
        Assert.assertTrue(containsSubscription.get());
    }

    @Test
    public void testInterceptor(){
        subscriptionServiceFacadeInterface.buySubcription(u.getUsername(),new Payment(),SubscriptionEnum.AnnualSubscription);
        SubscriptionDispatcher.getInstanceOfDispatcher().registerDispatcher(new ConcreteInterceptor());
        userServiceFacadeInterface.rentBike(u.getId());

        List<SubscriptionDto> subscriptions = subscriptionServiceFacadeInterface.getUserSubscriptions(u.getUsername());
        AtomicBoolean containsSubscription = new AtomicBoolean(false);
        subscriptions.forEach(subscription ->  {
            if(subscription.getName() == SubscriptionEnum.AnnualSubscription.name()){
                containsSubscription.set(true);
            }
        });
        Assert.assertTrue(containsSubscription.get());
    }

    @After
    public void remove(){
        userServiceFacadeInterface.removeUser(u.getId());
    }
}
