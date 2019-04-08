package com.csharp.bikerental.persistence.model.TwoWheel;


import com.csharp.bikerental.persistence.model.TwoWheel.TwoWheel;

public abstract class TwoWheelFactory {


    public enum twoWheelType {
        BIKE, EBIKE, SCOOTER, ESCOOTER

    }

    public static TwoWheel CreateTwoWheelItems(twoWheelType twotype) {
        switch ( twotype) {
            case BIKE:
                return new Bike();
            case EBIKE:
                return new EBike();

            case SCOOTER:
                return new Scooter();

            case ESCOOTER:
                return new EScooter();
             default:
                 System.out.println("no response");
                 break;
        }

        return null;
    }


}
