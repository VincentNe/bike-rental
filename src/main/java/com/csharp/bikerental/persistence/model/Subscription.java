package com.csharp.bikerental.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    protected int timesUsed;
    protected int currentUses;

    protected int maxConcurrentUsers;
    //region Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTimesUsed() {
        return timesUsed;
    }

    public void setTimesUsed(int timesUsed) {
        this.timesUsed = timesUsed;
    }

    public int getCurrentUses() {
        return currentUses;
    }

    public void setCurrentUses(int currentUses) {
        this.currentUses = currentUses;
    }

    public int getMaxConcurrentUsers() {
        return maxConcurrentUsers;
    }

    public void setMaxConcurrentUsers(int maxConcurrentUsers) {
        this.maxConcurrentUsers = maxConcurrentUsers;
    }

    //endregion

    public Subscription(){
    }
    public Subscription(int maxConcurrentUsers){
        this.maxConcurrentUsers = maxConcurrentUsers;
    }
    //BASED ON DATE
    public abstract boolean isSubscriptionValid();
    //BASED ON NUMBER OF USERS
    public abstract boolean canSubscriptionBeUsed();

    // When bike is being rent with subscription
    public abstract void useSubscription();
    // When bike is returned
    public abstract void stopUsingSubscription();

    public abstract int timesUsed();


}
