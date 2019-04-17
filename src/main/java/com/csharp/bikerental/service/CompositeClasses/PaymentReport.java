package com.csharp.bikerental.service.CompositeClasses;

import com.csharp.bikerental.persistence.model.Issues;
import com.csharp.bikerental.persistence.repo.IssuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap; 



public interface PaymentReport {
	

	@Autowired
    public void add(PaymentReport paymentReport);
    public void remove(PaymentReport paymentReport);
    public PaymentReport getChild(int i);
    public Object generatePayments();
    public HashMap<Date, Long> getReport();
    public List<HashMap<Date, Long>> getCompleteReport();

    

}
