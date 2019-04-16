package com.csharp.bikerental.controller;


import com.csharp.bikerental.service.PaymentReportService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.csharp.bikerental.persistence.model.PaymentReportEnum;;



@Controller
public class PaymentReportController {
    @Autowired
    private PaymentReportService paymentReportService;

    
    @GetMapping(path="/paymentReports/{userid}")
    public ResponseEntity<List<HashMap<Date, Long>>> PaymentReportOverview(@PathVariable("userid") Long userid){
    	List finalReport = paymentReportService.PaymentReportOverview(userid);
    	return  new ResponseEntity<List<HashMap<Date, Long>>>(finalReport,HttpStatus.OK);
    }
    }

