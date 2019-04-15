package com.csharp.bikerental.dto;


import com.csharp.bikerental.persistence.model.reservation.OneTimeReservation;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OneTimeReservationDto {
    private Long id;
    private TwoWheelDto twoWheelDto;
    private Date reservationMadeDate;
    private Date startDate;
    private Date endDate;
    private UserDto userDto;

    public OneTimeReservationDto(OneTimeReservation oneTimeReservation) {
        this.id = oneTimeReservation.getId();
        this.twoWheelDto = new TwoWheelDto(oneTimeReservation.getTwoWheel());
        this.reservationMadeDate = oneTimeReservation.getReservationMadeDate();
        this.startDate = oneTimeReservation.getStartDate();
        this.endDate = oneTimeReservation.getEndDate();
       this.userDto = new UserDto(oneTimeReservation.getUser());

    }





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TwoWheelDto getTwoWheelDto() {
        return twoWheelDto;
    }

    public void setTwoWheelDto(TwoWheelDto twoWheelDto) {
        this.twoWheelDto = twoWheelDto;
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

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
