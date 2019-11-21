package com.automation.android.workflows;

import java.util.List;

import org.openqa.selenium.By;

import com.automation.reports.Reporter;

import io.appium.java_client.MobileElement;

public class SearchPage extends BasePage{
	//Locators
	By searchResultText=By.id("tv.hooq.android:id/txtAssetTitle");
	 By btnSearch = By.id("tv.hooq.android:id/search");
	 By btnSearchcc = By.id("cardnumber");
	 By searchmov = By.id("tv.hooq.android:id/imagePortrait");
	 By edtSearch = By.id("tv.hooq.android:id/inputSearch");
	 By searchresult = By.id("tv.hooq.android:id/matchedTitlesSection");
	 By matchResult= By.id("tv.hooq.android:id/matchedTitlesListView");
	 By discoverTbl=By.id("tv.hooq.android:id/discover_feed_list");
	 By banner=By.id("tv.hooq.android:id/spotlightLayout");
	 By contniueWatching=By.xpath("//android.widget.TextView[@text='Continue Watching']");
	 
	
	
	public boolean clickAndSearch(String strContent) throws Throwable 
	{
		boolean blnStatus=true;
		try
		{
			Reporter.info("HOOQ Android","Verifying Search");
			click(btnSearch, "Search button");
			type(edtSearch,strContent, "Enter Details for Search");
			Thread.sleep(10000);
			if(isElementPresent(searchresult))
			{
				MobileElement eleMobile=(MobileElement) driver.findElement(matchResult);		
		 		List<MobileElement> eleContent=eleMobile.findElements(By.className("android.widget.LinearLayout"));
		 		System.out.println(eleContent.size());
		 		if(eleContent.size()>0)
		 		{
		 			eleContent.get(0).click();
		 			Thread.sleep(10000);
		 			String strResultTitle=getText(searchResultText,"Search Result");
		 			if(strContent.toLowerCase().contains(strResultTitle.toLowerCase())==false)
		 			{
		 				blnStatus=false;
		 			}
		 		}
		 		else
		 		{
		 			blnStatus=false;
		 		}
			} 
			else{
				Reporter.fail("Search result match", "Search result match is not displayed");
				blnStatus=false;
			}
			}
			catch(Exception e){blnStatus=false;}
			return blnStatus;
	}
	
	
	
}
