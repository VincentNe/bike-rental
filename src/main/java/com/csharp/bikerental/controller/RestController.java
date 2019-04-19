package com.csharp.bikerental.controller;

import com.csharp.bikerental.persistence.model.Station.Stand;
import com.csharp.bikerental.persistence.model.Station.Station;
import com.csharp.bikerental.service.StationService.StationServiceFacadeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Qualifier("stationServiceFacadeImpl")
    @Autowired
    private StationServiceFacadeInterface stationService;

    @GetMapping("api/getStats")
    public Map<String,Integer> getStats(){
        Map<String, Integer> result = new HashMap<>();
        List<Station> stations =   stationService.getStations();
        int TotalStations = stations.size();
        int TotalStands = 0;
        int TotalStandAvailable =0;
        int TotalStandsOcupied = 0;
        for (Station station :stations){
            List<Stand> stands = station.getStands();
            for(Stand stand: stands){
                TotalStands++;
                if(stand.isEmpty()) TotalStandAvailable ++;
                    else TotalStandsOcupied++;
            }
        }
        result.put("TotalStations",TotalStations);
        result.put("TotalStands",TotalStands);
        result.put("TotalStandAvailable",TotalStandAvailable);
        result.put("TotalStandsOcupied",TotalStandsOcupied);
        return result;

    }
}
