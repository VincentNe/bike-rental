package com.csharp.bikerental.persistence.model.TwoWheel;

public class TwoWheelBuilder {

     private TwoWheel twoWheeltemp;
    private TwoWheel biketemp;
    private TwoWheel ebiketemp;
    private TwoWheel scootertemp;
    private TwoWheel escootertemp;

    public   TwoWheel buildBike() {
        TwoWheel biker = new Bike();
        return biker;
    }

    public TwoWheel buildScooter(){
        TwoWheel scooter = new Scooter();
        return scooter;
    }

       public TwoWheel buildEScooter(){
        TwoWheel escooter = new EScooter();
        return escooter;
    }

    public TwoWheel buildEBike(){
        TwoWheel ebike = new EBike();
        return ebike;
    }

}
