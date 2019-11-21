package com.automation.ios.workflows;

import org.openqa.selenium.By;

import com.automation.reports.Reporter;
import com.automation.utilities.HOOQInput;

public class LoginPage extends BasePage{
	//Locators
	By meLabel = By.id("icon me");
	By LoginID=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[10]/XCUIElementTypeStaticText[2]");
	By navBackBtn = By.name("navbar back btn");
	By skipButton = By.name("Skip this step");
	By meLoginButton = By.name("Login");
	By alreadyLogin = By.name("Login");
	By mobileLabel = By.name("Mobile");
	By mobileText = By.xpath("//XCUIElementTypeTextField[2]");
	By yesBtn = By.name("YES");
	By addnewemail = By.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField[1]");
	By emailDone = By.name("Done");
	By discover=By.id("DISCOVER");
	By isThisYourNumberText = By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeAlert");
	By smsMsgText = By.name("We will send an SMS with a 6-digit verification code to the above number.");
	/***
	 * Function Name :- fnVerifyReLoginStatus
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
	public  HOOQInput  fnVerifyReLoginStatus(String strUserID,String strCountry,String strEnv) throws Throwable
	{
		Reporter.info("HOOQ IOS","Verifying HOOQ Login");
		try {

			if(BasePage.FirstLogin)
			{
				//LogOut From Existing Login
				isAlreadyLogin();
				Reporter.info("HOOQ IOS","Verifying HOOQ Login with User ID : " + strUserID);
				if(userLogin(strUserID, strCountry, strEnv,false))
				{
					Reporter.pass("Verification of Login Status", "User :- " + strUserID +" is logedin successfully");
				}
				BasePage.FirstLogin=false;
			}
			else
			{
				if (isElementDisplayed(meLabel))
				{
					mePage.fnSelectME();
					String strLoginID=getText(LoginID, "LoginID");
					if(strUserID.contains(strLoginID)==false)
					{
						click(navBackBtn,"Back From Download page");
						//LogOut From Existing Login
							isAlreadyLogin();
						//HOOQ_IOS_MOBILE_Login
						if(userLogin(strUserID, strCountry, strEnv,false))
						{
							Reporter.pass("Verification of Login Status", "User :- " + strUserID +" is login, no need to Re-login Again");
						}
					}
					else
					{
							Reporter.pass("Verification of Login Status", "User :- " + strUserID +" is already login, no need to Re-login Again");
					}
				}
			}
			Reporter.info("HOOQ IOS","Verifying Build No");
			if(strBuildNo.contains("App Version")==false)
			{
				objData.strBuildNo=meSupportPage.fnGetBuildNo();
				strBuildNo=objData.strBuildNo;				
			}
			else
			{
				objData.strBuildNo=strBuildNo;
			}
			Reporter.pass("Verification of Build No ", "HOOQ Build No " + strBuildNo);
			} catch (Exception e) {
			Reporter.fnPrintException(e);			
		}
		if(isElementDisplayed(navBackBtn))
		{
			click(navBackBtn,"Back From ME page");
		}
		click(discover,"Discover Page");
		return objData;
	}
	
	/***
	 * Function Name :- userLogin
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
	public  boolean userLogin(String emailMobile, String region, String envi,Boolean skip) throws Throwable {
		
		try {
			//Reporter.reportStep("Login/Skip");
			if(skip){
				click(skipButton, "Skip this step");
			} else {
				click(alreadyLogin, "logInButton");
				//fnSelectCountryEnv(region,envi);
				if(emailMobile.matches("[0-9]+")){
					click(mobileLabel, "MobileTab");
					type(mobileText, emailMobile, "MobileNumber");
					click(emailDone, "Done");
					verifyAlertMessage(emailMobile);
					click(yesBtn, "Yes");
					
				} else {
					//click(emailLabel, "Email label");
					type(addnewemail, emailMobile, "emailField");
					click(emailDone, "Done");
				}
			}
			if(discoverPage.verifyDiscoverFeed()){
				
				Reporter.pass("Login", "Logged in successfully");
				meSettingsPage.fnChangetoLanguageEnglish();
				if(isElementDisplayed(navBackBtn))
				{
					click(navBackBtn,"Back From ME page");
				}
				click(discover,"Discover Page");
			} else {
				Reporter.fail("DiscoverFeed", "App is taking more time to display Discover Feed");
				return false;
			}
			
		} catch (Exception e) {
			Reporter.fnPrintException(e);
			return false;
		}
		return true;
	}
	
	/***
	 * Function Name :- isAlreadyLogin
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
	public  boolean isAlreadyLogin() throws Throwable {

		try {
			if (isElementPresent(meLabel))
				mePage.logOut();
			return true;
		} catch (Exception e) {
			Reporter.fnPrintException(e);
			return false;
		}
	}
	/***
	 * Function Name :- verifyAlertMessage
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
	public  boolean verifyAlertMessage(String mobileNumber) throws Throwable{
		try {
			String text = getText(isThisYourNumberText, "Is this your number?");
			if(text.contains(mobileNumber)){
				Reporter.pass("MobileNumber", mobileNumber+" is found correctly in the alert message");
			} else {
				Reporter.fail("MobileNumber", mobileNumber+" is not found in the alert message");
			}
			if(isElementDisplayed(smsMsgText)){
				Reporter.pass("MobileNubmer", "SMS description is correctly displayed");
			} else {
				Reporter.fail("MobileNubmer", "SMS description is not correctly displayed");
			}
		} catch (Exception e) {
			Reporter.fnPrintException(e);
		}
		return true;
	}
}
