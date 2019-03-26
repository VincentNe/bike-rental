package com.csharp.bikerental.persistence.dto;

import com.csharp.bikerental.persistence.model.enums.ReservationPeriodicity;

import java.util.Date;

public class ReserveRepeatingDto {
    private Long twoWheelId;
    private ReservationPeriodicity reservationPeriodicity;
    private Date startDate;
    private Date endDate;

    public Long getTwoWheelId() {
        return twoWheelId;
    }

    public void setTwoWheelId(Long twoWheelId) {
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
