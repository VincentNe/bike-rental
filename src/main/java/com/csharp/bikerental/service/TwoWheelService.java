package com.csharp.bikerental.service;

import com.csharp.bikerental.persistence.model.TwoWheel;
import com.csharp.bikerental.persistence.model.TwoWheelFactory;
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

       public void selectBike(TwoWheel twoWheel){
           twoWheelerRepository.save(twoWheel);
       }

       public List<TwoWheel> getBike(){
           Iterator<TwoWheel> twoWheelIterator = twoWheelerRepository.findAll().iterator();
           List<TwoWheel> result = new ArrayList<>();
           twoWheelIterator.forEachRemaining(result::add);
           return result;
       }

}
