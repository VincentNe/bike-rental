package com.csharp.bikerental.persistence.model;

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

    public AnnualSubscription(Date beginDate, Date expireDate){
        this.beginDate = beginDate;
        this.expireDate = expireDate;
    }

    @Override
    public boolean isSubscriptionValid() {
        return expireDate.before(new Date(System.currentTimeMillis()));
    }

    @Override
    public void useSubscription() {

    }
}
