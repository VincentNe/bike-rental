package com.csharp.bikerental.persistence.dto;

import com.csharp.bikerental.persistence.model.TwoWheel;
import com.csharp.bikerental.persistence.model.User;
import com.csharp.bikerental.persistence.model.reservation.MaintenanceReservation;

import java.util.Date;

public class MaintenanceReservationDto {
    private TwoWheelDto twoWheelDto;
    private Date reservationMadeDate;
    private Date startDate;
    private Date endDate;
    private UserDto userDto;

    public MaintenanceReservationDto(MaintenanceReservation maintenanceReservation) {
        this.twoWheelDto = new TwoWheelDto(maintenanceReservation.getTwoWheel());
        this.userDto = new UserDto(maintenanceReservation.getUser());
        this.startDate = maintenanceReservation.getStartDate();
        this.endDate = maintenanceReservation.getEndDate();
        this.reservationMadeDate = maintenanceReservation.getReservationMadeDate();
    }

    public TwoWheelDto getTwoWheelDto() {
        return twoWheelDto;
    }

    public void setTwoWheelDto(TwoWheelDto twoWheelDto) {
        this.twoWheelDto = twoWheelDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
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
}
