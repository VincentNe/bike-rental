package com.csharp.bikerental.persistence.model.Subscriptions;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
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

    @Transient
    private SubscriptionCache subscriptionCache = new SubscriptionCache();

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
                return;
            }
        });
        return result.get();
    }
    public boolean useSubscription(){
        SubscriptionDispatcher dispatcher = SubscriptionDispatcher.getInstanceOfDispatcher();
        dispatcher.preRequest(subscriptions);
        List<Subscription> subscriptionUsed = null;
        AtomicBoolean result = new AtomicBoolean(false);
        subscriptions.forEach(subscription -> {
            if(subscription.isSubscriptionValid()) {
                subscription.useSubscription();
                subscriptionUsed.add(subscription);
                result.set(true);
                return;
            }
        });
        dispatcher.postRequest(subscriptionUsed);
        return result.get();
    }
    public void addSubscription(SubscriptionEnum subscriptionEnum){
        Subscription subscription = subscriptionCache.getSubscription(subscriptionEnum);
        subscriptions.add(subscription);
    }

}
