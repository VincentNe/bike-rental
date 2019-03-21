package com.csharp.bikerental.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Bike extends TwoWheel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    String twoWheelType;

    public Bike(String twoWheelType) {
        this.twoWheelType  = twoWheelType;
    }

    public Bike(){}


    //region Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getTwoWheelType() {
        return twoWheelType;
    }

    @Override
    public void setTwoWheelType(String twoWheelType) {
        this.twoWheelType = twoWheelType;
    }

    @Override
    public void select() {
        System.out.println("Bike");
    }
}
