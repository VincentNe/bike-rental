package com.csharp.bikerental.service;

import com.csharp.bikerental.persistence.model.Bike;
import com.csharp.bikerental.persistence.repo.TwoWheelerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class TwoWheelerService {

    @Autowired
    private TwoWheelerRepository twoWheelerRepository;
   //todo logic for selecting  twowheeler objects
    public void addBike(Bike bike){twoWheelerRepository.save(bike);}

    public List<Bike> getBikes(){
        Iterator<Bike> bikeIterator = twoWheelerRepository.findAll().iterator();
        List<Bike> result = new ArrayList<>();
        bikeIterator.forEachRemaining(result::add);
        return result;
    }

    public Bike getBikeByID(Long identifier){
        return twoWheelerRepository.findById(identifier).get();
    }
}
