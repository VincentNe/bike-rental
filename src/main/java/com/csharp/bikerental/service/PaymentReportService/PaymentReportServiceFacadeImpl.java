package com.csharp.bikerental.service.PaymentReportService;

import com.csharp.bikerental.persistence.model.Issues;
import com.csharp.bikerental.persistence.repo.IssuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.csharp.bikerental.service.CompositeClasses.PaymentReportImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Service
public class PaymentReportServiceFacadeImpl implements PaymentReportServiceFacadeInterface {

    private PaymentReportServiceInterface paymentReportService = new PaymentReportServiceImpl();

    @Autowired
	public List<HashMap<Date, Long>> PaymentReportOverview(Long userid) {
    	return paymentReportService.PaymentReportOverview(userid);
	}
}
