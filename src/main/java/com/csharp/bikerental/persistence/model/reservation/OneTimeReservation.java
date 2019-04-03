package com.csharp.bikerental.persistence.model.reservation;

import com.csharp.bikerental.persistence.model.Customer;

import com.csharp.bikerental.persistence.model.TwoWheel.TwoWheel;
import com.csharp.bikerental.persistence.model.User;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class OneTimeReservation extends Reservation {
    public OneTimeReservation(Customer customer, Date startDate, Date endDate, TwoWheel twoWheel) {
        super(twoWheel, customer, startDate, endDate);
    }
}
