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
    private Boolean seat;
    private Boolean lights;
    private String Speedometer;

     private String twoWheelType = "Bike";

    public Bike(String twoWheelType) {
        this.twoWheelType  = twoWheelType;
    }

    public Bike(){}


    //region Getters and Setters



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
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public Boolean getSeat() {
        return seat;
    }

    public void setSeat(Boolean seat) {
        this.seat = seat;
    }

    public Boolean getLights() {
        return lights;
    }

    public void setLights(Boolean lights) {
        this.lights = lights;
    }

    @Override
    public String getSpeedometer() {
        return Speedometer;
    }

    public void setSpeedometer(String speedometer) {
        Speedometer = speedometer;
    }
}
