package com.automation.android.workflows;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.googledrive.GoogleDriveAPI;
import com.automation.reports.Reporter;

import io.appium.java_client.ios.IOSDriver;

public class CommonPage extends BasePage{
//Locators
	By DISCOVER=By.id("tv.hooq.android:id/tvDiscoverTitle");
	By LiveTV=By.id("tv.hooq.android:id/tvChannelsTitle");
	By MOVIES=By.id("tv.hooq.android:id/tvMoviesTitle");
	By TVSHOWS=By.id("tv.hooq.android:id/tvTvShowsTitle");
	By RENT=By.id("tv.hooq.android:id/tvPremiumTitle");
	/***
	 * Function Name :- fnSelectDiscover
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 * @throws Throwable 
	 */
	public  void fnSelectTab(String strTab) throws Throwable
	{
		try
		{
				if(strTab.toLowerCase().startsWith("disc"))
				{
					click(DISCOVER,"Discover Tab");
				}
				else if(strTab.toLowerCase().startsWith("livetv"))
				{
					click(LiveTV,"LiveTV Tab");
					Thread.sleep(10000);
					List<WebElement> eleList=driver.findElements(By.className("android.webkit.WebView"));
					if(eleList.size()>0)
					{
						Thread.sleep(10000);
						driver.navigate().back();						
					}
				}        
				else if(strTab.toLowerCase().startsWith("movies"))
				{
					click(MOVIES,"MOVIES Tab");
				}
				else if(strTab.toLowerCase().startsWith("tvshows"))
				{
					click(TVSHOWS,"TVSHOWS Tab");
				}
				else if(strTab.toLowerCase().startsWith("rent"))
				{
					click(RENT,"RENT Tab");
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Thread.sleep(10000);
	}
	/***
	 * Function Name :- waitForPleaseWaitDisappear
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
	public  void waitForPleaseWaitDisappear() throws Throwable {
    try {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("Please wait...")));
    } catch (Exception e) {
    }
	}
	
	/***
	 * Function Name :- fnGetTVODContent
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
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
	/***
	 * Function Name :- fnGetTrailerContent
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/	
	public String fnGetTrailerContent() throws IOException
	{
	String spreadsheetId=objData.SHEET_ID;
	String strText="";
	int intRowNo=2;
	String contentRange = "TVOD_Content"+"!E"+intRowNo+":E"+intRowNo;
	strText=GoogleDriveAPI.fnGetData(spreadsheetId,contentRange);
	System.out.println("Date Content for Day ==> " + intRowNo + " Content Name==> "+ strText);
	return strText;
	
}
	
	
	
}
