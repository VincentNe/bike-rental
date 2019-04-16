package com.csharp.bikerental.controller;

import com.csharp.bikerental.dto.*;
import com.csharp.bikerental.persistence.model.Customer;
import com.csharp.bikerental.persistence.model.Employee;
import com.csharp.bikerental.persistence.model.User;
import com.csharp.bikerental.service.ReservationService.*;
import com.csharp.bikerental.service.UserService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ReservationController {

    @Autowired
    UserService userService;

    @Autowired
    ReservationServiceFacadeInterface reservationService = new ReservationServiceFacadeImpl();

    @RequestMapping(path="/reservation/onetime", method = RequestMethod.POST)
    public ResponseEntity<?> createOneTimeReservation(@RequestBody @Valid ReserveOneTimeDto reserveOneTimeDto, Customer customer) {
        try {
            reservationService.createOneTimeReservation(customer, reserveOneTimeDto);
            return ResponseEntity.ok().body(reserveOneTimeDto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }


    @RequestMapping(path="/reservation/maintenance", method = RequestMethod.POST)
    public ResponseEntity<?> createMaintenanceReservation(@RequestBody @Valid Employee employee,ReserveMaintenanceDto reserveMaintenanceDto) {
        try {
            reservationService.createMaintenanceReservation(employee,reserveMaintenanceDto);
            return ResponseEntity.ok().body(reserveMaintenanceDto);
        } catch (ServiceException e) {
            Map<String, String> response = new HashMap<>();
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }

    }


    @RequestMapping(path="/reservation/repeating", method = RequestMethod.POST)
    public ResponseEntity<?> createRepeatingReservation(@RequestBody @Valid User user,ReserveRepeatingDto reserveRepeatingDto) {
        try {
            reservationService.createRepeatingReservation(user,reserveRepeatingDto);
            return ResponseEntity.ok().body(reserveRepeatingDto);
        } catch (ServiceException e) {
            Map<String, String> response = new HashMap<>();
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

}
