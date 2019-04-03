package com.csharp.bikerental.persistence.model.reservation;

import com.csharp.bikerental.persistence.model.Employee;

import com.csharp.bikerental.persistence.model.TwoWheel.TwoWheel;
import com.csharp.bikerental.persistence.model.User;

import javax.persistence.Entity;
import java.util.Date;
@Entity
public class MaintenanceReservation extends  Reservation {
    public MaintenanceReservation(Employee employee, TwoWheel twoWheel, Date startDate, Date endDate) {
        super(twoWheel, employee, startDate, endDate);
    }
}
