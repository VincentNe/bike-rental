package com.csharp.bikerental.controller;

import com.csharp.bikerental.service.IssuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class IssuesController {
    @Autowired
    private IssuesService issuesService;


    @GetMapping("/ShowAllIssues")
    public String IssuesOverview(Model model){
        model.addAttribute("issues", issuesService.getIssues());
        return "issues";
    }

    @GetMapping("/ReportAnIssue")
    public String IssuesReporting(Model model){
        model.addAttribute("issues", issuesService.reportAnIssue());
        return "issues";
    }

    @GetMapping("/ResolveAnIssue{issueId}")
    public String IssueResolving(Model model){
        model.addAttribute("issues", issuesService.resolveAnIssue());
        return "issues";
    }




}
