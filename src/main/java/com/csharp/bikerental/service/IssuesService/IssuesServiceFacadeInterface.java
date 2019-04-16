package com.csharp.bikerental.service.IssuesService;

import com.csharp.bikerental.persistence.model.Issues;
import com.csharp.bikerental.persistence.repo.IssuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public interface IssuesServiceFacadeInterface {

    @Autowired
    public List<Issues> getIssues();
    public Issues getIssueByIssueID(Long identifier);
    public Issues getIssueByCustomerID(Long identifier);
	public boolean resolveAnIssue();
	public Object reportAnIssue();
}
