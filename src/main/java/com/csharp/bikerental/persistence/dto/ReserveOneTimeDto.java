package com.csharp.bikerental.persistence.dto;

import java.util.Date;

public class ReserveOneTimeDto {
    private Date startDate;
    private Date endDate;
    private Long twoWheelId;

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

    public Long getTwoWheelId() {
        return twoWheelId;
    }

    public void setTwoWheelId(Long twoWheelId) {
        this.twoWheelId = twoWheelId;
    }
}