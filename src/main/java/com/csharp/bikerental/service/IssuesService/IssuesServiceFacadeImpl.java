package com.csharp.bikerental.service.IssuesService;

import com.csharp.bikerental.persistence.model.Issues;
import com.csharp.bikerental.persistence.repo.IssuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csharp.bikerental.service.IssuesService.*;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class IssuesServiceFacadeImpl implements IssuesServiceFacadeInterface {

    @Autowired
    private IssuesRepository issuesRepository;
    private IssuesServiceInterface issuesService = new IssuesServiceImpl();

    


    public List<Issues> getIssues(){
        return issuesService.getIssues();
    }

    public Issues getIssueByIssueID(Long identifier){
        return issuesService.getIssueByIssueID(identifier);
    }

    public Issues getIssueByCustomerID(Long identifier){
    	
        return issuesService.getIssueByCustomerID(identifier);
    }



	public boolean resolveAnIssue() {
		return issuesService.resolveAnIssue();
	}

	public Object reportAnIssue() {
		return issuesService.reportAnIssue();
	}
}
