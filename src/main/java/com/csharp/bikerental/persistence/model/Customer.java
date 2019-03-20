package com.csharp.bikerental.persistence.model;

import javax.persistence.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Entity
public class Customer extends User{

    @OneToOne
    private Subscriptions subscriptions;

    //region Getters and Setters
    public Subscriptions getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Subscriptions subscriptions) {
        this.subscriptions = subscriptions;
    }
    //endregion

    public Customer(String name){
        super(name);
        subscriptions = new Subscriptions();
    }

    @Override
    public boolean rentbike() {
        //TODO add bike as rented
        if(!subscriptions.useSubscription());
        return true;
    }

    public void addSubscription(Subscription subscription){
        subscriptions.addSubscription(subscription);
    }


}
