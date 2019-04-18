package com.csharp.bikerental.service.StationService;

import com.csharp.bikerental.persistence.model.Station.Stand;
import com.csharp.bikerental.persistence.model.Station.Station;
import com.csharp.bikerental.persistence.model.TwoWheel.TwoWheel;
import com.csharp.bikerental.persistence.repo.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class StationServiceFacadeImpl implements StationServiceFacadeInterface{

    @Qualifier("stationServiceImpl")
    @Autowired
    private StationServiceInterface stationService;


    public void addStation(Station station){
    	stationService.addStation(station);
    }
    
    
    public List<Station> getStations(){
        return stationService.getStations();
    }

    public Station getStationByID(Long identifier){
        return stationService.getStationByID(identifier);
    }

    public Stand addStandToStation(Stand stand, Long identifier){
        return stationService.addStandToStation(stand,identifier);
    }

    public TwoWheel getBikeFromStand(Long standId){
        return  stationService.getBikeFromStand(standId);
    }
    public void putBikeInStand(Long standId,String twoWheelerId){
        stationService.putBikeInStand(standId,twoWheelerId);
    }
    public Stand getStandById(Long standId){
        return stationService.getStandById(standId);
    }

}
