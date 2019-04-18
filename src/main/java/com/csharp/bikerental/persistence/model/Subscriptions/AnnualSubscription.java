package com.csharp.bikerental.persistence.model.Subscriptions;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class AnnualSubscription extends Subscription {

    private Date beginDate;
    private Date expireDate;

    //region Getters and setters

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    //endregion

    public AnnualSubscription(){}

    public AnnualSubscription(int maxConcurrentUsers,Date beginDate, Date expireDate, SubscriptionEnum subType){
        super(maxConcurrentUsers,subType);
        this.beginDate = beginDate;
        this.expireDate = expireDate;
    }

    @Override
    public boolean isSubscriptionExpired() {
        boolean result = expireDate.before(new Date(System.currentTimeMillis()));
        return result;
    }

    @Override
    public boolean canSubscriptionBeUsed() {
        if(maxConcurrentUsers > currentUses) return true;
        return false;
    }

    @Override
    public void useSubscription() {
        if(currentUses < maxConcurrentUsers ){
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
