package com.csharp.bikerental.persistence.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Issues {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long issueId;
    private String issueDescription;
    private String createdBy;
    private String resolvedBy;
    
    public Issues(){

    }

    //region Getters and Setters

    public long getIssueId() {
        return issueId;
    }
    public void setId(long issueId) {
        this.issueId = issueId;
    }
 	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getIssueDescription() {
		return issueDescription;
	}
	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}
	public String getResolvedBy() {
		return resolvedBy;
	}
	public void setResolvedBy(String resolvedBy) {
		this.resolvedBy = resolvedBy;
	}

}
