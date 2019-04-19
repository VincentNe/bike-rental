package com.csharp.bikerental.persistence.model.Subscriptions;

import javax.persistence.Entity;

@Entity
public class PayAsYouGoSubscription extends  Subscription {


    //region Getters and Setters



    //endregion

    public PayAsYouGoSubscription(){

    }
    public PayAsYouGoSubscription(int maxConcurrentUsers,SubscriptionEnum subType){
       super(maxConcurrentUsers,subType);

    }

    @Override
    public boolean isSubscriptionExpired() {
        return false;
    }

    @Override
    public boolean canSubscriptionBeUsed() {
        if(currentUses < maxConcurrentUsers) return true;
        return false;
    }

    @Override
    public void useSubscription() {
        if(currentUses < maxConcurrentUsers){
            currentUses++;
            timesUsed++;
        }
        else{
            System.out.print("Max Concurrent uses is reached");
        }
    }

    @Override
    public void stopUsingSubscription() {
        currentUses--;
    }

    @Override
    public int timesUsed() {
        return timesUsed;
    }
}
