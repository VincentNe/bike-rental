package com.csharp.bikerental.persistence.model.reservation;

import com.csharp.bikerental.persistence.model.TwoWheel;
import com.csharp.bikerental.persistence.model.User;
import com.csharp.bikerental.persistence.model.enums.ReservationPeriodicity;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class RepeatingReservation extends  Reservation {
    private ReservationPeriodicity reservationPeriodicity;

    public RepeatingReservation(TwoWheel twoWheel, User user,ReservationPeriodicity reservationPeriodicity, Date startDate, Date endDate ) {
        super(twoWheel, user, startDate, endDate);
        this.reservationPeriodicity = reservationPeriodicity;
    }

    public ReservationPeriodicity getReservationPeriodicity() {
        return reservationPeriodicity;
    }

    public void setReservationPeriodicity(ReservationPeriodicity reservationPeriodicity) {
        this.reservationPeriodicity = reservationPeriodicity;
    }
}
