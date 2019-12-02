package com.automation.test.management;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.Assert;

import com.automation.accelerators.ConfigDetails;
import com.automation.accelerators.TestEngine;
import com.automation.googledrive.ReportStatus;
import com.automation.reports.Reporter;
import com.automation.utilities.FileUtilities;
import com.automation.utilities.HOOQInput;
public class TestRailTestRunStatus {
		public TestRailAPI objDemo=null;
		
		public TestRailTestRunStatus(String strProject,String strTestSuite,String strRunName)
		{
			 this.objDemo=new TestRailAPI();
			 this.objDemo.setProjectSuiteId(strProject,strTestSuite);
			 this.objDemo.createRun(strRunName);
		}
		
		public static void fnReportStatus(int scriptID) 
		{
			try
			{
				String strStatus="untested";
				if(ReportStatus.blnStatus)
				{
					strStatus="pass";
				}
				else
				{
					strStatus="fail";
				}
				int intStatus=0;
				if(strStatus.toLowerCase().startsWith("pass"))
				{
					intStatus=1;
				}
				else if(strStatus.toLowerCase().startsWith("block"))
				{
					intStatus=2;
				}
				else if(strStatus.toLowerCase().startsWith("untes"))
				{
					intStatus=3;
				}
				else if(strStatus.toLowerCase().startsWith("retest"))
				{
					intStatus=4;
				}
				else if(strStatus.toLowerCase().startsWith("fail"))
				{
					intStatus=5;
				}
				TestEngine.testRailStatus.objDemo.addStatusForCase(intStatus, scriptID);
				System.out.println("\n**********************************************");
				System.out.println("Test Rail Details Updated  " );
				System.out.println("Script ID :- " + scriptID);
				System.out.println("Script Status :- " + strStatus);
				System.out.println("\n**********************************************");
			}catch(Exception e){}
		}
		
		
		public static String fnGetTestRailRunInstance(ConfigDetails objConfig,HOOQInput objData)
		{
			String strTestRunInstance="";
			try
			{
				String strCountry=objData.COUNTRY;
				String strEnvironment=objData.ENV;
				String strOS=objConfig.strOSName.toUpperCase();
				String Browser="";
				if(objConfig.strApplicationType.toLowerCase().startsWith("browser"))
				{
					Browser=objConfig.strBrowserName.toUpperCase();
				}
				String ExecutionType=TestEngine.ExecutionType.toUpperCase();
				SimpleDateFormat format = new SimpleDateFormat("dd MMM yyy");
		        Date date = new Date();
		        String strName = format.format(date);
		        System.out.println(strName);
				strName=strName.replaceAll(":", "_").replaceAll("-", "_").replaceAll(" ", "_");
				System.out.println(strName);
				if(objConfig.strApplicationType.toLowerCase().startsWith("browser"))
				{
					strTestRunInstance=strCountry+"_"+strEnvironment+"_"+strOS+"_"+Browser+"_"+ExecutionType+"_"+strName;
				}
				else
				{
					
					strTestRunInstance=strCountry+"_"+strEnvironment+"_"+strOS+"_HOOQ_APP_"+ExecutionType;
				}
				
				if(objConfig.strApplicationType.toLowerCase().startsWith("browser")==false)
				{
					if(ExecutionType.toLowerCase().contains("sanity"))
					{
						strTestRunInstance=strTestRunInstance+"_"+strName;
					}
					else if(ExecutionType.toLowerCase().contains("internal"))
					{
						strTestRunInstance=strTestRunInstance+"_"+strName+objData.strBuildNo;
					}
					else
					{
						strName=fnGetWeekSequence();
						strTestRunInstance=strTestRunInstance+"_"+strName;
					}
				}
			}catch(Exception e){Reporter.fnPrintException(e);}
			return strTestRunInstance;
		}
		
		public  static String fnGetWeekSequence()
		{
			String strText="";
			try
			{
				//Get calendar set to current date and time
			    Calendar c = Calendar.getInstance();
			    // Set the calendar to monday of the current week
			     c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			    // Print dates of the current week starting on Monday
			    DateFormat df = new SimpleDateFormat("EEE_dd_MMM_yyyy");
			   	String strStartWeek=df.format(c.getTime());
			    for (int i = 0; i <4; i++) 
			    {
			       c.add(Calendar.DATE, 1);
			    }
				String strEndWeek=df.format(c.getTime());
				strText="From_"+strStartWeek+"_To_"+strEndWeek;
			}
			catch(Exception e){}
			return strText;
			}
		
		
}
