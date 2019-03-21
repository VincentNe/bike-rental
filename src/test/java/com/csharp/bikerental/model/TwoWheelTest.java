package com.csharp.bikerental.model;

import com.csharp.bikerental.persistence.model.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TwoWheelTest {


    @Test
    public void selectBike() {
        Bike bike = new Bike("Bike");
        bike.select();
        assertEquals("Bike", bike.getTwoWheelType());


    }

    @Test
    public void selectEBike() {
        EBike ebike = new EBike("EBike");
        ebike.select();
        assertEquals("EBike", ebike.getTwoWheelType());


    }

    @Test
    public void selectScooter() {
        Scooter scooter = new Scooter("Scooter");
        scooter.select();
        assertEquals("Scooter", scooter.getTwoWheelType());


    }

    @Test
    public void selectEScooter() {
        EScooter eScooter = new EScooter("EScooter");
        eScooter.select();
        assertEquals("EScooter", eScooter.getTwoWheelType());


    }



}
