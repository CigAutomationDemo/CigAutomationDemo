package com.automation.ios.workflows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.reports.Reporter;

public class MeHistoryPage extends BasePage{
	//Locators
	By historyLogo=By.id("empState_History");
	By Message=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText");
	By lnkBrowse=By.name("Browse");
	By MoviesHeaderTitle=By.name("MOVIES");
	By HistoryTitle = By.name("HISTORY");
	By lstHistory=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView");
	By navBackBtn = By.name("navbar back btn");
	
	/***
	 * Function Name :- fnVerifyHistoryScreen
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public  boolean fnVerifyHistoryScreen(boolean blnAnnonymous) throws Throwable
	{
		Reporter.info("HOOQ IOS","Verifying Verifying History");
		boolean blnFound=true;
		try
		{
			mePage.fnSelectMESection("his");
			boolean blnEmptyDownload=isElementDisplayed(historyLogo);
			if(blnEmptyDownload)
			{
			String strMessage=getText(Message,"History Message");
			boolean blnLink=isElementDisplayed(lnkBrowse);
			boolean blnHeader=isElementDisplayed(HistoryTitle);
			if(blnHeader)
			{
				Reporter.pass("History Screen", "History Section is displayed");
			}
			else
			{
				Reporter.fail("History Screen", "History Section is not displayed");
			}
			if(blnEmptyDownload)
			{
				Reporter.pass("History Screen", "History Empty Logo is displayed");
			}
			else
			{
				Reporter.fail("History Screen", "History Empty Logo is not displayed");
			}
			if(strMessage.contains("Movies and TV Shows that you watch appear here"))
			{
				System.out.println(strMessage);
				Reporter.pass("History Screen", "Default Empty Message is displayed");
			}
			else
			{
				Reporter.fail("History Screen", "Default Empty Message is  not displayed");		
			}
			if(blnLink)
			{
				Reporter.pass("History Screen", "Browse Link is displayed");
				click(lnkBrowse,"Browse Link");
				if(isElementDisplayed(MoviesHeaderTitle,"Movies Page"))
				{
					Reporter.pass("Movies Page Screen", "MOvies Page is displayed");
				}
				else
				{
					Reporter.fail("Movies Page Screen", "Movies Page is not displayed");
				}
			}
			else
			{
				Reporter.fail("History Screen", "Browse Link is  not displayed");		
			}
			}
			else
			{
				WebElement eleCom=driver.findElement(lstHistory);
				List<WebElement> eleComList=eleCom.findElements(By.xpath("XCUIElementTypeCell"));
				if(eleComList.size()>0)
				{
					Reporter.pass("History Page Screen", "History Page is displayed with " + eleComList.size() + " Contents");
					
				}
				else
				{
					Reporter.fail("History Page Screen", "History Page is not displayed");
				}
				click(navBackBtn,"Back Button");	
			}
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			blnFound=false;
		}
		return blnFound;
	}
}
