package com.csharp.bikerental.controller;

import com.csharp.bikerental.persistence.dto.*;
import com.csharp.bikerental.persistence.model.Customer;
import com.csharp.bikerental.persistence.model.User;
import com.csharp.bikerental.service.ReservationService;
import com.csharp.bikerental.service.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:8100" )
public class ReservationController {

    @Autowired
    UserService userService;

    @Autowired
    ReservationService reservationService;

    @RequestMapping(path="/reservation/onetime", method = RequestMethod.POST)
    public ResponseEntity<?> createOneTimeReservation(@RequestBody @Valid ReserveOneTimeDto reserveOneTimeDto) {
        try {


        } catch (ServiceException e) {
            Map<String, String> response = new HashMap<>();
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
        return  null;
    }


    @RequestMapping(path="/reservation/maintenance", method = RequestMethod.POST)
    public ResponseEntity<?> createMaintenanceReservation(@RequestBody @Valid ReserveMaintenanceDto reserveMaintenanceDto) {
        try {

            //TODO need spring secuirity



        } catch (ServiceException e) {
            Map<String, String> response = new HashMap<>();
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
        return  null;
    }

    @PreAuthorize("hasAnyRole('MAINTAINER','ADMINISTRATOR','CUSTOMER')")
    @RequestMapping(path="/reservation/repeating", method = RequestMethod.POST)
    public ResponseEntity<?> createRepeatingReservation(@RequestBody @Valid ReserveRepeatingDto reserveRepeatingDto) {
        try {




        } catch (ServiceException e) {
            Map<String, String> response = new HashMap<>();
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
        return  null;
    }

}
