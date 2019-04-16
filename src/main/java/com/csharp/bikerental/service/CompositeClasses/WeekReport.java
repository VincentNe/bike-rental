package com.csharp.bikerental.service.CompositeClasses;

import com.csharp.bikerental.persistence.model.Issues;
import com.csharp.bikerental.persistence.repo.IssuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.csharp.bikerental.service.CompositeClasses.PaymentReport;

import org.hibernate.query.*;
import org.hibernate.sql.ordering.antlr.Factory;
import org.hibernate.*;
import org.hibernate.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap; 



public class WeekReport implements PaymentReport {
    
	//Constructor
	HashMap<Date,Long> paymentsMap = new HashMap<Date,Long> ();
	long userid;
    Session session;

	public WeekReport(long userid)
	{
		this.userid=userid;
	}
	
	
	@Autowired

	@Override
	public void add(PaymentReport paymentReport) {
	    //this is leaf node so this method is not applicable to this class.
		
	}

	@Override
	public void remove(PaymentReport paymentReport) {
	    //this is leaf node so this method is not applicable to this class.
		
	}

	@Override
	public PaymentReport getChild(int i) {
	    //this is leaf node so this method is not applicable to this class.
		return null;
	}
	
	@Override
	public HashMap<Date, Long> getReport()
	{
		return this.paymentsMap;
	}
	@Override
	public List<HashMap<Date, Long>> getCompleteReport() {
	    //this is leaf node so this method is not applicable to this class.
		return null;
	}

	
	//Calculating the Payment Value
	@SuppressWarnings("rawtypes")
	@Override
	public Object generatePayments() {
		//StartDate
		Date startDate=new Date();
		
		//EndDate
		long milliseconds = (long) 7 * 24 * 60 * 60 * 1000;
        Date endDate = new Date(startDate.getTime() - milliseconds);
		
	    Query q = session.createQuery("select p.amount, p.payment_date from payment p where s.userid = :userid and where p.paymentdate between :startD and :endD").setParameter("userid", this.userid)
	    					.setParameter("startD", startDate).setParameter("endD", endDate);
	    List<Object[]> payments = null;
	    for(Object[] payment: payments){
	        paymentsMap.put((Date)payment[0],(Long)payment[1]);
	    }
	    return paymentsMap;
	}

}
