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
    private String seat;
    private String light;
    private String Speedometer;

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

    @Override
    public String getSeat() {
        return seat;
    }

    @Override
    public void setSeat(String seat) {
        this.seat = seat;
    }

    @Override
    public String getLight() {
        return light;
    }

    @Override
    public void setLight(String light) {
        this.light = light;
    }

    @Override
    public String getSpeedometer() {
        return Speedometer;
    }

    @Override
    public void setSpeedometer(String speedometer) {
        Speedometer = speedometer;
    }
}
