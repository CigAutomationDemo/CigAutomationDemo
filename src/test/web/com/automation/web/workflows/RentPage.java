package com.automation.web.workflows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.automation.reports.Reporter;

public class RentPage extends BasePage{

	//SeeAll
	By discoverMenu =null;
	By seeAllLnkFstCollection =null;
	By BackArrow=null;
	By rentMenu =null;
	By hooqLogo=null;
	//Show More
	By showMoreLnkFstCollection =null;
	By showMoreFstCollection=null;
	//Trailer
	By watchTrailer =null;
	By contentTitleTxt =null;
	By appVersion =null;
	By trailerWindow =null;
	By playerWindow =null;
	By playerTitleName = null;

	//Rent with CC
	By rentforCC =null;
	By movieTitlefstTVShow=null;
	By rentViaMobilePopUp=null;
	By continueBrowsingBtn=null;
	By watchNowbtn=null;	
	By signupBtn =null;

	//Rent with Ticket
	By rentWithTicket =null;
	By redeemContent =null;
	By redeemConfirmBtn =null;
	By redeemCancelBtn =null;


	//Locators
	public void fnLoadLocators()
	{
		try{
			if(objConfig.strDriverType!=null)
			{
				if(objConfig.strDriverType.equals("chromemobileview"))
				{
					//SeeAll
					discoverMenu = By.xpath("(//*[contains(@class,'e2e-tab-discover')])[1]");
					seeAllLnkFstCollection = By.xpath("(//a[contains(@class,'e2e-seeAll FeedCollectionHeader__SeeAllLink')])[3]");
					BackArrow=By.xpath("(//div[contains(@class,'HeaderBackButton__BackButton')]/a/img)[1]");
					rentMenu = By.xpath("(//*[contains(@href,'/rent')])[1]");
					hooqLogo=By.xpath("(//a[contains(@class,'HOOQLogo__Wrapper-sc')])[1]");
					//Show More
					showMoreLnkFstCollection = By.xpath("(//a[contains(@class,'e2e-showMore PortraitCollectionGrid')])[3]");
					showMoreFstCollection=By.xpath("(//div[contains(@class, 'e2e-collectionGrid Card__Group-sc')])[3]/a");
					//Trailer
					watchTrailer = By.xpath("//*[contains(@class,'WatchTrailerButton')]");
					contentTitleTxt = By.xpath("//*[contains(@class,'e2e-titleHeader TitleBasicInfo__TitleHeader')]");
					appVersion = By.xpath("(//div[contains(@class,'AppStatus__Container-sc')]/p)[1]");
					trailerWindow = By.xpath("//div[@id='trailerPlayer']");
					playerWindow = By.xpath("//*[contains(@class,'VideoComponent__VideoWrapper-adotv8-0')]");
					playerTitleName = By.xpath("//*[contains(@class,'e2e-player-title')]");

					//Rent with CC
					rentforCC = By.xpath("//*[contains(text(),'Rent for')]");
					movieTitlefstTVShow=By.xpath("((//*[@class='e2e-portraitCollection'])[1]//div[2]/a[1]//img)[1]");
					rentViaMobilePopUp=By.xpath("//*[contains(@class,'PromptModalBase__ModalButtonGroup')]//a");
					continueBrowsingBtn=By.xpath("//*[contains(@class,'PromptModalBase__ModalButtonGroup')]//a[2]");
					watchNowbtn=By.xpath("//*[contains(@class,'TitleActionButtons__DesktopButtonContainer')]/a");	
					signupBtn = By.tagName("label");

					//Rent with Ticket
					rentWithTicket = By.xpath("//*[contains(text(),'Redeem your ticket')]");
					redeemContent = By.xpath("//*[contains(@class,'PromptModalBase__ModalButtonGroup')]");
					redeemConfirmBtn = By.xpath("//*[contains(@class,'PromptModalBase__ModalButtonGroup')]//a[1]");
					redeemCancelBtn = By.xpath("//*[contains(@class,'PromptModalBase__ModalButtonGroup')]//a[2]");


				}
				else if(objConfig.strDriverType.equals("androidchrome"))
				{
					//SeeAll
					discoverMenu = By.xpath("(//*[contains(@class,'e2e-tab-discover')])[1]");
					seeAllLnkFstCollection = By.xpath("(//a[contains(@class,'e2e-seeAll FeedCollectionHeader__SeeAllLink')])[3]");
					BackArrow=By.xpath("(//div[contains(@class,'HeaderBackButton__BackButton')]/a/img)[1]");
					rentMenu = By.xpath("(//*[contains(@href,'/rent')])[1]");
					hooqLogo=By.xpath("(//a[contains(@class,'HOOQLogo__Wrapper')])[1]");
					//Show More
					showMoreLnkFstCollection = By.xpath("(//a[contains(@class,'e2e-showMore PortraitCollectionGrid')])[3]");
					showMoreFstCollection=By.xpath("(//div[contains(@class, 'e2e-collectionGrid Card__Group-sc')])[3]/a");
					//Trailer
					watchTrailer = By.xpath("//*[contains(@class,'WatchTrailerButton')]");
					contentTitleTxt = By.xpath("//*[contains(@class,'e2e-titleHeader TitleBasicInfo__TitleHeader')]");
					appVersion = By.xpath("(//div[contains(@class,'AppStatus__Container-sc')]/p)[1]");
					trailerWindow = By.xpath("//div[@id='trailerPlayer']");
					playerWindow = By.xpath("//*[contains(@class,'VideoComponent__VideoWrapper-adotv8-0')]");
					playerTitleName = By.xpath("//*[contains(@class,'e2e-player-title')]");

					//Rent with CC
					rentforCC = By.xpath("//*[contains(text(),'Rent for')]");
					movieTitlefstTVShow=By.xpath("((//*[@class='e2e-portraitCollection'])[1]//div[2]/a[1]//img)[1]");
					rentViaMobilePopUp=By.xpath("//*[contains(@class,'PromptModalBase__ModalButtonGroup')]//a");
					continueBrowsingBtn=By.xpath("//*[contains(@class,'PromptModalBase__ModalButtonGroup')]//a[2]");
					watchNowbtn=By.xpath("//*[contains(@class,'TitleActionButtons__DesktopButtonContainer')]/a");	
					signupBtn = By.tagName("label");

					//Rent with Ticket
					rentWithTicket = By.xpath("//*[contains(text(),'Redeem your ticket')]");
					redeemContent = By.xpath("//*[contains(@class,'PromptModalBase__ModalButtonGroup')]");
					redeemConfirmBtn = By.xpath("//*[contains(@class,'PromptModalBase__ModalButtonGroup')]//a[1]");
					redeemCancelBtn = By.xpath("//*[contains(@class,'PromptModalBase__ModalButtonGroup')]//a[2]");

				}

				else if(objConfig.strDriverType.equals("desktopchrome"))
				{
					//SeeAll
					discoverMenu = By.xpath("(//*[contains(@class,'e2e-tab-discover')])[2]");
					seeAllLnkFstCollection = By.xpath("(//a[contains(@class,'e2e-seeAll DesktopFeedCollectionHeader__SeeAllLink')])[3]");
					BackArrow=By.xpath("(//div[contains(@class,'HeaderBackButton__BackButton')]/a/img)[1]");
					rentMenu = By.xpath("(//*[contains(@href,'/rent')])[2]");
					hooqLogo=By.xpath("//header[contains(@class,'desktop Header__HeaderContainer')]//a[contains(@class,'HOOQLogo__Wrapper')]");
					//Show More
					showMoreLnkFstCollection = By.xpath("(//a[contains(@class,'e2e-showMore PortraitCollectionGrid')])[3]");
					showMoreFstCollection=By.xpath("(//div[contains(@class, 'e2e-collectionGrid Card__Group-sc')])[3]/a");
					//Trailer
					watchTrailer = By.xpath("//*[contains(@class,'WatchTrailerButton')]");
					contentTitleTxt = By.xpath("//*[contains(@class,'e2e-titleHeader TitleBasicInfo__TitleHeader')]");
					appVersion = By.xpath("(//div[contains(@class,'AppStatus__Container-sc')]/p)[1]");
					trailerWindow = By.xpath("//div[@id='trailerPlayer']");
					playerWindow = By.xpath("//*[contains(@class,'VideoComponent__VideoWrapper-adotv8-0')]");
					playerTitleName = By.xpath("//*[contains(@class,'e2e-player-title')]");

					//Rent with CC
					rentforCC = By.xpath("//*[contains(text(),'Rent for')]");
					movieTitlefstTVShow=By.xpath("((//*[@class='slick-track'])[1]//div[1]//a[1]//img)[1]");
					rentViaMobilePopUp=By.xpath("//*[contains(@class,'PromptModalBase__ModalButtonGroup')]//a");
					continueBrowsingBtn=By.xpath("//*[contains(@class,'PromptModalBase__ModalButtonGroup')]//a[2]");
					watchNowbtn=By.xpath("//*[contains(@class,'TitleActionButtons__DesktopButtonContainer')]/a");	
					signupBtn = By.tagName("label");

					//Rent with Ticket
					rentWithTicket = By.xpath("//*[contains(text(),'Redeem your ticket')]");
					redeemContent = By.xpath("//*[contains(@class,'PromptModalBase__ModalButtonGroup')]");
					redeemConfirmBtn = By.xpath("//*[contains(@class,'PromptModalBase__ModalButtonGroup')]//a[1]");
					redeemCancelBtn = By.xpath("//*[contains(@class,'PromptModalBase__ModalButtonGroup')]//a[2]");


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
			click(rentMenu, "Discover");
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
			click(rentMenu, "Discover");
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

	public boolean verifyPlayTrailer(String userType) throws Throwable
	{
		fnLoadLocators();
		boolean result=false;
		try
		{
			searchPage.SearchSpecificItem("A Star Is Born");
			if(isElementDisplayed(watchTrailer))
			{
				String contentTitle =getText(contentTitleTxt, "Heading of collection is displayed successfully");
				Reporter.pass("Verify content details Play Btn ", "Play button is displayed in content details page");	
				JSClick(watchTrailer, "Clicked on Play button");
				Thread.sleep(5000);
				if(userType.equalsIgnoreCase("Visitor"))
				{					
					if(isElementDisplayed(By.xpath("//div[contains(@class,'PromptModalBase__ModalButtonGroup-sc')]/a[1]")))
					{
						Reporter.pass("Verify trailer for Anonymous user", "Signup page is displayed successfully while playing the trailer");	
						click(By.xpath("//div[contains(@class,'PromptModalBase__ModalButtonGroup-sc')]/a[2]"), "Click on continue watching");
						Thread.sleep(3000);
						driver.navigate().back();
						result=true;
					}
					else if(isElementDisplayed(trailerWindow))
					{
						Reporter.pass("Verify video player", "Able to play the trailer");	
						//String titleName = getText(WebLocators.titleTxt, "Get title");
						Reporter.pass("Verify trailer for Anonymous user", "Signup page is not displayed while playing the trailer");
						driver.navigate().back();
						result=true;
					}
					else if(isElementDisplayed(playerWindow))
					{
						Reporter.fail("Verify Movie for Anonymous user", "Able to play the content with anonymous user");
						result=false;
					}
					else
					{
						Reporter.fail("Verify Movie for Anonymous user", "Signup page is not displayed for  anonymous user");
						result=false;
					}
				}
				else if(userType.equalsIgnoreCase("Active") || userType.equalsIgnoreCase("Lapsed") )
				{
					if(isElementDisplayed(trailerWindow))
					{
						Reporter.pass("Verify video player", "Able to play the trailer");	
						String titleName = getText(playerTitleName, "Get title");
						if(titleName.contains(contentTitle))
						{
							Reporter.pass("Verify content title in content details page" , ""+ contentTitle +" " +  ""+ titleName+"" + " is Matched successfully");
							result=true;
						}
						else
						{
							Reporter.fail("Verify content title in content details page" ,  ""+ contentTitle +" " +  ""+ titleName+"" + " contents are not Matched");
							result=false;
						}
						Reporter.pass("Verify content title: ", contentTitle + "is displayed");
						driver.navigate().back();
					}
					else if(isElementDisplayed(playerWindow))
					{
						Reporter.fail("Verify Movie for Active/Lapsed user", "Able to play the content with anonymous user");
						result=false;
					}
					else
					{
						Reporter.fail("Verify Movie for Active/Lapsed user", "Signup page is not displayed for  anonymous user");
						result=false;
					}
				}					
			}
			else 
			{
				Reporter.pass("Verify content details Play Btn ", "Play button is not displayed in content details page");
				driver.navigate().back();
				Thread.sleep(3000);
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	public  boolean VerifyRentWithCC(String userType) throws Throwable
	{
		fnLoadLocators();
		boolean blnStatus=true;
		try
		{
			click(rentMenu,"click on Premium+ Tab");
			Thread.sleep(2000);
			click(movieTitlefstTVShow,"click on content");			
			if(isElementDisplayed(rentforCC))
			{	     
				if(userType.equalsIgnoreCase("Active") || userType.equalsIgnoreCase("Lapsed"))
				{
					click(rentforCC, "Rent for button");
					isElementDisplayed(rentViaMobilePopUp);
					Reporter.pass("Verify Rent via HOOQ app", "Rent via HOOQ app is displayed and Clicked on continue Browsing");
					click(continueBrowsingBtn, "Click on Continue watching button");
				}
				else if(userType.equalsIgnoreCase("visitor"))
				{  
					click(watchNowbtn, "Click on Subscribe to watch button");
					Thread.sleep(2000);
					isElementDisplayed(signupBtn);
					driver.navigate().back();
					driver.navigate().back();
					Reporter.pass("Verify rent for visitors", "We cannot Rent with Visitor for visitors");            	
				}
			}
			else
			{
				Reporter.pass("Verify Rent via HOOQ app", "Rent via HOOQ app is not displayed");
				driver.navigate().back();
				Thread.sleep(3000);
			}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return blnStatus;
	}

	public  boolean VerifyRentWithRedeemTicket(String userType) throws Throwable
	{
		fnLoadLocators();
		boolean blnStatus=true;
		try
		{
			String strTVODContent=fnGetTVODContent();
			searchPage.SearchSpecificItem(strTVODContent);
			Thread.sleep(2000);						
			String strText=getText(rentWithTicket, "Redeem Ticket Info");
			System.out.println(strText);
			if(strText.toLowerCase().contains("ticket"))
			{
				if(userType.equalsIgnoreCase("Active") || userType.equalsIgnoreCase("Lapsed"))
				{
					click(watchNowbtn, "Rent with ticket button");
					if(isElementDisplayed(redeemContent))
					{
						Reporter.pass("Verify Rent with ticket", "Rent with ticket is displayed and Clicked on cancel button");
						click(redeemCancelBtn, "Click on cancel button on redeem ticket");
						Thread.sleep(2000);
						click(watchNowbtn, "Rent with ticket button");
						Thread.sleep(2000);
						click(redeemConfirmBtn, "Click on cancel button on redeem ticket");
						Thread.sleep(2000);
						click(redeemCancelBtn, "Click on watchlater button on redeem ticket");
						Thread.sleep(2000);
						click(watchNowbtn, "Click on watch now button on redeemed Content");
						Thread.sleep(5000);
						String playerName = getText(playerTitleName,"Content Name");
						System.out.println(playerName);	
						Reporter.pass("Verify movie player for Active user", "Player window is displayed successfully while playing the Movie");	
						driver.navigate().back();
						Thread.sleep(3000);						
					}
					else
					{
						Reporter.fail("Verify Rent with ticket", "Rent with ticket is not displayed");
					}
				}
				else if(userType.equalsIgnoreCase("visitor"))
				{  
					click(watchNowbtn, "Click on Subscribe to watch button");
					Thread.sleep(2000);
					isElementDisplayed(signupBtn);
					driver.navigate().back();
					driver.navigate().back();
					Reporter.pass("Verify rent for visitors", "We cannot Rent with Visitor for visitors");            	
				}
			}
			else if(isElementDisplayed(watchNowbtn))
			{
				Reporter.pass("Redeem Ticket Info","Ticket is Already Redeemed successfully");
			}
		}   
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return blnStatus;
	}

	/*	public boolean verifyPlayTrailer(String userType) throws Throwable
	{
		fnLoadLocators();
		boolean result=false;
		try
		{
			Thread.sleep(3500);
			click(rentMenu,"click on Preminm+ Tab");
			Thread.sleep(3500);
			List<WebElement> Content = driver.findElements(By.xpath("(//*[@class='e2e-portraitCollection']//div[2])[1]//a//img"));			
			for(int i=1;i<=Content.size();i++)
			{	
				WebElement title = driver.findElement(By.xpath("(//*[@class='e2e-portraitCollection']//div[2])[1]//a["+i+"]//img"));
				String fstTitle=title.getAttribute("title");
				click(By.xpath("(//*[@class='e2e-portraitCollection']//div[2])[1]//a["+i+"]"),"Click on content");
				if(isElementDisplayed(watchTrailer))
				{
					Reporter.pass("Verify content details Play Btn ", "Play button is displayed in content details page");	
					JSClick(watchTrailer, "Clicked on Play button");
					Thread.sleep(5000);
					if(userType.equalsIgnoreCase("Visitor"))
					{					
						if(isElementDisplayed(By.xpath("//div[contains(@class,'PromptModalBase__ModalButtonGroup-sc')]/a[1]")))
						{
							Reporter.pass("Verify trailer for Anonymous user", "Signup page is displayed successfully while playing the trailer");	
							click(By.xpath("//div[contains(@class,'PromptModalBase__ModalButtonGroup-sc')]/a[2]"), "Click on continue watching");
							Thread.sleep(3000);
							driver.navigate().back();
							result=true;
						}
						else if(isElementDisplayed(trailerWindow))
						{
							Reporter.pass("Verify video player", "Able to play the trailer");	
							//String titleName = getText(WebLocators.titleTxt, "Get title");
							Reporter.pass("Verify trailer for Anonymous user", "Signup page is not displayed while playing the trailer");
							driver.navigate().back();
							//click(By.xpath("//div[contains(@class,'PromptModalBase__ModalButtonGroup-sc-1')]/a[2]"), "Click on continue watching");
							result=false;
						}
						else if(isElementDisplayed(playerWindow))
						{
							Reporter.fail("Verify Movie for Anonymous user", "Able to play the content with anonymous user");
							result=false;
						}
						else
						{
							Reporter.fail("Verify Movie for Anonymous user", "Signup page is not displayed for  anonymous user");
							result=false;
						}
						break;
					}
					else if(userType.equalsIgnoreCase("Active") || userType.equalsIgnoreCase("Lapsed") )
					{
						if(isElementDisplayed(trailerWindow))
						{
							Reporter.pass("Verify video player", "Able to play the trailer");	
							String titleName = getText(playerTitleName, "Get title");
							if(titleName.contains(fstTitle))
							{
								Reporter.pass("Verify content title in content details page" , ""+ fstTitle +" " +  ""+ titleName+"" + " is Matched successfully");
								result=true;
							}
							else
							{
								Reporter.fail("Verify content title in content details page" ,  ""+ fstTitle +" " +  ""+ titleName+"" + " contents are not Matched");
								result=false;
							}
							Reporter.pass("Verify content title: ", titleName+ "is displayed");
							driver.navigate().back();

						}
						else if(isElementDisplayed(playerWindow))
						{
							Reporter.fail("Verify Movie for Active/Lapsed user", "Able to play the content with anonymous user");
							result=false;
						}
						else
						{
							Reporter.fail("Verify Movie for Active/Lapsed user", "Signup page is not displayed for  anonymous user");
							result=false;
						}
					}
					break;
				}
				else 
				{
					Reporter.pass("Verify content details Play Btn ", "Play button is not displayed in content details page");
					driver.navigate().back();
					Thread.sleep(3000);
				}	
			}		
			Thread.sleep(4000);
			String strBuildNo=getText(appVersion, "Get App Version");
			Reporter.pass("Verify Application version", "Redirected to '"+strBuildNo + "' and is displayed successfully"); 
			//driver.navigate().back();
			Thread.sleep(2000);
			click(hooqLogo,"click on HOOQ logo");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}*/
}
