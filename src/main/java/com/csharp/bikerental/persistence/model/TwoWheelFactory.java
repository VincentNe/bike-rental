package com.csharp.bikerental.persistence.model;


public class TwoWheelFactory {


//    public enum TwoWheelType {
//        BIKE, EBIKE, SCOOTER, ESCOOTER
//
//    }

    public TwoWheel CreateTwoWheelItems(String type) {
        switch (type) {
            case "Bike":
                return new Bike();
            case "EBike":
                return new EBike();
            case "Scooter":
                return new Scooter();
            case "EScooter":
                return new EScooter();
        }
        return null;
    }


}
