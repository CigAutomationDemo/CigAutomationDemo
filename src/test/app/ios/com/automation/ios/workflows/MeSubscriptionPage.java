package com.automation.ios.workflows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.reports.Reporter;

public class MeSubscriptionPage extends BasePage{
	//Locators
	By vocherTextBox = By.xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTextField");
	By submitButton = By.name("Submit");
	By alertErrorMessage = By.name("Invalid code");
	By okButton = By.name("Okay");
	By redeemCode = By.name("Code redeemed");
	By subAnonDay = By.name("0 DAY");
	By subAnonMessage = By.name("You do not have an active subscription.");
	By navBackBtn = By.name("navbar back btn");
	By howdyStranger = By.name("HOWDY STRANGER!");
	By anonSubscriptionMessage = By.name("You need to be logged in to view your subscription details.");
	By getStartedTitle1 = By.name("Get Started");
	By subscriptionHeading = By.name("SUBSCRIPTION");
	By alreadyLogin = By.name("Login");
	By remainingDaysInMePage= By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeImage/XCUIElementTypeStaticText[2]");
	By remainingDays = By.xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[2]");
	By expiresOn = By.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[3]");
	By terminationDesc = By.xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeStaticText[2]");
	By SubsTitle = By.name("SUBSCRIPTION");
	By lblSubMessage1=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[1]");
	By lblSubMessage2=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[2]");
	By lblSubInfo1=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[1]");
	By lblSubInfo2=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[2]");
	By lblSubInfo3=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeStaticText[1]");
	By lblSubInfo4=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeStaticText[2]");
	By lnkCancelSub=By.id("Cancel Subscription");
	By lblCancelSubMessage=By.id("Proceed to cancel your subscription");
	By lblLapsedMessage1=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[1]");
	By lblLapsedMessage2=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[2]");
	By btnSubscribeNow=By.id("Subscribe now");
	By btnStartYourTrail=By.id("Start your 30 day trial!");
	By subPayentMsg1=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeWebView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeStaticText");
	By subPaymentMsg2=By.id("No commitment, cancel anytime");
	By subPaymentMsg3=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeWebView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText");
	By subPaymentMsg4=By.id("No commitment, cancel anytime");
	By subPaymantPlan=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeWebView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[6]");
	By subPaymentPopup=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeAlert/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther");
	By subPaymentPopUpDetail1=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeAlert/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeStaticText[1]");
	By subPaymentPopUpDetail2=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeAlert/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeStaticText[2]");
	By subPaymentPopUpEnterPassword=By.id("Enter Password");
	By subPaymentPopUpCancel=By.id("Cancel");
	By lblCancelMessage=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeStaticText[2]");
	By SignInItunes=By.id("Sign-In Required");
	By SignInMessage=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[5]/XCUIElementTypeOther[2]/XCUIElementTypeAlert/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[2]");
	By SignInPassword=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[5]/XCUIElementTypeOther[2]/XCUIElementTypeAlert/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeSecureTextField");
	By SignInCancel=By.id("Cancel");
	By SignInOK=By.id("Buy");
	By SubsBack=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeWebView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther");
	By RentPageTktInfo=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText");
	By RentPageTable=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeCollectionView");
	By RentPageInnerTable=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable");
	/***
	 * Function Name :- applyVoucher
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public  boolean applyVoucher(String code,boolean click) throws Throwable{
		try {
			type(vocherTextBox, code, "Voucher textbox");
			if(click)
				click(submitButton, "Submit button");
		} catch (Exception e) {
			Reporter.fnPrintException(e);
		}
		return false;
	}
	/***
	 * Function Name :- verifySubscritionPageLapsedUser
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public  boolean verifySubscritionPageLapsedUser() throws Throwable {
		//Reporter.reportStep("Verify_Subscription_Page_Details");
		try {
			verifyText(subAnonDay, "0 DAY", "zeor days");
			verifyText(subAnonMessage, "You do not have an active subscription.", "Subscription Message");
			click(navBackBtn, "Back button");
			return true;
		} catch (Exception e) {
			Reporter.fnPrintException(e);
			return false;
		}
	}
	/***
	 * Function Name :- verifyAnonymousUserSubscription
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public  boolean verifyAnonymousUserSubscription(String description) throws Throwable {
		try {
			//Reporter.reportStep("Verify_Subscription_Page_Details");
			verifyText(howdyStranger, "HOWDY STRANGER!", "Howday Stranger");
			verifyText(anonSubscriptionMessage,
					"You need to be logged in to view your subscription details.", "Anonymous Subcription Message");
			click(getStartedTitle1, "get started button");
			if (isElementDisplayed(alreadyLogin, description)) {
				Reporter.pass("Verfify ", " <b>" + description + "</b>" + " is displayed ");
			} else {
				Reporter.fail("Verfify", " <b>" + description + "</b>" + " is not displayed ");
			}
			/*click(closeButton, "close button");

			click(backButton, "Back button");
*/			return true;
		} catch (Exception e) {
			Reporter.fnPrintException(e);
			return false;
		}
	}
	/***
	 * Function Name :- verifySubscription
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public  boolean verifySubscription(String days) throws Throwable {
		try {
			//Reporter.reportStep("Verifying Subscription");
			String text = null;
			verifyText(subscriptionHeading, "SUBSCRIPTION", "Subscription heading");
			if(isElementDisplayed(remainingDays)){
				text = getText(remainingDays, "Remaning days");
				if(days.equalsIgnoreCase(text)){
					Reporter.pass("SubscriptionDays", "Subscriptions days are matching in Me Page it is:"+days+" and in Subscription page it is "+text);
				} else {
					Reporter.fail("SubscriptionDays", "Subscriptions days are not matching in Me Page it is:"+days+" and in Subscription page it is "+text);
				}
				
			} else {
				Reporter.fail("Remaining Days", "Remaining days are not displayed");
			} 
			if(isElementDisplayed(expiresOn)){
				text = getText(expiresOn, "Expires on");
				Reporter.pass("ExpiresOn", "Expires on is displayed as "+text);
			} else {
				Reporter.fail("ExpiresOn", "Expires On is not displayed");
			}
			
		} catch (Exception e) {
			Reporter.fnPrintException(e);
		}
		return false;
	}
	
	/***
	 * Function Name :- fnVerifySubscriptionFree
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public  boolean fnVerifySubscriptionFree() throws Throwable
	{
		Reporter.info("HOOQ IOS","Verifying Subscription for Free User");
		boolean blnFound=true;
		try
		{
			mePage.fnSelectMESection("subs");
			commonPage.waitForPleaseWaitDisappear();
			boolean blnHeader=isElementDisplayed(SubsTitle);
			if(blnHeader)
			{
				Reporter.pass("Subscription Screen", "Subscription Section is displayed");
				String strSubMessage1=getText(lblSubMessage1,"Subscription RenewInformation");
				String strSubMessage2=getText(lblSubMessage2,"Subscription Remaing Days");
				String strSubInfo1=getText(lblSubInfo1,"Expires Label");
				String strSubInfo2=getText(lblSubInfo2,"Expiration Date");
				String strSubInfo3=getText(lblSubInfo3,"AutoRenew Label");
				String strSubInfo4=getText(lblSubInfo4,"AutoRenew Status");
				boolean blnStartTrail=isElementDisplayed(btnStartYourTrail);
				boolean blnCancel=isElementDisplayed(lnkCancelSub);
				String strCancelSubMessage=getText(lblCancelMessage,"Cancel Subscription Message");
				if(strSubMessage1.contains("Your trial expires in"))
				{
					Reporter.pass("Subscription Screen", "Renew Information " + strSubMessage1 + " is displayed");
				}
				else
				{
					Reporter.fail("Subscription Screen", "Renew Information is not displayed , Message Displayed " + strSubMessage1);
				}
				if(strSubMessage2.toLowerCase().contains("days"))
				{
					Reporter.pass("Subscription Screen", "Renew Information Days " + strSubMessage2 + " is displayed");
				}
				else
				{
					Reporter.fail("Subscription Screen", "Renew Information Days is not displayed , Message Displayed " + strSubMessage2);
				}
				if(strSubInfo1.toLowerCase().contains("expires on"))
				{
					Reporter.pass("Subscription Screen", "Renew Information " + strSubInfo1 + " is displayed");
				}
				else
				{
					Reporter.fail("Subscription Screen", "Renew Information is not displayed , Message Displayed " + strSubInfo1);
				}
				if(strSubInfo2.toLowerCase().contains("-"))
				{
					Reporter.pass("Subscription Screen", "Renew Information Expires " + strSubInfo2 + " is displayed");
				}
				else
				{
					Reporter.fail("Subscription Screen", "Renew Information  Expires is not displayed , Message Displayed " + strSubInfo2);
				}
				if(strSubInfo3.toLowerCase().contains("auto-renew"))
				{
					Reporter.pass("Subscription Screen", "Renew Information " + strSubInfo3 + " is displayed");
				}
				else
				{
					Reporter.fail("Subscription Screen", "Renew Information is not displayed , Message Displayed " + strSubInfo3);
				}
				if(strSubInfo4.toLowerCase().contains("off"))
				{
					Reporter.pass("Subscription Screen", "Renew Information Auto Renew" + strSubInfo4 + " is displayed");
				}
				else
				{
					Reporter.fail("Subscription Screen", "Renew Information Auto Renew is not displayed , Message Displayed " + strSubInfo4);
				}
				if(blnCancel)
				{
					Reporter.pass("Subscription Screen", "Cancel Subscription Link is displayed");
				}
				else
				{
					Reporter.fail("Subscription Screen", "Cancel Subscription Link is not displayed");
				}
				if(strCancelSubMessage.toLowerCase().contains("your subscription will expire on") && strCancelSubMessage.toLowerCase().contains("no action is required."))
				{
					Reporter.pass("Subscription Screen", "Cancel Subscription Message " + strCancelSubMessage + " is displayed");
				}
				else
				{
					Reporter.fail("Subscription Screen", "Cancel Subscription Message is not displayed Message Displayed " + strCancelSubMessage);
				}
				if(blnStartTrail)
				{
					Reporter.pass("Subscription Screen", "Start Your 30 Days trail button is displayed");
					click(btnStartYourTrail,"Start your 30 day trail");
					commonPage.waitForPleaseWaitDisappear();
					fnVerifyPaymentPlan();
					List<WebElement> eleList1=driver.findElements(By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeWebView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther"));
					System.out.println(eleList1.size());
					eleList1.get(0).click();
					
					WebElement eleRoot=driver.findElement(SubsBack);
					List<WebElement> eleBack=eleRoot.findElements(By.xpath("XCUIElementTypeOther"));
					System.out.println(eleBack.size());
					eleBack.get(0).click();
				}
				else
				{
					Reporter.fail("Subscription Screen", "Start Your 30 Days trail button is not displayed");
				}
			}
			else
			{
				Reporter.fail("Subscription Screen", "Subscription Section is not displayed");			
			}
			
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			blnFound=false;
		}
		return blnFound;
	}
	
	/***
	 * Function Name :- fnVerifyPaymentPlan
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public  boolean fnVerifyPaymentPlan() throws Throwable
	{
		boolean blnStatus=true;
		try
		{
			//Reporter.reportStep("Verifying Payment Plan");
			String strMessage1=getText(subPayentMsg1,"Payment Plan Message 1");
			System.out.println(strMessage1);
			String strMessage2=getText(subPaymentMsg2,"Payment Plan Message 2");
			System.out.println(strMessage2);
			String strMessage3=getText(subPaymentMsg3,"Payment Plan Message 3");
			System.out.println(strMessage3);
			String strMessage4=getText(subPaymentMsg4,"Payment Plan Message 4");
			System.out.println(strMessage4);
			if(strMessage1.contains("4"))
			{
				Reporter.pass("Subscription Payment Screen", "Payment Info " + strMessage1 + " is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Screen", "Payment info is not displayed Message : " + strMessage1);
				
			}
			if(strMessage2.contains("No commitment, cancel anytime"))
			{
				Reporter.pass("Subscription Payment Screen", "Payment Info " + strMessage2 + " is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Screen", "Payment info is not displayed Message : " + strMessage2);	
			}
			if(strMessage3.contains("First 90 days for INR 89 only - Less than 1 rupee/day"))
			{
				Reporter.pass("Subscription Payment Screen", "Payment Info " + strMessage3 + " is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Screen", "Payment info is not displayed Message : " + strMessage3);	
			}
			if(strMessage4.contains("No commitment, cancel anytime"))
			{
				Reporter.pass("Subscription Payment Screen", "Payment Info " + strMessage4 + " is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Screen", "Payment info is not displayed Message : " + strMessage4);	
			}			
			WebElement elePlan=driver.findElement(subPaymantPlan);
			List<WebElement> elePlanType=elePlan.findElements(By.xpath("XCUIElementTypeOther"));
			if(elePlanType.size() > 0)
			{	
				Reporter.pass("Subscription Payment Plan", elePlanType.size() + " Payment Plan is displayed");		
				List<WebElement> elePlanValue1=elePlanType.get(0).findElements(By.xpath("XCUIElementTypeOther"));
				System.out.println(elePlanValue1.size());
				String strPlanType1=elePlanValue1.get(0).findElement(By.xpath("XCUIElementTypeText")).getText();
				String strPlanType1Value=elePlanValue1.get(1).findElement(By.xpath("XCUIElementTypeText")).getText();
				List<WebElement> elePlanValue2=elePlanType.get(1).findElements(By.xpath("XCUIElementTypeOther"));
				String strPlanType2=elePlanValue2.get(0).findElement(By.xpath("XCUIElementTypeText")).getText();
				String strPlanType2Value=elePlanValue2.get(1).findElement(By.xpath("XCUIElementTypeText")).getText();
				if(strPlanType1.contains("Monthly Plan"))
				{
					Reporter.pass("Subscription Payment Plan 1", "Payment Info " + strPlanType1 + " is displayed");
				}
				else
				{
					Reporter.fail("Subscription Payment Plan 1", "No Payment Info is displayed");	
				}
				if(strPlanType1Value.contains("INR89"))
				{
					Reporter.pass("Subscription Payment Plan 2", "Payment Info Price " + strPlanType1Value + " is displayed");
				}
				else
				{
					Reporter.fail("Subscription Payment Plan 2", "No Payment Info is displayed");	
				}	
				if(strPlanType2.contains("1 Year Plan"))
				{
					Reporter.pass("Subscription Payment Plan 2", "Payment Info " + strPlanType2 + " is displayed");
				}
				else
				{
					Reporter.fail("Subscription Payment Plan 2", "No Payment Info is displayed");	
				}
				if(strPlanType2Value.contains("INR449"))
				{
					Reporter.pass("Subscription Payment Plan 2", "Payment Info Price " + strPlanType2Value + " is displayed");
				}
				else
				{
					Reporter.fail("Subscription Payment Plan 2", "No Payment Info is displayed");	
				}	
				//Click on First Payment Plan and Verify Popup
				//Reporter.reportStep("Verifying Payment Plan for 1 Year");
				//elePlanType.get(0).click();
				//fnVerifyITunesPayementPopup();
			//	Reporter.reportStep("Verifying Payment Plan for 1 Month");
			//	elePlanType.get(1).click();
			//	fnVerifyITunesPayementPopup();
			}
			else
			{
				Reporter.fail("Subscription Payment Plan", "No Payment Plan is displayed");	
				
			}
			
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			blnStatus=false;
		}
		return blnStatus;
	}
	/***
	 * Function Name :- fnVerifyITunesPayementPopup
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public  boolean fnVerifyITunesPayementPopup() throws Throwable
	{
		boolean blnPopup=true;
		try
		{
			commonPage.waitForPleaseWaitDisappear();
			if(isElementDisplayed(subPaymentPopup))
			{
				String strsubPaymentPopUpDetail1=getText(subPaymentPopUpDetail1,"Payment PopupDetails 1");
				String strsubPaymentPopUpDetail2=getText(subPaymentPopUpDetail2,"Payment PopupDetails 2");
				boolean blnEnterPassword=isElementDisplayed(subPaymentPopUpEnterPassword);
				boolean blnCancel=isElementDisplayed(subPaymentPopUpCancel);
				if(strsubPaymentPopUpDetail1.contains("Touch ID"))
				{
					Reporter.pass("Subscription Payment ITunes Popup", "ITunes Popup for Payement is displayed");
				}
				else
				{
					Reporter.fail("Subscription Payment ITunes Popup", "ITunes Popup for Payement is not displayed");	
				}	
				if(strsubPaymentPopUpDetail2.contains("@"))
				{
					Reporter.pass("Subscription Payment ITunes Popup", "ITunes Popup for Payement User ID is displayed ITunes User ID " + strsubPaymentPopUpDetail1);
				}
				else
				{
					Reporter.fail("Subscription Payment ITunes Popup", "ITunes Popup for Payement User ID is not displayed");	
				}
				if(blnEnterPassword)
				{
					Reporter.pass("Subscription Payment ITunes Popup","ITunes Popup Enter Password is displayed"); 
				}
				else
				{
					Reporter.fail("Subscription Payment ITunes Popup","ITunes Popup Enter Password is not displayed");	
				}
				if(blnCancel)
				{
					Reporter.pass("Subscription Payment ITunes Popup","ITunes Popup Cancel Button is displayed"); 
					click(subPaymentPopUpCancel,"Cancel ITunes Popup");
					commonPage.waitForPleaseWaitDisappear();
				}
				else
				{
					Reporter.fail("Subscription Payment ITunes Popup","ITunes Popup Cancel Button is displayed");	
				}
			}
			else if(isElementDisplayed(SignInItunes))
			{
				String strText1=getText(SignInItunes,"ITunes Popup Header");
				String strText2=getText(SignInMessage,"ITunes Popup Details");
				boolean blnPassword=isElementDisplayed(SignInPassword);
				boolean blnOk=isElementDisplayed(SignInOK);
				boolean blnCancel=isElementDisplayed(SignInCancel);
				if(strText1.contains("Sign-In Required"))
				{
					Reporter.pass("Subscription Payment ITunes Popup", "ITunes Popup for Payement is displayed");
				}
				else
				{
					Reporter.fail("Subscription Payment ITunes Popup", "ITunes Popup for Payement is not displayed");	
				}
				if(strText2.contains("If you have an Apple ID"))
				{
					Reporter.pass("Subscription Payment ITunes Popup", "ITunes Popup for Payement User ID is displayed ITunes User ID " + strText2);
				}
				else
				{
					Reporter.fail("Subscription Payment ITunes Popup", "ITunes Popup for Payement User ID is not displayed");	
				}
				if(blnPassword)
				{
					Reporter.pass("Subscription Payment ITunes Popup","ITunes Popup Enter Password is displayed"); 
				}
				else
				{
					Reporter.fail("Subscription Payment ITunes Popup","ITunes Popup Enter Password is not displayed");	
				}
				if(blnOk)
				{
					Reporter.pass("Subscription Payment ITunes Popup","ITunes Popup OK Button is displayed"); 
				}
				else
				{
					Reporter.fail("Subscription Payment ITunes Popup","ITunes Popup OK Button is not displayed");	
				}
				if(blnCancel)
				{
					Reporter.pass("Subscription Payment ITunes Popup","ITunes Popup Cancel Button is displayed"); 
					click(SignInCancel,"Cancel ITunes Popup");
					commonPage.waitForPleaseWaitDisappear();
				}
				else
				{
					Reporter.fail("Subscription Payment ITunes Popup","ITunes Popup Cancel Button is not displayed");	
				}
			}
			else
			{
				Reporter.fail("Subscription Payment ITunes Popup","ITunes Popup is not  displayed");
				blnPopup=false;
			}
			
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			blnPopup=false;
		}
		return blnPopup;
	}
}
