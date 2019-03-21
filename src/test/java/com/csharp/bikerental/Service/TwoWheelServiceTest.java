package com.csharp.bikerental.Service;

import com.csharp.bikerental.BikeRentalApplication;
import com.csharp.bikerental.persistence.model.TwoWheel;
import com.csharp.bikerental.service.TwoWheelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BikeRentalApplication.class})
public class TwoWheelServiceTest {
    @Autowired
    TwoWheelService twoWheelService;

    @Test
    public void SelectBike(){
        //TwoWheel twoWheel = new TwoWheel("Bike");
    }

}
