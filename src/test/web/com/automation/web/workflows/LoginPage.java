package com.automation.web.workflows;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.automation.reports.Reporter;

public class LoginPage extends BasePage{
	By hooqLogo=null;
	By hamburgerMenu =null;
	By loginBtn = null;
	By loginTitleVerification =null;
	By lblEmail = null;
	By emailIDTxt=null;
	By evLoginBtn =null;
	By lblPWDForm =null;
	By txtPWD=null;
	By btnPWDLogin = null;
	By closehamburgerMenu = null;
	By txtLoginMobile = null;
	By btnLoginNxt = null;
	By logoutLink=null;
	
	//Locators
	public void fnLoadLocators()
	{
		try{
			if(objConfig.strDriverType!=null)
			{
				if(objConfig.strDriverType.toLowerCase().equals("chromemobileview"))
				{
					hooqLogo=By.xpath("(//a[contains(@class,'HOOQLogo__Wrapper')])[1]");
					hamburgerMenu = By.xpath("(//img[@title='Menu'])[1]");
					loginBtn = By.xpath("//li[contains(@class,'e2e-sideMenu-login')]/a");
					loginTitleVerification = By.tagName("label");
					lblEmail = By.xpath("//a[contains(@class,'redirect_url emailormobile')]");
					emailIDTxt=By.xpath("//input[@id='email']");
					evLoginBtn = By.xpath("//*[@type='submit']");
					lblPWDForm = By.xpath(".//*[@id='loginpwd_form']/label");
					txtPWD=By.xpath("//input[@name='password']");
					btnPWDLogin = By.xpath(".//*[@id='loginpwd_form']/div[2]/button");
					closehamburgerMenu = By.xpath("//img[@title='Close']");
					txtLoginMobile = By.xpath("//*[@id='mobile']");
					btnLoginNxt = By.xpath("//div[contains(@class,'SideMenu__UserLoginText')]");
					logoutLink=By.xpath("(//a[@href='/auth/logout'])[2]");
				}
				else if(objConfig.strDriverType.toLowerCase().equals("androidchrome"))
				{
					hooqLogo=By.xpath("(//a[contains(@class,'HOOQLogo__Wrapper')])[1]");
					hamburgerMenu = By.xpath("//*[@id='mount']/header[1]/div/a[2]/img");
					loginBtn = By.xpath("//li[contains(@class,'e2e-sideMenu-login')]/a");
					loginTitleVerification = By.tagName("label");
					lblEmail = By.xpath("//a[contains(@class,'redirect_url emailormobile')]");
					emailIDTxt=By.xpath("//input[@id='email']");
					evLoginBtn = By.xpath("//*[@type='submit']");
					lblPWDForm = By.xpath(".//*[@id='loginpwd_form']/label");
					txtPWD=By.xpath("//input[@name='password']");
					btnPWDLogin = By.xpath(".//*[@id='loginpwd_form']/div[2]/button");
					closehamburgerMenu = By.xpath("//img[@title='Close']");
					txtLoginMobile = By.xpath("//*[@id='mobile']");
					btnLoginNxt = By.xpath("//div[contains(@class,'SideMenu__UserLoginText')]");
					logoutLink=By.xpath("(//a[@href='/auth/logout'])[2]");
				}
				else if(objConfig.strDriverType.toLowerCase().equals("desktopchrome"))
				{
					hooqLogo=By.xpath("//header[contains(@class,'desktop Header__HeaderContainer')]//a[contains(@class,'HOOQLogo__Wrapper')]");
					hamburgerMenu = By.xpath("(//img[@title='Menu'])[2]");
					loginBtn = By.xpath("//*[contains(@class,'Header__LoginButton')]");
					loginTitleVerification = By.tagName("label");
					lblEmail = By.xpath("//a[contains(@class,'redirect_url emailormobile')]");
					emailIDTxt=By.xpath("//input[@id='email']");
					evLoginBtn = By.xpath("//*[@type='submit']");
					lblPWDForm = By.xpath(".//*[@id='loginpwd_form']/label");
					txtPWD=By.xpath("//input[@name='password']");
					btnPWDLogin = By.xpath(".//*[@id='loginpwd_form']/div[2]/button");
					closehamburgerMenu = By.xpath("//img[@title='Close']");
					txtLoginMobile = By.xpath("//*[@id='mobile']");
					btnLoginNxt = By.xpath(".//*[contains(@class,'NavPopupMenu__UserLoginText')]");
					logoutLink=By.xpath("//a[@href='/auth/logout']");
				}
			}
		}
		catch(Exception e){}
	}
	
	
	
	
	public  boolean launchUrl(String url) throws Throwable {
		boolean flag = false;
		try {
			if(BasePage.FirstLogin)
			{
				driver.get(url);
			}
			else
			{
				driver.navigate().to(url);
			}
			ImplicitWait();	
			
			flag = true;
			return true;
		} catch (Exception e) {
			Assert.assertTrue(flag,"Failed to launch "
					+ url);
			Reporter.fnPrintException(e);
			return false;
		}
	}

	public  boolean launchHOOQUrl(String url) throws Throwable {
		boolean flag = false;
		try {
			if(launchUrl(url))
				fnGetBuildNo();
			return true;
		} catch (Exception e) {
			Reporter.fnPrintException(e);
			return false;
		}
	}
	public boolean verifyLoginWithEV(String email,String password,String mobileNo,String struserID) throws Throwable
	{
		fnLoadLocators();
		boolean blnStatus=true;
		try
		{
			Thread.sleep(10000);
			loginPage.launchHOOQUrl(objConfig.strURL);
			Thread.sleep(3000);
			JSClick(hamburgerMenu,"Hamburger Menu");
			Thread.sleep(3000);		
			if(isElementDisplayed(btnLoginNxt))
			{
				String strUser=getText(btnLoginNxt,"Login ID");
				System.out.println(strUser);
				if(!strUser.equalsIgnoreCase(email))
				{
					logOut();
					JSClick(hamburgerMenu,"Hamburger Menu");
					Thread.sleep(3000);	
					JSClick(loginBtn,"Click on Login");
					fnLoginWithEmail(email);
				}	
				JSClick(closehamburgerMenu,"Close Hamburger Menu");
			}
			else if(isElementDisplayed(loginBtn))
			{
				JSClick(loginBtn,"Click on Login");
				Thread.sleep(4000);
				String loginTitle=null;//getText(loginTitleVerification, "Login page title");
				if(isElementDisplayed(loginTitleVerification))
				{
					loginTitle=getText(loginTitleVerification, "Login page title");
					Reporter.pass("Verify Login Page", " "+loginTitle+" displayed successfully"); 
				}
				else
				{
					Reporter.fail("Verify Login Page", ""+loginTitle+" is not displayed successfully");
				}
				Thread.sleep(5000);
				if(struserID.equalsIgnoreCase("email"))
				{
					fnLoginWithEmail(email);
				}
				else if(struserID.equalsIgnoreCase("mobile"))
				{
					fnLoginWithMobileNo(mobileNo, struserID);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return blnStatus;
	}

	public boolean logOut() throws Throwable
	{
		fnLoadLocators();
		boolean blnStatus=true;
		try
		{
			click(hamburgerMenu,"Click on Hamburger Menu");
			Thread.sleep(3000);
			click(logoutLink,"Click on Logout");
			Thread.sleep(5000);
			click(hamburgerMenu,"Click on Hamburger Menu");
			Thread.sleep(3000);
			if(isElementDisplayed(loginBtn))
			{
				Reporter.pass("Verify Logout ", " Log out is done successfully"); 
			}
			else
			{
				Reporter.fail("Verify Logout", " Logout is not done successfully"); 
			}
			click(closehamburgerMenu,"Click on close button on Hamburger Menu");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return blnStatus;
	}
	
	public boolean fnLoginWithMobileNo(String mobileNo,String struserID) throws Throwable
	{
		fnLoadLocators();
		boolean blnStatus=true;
		try
		{
			Reporter.pass("Login to HOOQ Application","Login with " + mobileNo + " User Type: " + struserID);
			//Thread.sleep(10000);
			System.out.println("String mobile: "+mobileNo+ "String userType "+struserID);
			Thread.sleep(2000);
			type(txtLoginMobile, mobileNo, "Mobile number");
			Thread.sleep(2000);
			click(btnLoginNxt, "Next");
			Thread.sleep(2000);
			String strMobileVerify=getText(lblPWDForm,"Login Verification");
			System.out.println(strMobileVerify);
			if(strMobileVerify.contains("Enter your password") || strMobileVerify.contains("Ketik kata sandi kamu") || strMobileVerify.contains("ใส่รหัสผ่านของคุณ"))
			{
				type(txtPWD, "123456", "Password");
				Thread.sleep(5000);
				click(btnPWDLogin, "Login");
				Thread.sleep(5000);
				Thread.sleep(8000);
				click(hamburgerMenu,"Hamburger Menu");
				Thread.sleep(3000);
				if(isElementDisplayed(logoutLink))
				{
					blnStatus=true;
				}
				else
				{
					blnStatus=false;
				}
				click(closehamburgerMenu,"Close Hamburger Menu");
				Thread.sleep(3000);
			}
		}
		catch(Exception e){blnStatus=false;}
		return blnStatus;
		
	}
	

	public boolean fnLoginWithEmail(String strEmail) throws Throwable
	{
		fnLoadLocators();
		boolean blnStatus=true;
		try
		{
			JSClick(lblEmail,"Click on Email button");
			Thread.sleep(2500);
			System.out.println(strEmail);	
			click(emailIDTxt,"Click on Email text");
			JStype("email","Entering Valid Email ID", strEmail + "l");
			Thread.sleep(2000);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.BACK_SPACE).build().perform();		
			Thread.sleep(2000);
			JSClick(evLoginBtn,"Click on login button");
			Thread.sleep(5000);
			if(isElementDisplayed(lblPWDForm))
			{
				String strPWDVerify=getText(lblPWDForm,"Login Verification");
				System.out.println(strPWDVerify);
				if(strPWDVerify.contains("Enter your password") || strPWDVerify.contains("Ketik kata sandi kamu") || strPWDVerify.contains("ใส่รหัสผ่านของคุณ"))
				{
					type(txtPWD, "123456", "Password");
					Thread.sleep(5000);
					click(btnPWDLogin, "Login");
					Thread.sleep(8000);
					
				}
			}
			click(hamburgerMenu,"Hamburger Menu");
			Thread.sleep(3000);
			if(isElementDisplayed(logoutLink))
			{
				blnStatus=true;
			}
			else
			{
				blnStatus=false;
			}
			click(closehamburgerMenu,"Close Hamburger Menu");
			Thread.sleep(3000);			
			
		}
		catch(Exception e){blnStatus=false;}
		return blnStatus;
	}
	public String fnGetLogedInUser() throws Throwable
	{
		fnLoadLocators();
		String strUser="";
		try
		{
			click(hamburgerMenu,"Hamburger Menu");
			Thread.sleep(3000);
			strUser=getText(btnLoginNxt, "LoggedIn ID");
			System.out.println(strUser);
			click(closehamburgerMenu,"Close Hamburger Menu");
		}
		catch(Exception e){}
		return strUser;
		
	}
	
	public boolean fnLoginToHOOQ(String struserID,String email,String mobileNo) throws Throwable
	{
		fnLoadLocators();
		boolean blnStatus=false;
		try
		{
			Thread.sleep(10000);
			JSClick(hamburgerMenu,"Hamburger Menu");
			Thread.sleep(3000);
			JSClick(loginBtn,"Click on Login");
			Thread.sleep(4000);
			String loginTitle=getText(loginTitleVerification, "Login page title");
			if(isElementDisplayed(loginTitleVerification))
			{
				Reporter.pass("Verify Login Page", " "+loginTitle+" displayed successfully"); 
			}
			else
			{
				Reporter.fail("Verify Login Page", ""+loginTitle+" is not displayed successfully");
			}
			Thread.sleep(5000);
			if(struserID.equalsIgnoreCase("email"))
			{
				blnStatus=fnLoginWithEmail(email);
				BasePage.strLastLogedUser=email;
			}				
			else if(struserID.equalsIgnoreCase("mobile"))
			{
				blnStatus=fnLoginWithMobileNo(mobileNo, struserID);
				BasePage.strLastLogedUser=mobileNo;
			}
		}
		catch(Exception e){}
		return blnStatus;
	}

}
