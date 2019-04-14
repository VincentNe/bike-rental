package com.csharp.bikerental.dto;

import com.csharp.bikerental.persistence.model.enums.TwoWheelType;

public class NewTwoWheelDto {
    private TwoWheelType twoWheelType;

    public TwoWheelType getTwoWheelType() {
        return twoWheelType;
    }

    public void setTwoWheelType(TwoWheelType twoWheelType) {
        this.twoWheelType = twoWheelType;
    }
}
