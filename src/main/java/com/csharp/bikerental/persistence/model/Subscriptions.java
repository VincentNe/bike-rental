package com.csharp.bikerental.persistence.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Entity
public class Subscriptions {
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<Subscription> subscriptions;

    //region Getters and Setters
    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
    //endregion

    public Subscriptions(){
        subscriptions = new ArrayList<>();
    }

    public void addSubscription(Subscription subscription){
        subscriptions.add(subscription);
    }

    public boolean hasValidSubscription(){
        AtomicBoolean result = new AtomicBoolean(false);
        subscriptions.forEach(subscription -> {
            if(subscription.isSubscriptionValid()) {
                result.set(true);
            }
        });
        return result.get();
    }
    public boolean useSubscription(){
        AtomicBoolean result = new AtomicBoolean(false);
        subscriptions.forEach(subscription -> {
            if(subscription.isSubscriptionValid()) {
                subscription.useSubscription();
                result.set(true);
            }
        });
        return result.get();
    }

}
