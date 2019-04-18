package com.csharp.bikerental.service.TwoWheelService;

import com.csharp.bikerental.dto.NewTwoWheelDto;
import com.csharp.bikerental.persistence.model.TwoWheel.*;
import com.csharp.bikerental.persistence.repo.TwoWheelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public interface TwoWheelServiceFacadeInterface {


    public TwoWheel createTwoWheel(NewTwoWheelDto newTwoWheelDto);


    public void selectBike(TwoWheel twoWheel);
    public List<TwoWheel> getBike();
    public TwoWheel getTwoWheel(String identifier);
    public void saveTwoWheel(TwoWheel twoWheel);

    public void builderBike();

    public void builderScooter();

    public void builderEScooter();

    public void builderEBike();
}
