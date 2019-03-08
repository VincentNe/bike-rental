package com.csharp.bikerental.persistence.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


public class TwoWheelerFactory {
    public enum TwoWheelType {
        BIKE, EBIKE, SCOOTER, ESCOOTER

    }

    public static TwoWheeler CreateTwoWheelItems(TwoWheelType twoWheelType) {
        switch (twoWheelType) {
            case BIKE:
                return new Bike();
            case EBIKE:
                return new EBike();
            case SCOOTER:
                return new Scooter();
            case ESCOOTER:
                return new EScooter();
        }
        return null;
    }


}
