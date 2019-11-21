package com.automation.web.workflows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.automation.reports.Reporter;

public class TVShowsPage extends BasePage{

	//Content Details
	By tvShowMenu =null;
	By movieTitlefstTVShow=null;
	By contentTitleTxt =null;
	By ContentDetails =null;
	By episodeName=null;
	By episodeDuration=null;
	By episodeDetail=null;
	By hooqLogo=null;
	
	//SeeAll
	By discoverMenu =null;
	By seeAllLnkFstCollection =null;
	By BackArrow=null;
		
	//Show More
	By showMoreLnkFstCollection =null;
	By showMoreFstCollection=null;

	//Locators
		public void fnLoadLocators()
		{
			try{
				if(objConfig.strDriverType!=null)
				{
					if(objConfig.strDriverType.equals("chromemobileview"))
					{
						//Content Details
						tvShowMenu = By.xpath("(//*[contains(@href,'/tv-shows')])[1]");
						movieTitlefstTVShow=By.xpath("((//*[@class='e2e-portraitCollection'])[1]//div[2]/a[1]//img)[1]");
						contentTitleTxt = By.xpath("//*[contains(@class,'e2e-titleHeader TitleBasicInfo__TitleHeader')]");
						ContentDetails = By.cssSelector("[class*='TitleBasicInfo__Container']>div");
						episodeName=By.xpath("(//div[contains(@class,'EpisodeList__EpisodeDetail')]//h3)[1]");
						episodeDuration=By.xpath("//div[contains(@class,'EpisodeList__EpisodeDetail')]//div[2]");
						episodeDetail=By.xpath("//div[contains(@class,'EpisodeList__EpisodeDetail')]//p");
						hooqLogo=By.xpath("(//a[contains(@class,'HOOQLogo__Wrapper-sc')])[1]");
						
						//SeeAll
						discoverMenu = By.xpath("(//*[contains(@class,'e2e-tab-discover')])[1]");
						seeAllLnkFstCollection = By.xpath("(//a[contains(@class,'e2e-seeAll FeedCollectionHeader__SeeAllLink')])[3]");
						BackArrow=By.xpath("(//div[contains(@class,'HeaderBackButton__BackButton')]/a/img)[1]");
							
						//Show More
						showMoreLnkFstCollection = By.xpath("(//a[contains(@class,'e2e-showMore PortraitCollectionGrid')])[3]");
						showMoreFstCollection=By.xpath("(//div[contains(@class, 'e2e-collectionGrid Card__Group-sc')])[3]/a");
					}
					else if(objConfig.strDriverType.equals("androidchrome"))
					{
						//Content Details
						tvShowMenu = By.xpath("(//*[contains(@href,'/tv-shows')])[1]");
						movieTitlefstTVShow=By.xpath("((//*[@class='e2e-portraitCollection'])[1]//div[2]/a[1]//img)[1]");
						contentTitleTxt = By.xpath("//*[contains(@class,'e2e-titleHeader TitleBasicInfo__TitleHeader')]");
						ContentDetails = By.cssSelector("[class*='TitleBasicInfo__Container']>div");
						episodeName=By.xpath("(//div[contains(@class,'EpisodeList__EpisodeDetail')]//h3)[1]");
						episodeDuration=By.xpath("//div[contains(@class,'EpisodeList__EpisodeDetail')]//div[2]");
						episodeDetail=By.xpath("//div[contains(@class,'EpisodeList__EpisodeDetail')]//p");
						hooqLogo=By.xpath("(//a[contains(@class,'HOOQLogo__Wrapper')])[1]");
						
						//SeeAll
						discoverMenu = By.xpath("(//*[contains(@class,'e2e-tab-discover')])[1]");
						seeAllLnkFstCollection = By.xpath("(//a[contains(@class,'e2e-seeAll FeedCollectionHeader__SeeAllLink')])[3]");
						BackArrow=By.xpath("(//div[contains(@class,'HeaderBackButton__BackButton')]/a/img)[1]");
							
						//Show More
						showMoreLnkFstCollection = By.xpath("(//a[contains(@class,'e2e-showMore PortraitCollectionGrid')])[3]");
						showMoreFstCollection=By.xpath("(//div[contains(@class, 'e2e-collectionGrid Card__Group-sc')])[3]/a");
					}
					
					if(objConfig.strDriverType.equals("desktopchrome"))
					{
						//Content Details
						tvShowMenu = By.xpath("(//*[contains(@href,'/tv-shows')])[2]");
						movieTitlefstTVShow=By.xpath("((//*[@class='slick-track'])[1]//div[1]//a[1]//img)[1]");
						contentTitleTxt = By.xpath("//*[contains(@class,'e2e-titleHeader TitleBasicInfo__TitleHeader')]");
						ContentDetails = By.cssSelector("[class*='TitleBasicInfo__Container']>div");
						episodeName=By.xpath("(//div[contains(@class,'EpisodeList__EpisodeDetail')]//h3)[1]");
						episodeDuration=By.xpath("//div[contains(@class,'EpisodeList__EpisodeDetail')]//div[2]");
						episodeDetail=By.xpath("//div[contains(@class,'EpisodeList__EpisodeDetail')]//p");
						hooqLogo=By.xpath("//header[contains(@class,'desktop Header__HeaderContainer')]//a[contains(@class,'HOOQLogo__Wrapper')]");
						
						//SeeAll
						discoverMenu = By.xpath("(//*[contains(@class,'e2e-tab-discover')])[2]");
						seeAllLnkFstCollection = By.xpath("(//a[contains(@class,'e2e-seeAll DesktopFeedCollectionHeader__SeeAllLink')])[3]");
						BackArrow=By.xpath("(//div[contains(@class,'HeaderBackButton__BackButton')]/a/img)[1]");
							
						//Show More
						showMoreLnkFstCollection = By.xpath("(//a[contains(@class,'e2e-showMore PortraitCollectionGrid')])[3]");
						showMoreFstCollection=By.xpath("(//div[contains(@class, 'e2e-collectionGrid Card__Group-sc')])[3]/a");
					}
				}
			}
			catch(Exception e){}
		}
	
	public boolean verifyContentDetails() throws Throwable
	{
		fnLoadLocators();
		boolean blnStatus=false;
		try
		{
			Thread.sleep(10000);
			click(tvShowMenu, "TV SHOWS");
			Thread.sleep(7000);
			waitForElementPresent(movieTitlefstTVShow,"");
			WebElement title = driver.findElement(movieTitlefstTVShow);
			String fstTitle=title.getAttribute("title");
			Reporter.pass("Verify Content Title on TV Shows page" , fstTitle + " is dispalyed successfully");
			click(movieTitlefstTVShow, "Click on content");
			Thread.sleep(10000);
			String contentName=getText(contentTitleTxt,"");
			if(fstTitle.equalsIgnoreCase(contentName))
			{
				Reporter.pass("Verify content title in content details page" , ""+ fstTitle +" " +  " "+ contentName+"" + " is Matched successfully");
				blnStatus=true;
			}
			else
			{
				Reporter.fail("Verify content title in content details page" ,  ""+ fstTitle +" " +  " "+ contentName+"" + " contents are not Matched");
			}
			Thread.sleep(10000);
			List<WebElement> contentDetails=driver.findElements(ContentDetails);
			for(int i=0;i< contentDetails.size();i++)
			{
				String contentTxt= contentDetails.get(i).getText();	
				Reporter.pass("Verify Content Details " , contentTxt + "  is dispalyed successfully");
			}

			//click(By.xpath("//div[@class='EpisodeList__EpisodeDetail-s1d8ke12-4 ixQOYt'][1]"),"V button");
			Thread.sleep(3000);
			String getEpisodeName=getText(episodeName, "Episode Name");
			String getEpisodeDuration=getText(episodeDuration, "Episode Duration");
			String getEpisodeDetail=getText(episodeDetail, "Episode Detail");
			if(driver.getPageSource().contains(getEpisodeName)&&driver.getPageSource().contains(getEpisodeDuration)&&driver.getPageSource().contains(getEpisodeDetail) )
			{
				Reporter.pass("Verify Content Details Episode Name" , getEpisodeName + " is displayed successfully");
				Reporter.pass("Verify Content Details Episode Duration" , getEpisodeDuration + " is displayed successfully");
				Reporter.pass("Verify Detail of Episode summary " , "Summary is : " + getEpisodeDetail + " is displayed successfully");

			}
			else
			{
				Reporter.fail("Verify Content Details Episode Name" , episodeName+ " is not displayed successfully");
				Reporter.fail("Verify Content Details Episode Duration" , episodeDuration+ " is not displayed successfully");
				Reporter.fail("Verify Content Details Episode Detail" , episodeDetail+ " is not displayed successfully");
			}

			driver.navigate().back();
			//click(WebLocators.BackArrow, "Back Arrow");
			Thread.sleep(2000);
			click(hooqLogo,"Succuessfully clicked on HOOQ Logo");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return blnStatus;
	}
	
	public boolean verifySeeAll() throws Throwable
	{
		fnLoadLocators();
		boolean result=false;
		try
		{
			Thread.sleep(7000);
			click(tvShowMenu, "Discover");
			Thread.sleep(2000);
			if(isElementDisplayed(seeAllLnkFstCollection))
			{
				Reporter.pass("Verify See All link ","See All link is displayed successfully");
				JSClick(seeAllLnkFstCollection, "See All");
				Thread.sleep(7000);
				String collectionName=getText(By.xpath("//img[@title='Back']//following-sibling::span"), "Heading of collection is displayed successfully");
				Thread.sleep(7000);
				if(isElementDisplayed(BackArrow))
				{
					Reporter.pass("See all collection Title is " , " '' " + collectionName + " '' " + " collection page is displayed successfully");
					Reporter.pass("Verify Back Arrow","Back Arrow is displayed successfully");
					click(BackArrow, "Back Arrow");
					Thread.sleep(10000);
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
			click(tvShowMenu, "Discover");
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
