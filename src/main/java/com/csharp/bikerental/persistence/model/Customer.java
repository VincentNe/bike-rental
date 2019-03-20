package com.csharp.bikerental.persistence.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Entity
public class Customer extends User{

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<Subscription> subscriptions;

    public Customer(String name){
        super(name);


    }

    public void addSubscription(Subscription subscription){
        subscriptions.add(subscription);
    }
    public boolean hasValidSubscription(){
        AtomicBoolean result = new AtomicBoolean(false);
        subscriptions.forEach(subscription -> {
            if(hasValidSubscription()) result.set(true);
        });
        return result.get();
    }

}
