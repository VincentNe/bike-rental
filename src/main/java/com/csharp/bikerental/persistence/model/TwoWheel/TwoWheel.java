package com.csharp.bikerental.persistence.model.TwoWheel;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class TwoWheel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    String twoWheelType;

   public TwoWheel(){}
    public TwoWheel(String twoWheelType){
        this.twoWheelType =twoWheelType;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getTwoWheelType() {
        return twoWheelType;
    }


    public void setTwoWheelType(String twoWheelType) {
        this.twoWheelType = twoWheelType;
    }
    public abstract void select();






}
