package com.csharp.bikerental.service;

import com.csharp.bikerental.persistence.model.TwoWheel.TwoWheel;
import com.csharp.bikerental.persistence.model.TwoWheel.TwoWheelBuilder;
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
    // private TwoWheelBuilder twoWheelBuilder;


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
        TwoWheelBuilder twoWheelBuilder = new TwoWheelBuilder();
        TwoWheel biker = twoWheelBuilder.buildBike();
    }

    public void builderScooter() {
        TwoWheelBuilder twoWheelBuilder = new TwoWheelBuilder();
        TwoWheel scooter = twoWheelBuilder.buildScooter();
    }

    public void builderEScooter() {
        TwoWheelBuilder twoWheelBuilder = new TwoWheelBuilder();
        TwoWheel escooter = twoWheelBuilder.buildEScooter();
    }

    public void builderEBike() {
        TwoWheelBuilder twoWheelBuilder = new TwoWheelBuilder();
        TwoWheel Ebiker = twoWheelBuilder.buildBike();
    }

}
