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


public class FullReport implements PaymentReport {
    
	//Constructor
	HashMap<Date,Long> paymentsMap = new HashMap<Date,Long> ();
	long userid;
    Session session;

	public FullReport(long userid)
	{
		this.userid=userid;
	}
	
	
	@Autowired

    List<PaymentReport> paymentReports = new ArrayList<PaymentReport>();	
	@Override
	public void add(PaymentReport paymentReport) {
		paymentReports.add(paymentReport);
		
	}

	@Override
	public void remove(PaymentReport paymentReport) {
		paymentReports.remove(paymentReport);
		
	}

	@Override
	public PaymentReport getChild(int i) {
		  return paymentReports.get(i);
	}

	
	@Override
	public HashMap<Date, Long> getReport()
	{
		return this.paymentsMap;
	}

	@Override
	public List<HashMap<Date,Long>> getCompleteReport()
	{
		ArrayList listOfMaps = new ArrayList();
		listOfMaps.add(this.getReport());
		
		//Traversing through all nodes
		Iterator<PaymentReport> paymentIterator = paymentReports.iterator();
		while(paymentIterator.hasNext()){
			 PaymentReport p = paymentIterator.next();
			 listOfMaps.add(p.getReport());
		     
		  }
		
		return listOfMaps;
	}
	
	
	
	
	//Calculating the Payment Value
	@SuppressWarnings("rawtypes")
	@Override
	public Object generatePayments() {
		
	     Query q = session.createQuery("select p.amount, p.payment_date from payment p where s.userid = :userid").setParameter("userid", this.userid);
	     List<Object[]> payments = null;
	     for(Object[] payment: payments){
	         paymentsMap.put((Date)payment[0],(Long)payment[1]);
	     }
	     return paymentsMap;
	}

}
