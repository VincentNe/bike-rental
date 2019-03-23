package com.csharp.bikerental.persistence.model;

import com.sun.xml.internal.ws.message.PayloadElementSniffer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


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
