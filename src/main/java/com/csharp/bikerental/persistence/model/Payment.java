package com.csharp.bikerental.persistence.model;

import com.sun.xml.internal.ws.message.PayloadElementSniffer;

import javax.persistence.Entity;

@Entity
public class Payment {
    private int amount;

    //region Getters and Setters
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    //endregion

    public Payment(){}

    public Payment(int amount){

    }
}
