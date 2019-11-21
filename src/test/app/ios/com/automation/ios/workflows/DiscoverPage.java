package com.automation.ios.workflows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.reports.Reporter;

public class DiscoverPage extends BasePage{
	//Locators
	By discover=By.id("DISCOVER");
	By DiscoverGenreTbl=By.xpath("//XCUIElementTypeTable");
	By youWereWatching= By.id("Continue Watching");
	By discoverTbl=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable");
	By quickLinksTbl=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]");
	/***
	 * Function Name :- verifyDiscoverFeed
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
	public  boolean verifyDiscoverFeed() throws Throwable{
		try {
			WebDriverWait wait = new WebDriverWait(driver,5);
			wait.until(ExpectedConditions.presenceOfElementLocated(discover));
		} catch (Exception e) {
			Reporter.fnPrintException(e);
			return false;
		}
		return true;
	}
	
	/***
	 * Function Name :- fnVerifyDiscoverSection
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
	public  boolean fnVerifyDiscoverSection(boolean blnAnynomous) throws Throwable
	{
		Reporter.info("HOOQ IOS","Verifying Discover Section");
		boolean blnStatus=true;
		try
		{
			commonPage.fnSelectTab("Discover");
			scrollJs("up");
			/*boolean blnBanner=isElementDisplayed(banner);
			if(blnBanner)
			{
				Reporter.pass("Discover Page","Banner is displayed");	
			}
			else
			{
				Reporter.fail("Discover Page","Banner is not displayed");
			}*/
			//Discover Tab QuickLinks
			if(fnVerifyQuickLinksDiscover())
			{
				Reporter.pass("Discover Page","Quick Links Section is displayed");	
			}
			else
			{
				Reporter.fail("Discover Page","Quick Links Section is not displayed");
				blnStatus=false;
			}
			Reporter.info("HOOQ IOS","Verifying Discover Page Genere");
			if(isElementDisplayed(DiscoverGenreTbl))
			{
				List<WebElement> eleTbl=driver.findElement(DiscoverGenreTbl).findElements(By.xpath("XCUIElementTypeCell"));
				if(eleTbl.size()>0)
				{
					Reporter.pass("Discover Page","Discover Genere :-  " + eleTbl.size() + " is displayed");
					for(int i=3;i<eleTbl.size();i++)
					{
						String strText=eleTbl.get(i).findElement(By.xpath("XCUIElementTypeStaticText")).getText();
						Reporter.pass("Discover Page","Discover Genere : "+strText + " is displayed");
					}
				}
			}
			else
			{
				Reporter.fail("Discover Page","Discover Genere is not displayed");
				blnStatus=false;
			}
			if(blnAnynomous==false)
			{
				Reporter.info("HOOQ IOS","Verifying Discover Page Continue Page");
				boolean blnContinueWathingHeader=isElementDisplayed(youWereWatching);
				if(blnContinueWathingHeader)
				{
					Reporter.pass("Discover Page","Continue Watching Section is displayed");	
				}
				else
				{
					Reporter.fail("Discover Page","Continue Watching Section is not displayed");
					blnStatus=false;
				}
			}
			
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			blnStatus=false;
		}
		return blnStatus;
	}
	public  boolean fnVerifyQuickLinksDiscover()
	{	
		Reporter.info("HOOQ IOS","Verifying Quick Section");
		boolean blnStatus=false;
		try
		{
			List<WebElement> eleQuickLinks=driver.findElement(quickLinksTbl).findElements(By.xpath("XCUIElementTypeButton"));
			if(eleQuickLinks.size()>0)
			{
				blnStatus=true;
				for(int i=0;i<eleQuickLinks.size();i++)
				{
					Reporter.pass("Discover Page Quick Links ","Quick Links : " + eleQuickLinks.get(i).getText()+"  is displayed");	
				}
			}
		}
		catch(Exception e)
		{
			
		}
		return blnStatus;
	}
}
