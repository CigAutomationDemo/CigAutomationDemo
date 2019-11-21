package com.automation.android.workflows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.reports.Reporter;

public class MeHistoryPage extends BasePage{
	//Locators
	By HistoryTitle=By.id("tv.hooq.android:id/title");
	By lstHistory=By.id("tv.hooq.android:id/listView");
	By Edit=By.id("tv.hooq.android:id/btnCancel");
	By historyLogo=By.id("tv.hooq.android:id/emptyStateIcon");
	By Message=By.id("tv.hooq.android:id/emptyStateDesc");
	By lnkDiscover=By.id("tv.hooq.android:id/btnAction");
	By headerLogo=By.id("tv.hooq.android:id/headerLogo");
	By hisTopLayout=By.id("tv.hooq.android:id/appBarLayout");
	
	
	public boolean fnVerifyHistoryScreen(boolean strAction) throws Throwable {
		Reporter.info("HOOQ Android","Verifying Verifying History");
		boolean blnFound=true;
		try
		{
			mePage.fnSelectMESection("his");
			String strHeader=driver.findElement(hisTopLayout).findElement(HistoryTitle).getText();
			System.out.println(strHeader);
			if(strHeader.toLowerCase().contains("history"))
			{
				Reporter.pass("History Screen", "History Section is displayed");
			}
			else
			{
				Reporter.fail("History Screen", "History Section is not displayed");
			}
			boolean blnEmptyDownload=isElementDisplayed(historyLogo);
			if(blnEmptyDownload)
			{
				String strMessage=getText(Message,"History Message");
				boolean blnLink=isElementDisplayed(lnkDiscover);
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
					Reporter.pass("History Screen", "Default Empty Message is displayed");
				}
				else
				{
					Reporter.fail("History Screen", "Default Empty Message is  not displayed");		
				}
				if(blnLink)
				{
					Reporter.pass("History Screen", "Discover Link is displayed");
					click(lnkDiscover,"Discover Link");
					if(isElementDisplayed(headerLogo,"Discover Page"))
					{
						Reporter.pass("Discover Page Screen", "Discover Page is displayed");
					}
					else
					{
						Reporter.fail("Discover Page Screen", "Discover Page is not displayed");
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
				List<WebElement> eleComList=eleCom.findElements(By.className("android.widget.RelativeLayout"));
				if(eleComList.size()>0)
				{
					Reporter.pass("History Page Screen", "History Page is displayed with " + eleComList.size() + " Contents");
				}
				else
				{
					Reporter.fail("History Page Screen", "History Page is not displayed");
				}
				if(isElementDisplayed(Edit))
				{
					Reporter.pass("History Page Screen", "History Page Edit is displayed.");
				}
				else
				{
					Reporter.fail("History Page Screen", "History Page Edit is not displayed.");
				}
				driver.navigate().back();
			}
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			blnFound=false;
		}
		return blnFound;
	}

	public boolean fnVerifyHistoryScreenSelectContent() throws Throwable {
		Reporter.info("HOOQ Android","Verifying Verifying History");
		boolean blnFound=true;
		try
		{
			mePage.fnSelectMESection("his");
			String strHeader=driver.findElement(hisTopLayout).findElement(HistoryTitle).getText();
			System.out.println(strHeader);
			if(strHeader.toLowerCase().contains("history"))
			{
				Reporter.pass("History Screen", "History Section is displayed");
			}
			else
			{
				Reporter.fail("History Screen", "History Section is not displayed");
			}
			boolean blnEmptyDownload=isElementDisplayed(historyLogo);
			if(blnEmptyDownload)
			{
				blnFound=false;
			}
			else
			{
				WebElement eleCom=driver.findElement(lstHistory);
				List<WebElement> eleComList=eleCom.findElements(By.className("android.widget.RelativeLayout"));
				if(eleComList.size()>0)
				{
					Reporter.pass("History Page Screen", "History Page is displayed with " + eleComList.size() + " Contents");
					eleComList.get(0).click();
				}
				else
				{
					Reporter.fail("History Page Screen", "History Page is not displayed");
				}
				
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
