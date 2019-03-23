package com.csharp.bikerental.persistence.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Entity
@Table(name = "subscriptions")
public class Subscriptions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subscriptionsID")
    private long subscriptionsID;

    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Subscription> subscriptions;

    //region Getters and Setters

    public long getId() {
        return subscriptionsID;
    }

    public void setId(long subscriptionsID) {
        this.subscriptionsID = subscriptionsID;
    }

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
