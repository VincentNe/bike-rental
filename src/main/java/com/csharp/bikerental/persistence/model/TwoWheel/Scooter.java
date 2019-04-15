package com.csharp.bikerental.persistence.model.TwoWheel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Scooter extends TwoWheel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private Boolean seat;
    private Boolean lights;
    private String Speedometer;

    private String twoWheelType = "Scooter";

    public Scooter(String twoWheelType) {
        this.twoWheelType  = twoWheelType;
    }

    public Scooter(){}

    //region Getters and Setters


    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public Boolean getSeat() {
        return seat;
    }

    @Override
    public void setSeat(Boolean seat) {
        this.seat = seat;
    }

    @Override
    public Boolean getLights() {
        return lights;
    }

    @Override
    public void setLights(Boolean lights) {
        this.lights = lights;
    }

    @Override
    public String getSpeedometer() {
        return Speedometer;
    }

    @Override
    public void setSpeedometer(String speedometer) {
        Speedometer = speedometer;
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
        System.out.println("Scooter");
    }


}
