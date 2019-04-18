package com.csharp.bikerental.service.StationService;

import com.csharp.bikerental.persistence.model.Station.Stand;
import com.csharp.bikerental.persistence.model.Station.Station;
import com.csharp.bikerental.persistence.model.TwoWheel.TwoWheel;
import com.csharp.bikerental.persistence.repo.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public interface StationServiceInterface {

    public void addStation(Station station);
    public List<Station> getStations();
    public Station getStationByID(Long identifier);
    public boolean addStandToStation(Stand stand, Long identifier);
    public TwoWheel getBikeFromStand(Long standId);
    public void putBikeInStand(Long standId,String twoWheelerId);

}
