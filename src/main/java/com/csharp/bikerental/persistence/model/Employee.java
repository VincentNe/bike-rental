package com.csharp.bikerental.persistence.model;

import com.csharp.bikerental.persistence.model.Station.Stand;
import com.csharp.bikerental.persistence.model.Subscriptions.Subscription;
import com.csharp.bikerental.persistence.model.Subscriptions.Subscriptions;
import com.csharp.bikerental.persistence.model.TwoWheel.TwoWheel;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import javax.persistence.*;


@Entity
public class Employee extends  User{

    public Employee() {

    }
    public Employee( String name,String username,String password){
        super(name, username,password);

    }


    @Override
    public boolean rentbike(Stand s) {

        return true ;
    }

    @Override
    public boolean returnBike(String twoWheelId) {
        return false;
    }


}
