package com.csharp.bikerental.controller;

import com.csharp.bikerental.service.TwoWheelerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TwoWheelerController {
    @Autowired
    private TwoWheelerService twoWheelerService;
}
