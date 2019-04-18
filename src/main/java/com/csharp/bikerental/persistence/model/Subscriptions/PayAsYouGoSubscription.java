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
    public boolean isSubscriptionValid() {
        return false;
    }

    @Override
    public boolean canSubscriptionBeUsed() {
        if(maxConcurrentUsers >= currentUses) return true;
        return false;
    }

    @Override
    public void useSubscription() {
        if(maxConcurrentUsers > currentUses) currentUses++;
        else{
            System.out.print("Max Concurrent uses is reached");
        }
    }

    @Override
    public void stopUsingSubscription() {
        if(currentUses>0)return;
        currentUses--;
    }

    @Override
    public int timesUsed() {
        return 0;
    }
}
