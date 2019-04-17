package com.csharp.bikerental.service.TwoWheelService;

import com.csharp.bikerental.dto.NewTwoWheelDto;
import com.csharp.bikerental.persistence.model.TwoWheel.*;
import com.csharp.bikerental.persistence.repo.TwoWheelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class TwoWheelServiceFacadeImpl implements TwoWheelServiceFacadeInterface{

    @Qualifier("twoWheelServiceImpl")
    @Autowired
    private TwoWheelServiceInterface twoWheelService;


    public TwoWheel createTwoWheel(NewTwoWheelDto newTwoWheelDto){
        return twoWheelService.createTwoWheel(newTwoWheelDto);
    }



    public void selectBike(TwoWheel twoWheel) {
    	twoWheelService.selectBike(twoWheel);    }

    public List<TwoWheel> getBike() {
        
        return twoWheelService.getBike();
    }

    public void builderBike() {
    	twoWheelService.builderBike();
    }

    public void builderScooter() {
    	twoWheelService.builderScooter();
    }

    public void builderEScooter() {
    	twoWheelService.builderEScooter();
    }

    public void builderEBike() {
    	twoWheelService.builderEBike();
    }

}