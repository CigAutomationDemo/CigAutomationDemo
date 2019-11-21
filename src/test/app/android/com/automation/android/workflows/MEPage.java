package com.automation.android.workflows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.accelerators.ActionEngine;
import com.automation.googledrive.ReportStatus;
import com.automation.reports.Reporter;

public class MEPage extends BasePage {
	//Locators
	By navBackBtn=By.id("tv.hooq.android:id/backInMainActivity");
	By meLabel=By.id("tv.hooq.android:id/ivMeBtn");
	By downloadSection=By.xpath("//android.widget.TextView[@text='Downloads']");
	By rentalsSection=By.xpath("//android.widget.TextView[@text='My Rentals']");
	By watchListModule=By.xpath("//android.widget.TextView[@text='Watchlist']");
	By history=By.xpath("//android.widget.TextView[@text='History']");
	By langSettings=By.id("tv.hooq.android:id/profileBtnSettings");
	By subscriptionSection=By.xpath("//android.widget.TextView[@text='Subscription']");
	By transactionHistory=By.xpath("//android.widget.TextView[@text='Transaction History']");
	By supportSection=By.xpath("//android.widget.TextView[@text='Support']");
	By linkTV=By.xpath("//android.widget.TextView[@text='Link TV']");
	By logout=By.xpath("//android.widget.TextView[@text='Log out']");
	By meTbl=By.id("tv.hooq.android:id/discover_feed_list");
	By subscriptionInfo=By.id("tv.hooq.android:id/subscription_days");
	By ticketInfo=By.id("tv.hooq.android:id/tickets");
	By mePageTopHeader=By.id("tv.hooq.android:id/bottomContainer");
	By Settings=By.id("tv.hooq.android:id/profileBtnSettings");
	By subs=By.id("tv.hooq.android:id/profileBtnSubscription");
	By transHistory=By.id("tv.hooq.android:id/profileBtnTrasactionHistory");
	By suppSection=By.id("tv.hooq.android:id/profileBtnSupport");
	By linkTv=By.id("tv.hooq.android:id/profileBtnLinkTV");
	
	//Old Locators
	By discoverFeedList=By.id("tv.hooq.android:id/discover_feed_list");
	By subsription=By.id("tv.hooq.android:id/profileBtnSubscription");
    By meProfile = By.id("btnProfile");
	By meProfile1 = By.id("tv.hooq.android:id/iv_me_btn");
	By WatchList = By.xpath("//android.widget.TextView[@text='Watchlist']");
	 By discoverPageFirstShowMovie2 = By.id("tv.hooq.android:id/imgPoster");
	 By discoverPageFirstShowMovie1 = By.id("tv.hooq.android:id/collectionPoster");
	 By WatchLater = By.xpath("//android.widget.TextView[@text='Watch Later']");
	 By WatchLaterTitle = By.xpath("//android.widget.TextView[@text='Watchlist']");
	 By WatchLaterBackbtn = By.id("tv.hooq.android:id/btnUp");
	 By cancelBtn= By.id("tv.hooq.android:id/btnCancel");
	 By historyimage= By.id("tv.hooq.android:id/imagePortrait");
	 By historyremove= By.id("tv.hooq.android:id/btnRemove");
	 By historydelete= By.id("tv.hooq.android:id/confirm");
	 By WatchLaterimg = By.id("tv.hooq.android:id/imagePortrait");
	 By FavSection = By.xpath("//android.widget.TextView[@text='Favorites']");
	
	 By WLSection = By.xpath("//android.widget.TextView[@text='Watch Later']");
	
	 By FavTitle = By.xpath("//android.widget.TextView[@text='Favorites']");
	 By FavBackbtn = By.id("tv.hooq.android:id/btnUp");
	 By SetBackbtn1 = By.id("tv.hooq.android:id/backInMainActivity");
	 By setBackbtn = By.id("tv.hooq.android:id/btnUp");
	 By Favimg = By.id("tv.hooq.android:id/imagePortrait");
	 By HistoryTitle = By.xpath("//android.widget.TextView[@text='History']");
	 By SettingsTitle = By.xpath("//android.widget.TextView[@text='Settings']");
	 By SubmitTitle = By.xpath("//android.widget.Button[@text='Submit']");
	 By Substitle = By.id("tv.hooq.android:id/startingSentence");
	
	 By Substitle1 = By.id("tv.hooq.android:id/manage");
	 By TransactionTitle = By.xpath("//android.widget.TextView[@text='Transaction History']");
	 By HistoryBackbtn = By.id("tv.hooq.android:id/btnUp");
	 By rentflag = By.id("tv.hooq.android:id/img_flag_rental");
	 By HistorySection = By.xpath("//android.widget.TextView[@text='History']");
	 By settingsSection = By.xpath("//android.widget.TextView[@text='Settings']");
	 By TransactionSection = By.xpath("//android.widget.TextView[@text='Transaction History']");
	 By SupportSection = By.xpath("//android.widget.TextView[@text='Support']");
	
	
	 By SupportSectionheader = By.xpath("//android.widget.TextView[@text='Support']");
	 By SupportSection1 = By.xpath("//android.widget.TextView[@text='Support']");
	 By DownloadsTitle = By.xpath("//android.widget.TextView[@text='Downloads']");
	 By AudiolanTitle = By.xpath("//android.widget.TextView[@text='Audio Language']");
	 By Bahasalang = By.xpath("//android.widget.TextView[@text='Paket Berlangganan']");
	 By AudiolanTitlecancel = By.xpath("//android.widget.Button[@text='Cancel']");
	// By thailang = By.xpath("//android.widget.TextView[@text='รายการของฉัน']");
	 By englang = By.xpath("//android.widget.TextView[@text='ME']");
	// By Appdisplaylangbahasa = By.xpath("//android.widget.TextView[@text='SAYA']");
	 By DownloadsBackbtn = By.id("tv.hooq.android:id/btnUp");
	 By rentalsBackbtn = By.id("tv.hooq.android:id/backInMainActivity");
	 By DownloadSection = By.xpath("//android.widget.TextView[@text='Downloads']");
	 By Seasonlist1 = By.xpath("//android.widget.RadioButton[@text='Season 1']");
	 By Audiolan = By.xpath("//android.widget.TextView[@text='Audio Language']");
	 By Appdisplay = By.xpath("//android.widget.TextView[@text='App Display Language']");
	 By Appdisplaybahasa = By.xpath("//android.widget.CheckedTextView[@text='Bahasa Indonesia']");
	 By linktv = By.xpath("//android.widget.TextView[@text='Link TV']");
	 By Downloadqual = By.xpath("//android.widget.TextView[@text='Download Quality']");
	 By playbackquality = By.xpath("//android.widget.TextView[@text='Playback Quality']");
	 By mobdatausage = By.xpath("//android.widget.TextView[@text='Mobile Data Usage']");
	 By transactionhistoryimage = By.id("tv.hooq.android:id/emptyStateIcon");
	 By transactionhistorydesc = By.id("tv.hooq.android:id/emptyStateDesc");
	 By transactionhistoryheader = By.xpath("//android.widget.TextView[@text='TRANSACTION HISTORY']");
	 By subtitle = By.xpath("//android.widget.TextView[@text='Subtitle Language']");
	 By playbackauto = By.xpath("//android.widget.CheckedTextView[@text='Auto']");
	 By downloadlow1 = By.xpath("//android.widget.CheckedTextView[@text='Low']");
	 By downloadmed = By.xpath("//android.widget.CheckedTextView[@text='Medium']");
	 By downloadhigh = By.xpath("//android.widget.CheckedTextView[@text='High']");
	 By subtitlelan = By.xpath("//android.widget.TextView[@text='Subtitle Language']");
	 By subtitlelan1 = By.xpath("//android.widget.CheckedTextView[@text='English']");
	 By link = By.id("tv.hooq.android:id/btn_link");
	 By season = By.id("tv.hooq.android:id/txtSeason");
	 By linktvcode = By.id("tv.hooq.android:id/btnEnterTvCode");	
	 By linktvbckbtn = By.id("tv.hooq.android:id/backInMainActivity");
	 By premiumme = By.xpath("//android.widget.TextView[@text='My Rentals']");
	 By premiumbtn = By.xpath("//android.widget.Button[@text='Explore Rental Movies']");
	 By support = By.xpath("//android.widget.TextView[@text='Support']");
	 By Rentalsme = By.xpath("//android.widget.TextView[@text='Rentals']");
	 By Rentalsmetitle = By.xpath("//android.widget.TextView[@text='My Rentals']");
	 By Linktvheader = By.xpath("//android.widget.TextView[@text='Link TV']");
	 By bahasalanguage = By.xpath("//android.widget.CheckedTextView[@text='Bahasa Indonesia']");
	 By Linktvtext = By.xpath("//android.widget.TextView[@text='Launch the HOOQ app on your TV.']");
	 By indo = By.xpath("//android.widget.TextView[@text='Bahasa Indonesia']");
	 By Linktvscantext = By.xpath("//android.widget.TextView[@text='Scan the QR code displayed on your TV to link it with your account.']");
	 By settingsindo = By.xpath("//android.widget.TextView[@text='Pengaturan']");
	 By Default = By.xpath("//android.widget.CheckedTextView[@text='Default']");
	 By Linktvcodetext = By.xpath("//android.widget.TextView[@text='Please enter the 6 digit code displayed on your TV to link it with your account.']");
	 By Rentalsticketsdesc = By.id("tv.hooq.android:id/ticketText");
	  
	 
	public boolean verifyingMePage(boolean anonymousUser) throws Throwable {
		boolean blnStatus=true;
		Reporter.info("HOOQ Android","Verifying Me Section");
		Reporter.blnReportTempStatus=true;
		try {
			fnSelectME();
			swipeUpOrBottom(false);
			isElementDisplayed(downloadSection, "Downloads");
			isElementDisplayed(rentalsSection, "My Rentals");
			isElementDisplayed(watchListModule, "WatchList");
			isElementDisplayed(HistorySection, "History");
			isElementDisplayed(settingsSection, "Settings");
			isElementDisplayed(subscriptionSection, "Subscription");
			isElementDisplayed(transactionHistory, "Transaction History");
			isElementDisplayed(supportSection, "Support");
			isElementDisplayed(linkTV,"Link TV");
			isElementDisplayed(logout, "Logout");
			if(anonymousUser){
				if(isElementDisplayed(linkTV)==false){
					Reporter.fail("Link TV", "Link TV is not displayed");
				} else{
					Reporter.pass("Link TV", "Link TV is displayed");
				}				
			} else {
				List<WebElement> eleSubHeading=driver.findElement(mePageTopHeader).findElements(By.className("android.widget.TextView"));
				if(eleSubHeading.get(0).getText().toLowerCase().contains("subscription"))
				{
					Reporter.pass("Subscription Heading", "Subscription Heading is displaying successfully");
				} 
				else
				{
					Reporter.fail("Subscription Heading", "Subscription Heading is not displaying.");					
				}
				String subInfo=eleSubHeading.get(1).getText();
				if(subInfo.length()>0)
				{
					Reporter.pass("Subscription Days", "Subscription days are appearing : " + subInfo);
				} 
				else
				{
					Reporter.fail("Suscription Days", "Subscriptions are not appearing");
				}
				if(eleSubHeading.get(2).getText().toLowerCase().contains("tickets"))
				{
					Reporter.pass("Ticket Heading", "Ticket Heading is displaying successfully");
				} 
				else
				{
					Reporter.fail("Ticket Heading", "Ticket Heading is not displaying.");
				}
				String ticketInfo=eleSubHeading.get(3).getText();
				if(ticketInfo.length()>0)
				{
					Reporter.pass("Ticket Info", "Ticket Info : "+ ticketInfo+" is displaying successfully");
				} 
				else
				{
					Reporter.fail("Ticket Info", "Ticket Info is not displaying.");
				}
			}
			click(navBackBtn,"Back From ME page");
		} catch (Exception e) {
			Reporter.fnPrintException(e);
			Reporter.blnReportTempStatus=false;
		}
		blnStatus=Reporter.blnReportTempStatus;
		return blnStatus;
	}


	public boolean fnSelectME() throws Throwable {
		boolean blnStatus=true;
		try
		{
			if(isElementDisplayed(meLabel))
			{
				click(meLabel,"Me Icon");
			}
			else
			{
				if(isElementDisplayed(navBackBtn))
				{
					click(navBackBtn,"Back From ME page");
				}
				click(meLabel,"Me Icon");
			}
			Thread.sleep(5000);
		}
		catch(Exception e){blnStatus=false;}
		return blnStatus;
		
	}


	public void fnSelectMESection(String strSection) throws Throwable {
		try
		{
			//Click on Me Tab
			fnSelectME();
			waitForPleaseWaitDisappear();
			if(strSection.startsWith("down"))
			{
				click(downloadSection,"Downloads");
				Thread.sleep(20000);
			}
			else if(strSection.startsWith("rentals"))
			{
				click(rentalsSection,"My Rentals");
			}
			else if(strSection.startsWith("watch"))
			{
				click(watchListModule,"Watch Later");
			}
			else if(strSection.startsWith("his"))
			{
				click(HistorySection,"History");
			}
			else if(strSection.startsWith("sett"))
			{
				click(Settings,"Settings");
			}
			else if(strSection.startsWith("subs"))
			{
				click(subs,"Subscription");
			}
			else if(strSection.startsWith("trans"))
			{
				click(transHistory,"Transaction History");
			}
			else if(strSection.startsWith("supp"))
			{
				click(suppSection,"Support");
			}
			else if(strSection.startsWith("linktv"))
			{
				click(linkTv,"Link TV");
			}
			else if(strSection.startsWith("log"))
			{
				loginPage.logOut();
			}
			waitForPleaseWaitDisappear();
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
		}
		
	}

	/***
	 * Function Name :- waitForPleaseWaitDisappear
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
	public  void waitForPleaseWaitDisappear() throws Throwable {
	try {
	    Thread.sleep(1000);
	    WebDriverWait wait = new WebDriverWait(driver, 5);
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("Please wait...")));
	    Thread.sleep(1000);
	} catch (Exception e) {
	}
	}
}
