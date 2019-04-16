package com.csharp.bikerental.Service;

import com.csharp.bikerental.BikeRentalApplication;
import com.csharp.bikerental.persistence.model.TwoWheel.*;
import com.csharp.bikerental.service.TwoWheelService.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BikeRentalApplication.class})
public class TwoWheelServiceTest {
    @Autowired
    TwoWheelServiceFacadeInterface twoWheelService = new TwoWheelServiceFacadeImpl();

    @Test
    public void builderBikeTest() {

        Bike biker = new Bike("Bike1");
        twoWheelService.builderBike();
        assertEquals("Bike1", biker.getTwoWheelType());
    }

    @Test
    public void builderScooterTest() {
        Scooter scooter = new Scooter("Scooter2");
        TwoWheelBuilder sBuilder = new TwoWheelBuilder();
        sBuilder.buildScooter();
        assertEquals("Scooter2", scooter.getTwoWheelType());
    }
    @Test
    public void builderEScooterTest() {
        EScooter eScooter = new EScooter("EScooter3");
        TwoWheelBuilder eSBuilder = new TwoWheelBuilder();
        eSBuilder.buildEScooter();
        assertEquals("EScooter3", eScooter.getTwoWheelType());
    }
    @Test
    public void builderEBikeTest() {
        EBike ebiker = new EBike("EBike4");
        TwoWheelBuilder eBBuilder = new TwoWheelBuilder();
        eBBuilder.buildEBike();
        assertEquals("EBike4", ebiker.getTwoWheelType());
    }





}
