package com.csharp.bikerental.controller;

import com.csharp.bikerental.persistence.model.TwoWheel.TwoWheel;
import com.csharp.bikerental.persistence.model.User;
import com.csharp.bikerental.service.StationService.*;
import com.csharp.bikerental.service.UserService.UserServiceFacadeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StationController {

    @Qualifier("stationServiceFacadeImpl")
    @Autowired
    private StationServiceFacadeInterface stationService;

    @Qualifier("userServiceFacadeImpl")
    @Autowired
    private UserServiceFacadeInterface userService;

    @GetMapping("/Stations")
    public String StationOverview(Model model){
        model.addAttribute("stations", stationService.getStations());
        User u = userService.getUserByUsername(getUsername());
        model.addAttribute("bikesInUse",u.getTwoWheel());
        return "stations";
    }

    @PostMapping("/RentBike")
    public String rentBike(@RequestParam(name = "standId") Long standId, Model model){
        Boolean b=  userService.rentBike(getUsername(), standId);
        return StationOverview(model);
    }
    @PostMapping("/ReturnBike")
    public String returnBike(@RequestParam(name = "standId") Long standId,@RequestParam(name = "bikeId") String bikeId, Model model){
        userService.returnBike(getUsername(),standId, bikeId);
        return StationOverview(model);
    }
    private String getUsername(){
        return ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
    }
}
