package com.csharp.bikerental.persistence.model;

import javax.persistence.Entity;

@Entity
public class PayAsYouGoSubscription extends  Subscription {

    private  boolean isBeenUsed;

    //region Getters and Setters

    public boolean isBeenUsed() {
        return isBeenUsed;
    }

    public void setBeenUsed(boolean beenUsed) {
        isBeenUsed = beenUsed;
    }


    //endregion

   public PayAsYouGoSubscription(){

   }

    @Override
    public boolean isSubscriptionValid() {
        return !isBeenUsed;
    }

    @Override
    public void useSubscription() {
        isBeenUsed = true;
    }
}
