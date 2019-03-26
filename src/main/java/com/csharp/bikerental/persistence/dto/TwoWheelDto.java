package com.csharp.bikerental.persistence.dto;

import com.csharp.bikerental.persistence.model.TwoWheel;

public class TwoWheelDto {
    private Long id;
    private String twoWheelType;

    public TwoWheelDto(TwoWheel twoWheel) {
        this.id = twoWheel.getId();
        this.twoWheelType = twoWheel.getTwoWheelType();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTwoWheelType() {
        return twoWheelType;
    }

    public void setTwoWheelType(String twoWheelType) {
        this.twoWheelType = twoWheelType;
    }
}
