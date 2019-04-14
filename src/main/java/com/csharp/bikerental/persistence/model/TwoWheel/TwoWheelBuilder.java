package com.csharp.bikerental.persistence.model.TwoWheel;

public class TwoWheelBuilder {

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
