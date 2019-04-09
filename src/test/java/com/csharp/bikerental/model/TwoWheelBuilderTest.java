package com.csharp.bikerental.model;

import com.csharp.bikerental.persistence.model.TwoWheel.Bike;
import com.csharp.bikerental.persistence.model.TwoWheel.TwoWheel;

import org.junit.Test;

import com.csharp.bikerental.persistence.model.TwoWheel.TwoWheelBuilder;

import static org.junit.Assert.assertEquals;

public class TwoWheelBuilderTest {


    @Test
    public void builderBike() {
     TwoWheelBuilder twoWheelBuilder = new TwoWheelBuilder();
     TwoWheel biker = twoWheelBuilder.buildBike();
     biker.setSpeedometer("192");
     biker.setId("4");
     biker.setLight("yes");
     assertEquals("192", biker.getSpeedometer());
     assertEquals("4", biker.getId());
     assertEquals("yes", biker.getLight());
    }
    @Test
    public void builderEBike() {
        TwoWheelBuilder twoWheelBuilder = new TwoWheelBuilder();
        TwoWheel ebiker = twoWheelBuilder.buildBike();
        ebiker.setSpeedometer("122");
        ebiker.setId("99");
        ebiker.setLight("yes");
        assertEquals("122", ebiker.getSpeedometer());
        assertEquals("99", ebiker.getId());
        assertEquals("yes", ebiker.getLight());
    }

    @Test
    public void builderScooter() {
        TwoWheelBuilder twoWheelBuilder = new TwoWheelBuilder();
        TwoWheel scooter = twoWheelBuilder.buildScooter();
        scooter.setSpeedometer("142");
        scooter.setId("224");
        scooter.setLight("yes");
        assertEquals("142", scooter.getSpeedometer());
        assertEquals("224", scooter.getId());
        assertEquals("yes", scooter.getLight());
    }

    @Test
    public void builderEScooter() {
        TwoWheelBuilder twoWheelBuilder = new TwoWheelBuilder();
        TwoWheel escooter = twoWheelBuilder.buildEScooter();
        escooter.setSpeedometer("12");
        escooter.setId("13");
        escooter.setLight("yes");
        assertEquals("12", escooter.getSpeedometer());
        assertEquals("13", escooter.getId());
        assertEquals("yes", escooter.getLight());
    }
}
