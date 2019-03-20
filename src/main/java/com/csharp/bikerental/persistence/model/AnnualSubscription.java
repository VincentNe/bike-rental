package com.csharp.bikerental.persistence.model;

import java.util.Date;

public class AnnualSubscription extends Subscription {

    private Date beginDate;
    private Date expireDate;


    public AnnualSubscription(Date beginDate, Date expireDate){
        this.beginDate = beginDate;
        this.expireDate = expireDate;
    }

    @Override
    public boolean isSubscriptionValid() {
        return expireDate.before(new Date(System.currentTimeMillis()));
    }

    @Override
    public void useSubscription(Bike bike) {

    }
}
