package com.csharp.bikerental.service.IssuesService;

import com.csharp.bikerental.persistence.model.Issues;
import com.csharp.bikerental.persistence.repo.IssuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class IssuesServiceImpl implements IssuesServiceInterface {

    @Autowired
    private IssuesRepository issuesRepository;


    public List<Issues> getIssues(){
        Iterator<Issues> issuesIterator = issuesRepository.findAll().iterator();
        List<Issues> result = new ArrayList<>();
        issuesIterator.forEachRemaining(result::add);
        return result;
    }

    public Issues getIssueByIssueID(Long identifier){
        return issuesRepository.findById(identifier).get();
    }

    public Issues getIssueByCustomerID(Long identifier){
    	
        return issuesRepository.findById(identifier).get();
    }

    /*
	public void reportAnIssue() {
		issuesRepository.save(i);
		
	}*/

	public boolean resolveAnIssue() {
		// TODO Auto-generated method stub
		return true;
	}

	public Object reportAnIssue() {
		// TODO Auto-generated method stub
		return null;
	}
    


}
