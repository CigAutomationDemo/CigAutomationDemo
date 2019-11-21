package com.automation.reports;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.accelerators.TestEngine;
import com.relevantcodes.extentreports.LogStatus;

public class TestReport extends TestEngine{
	
	@Test
	public void fnTest1()
	{
		System.out.println("Test 1");
		Reporter.info("Login Details", "Verify Login Details");
		Reporter.pass("Verify Login Details", "User ID is Displayed");
		Reporter.pass("Verify Login Details", "User Password is Displayed");
	//	test.log(LogStatus.FAIL, "Verify Login Details", "Login Button is Displayed");
	//	test.log(LogStatus.SKIP, "Verify Login Details", "SignUP Button is Displayed");
	}
	
	@Test
	public void fnTest2()
	{
		System.out.println("Test 2");
		Reporter.pass("Verify Registration Details", "User ID is Displayed");
		Reporter.pass("Verify Registration Details", "User Password is Displayed");
		test.log(LogStatus.FAIL, "Verify Registration Details", "Login Button is Displayed");
		Reporter.pass("Verify Registration Details", "SignUP Button is Displayed");
	}
	
	
}
