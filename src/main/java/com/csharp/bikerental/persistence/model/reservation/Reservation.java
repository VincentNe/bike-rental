package com.csharp.bikerental.persistence.model.reservation;

import com.csharp.bikerental.persistence.model.TwoWheel;
import com.csharp.bikerental.persistence.model.User;

import javax.persistence.*;
import java.util.Date;

@Entity
public abstract  class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private TwoWheel twoWheel;
    @ManyToOne
    private User user;
    private Date reservationMadeDate;
    private Date startDate;
    private Date endDate;
    private boolean cancelled;

    public Reservation(TwoWheel twoWheel, User user, Date startDate, Date endDate) {
        this.twoWheel = twoWheel;
        this.reservationMadeDate = new Date();
        this.startDate = startDate;
        this.endDate = endDate;
        this.cancelled = false;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TwoWheel getTwoWheel() {
        return twoWheel;
    }

    public void setTwoWheel(TwoWheel twoWheel) {
        this.twoWheel = twoWheel;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }


}
