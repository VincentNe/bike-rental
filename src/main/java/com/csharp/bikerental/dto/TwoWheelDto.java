package com.csharp.bikerental.dto;


import com.csharp.bikerental.persistence.model.TwoWheel.TwoWheel;
import com.csharp.bikerental.persistence.model.enums.TwoWheelType;

public class TwoWheelDto {
    private String identifier;
    private String id;
    //private String twoWheelType;
    private TwoWheelType twoWheelType;


    public TwoWheelDto(TwoWheel twoWheel) {
        this.id = twoWheel.getId();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TwoWheelType getTwoWheelType() {
        return twoWheelType;
    }

    public void setTwoWheelType(TwoWheelType twoWheelType) {
        this.twoWheelType = twoWheelType;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
