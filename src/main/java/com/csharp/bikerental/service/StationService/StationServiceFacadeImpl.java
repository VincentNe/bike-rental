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
public class StationServiceFacadeImpl implements StationServiceFacadeInterface{

    @Autowired
    private StationRepository stationRepository;

    private StationServiceInterface stationService = new StationServiceImpl();

    
    public void addStation(Station station){
    	stationService.addStation(station);
    }
    
    
    public List<Station> getStations(){
        return stationService.getStations();
    }

    public Station getStationByID(Long identifier){
        return stationService.getStationByID(identifier);
    }

    public boolean addStandToStation(Stand stand, Long identifier){
        return stationService.addStandToStation(stand,identifier);
    }


}
