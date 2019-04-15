package com.csharp.bikerental.dto;

import com.csharp.bikerental.persistence.model.enums.ReservationPeriodicity;

import java.util.Date;

public class ReserveRepeatingDto {
    private String twoWheelId;
    private ReservationPeriodicity reservationPeriodicity;
    private Date startDate;
    private Date endDate;

    public String getTwoWheelId() {
        return twoWheelId;
    }

    public void setTwoWheelId(String twoWheelId) {
        this.twoWheelId = twoWheelId;
    }

    public ReservationPeriodicity getReservationPeriodicity() {
        return reservationPeriodicity;
    }

    public void setReservationPeriodicity(ReservationPeriodicity reservationPeriodicity) {
        this.reservationPeriodicity = reservationPeriodicity;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
