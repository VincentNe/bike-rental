package com.csharp.bikerental.config;

import com.csharp.bikerental.persistence.model.Customer;
import com.csharp.bikerental.persistence.model.Employee;
import com.csharp.bikerental.persistence.model.Station.Stand;
import com.csharp.bikerental.persistence.model.Station.Station;
import com.csharp.bikerental.persistence.model.Subscriptions.SubscriptionEnum;
import com.csharp.bikerental.persistence.model.TwoWheel.TwoWheel;
import com.csharp.bikerental.persistence.model.TwoWheel.TwoWheelBuilder;
import com.csharp.bikerental.service.StationService.StationServiceFacadeImpl;
import com.csharp.bikerental.service.StationService.StationServiceFacadeInterface;
import com.csharp.bikerental.service.SubscriptionService.*;

import com.csharp.bikerental.persistence.model.Employee;

import com.csharp.bikerental.service.TwoWheelService.TwoWheelServiceFacadeInterface;
import com.csharp.bikerental.service.UserService.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DemoData {

    @Autowired
    private UserServiceFacadeInterface userRepo;

    @Autowired
    private SubscriptionServiceFacadeInterface subscriptionService;

    @Autowired
    private StationServiceFacadeInterface stationService;

    @Autowired
    private TwoWheelServiceFacadeInterface twoWheelService;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {

        // ADD USERS TO THE APPLICATION
        userRepo.saveUser(new Customer("Customer Name","custy","pass"));
        userRepo.saveUser(new Employee("Employer Name","employe","pass"));

        // ADD SUBSCRIPTIONS TO A USER
        subscriptionService.buySubcription("custy",null, SubscriptionEnum.PayAsYouGo);

        //ADD STATION
        Station station1 = new Station("Limerick City Centre");
        Station station2 = new Station("Thomond Stadion");

        stationService.addStation(station1);
        stationService.addStation(station2);

        //ADD STANDS
        Stand stand1 = new Stand();
        Stand stand2 = new Stand();
        Stand stand3 = new Stand();
        Stand stand4 = new Stand();
        Stand stand5 = new Stand();

        stationService.addStandToStation(stand1,station1.getId());
        stationService.addStandToStation(stand2,station1.getId());
        stationService.addStandToStation(stand3,station1.getId());
        stationService.addStandToStation(stand4,station2.getId());
        stationService.addStandToStation(stand5,station2.getId());

        //ADD BIKE
        TwoWheelBuilder sBuilder = new TwoWheelBuilder();
        TwoWheel twoWheel1 = sBuilder.buildBike();
        TwoWheel twoWheel2 = sBuilder.buildBike();

        twoWheelService.saveTwoWheel(twoWheel1);
        twoWheelService.saveTwoWheel(twoWheel2);

        stationService.putBikeInStand(stand1.getId(),twoWheel1.getId());
        stationService.putBikeInStand(stand4.getId(),twoWheel2.getId());

    }
}
