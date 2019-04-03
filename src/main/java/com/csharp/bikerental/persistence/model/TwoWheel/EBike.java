package com.csharp.bikerental.persistence.model.TwoWheel;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EBike extends Bike implements Rechargeable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    String twoWheelType = "EBike";
    private String ExpectedKilometers;
    private String BatteryLevel;
    private String Watt;
    private String Capacity;

    public EBike(String twoWheelType) {
        this.twoWheelType  = twoWheelType;
    }

    public EBike(){}



    //region Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Override
    public void ExpectedKilometers() {

    }

    @Override
    public void BatteryLevel() {

    }

    @Override
    public void Watt() {

    }

    @Override
    public void Capacity() {

    }

    public String getExpectedKilometers() {
        return ExpectedKilometers;
    }

    public void setExpectedKilometers(String expectedKilometers) {
        ExpectedKilometers = expectedKilometers;
    }

    public String getCapacity() {
        return Capacity;
    }

    public void setCapacity(String capacity) {
        Capacity = capacity;
    }

    public String getBatteryLevel() {
        return BatteryLevel;
    }

    public void setBatteryLevel(String batteryLevel) {
        BatteryLevel = batteryLevel;
    }

    public String getWatt() {
        return Watt;
    }

    public void setWatt(String watt) {
        Watt = watt;
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
        System.out.println("EBike");
    }
}
