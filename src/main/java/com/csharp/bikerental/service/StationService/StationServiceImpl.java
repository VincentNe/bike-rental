package com.csharp.bikerental.service.StationService;

import com.csharp.bikerental.persistence.model.Station.Stand;
import com.csharp.bikerental.persistence.model.Station.Station;
import com.csharp.bikerental.persistence.repo.StationRepository;
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


}
