package com.automation.web.workflows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.automation.reports.Reporter;

public class MoviesPage extends BasePage{


	//SeeAll
	By discoverMenu =null;
	By seeAllLnkFstCollection =null;
	By BackArrow=null;
	By moviesMenu =null;	
	//Show More
	By showMoreLnkFstCollection =null;
	By showMoreFstCollection=null;
	By hooqLogo=null;

	//Locators
		public void fnLoadLocators()
		{
			try{
				if(objConfig.strDriverType!=null)
				{
					if(objConfig.strDriverType.equals("chromemobileview"))
					{
						discoverMenu = By.xpath("(//*[contains(@class,'e2e-tab-discover')])[1]");
						seeAllLnkFstCollection = By.xpath("(//a[contains(@class,'e2e-seeAll FeedCollectionHeader__SeeAllLink')])[3]");
						BackArrow=By.xpath("(//div[contains(@class,'HeaderBackButton__BackButton')]/a/img)[1]");
						moviesMenu = By.xpath("(//*[contains(@href,'/movies')])[1]");	
						//Show More
						showMoreLnkFstCollection = By.xpath("(//a[contains(@class,'e2e-showMore PortraitCollectionGrid')])[3]");
						showMoreFstCollection=By.xpath("(//div[contains(@class, 'e2e-collectionGrid Card__Group-sc')])[3]/a");
						hooqLogo=By.xpath("(//a[contains(@class,'HOOQLogo__Wrapper-sc')])[1]");

					}
					else if(objConfig.strDriverType.equals("androidchrome"))
					{
						discoverMenu = By.xpath("(//*[contains(@class,'e2e-tab-discover')])[1]");
						seeAllLnkFstCollection = By.xpath("(//a[contains(@class,'e2e-seeAll FeedCollectionHeader__SeeAllLink')])[3]");
						BackArrow=By.xpath("(//div[contains(@class,'HeaderBackButton__BackButton')]/a/img)[1]");
						moviesMenu = By.xpath("(//*[contains(@href,'/movies')])[1]");	
						//Show More
						showMoreLnkFstCollection = By.xpath("(//a[contains(@class,'e2e-showMore PortraitCollectionGrid')])[3]");
						showMoreFstCollection=By.xpath("(//div[contains(@class, 'e2e-collectionGrid Card__Group-sc')])[3]/a");
						hooqLogo=By.xpath("(//a[contains(@class,'HOOQLogo__Wrapper')])[1]");

					}
					else if(objConfig.strDriverType.equals("desktopchrome"))
					{
						discoverMenu = By.xpath("(//*[contains(@class,'e2e-tab-discover')])[2]");
						seeAllLnkFstCollection = By.xpath("(//a[contains(@class,'e2e-seeAll DesktopFeedCollectionHeader__SeeAllLink')])[3]");
						BackArrow=By.xpath("(//div[contains(@class,'HeaderBackButton__BackButton')]/a/img)[1]");
						moviesMenu = By.xpath("(//*[contains(@href,'/movies')])[2]");	
						//Show More
						showMoreLnkFstCollection = By.xpath("(//a[contains(@class,'e2e-showMore PortraitCollectionGrid')])[3]");
						showMoreFstCollection=By.xpath("(//div[contains(@class, 'e2e-collectionGrid Card__Group-sc')])[3]/a");
						hooqLogo=By.xpath("(//a[contains(@class,'HOOQLogo__Wrapper')])[1]");

					}
				}
			}
			catch(Exception e){}
		}
	
	
	public boolean verifySeeAll() throws Throwable
	{
		fnLoadLocators();
		boolean result=false;
		try
		{
			Thread.sleep(7000);
			click(moviesMenu, "Discover");
			Thread.sleep(2000);
			if(isElementDisplayed(seeAllLnkFstCollection))
			{
				Reporter.pass("Verify See All link ","See All link is displayed successfully");
				JSClick(seeAllLnkFstCollection, "See All");
				Thread.sleep(7000);
				String collectionName=getText(By.xpath("//img[@title='Back']//following-sibling::span"), "Heading of collection is displayed successfully");
				Thread.sleep(3000);
				Reporter.pass("See all collection Title is " , " '' " + collectionName + " '' " + " collection page is displayed successfully");
				if(isElementDisplayed(BackArrow))
				{
					List<WebElement> seeAllSize=driver.findElements(By.xpath("//div[contains(@class,'Card__Group-sc')]//a//div//div/img"));
					for(int i=0;i< seeAllSize.size();i++)
					{
						int seeAllLst = seeAllSize.size();
						String contentTxt= seeAllSize.get(i).getAttribute("title");
						Reporter.pass("Verify Content Details ", ""+ seeAllLst  + "count and "+ " " + contentTxt + "  is dispalyed successfully");
					}			
					Reporter.pass("Verify Back Arrow","Back Arrow is displayed successfully");
					click(BackArrow, "Back Arrow");
					Thread.sleep(5000);
					if(isElementDisplayed(hooqLogo))
					{
						Reporter.pass("Verify Home Page"," Hooq logo is displayed successfully");
					}
					else
					{
						Reporter.fail("Verify Home Page"," Hooq logo is not displayed successfully");
					}
					result=true;
				}
				else
				{
					Reporter.fail("Click See All","Unable to click See All");
					Reporter.fail("Verify Back Arrow","Back Arrow is not displayed");
				}
			}
			else
			{
				Reporter.fail("Verify See All link ","See All link is not displayed successfully");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

	public boolean verifyShowMore() throws Throwable
	{
		fnLoadLocators();
		boolean result=false;
		try
		{
			Thread.sleep(4000);
			click(moviesMenu, "Discover");
			if(isElementDisplayed(hooqLogo))
			{
				Reporter.pass("Verify Home Page"," Hooq logo is displayed successfully");
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(showMoreLnkFstCollection));
				/*Actions actions = new Actions(driver);
				actions.moveToElement((WebElement) WebLocators.showMoreLnkFstCollection);
				actions.perform();*/
				Thread.sleep(2000);
				if(isElementDisplayed(showMoreLnkFstCollection))
				{
					Reporter.pass("Verify Show More"," Show More link is displayed successfully");
					Thread.sleep(3000);
					JSClick(showMoreLnkFstCollection, "Show More Link");
					Thread.sleep(7000);
					List<WebElement> showMoreCollSize=driver.findElements(showMoreFstCollection);
					if(showMoreCollSize.size()>7)
					{
						Reporter.pass("Verify Show More Collection Title"," 7 or More Than 7 collection titles are displayed ");
					}
					else
					{
						Reporter.fail("Verify Show More Collection Title"," Less than 7 collection titles are displayed ");
					}
					result=true;

				}
				else
				{
					Reporter.fail("Verify Show More"," Show More link is not displayed");
				}
				Thread.sleep(2000);
			}
			else
			{
				Reporter.fail("Verify Home Page"," Hooq logo is not displayed successfully");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}


}
