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

    public Stand addStandToStation(Stand stand, Long identifier){
        Optional<Station> stationOptional = stationRepository.findById(identifier);
        if(!stationOptional.isPresent())return null;
        Station station = stationOptional.get();
        stand.setId(0);
        stand = standRepository.save(stand);
        station.addStand(stand);
        stationRepository.save(station);
        return stand;
    }
    public void putBikeInStand(Long standId,String twoWheelerId){
       Optional<Stand> standOptional =  standRepository.findById(standId);
       if(!standOptional.isPresent())throw new IllegalArgumentException("Couldn't find stand");
       Stand stand = standOptional.get();
       TwoWheel twoWheeler = twoWheelServiceInterface.getTwoWheel(twoWheelerId);
       if(twoWheeler == null)  throw new IllegalArgumentException("Couldn't TwoWheeler");
       stand.putBikeInStand(twoWheeler);
       standRepository.save(stand);

    }

    @Override
    public Stand getStandById(Long standId) {
        return  standRepository.findById(standId).get();
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
