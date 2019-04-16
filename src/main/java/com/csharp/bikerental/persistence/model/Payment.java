package com.csharp.bikerental.persistence.model;

//import com.sun.xml.internal.ws.message.PayloadElementSniffer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private int amount;
    
    private Date paymentDate;
    
    private long userid;

    //region Getters and Setters
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public long getUserId() {
		return userid;
	}

	public void setUserId(Long userId) {
		this.userid = userId;
	}
    //endregion

    public Payment(){}

    public Payment(int amount, Date paymentDate, String username){
    	this.setPaymentDate(new Date(System.currentTimeMillis()));

    }


}
