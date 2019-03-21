package com.csharp.bikerental.persistence.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class TwoWheel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    String twoWheelType;

   public TwoWheel(){}
    public TwoWheel(String twoWheelType){
        this.twoWheelType =twoWheelType;
    }

    // Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void select(){}

    public String getTwoWheelType() {
        return twoWheelType;
    }


    public void setTwoWheelType(String twoWheelType) {
        this.twoWheelType = twoWheelType;
    }
}
