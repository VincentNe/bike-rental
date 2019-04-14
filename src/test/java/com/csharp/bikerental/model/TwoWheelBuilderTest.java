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
     biker.setSpeedometer("192.2");
     biker.setId("4");
     biker.setLights(true);
     biker.setSeat(true);
     assertEquals("192.2",biker.getSpeedometer());
     assertEquals("4",biker.getId());
     assertEquals(true, biker.getLights());
     assertEquals(true, biker.getSeat());
    }
    @Test
    public void builderEBike() {
        TwoWheelBuilder twoWheelBuilder = new TwoWheelBuilder();
        TwoWheel ebiker = twoWheelBuilder.buildBike();
        ebiker.setSpeedometer("122.3");
        ebiker.setId("99");
        ebiker.setLights(true);
        ebiker.setSeat(true);
        assertEquals("122.3",ebiker.getSpeedometer());
        assertEquals("99", ebiker.getId());
        assertEquals(true, ebiker.getLights());
        assertEquals(true,ebiker.getSeat());
    }

    @Test
    public void builderScooter() {
        TwoWheelBuilder twoWheelBuilder = new TwoWheelBuilder();
        TwoWheel scooter = twoWheelBuilder.buildScooter();
        scooter.setSpeedometer("142.9");
        scooter.setId("224");
        scooter.setLights(true);
        scooter.setSeat(true);
        assertEquals("142.9",scooter.getSpeedometer());
        assertEquals("224",scooter.getId());
        assertEquals(true, scooter.getLights());
        assertEquals(true,scooter.getSeat());
    }

    @Test
    public void builderEScooter() {
        TwoWheelBuilder twoWheelBuilder = new TwoWheelBuilder();
        TwoWheel escooter = twoWheelBuilder.buildEScooter();
        escooter.setSpeedometer("46.3");
        escooter.setId("13");
        escooter.setLights(true);
        escooter.setSeat(true);
       assertEquals("46.3",escooter.getSpeedometer());
        assertEquals("13", escooter.getId());
        assertEquals(true, escooter.getLights());
        assertEquals(true,escooter.getSeat());
    }
}
