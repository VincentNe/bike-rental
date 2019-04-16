package com.csharp.bikerental.controller;

import com.csharp.bikerental.service.StationService.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StationController {
    @Autowired
    private StationServiceFacadeInterface stationService = new StationServiceFacadeImpl();



    @GetMapping("/Stations")
    public String StationOverview(Model model){
        model.addAttribute("stations", stationService.getStations());
        return "stations";
    }
}
