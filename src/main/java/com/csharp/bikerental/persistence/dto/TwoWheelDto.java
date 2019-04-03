package com.csharp.bikerental.persistence.dto;


import com.csharp.bikerental.persistence.model.TwoWheel.TwoWheel;

public class TwoWheelDto {
    private String id;
    private String twoWheelType;

    public TwoWheelDto(TwoWheel twoWheel) {
        this.id = twoWheel.getId();
        this.twoWheelType = twoWheel.getTwoWheelType();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTwoWheelType() {
        return twoWheelType;
    }

    public void setTwoWheelType(String twoWheelType) {
        this.twoWheelType = twoWheelType;
    }
}
