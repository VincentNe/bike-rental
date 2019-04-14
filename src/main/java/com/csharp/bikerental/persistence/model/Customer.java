package com.csharp.bikerental.persistence.model;

import com.csharp.bikerental.persistence.model.Subscriptions.Subscription;
import com.csharp.bikerental.persistence.model.Subscriptions.SubscriptionEnum;
import com.csharp.bikerental.persistence.model.Subscriptions.Subscriptions;

import javax.persistence.*;

@Entity
public class Customer extends User{

    @OneToOne(cascade=CascadeType.ALL)
    private Subscriptions subscriptions;

    //region Getters and Setters
    public Subscriptions getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Subscriptions subscriptions) {
        this.subscriptions = subscriptions;
    }
    //endregion

    public Customer() {
        super();

    }
    public Customer(String name,String username,String password){
        super(name, username,password);
        subscriptions = new Subscriptions();
    }

    @Override
    public boolean rentbike() {
        //TODO add bike as rented
        if(!subscriptions.useSubscription());
        return true;
    }
    public void addSubscription(SubscriptionEnum subscriptionEnum){
        subscriptions.addSubscription(subscriptionEnum);
    }



}
