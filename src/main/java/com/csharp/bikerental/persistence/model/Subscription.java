package com.csharp.bikerental.persistence.model;

public abstract class Subscription {

    public abstract boolean isSubscriptionValid();
    public abstract void useSubscription(Bike bike);
}
