package com.csharp.bikerental.dto;

import com.csharp.bikerental.persistence.model.Subscriptions.Subscription;

public class SubscriptionDto {
    private String name;
    private boolean IsAvailable;
    private  boolean isExpired;
    private int timesUsed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return IsAvailable;
    }

    public void setAvailable(boolean available) {
        IsAvailable = available;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    public int getTimesUsed() {
        return timesUsed;
    }

    public void setTimesUsed(int timesUsed) {
        this.timesUsed = timesUsed;
    }

    public SubscriptionDto(){

    }
}
