package com.csharp.bikerental.persistence.model;

public class PayAsYouGoSubscription extends  Subscription {

    private  boolean isBeenUsed;


    @Override
    public boolean isSubscriptionValid() {
        return !isBeenUsed;
    }

    @Override
    public void useSubscription(Bike bike) {
        isBeenUsed = true;
    }
}
