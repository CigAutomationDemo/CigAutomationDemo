package com.automation.android.workflows;

import java.time.LocalDateTime;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.accelerators.ConfigDetails;
import com.automation.reports.Reporter;
import com.automation.utilities.HOOQInput;

public class LoginPage extends BasePage{
	//Locators
	By navBackBtn=By.id("tv.hooq.android:id/backInMainActivity");
	By meLabel=By.id("tv.hooq.android:id/ivMeBtn");
	By LoginID=By.id("tv.hooq.android:id/subtitle");
	By logoutButton=By.xpath("//android.widget.TextView[@text='Log out']");
	By confirm=By.id("tv.hooq.android:id/okay");
	By welcomeScreen=By.id("tv.hooq.android:id/accountLogin");
	By addnewemail1 = By.id("tv.hooq.android:id/emailInput");
	By iHaveVerifiedBtn = By.xpath("//android.widget.Button[@text='I have verified']");
	By HOOQLogo = By.xpath("//*[@resource-id='tv.hooq.android:id/headerLogo']"); 
	By Login = By.id("tv.hooq.android:id/accountLogin");
	By emailTab = By.id("tv.hooq.android:id/btnEmail");
	By email = By.id("text1");
	By email2 = By.id("tv.hooq.android:id/emailInputLayout");
	By emailnight = By.id("android:id/text1");
	By email1 = By.id("tv.hooq.android:id/mobileInput");
	By mobile = By.id("tv.hooq.android:id/mobileText");
	By mobiledrop = By.id("android:id/text1");
	By emailDone = By.xpath("//*[@text='Done']");
	By LoginLogo = By.name("Login"); 
	By mobalert = By.xpath("//android.widget.Button[@text='Yes']");
	By preprod =  By.xpath("//android.widget.TextView[@text='preprod']");
	By mobalert1 = By.xpath("//android.widget.TextView[@text='+91']");
	By Region = By.xpath("//*[@resource-id='tv.hooq.android:id/regionSpinner']");  
	By addnewemail = By.id("emailInput");
	By discoverLogin=By.id("tv.hooq.android:id/loginButton");
	By cast=By.id("tv.hooq.android:id/cast_featurehighlight_help_text_header_view");
	By discoverfeed=By.id("tv.hooq.android:id/discover_feed_list");
	
	public static By NameOfRegion(String region)
	{
		return 	By.xpath("//*[@text='"+region+"'][@resource-id='android:id/text1'][@class='android.widget.TextView']");
	}
	By logOut = By.xpath("//android.widget.TextView[@text='Log out']");
	By logOutConfirm = By.xpath("//android.widget.Button[@resource-id='tv.hooq.android:id/confirm']");
	By Api1 = By.xpath("//*[@resource-id='tv.hooq.android:id/apiSpinner']");
	public static By NameofAPI(String api)
	{
		
		return By.xpath("//*[@text='"+api+"'][@resource-id='android:id/text1'][@class='android.widget.TextView']");
	}
	By nightenvi =  By.xpath("//android.widget.TextView[@text='nightly']");
	By Api2 = By.xpath("//*[@resource-id='tv.hooq.android:id/apiSpinner']");
	public static By NameofAPI1(String api1)
	{
		
		return By.xpath("//*[@text='"+api1+"'][@resource-id='android:id/text1'][@class='android.widget.TextView']");
	}
	By addnewEmailButton = By.xpath("//*[@text='+ add new email'][@resource-id='android:id/text1']");
	By autofillDataList=By.id("android:id/autofill_dataset_list");
	/***
	 * Function Name :- fnVerifyReLoginStatus
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
	public  HOOQInput  fnVerifyReLoginStatus(String strUserID,String strCountry,String strEnv) throws Throwable
	{
		boolean blnStatus=true;
		Reporter.info("HOOQ Android","Verifying HOOQ Login");
		try {
			
			if(BasePage.FirstLogin)
			{
				//LogOut From Existing Login
				isAlreadyLogin();
				if(strUserID.length()>0)
				{
					Reporter.info("HOOQ Android","Verifying HOOQ Login with User ID : " + strUserID);
					if(userLogin(strUserID, strCountry, strEnv,false))
					{
						Reporter.pass("Verification of Login Status", "User :- " + strUserID +" is logedin successfully");
					}
				}
				else
				{
					if(isElementPresent(discoverLogin))
					{
						Reporter.info("HOOQ Android","Verifying HOOQ Login with as Visitor");
					}
				}
				BasePage.FirstLogin=false;
			}
			else
			{
				if(isElementPresent(discoverLogin))
				{
					Reporter.info("HOOQ Android","Verifying HOOQ Login with as Visitor");
				}
				else if (isElementDisplayed(meLabel))
				{
					mePage.fnSelectME();
					String strLoginID=getText(LoginID, "LoginID");
					if(strUserID.contains(strLoginID)==false)
					{
						click(navBackBtn,"Back From ME page");
						//LogOut From Existing Login
						isAlreadyLogin();
						if(strUserID.length()>0)
						{
							//HOOQ_IOS_MOBILE_Login
							if(userLogin(strUserID, strCountry, strEnv,false))
							{
								Reporter.pass("Verification of Login Status", "User :- " + strUserID +" is login, no need to Re-login Again");
							}
						}
						else
						{
							if(isElementPresent(discoverLogin))
							{
								Reporter.info("HOOQ Android","Verifying HOOQ Login with as Visitor");
							}
						}
					}
					else
					{
							Reporter.pass("Verification of Login Status", "User :- " + strUserID +" is already login, no need to Re-login Again");
					}
				}
			}
			if(strUserID.length()>0)
			{
				Reporter.info("HOOQ Android","Verifying Build No");
				if(strBuildNo.contains(".")==false)
				{
					objData.strBuildNo=meSupportPage.fnGetBuildNo();
					strBuildNo=objData.strBuildNo;				
				}
				else
				{
					objData.strBuildNo=strBuildNo;
				}
			}
			if(objData.strBuildNo==null)
			{
				objData.strBuildNo=LocalDateTime.now().toString();
			}
			Reporter.pass("Verification of Build No ", "HOOQ Build No " + strBuildNo);
			} catch (Exception e) {
			Reporter.fnPrintException(e);			
		}
		if(isElementPresent(navBackBtn))
		{
			click(navBackBtn,"Back From ME page");
		}
		Thread.sleep(10000);
		return objData;
	}

	
	private boolean userLogin(String strUserID, String strCountry, String strEnv, boolean b) throws Throwable {
		boolean blnStatus=true;
		try
		{
			//already have an account
			if(isElementPresent(Login))
			{
				click(Login, "Login option");
				Thread.sleep(5000);
				//email id
				click(addnewemail1, "Email Textbox");
			}
			else if(isElementPresent(discoverLogin))
			{
				click(discoverLogin, "Login option");
			}
			Thread.sleep(5000);
	        List<WebElement> eleList1 = driver.findElements(By.xpath(
	                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[1]"));
	        if (eleList1.size() > 0) {
	            eleList1.get(0).click();
	        }
	        Thread.sleep(3000);
            if(isElementDisplayed(autofillDataList))
            {
                driver.navigate().back();
            }
            Thread.sleep(3000);
	        type(addnewemail1, strUserID, "Email Address");
	        click(emailDone, "Done button");
			Thread.sleep(5000);
			if(isElementPresent(cast))
			{
				driver.findElement(discoverfeed).click();
				Thread.sleep(5000);
			}
			if(isElementDisplayed(HOOQLogo)){
				Reporter.pass("Verfify Login" ,"Successfully logged in with "+strUserID);
			} else if(isElementDisplayed(iHaveVerifiedBtn))
			{
				//dualLaunc(email);
				click(Login, "Already have an account?");
				click(emailTab, "Email tab");
				tapOn("Login");
				click(Region,"Region List");
				click(NameOfRegion(strCountry),strCountry);
				click(Api1,"API");
				click(NameofAPI(strEnv),strEnv);
				click(email, "email dropdown");
				click(addnewEmailButton,"+ add new email");
				type(addnewemail, strUserID, "Email Address");
				click(emailDone,"Done button");
				if(isElementDisplayed(HOOQLogo))
					Reporter.pass("Verfify Login" ,"Successfully logged in with "+strUserID);
				else
					Reporter.fail("Verify Login", "Login failed with "+strUserID);
				blnStatus=false;
			} else 
				Reporter.fail("Verify Login", "Login failed with "+strUserID);
		}
		catch(Exception e){blnStatus=false;}
		return blnStatus;
	}

	public boolean isAlreadyLogin() throws Throwable {
		boolean blnStatus=true;
		try
		{
			if(isElementPresent(meLabel))
			{
				logOut();
			}
		}
		catch(Exception e){blnStatus=false;}
		return blnStatus;
	
		
	}

	public boolean logOut() throws Throwable {
		boolean blnStatus=true;
		try {
			meSettingsPage.fnChangetoLanguageEnglish();
			mePage.fnSelectME();
			if(isElementDisplayed(logoutButton)){
				click(logoutButton, "Logout Button");
				click(confirm, "Confirm");
			} 
			Thread.sleep(10000);
			boolean blnLogout=false;
			if(isElementPresent(welcomeScreen))
			{
				blnLogout=true;
			}
			else if(isElementPresent(discoverLogin))
			{
				blnLogout=true;
			}
			if (blnLogout)
			{
				Reporter.pass("Logout", "Logout successful");
			}
			else
			{
				Reporter.fail("Verfify", "Logout is not successful");
				blnStatus=false;
			}
		}
		catch (Exception e) {
			Reporter.fnPrintException(e);
			blnStatus=false;
		}
		return blnStatus;
	}
	
	public void fnEnterPassword() throws Throwable
	{
		By linkEnterpassword=By.id("tv.hooq.android:id/password");
		By txtEnterPassord=By.id("tv.hooq.android:id/input");
		By btnConfirm=By.id("tv.hooq.android:id/confirm");
		By closePopup=By.id("tv.hooq.android:id/com_appboy_inappmessage_modal_close_button");
		Thread.sleep(10000);
		if(isElementPresent(linkEnterpassword))
		{
			click(linkEnterpassword,"Enter Password");
			Thread.sleep(5000);
			type(txtEnterPassord, "123456", "Password");
			Thread.sleep(5000);
			click(btnConfirm,"Enter Password");
			Thread.sleep(15000);
			click(closePopup,"Close Popup");
			Thread.sleep(10000);
		}
		
		
	}
	
}
