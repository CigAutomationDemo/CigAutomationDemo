package com.automation.android.mobile.scripts;

import com.automation.test.management.IssueDetails;
import com.automation.test.management.JiraAPI;
import com.automation.utilities.Settings;

import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.JiraException;

public class TestJira {

	public static void main(String[] args) throws JiraException {
		System.out.println("Test JIRA Status");
		IssueDetails objIssueDetails=new IssueDetails();
		objIssueDetails.PROJECT=Settings.JIRAPROJECTID;
		objIssueDetails.ASSIGNEE="admin";
		objIssueDetails.DESCRIPTION="Test Defect From Framework";
		objIssueDetails.SUMMARY="IOS From Framework";
		Issue objissue=JiraAPI.fnAddDefectInJira(objIssueDetails);
		JiraAPI.fnDisplayJIRAISSSUE(objissue);
	}

}
