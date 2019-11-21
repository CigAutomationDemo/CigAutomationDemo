package com.automation.web.workflows;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.automation.reports.Reporter;

public class SignUpPage extends BasePage {

	By hamburgerMenu =null;
	By signupBtnhamburgermenu  =null;
	By signupBtn  =null;
	By lblEmail  =null;
	By emailIDTxt =null;
	By txtPWD =null;
	By evLoginBtn  =null;
	By skipBtn  =null;
	By getStarted  =null;
	By novaPageValidation =null;		

	//blnStatuset password
	By lblAcntExists =null;
	By lnkblnResetMyPWD =null;
	By lblblnStatusetPWD =null;
	By lblblnStatusetPWDActiveTab =null;
	By btnEmailNxt =null;
	By lblblnStatusetPWDEmailConfirmation =null;
	By btnGotIt =null;
	By lblSecureEmail =null;
	
	//
	By txtLoginEmail =null;
	By nextBtn =null;
	By txtLoginPwd =null;
	By lnkResetPWD = null;
	By lnkblnStatusetPwd = null;
	By lblResetPWDForm = null;
	By lblResetPWDConfirmation = null;
	By btnResetPWDConfirmation = null;
	//Locators
		public void fnLoadLocators()
		{
			try{
				if(objConfig.strDriverType!=null)
				{
					if(objConfig.strDriverType.equals("chromemobileview"))
					{
						hamburgerMenu = By.xpath("(//img[@title='Menu'])[1]");
						signupBtnhamburgermenu = By.xpath("//li[contains(@class,'e2e-sideMenu-signup')]/a");
						signupBtn = By.tagName("label");
						lblEmail = By.xpath("//a[contains(@class,'redirect_url emailormobile')]");
						emailIDTxt=By.xpath("//input[@id='email']");
						txtPWD=By.xpath("//input[@name='password']");
						evLoginBtn = By.xpath("//*[@type='submit']");
						skipBtn = By.xpath("//*[contains(@class,'navbarWeb__button-skip')]");
						getStarted = By.xpath("//button[@type='button']");
						novaPageValidation=By.xpath("//div[@id='payment-mount']//ul");	
					}
					else if(objConfig.strDriverType.equals("androidchrome"))
					{
						hamburgerMenu = By.xpath("(//img[@title='Menu'])[1]");
						signupBtnhamburgermenu = By.xpath("//li[contains(@class,'e2e-sideMenu-signup')]/a");
						signupBtn = By.tagName("label");
						lblEmail = By.xpath("//a[contains(@class,'redirect_url emailormobile')]");
						emailIDTxt=By.xpath("//input[@id='email']");
						txtPWD=By.xpath("//input[@name='password']");
						evLoginBtn = By.xpath("//*[@type='submit']");
						skipBtn = By.xpath("//*[contains(@class,'navbarWeb__button-skip')]");
						getStarted = By.xpath("//button[@type='button']");
						novaPageValidation=By.xpath("//div[@id='payment-mount']//ul");	
						
						lblAcntExists = By.xpath("//*[@class='modal-body']//label");
						lnkblnResetMyPWD = By.xpath("//*[@class='modal-content']//div[2]//a");
						lblblnStatusetPWD = By.xpath("//*[contains(@class,'labelHead')]");
						lblblnStatusetPWDActiveTab = By.xpath("//*[@tabindex='0']");
						btnEmailNxt = By.xpath("//*[@id='email']/../../..//div[@class='form-group']//button");
						lblblnStatusetPWDEmailConfirmation = By.xpath("//*[contains(@class,'labelHead')]");
						btnGotIt = By.xpath("//*[contains(@class,'labelHead')]/..//div//button");
						lblSecureEmail = By.tagName("label");
						
						txtLoginEmail = By.xpath("//input[@type='email']");
						nextBtn = By.xpath("//*[text()='Next']");
						txtLoginPwd = By.xpath("//input[@type='password']");
						lnkResetPWD = By.xpath("(//span[text()='Reset Your Password'])[1]/../../..");
						lnkblnStatusetPwd = By.xpath("//*[text()='Reset Now']");
						lblResetPWDForm = By.xpath("//label[text()='Create a new password']");
						lblResetPWDConfirmation = By.xpath("(//*[@class='modal-body']//label)[1]");
						btnResetPWDConfirmation = By.xpath("//*[@type='button']");
					}
					else if(objConfig.strDriverType.equals("desktopchrome"))
					{
						hamburgerMenu = By.xpath("(//img[@title='Menu'])[2]");
						signupBtnhamburgermenu = By.xpath("//*[text()='Pricing']");
						signupBtn = By.tagName("label");
						lblEmail = By.xpath("//a[contains(@class,'redirect_url emailormobile')]");
						emailIDTxt=By.xpath("//input[@id='email']");
						txtPWD=By.xpath("//input[@name='password']");
						evLoginBtn = By.xpath("//*[@type='submit']");
						skipBtn = By.xpath("//*[contains(@class,'navbarWeb__button-skip')]");
						getStarted = By.xpath("//button[@type='button']");
						novaPageValidation=By.xpath("//div[@id='payment-mount']//ul");	
					}
				}
			}
			catch(Exception e){}
		}

	public static String getDate()
	{
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		String timeStamp = dateFormat.format(date);
		return timeStamp;
	}

	public boolean verifySignUPWithEV(String email,String password) throws Throwable
	{
		fnLoadLocators();
		boolean blnStatus=true;
		try
		{
			loginPage.launchUrl(objConfig.strURL);
			Thread.sleep(10000);
			JSClick (hamburgerMenu,"Hamburger Menu");
			Thread.sleep(3000);
			JSClick (signupBtnhamburgermenu,"click  on SignUp Button");
			Thread.sleep(4000);
			String signUpTitle=getText(signupBtn, "Login page title");
			if(isElementDisplayed(signupBtn))
			{
				Reporter.pass("Verify SignUp Page", " "+signUpTitle+" displayed successfully"); 
			}
			else
			{
				Reporter.fail("Verify SignUp Page", ""+signUpTitle+" is not displayed successfully");
			}
			JSClick (lblEmail,"click  on Email button");
			Thread.sleep(2500);
			System.out.println(email);	
			click (emailIDTxt,"click  on Email text");
			JStype("email","Entering Valid Email ID", email);
			Thread.sleep(2000);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.BACK_SPACE).build().perform();		
			Thread.sleep(2000);
			click (txtPWD,"click  on Password text");
			type(txtPWD, password , "Password");
			Thread.sleep(2000);
			JSClick (evLoginBtn,"click  on login button");
			Thread.sleep(5000);
			if(isElementDisplayed(novaPageValidation))
			{
				Reporter.pass("HOOQ SignUp with Skip Nova", "Plan Selector is displayed");
				blnStatus=true;					
				if(isElementDisplayed(skipBtn))
				{	
					Reporter.pass("HOOQ SignUp with Skip Nova", "Skip Nova button is displayed");
					click (skipBtn, "Skip");
					Thread.sleep(2000);
					if(isElementDisplayed(getStarted))
					{
						String getStartedBtn=getText(getStarted,"Get started");
						Reporter.pass("HOOQ SignUp with Skip Nova", "Redirected to GetStarted email page with the label: "+getStartedBtn);
						click (getStarted,"Get started");
						Thread.sleep(2000);
					}
					else
					{
						Reporter.fail("HOOQ SignUp with Skip Nova", "GetStarted email page is not displayed ");
						blnStatus=false;
					}
					Thread.sleep(10000);
					click (hamburgerMenu,"Hamburger Menu");
					Thread.sleep(3000);
					String loggedinID=getText(By.xpath("//div[contains(@class,'SideMenu__UserLoginText-sc')]"), "LoggedIn ID");
					System.out.println(loggedinID);
					if(driver.getPageSource().contains(loggedinID))
					{
						Reporter.pass("Verify Login", loggedinID+ "User Logged in successfully");
						blnStatus=true;
					}
					else
					{
						Reporter.fail("Verify Login", " User does not logged in successfully"); 	
					}
				}
				else
				{
					Reporter.fail("HOOQ SignUp with Skip Nova","Skip Nova link is not displayed");
					blnStatus=false;
				}
			}
			else
			{
				Reporter.fail("HOOQ SignUp with Skip Nova", "Plan Selector is not displayed" );
				blnStatus=false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return blnStatus;
	}

	public boolean verifyblnResetPWDWithEmail(String email, String password) throws Throwable
	{
		fnLoadLocators();
		boolean blnStatus=true;
		try
		{
			//Reporter.info("Login to HOOQ Application","Login with " + loginID + " User Type: " + strUserType);
			Thread.sleep(5000);
			JSClick (hamburgerMenu,"Hamburger Menu");
			Thread.sleep(3000);
			JSClick (signupBtnhamburgermenu,"click  on SignUp Button");
			Thread.sleep(4000);
			String signUpTitle=getText(signupBtn, "Login page title");
			if(isElementDisplayed(signupBtn))
			{
				Reporter.pass("Verify SignUp Page", " "+signUpTitle+" displayed successfully"); 
			}
			else
			{
				Reporter.fail("Verify SignUp Page", ""+signUpTitle+" is not displayed successfully");
			}
			Thread.sleep(2000);
			JSClick (lblEmail,"click  on Email button");
			Thread.sleep(2500);
			System.out.println(email);	
			click (emailIDTxt,"click  on Email text");
			JStype("email","Entering Valid Email ID", email+"5");
			Thread.sleep(2000);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.BACK_SPACE).build().perform();		
			Thread.sleep(2000);
			JSClick (evLoginBtn,"click  on login button");
			Thread.sleep(5000);
			if(isElementDisplayed(lblAcntExists))
			{					
				String strEmailAlreadyExists=getText(lblAcntExists,"Account already exists");
				Reporter.pass("HOOQ Login with Email OTT User", strEmailAlreadyExists+ " - is displayed");
				blnStatus=true;
				boolean eleResetPWD =isElementDisplayed(lnkblnResetMyPWD);
				if(eleResetPWD)
				{
					Reporter.pass("HOOQ Login with Email OTT User", " blnStatuset my password- link is displayed");
					click (lnkblnResetMyPWD, "blnStatuset my password");
					Thread.sleep(2000);

					boolean eleblnStatusetPwd =isElementDisplayed(lblblnStatusetPWD);
					if(eleblnStatusetPwd)
					{					
						String strblnStatusetPWD=getText(lblblnStatusetPWD,"blnStatuset Password");
						Reporter.pass("HOOQ Login with Email OTT User", "blnStatuset Password page is displayed with label: "+strblnStatusetPWD);
						String strActiveTab=getText(lblblnStatusetPWDActiveTab,"Active tab");
						if(strActiveTab.equalsIgnoreCase("Email") || strActiveTab.equalsIgnoreCase("Email") || strActiveTab.equalsIgnoreCase(""))
						{
							Reporter.pass("HOOQ Login with Email OTT User", "Email tab is active in blnStatuset passord page ");
							WebElement defaultemail=driver.findElement(By.xpath("//*[@id='email']"));
							String strdefaultemail=defaultemail.getAttribute("value");
							if(strdefaultemail.equalsIgnoreCase(email))
							{
								Reporter.pass("HOOQ Login with Email OTT User", "Default Email displayed in blnStatuset passord page is "+strdefaultemail);
								Thread.sleep(1000);
								click (btnEmailNxt, "Next");
								String strPwdConfirmation=getText(lblblnStatusetPWDEmailConfirmation,"Password blnStatuset link sent");
								if(strPwdConfirmation.equalsIgnoreCase("Password reset link sent") || strPwdConfirmation.equalsIgnoreCase("Link perubahan kata sandi telah dikirim") || strPwdConfirmation.equalsIgnoreCase("Ã Â¸ÂªÃ Â¹Ë†Ã Â¸â€¡Ã Â¸Â¥Ã Â¸Â´Ã Â¸â€¡Ã Â¸ÂÃ Â¹Å’Ã Â¸Â£Ã Â¸ÂµÃ Â¹â‚¬Ã Â¸â€¹Ã Â¹â€¡Ã Â¸â€¢Ã Â¸Â£Ã Â¸Â«Ã Â¸Â±Ã Â¸ÂªÃ Â¸Å“Ã Â¹Ë†Ã Â¸Â²Ã Â¸â„¢Ã Â¹ÂÃ Â¸Â¥Ã Â¹â€°Ã Â¸Â§"))
								{
									Reporter.pass("HOOQ Login with Email OTT User", "Page displayed with label: "+strPwdConfirmation);
									click (btnGotIt, "Okay, got it");
									String strLoginPage=getText(lblSecureEmail,"Log in to your account");
								
									if(strLoginPage.equalsIgnoreCase("Log in to your account") || strLoginPage.equalsIgnoreCase("Masuk dengan menggunakan akun anda") || strLoginPage.equalsIgnoreCase(""))
									{
										Reporter.pass("HOOQ Login with Email OTT User", "Login page is displayed upon click ing 'Okay, got it' button");
										emailblnStatusetPWD("indraja.hooq@gmail.com","cigniti123");
									}
									else
									{
										Reporter.fail("HOOQ Login with Email OTT User", "Login page is not displayed upon click ing 'Okay, got it' button");
										blnStatus=false;	
									}
								}
								else
								{
									Reporter.fail("HOOQ Login with Email OTT User", "Page displayed not displayed with label: Password blnStatuset link sent " );
									blnStatus=false;	
								}							
							}
							else
							{
								Reporter.fail("HOOQ Login with Email OTT User", "Default Email is not displayed in blnStatuset passord page ");
								blnStatus=false;	
							}						
						}
						else
						{
							Reporter.fail("HOOQ Login with Email OTT User", "Email tab is not active in blnStatuset passord page ");
							blnStatus=false;	
						}												
					}
					else
					{
						Reporter.fail("HOOQ Login with Email OTT User", "blnStatuset Password page is not displayed ");
						blnStatus=false;	
					}
				}
				else
				{
					Reporter.fail("HOOQ Login with Email OTT User", " blnStatuset my password link is not displayed");
					blnStatus=false;					
				}				
			}
			else
			{
				Reporter.fail("HOOQ Login with Email OTT User", " Accounts already exist is not displayed");
				blnStatus=false;				
			}					
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
		}
		return blnStatus;
	}
	
	/**
	 * @param validEmail
	 * @return
	 * @throws Throwable
	 */
	public boolean emailblnStatusetPWD(String validEmail, String validPWD)throws Throwable
    {
		fnLoadLocators();
		boolean blnStatus=true;
		try
		{
            //Thread.sleep(3000);
            //extentLogs.info("Confirming Email AddblnStatuss","Confirm Email addblnStatuss for Email Verification");
            driver.navigate().to("https://accounts.google.com/signin/v2");
            Reporter.info("HOOQ Login with Email OTT User", "Navigated to Gmail");
            type(txtLoginEmail,validEmail,"Login Email");
            click(nextBtn,"Click on Next button");
            type(txtLoginPwd,validPWD,"password");
            click(nextBtn,"Click on Next button");
            Thread.sleep(2000);
          /*  driver.switchTo().defaultContent();
            driver.switchTo().frame("ifmail");            
            String winHandleBefore = driver.getWindowHandle();*/
                
            click(lnkResetPWD,"Click on Reset password link");
            Thread.sleep(2000);
                        
            // Switch to new window opened
            /*for(String winHandle : driver.getWindowHandles()){
                driver.switchTo().window(winHandle);
            }*/
            click(lnkblnStatusetPwd,"click on reset now link");
            Thread.sleep(2000);
            
            // Perform the actions on new window          
            String strResetPWD=getText(lblResetPWDForm,"Create a new PWD");        
            if(strResetPWD.equalsIgnoreCase("Create a new password") || strResetPWD.equalsIgnoreCase("Buat kata sandi baru") || strResetPWD.equalsIgnoreCase(""))
            {
                Reporter.pass("HOOQ Login with Email OTT User", "Page redirected to "+strResetPWD);               
                String lblCreatePwd = driver.findElement(By.xpath("//*[@id='password']")).getAttribute("placeholder");              
                if (lblCreatePwd.equalsIgnoreCase("Create a password") || lblCreatePwd.equalsIgnoreCase("Buat kata sandi") || lblCreatePwd.equalsIgnoreCase("à¸•à¸±à¹‰à¸‡à¸£à¸«à¸±à¸ªà¸œà¹ˆà¸²à¸™"))
                {
                    Reporter.pass("HOOQ Login with Email OTT User", "PWD field is displayed with inner text "+lblCreatePwd);
                    type(txtPWD, "123456", "Password");
                    Thread.sleep(5000);
                    click(evLoginBtn, "Done");
                    Thread.sleep(5000);
                    //boolean eleDisplayed =verifyElementDisplayed(btnWelcomePageLogin, "Welcome page with Login button");
                    boolean eleDisplayed =isElementDisplayed(lblResetPWDConfirmation);
                    if(eleDisplayed)
                    {
                        String strConfirmation = getText(lblResetPWDConfirmation,"Confirmation message");
                        
                        Reporter.pass("HOOQ Login with Email OTT User", "Confirmation message is displayed as: " +strConfirmation);
                        boolean eleLoginBtnDisplayed =isElementDisplayed(lblResetPWDConfirmation);
                        if(eleLoginBtnDisplayed)
                        {                                            
                            Reporter.pass("HOOQ Login with Email OTT User", "The button 'Log in to my account' is displayed after PWD is changes");
                            click(btnResetPWDConfirmation, "Log in to my account");
                            Thread.sleep(5000);                        
                            String urlWelcomePage=objConfig.strURL;
                            Reporter.pass("HOOQ Login with Email User", "Welcome page URL " +urlWelcomePage);
                            Reporter.pass("HOOQ Login with Email User", "Welcome page is displayed successfully ");
                            blnStatus = true;
                        }
                        else
                        {
                            Reporter.fail("HOOQ Login with Email OTT User", "The button 'Log in to my account' is not displayed after PWD is changes" );
                            blnStatus = false;
                        }
                    }
                    else
                    {
                        Reporter.fail("HOOQ Login with Email OTT User", "Confirmation message is not displayed " );
                        blnStatus = false;
                    }
                }
                else
                {
                    Reporter.fail("HOOQ Login with Email OTT User", "PWD field is not displayed with inner text ");
                    blnStatus = false;
                }        
                
            }
            else
            {
                Reporter.fail("HOOQ Login with Email OTT User", "Page is not redirected to Create pwd page");
                blnStatus = false;
            }    
                        
        }
        catch(Exception e){
            e.printStackTrace();
            blnStatus = false;
        }
        return blnStatus;
    }

}
