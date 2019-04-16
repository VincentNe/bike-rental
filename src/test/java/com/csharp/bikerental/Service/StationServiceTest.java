package com.csharp.bikerental.Service;

import com.csharp.bikerental.BikeRentalApplication;
import com.csharp.bikerental.persistence.model.Station.Stand;
import com.csharp.bikerental.persistence.model.Station.Station;
import com.csharp.bikerental.service.StationService.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { BikeRentalApplication.class })
public class StationServiceTest {

    @Autowired
    private StationServiceImpl stationService;

    @Test
    public void AddStation(){
        Station station = new Station("TestStation 2");

        stationService.addStation(station);

        Assert.assertEquals(stationService.getStationByID(station.getId()).getId(),station.getId());
    }
    @Test
    public void AddStandToStation(){
        Station station = new Station("TestStation");

        stationService.addStation(station);

        station.addStand(new Stand());
        station.addStand(new Stand());

        stationService.addStandToStation(new Stand(),station.getId());
        stationService.addStandToStation(new Stand(),station.getId());

        Station returnedStation = stationService.getStationByID(station.getId());

        Assert.assertEquals(returnedStation.getEmptyStands(), station.getEmptyStands());
    }

}
