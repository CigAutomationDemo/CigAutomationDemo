package com.automation.ios.workflows;

import java.time.LocalDateTime;

import org.openqa.selenium.By;
import com.automation.reports.Reporter;

public class MeSupportPage extends BasePage{
	//Locators
	By meLabel = By.id("icon me");
	By buildNo=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[6]/XCUIElementTypeStaticText");
	By navBackBtn = By.name("navbar back btn");
	By discover=By.id("DISCOVER");
	By contactUs = By.name("Contact Us");
	By aboutUs =  By.name("About Us");
	By faq = By.name("FAQ");
	By privacyPolicy = By.name("Privacy Policy");
	By cancel = By.name("Cancel");
	By deleteDraft = By.name("Delete Draft");
	By aboutUsHeading = By.xpath("//XCUIElementTypeStaticText[@name='ABOUT US']");
	By faqHeading = By.xpath("//XCUIElementTypeStaticText[@name='FAQ']");
	By hooqDigitalPteLtd = By.name("HOOQ Digital Pte Ltd");
	By helpTopics = By.name("Help Topics");
	By privacyPolicyHeading = By.xpath("//XCUIElementTypeStaticText[contains(@name,'PRIVACY POLICY')]");
	By generalTerms = By.xpath("//XCUIElementTypeStaticText[contains(@name,'GENERAL TERMS AND CO')]");
	By appVersion = By.xpath("//XCUIElementTypeStaticText[contains(@name,'App Version')]");
	By backButton = By.id("navbar back btn");
	By termsOfUse = By.name("Terms of Use");
	/***
	 * Function Name :-fnGetBuildNo 
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
	public  String fnGetBuildNo() throws Throwable
	{
		String strBuildNo="";
		try
		{
			if(objData.strBuildNo==null)
			{
				//Reporter.reportStep("Get HOOQ Build No");
				if(isElementDisplayed(meLabel))
				{
					//Go to the Specific Section
					mePage.fnSelectMESection("supp");
					strBuildNo=getText(buildNo,"HOOQ Build No");
					strBuildNo=strBuildNo.replaceAll("\n", " - ");
					System.out.println(strBuildNo);
					objData.strBuildNo=strBuildNo;
					click(navBackBtn,"Back From Settings page");
					click(navBackBtn,"Back From Settings page");
					click(discover,"Discover Page");
				}
				else
				{
					strBuildNo=LocalDateTime.now().toString();
				}
			}
			else
			{
				strBuildNo=objData.strBuildNo;
			}
				
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			
		}
		return strBuildNo;
	}
	
	/***
	 * Function Name :- verifySupportPage
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public  boolean verifySupportPage() throws Throwable {
		Reporter.info("HOOQ IOS","Verifying Support");
		mePage.fnSelectMESection("supp");
		try {
			if(isElementPresentEvenNotVisibleOnScreen(contactUs)){
				Reporter.pass("Contact Us", "Contact Us button is available");
				//click(contactUs, "Contact Us");
				//click(cancel, "Cancel button");
				//click(deleteDraft, "Delete Draft");
			} else {
				Reporter.fail("Contact Us", "Contact Us button is not available");
			}
			if(isElementPresentEvenNotVisibleOnScreen(aboutUs)){
				Reporter.pass("AboutUs", "About Us button is displayed");
				click(aboutUs, "About Us");
				isElementDisplayed(aboutUsHeading, "About Us Heading");
				click(backButton, "Back button");
			} else {
				Reporter.fail("AboutUs", "About Us button is not available");
			}
			
			if(isElementPresentEvenNotVisibleOnScreen(faq)){
				Reporter.pass("FAQ", "FAQ button is displayed");
				click(faq, "FAQ");
				isElementPresentEvenNotVisibleOnScreen(faqHeading, "FAQ Heading");
				isElementPresentEvenNotVisibleOnScreen(hooqDigitalPteLtd, "HOOQ Digital Pte Ltd");
				click(backButton, "Back button");
			} else {
				Reporter.fail("FAQ", "FAQ button is not available");
			}
			if(isElementDisplayed(privacyPolicy)){
				Reporter.pass("PrivacyPolicy", "Privacy Policy button is displayed");
				click(privacyPolicy, "Privacy Policy");
				isElementPresentEvenNotVisibleOnScreen(privacyPolicyHeading, "Privacy Policy Heading");
				click(backButton, "Back button");
			} else {
				Reporter.fail("PrivacyPolicy", "Privacy Policy button is not available");
			}
			if(isElementDisplayed(termsOfUse)){
				Reporter.pass("Terms of Use", "Terms of Use button is displayed");
				click(termsOfUse, "Terms of Use");
				isElementPresentEvenNotVisibleOnScreen(generalTerms, "General Terms of Use Heading");	
				click(backButton, "Back button");
			} else {
				Reporter.fail("Terms of Use", "Terms of Use button is displayed");
			}
			if(isElementPresentEvenNotVisibleOnScreen(appVersion)){
				Reporter.pass("AppVersion", "AppVersion is displayed");
			} else {
				Reporter.fail("AppVersion", "AppVersion is not displayed");
			}
			click(backButton, "Back button");
		} catch (Exception e) {
			Reporter.fnPrintException(e);
			return false;
		}
		return true;
	}
}
