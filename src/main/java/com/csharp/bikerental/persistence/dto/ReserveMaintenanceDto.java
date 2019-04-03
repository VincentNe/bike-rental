package com.csharp.bikerental.persistence.dto;

import java.util.Date;

public class ReserveMaintenanceDto {
    private Date startDate;
    private Date endDate;
    private String twoWheelId;

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

    public String getTwoWheelId() {
        return twoWheelId;
    }

    public void setTwoWheelId(String twoWheelId) {
        this.twoWheelId = twoWheelId;
    }
}
