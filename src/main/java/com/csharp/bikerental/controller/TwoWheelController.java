package com.csharp.bikerental.controller;


import com.csharp.bikerental.persistence.model.TwoWheel.TwoWheel;
import com.csharp.bikerental.persistence.repo.TwoWheelRepository;
import com.csharp.bikerental.service.TwoWheelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class TwoWheelController {
    @Autowired
    private TwoWheelService twoWheelService;
    private TwoWheelRepository twoWheelRepository;


    @GetMapping("/bike")
    public String BikeOverview(Model model){
        model.addAttribute("bike",twoWheelService.getBike());
        return "bike";
    }
    @PostMapping("/bike")
    public ResponseEntity<?> selectTwoWheel(@RequestBody TwoWheel twoWheel){
        try{
            twoWheelService.selectBike(twoWheel);
            return ResponseEntity.ok().body(twoWheel);

        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }



    }

}
