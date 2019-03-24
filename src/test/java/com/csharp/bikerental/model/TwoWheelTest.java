package com.csharp.bikerental.model;

import com.csharp.bikerental.persistence.model.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TwoWheelTest {

    @Test
    public void selectBike() {
        TwoWheel twoWheel = TwoWheelFactory.CreateTwoWheelItems(TwoWheelFactory.twoWheelType.BIKE);
        twoWheel.select();
        assertEquals("Bike", twoWheel.getTwoWheelType());
    }


    @Test
    public void selectEBike() {
        TwoWheel twoWheel = TwoWheelFactory.CreateTwoWheelItems(TwoWheelFactory.twoWheelType.EBIKE);
        twoWheel.select();
        assertEquals("EBike", twoWheel.getTwoWheelType());


    }

    @Test
    public void selectScooter() {
        TwoWheel twoWheel = TwoWheelFactory.CreateTwoWheelItems(TwoWheelFactory.twoWheelType.SCOOTER);
        twoWheel.select();
        assertEquals("Scooter", twoWheel.getTwoWheelType());


    }

    @Test
    public void selectEScooter() {
        TwoWheel twoWheel = TwoWheelFactory.CreateTwoWheelItems(TwoWheelFactory.twoWheelType.ESCOOTER);
        twoWheel.select();
        assertEquals("EScooter", twoWheel.getTwoWheelType());


    }






}
