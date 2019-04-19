package com.csharp.bikerental.persistence.model.TwoWheel;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class TwoWheel {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String identifier;

    String twoWheelType;
    private  String id;
    private Boolean seat;
    private Boolean lights;
    private String Speedometer;



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

    public String getSpeedometer() {
        return Speedometer;
    }

    public void setSpeedometer(String speedometer) {
        Speedometer = speedometer;
    }

    public String getTwoWheelType() {
        return twoWheelType;
    }


    public void setTwoWheelType(String twoWheelType) {
        this.twoWheelType = twoWheelType;
    }
    public abstract void select();

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
