package com.automation.web.workflows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.automation.reports.Reporter;

public class HamburgerPage extends BasePage {

	By appVersion = null;
	By hamburgerMenu = null;
	By hamburgerListMenu = null;
	By signupBtn = null;	
	By loginTitleVerification = null;
	By hooqLogo= null;
	By channelPlayer = null;
	By playerwindow = null;
	By myRentals = null;
	By Accounts_Settings = null;
	By linkTV = null;
	By closehamburgerMenu = null;
	By BackArrow= null;
	By novaPageValidation= null;
	By hooqlogoNew= null;	

	//Locators
	public void fnLoadLocators()
	{
		try{
			if(objConfig.strDriverType!=null)
			{
				if(objConfig.strDriverType.equals("chromemobileview"))
				{
					appVersion = By.xpath("(//div[contains(@class,'AppStatus__Container-sc')]/p)[1]");
					hamburgerMenu = By.xpath("(//img[@title='Menu'])[1]");
					hamburgerListMenu = By.xpath("//ul[contains(@class, 'SideMenu__NavMenuList')]/li/a");
					signupBtn = By.tagName("label");	
					loginTitleVerification = By.tagName("label");
					hooqLogo=By.xpath("(//a[contains(@class,'HOOQLogo__Wrapper-sc')])[1]");
					channelPlayer = By.xpath("//*[@id='live-tv-player']");
					playerwindow = By.xpath("//*[contains(@class,'VideoComponent__VideoWrapper-adotv8-0')]");
					myRentals = By.xpath("(//a[contains(@class,'e2e-iconButton IconButton__WrappedLink')]/span)[1]");
					Accounts_Settings = By.xpath("//a[contains(@class,'SettingsWindow__SettingLink')]");
					linkTV = By.xpath("//h1[contains(@class,'LinkTvContent__LinkHeader')]");
					closehamburgerMenu = By.xpath("//img[@title='Close']");
					BackArrow=By.xpath("(//div[contains(@class,'HeaderBackButton__BackButton')]/a/img)[1]");
					novaPageValidation=By.xpath("//div[@id='payment-mount']//ul");
					hooqlogoNew=By.xpath("//*[@id='payment-mount']/section/div/a");	
				}
				else if(objConfig.strDriverType.equals("androidchrome"))
				{
					appVersion = By.xpath("(//div[contains(@class,'AppStatus__Container-sc')]/p)[1]");
					hamburgerMenu = By.xpath("//*[@id='mount']/header[1]/div/a[2]/img");
					hamburgerListMenu = By.xpath("//ul[contains(@class, 'SideMenu__NavMenuList')]/li/a");
					signupBtn = By.tagName("label");	
					loginTitleVerification = By.tagName("label");
					hooqLogo=By.xpath("(//a[contains(@class,'HOOQLogo__Wrapper')])[1]");
					channelPlayer = By.xpath("//*[@id='live-tv-player']");
					playerwindow = By.xpath("//*[contains(@class,'VideoComponent__VideoWrapper-adotv8-0')]");
					myRentals = By.xpath("(//a[contains(@class,'e2e-iconButton IconButton__WrappedLink')]/span)[1]");
					Accounts_Settings = By.xpath("//a[contains(@class,'SettingsWindow__SettingLink')]");
					linkTV = By.xpath("//h1[contains(@class,'LinkTvContent__LinkHeader')]");
					closehamburgerMenu = By.xpath("//img[@title='Close']");
					BackArrow=By.xpath("(//div[contains(@class,'HeaderBackButton__BackButton')]/a/img)[1]");
					novaPageValidation=By.xpath("//div[@id='payment-mount']//ul");
					hooqlogoNew=By.xpath("//*[@id='payment-mount']/section/div/a");	
				}
				else if(objConfig.strDriverType.equals("desktopchrome"))
				{
					appVersion = By.xpath("(//div[contains(@class,'AppStatus__Container-sc')]/p)[1]");
					hamburgerMenu = By.xpath("(//img[@title='Menu'])[2]");
					hamburgerListMenu = By.xpath("//*[contains(@class, 'NavPopupMenu__Nav')]//a");
					signupBtn = By.tagName("label");	
					loginTitleVerification = By.tagName("label");
					hooqLogo=By.xpath("(//a[contains(@class,'HOOQLogo__Wrapper')])[1]");
					channelPlayer = By.xpath("//*[@id='live-tv-player']");
					playerwindow = By.xpath("//*[contains(@class,'VideoComponent__VideoWrapper-adotv8-0')]");
					myRentals = By.xpath("(//a[contains(@class,'e2e-iconButton IconButton__WrappedLink')]/span)[1]");
					Accounts_Settings = By.xpath("//a[contains(@class,'SettingsWindow__SettingLink')]");
					linkTV = By.xpath("//h1[contains(@class,'LinkTvContent__LinkHeader')]");
					closehamburgerMenu = By.xpath("//img[@title='Close']");
					BackArrow=By.xpath("(//div[contains(@class,'HeaderBackButton__BackButton')]/a/img)[1]");
					novaPageValidation=By.xpath("//div[@id='payment-mount']//ul");
					hooqlogoNew=By.xpath("//*[@id='payment-mount']/section/div/a");	
				}
			}
		}
		catch(Exception e){}
	}



	public boolean verifyHamburgerMenu(String userType) throws Throwable
	{
		fnLoadLocators();
		boolean blnStatus=true;
		try
		{
			Thread.sleep(10000);
			String strBuildNo=getText(appVersion, "Get App Version");
			Reporter.pass("Verify Application version", "Redirected to '"+strBuildNo + "' and is displayed successfully"); 
			Thread.sleep(2000);
			click(hamburgerMenu, "HamburgerMenu");
			if(objConfig.strDriverType.equals("chromemobileview")||(objConfig.strDriverType.equals("androidchrome")))
			{
				if(userType.equalsIgnoreCase("Visitor"))
				{
					List<WebElement> lstHamburgerMenu=driver.findElements(hamburgerListMenu);
					for(int i=0; i<lstHamburgerMenu.size(); i++)
					{
						String lstText = null;
						String lstText1 = null;
						if(objConfig.strDriverType.equals("chromemobileview"))
						{
							Thread.sleep(2000);
							WebElement menuItem = driver.findElement(By.xpath("(//*[contains(@class, 'SideMenu__Nav')])[4]//li["+(i+1)+"]//a[1]"));
							lstText=menuItem.getText();
							lstText1=driver.findElement(By.xpath("(//*[contains(@class, 'SideMenu__Nav')])[4]//li["+(i+1)+"]//a[1]")).getText();
							WebElement element = driver.findElement(By.xpath("(//*[contains(@class, 'SideMenu__Nav')])[4]//li["+(i+1)+"]//a[1]"));
							JavascriptExecutor executor = (JavascriptExecutor) driver;
							executor.executeScript("arguments[0].click();", element);
						}
						else if(objConfig.strDriverType.equals("androidchrome"))
						{
							Thread.sleep(2000);
							WebElement menuItem = driver.findElement(By.xpath("//ul[contains(@class, 'SideMenu__NavMenuList')]/li/a["+(i+1)+"]"));
							lstText=menuItem.getText();
							lstText1=driver.findElement(By.xpath("//ul[contains(@class, 'SideMenu__NavMenuList')]/li/a["+(i+1)+"]")).getText();
							WebElement element = driver.findElement(By.xpath("//ul[contains(@class, 'SideMenu__NavMenuList')]/li/a["+(i+1)+"]"));
							JavascriptExecutor executor = (JavascriptExecutor) driver;
							executor.executeScript("arguments[0].click();", element);

						}

						Thread.sleep(10000);
						String menuTabHighlightedtxt= null;
						if(lstText.equalsIgnoreCase("Discover") ||lstText.equalsIgnoreCase("หนัา�?ร�?")|| lstText.equalsIgnoreCase("Telusuri")|| lstText.equalsIgnoreCase("Movies")|| lstText.equalsIgnoreCase("ภาพยนตร์")|| lstText.equalsIgnoreCase("Film") || lstText.equalsIgnoreCase("TV Shows")||lstText.equalsIgnoreCase("ทีวีซีรีส์")|| lstText.equalsIgnoreCase("Serial TV") || lstText.equalsIgnoreCase("Premium+")|| lstText.equalsIgnoreCase("ระดับพรีเมียมขึ้นไป")|| lstText.equalsIgnoreCase("Premium+"))
						{
							menuTabHighlightedtxt = getText(By.xpath("(//div[text()='"+lstText+"'])[1]"), "");
							if(menuTabHighlightedtxt.equalsIgnoreCase(lstText))
							{
								Reporter.pass("Verify Hamburger Menu", "Redirected to '"+menuTabHighlightedtxt + "' and is highlighted successfully"); 
							}
							else
							{
								Reporter.fail("Verify Hamburger Menu", " '"+menuTabHighlightedtxt + "'  is not highlighted successfully"); 
							}
						}
						else if(lstText.equalsIgnoreCase("Channels"))
						{
							Thread.sleep(2000);
							if(isElementDisplayed(channelPlayer))
							{
								Reporter.pass("Verify live tv player", "Visitor user asking for Login/Sign up to play channels");	
								driver.navigate().back();						
							}
							else 
							{
								Reporter.fail("Verify live tv player", "Login/Sign up button are not displayed for channels tab");
								driver.navigate().back();
							}
						}
						else if(lstText.equalsIgnoreCase("PRICING")|| lstText.equalsIgnoreCase("ราคา")|| lstText.equalsIgnoreCase("Daftar harga") )
						{
							String signupPage=getText(By.tagName("label"), "Sign UP Page");
							if(isElementDisplayed(signupBtn))
							{
								Reporter.pass("Verify Hamburger Menu of pricing is : ", "Redirected to '"+signupPage + "' and is displayed successfully");
							}
							else
							{
								Reporter.fail("Verify Hamburger Menu pricing is : ", "Redirected to '"+signupPage + "' and is not displayed successfully");

							}
							driver.navigate().back();
							Thread.sleep(20000);
						}

						//Note: Need to add "Download" option for both android and IOS
						else if(lstText.equalsIgnoreCase("Download the free App")|| lstText.equalsIgnoreCase("ดาวน์โหลด�?อปพลิเคชันฟรี")|| lstText.equalsIgnoreCase("Download Aplikasi gratis"))
						{
							Reporter.pass("Verify Hamburger Menu for Download app : ", "For web no option for download app");
							driver.navigate().back();
							Thread.sleep(20000);
						}
						else if(lstText.equalsIgnoreCase("Log in")|| lstText.equalsIgnoreCase("เข้าสู่ระบบ")|| lstText.equalsIgnoreCase("Masuk") ||lstText.equalsIgnoreCase("Sign up")|| lstText.equalsIgnoreCase("ลงทะเบียน")|| lstText.equalsIgnoreCase("Daftar"))
						{
							if(lstText.equalsIgnoreCase("Log in")|| lstText.equalsIgnoreCase("เข้าสู่ระบบ")|| lstText.equalsIgnoreCase("Masuk") )
							{
								Thread.sleep(2000);
								String loginpage=getText(loginTitleVerification, "Login Page");
								if(isElementDisplayed(loginTitleVerification))
								{
									Reporter.pass("Verify Hamburger Menu", "Redirected to '"+loginpage + "' and is displayed successfully");
								}
								else
								{
									Reporter.fail("Verify Hamburger Menu", "Redirected to '"+loginpage + "' and is not displayed successfully");

								}
							}
							else if(lstText.equalsIgnoreCase("Sign up")|| lstText.equalsIgnoreCase("ลงทะเบียน")|| lstText.equalsIgnoreCase("Daftar"))
							{
								String signupPage=getText(signupBtn, "Sign UP Page");
								if(isElementDisplayed(signupBtn))
								{
									Reporter.pass("Verify Hamburger Menu", "Redirected to '"+signupPage + "' and is displayed successfully");
								}
								else
								{
									Reporter.fail("Verify Hamburger Menu", "Redirected to '"+signupPage + "' and is not displayed successfully");

								}
							}
							driver.navigate().back();
							Thread.sleep(20000);
							blnStatus = true;
						}
						click(hooqLogo, "HamburgerMenu");
						Thread.sleep(2000);
						JSClick(hamburgerMenu, "HamburgerMenu");
						Thread.sleep(10000);
						blnStatus= true;
					}
				}
				else if(userType.equalsIgnoreCase("Active"))
				{
					List<WebElement> lstHamburgerMenu=driver.findElements(hamburgerListMenu);
					for(int i=0; i<lstHamburgerMenu.size(); i++)
					{
						Thread.sleep(2000);
						WebElement menuItem = driver.findElement(By.xpath("(//*[contains(@class, 'SideMenu__Nav')])[4]//li["+(i+1)+"]//a[1]"));
						String lstText=menuItem.getText();
						String lstText1=driver.findElement(By.xpath("(//*[contains(@class, 'SideMenu__Nav')])[4]//li["+(i+1)+"]//a[1]")).getText();

						//driver.findElement(By.xpath("(//*[contains(@class, 'SideMenu__NavItem')]/a)["+(i+1)+"]")).click();
						//menuItem.click();
						WebElement element = driver.findElement(By.xpath("(//*[contains(@class, 'SideMenu__Nav')])[4]//li["+(i+1)+"]//a[1]"));
						JavascriptExecutor executor = (JavascriptExecutor) driver;
						executor.executeScript("arguments[0].click();", element);

						Thread.sleep(10000);
						String menuTabHighlightedtxt= null;
						if(lstText.equalsIgnoreCase("Discover") ||lstText.equalsIgnoreCase("หน้าแรก")|| lstText.equalsIgnoreCase("Telusuri")|| lstText.equalsIgnoreCase("Movies")|| lstText.equalsIgnoreCase("ภาพยนตร์")|| lstText.equalsIgnoreCase("Film") || lstText.equalsIgnoreCase("TV Shows")||lstText.equalsIgnoreCase("ทีวีซีรีส์")|| lstText.equalsIgnoreCase("Serial TV") || lstText.equalsIgnoreCase("Rent")|| lstText.equalsIgnoreCase("เช่าหนัง")|| lstText.equalsIgnoreCase("Rent"))
						{
							//menuTabHighlightedtxt = getText(By.xpath("(//a[contains(@class,'e2e-tab header-tab e2e-tab-"+lstText+" HeaderTab__HeaderTabButton-sc-7t0a3i-0 active')]/div)[1]"), "");
							//menuTabHighlightedtxt = getText(highlightedElement(lstText),"Highlighted tab is displayed");
							menuTabHighlightedtxt = getText(By.xpath("(//div[text()='"+lstText+"'])[1]"), "");

							if(menuTabHighlightedtxt.equalsIgnoreCase(lstText))
							{
								Reporter.pass("Verify Hamburger Menu", "Redirected to '"+menuTabHighlightedtxt + "' and is highlighted successfully"); 
							}
							else
							{
								Reporter.fail("Verify Hamburger Menu", " '"+menuTabHighlightedtxt + "'  is not highlighted successfully"); 
							}
							//Reporter.pass("Verify Hamburger Menu", "Redirected to '"+menuTabHighlightedtxt + "' and is highlighted successfully"); 
						}
						else if(lstText.equalsIgnoreCase("Channels")||lstText.equalsIgnoreCase("ช่อง"))
						{
							Thread.sleep(2000);
							if(isElementDisplayed(channelPlayer))
							{
								Reporter.pass("Verify live tv player", "Able to play the LIVE TV");	
								if(isElementDisplayed(By.xpath("(//*[contains(@class,'ChannelButton__ChannelButtonImages')]//img[2])[1]")));
								{
									String liveTv = getText(By.xpath("(//*[contains(@class,'ChannelButton__ChannelButtonImages')]//img[2])[1]"), "Get text for live tv");
									Reporter.pass("Verify live tv player", "First LIVE tv channel "+liveTv+" is playing");
									driver.navigate().back();
								}
							}
							else 
							{
								Reporter.fail("Verify live tv player", "First LIVE tv channel is not playing");
								driver.navigate().back();
							}
						}
						else if(lstText.equalsIgnoreCase("PRICING")|| lstText.equalsIgnoreCase("ราคา")|| lstText.equalsIgnoreCase("Daftar harga"))
						{

							String signupPage=getText(signupBtn, "Sign UP Page");
							if(isElementDisplayed(signupBtn))
							{
								Reporter.pass("Verify Hamburger Menu of pricing is : ", "Redirected to '"+signupPage + "' and is displayed successfully");
							}
							else
							{
								Reporter.fail("Verify Hamburger Menu pricing is : ", "Redirected to '"+signupPage + "' and is not displayed successfully");

							}
							driver.navigate().back();
							Thread.sleep(20000);
						}
						//Note: Need to add "Download" option for both android and IOS
						else if(lstText.equalsIgnoreCase("Download the free App")|| lstText.equalsIgnoreCase("ดาวน์โหลดแอปพลิเคชันฟรี")|| lstText.equalsIgnoreCase("Download Aplikasi gratis"))
						{

							Reporter.pass("Verify Hamburger Menu for Download app : ", "For web no option for download app");
							driver.navigate().back();
							Thread.sleep(20000);
						}
						else if(lstText.equalsIgnoreCase("My Rentals")|| lstText.equalsIgnoreCase("หนังเช่าของฉัน")|| lstText.equalsIgnoreCase("Sewaan Saya"))
						{
							String myRentalTxt = getText(myRentals,"MyRentals"); //*[contains(@class,'PageContent__Content')]/div/h1
							Reporter.pass("Verify Hamburger Menu for My Rental : ", " "+myRentalTxt+" page should have Purchased content");
							JSClick(BackArrow, "Back Arrow");
							//driver.navigate().back();
							Thread.sleep(20000);
						}
						else if(lstText.equalsIgnoreCase("Account & Settings")|| lstText.equalsIgnoreCase("บัญชีผู้ใช้และการตั้งค่า")|| lstText.equalsIgnoreCase("Akun & Pengaturan"))
						{
							String Account_settings = getText(Accounts_Settings,"Accounts&Settings");
							Reporter.pass("Verify Hamburger Menu for Account & settings : ", " "+Account_settings+" is dispalyed");
							JSClick(BackArrow, "Back Arrow");
							//driver.navigate().back();
							Thread.sleep(20000);
						}
						else if(lstText.equalsIgnoreCase("Link TV")|| lstText.equalsIgnoreCase("เชื่อมต่อทีวี") ||lstText.equalsIgnoreCase("Hubungkan TV"))
						{
							String linkTVTxt = getText(linkTV,"Link Tv");
							if(linkTVTxt.equalsIgnoreCase(lstText))
							{
								Reporter.pass("Verify Hamburger Menu", "Redirected to '"+menuTabHighlightedtxt + "' and is highlighted successfully"); 
							}
							else
							{
								Reporter.fail("Verify Hamburger Menu", " '"+menuTabHighlightedtxt + "'  is not highlighted successfully"); 
							}	
							Thread.sleep(2000);
							JSClick(BackArrow, "Back Arrow");
						}

						else if(lstText.equalsIgnoreCase("Log out")|| lstText.equalsIgnoreCase("ออกจากระบบ") ||lstText.equalsIgnoreCase("Keluar"))
						{
							Thread.sleep(2000);
							Reporter.pass("Verify Hamburger Menu", "Redirected to Logout and is displayed successfully");			
							//driver.navigate().back();
							Thread.sleep(20000);
						}		
						else if(lstText.equalsIgnoreCase("Log in")|| lstText.equalsIgnoreCase("เข้าสู่ระบบ")|| lstText.equalsIgnoreCase("Masuk") ||lstText.equalsIgnoreCase("Sign up")|| lstText.equalsIgnoreCase("ลงทะเบียน")|| lstText.equalsIgnoreCase("Daftar"))
						{
							if(lstText.equalsIgnoreCase("Log in")|| lstText.equalsIgnoreCase("เข้าสู่ระบบ")|| lstText.equalsIgnoreCase("Masuk") )
							{
								Thread.sleep(2000);
								String loginpage=getText(loginTitleVerification, "Login Page");
								if(isElementDisplayed(loginTitleVerification))
								{
									Reporter.pass("Verify Hamburger Menu", "Redirected to '"+loginpage + "' and is displayed successfully");
								}
								else
								{
									Reporter.fail("Verify Hamburger Menu", "Redirected to '"+loginpage + "' and is not displayed successfully");

								}
							}
							else if(lstText.equalsIgnoreCase("Sign up")|| lstText.equalsIgnoreCase("ลงทะเบียน")|| lstText.equalsIgnoreCase("Daftar"))
							{
								String signupPage=getText(signupBtn, "Sign UP Page");
								if(isElementDisplayed(signupBtn))
								{
									Reporter.pass("Verify Hamburger Menu", "Redirected to '"+signupPage + "' and is displayed successfully");
								}
								else
								{
									Reporter.fail("Verify Hamburger Menu", "Redirected to '"+signupPage + "' and is not displayed successfully");

								}
							}
							driver.navigate().back();
							Thread.sleep(20000);
							blnStatus = true;
						}
						Thread.sleep(2000);
						JSClick(hamburgerMenu, "HamburgerMenu");
						Thread.sleep(10000);
						blnStatus= true;

					}
				}
				else if(userType.equalsIgnoreCase("Lapsed"))
				{
					List<WebElement> lstHamburgerMenu=driver.findElements(hamburgerListMenu);
					for(int i=0; i<lstHamburgerMenu.size(); i++)
					{
						Thread.sleep(2000);
						WebElement menuItem = driver.findElement(By.xpath(""+(i+1)+"]"));
						String lstText=menuItem.getText();
						String lstText1=driver.findElement(By.xpath("(//*[contains(@class, 'SideMenu__Nav')])[4]//li["+(i+1)+"]//a[1]")).getText();

						//driver.findElement(By.xpath("(//*[contains(@class, 'SideMenu__NavItem')]/a)["+(i+1)+"]")).click();
						//menuItem.click();
						WebElement element = driver.findElement(By.xpath("(//*[contains(@class, 'SideMenu__Nav')])[4]//li["+(i+1)+"]//a[1]"));
						JavascriptExecutor executor = (JavascriptExecutor) driver;
						executor.executeScript("arguments[0].click();", element);

						Thread.sleep(10000);
						String menuTabHighlightedtxt= null;
						if(lstText.equalsIgnoreCase("Discover") ||lstText.equalsIgnoreCase("หนัา�?ร�?")|| lstText.equalsIgnoreCase("Telusuri")|| lstText.equalsIgnoreCase("Movies")|| lstText.equalsIgnoreCase("ภาพยนตร์")|| lstText.equalsIgnoreCase("Film") || lstText.equalsIgnoreCase("TV Shows")||lstText.equalsIgnoreCase("ทีวีซีรีส์")|| lstText.equalsIgnoreCase("Serial TV") || lstText.equalsIgnoreCase("Premium+")|| lstText.equalsIgnoreCase("ระดับพรีเมียมขึ้นไป")|| lstText.equalsIgnoreCase("Premium+"))
						{
							//menuTabHighlightedtxt = getText(By.xpath("(//a[contains(@class,'e2e-tab header-tab e2e-tab-"+lstText+" HeaderTab__HeaderTabButton-sc-7t0a3i-0 active')]/div)[1]"), "");
							//menuTabHighlightedtxt = getText(highlightedElement(lstText),"Highlighted tab is displayed");
							menuTabHighlightedtxt = getText(By.xpath("(//div[text()='"+lstText+"'])[1]"), "");

							if(menuTabHighlightedtxt.equalsIgnoreCase(lstText))
							{
								Reporter.pass("Verify Hamburger Menu", "Redirected to '"+menuTabHighlightedtxt + "' and is highlighted successfully"); 
							}
							else
							{
								Reporter.fail("Verify Hamburger Menu", " '"+menuTabHighlightedtxt + "'  is not highlighted successfully"); 
							}
							//Reporter.pass("Verify Hamburger Menu", "Redirected to '"+menuTabHighlightedtxt + "' and is highlighted successfully"); 
						}
						else if(lstText.equalsIgnoreCase("Channels"))
						{
							Thread.sleep(2000);
							if(isElementDisplayed(playerwindow))
							{
								Reporter.pass("Verify live tv player", "Able to play the LIVE TV");	
								if(isElementDisplayed(By.xpath("(//div[contains(@class,'ChannelButton__ImageContainer')]//img)[1]")));
								{
									Reporter.pass("Verify live tv player", "First LIVE tv channel is playing");
									driver.navigate().back();
								}
							}
							else 
							{
								Reporter.fail("Verify live tv player", "First LIVE tv channel is not playing");
								driver.navigate().back();
							}
						}
						else if(lstText.equalsIgnoreCase("PRICING")|| lstText.equalsIgnoreCase("ราคา")|| lstText.equalsIgnoreCase("Daftar harga") )
						{
							if(isElementDisplayed(novaPageValidation))
							{
								Thread.sleep(2000);
								Reporter.pass("Verify movie player for Lapsed user", "Nova planselector page is displayed successfully while playing the Movie");	
								JSClick(hooqlogoNew,"Click on HOOQ logo");
								Thread.sleep(3000);
								driver.navigate().to(objConfig.strURL);
								blnStatus=true;
							}
							else 
							{
								Reporter.fail("Verify movie player for Lapsed user", "Nova planselector page is not displayed while playing the Movie");
								blnStatus=false;
							}
							//driver.navigate().back();
							Thread.sleep(20000);
						}

						//Note: Need to add "Download" option for both android and IOS
						else if(lstText.equalsIgnoreCase("Download the free App")|| lstText.equalsIgnoreCase("ดาวน์โหลด�?อปพลิเคชันฟรี")|| lstText.equalsIgnoreCase("Download Aplikasi gratis"))
						{

							Reporter.pass("Verify Hamburger Menu for Download app : ", "For web no option for download app");
							driver.navigate().back();
							Thread.sleep(10000);
							//JSClick(hooqLogo, "click on hooq logo");

						}
						else if(lstText.equalsIgnoreCase("My Rentals")|| lstText.equalsIgnoreCase("หนังเช่าของฉัน"))
						{
							String myRental = getText(myRentals,""); //*[contains(@class,'PageContent__Content')]/div/h1
							Reporter.pass("Verify Hamburger Menu for My Rental : ", " "+myRental+" page should have Purchased content");
							driver.navigate().back();
							Thread.sleep(20000);

						}
						else if(lstText.equalsIgnoreCase("Account & Settings")|| lstText.equalsIgnoreCase("บั�?ชีผู้ใช้�?ละ�?ารตั้งค่า"))
						{
							String Account_settings = getText(Accounts_Settings,"");
							Reporter.pass("Verify Hamburger Menu for Account & settings : ", " "+Account_settings+" is dispalyed");
							driver.navigate().back();
							Thread.sleep(20000);

						}
						else if(lstText.equalsIgnoreCase("Link TV")|| lstText.equalsIgnoreCase("เชื่อมต่อทีวี ") ||lstText.equalsIgnoreCase("Hubungkan TV"))
						{
							String linkTVTxt = getText(linkTV,"Link Tv");
							if(linkTVTxt.equalsIgnoreCase(lstText))
							{
								Reporter.pass("Verify Hamburger Menu", "Redirected to '"+menuTabHighlightedtxt + "' and is highlighted successfully"); 
							}
							else
							{
								Reporter.fail("Verify Hamburger Menu", " '"+menuTabHighlightedtxt + "'  is not highlighted successfully"); 
							}	
							JSClick(BackArrow, "Back Arrow");
						}
						else if(lstText.equalsIgnoreCase("Log out")|| lstText.equalsIgnoreCase("ออ�?จา�?ระบบ") ||lstText.equalsIgnoreCase("Keluar"))
						{
							Thread.sleep(2000);
							Reporter.pass("Verify Hamburger Menu", "Redirected to Logout and is displayed successfully");					
							//driver.navigate().back();
							Thread.sleep(20000);
						}
						else if(lstText.equalsIgnoreCase("Log in")|| lstText.equalsIgnoreCase("เข้าสู่ระบบ")|| lstText.equalsIgnoreCase("Masuk") ||lstText.equalsIgnoreCase("Sign up")|| lstText.equalsIgnoreCase("ลงทะเบียน")|| lstText.equalsIgnoreCase("Daftar"))
						{
							if(lstText.equalsIgnoreCase("Log in")|| lstText.equalsIgnoreCase("เข้าสู่ระบบ")|| lstText.equalsIgnoreCase("Masuk") )
							{
								Thread.sleep(2000);
								String loginpage=getText(loginTitleVerification, "Login Page");
								if(isElementDisplayed(loginTitleVerification))
								{
									Reporter.pass("Verify Hamburger Menu", "Redirected to '"+loginpage + "' and is displayed successfully");
								}
								else
								{
									Reporter.fail("Verify Hamburger Menu", "Redirected to '"+loginpage + "' and is not displayed successfully");

								}
							}
							else if(lstText.equalsIgnoreCase("Sign up")|| lstText.equalsIgnoreCase("ลงทะเบียน")|| lstText.equalsIgnoreCase("Daftar"))
							{
								String signupPage=getText(signupBtn, "Sign UP Page");
								if(isElementDisplayed(signupBtn))
								{
									Reporter.pass("Verify Hamburger Menu", "Redirected to '"+signupPage + "' and is displayed successfully");
								}
								else
								{
									Reporter.fail("Verify Hamburger Menu", "Redirected to '"+signupPage + "' and is not displayed successfully");

								}
							}
							driver.navigate().back();
							Thread.sleep(20000);
							blnStatus = true;
						}
						click(hooqLogo, "HamburgerMenu");
						Thread.sleep(2000);
						JSClick(hamburgerMenu, "HamburgerMenu");
						Thread.sleep(10000);
						blnStatus= true;

					}
				}

				JSClick(closehamburgerMenu, "Close the HamburgerMenu");
				Thread.sleep(5000);
			}
			else if(objConfig.strDriverType.equals("desktopchrome"))
			{
				if(userType.equalsIgnoreCase("Visitor"))
				{
					List<WebElement> lstHamburgerMenu=driver.findElements(hamburgerListMenu);
					for(int i=0; i<lstHamburgerMenu.size(); i++)
					{
						String lstText = null;
						String lstText1 = null;						
						Thread.sleep(2000);
						WebElement menuItem = driver.findElement(By.xpath("//*[contains(@class, 'NavPopupMenu__Nav')]//a["+(i+1)+"]"));
						lstText=menuItem.getText();
						lstText1=driver.findElement(By.xpath("//*[contains(@class, 'NavPopupMenu__Nav')]//a["+(i+1)+"]")).getText();
						WebElement element = driver.findElement(By.xpath("//*[contains(@class, 'NavPopupMenu__Nav')]//a["+(i+1)+"]"));
						JavascriptExecutor executor = (JavascriptExecutor) driver;
						executor.executeScript("arguments[0].click();", element);																				
						Thread.sleep(10000);
						String menuTabHighlightedtxt= null;						
						if(lstText.equalsIgnoreCase("PRICING")|| lstText.equalsIgnoreCase("ราคา")|| lstText.equalsIgnoreCase("Daftar harga") )
						{
							String signupPage=getText(By.tagName("label"), "Sign UP Page");
							if(isElementDisplayed(signupBtn))
							{
								Reporter.pass("Verify Hamburger Menu of pricing is : ", "Redirected to '"+signupPage + "' and is displayed successfully");
							}
							else
							{
								Reporter.fail("Verify Hamburger Menu pricing is : ", "Redirected to '"+signupPage + "' and is not displayed successfully");

							}
							driver.navigate().back();
							Thread.sleep(20000);
						}
						click(hooqLogo, "HamburgerMenu");
						Thread.sleep(2000);
						JSClick(hamburgerMenu, "HamburgerMenu");
						Thread.sleep(10000);
						blnStatus= true;
					}
				}
				else if(userType.equalsIgnoreCase("Active"))
				{
					List<WebElement> lstHamburgerMenu=driver.findElements(hamburgerListMenu);
					for(int i=0; i<lstHamburgerMenu.size(); i++)
					{
						String lstText = null;
						String lstText1 = null;	
						Thread.sleep(2000);
						WebElement menuItem = driver.findElement(By.xpath("//*[contains(@class, 'NavPopupMenu__Nav')]//a["+(i+1)+"]"));
						lstText=menuItem.getText();
						lstText1=driver.findElement(By.xpath("//*[contains(@class, 'NavPopupMenu__Nav')]//a["+(i+1)+"]")).getText();
						WebElement element = driver.findElement(By.xpath("//*[contains(@class, 'NavPopupMenu__Nav')]//a["+(i+1)+"]"));
						JavascriptExecutor executor = (JavascriptExecutor) driver;
						executor.executeScript("arguments[0].click();", element);																				

						Thread.sleep(10000);
						String menuTabHighlightedtxt= null;

						if(lstText.equalsIgnoreCase("Channels"))
						{
							Thread.sleep(2000);
							if(isElementDisplayed(playerwindow))
							{
								Reporter.pass("Verify live tv player", "Able to play the LIVE TV");	
								if(isElementDisplayed(By.xpath("(//div[contains(@class,'ChannelButton__ImageContainer-sc-1')]//img)[1]")));
								{
									Reporter.pass("Verify live tv player", "First LIVE tv channel is playing");
									driver.navigate().back();
								}
							}
							else 
							{
								Reporter.fail("Verify live tv player", "First LIVE tv channel is not playing");
								driver.navigate().back();
							}
						}

						else if(lstText.equalsIgnoreCase("My Rentals")|| lstText.equalsIgnoreCase("หนังเช่าของฉัน"))
						{
							String myRentalTxt = getText(myRentals,"MyRentals"); //*[contains(@class,'PageContent__Content')]/div/h1
							Reporter.pass("Verify Hamburger Menu for My Rental : ", " "+myRentalTxt+" page should have Purchased content");
							driver.navigate().back();
							Thread.sleep(20000);
						}
						else if(lstText.equalsIgnoreCase("Account & Settings")|| lstText.equalsIgnoreCase("บั�?ชีผู้ใช้�?ละ�?ารตั้งค่า"))
						{
							String Account_settings = getText(Accounts_Settings,"Accounts&Settings");
							Reporter.pass("Verify Hamburger Menu for Account & settings : ", " "+Account_settings+" is dispalyed");
							driver.navigate().back();
							Thread.sleep(20000);

						}
						else if(lstText.equalsIgnoreCase("Link TV")|| lstText.equalsIgnoreCase("เชื่อมต่อทีวี ") ||lstText.equalsIgnoreCase("Hubungkan TV"))
						{
							String linkTVTxt = getText(linkTV,"Link Tv");
							if(linkTVTxt.equalsIgnoreCase(lstText))
							{
								Reporter.pass("Verify Hamburger Menu", "Redirected to '"+menuTabHighlightedtxt + "' and is highlighted successfully"); 
							}
							else
							{
								Reporter.fail("Verify Hamburger Menu", " '"+menuTabHighlightedtxt + "'  is not highlighted successfully"); 
							}	
							Thread.sleep(2000);
							JSClick(BackArrow, "Back Arrow");
						}

						else if(lstText.equalsIgnoreCase("Log out")|| lstText.equalsIgnoreCase("ออ�?จา�?ระบบ") ||lstText.equalsIgnoreCase("Keluar"))
						{
							Thread.sleep(2000);
							Reporter.pass("Verify Hamburger Menu", "Redirected to Logout and is displayed successfully");			
							//driver.navigate().back();
							Thread.sleep(20000);
						}		

						click(hooqLogo, "HamburgerMenu");
						Thread.sleep(2000);
						JSClick(hamburgerMenu, "HamburgerMenu");
						Thread.sleep(10000);
						blnStatus= true;

					}
				}
				else if(userType.equalsIgnoreCase("Lapsed"))
				{
					List<WebElement> lstHamburgerMenu=driver.findElements(hamburgerListMenu);
					for(int i=0; i<lstHamburgerMenu.size(); i++)
					{
						String lstText = null;
						String lstText1 = null;	
						Thread.sleep(2000);
						WebElement menuItem = driver.findElement(By.xpath("//*[contains(@class, 'NavPopupMenu__Nav')]//a["+(i+1)+"]"));
						lstText=menuItem.getText();
						lstText1=driver.findElement(By.xpath("//*[contains(@class, 'NavPopupMenu__Nav')]//a["+(i+1)+"]")).getText();
						WebElement element = driver.findElement(By.xpath("//*[contains(@class, 'NavPopupMenu__Nav')]//a["+(i+1)+"]"));
						JavascriptExecutor executor = (JavascriptExecutor) driver;
						executor.executeScript("arguments[0].click();", element);	

						Thread.sleep(10000);
						String menuTabHighlightedtxt= null;

						if(lstText.equalsIgnoreCase("Channels"))
						{
							Thread.sleep(2000);
							if(isElementDisplayed(playerwindow))
							{
								Reporter.pass("Verify live tv player", "Able to play the LIVE TV");	
								if(isElementDisplayed(By.xpath("(//div[contains(@class,'ChannelButton__ImageContainer')]//img)[1]")));
								{
									Reporter.pass("Verify live tv player", "First LIVE tv channel is playing");
									driver.navigate().back();
								}
							}
							else 
							{
								Reporter.fail("Verify live tv player", "First LIVE tv channel is not playing");
								driver.navigate().back();
							}
						}
						else if(lstText.equalsIgnoreCase("PRICING")|| lstText.equalsIgnoreCase("ราคา")|| lstText.equalsIgnoreCase("Daftar harga") )
						{
							if(isElementDisplayed(novaPageValidation))
							{
								Thread.sleep(2000);
								Reporter.pass("Verify movie player for Lapsed user", "Nova planselector page is displayed successfully while playing the Movie");	
								JSClick(hooqlogoNew,"Click on HOOQ logo");
								Thread.sleep(3000);
								driver.navigate().to(objConfig.strURL);
								blnStatus=true;
							}
							else 
							{
								Reporter.fail("Verify movie player for Lapsed user", "Nova planselector page is not displayed while playing the Movie");
								blnStatus=false;
							}
							//driver.navigate().back();
							Thread.sleep(20000);
						}
						else if(lstText.equalsIgnoreCase("My Rentals")|| lstText.equalsIgnoreCase("หนังเช่าของฉัน"))
						{
							String myRental = getText(myRentals,""); //*[contains(@class,'PageContent__Content')]/div/h1
							Reporter.pass("Verify Hamburger Menu for My Rental : ", " "+myRental+" page should have Purchased content");
							driver.navigate().back();
							Thread.sleep(20000);

						}
						else if(lstText.equalsIgnoreCase("Account & Settings")|| lstText.equalsIgnoreCase("บั�?ชีผู้ใช้�?ละ�?ารตั้งค่า"))
						{
							String Account_settings = getText(Accounts_Settings,"");
							Reporter.pass("Verify Hamburger Menu for Account & settings : ", " "+Account_settings+" is dispalyed");
							driver.navigate().back();
							Thread.sleep(20000);

						}
						else if(lstText.equalsIgnoreCase("Link TV")|| lstText.equalsIgnoreCase("เชื่อมต่อทีวี ") ||lstText.equalsIgnoreCase("Hubungkan TV"))
						{
							String linkTVTxt = getText(linkTV,"Link Tv");
							if(linkTVTxt.equalsIgnoreCase(lstText))
							{
								Reporter.pass("Verify Hamburger Menu", "Redirected to '"+menuTabHighlightedtxt + "' and is highlighted successfully"); 
							}
							else
							{
								Reporter.fail("Verify Hamburger Menu", " '"+menuTabHighlightedtxt + "'  is not highlighted successfully"); 
							}	
							JSClick(BackArrow, "Back Arrow");
						}
						else if(lstText.equalsIgnoreCase("Log out")|| lstText.equalsIgnoreCase("ออ�?จา�?ระบบ") ||lstText.equalsIgnoreCase("Keluar"))
						{
							Thread.sleep(2000);
							Reporter.pass("Verify Hamburger Menu", "Redirected to Logout and is displayed successfully");					
							//driver.navigate().back();
							Thread.sleep(20000);
						}
						click(hooqLogo, "HamburgerMenu");
						Thread.sleep(2000);
						JSClick(hamburgerMenu, "HamburgerMenu");
						Thread.sleep(10000);
						blnStatus= true;
					}
				}
				JSClick(closehamburgerMenu, "Close the HamburgerMenu");
				Thread.sleep(5000);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return blnStatus;	
	}

}
