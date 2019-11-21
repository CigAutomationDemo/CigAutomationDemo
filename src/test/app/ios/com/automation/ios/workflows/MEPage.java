package com.automation.ios.workflows;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.googledrive.ReportStatus;
import com.automation.reports.Reporter;

public class MEPage extends BasePage {
	//Locators
	By logoutButton = By.name("Logout");
	By confirm = By.name("Confirm");
	By mePageLogin = By.name("Login");
	By alreadyLogin = By.name("Login");
	By navBackBtn = By.name("navbar back btn");
	By meLabel = By.id("icon me");
	By downloadSection = By.name("Downloads");
	By rentalsSection = By.name("My Rentals");
	By watchLaterModule = By.name("Watchlist");
	By HistorySection = By.name("History");
	By langSettings=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[5]/XCUIElementTypeStaticText");
	By subscriptionSection = By.name("Subscription");
	By transactionHistory = By.name("Transaction History");
	By supportSection = By.name("Support");
	By settingsSection = By.name("Settings");
	By LinkTV=By.name("Link TV");
	By meLoginButton = By.name("Login");
	By subscriptionHeading = By.id("SUBSCRIPTION");
	By TicketsHeading=By.id("TICKETS");
	By subsInfo=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeImage/XCUIElementTypeStaticText[3]");
	By ticketInfo=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeImage/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText");
	/***
	 * Function Name :- logOut
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
public boolean logOut() throws Throwable {
	try {
		meSettingsPage.fnChangetoLanguageEnglish();
		fnSelectME();
		if(isElementDisplayed(logoutButton)){
			click(logoutButton, "Logout Button");
			click(confirm, "Confirm");
		}else 
			click(mePageLogin, "Login");
			if (isElementDisplayed(alreadyLogin, "WelcomePage"))
			{
				Reporter.pass("Logout", "Logout successful");
			}
		else
			Reporter.fail("Verfify", "Logout is not successful");
		return true;
	}

	catch (Exception e) {
		Reporter.fnPrintException(e);
		return false;
	}
}
/***
 * Function Name :- fnSelectME
 * Developed By  :- Pankaj Kumar
 * Date			 :- 23-May-2019 	
 */
public  void fnSelectME() throws Throwable
{
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
	}
	catch(Exception e)
	{
		e.printStackTrace();
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
/***
 * Function Name :- fnSelectMESection
 * Developed By  :- Pankaj Kumar
 * Date			 :- 23-May-2019 	
 */
public  void fnSelectMESection(String strSection) throws Throwable  
{
	try
	{
		
		//Click on Me Tab
		fnSelectME();
		waitForPleaseWaitDisappear();
		if(strSection.startsWith("down"))
		{
			click(downloadSection,"Downloads");
		}
		else if(strSection.startsWith("rentals"))
		{
			click(rentalsSection,"My Rentals");
		}
		else if(strSection.startsWith("watch"))
		{
			click(watchLaterModule,"Watch Later");
		}
		else if(strSection.startsWith("his"))
		{
			click(HistorySection,"History");
		}
		else if(strSection.startsWith("sett"))
		{
			click(langSettings,"Settings");
		}
		else if(strSection.startsWith("subs"))
		{
			click(subscriptionSection,"Subscription");
		}
		else if(strSection.startsWith("trans"))
		{
			click(transactionHistory,"Transaction History");
		}
		else if(strSection.startsWith("supp"))
		{
			click(supportSection,"Support");
		}
		else if(strSection.startsWith("log"))
		{
			logOut();
		}
		waitForPleaseWaitDisappear();
	}
	catch(Exception e)
	{
		Reporter.fnPrintException(e);
	}
}
/***
 * Function Name :- verifyingMePage
 * Developed By  :- Pankaj Kumar
 * Date			 :- 23-May-2019 	
 */
public  boolean verifyingMePage(boolean anonymousUser) throws Throwable {
	boolean blnStatus=true;
	Reporter.info("HOOQ IOS","Verifying ME Section");
	try {
		fnSelectME();
		scrollJs("up");
		isElementDisplayed(downloadSection, "Downloads");
		isElementDisplayed(rentalsSection, "My Rentals");
		isElementDisplayed(watchLaterModule, "Watch Later");
		isElementDisplayed(HistorySection, "History");
		isElementDisplayed(settingsSection, "Settings");
		isElementDisplayed(subscriptionSection, "Subscription");
		isElementDisplayed(transactionHistory, "Transaction History");
		isElementDisplayed(supportSection, "Support");
		if(anonymousUser){
			if(isElementDisplayed(LinkTV)==false){
				Reporter.fail("Link TV", "Link TV is not displayed");
			} else{
				Reporter.pass("Link TV", "Link TV is displayed");
			}
			isElementDisplayed(meLoginButton, "Login");
			if(isElementDisplayed(subscriptionHeading)){
				Reporter.fail("SubscriptionDays", "Subscription days are appearing for anonymous user");
			} else{
				Reporter.pass("SuscriptionDays", "Subscriptions are not appearing for anonymous user");
			}
		} else {
			isElementDisplayed(subscriptionHeading,"Subscription");
			isElementDisplayed(TicketsHeading,"Tickets");
			String subInfo=getText(subsInfo, "Subscription Info");
			if(subInfo.toLowerCase().contains("day"))
			{
				Reporter.pass("Subscription Days", "Subscription days are appearing : " + subInfo);
			} 
			else
			{
				Reporter.fail("Suscription Days", "Subscriptions are not appearing");
			}
			getText(ticketInfo, "Ticket Info");
			if(isElementDisplayed(subscriptionHeading)){
				Reporter.pass("SubscriptionDays", "Subscription days are appearing for anonymous user");
			} else{
				Reporter.fail("SuscriptionDays", "Subscriptions are not appearing for anonymous user");
			}
			scrollJs("down");
			if(isElementDisplayed(LinkTV)){
				Reporter.pass("Link TV", "Link TV is displayed");
			} else{
				Reporter.fail("Link TV", "Link TV is not displayed");
			}
			isElementDisplayed(logoutButton, "Logout");
			
		}
		click(navBackBtn,"Back From ME page");
	} catch (Exception e) {
		Reporter.fnPrintException(e);
		blnStatus=false;
	}
	blnStatus=ReportStatus.blnStatus;
	return blnStatus;
}
}
