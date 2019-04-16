package com.csharp.bikerental.dto;

import com.csharp.bikerental.persistence.model.enums.ReservationPeriodicity;
import com.csharp.bikerental.persistence.model.reservation.RepeatingReservation;

import java.util.Date;

public class RepeatingReservationDto {
    private Long id;
    private UserDto userDto;
    private ReservationPeriodicity reservationPeriodicity;
    private Date reservationMadeDate;
    private Date startDate;
    private Date endDate;
    private TwoWheelDto twoWheelDto;

    public RepeatingReservationDto(RepeatingReservation repeatingReservation) {
        this.id = repeatingReservation.getId();
        this.userDto = new UserDto(repeatingReservation.getUser());
        this.reservationPeriodicity = repeatingReservation.getReservationPeriodicity();
        this.reservationMadeDate = repeatingReservation.getReservationMadeDate();
        this.startDate =  repeatingReservation.getStartDate();
        this.endDate = repeatingReservation.getEndDate();
        this.twoWheelDto = new TwoWheelDto(repeatingReservation.getTwoWheel());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public ReservationPeriodicity getReservationPeriodicity() {
        return reservationPeriodicity;
    }

    public void setReservationPeriodicity(ReservationPeriodicity reservationPeriodicity) {
        this.reservationPeriodicity = reservationPeriodicity;
    }

    public Date getReservationMadeDate() {
        return reservationMadeDate;
    }

    public void setReservationMadeDate(Date reservationMadeDate) {
        this.reservationMadeDate = reservationMadeDate;
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

    public TwoWheelDto getTwoWheelDto() {
        return twoWheelDto;
    }

    public void setTwoWheelDto(TwoWheelDto twoWheelDto) {
        this.twoWheelDto = twoWheelDto;
    }
}
