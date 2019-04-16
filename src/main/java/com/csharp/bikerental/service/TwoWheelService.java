package com.csharp.bikerental.service;

import com.csharp.bikerental.dto.NewTwoWheelDto;
import com.csharp.bikerental.persistence.model.TwoWheel.*;
import com.csharp.bikerental.persistence.repo.TwoWheelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class TwoWheelService {

    @Autowired
    private TwoWheelRepository twoWheelerRepository;


    public TwoWheel createTwoWheel(NewTwoWheelDto newTwoWheelDto){
        TwoWheel twoWheel;
        switch (newTwoWheelDto.getTwoWheelType()){
            case BIKE:
                twoWheel = new Bike();
                break;
            case EBIKE:
                twoWheel = new EBike();
                break;
            case SCOOTER:
                twoWheel = new Scooter();
                break;
            case ESCOOTER:
                twoWheel = new EScooter();
                break;
            default:
                return null;
        }
        return twoWheelerRepository.save(twoWheel);
    }



    public void selectBike(TwoWheel twoWheel) {
        twoWheelerRepository.save(twoWheel);
    }

    public List<TwoWheel> getBike() {
        Iterator<TwoWheel> twoWheelIterator = twoWheelerRepository.findAll().iterator();
        List<TwoWheel> result = new ArrayList<>();
        twoWheelIterator.forEachRemaining(result::add);
        return result;
    }

    public void builderBike() {
        Bike biker = new Bike();
        TwoWheelBuilder twoWheelBuilder = new TwoWheelBuilder();
        twoWheelBuilder.buildBike();
    }

    public void builderScooter() {
        Scooter scooter = new Scooter();
        TwoWheelBuilder twoWheelBuilder = new TwoWheelBuilder();
        twoWheelBuilder.buildScooter();
    }

    public void builderEScooter() {
        EScooter eScooter = new EScooter();
        TwoWheelBuilder twoWheelBuilder = new TwoWheelBuilder();
        twoWheelBuilder.buildEScooter();
    }

    public void builderEBike() {
        EBike ebiker = new EBike();
        TwoWheelBuilder twoWheelBuilder = new TwoWheelBuilder();
        twoWheelBuilder.buildEBike();
    }

}
