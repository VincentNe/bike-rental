package com.csharp.bikerental.service.CompositeClasses;

import com.csharp.bikerental.persistence.model.Issues;
import com.csharp.bikerental.persistence.repo.IssuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.csharp.bikerental.service.CompositeClasses.*;



import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap; 




public class PaymentReportImpl {
	

    @Autowired
    public List<HashMap<Date, Long>> calculatePayments(long userid)
    {
    	
    	PaymentReport fullReport = new FullReport(userid);
    	PaymentReport yearReport = new YearReport(userid);
    	PaymentReport monthReport = new MonthReport(userid);
    	PaymentReport weekReport = new WeekReport(userid);
    	PaymentReport dayReport = new DayReport(userid);
    	
    	//Generating the Payments
    	fullReport.generatePayments();
    	yearReport.generatePayments();
    	monthReport.generatePayments();
    	weekReport.generatePayments();
    	dayReport.generatePayments();
    	
    	//Adding to Root
    	
    	fullReport.add(yearReport);
    	fullReport.add(monthReport);
    	fullReport.add(weekReport);
    	fullReport.add(dayReport);
    	

    	//Returning the Root which has its own Report along with other reports and its corresponding hashmaps
    	return fullReport.getCompleteReport();
    	    	
    }
}
