package com.automation.web.workflows;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.openqa.selenium.By;

import com.automation.accelerators.ActionEngine;
import com.automation.googledrive.GoogleDriveAPI;
import com.automation.reports.Reporter;

public class BasePage extends ActionEngine{

	String strBuildNo="";
	public static String strLastLogedUser=null;
	public static boolean FirstLogin = true;
	public static DiscoverPage discoverPage=new DiscoverPage();
	public static TVShowsPage tvshowspage =new TVShowsPage();
	public static MoviesPage moviesPage=new MoviesPage();
	public static RentPage rentPage=new RentPage();
	public static HamburgerPage hamburgerPage=new HamburgerPage();
	public static LoginPage loginPage=new LoginPage();
	public static SearchPage searchPage=new SearchPage();
	public static PlaybackPage playbackPage=new PlaybackPage();
	public static SignUpPage signUpPage =new SignUpPage();


	By appVersion = By.xpath("(//div[contains(@class,'AppStatus__Container-sc')]/p)[1]");


	public String fnGetBuildNo() throws Throwable
	{
		//info("HOOQ Web Test Script ","HOOQ Web Build No");
		try
		{
			//Navigate to Support
			String strBuildno="";
			if(isElementDisplayed(appVersion))
			{					
				Thread.sleep(5000);
				strBuildno=getText(appVersion, "Get App Version");
				Reporter.pass("Verify Application version", "Redirected to '"+strBuildno + "' and is displayed successfully"); 
				strBuildNo="Version : " + strBuildno;
				Thread.sleep(7000);
			}
			else
			{
				strBuildNo="Build Date :- " + strBuildno + LocalDateTime.now().toString();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			strBuildNo=LocalDateTime.now().toString();
		}		
		Reporter.info("HOOQ Web Test Script ","HOOQ Web Build No " + strBuildNo);
		objData.strBuildNo=strBuildNo;
		return strBuildNo;
	}

	public String fnGetTVODContent() throws IOException
	{
		String spreadsheetId=objData.SHEET_ID;
		String strText="";
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Date date = new Date();
		System.out.println("Current Date ==> " + dateFormat.format(date));
		int intRowNo=Integer.parseInt(dateFormat.format(date));
		intRowNo=intRowNo+1;
		String contentRange = "TVOD_Content"+"!B"+intRowNo+":B"+intRowNo;
		strText=GoogleDriveAPI.fnGetData(spreadsheetId,contentRange);
		System.out.println("Date Content for Day ==> " + intRowNo + " Content Name==> "+ strText);
		return strText;

	}
}
