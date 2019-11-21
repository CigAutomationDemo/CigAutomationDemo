
package com.automation.web.workflows;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.automation.reports.Reporter;

public class DiscoverPage extends BasePage {

	//Spotlight Locators
	By hamburgerMenu = null;
	By hamburgerDiscoverMenu  =null;
	By spotlight =null;
	By contentTitleTxt =null;
	By watchNowbtn=null;
	By signupBtn =null;
	By playerwindow =null;
	By playerTitleName =null;
	By novaPageValidation=null;
	By hooqlogoNew=null;
	By footerSignUP =null;
	By restrictedContent = null;
	// QuickLinks
	By quickLinksTab =null;
	By collectionName=null;
	By hooqLogo=null;

	//SeeAll
	By discoverMenu =null;
	By seeAllLnkFstCollection =null;
	By BackArrow=null;

	//Show More
	By showMoreLnkFstCollection =null;
	By showMoreFstCollection=null;

	//Footer Links 
	By footerTermsOfUse=null;
	By footerAboutUS =null;
	By footerFAQ =null;
	By footerContactUs=null;
	By footerPrivacyPOlicy =null;

	//Content details 
	By movieTitlefstTVShow=null;
	By ContentDetails =null;
	By moviesMenu =null;	
	By rentMenu =null;

	//Similar titles
	By similarTitlesTxt =null;
	By similarTitleslst =null;
	
	//Locators
		public void fnLoadLocators()
		{
			try{
				if(objConfig.strDriverType!=null)
				{
					if(objConfig.strDriverType.equals("chromemobileview"))
					{
						//Spotlight Locators
						hamburgerMenu = By.xpath("(//img[@title='Menu'])[1]");
						hamburgerDiscoverMenu = By.xpath("//ul[contains(@class, 'SideMenu__NavMenu')]//li[1]//a");
						spotlight = By.xpath(".//*[@aria-hidden='false']/div/a/div[2]");
						contentTitleTxt = By.xpath("//*[contains(@class,'e2e-titleHeader TitleBasicInfo__TitleHeader')]");
						watchNowbtn=By.xpath("//*[contains(@class,'TitleActionButtons__DesktopButtonContainer')]/a");
						signupBtn = By.tagName("label");
						playerwindow = By.xpath("//*[contains(@class,'VideoComponent__VideoWrapper')]");
						playerTitleName = By.xpath("//*[contains(@class,'e2e-player-title')]");
						novaPageValidation=By.xpath("//div[@id='payment-mount']//ul");
						hooqlogoNew=By.xpath("//*[@id='payment-mount']/section/div/a");
						footerSignUP = By.xpath("(//*[@href='/auth/signup'])[2]");
						restrictedContent = By.xpath("//*[contains(@class,'PromptModalBase__ModalHeader')]");
						
						// QuickLinks
						quickLinksTab = By.xpath("//a[contains(@class,'QuickLinkButton__QuickLinkButtonContainer')]");
						collectionName=By.cssSelector("[class*='typo__Title3Heading']");
						hooqLogo=By.xpath("(//a[contains(@class,'HOOQLogo__Wrapper')])[1]");

						//SeeAll
						discoverMenu = By.xpath("(//*[contains(@class,'e2e-tab-discover')])[1]");
						seeAllLnkFstCollection = By.xpath("(//a[contains(@class,'e2e-seeAll FeedCollectionHeader__SeeAllLink')])[3]");
						BackArrow=By.xpath("(//div[contains(@class,'HeaderBackButton__BackButton')]/a/img)[1]");

						//Show More
						showMoreLnkFstCollection = By.xpath("(//a[contains(@class,'e2e-showMore PortraitCollectionGrid')])[3]");
						showMoreFstCollection=By.xpath("(//div[contains(@class, 'e2e-collectionGrid Card__Group-sc')])[3]/a");

						//Footer Links 
						footerTermsOfUse= By.xpath("//*[@href='/terms-of-use']");
						footerAboutUS = By.xpath("//*[@href='/about-us']");
						footerFAQ = By.xpath("//*[@href='https://hooq.desk.com/customer/en/portal/articles']");
						footerContactUs= By.xpath("//div[contains(@class,'PageFooter__FooterLinks')]/a[5]");
						footerPrivacyPOlicy = By.xpath("//*[@href='/privacy-policy']");

						//Content details 
						movieTitlefstTVShow=By.xpath("((//*[@class='e2e-portraitCollection'])[1]//div[2]/a[1]//img)[1]");
						ContentDetails = By.cssSelector("[class*='MobileTitle__MobileContainer']>div>div");
						moviesMenu = By.xpath("(//*[contains(@href,'/movies')])[1]");	
						rentMenu = By.xpath("(//*[contains(@href,'/rent')])[1]");

						//Similar titles
						similarTitlesTxt = By.xpath("//*[contains(@class,'e2e-gridTitle FeedCollectionHeader__FeedCollectionTitle')]");
						similarTitleslst = By.xpath("//*[contains(@class,'e2e-collectionGrid Card__Group-sc')]//a//img");
					}
					else if(objConfig.strDriverType.equals("androidchrome"))
					{
						//Spotlight Locators
						hamburgerMenu = By.xpath("//*[@id='mount']/header[1]/div/a[2]/img");
						hamburgerDiscoverMenu = By.xpath("//ul[contains(@class, 'SideMenu__NavMenu')]//li[1]//a");
						spotlight = By.xpath(".//*[@aria-hidden='false']/div/a/div[2]");
						contentTitleTxt = By.xpath("//*[contains(@class,'e2e-titleHeader TitleBasicInfo__TitleHeader')]");
						watchNowbtn=By.xpath("//*[contains(@class,'TitleActionButtons__DesktopButtonContainer')]/a");
						signupBtn = By.tagName("label");
						playerwindow = By.xpath("//*[contains(@class,'VideoComponent__VideoWrapper')]");
						playerTitleName = By.xpath("//*[contains(@class,'e2e-player-title')]");
						novaPageValidation=By.xpath("//div[@id='payment-mount']//ul");
						hooqlogoNew=By.xpath("//*[@id='payment-mount']/section/div/a");
						footerSignUP = By.xpath("(//*[@href='/auth/signup'])[2]");
						restrictedContent = By.xpath("//*[contains(@class,'PromptModalBase__ModalHeader')]");
						
						// QuickLinks
						quickLinksTab = By.xpath("//a[contains(@class,'QuickLinkButton__QuickLinkButtonContainer')]");
						collectionName=By.cssSelector("[class*='typo__Title3Heading']");
						hooqLogo=By.xpath("(//a[contains(@class,'HOOQLogo__Wrapper')])[1]");

						//SeeAll
						discoverMenu = By.xpath("(//*[contains(@class,'e2e-tab-discover')])[1]");
						seeAllLnkFstCollection = By.xpath("(//a[contains(@class,'e2e-seeAll FeedCollectionHeader__SeeAllLink')])[3]");
						BackArrow=By.xpath("(//div[contains(@class,'HeaderBackButton__BackButton')]/a/img)[1]");

						//Show More
						showMoreLnkFstCollection = By.xpath("(//a[contains(@class,'e2e-showMore PortraitCollectionGrid')])[3]");
						showMoreFstCollection=By.xpath("(//div[contains(@class, 'e2e-collectionGrid Card__Group-sc')])[3]/a");

						//Footer Links 
						footerTermsOfUse= By.xpath("//*[@href='/terms-of-use']");
						footerAboutUS = By.xpath("//*[@href='/about-us']");
						footerFAQ = By.xpath("//*[@href='https://hooq.desk.com/customer/en/portal/articles']");
						footerContactUs= By.xpath("//div[contains(@class,'PageFooter__FooterLinks')]/a[5]");
						footerPrivacyPOlicy = By.xpath("//*[@href='/privacy-policy']");

						//Content details 
						movieTitlefstTVShow=By.xpath("((//*[@class='e2e-portraitCollection'])[1]//div[2]/a[1]//img)[1]");
						ContentDetails = By.cssSelector("[class*='MobileTitle__MobileContainer']>div>div");
						moviesMenu = By.xpath("(//*[contains(@href,'/movies')])[1]");	
						rentMenu = By.xpath("(//*[contains(@href,'/rent')])[1]");

						//Similar titles
						similarTitlesTxt = By.xpath("//*[contains(@class,'e2e-gridTitle FeedCollectionHeader__FeedCollectionTitle')]");
						similarTitleslst = By.xpath("//*[contains(@class,'e2e-collectionGrid Card__Group-sc')]//a//img");
					}
					if(objConfig.strDriverType.equals("desktopchrome"))
					{
						//Spotlight Locators
						hamburgerMenu = By.xpath("(//img[@title='Menu'])[2]");
						hamburgerDiscoverMenu = By.xpath("//header[contains(@class,'desktop Header__HeaderContainer')]//a[contains(@class,'HOOQLogo__Wrapper')]");
						spotlight = By.xpath(".//*[contains(@class,'SpotlightCard__CardTitle')]");
						contentTitleTxt = By.xpath("//*[contains(@class,'e2e-titleHeader TitleBasicInfo__TitleHeader')]");
						watchNowbtn=By.xpath("//*[contains(@class,'TitleActionButtons__DesktopButtonContainer')]/a");
						signupBtn = By.tagName("label");
						playerwindow = By.xpath("//*[contains(@class,'VideoComponent__VideoWrapper')]");
						playerTitleName = By.xpath("//*[contains(@class,'e2e-player-title')]");
						novaPageValidation=By.xpath("//div[@id='payment-mount']//ul");
						hooqlogoNew=By.xpath("//*[@id='payment-mount']/section/div/a");
						footerSignUP = By.xpath("(//*[@href='/auth/signup'])[2]");

						// QuickLinks
						quickLinksTab = By.xpath("//*[contains(@class,'DesktopQuickLinkButton__DesktopQuickLinkButtonContainer')]//div");
						collectionName=By.cssSelector("[class*='Breadcrumbs__BreadcrumbTitleDiv']");
						hooqLogo=By.xpath("(//a[contains(@class,'HOOQLogo__Wrapper')])[1]");

						//SeeAll
						discoverMenu = By.xpath("(//*[contains(@class,'e2e-tab-discover')])[2]");
						seeAllLnkFstCollection = By.xpath("(//a[contains(@class,'e2e-seeAll DesktopFeedCollectionHeader__SeeAllLink')])[3]");
						BackArrow=By.xpath("//header[contains(@class,'desktop Header__HeaderContainer')]//a[contains(@class,'HOOQLogo__Wrapper')]");

						//Show More
						showMoreLnkFstCollection = By.xpath("(//a[contains(@class,'e2e-showMore PortraitCollectionGrid')])[3]");
						showMoreFstCollection=By.xpath("(//div[contains(@class, 'e2e-collectionGrid Card__Group-sc')])[3]/a");

						//Footer Links 
						footerTermsOfUse= By.xpath("//*[@href='/terms-of-use']");
						footerAboutUS = By.xpath("//*[@href='/about-us']");
						footerFAQ = By.xpath("//*[@href='https://hooq.desk.com/customer/en/portal/articles']");
						footerContactUs= By.xpath("//div[contains(@class,'PageFooter__FooterLinks')]/a[5]");
						footerPrivacyPOlicy = By.xpath("//*[@href='/privacy-policy']");

						//Content details 
						movieTitlefstTVShow=By.xpath("((//*[@class='slick-track'])[1]//div[1]//a[1]//img)[1]");
						ContentDetails = By.cssSelector("[class*='DesktopTopContainer__DetailContainer']>div>div");
						moviesMenu = By.xpath("(//*[contains(@href,'/movies')])[2]");	
						rentMenu = By.xpath("(//*[contains(@href,'/rent')])[2]");

						//Similar titles
						similarTitlesTxt = By.xpath("//*[contains(@class,'e2e-gridTitle DesktopFeedCollectionHeader__FeedCollectionTitle')]");
						similarTitleslst = By.xpath("//*[contains(@class,'slick-track')]//a//img");
					}
					
				}
			}
			catch(Exception e){}
		}
	
		
	public boolean verifySimilarTitlesContents(String ContentType) throws Throwable
	{
		fnLoadLocators();
		boolean blnStatus=false;
		try
		{				
			Thread.sleep(10000);
			if(ContentType=="Movies")
			{
				click(moviesMenu, "Movies");
			}
			else if(ContentType=="Discover")
			{
				JSClick(hamburgerMenu, "HamburgerMenu");
				click(hamburgerDiscoverMenu, "Discover");
			}
			else if(ContentType=="Rent")
			{
				click(rentMenu, "Rent");
			}
			Thread.sleep(4000);
			waitForElementPresent(movieTitlefstTVShow,"");
			WebElement title = driver.findElement(movieTitlefstTVShow);
			String fstTitle=title.getAttribute("title");
			Reporter.pass("Verify Content Title on Movies page" , fstTitle + " is dispalyed successfully");
			JSClick(movieTitlefstTVShow, "Click on content");
			Thread.sleep(10000);
			String contentName=getText(contentTitleTxt,"");
			if(fstTitle.equalsIgnoreCase(contentName))
			{
				Reporter.pass("Verify content title in content details page" , ""+ fstTitle +"" +  ""+ contentName+"" + " is Matched successfully");
				blnStatus=true;
			}
			else
			{
				Reporter.fail("Verify content title in content details page" ,  ""+ fstTitle +"" +  ""+ contentName+"" + " contents are not Matched");
			}
			Thread.sleep(10000);
			List<WebElement> similarTitleslstTxt =driver.findElements(similarTitleslst);
			for(int i=0;i< similarTitleslstTxt.size();i++)
			{
				String contentTxt= similarTitleslstTxt.get(i).getAttribute("title");
				Reporter.pass("Verify Content Details " , contentTxt + "  is dispalyed successfully");
			}
			Thread.sleep(3000);
			driver.navigate().back();
			Thread.sleep(2000);
			click(hooqLogo,"Succuessfully clicked on HOOQ Logo");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return blnStatus;
	}
	
	public boolean verifyContentDetails(String ContentType) throws Throwable
	{
		fnLoadLocators();
		boolean blnStatus=false;
		try
		{				
			Thread.sleep(10000);
			if(ContentType=="Movies")
			{
				click(moviesMenu, "Movies");
			}
			else if(ContentType=="Discover")
			{
				JSClick(hamburgerMenu, "HamburgerMenu");
				click(hamburgerDiscoverMenu, "Discover");
			}
			else if(ContentType=="Rent")
			{				
				click(rentMenu, "Rent");
			}
			waitForElementPresent(movieTitlefstTVShow,"");
			WebElement title = driver.findElement(movieTitlefstTVShow);
			String fstTitle=title.getAttribute("title");
			Reporter.pass("Verify Content Title on Movies page" , fstTitle + " is dispalyed successfully");
			click(movieTitlefstTVShow, "Click on content");
			Thread.sleep(10000);
			String contentName=getText(contentTitleTxt,"");
			if(fstTitle.equalsIgnoreCase(contentName))
			{
				Reporter.pass("Verify content title in content details page" , ""+ fstTitle +"" +  ""+ contentName+"" + " is Matched successfully");
				blnStatus=true;
			}
			else
			{
				Reporter.fail("Verify content title in content details page" ,  ""+ fstTitle +"" +  ""+ contentName+"" + " contents are not Matched");
			}
			Thread.sleep(10000);
			List<WebElement> contentDetails=driver.findElements(ContentDetails);
			for(int i=0;i< contentDetails.size();i++)
			{
				String contentTxt= contentDetails.get(i).getText();	
				Reporter.pass("Verify Content Details " , contentTxt + "  is dispalyed successfully");
			}
			Thread.sleep(3000);
			driver.navigate().back();
			Thread.sleep(2000);
			click(hooqLogo,"Succuessfully clicked on HOOQ Logo");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return blnStatus;
	}

	public boolean verifySpotlight(String userType) throws Throwable
	{
		fnLoadLocators();
		boolean result=true;
		try
		{
			Thread.sleep(5000);
			String spotlightTxt = getText(spotlight, "getext of first spolight");
			System.out.println(spotlightTxt);
			JSClick(spotlight, "Click on spolight");
			Thread.sleep(4000);
			String contentName=getText(contentTitleTxt,"gettext of content title");
			if(spotlightTxt.equalsIgnoreCase(contentName))
			{
				Reporter.pass("Verify content title in content details page" , ""+ spotlightTxt +" " +  " "+ contentName+"" + " is Matched successfully");
				result=true;
				if(isElementDisplayed(watchNowbtn))
				{
					if(isElementDisplayed(watchNowbtn))
					{
						Reporter.pass("Verify content details Play Btn ", "Play button is displayed in content details page");	
						JSClick(watchNowbtn, "Clicked on Play button");
					}
					Thread.sleep(3000);
					if(userType.equalsIgnoreCase("Visitor"))
					{
						Thread.sleep(3000);
						if(isElementDisplayed(signupBtn))
						{
							String signupPage=getText(signupBtn, "Sign UP Page");
							Reporter.pass("Verify Sign up", "Redirected to '"+signupPage + "' and is displayed successfully for Visitor user");
							driver.navigate().back();
							driver.navigate().back();
							result=true;
						}						
						/*else if(isElementDisplayed(By.xpath("//div[contains(@class,'PromptModalBase__ModalButtonGroup-sc-1')]/a[1]")))
						{
							Reporter.pass("Verify movie player for Visitor user", "Signup page is displayed successfully while playing the Movie for the Visitor user ");	
							click(By.xpath("//div[contains(@class,'PromptModalBase__ModalButtonGroup-sc-1')]/a[2]"), "Click on continue watching");
							Thread.sleep(3000);
							driver.navigate().back();
							result=true;
						}*/
						else if(isElementDisplayed(By.xpath("//div[@id='trailerPlayer']")))
						{
							Reporter.pass("Verify video player", "Able to play the trailer");	
							//String titleName = getText(WebLocators.titleTxt, "Get title");
							Reporter.pass("Verify Movie for Visitor user", "Signup page is not displayed while playing the trailer");
							driver.navigate().back();
							result=true;
						}
						else if(isElementDisplayed(playerwindow))
						{
							Thread.sleep(10000);	
							click(playerwindow, "player window");
							String playerName = getText(playerTitleName,"Content Name");
							System.out.println(playerName);	
							Thread.sleep(4000);		
							Reporter.pass("Verify movie player for Active user", "Player window is displayed successfully while playing the pilot episode");	
							driver.navigate().back();
							Thread.sleep(3000);
							//driver.navigate().back();
							result=true;
						}
						else 
						{
							Reporter.fail("Verify Movie for Visitor user", "Signup page is not displayed while playing the content with Visitor user");
							result=false;
						}
					}		
					else if(userType.equalsIgnoreCase("Active"))
					{
						
						if(isElementDisplayed(restrictedContent))
						{
							for (int j = 1;j <= 4; j++)
							{
								driver.findElement(By.xpath("(//*[@type='tel'])["+j+"]")).sendKeys(String.valueOf(j));
							}
							Thread.sleep(2000);
						}
						else
						{
							Reporter.pass("Verify restricted content for SG", "Restricted content is present for SG");
						}
						if(isElementDisplayed(By.xpath("//div[@id='trailerPlayer']")))
						{
							//String titleName = getText(WebLocators.titleTxt, "Get title");
							Reporter.pass("Verify Movie for Active user", "Trailer window is displayed for Active user from discover page");
							driver.navigate().back();
							result=true;
						}
						else if(isElementDisplayed(playerwindow))
						{
							Thread.sleep(15000);		
							if(!(isElementDisplayed(playerTitleName)))
							{
								JSClick(playerwindow,"Click on player window");
							}
							String playerName = getText(playerTitleName,"Content Name");
							System.out.println(playerName);	
							Thread.sleep(4000);		
							Reporter.pass("Verify movie player for Active user", "Player window is displayed successfully while playing the Movie" +playerName+"");	
							driver.navigate().back();
							Thread.sleep(3000);
							//driver.navigate().back();
							result=true;
							if(isElementDisplayed(watchNowbtn))
							{
								Reporter.pass("Verify content deatails", "content deatils page is displayed after clicking on back button");	
								driver.navigate().back();
							}
						}
						else 
						{
							Reporter.fail("Verify movie player for Active user", "Player window is not displayed while playing the Movie");
							result=false;
						}	

					}
					else if(userType.equalsIgnoreCase("Lapsed"))
					{
						Thread.sleep(2000);
						if(isElementDisplayed(novaPageValidation))
						{
							Reporter.pass("Verify movie player for Lapsed user", "Nova planselector page is displayed successfully while playing the Movie");	
							JSClick(hooqlogoNew,"Click on HOOQ logo");
							Thread.sleep(3000);
							System.out.println(driver.getCurrentUrl());
							driver.navigate().to(objConfig.strURL);
							result=true;
						}						
						else if(isElementDisplayed(playerwindow))
						{
							Reporter.pass("Verify video player", "Able to play the pilot episode");	
							//String titleName = getText(WebLocators.titleTxt, "Get title");
							Reporter.pass("Verify trailer for Lapsed user", "Signup page is not displayed while playing the pilot episode");
							driver.navigate().back();
							result=true;
						}
						else if(isElementDisplayed(footerSignUP))
						{
							driver.navigate().to(objConfig.strURL);
							Thread.sleep(4000);
							String url= driver.getCurrentUrl();
							Reporter.pass("Verify content details URL", url+" displayed successfully"); 	
							result= true;
						}
						else 
						{
							Reporter.fail("Verify movie player for Lapsed user", "Nova planselector page is not displayed while playing the Movie");
							result=false;
						}
					}
				}
			}
			else
			{
				Reporter.fail("Verify content title in content details page" , ""+ spotlight +"" +  ""+ contentName+"" + " are not Matching");
				result=true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

	public boolean verifyQuickLinks() throws Throwable
	{
		fnLoadLocators();
		boolean blnStatus=false;
		try
		{
			Thread.sleep(2000);
			if(isElementDisplayed(hooqLogo))
			{
				Reporter.pass("Verify Hooq Logo ","Hooq Logo is displayed successfully");
				blnStatus=true;
			}
			else
			{
				Reporter.fail("Verify Hooq Logo ", "Hooq Logo is not displayed");
			}
			Thread.sleep(2000);
			if(isElementDisplayed(quickLinksTab))
			{
				List<WebElement> lst=driver.findElements(quickLinksTab);
				for(int i=1;i<=lst.size();i++)
				{
					Thread.sleep(3000);
					WebElement strt;						
					String menuTabsTxt= getText(By.xpath("//a[contains(@class,'QuickLinkButton__QuickLinkButtonContainer')]["+i+"]"),"");						
					strt= driver.findElement(By.xpath("//a[contains(@class,'QuickLinkButton__QuickLinkButtonContainer')]["+i+"]"));
					strt.click();
					Thread.sleep(7000);
					String getcollectionName =getText(collectionName, "Collection name is displayed");
					Reporter.pass("Verify Quick links tabs on Discover page" , menuTabsTxt + " is dispalyed successfully and clicked ");
					Thread.sleep(3000);
					if(menuTabsTxt.contains(getcollectionName))
					{
						Reporter.pass("Verify Quick links Collection name" , getcollectionName  +" "+  menuTabsTxt +  " is displayed successfully");
						driver.navigate().back();
					}
					else
					{
						Reporter.fail("Verify Quick links Collection name" , getcollectionName  + " "+ menuTabsTxt +  " is not displayed");
						driver.navigate().back();
					}	
				}
				click(hooqLogo,"clcik on hooq logo");
			}
			else
			{
				Reporter.fail("Verify Quick links", "Verify Quick links is not displayed");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
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
			//click(discoverMenu, "Discover");
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
			//click(discoverMenu, "Discover");
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

	public boolean verifyFooterLnks() throws Throwable
	{
		fnLoadLocators();
		boolean result=false;
		try
		{
			Thread.sleep(2000);
			String currentWindow = driver.getWindowHandle();
			//ScrollPageUpDown((AppiumDriver)driver,"down");
			Thread.sleep(1500);
			JSClick(footerTermsOfUse, "Terms of use");
			Thread.sleep(10000);
			Set<String> windows=driver.getWindowHandles();
			System.out.println(windows.size());
			for(String newWindow : windows )
			{
				driver.switchTo().window(newWindow);
			}
			Thread.sleep(1500);
			String TermsOfUse= driver.findElement(By.tagName("h1")).getText();
			driver.close();
			Thread.sleep(10000);
			Reporter.pass("Verify Footer Links", " "+TermsOfUse+" displayed successfully"); 			
			driver.switchTo().window(currentWindow);

			///privacy policy
			Thread.sleep(2000);
			String currentWindow1 = driver.getWindowHandle();
			JSClick(footerPrivacyPOlicy,"Privacy Policy");
			Thread.sleep(10000);
			Set<String> windows1=driver.getWindowHandles();
			for(String newWindow1 : windows1 )
			{
				driver.switchTo().window(newWindow1);
			}
			Thread.sleep(1500);
			String PrivacyPolicy= driver.findElement(By.tagName("h1")).getText();
			driver.close();
			Thread.sleep(10000);
			//System.out.println(driver.getWindowHandles().size());
			Reporter.pass("Verify Footer Links", " "+PrivacyPolicy+" displayed successfully"); 			
			driver.switchTo().window(currentWindow1);

			//About US
			String currentWindow2 = driver.getWindowHandle();
			JSClick(footerAboutUS,"About Us");
			Thread.sleep(10000);
			Set<String> windows2=driver.getWindowHandles();
			for(String newWindow2 : windows2 )
			{
				driver.switchTo().window(newWindow2);
			}
			Thread.sleep(1500);
			String AboutUs= driver.findElement(By.tagName("h1")).getText();
			driver.close();
			Thread.sleep(10000);
			//System.out.println(driver.getWindowHandles().size());
			Reporter.pass("Verify Footer Links", " "+AboutUs+" displayed successfully"); 			
			driver.switchTo().window(currentWindow2);
			Thread.sleep(2000);

			//FAQ
			Thread.sleep(2000);
			String currentWindow3 = driver.getWindowHandle();
			JSClick(footerFAQ,"FAQ");
			Thread.sleep(10000);
			Set<String> windows3=driver.getWindowHandles();
			for(String newWindow3 : windows3 )
			{
				driver.switchTo().window(newWindow3);
			}
			Thread.sleep(5000);
			String FAQ = driver.findElement(By.tagName("h2")).getText();
			driver.close();
			Thread.sleep(10000);
			//System.out.println(driver.getWindowHandles().size());
			Reporter.pass("Verify Footer Links", " "+FAQ+" displayed successfully"); 			
			driver.switchTo().window(currentWindow3);

			//Contact us 
			Thread.sleep(4000);
			String currentWindow4 = driver.getWindowHandle();
			JSClick(footerContactUs,"ContactUs");
			Thread.sleep(10000);
			Set<String> windows4=driver.getWindowHandles();
			for(String newWindow4 : windows4 )
			{
				driver.switchTo().window(newWindow4);
			}
			Thread.sleep(4500);
			String ContactUs= driver.findElement(By.xpath("//li[@class='active crumb']")).getText();
			driver.close();
			Thread.sleep(10000);
			//System.out.println(driver.getWindowHandles().size());
			Reporter.pass("Verify Footer Links", " "+ContactUs+" displayed successfully"); 			
			driver.switchTo().window(currentWindow4);
			JSClick(hooqLogo,"Succuessfully clicked on HOOQ Logo");
			result= true;

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

}
