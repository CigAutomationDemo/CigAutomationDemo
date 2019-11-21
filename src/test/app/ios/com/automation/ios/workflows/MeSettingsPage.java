package com.automation.ios.workflows;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.reports.Reporter;

public class MeSettingsPage extends BasePage{
	//Locators
	By lstMe=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell");
	By langMeHeader=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeNavigationBar/XCUIElementTypeStaticText/XCUIElementTypeStaticText");
	By langSubDetil1=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeImage/XCUIElementTypeStaticText[1]");
	By langSubDetil2=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeImage/XCUIElementTypeStaticText[2]");
	By langDaownloads=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText");
	By langRentals=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeStaticText");
	By langWatchLater=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[3]/XCUIElementTypeStaticText");
	By langFav=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[4]/XCUIElementTypeStaticText");
	By langHistory=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[4]/XCUIElementTypeStaticText");
	By langSettings=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[5]/XCUIElementTypeStaticText");
	By langSubscription=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[6]/XCUIElementTypeStaticText");
	By langTransactionHistory=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[7]/XCUIElementTypeStaticText");
	By langSupport=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[8]/XCUIElementTypeStaticText");
	By langLinkTV=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[9]/XCUIElementTypeStaticText");
	By langLogOut=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[10]/XCUIElementTypeStaticText[1]");
	By langRentHeader=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeNavigationBar/XCUIElementTypeStaticText/XCUIElementTypeStaticText");
	By langRentPopup=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeButton");
	By langBrowse=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeNavigationBar/XCUIElementTypeStaticText/XCUIElementTypeStaticText");
	By settingTable=By.xpath("//XCUIElementTypeTable");
	By settingsHeading = By.name("SETTINGS");
	By appDisplayHeading= By.name("App Display Language");
	By appDisplayLanguage = By.xpath("//XCUIElementTypeCell[1]/XCUIElementTypeButton");
	By audioTrackHeading = By.name("Audio Track");
	By audioTrackInSettings = By.xpath("//XCUIElementTypeCell[2]/XCUIElementTypeButton");
	By subtitlesHeading = By.name("Subtitles");
	By subtitles = By.xpath("//XCUIElementTypeCell[3]/XCUIElementTypeButton");
	By playbackQualityHeading = By.name("Playback Quality");
	By playbackQuality = By.xpath("//XCUIElementTypeCell[4]/XCUIElementTypeButton");
	By downloadQualityHeading = By.name("Download Quality");
	By downloadQuality = By.xpath("//XCUIElementTypeCell[5]/XCUIElementTypeButton");
	By mobileDataHeading = By.name("Mobile Data Usage");
	By mobileDataDesc = By.name("HOOQ will use mobile data to stream and download videos.");
	By mobileDataSwitch = By.name("Mobile Data Usage, HOOQ will use mobile data to stream and download videos.");
	By appAudioTypeList=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTable");
	By appLanguagePopup=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeButton");
	By navBackBtn = By.name("navbar back btn");
	By cancel = By.name("Cancel");
	By rentPage = By.xpath("//XCUIElementTypeTabBar/XCUIElementTypeButton[3]");
	By browsePage = By.xpath("//XCUIElementTypeTabBar/XCUIElementTypeButton[2]");
	/***
	 * Function Name :- fnChangetoLanguageEnglish
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public  void fnChangetoLanguageEnglish() throws Throwable
	{
		try
		{
			mePage.fnSelectME();
			List<WebElement> eleList=driver.findElements(lstMe);
			String strText="";
			boolean blnChange=false;
			if(eleList.size()==9)
			{
				strText=getText(langLinkTV,"LogOut");
				if(strText.toLowerCase().equals("login")==false)
				{
					blnChange=true;
				}
			}
			else if(eleList.size()==10)
			{
				strText=getText(langLogOut,"LogOut / Login Text");
				if(strText.toLowerCase().equals("logout")==false)
				{
					if(strText.toLowerCase().equals("login")==false)
					{
						blnChange=true;
					}
				}
			}
			if(blnChange)
			{
				mePage.fnSelectMESection("sett");
				click(appDisplayLanguage,"Application Display Language Settings");
				List<WebElement> eleAudioList=driver.findElement(appAudioTypeList).findElements(By.xpath("XCUIElementTypeCell"));
				eleAudioList.get(0).click();
				fnCloseAppChanePopup();
				if(isElementDisplayed(navBackBtn))
				{
					click(navBackBtn,"Back From Settings page");
				}
			}
			if(isElementDisplayed(navBackBtn))
			{
				click(navBackBtn,"Back From ME page");
			}
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
		}
	}
	/***
	 * Function Name :- fnCloseAppChanePopup
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public  void fnCloseAppChanePopup() throws Throwable
	{
		try
		{
			if(isElementDisplayed(By.name("Okay")))
			{
				click(By.name("Okay"),"Popup Closed");
			}
			else
			{
				//Find the popup
				List<WebElement> elePopup=driver.findElements(appLanguagePopup);
				System.out.println(elePopup.size());
				if(elePopup.size()>0)
				{
					elePopup.get(0).click();
				}
			}
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
		}
	}
	
	
	/***
	 * Function Name :- fnVerifySettingsPage
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public  boolean fnVerifySettingsPage() throws Throwable
	{
		Reporter.info("HOOQ IOS","Verifying Settings");
		boolean blnFound=true;
		try
		{
				//Go to Me Section
				mePage.fnSelectMESection("sett");
				Reporter.info("HOOQ Settings Screen","Verifying Settings Screen");
				List<WebElement> eleList=driver.findElement(settingTable).findElements(By.xpath("XCUIElementTypeCell"));
				System.out.println(eleList.size());
				if(eleList.size()==7)
				{
					Reporter.pass("Verify App Setting page","Setting page is is Displayed");
				}
				else
				{
					Reporter.fail("Verify App Setting page","Setting page is not Displayed");
				}
				Reporter.info("HOOQ Settings Screen","Verifying Settings Components");
				for(int i=0;i<eleList.size();i++)
				{
					String strText=eleList.get(i).findElement(By.xpath("XCUIElementTypeStaticText")).getText();
					if(strText.length()>0)
					{
						Reporter.pass("Verify App Setting page","Setting for " + strText + " is Displayed");
					}
				}
				click(navBackBtn,"Back From Settings page");
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			blnFound=false;
		}
		return blnFound;
		
	}
	
	public boolean fnVerifySettingsAppLangauge(String strLanguage,boolean blnAnonymous) throws Throwable
	{
		boolean blnStatus=true;
		try
		{
			//Verify all Available Language
			//Go to Me Section
			mePage.fnSelectMESection("sett");
			//Click on Audio Track setting
			click(appDisplayLanguage,"Application Display Language Settings");
			//Get the all App Display  Language
			List<WebElement> eleAudioList=driver.findElement(appAudioTypeList).findElements(By.xpath("XCUIElementTypeCell"));
			if(fnVerifyAppLanguageList(eleAudioList))
			{
				Reporter.pass("Verify App Display Language List","All Pre-Defined Application Display Language are displayed successfully.");
			}
			else
			{
				Reporter.fail("Verify App Display Languag List","All Pre-Defined Application Display Language are not displayed successfully.");
			}
			click(cancel,"Cancel");
			click(navBackBtn,"Back From Settings page");
			if(eleAudioList.size()>0)
			{
				//Go to Me Section
				mePage.fnSelectMESection("sett");
				click(appDisplayLanguage,"Application Display Language Settings");
				List<WebElement> eleAudioList1=driver.findElement(appAudioTypeList).findElements(By.xpath("XCUIElementTypeCell"));
				if(strLanguage.toLowerCase().contains("eng"))
				{
					eleAudioList1.get(0).click();
				}
				else if(strLanguage.toLowerCase().contains("thai"))
				{
					eleAudioList1.get(1).click();
				}
				else if(strLanguage.toLowerCase().contains("bahasa"))
				{
					eleAudioList1.get(2).click();
				}
				//Close Popup
				fnCloseAppChanePopup();
				fnVerifyLanguageSettings(strLanguage,blnAnonymous);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
		}
		fnChangetoLanguageEnglish();
		return blnStatus;
	}
	
	public static boolean fnVerifyAppLanguageList(List<WebElement> eleAudioList) throws Throwable
	{
	boolean blnFound=true;
	List<String> eleAudio=new ArrayList<String>();
	eleAudio.add("English");
	eleAudio.add("Thai");
	eleAudio.add("Bahasa Indonesia");
		try
		{
		for(int i=0;i<eleAudio.size();i++)
		{
			boolean blnMatch=false;
			System.out.println(eleAudio.get(i));
			for(int j=0;j<eleAudioList.size();j++)
			{
				String str1=eleAudioList.get(j).findElement(By.xpath("XCUIElementTypeStaticText")).getText();
				if(eleAudio.get(i).equals(str1))
				{
					blnMatch=true;
					break;
				}
			}
			if(blnMatch)
			{
				Reporter.pass("Verify App Display Language List",eleAudio.get(i) +  " is displayed successfully.");
			}
			else
			{
				Reporter.fail("Verify App Display Language List",eleAudio.get(i) +  " is not displayed successfully.");				
				blnFound=false;
			}
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return blnFound;
	}
	
	
	public void fnVerifyLanguageSettings(String strLanguage,boolean blnAnonymous) throws Throwable
	{
		try
		{
			//Click on Me Tab
			mePage.fnSelectME();
			String strlangMeHeader=getText(langMeHeader,"Me Page Header");
			System.out.println(strlangMeHeader);
			String strlangSubDetil1="";
			String strlangSubDetil2="";
			if(blnAnonymous==false)
			{
				strlangSubDetil1=getText(langSubDetil1,"Sub Title 1");
				System.out.println(strlangSubDetil1);
				strlangSubDetil2=getText(langSubDetil2,"Sub Title 2");
				System.out.println(strlangSubDetil2);
			}
			String strlangDaownloads=getText(langDaownloads,"Downlad");
			System.out.println(strlangDaownloads);
			String strlangRentals=getText(langRentals,"Rentals");
			System.out.println(strlangRentals);
			String strlangWatchLater=getText(langWatchLater,"Watch Later");
			System.out.println(strlangWatchLater);
			/*String strlangFav=getText(MePageLocators.langFav,"Favorite");
			System.out.println(strlangFav);*/
			String strlangHistory=getText(langHistory,"History");
			System.out.println(strlangHistory);
			String strlangSettings=getText(langSettings,"Settings");
			System.out.println(strlangSettings);
			String strlangSubscription=getText(langSubscription,"Subscription");
			System.out.println(strlangSubscription);
			String strlangTransactionHistory=getText(langTransactionHistory,"Transaction History");
			System.out.println(strlangTransactionHistory);
			String strlangSupport=getText(langSupport,"Support");
			System.out.println(strlangSupport);
			String strlangLinkTV=getText(langLinkTV,"Link TV");
			System.out.println(strlangLinkTV);
			scrollJs("down");
			Thread.sleep(5000);
			String strlangLogOut=getText(langLogOut,"LogOut");
			System.out.println(strlangLogOut);
			click(rentPage, "Rent Page");
			String strlangRentPopup=getText(langRentPopup,"Rent Popup");		
			System.out.println(strlangRentPopup);
			click(langRentPopup, "Close Rent Poup");
			String strlangRentHeader=getText(langRentHeader,"Rent Header");
			System.out.println(strlangRentHeader);
			click(browsePage, "Browse Page");
			Thread.sleep(5000);
			String strlangBrowse=getText(langBrowse,"Browse Header");
			System.out.println(strlangBrowse);
			if(strLanguage.toLowerCase().contains("eng"))
			{
				if(strlangMeHeader.toLowerCase().equals("me"))
				{
					Reporter.pass("Verify Change Language in English","Me Header is change Successfully displays as " +strlangMeHeader);
				}
				else
				{
					Reporter.fail("Verify Change Language in English","Me Header is not change displays as " +strlangMeHeader);
				}
				if(blnAnonymous==false)
				{
					if(strlangSubDetil1.toLowerCase().equals("subscription"))
					{
						Reporter.pass("Verify Change Language in English","Subscription is change Successfully displays as " +strlangSubDetil1);
					}
					else
					{
						Reporter.fail("Verify Change Language in English","Subscription is not change displays as " +strlangSubDetil1);
					}
					if(strlangSubDetil2.toLowerCase().contains("tickets"))
					{
						Reporter.pass("Verify Change Language in English","Tickets is change Successfully displays as " +strlangSubDetil2);
					}
					else
					{
						Reporter.fail("Verify Change Language in English","Tickets is not change displays as " +strlangSubDetil2);
					}
				}
				if(strlangDaownloads.toLowerCase().contains("downloads"))
				{
					Reporter.pass("Verify Change Language in English","Downloads is change Successfully displays as " +strlangDaownloads);
				}
				else
				{
					Reporter.fail("Verify Change Language in English","Download is not change displays as " +strlangDaownloads);
				}
				if(strlangRentals.toLowerCase().contains("rentals"))
				{
					Reporter.pass("Verify Change Language in English","Rentals is change Successfully displays as " +strlangRentals);
				}
				else
				{
					Reporter.fail("Verify Change Language in English","Rentals is not change displays as " +strlangRentals);
				}
				if(strlangWatchLater.toLowerCase().contains("watch"))
				{
					Reporter.pass("Verify Change Language in English","Watch Later is change Successfully displays as " +strlangWatchLater);
				}
				else
				{
					Reporter.fail("Verify Change Language in English","Watch Later is not change displays as " +strlangWatchLater);
				}
				/*if(strlangFav.toLowerCase().contains("favorite"))
				{
					Reporter.SuccessReport("Verify Change Language in English","Favorite is change Successfully displays as " +strlangFav);
				}
				else
				{
					Reporter.failureReportContinue("Verify Change Language in English","Favorite is not change displays as " +strlangFav);
				}*/
				if(strlangHistory.toLowerCase().contains("history"))
				{
					Reporter.pass("Verify Change Language in English","History is change Successfully displays as " +strlangHistory);
				}
				else
				{
					Reporter.fail("Verify Change Language in English","History is not change displays as " +strlangHistory);
				}
				if(strlangSettings.toLowerCase().contains("settings"))
				{
					Reporter.pass("Verify Change Language in English","Settings is change Successfully displays as " +strlangSettings);
				}
				else
				{
					Reporter.fail("Verify Change Language in English","Settings is not change displays as " +strlangSettings);
				}
				if(strlangSubscription.toLowerCase().contains("subscription"))
				{
					Reporter.pass("Verify Change Language in English","Subscription is change Successfully displays as " +strlangSubscription);
				}
				else
				{
					Reporter.fail("Verify Change Language in English","Subscription is not change displays as " +strlangSubscription);
				}
				if(strlangTransactionHistory.toLowerCase().contains("transaction history"))
				{
					Reporter.pass("Verify Change Language in English","Transaction History is change Successfully displays as " +strlangTransactionHistory);
				}
				else
				{
					Reporter.fail("Verify Change Language in English","Transaction History is not change displays as " +strlangTransactionHistory);
				}
				if(strlangSupport.toLowerCase().contains("support"))
				{
					Reporter.pass("Verify Change Language in English","Support is change Successfully displays as " +strlangSupport);
				}
				else
				{
					Reporter.fail("Verify Change Language in English","Support is not change displays as " +strlangSupport);
				}
				if(strlangLinkTV.toLowerCase().contains("link tv"))
				{
					Reporter.pass("Verify Change Language in English","Link TV is change Successfully displays as " +strlangLinkTV);
				}
				else
				{
					Reporter.fail("Verify Change Language in English","Link TV is not change displays as " +strlangLinkTV);
				}
				if(blnAnonymous)
				{
					if(strlangLogOut.toLowerCase().contains("login"))
					{
						Reporter.pass("Verify Change Language in English","Login is change Successfully displays as " +strlangLogOut);
					}
					else
					{
						Reporter.fail("Verify Change Language in English","Login is not change displays as " +strlangLogOut);
					}
				}
				else
				{
					if(strlangLogOut.toLowerCase().contains("logout"))
					{
						Reporter.pass("Verify Change Language in English","Logout is change Successfully displays as " +strlangLogOut);
					}
					else
					{
						Reporter.fail("Verify Change Language in English","Logout is not change displays as " +strlangLogOut);
					}
				}
				if(strlangRentPopup.toLowerCase().contains("explore rental movies"))
				{
					Reporter.pass("Verify Change Language in English","Rental Popup is change Successfully displays as " +strlangRentPopup);
				}
				else
				{
					Reporter.fail("Verify Change Language in English","Rental Popup is not change displays as " +strlangRentPopup);
				}
				if(strlangRentHeader.toLowerCase().contains("rent"))
				{
					Reporter.pass("Verify Change Language in English","Rent Header is change Successfully displays as " +strlangRentHeader);
				}
				else
				{
					Reporter.fail("Verify Change Language in English","Rent Header is not change displays as " +strlangRentHeader);
				}
				if(strlangBrowse.toLowerCase().contains("browse"))
				{
					Reporter.pass("Verify Change Language in English","Browse Header is change Successfully displays as " +strlangBrowse);
				}
				else
				{
					Reporter.fail("Verify Change Language in English","Browse Header is not change Successfully displays as " +strlangBrowse);
				}
			}
			else if(strLanguage.toLowerCase().contains("thai"))
			{
				if(strlangMeHeader.toLowerCase().equals("me")==false && strlangMeHeader.length()>0)
				{
					Reporter.pass("Verify Change Language in Thai","Me Header is change Successfully displays as " +strlangMeHeader);
				}
				else
				{
					Reporter.fail("Verify Change Language in Thai","Me Header is not change displays as " +strlangMeHeader);
				}
				if(blnAnonymous==false)
				{
					if(strlangSubDetil1.toLowerCase().equals("subscription")==false && strlangSubDetil1.length()>0)
					{
						Reporter.pass("Verify Change Language in Thai","Subscription is change Successfully displays as " +strlangSubDetil1);
					}
					else
					{
						Reporter.fail("Verify Change Language in Thai","Subscription is not change displays as " +strlangSubDetil1);
					}
					if(strlangSubDetil2.toLowerCase().contains("day")==false && strlangSubDetil2.length()>0)
					{
						Reporter.pass("Verify Change Language in Thai","Ticktes is change Successfully displays as " +strlangSubDetil2);
					}
					else
					{
						Reporter.fail("Verify Change Language in Thai","Tickets is not change displays as " +strlangSubDetil2);
					}
				}
				if(strlangDaownloads.toLowerCase().contains("downloads")==false && strlangDaownloads.length()>0)
				{
					Reporter.pass("Verify Change Language in Thai","Downloads is change Successfully displays as " +strlangDaownloads);
				}
				else
				{
					Reporter.fail("Verify Change Language in Thai","Download is not change displays as " +strlangDaownloads);
				}
				if(strlangRentals.toLowerCase().contains("rentals")==false && strlangRentals.length()>0)
				{
					Reporter.pass("Verify Change Language in Thai","Rentals is change Successfully displays as " +strlangRentals);
				}
				else
				{
					Reporter.fail("Verify Change Language in Thai","Rentals is not change displays as " +strlangRentals);
				}
				if(strlangWatchLater.toLowerCase().contains("watch")==false && strlangWatchLater.length()>0)
				{
					Reporter.pass("Verify Change Language in Thai","Watch Later is change Successfully displays as " +strlangWatchLater);
				}
				else
				{
					Reporter.fail("Verify Change Language in Thai","Watch Later is not change displays as " +strlangWatchLater);
				}
				/*if(strlangFav.toLowerCase().contains("favorite")==false && strlangFav.length()>0)
				{
					Reporter.SuccessReport("Verify Change Language in Thai","Favorite is change Successfully displays as " +strlangFav);
				}
				else
				{
					Reporter.failureReportContinue("Verify Change Language in Thai","Favorite is not change displays as " +strlangFav);
				}*/
				if(strlangHistory.toLowerCase().contains("history")==false && strlangHistory.length()>0)
				{
					Reporter.pass("Verify Change Language in Thai","History is change Successfully displays as " +strlangHistory);
				}
				else
				{
					Reporter.fail("Verify Change Language in Thai","History is not change displays as " +strlangHistory);
				}
				if(strlangSettings.toLowerCase().contains("settings")==false && strlangSettings.length()>0)
				{
					Reporter.pass("Verify Change Language in Thai","Settings is change Successfully displays as " +strlangSettings);
				}
				else
				{
					Reporter.fail("Verify Change Language in Thai","Settings is not change displays as " +strlangSettings);
				}
				if(strlangSubscription.toLowerCase().contains("subscription")==false && strlangSubscription.length()>0)
				{
					Reporter.pass("Verify Change Language in Thai","Subscription is change Successfully displays as " +strlangSubscription);
				}
				else
				{
					Reporter.fail("Verify Change Language in Thai","Subscription is not change displays as " +strlangSubscription);
				}
				if(strlangTransactionHistory.toLowerCase().contains("transaction history")==false && strlangTransactionHistory.length()>0)
				{
					Reporter.pass("Verify Change Language in Thai","Transaction History is change Successfully displays as " +strlangTransactionHistory);
				}
				else
				{
					Reporter.fail("Verify Change Language in Thai","Transaction History is not change displays as " +strlangTransactionHistory);
				}
				if(strlangSupport.toLowerCase().contains("support")==false && strlangSupport.length()>0)
				{
					Reporter.pass("Verify Change Language in Thai","Support is change Successfully displays as " +strlangSupport);
				}
				else
				{
					Reporter.fail("Verify Change Language in Thai","Support is not change displays as " +strlangSupport);
				}
				if(strlangLinkTV.toLowerCase().contains("link tv")==false && strlangLinkTV.length()>0)
				{
					Reporter.pass("Verify Change Language in Thai","Link TV is change Successfully displays as " +strlangLinkTV);
				}
				else
				{
					Reporter.fail("Verify Change Language in Thai","Link TV is not change displays as " +strlangLinkTV);
				}
				if(blnAnonymous)
				{
					if(strlangLogOut.toLowerCase().contains("login")==false && strlangLogOut.length()>0)
					{
						Reporter.pass("Verify Change Language in Thai","Logout is change Successfully displays as " +strlangLogOut);
					}
					else
					{
						Reporter.fail("Verify Change Language in Thai","Logout is not change displays as " +strlangLogOut);
					}
				}
				else
				{
					if(strlangLogOut.toLowerCase().contains("logout")==false && strlangLogOut.length()>0)
					{
						Reporter.pass("Verify Change Language in Thai","Logout is change Successfully displays as " +strlangLogOut);
					}
					else
					{
						Reporter.fail("Verify Change Language in Thai","Logout is not change displays as " +strlangLogOut);
					}
				}
				if(strlangRentPopup.toLowerCase().contains("explore rental movies")==false && strlangRentPopup.length()>0)
				{
					Reporter.pass("Verify Change Language in Thai","Rental Popup is change Successfully displays as " +strlangRentPopup);
				}
				else
				{
					Reporter.fail("Verify Change Language in Thai","Rental Popup is not change displays as " +strlangRentPopup);
				}
				if(strlangRentHeader.toLowerCase().contains("rent")==false && strlangRentHeader.length()>0)
				{
					Reporter.pass("Verify Change Language in Thai","Rent Header is change Successfully displays as " +strlangRentHeader);
				}
				else
				{
					Reporter.fail("Verify Change Language in Thai","Rent Header is not change displays as " +strlangRentHeader);
				}
				if(strlangBrowse.toLowerCase().contains("browse")==false && strlangBrowse.length()>0)
				{
					Reporter.pass("Verify Change Language in Thai","Browse Header is change Successfully displays as " +strlangBrowse);
				}
				else
				{
					Reporter.fail("Verify Change Language in Thai","Browse Header is not change displays as " +strlangBrowse);
				}
			}
			else if(strLanguage.toLowerCase().contains("bah"))
			{
				if(strlangMeHeader.toLowerCase().contains("saya"))
				{
					Reporter.pass("Verify Change Language in Bahasa Indonesia","Me Header is change Successfully displays as " +strlangMeHeader);
				}
				else
				{
					Reporter.fail("Verify Change Language in Bahasa Indonesia","Me Header is not change displays as " +strlangMeHeader);
				}
				if(blnAnonymous==false)
				{
					if(strlangSubDetil1.toLowerCase().contains("paket"))
					{
						Reporter.pass("Verify Change Language in Bahasa Indonesia","Subscription is change Successfully displays as " +strlangSubDetil1);
					}
					else
					{
						Reporter.fail("Verify Change Language in Bahasa Indonesia","Subscription is not change displays as " +strlangSubDetil1);
					}
					if(strlangSubDetil2.toLowerCase().contains("tiket"))
					{
						Reporter.pass("Verify Change Language in Bahasa Indonesia","Tickets is change Successfully displays as " +strlangSubDetil2);
					}
					else
					{
						Reporter.fail("Verify Change Language in Bahasa Indonesia","Tickets is not change displays as " +strlangSubDetil2);
					}
				}
				if(strlangDaownloads.toLowerCase().contains("unduh"))
				{
					Reporter.pass("Verify Change Language in Bahasa Indonesia","Downloads is change Successfully displays as " +strlangDaownloads);
				}
				else
				{
					Reporter.fail("Verify Change Language in Bahasa Indonesia","Download is not change displays as " +strlangDaownloads);
				}
				if(strlangRentals.toLowerCase().contains("sewa"))
				{
					Reporter.pass("Verify Change Language in Bahasa Indonesia","Rentals is change Successfully displays as " +strlangRentals);
				}
				else
				{
					Reporter.fail("Verify Change Language in Bahasa Indonesia","Rentals is not change displays as " +strlangRentals);
				}
				if(strlangWatchLater.toLowerCase().contains("tonton"))
				{
					Reporter.pass("Verify Change Language in Bahasa Indonesia","Watch Later is change Successfully displays as " +strlangWatchLater);
				}
				else
				{
					Reporter.fail("Verify Change Language in Bahasa Indonesia","Watch Later is not change displays as " +strlangWatchLater);
				}
				/*if(strlangFav.toLowerCase().contains("favorit"))
				{
					Reporter.SuccessReport("Verify Change Language in Bahasa Indonesia","Favorite is change Successfully displays as " +strlangFav);
				}
				else
				{
					Reporter.failureReportContinue("Verify Change Language in Bahasa Indonesia","Favorite is not change displays as " +strlangFav);
				}*/
				if(strlangHistory.toLowerCase().contains("history"))
				{
					Reporter.pass("Verify Change Language in Bahasa Indonesia","History is change Successfully displays as " +strlangHistory);
				}
				else
				{
					Reporter.fail("Verify Change Language in Bahasa Indonesia","History is not change displays as " +strlangHistory);
				}
				if(strlangSettings.toLowerCase().contains("pengaturan"))
				{
					System.out.println("Pass Settings ==> " +strlangSettings);
					Reporter.pass("Verify Change Language in Bahasa Indonesia","Settings is change Successfully displays as " +strlangSettings);
				}
				else
				{
					System.out.println("Fail Settings ==> " +strlangSettings);
					Reporter.fail("Verify Change Language in Bahasa Indonesia","Settings is not change displays as " +strlangSettings);
				}
				if(strlangSubscription.toLowerCase().contains("paket"))
				{
					Reporter.pass("Verify Change Language in Bahasa Indonesia","Subscription is change Successfully displays as " +strlangSubscription);
				}
				else
				{
					Reporter.fail("Verify Change Language in Bahasa Indonesia","Subscription is not change displays as " +strlangSubscription);
				}
				if(strlangTransactionHistory.toLowerCase().contains("daftar transaksi"))
				{
					Reporter.pass("Verify Change Language in Bahasa Indonesia","Transaction History is change Successfully displays as " +strlangTransactionHistory);
				}
				else
				{
					Reporter.fail("Verify Change Language in Bahasa Indonesia","Transaction History is not change displays as " +strlangTransactionHistory);
				}
				if(strlangSupport.toLowerCase().contains("bantuan"))
				{
					Reporter.pass("Verify Change Language in Bahasa Indonesia","Support is change Successfully displays as " +strlangSupport);
				}
				else
				{
					Reporter.fail("Verify Change Language in Bahasa Indonesia","Support is not change displays as " +strlangSupport);
				}
				if(strlangLinkTV.toLowerCase().contains("tautan tv"))
				{
					Reporter.pass("Verify Change Language in Bahasa Indonesia","Link TV is change Successfully displays as " +strlangLinkTV);
				}
				else
				{
					Reporter.fail("Verify Change Language in Bahasa Indonesia","Link TV is not change displays as " +strlangLinkTV);
				}
				if(blnAnonymous)
				{
					if(strlangLogOut.toLowerCase().contains("masuk"))
					{
						Reporter.pass("Verify Change Language in Bahasa Indonesia","Logout is change Successfully displays as " +strlangLogOut);
					}
					else
					{
						Reporter.fail("Verify Change Language in Bahasa Indonesia","Logout is not change displays as " +strlangLogOut);
					}
				}
				else
				{
					if(strlangLogOut.toLowerCase().contains("keluar"))
					{
						Reporter.pass("Verify Change Language in Bahasa Indonesia","Logout is change Successfully displays as " +strlangLogOut);
					}
					else
					{
						Reporter.fail("Verify Change Language in Bahasa Indonesia","Logout is not change displays as " +strlangLogOut);
					}
				}
				if(strlangRentPopup.toLowerCase().contains("jelajahi sewa film"))
				{
					Reporter.pass("Verify Change Language in Bahasa Indonesia","Rental Popup is change Successfully displays as " +strlangRentPopup);
				}
				else
				{
					Reporter.fail("Verify Change Language in Bahasa Indonesia","Rental Popup is not change displays as " +strlangRentPopup);
				}
				if(strlangRentHeader.toLowerCase().contains("sewa"))
				{
					Reporter.pass("Verify Change Language in Bahasa Indonesia","Rent Header is change Successfully displays as " +strlangRentHeader);
				}
				else
				{
					Reporter.fail("Verify Change Language in Bahasa Indonesia","Rent Header is not change displays as " +strlangRentHeader);
				}
				if(strlangBrowse.toLowerCase().contains("telusuri"))
				{
					Reporter.pass("Verify Change Language in Bahasa Indonesia","Browse Header is change Successfully displays as " +strlangBrowse);
				}
				else
				{
					Reporter.fail("Verify Change Language in Bahasa Indonesia","Browse Header is not change displays as " +strlangBrowse);
				}
			}
			
		}
		catch(Exception e)
		{
			
		}
	}
	
	public boolean fnVerifySettingsAppAudioTrack() throws Throwable
	{
		boolean blnFound=true;
		try
		{
			//Go to Me Section
			mePage.fnSelectMESection("sett");
			//Click on Audio Track setting
			click(audioTrackInSettings,"Audio Track Settings");
			//Get the all Audio Track Language
			List<WebElement> eleAudioList=driver.findElement(appAudioTypeList).findElements(By.xpath("XCUIElementTypeCell"));
			if(fnVerifyAudioLanguageList(eleAudioList))
			{
				Reporter.pass("Verify App Audio Language List","All Pre-Defined Audio Language is displayed successfully.");
			}
			else
			{
				Reporter.fail("Verify App Audio Language List","All Pre-Defined Audio Language is not displayed successfully.");
			}
			click(cancel,"Cancel");
			click(navBackBtn,"Back From Settings page");
			for(int i=0;i<=3;i++)
			{
				//Go to Me Section
				mePage.fnSelectMESection("sett");
				//Click on Audio Track setting
				click(audioTrackInSettings,"Audio Track Settings");
				List<WebElement> eleAudioList1=driver.findElement(appAudioTypeList).findElements(By.xpath("XCUIElementTypeCell"));
				String strAppLanguage=eleAudioList1.get(i).findElement(By.xpath("XCUIElementTypeStaticText")).getText();
				eleAudioList1.get(i).click();
				//Go to Back Button
				click(navBackBtn,"Back From Settings page");
				mePage.fnSelectMESection("sett");
				String strSettingAppAudioLanguage=getText(audioTrackInSettings,"Language selected");
				if(strAppLanguage.equals(strSettingAppAudioLanguage))
				{
					Reporter.pass("Verify App Audio Language Settings",strAppLanguage + " Audio Language is Selected successfully.");
				}
				else
				{
					Reporter.fail("Verify App Audio Language Settings",strAppLanguage + " Audio Language is not Selected successfully.");
				}
				click(navBackBtn,"Back From Settings page");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnFound=false;
		}
		return blnFound;
	}
	public boolean fnVerifyAudioLanguageList(List<WebElement> eleAudioList) throws Throwable
	{
		boolean blnFound=true;
		List<String> eleAudio=new ArrayList<String>();
		eleAudio.add("English");
		eleAudio.add("Assamese");
		eleAudio.add("Bahasa Indonesia");
		eleAudio.add("Bahasa Malaysia");
		eleAudio.add("Bengali");
		eleAudio.add("Bhojpuri");
		eleAudio.add("Chhattisgarhi");
		eleAudio.add("Gujarati");
		eleAudio.add("Japanese");
		eleAudio.add("Hindi");
		eleAudio.add("Kannada");
		eleAudio.add("Konkani");
		eleAudio.add("Korean");
		eleAudio.add("Marathi");
		eleAudio.add("Malayalam");
		eleAudio.add("Oriya");
		eleAudio.add("Punjabi");
		eleAudio.add("Sindhi");
		eleAudio.add("Telugu");
		eleAudio.add("Tagalog");
		eleAudio.add("Tamil");
		eleAudio.add("Thai");
		eleAudio.add("Simplified Chinese");
		eleAudio.add("Traditional Chinese");
		try
		{
			List<String> eleAudioLanguage=new ArrayList<String>();
			for(int i=0;i<eleAudioList.size();i++)
			{
				String str1=eleAudioList.get(i).findElement(By.xpath("XCUIElementTypeStaticText")).getText();
				eleAudioLanguage.add(str1);
			}
			for(int i=0;i<eleAudio.size();i++)
			{
				boolean blnMatch=false;
				System.out.println(eleAudio.get(i));
				for(int j=0;j<eleAudioLanguage.size();j++)
				{
					String str1=eleAudioLanguage.get(j);
					if(eleAudio.get(i).equals(str1))
					{
						blnMatch=true;
						break;
					}
				}
				if(blnMatch)
				{
					Reporter.pass("Verify App Audio Language List",eleAudio.get(i) +  " is displayed successfully.");
				}
				else
				{
					Reporter.fail("Verify App Audio Language List",eleAudio.get(i) +  " is not displayed successfully.");
					blnFound=false;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return blnFound;
	}
	
	public boolean fnVerifySettingsSubTitle() throws Throwable
	{
		boolean blnFound=true;
		try
		{
			//Go to Me Section
			mePage.fnSelectMESection("sett");
			//Click on Audio Track setting
			click(subtitles,"SubTitle Settings");
			//Get the all Audio Track Language
			List<WebElement> eleAudioList=driver.findElement(appAudioTypeList).findElements(By.xpath("XCUIElementTypeCell"));
			if(fnVerifySubTitleLanguageList(eleAudioList))
			{
				Reporter.pass("Verify App SubTitle Language List","All Pre-Defined SubTitle Language is displayed successfully.");
			}
			else
			{
				Reporter.fail("Verify App SubTitle Language List","All Pre-Defined SubTile Language is not displayed successfully.");
			}
			click(cancel,"Cancel");
			click(navBackBtn,"Back From Settings page");
			for(int i=0;i<=3;i++)
			{
				//Go to Me Section
				mePage.fnSelectMESection("sett");
				//Click on Audio Track setting
				click(subtitles,"SubTitle Track Settings");
				List<WebElement> eleAudioList1=driver.findElement(appAudioTypeList).findElements(By.xpath("XCUIElementTypeCell"));
				String strAppLanguage=eleAudioList1.get(i).findElement(By.xpath("XCUIElementTypeStaticText")).getText();
				eleAudioList1.get(i).click();
				//Go to Back Button
				click(navBackBtn,"Back From Settings page");
				mePage.fnSelectMESection("sett");
				String strSettingAppAudioLanguage=getText(subtitles,"SubTitle Language selected");
				if(strAppLanguage.equals(strSettingAppAudioLanguage))
				{
					Reporter.pass("Verify App Subtitles Language Settings",strAppLanguage + " Subtitles Language is Selected successfully.");
				}
				else
				{
					Reporter.fail("Verify App Subtitles Language Settings",strAppLanguage + " Subtitles Language is not Selected successfully.");
				}
				click(navBackBtn,"Back From Settings page");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnFound=false;
		}
		return blnFound;
	}
	public  boolean fnVerifySubTitleLanguageList(List<WebElement> eleAudioList) throws Throwable
	{
		boolean blnFound=true;
		List<String> eleAudio=new ArrayList<String>();
		eleAudio.add("English");
		eleAudio.add("Assamese");
		eleAudio.add("Bahasa Indonesia");
		eleAudio.add("Bahasa Malaysia");
		eleAudio.add("Bengali");
		eleAudio.add("Bhojpuri");
		eleAudio.add("Chhattisgarhi");
		eleAudio.add("Gujarati");
		eleAudio.add("Japanese");
		eleAudio.add("Hindi");
		eleAudio.add("Kannada");
		eleAudio.add("Konkani");
		eleAudio.add("Korean");
		eleAudio.add("Marathi");
		eleAudio.add("Malayalam");
		eleAudio.add("Oriya");
		eleAudio.add("Punjabi");
		eleAudio.add("Sindhi");
		eleAudio.add("Telugu");
		eleAudio.add("Tagalog");
		eleAudio.add("Tamil");
		eleAudio.add("Thai");
		eleAudio.add("Simplified Chinese");
		eleAudio.add("Traditional Chinese");
		try
		{
			List<String> eleSubTitle=new ArrayList<String>();
			for(int i=0;i<eleAudioList.size();i++)
			{
				String str1=eleAudioList.get(i).findElement(By.xpath("XCUIElementTypeStaticText")).getText();
				eleSubTitle.add(str1);
			}
			for(int i=0;i<eleAudio.size();i++)
			{
				boolean blnMatch=false;
				System.out.println(eleAudio.get(i));
				for(int j=0;j<eleSubTitle.size();j++)
				{
					String str1=eleSubTitle.get(j);
					if(eleAudio.get(i).equals(str1))
					{
						blnMatch=true;
						break;
					}
				}
				if(blnMatch)
				{
					Reporter.pass("Verify App Subtitles Language List",eleAudio.get(i) +  " is displayed successfully.");
				}
				else
				{
					Reporter.fail("Verify App Subtitles Language List",eleAudio.get(i) +  " is not displayed successfully.");
					
					blnFound=false;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return blnFound;
	}
	
	public boolean fnVerifySettingsDownloadQuality() throws Throwable
	{
		boolean blnFound=true;
		try
		{
			//Go to Me Section
			mePage.fnSelectMESection("sett");
			//Click on Audio Track setting
			click(downloadQuality,"Download Quality Settings");
			//Get the all Audio Track Language
			List<WebElement> eleAudioList=driver.findElement(appAudioTypeList).findElements(By.xpath("XCUIElementTypeCell"));
			if(fnVerifyDownloadQualityList(eleAudioList))
			{
				Reporter.pass("Verify App Download Quality Language List","All Pre-Defined Download Quality is displayed successfully.");
			}
			else
			{
				Reporter.fail("Verify App Download Quality List","All Pre-Defined Download Quality is not displayed successfully.");
			}
			click(cancel,"Cancel");
			click(navBackBtn,"Back From Settings page");
			for(int i=0;i<eleAudioList.size();i++)
			{
				//Go to Me Section
				mePage.fnSelectMESection("sett");
				//Click on Audio Track setting
				click(downloadQuality,"Download Quality Track Settings");
				List<WebElement> eleAudioList1=driver.findElement(appAudioTypeList).findElements(By.xpath("XCUIElementTypeCell"));
				String strAppLanguage=eleAudioList1.get(i).findElement(By.xpath("XCUIElementTypeStaticText")).getText();
				eleAudioList1.get(i).click();
				//Go to Back Button
				click(navBackBtn,"Back From Settings page");
				mePage.fnSelectMESection("sett");
				String strSettingAppAudioLanguage=getText(downloadQuality,"Download Quality selected");
				System.out.println(strSettingAppAudioLanguage);
				if(strAppLanguage.equals(strSettingAppAudioLanguage))
				{
					Reporter.pass("Verify App Download Quality Settings",strAppLanguage + " Download Quality is Selected successfully.");
				}
				else
				{
					Reporter.fail("Verify App Download Quality Settings",strAppLanguage + " Download Quality is not Selected successfully.");
				}
				click(navBackBtn,"Back From Settings page");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnFound=false;
		}
		return blnFound;
	}
	public boolean fnVerifyDownloadQualityList(List<WebElement> eleAudioList) throws Throwable
	{
		boolean blnFound=true;
		List<String> eleAudio=new ArrayList<String>();
		eleAudio.add("Low");
		eleAudio.add("Medium");
		eleAudio.add("High");
			try
			{
			for(int i=0;i<eleAudio.size();i++)
			{
				boolean blnMatch=false;
				System.out.println(eleAudio.get(i));
				for(int j=0;j<eleAudioList.size();j++)
				{
					String str1=eleAudioList.get(j).findElement(By.xpath("XCUIElementTypeStaticText")).getText();
					if(eleAudio.get(i).equals(str1))
					{
						blnMatch=true;
						break;
					}
				}
				if(blnMatch)
				{
					Reporter.pass("Verify App Download Quality List",eleAudio.get(i) +  " is displayed successfully.");
				}
				else
				{
					Reporter.fail("Verify App Download Quality List",eleAudio.get(i) +  " is not displayed successfully.");				
					blnFound=false;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return blnFound;
	}

	public boolean fnVerifySettingsPlayBackQuality() throws Throwable
	{
		boolean blnFound=true;
		try
		{
			//Go to Me Section
			mePage.fnSelectMESection("sett");
			//Click on Audio Track setting
			click(playbackQuality,"Playback Quality Settings");
			//Get the all Audio Track Language
			List<WebElement> eleAudioList=driver.findElement(appAudioTypeList).findElements(By.xpath("XCUIElementTypeCell"));
			if(fnVerifyDownloadQualityList(eleAudioList))
			{
				Reporter.pass("Verify App Playback Quality Language List","All Pre-Defined Playback Quality is displayed successfully.");
			}
			else
			{
				Reporter.fail("Verify App Playback Quality List","All Pre-Defined Playback Quality is not displayed successfully.");
			}
			click(cancel,"Cancel");
			click(navBackBtn,"Back From Settings page");
			for(int i=0;i<eleAudioList.size();i++)
			{
				//Go to Me Section
				mePage.fnSelectMESection("sett");
				//Click on Audio Track setting
				click(playbackQuality,"Playback Quality Track Settings");
				List<WebElement> eleAudioList1=driver.findElement(appAudioTypeList).findElements(By.xpath("XCUIElementTypeCell"));
				String strAppLanguage=eleAudioList1.get(i).findElement(By.xpath("XCUIElementTypeStaticText")).getText();
				eleAudioList1.get(i).click();
				//Go to Back Button
				click(navBackBtn,"Back From Settings page");
				mePage.fnSelectMESection("sett");
				String strSettingAppAudioLanguage=getText(playbackQuality,"Playback Quality selected");
				System.out.println(strSettingAppAudioLanguage);
				if(strAppLanguage.equals(strSettingAppAudioLanguage))
				{
					Reporter.pass("Verify App Playback Quality Settings",strAppLanguage + " Playback Quality is Selected successfully.");
				}
				else
				{
					Reporter.fail("Verify App Playback Quality Settings",strAppLanguage + " Playback Quality is not Selected successfully.");
				}
				click(navBackBtn,"Back From Settings page");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnFound=false;
		}
		return blnFound;
	}
	public boolean fnVerifyPlayQualityList(List<WebElement> eleAudioList) throws Throwable
	{
		boolean blnFound=true;
		List<String> eleAudio=new ArrayList<String>();
		eleAudio.add("Auto");
		eleAudio.add("Low");
		eleAudio.add("Medium");
		eleAudio.add("High");
			try
			{
			for(int i=0;i<eleAudio.size();i++)
			{
				boolean blnMatch=false;
				System.out.println(eleAudio.get(i));
				for(int j=0;j<eleAudioList.size();j++)
				{
					String str1=eleAudioList.get(j).findElement(By.xpath("XCUIElementTypeStaticText")).getText();
					if(eleAudio.get(i).equals(str1))
					{
						blnMatch=true;
						break;
					}
				}
				if(blnMatch)
				{
					Reporter.pass("Verify App Playback Quality List",eleAudio.get(i) +  " is displayed successfully.");
				}
				else
				{
					Reporter.fail("Verify App Playback Quality List",eleAudio.get(i) +  " is not displayed successfully.");				
					blnFound=false;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return blnFound;
	}
	
	public void fnVerifySettingMobileDataUsage() throws Throwable
	{
		try
		{
			//Go to Me Section
			mePage.fnSelectMESection("sett");
			verifyText(mobileDataHeading, "Mobile Data Usage","Mobile Data Usage");
			verifyText(mobileDataDesc, "HOOQ will use mobile data to stream and download videos.","HOOQ will use mobile data to stream and download videos.");
			if(isElementDisplayed(mobileDataSwitch))
			{
				Reporter.pass("Mobile Data Usage Screen In Setting Page","Switch for Mobile Data Usage, HOOQ will use mobile data to stream and download videos. is displayed");
			}
			else
			{
				Reporter.fail("Mobile Data Usage Screen In Setting Page","Switch for Mobile Data Usage, HOOQ will use mobile data to stream and download videos. is not displayed");
			}
			click(navBackBtn,"Back From Settings page");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
