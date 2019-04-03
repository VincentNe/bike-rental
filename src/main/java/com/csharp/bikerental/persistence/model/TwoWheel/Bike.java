package com.csharp.bikerental.persistence.model.TwoWheel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bike extends TwoWheel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

     private String twoWheelType = "Bike";

    public Bike(String twoWheelType) {
        this.twoWheelType  = twoWheelType;
    }

    public Bike(){}


    //region Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getTwoWheelType() {
        return twoWheelType;
    }

    @Override
    public void setTwoWheelType(String twoWheelType) {
        this.twoWheelType = twoWheelType;
    }

    @Override
    public void select() {
        System.out.println("Bike");
    }

}
