package com.csharp.bikerental.service.StationService;

import com.csharp.bikerental.persistence.model.Station.Stand;
import com.csharp.bikerental.persistence.model.Station.Station;
import com.csharp.bikerental.persistence.model.TwoWheel.TwoWheel;
import com.csharp.bikerental.persistence.repo.StandRepository;
import com.csharp.bikerental.persistence.repo.StationRepository;
import com.csharp.bikerental.persistence.repo.TwoWheelRepository;
import com.csharp.bikerental.service.TwoWheelService.TwoWheelServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class StationServiceImpl implements  StationServiceInterface{

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private StandRepository standRepository;

    @Autowired
    private TwoWheelServiceInterface twoWheelServiceInterface;

    public void addStation(Station station){
        stationRepository.save(station);
    }
    public List<Station> getStations(){
        Iterator<Station> stationsIterator = stationRepository.findAll().iterator();
        List<Station> result = new ArrayList<>();
        stationsIterator.forEachRemaining(result::add);
        return result;
    }

    public Station getStationByID(Long identifier){
        return stationRepository.findById(identifier).get();
    }

    public boolean addStandToStation(Stand stand, Long identifier){
        Optional<Station> stationOptional = stationRepository.findById(identifier);
        if(!stationOptional.isPresent())return false;
        Station station = stationOptional.get();
        station.addStand(stand);
        stationRepository.save(station);
        return true;
    }
    public void putBikeInStand(Long standId,String twoWheelerId){
       Optional<Stand> standOptional =  standRepository.findById(standId);
       if(!standOptional.isPresent())return;
       Stand stand = standOptional.get();
       TwoWheel twoWheeler = twoWheelServiceInterface.getTwoWheel(twoWheelerId);
       stand.putBikeInStand(twoWheeler);
       standRepository.save(stand);

    }
    public TwoWheel getBikeFromStand(Long standId){
        Optional<Stand> standOptional =  standRepository.findById(standId);
        if(!standOptional.isPresent())return null;
        Stand stand = standOptional.get();
        TwoWheel bike = stand.takeoutBike();
        standRepository.save(stand);
        return  bike;
    }


}
