package com.csharp.bikerental.persistence.model;

import com.csharp.bikerental.persistence.model.Station.Stand;
import com.csharp.bikerental.persistence.model.Subscriptions.Subscription;
import com.csharp.bikerental.persistence.model.Subscriptions.SubscriptionEnum;
import com.csharp.bikerental.persistence.model.Subscriptions.Subscriptions;
import com.csharp.bikerental.persistence.model.TwoWheel.TwoWheel;

import javax.persistence.*;

@Entity
public class Customer extends User{

    @OneToOne(cascade=CascadeType.ALL)
    private Subscriptions subscriptions;

    //region Getters and Setters
    public Subscriptions getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Subscriptions subscriptions) {
        this.subscriptions = subscriptions;
    }
    //endregion

    public Customer() {
        super();

    }
    public Customer(String name,String username,String password){
        super(name, username,password);
        subscriptions = new Subscriptions();
    }

    @Override
    public boolean rentbike(Stand s) {
        Subscription sub = subscriptions.useSubscription();
        if(sub !=null ){
            this.twoWheel.add(new Rental( s.takeoutBike(), sub));
            return true;
        }
        return false;
    }
    @Override
    public boolean returnBike(String twoWheelId){
        for (Rental temp: this.twoWheel) {
            String tempId = temp.getT().getIdentifier();
            if(tempId.trim().equals(twoWheelId.trim())){
                this.twoWheel.remove(temp);
                //subscriptions.stopUsingSubscription();
                temp.getS().stopUsingSubscription();
                return true;
            }
        }

        return  false;
    }
    public void addSubscription(SubscriptionEnum subscriptionEnum){
        subscriptions.addSubscription(subscriptionEnum);
    }



}
