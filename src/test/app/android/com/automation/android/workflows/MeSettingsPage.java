package com.automation.android.workflows;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.accelerators.ActionEngine;
import com.automation.reports.Reporter;
import com.automation.utilities.CreditCardNumberGenerator;

public class MeSettingsPage extends BasePage{
	//Locators
	By Logout=By.id("tv.hooq.android:id/profileBtnLoginOut");
	By logoutText=By.id("tv.hooq.android:id/title");
	By settingsTbl=By.id("tv.hooq.android:id/recycler_view");
	By appdisplayAlertTitle=By.id("tv.hooq.android:id/alertTitle");
	By appdisplayDisloglanTbl=By.id("tv.hooq.android:id/select_dialog_listview");
	By restartAppDialog=By.id("tv.hooq.android:id/dialogContentLayout");
	By restartAppTitle=By.id("tv.hooq.android:id/title");
	By restartAppContent=By.id("tv.hooq.android:id/content");
	By restartOkay=By.id("tv.hooq.android:id/okay");
	By navBackBtn=By.id("tv.hooq.android:id/backInMainActivity");
	By settingsTopLayout=By.id("tv.hooq.android:id/appBarLayout");
	By settingTitle=By.id("tv.hooq.android:id/toolbarTitle");
	By settingsTable=By.id("tv.hooq.android:id/recycler_view");
	By settingsTitle=By.id("android:id/title");
	By settingsDescription=By.id("android:id/summary");
	By mobileDataSwitch=By.id("tv.hooq.android:id/switchWidget");
	By lanText=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout[1]/android.view.View/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView[2]");
	By parentPopuppannel=By.id("tv.hooq.android:id/parentPanel");
	By contentpannel=By.id("tv.hooq.android:id/contentPanel");
	By popupCancel=By.id("android:id/button2");
	By audioLanSel=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout[1]/android.view.View/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView[2]");
	By SubLanSel=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout[1]/android.view.View/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.TextView[2]");
	By PlaybackQualitySel=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout[1]/android.view.View/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.TextView[2]");
	By DownloadQualitySel=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout[1]/android.view.View/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.RelativeLayout/android.widget.TextView[2]");
	By MobiledataSel=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout[1]/android.view.View/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[6]/android.widget.RelativeLayout/android.widget.TextView[2]");
	By ParentalControlSel=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout[1]/android.view.View/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[7]/android.widget.RelativeLayout/android.widget.TextView[2]");
	By pcTitle=By.id("tv.hooq.android:id/title");
	By pcHeaderTitle=By.id("tv.hooq.android:id/toolbarTitle");
	By btnOver21=By.id("tv.hooq.android:id/btn_over_21");
	By btnBelow21=By.id("tv.hooq.android:id/btn_not_over_21");
	By layoutParent=By.id("tv.hooq.android:id/layout_over_21");
	By confirmAge=By.id("tv.hooq.android:id/btn_verify_age");
	By layoutnotOver=By.id("tv.hooq.android:id/layout_not_over_21");
	By confirmNotOver=By.id("tv.hooq.android:id/btn_confirm");
	
	
	
	public boolean fnVerifySettingsPage() throws Throwable {
		Reporter.info("HOOQ Android","Verifying Settings Section");
		boolean blnFound=true;
		try
		{
				Reporter.info("HOOQ Settings Screen","Verifying Settings Screen");
				//Go to Me Section
				mePage.fnSelectMESection("sett");
				String strHeader=driver.findElement(settingsTopLayout).findElement(settingTitle).getText();
				System.out.println(strHeader);
				if(strHeader.toLowerCase().contains("settings"))
				{
					Reporter.pass("Settings Screen", "Settings Section is displayed");
				}
				else
				{
					Reporter.fail("Settings Screen", "Settings Section is not displayed");
				}
				List<WebElement> eleList=driver.findElement(settingsTable).findElements(By.className("android.widget.LinearLayout"));
				System.out.println(eleList.size());
				if(eleList.size()==8)
				{
					Reporter.pass("Verify App Setting page","Setting page is is Displayed");
					Reporter.info("HOOQ Settings Screen","Verifying Settings Components");
					String strAppDisplayLabel=eleList.get(0).findElement(settingsTitle).getText();
					String strAppDisplayText=eleList.get(0).findElement(settingsDescription).getText();
					if(strAppDisplayLabel.toLowerCase().contains("app display language"))
					{
						Reporter.pass("Verify App Setting page","Setting page - App Display Language is Displayed");
					}
					else
					{
						Reporter.fail("Verify App Setting page","Setting page - App Display Language is not Displayed");
					}
					if(strAppDisplayText.length()>0)
					{
						Reporter.pass("Verify App Setting page","Setting page - App Display Language :- "+ strAppDisplayText+" is Displayed");
					}
					else
					{
						Reporter.fail("Verify App Setting page","Setting page - App Display Language Text Selected is not Displayed");
					}
					
					String strAudioLanguageLabel=eleList.get(1).findElement(settingsTitle).getText();
					String strAudioLanguageText=eleList.get(1).findElement(settingsDescription).getText();
					if(strAudioLanguageLabel.toLowerCase().contains("audio language"))
					{
						Reporter.pass("Verify App Setting page","Setting page - Audio Language is Displayed");
					}
					else
					{
						Reporter.fail("Verify App Setting page","Setting page - Audio Language is not Displayed");
					}
					if(strAudioLanguageText.length()>0)
					{
						Reporter.pass("Verify App Setting page","Setting page - Audio Language :- "+ strAudioLanguageText+" is Displayed");
					}
					else
					{
						Reporter.fail("Verify App Setting page","Setting page - Audio Language Text Selected is not Displayed");
					}
					
					
					String strSubtitleLanguageLabel=eleList.get(2).findElement(settingsTitle).getText();
					String strSubtitleLanguageText=eleList.get(2).findElement(settingsDescription).getText();
					if(strSubtitleLanguageLabel.toLowerCase().contains("subtitle language"))
					{
						Reporter.pass("Verify App Setting page","Setting page - Subtitle Language is Displayed");
					}
					else
					{
						Reporter.fail("Verify App Setting page","Setting page - Subtitle Language is not Displayed");
					}
					if(strSubtitleLanguageText.length()>0)
					{
						Reporter.pass("Verify App Setting page","Setting page - Subtitle Language :- "+ strSubtitleLanguageText+" is Displayed");
					}
					else
					{
						Reporter.fail("Verify App Setting page","Setting page - Subtitle Language Text Selected is not Displayed");
					}
					
					String strPlaybackQualityLabel=eleList.get(3).findElement(settingsTitle).getText();
					String strPlaybackQualityText=eleList.get(3).findElement(settingsDescription).getText();
					if(strPlaybackQualityLabel.toLowerCase().contains("playback quality"))
					{
						Reporter.pass("Verify App Setting page","Setting page - Playback Quality is Displayed");
					}
					else
					{
						Reporter.fail("Verify App Setting page","Setting page - Playback Quality is not Displayed");
					}
					if(strPlaybackQualityText.length()>0)
					{
						Reporter.pass("Verify App Setting page","Setting page - Playback Quality :- "+ strPlaybackQualityText+" is Displayed");
					}
					else
					{
						Reporter.fail("Verify App Setting page","Setting page - Playback Quality Text Selected is not Displayed");
					}
					
					String strDownloadQualityLabel=eleList.get(4).findElement(settingsTitle).getText();
					String strDownloadQualityText=eleList.get(4).findElement(settingsDescription).getText();
					if(strDownloadQualityLabel.toLowerCase().contains("download quality"))
					{
						Reporter.pass("Verify App Setting page","Setting page - Download Quality is Displayed");
					}
					else
					{
						Reporter.fail("Verify App Setting page","Setting page - Download Quality is not Displayed");
					}
					if(strDownloadQualityText.length()>0)
					{
						Reporter.pass("Verify App Setting page","Setting page - Download Quality :- "+ strDownloadQualityText+" is Displayed");
					}
					else
					{
						Reporter.fail("Verify App Setting page","Setting page - Download Quality Text Selected is not Displayed");
					}
					
					String strMobileDataUsageLabel=eleList.get(5).findElement(settingsTitle).getText();
					String strMobileDataUsageText=eleList.get(5).findElement(settingsDescription).getText();
					if(strMobileDataUsageLabel.toLowerCase().contains("mobile data usage"))
					{
						Reporter.pass("Verify App Setting page","Setting page - Mobile Data Usage is Displayed");
					}
					else
					{
						Reporter.fail("Verify App Setting page","Setting page - Mobile Data Usage is not Displayed");
					}
					if(strMobileDataUsageText.length()>0)
					{
						Reporter.pass("Verify App Setting page","Setting page - Mobile Data Usage :- "+ strMobileDataUsageText+" is Displayed");
					}
					else
					{
						Reporter.fail("Verify App Setting page","Setting page - Mobile Data Usage Text Selected is not Displayed");
					}
					if(isElementDisplayed(mobileDataSwitch))
					{
						Reporter.pass("Verify App Setting page","Setting page - Mobile Data Usage Switch Button is Displayed");
					}
					else
					{
						Reporter.fail("Verify App Setting page","Setting page - Mobile Data Usage Switch Button is not Displayed");
					}
					
					String strParentalControlsLabel=eleList.get(6).findElement(settingsTitle).getText();
					String strParentalControlsText=eleList.get(6).findElement(settingsDescription).getText();
					if(strParentalControlsLabel.toLowerCase().contains("parental controls"))
					{
						Reporter.pass("Verify App Setting page","Setting page - Parental Controls is Displayed");
					}
					else
					{
						Reporter.fail("Verify App Setting page","Setting page - Parental Controls is not Displayed");
					}
					if(strParentalControlsText.length()>0)
					{
						Reporter.pass("Verify App Setting page","Setting page - Parental Controls :- "+ strParentalControlsText+" is Displayed");
					}
					else
					{
						Reporter.fail("Verify App Setting page","Setting page - Parental Controls Text Selected is not Displayed");
					}
				}
				else
				{
					Reporter.fail("Verify App Setting page","Setting page is not Displayed");
				}
				driver.navigate().back();
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			blnFound=false;
		}
		return blnFound;
		
	}

	public boolean fnSelectSettingsModule(String strModule)
	{
		boolean blnStatus=true;
		try
		{
			List<WebElement> elelist=driver.findElement(settingsTbl).findElements(By.id("android:id/title"));
			if(strModule.toLowerCase().startsWith("displaylang"))
			{
				elelist.get(0).click();
			}
			else if(strModule.toLowerCase().startsWith("audiolang"))
			{
				elelist.get(1).click();
			}
			else if(strModule.toLowerCase().startsWith("subtitlelang"))
			{
				elelist.get(2).click();
			}
			else if(strModule.toLowerCase().startsWith("playbackquality"))
			{
				elelist.get(3).click();
			}
			else if(strModule.toLowerCase().startsWith("downloadquality"))
			{
				elelist.get(4).click();
			}
			else if(strModule.toLowerCase().startsWith("mobiledatausage"))
			{
				elelist.get(5).click();
			}
			else if(strModule.toLowerCase().startsWith("parentalcontrol"))
			{
				elelist.get(6).click();
			}
		}
		catch(Exception e){blnStatus=false;}
			return blnStatus;
		
	}
	
	public String fnGetTextSettingsodule(String strModule)
	{
		String strText="";
		try
		{
			List<WebElement> elelist=driver.findElement(settingsTbl).findElements(By.id("android:id/summary"));
			if(strModule.toLowerCase().startsWith("displaylang"))
			{
				strText=elelist.get(0).getText();
			}
			else if(strModule.toLowerCase().startsWith("audiolang"))
			{
				strText=elelist.get(1).getText();
			}
			else if(strModule.toLowerCase().startsWith("subtitlelang"))
			{
				strText=elelist.get(2).getText();
			}
			else if(strModule.toLowerCase().startsWith("playbackquality"))
			{
				strText=elelist.get(3).getText();
			}
			else if(strModule.toLowerCase().startsWith("downloadquality"))
			{
				strText=elelist.get(4).getText();
			}
			else if(strModule.toLowerCase().startsWith("mobiledatausage"))
			{
				strText=elelist.get(5).getText();
			}
			else if(strModule.toLowerCase().startsWith("parentalcontrol"))
			{
				strText=elelist.get(6).getText();
			}
		}
		catch(Exception e){}
			return strText;
		
	}
	
	
	
	public void fnChangetoLanguageEnglish() throws Throwable {
		try
		{
			boolean blnChange=false;
			mePage.fnSelectME();
			List<WebElement> eleList=driver.findElement(Logout).findElements(logoutText);
			String strText=eleList.get(0).getText();
			if(strText.toLowerCase().contains("log out")==false)
			{
				blnChange=true;
			}
			if(blnChange)
			{
				fnChangeLanguage("default");
			}
			if(isElementDisplayed(navBackBtn))
			{
				click(navBackBtn,"Back From Settings page");
			}
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
		}
		
	}

	public boolean fnChangeLanguage(String strLanguage) throws Throwable
	{
		boolean blnStatus=false;
		try
		{
			mePage.fnSelectMESection("sett");
			fnSelectSettingsModule("displaylang");
			String strText=getText(appdisplayAlertTitle,"Alert Title");
			if(strText.length()>0)
			{
				Reporter.pass("App Display Language Alert Text","Alert Text : " + strText+" is Displayed" );
			}
			else
			{
				Reporter.fail("App Display Language Alert Text","Alert Text is not Displayed" );
			}
			List<WebElement> elelist=driver.findElement(appdisplayDisloglanTbl).findElements(By.id("android:id/text1"));
			for(int i=0;i<elelist.size();i++)
			{
				Reporter.pass("App Display Language","App language Option : " + elelist.get(i).getText() +" is Displayed" );
			}
			if(strLanguage.toLowerCase().contains("default"))
			{
				elelist.get(0).click();
			}
			else if(strLanguage.toLowerCase().contains("eng"))
			{
				elelist.get(1).click();
			}
			else if(strLanguage.toLowerCase().contains("thai"))
			{
				elelist.get(2).click();
			}
			else if(strLanguage.toLowerCase().contains("bah"))
			{
				elelist.get(3).click();
			}
			fnHandleRestartAppPopUp();
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fnPrintException(e);
		}
		return blnStatus;
	}
	
	public boolean fnHandleRestartAppPopUp() throws Throwable
	{
		boolean blnStatus=true;
		try
		{
			List<WebElement> eleList=driver.findElements(restartAppDialog);
			if(eleList.size()>0)
			{
				String strTitle=getText(restartAppTitle, "Alert Title");
				if(strTitle.length()>0)
				{
					Reporter.pass("Restart App Title","Title : " + strTitle+" is Displayed" );
				}
				else
				{
					Reporter.fail("Restart App Title","Title is not Displayed" );
					blnStatus=false;
				}
				String strContent=getText(restartAppContent, "Alert Content");
				if(strContent.length()>0)
				{
					Reporter.pass("Restart App Content","Content : " + strContent+" is Displayed" );
				}
				else
				{
					Reporter.fail("Restart App Content","Content is not Displayed" );
					blnStatus=false;
				}
				if(isElementDisplayed(restartOkay))
				{
					Reporter.pass("Restart App Okay","Okay Button is Displayed" );
					click(restartOkay, "Restart Okay");
					Thread.sleep(10000);
				}
				else
				{
					Reporter.fail("Restart App Okay","Okay Button is not Displayed" );
					blnStatus=false;
				}
			}
			else
			{
				driver.navigate().back();
			}
			
		}
		catch(Exception e){blnStatus=false;}
		return blnStatus;
	}
	
	
	public boolean fnVerifyLanguage(String strLanguage) throws Throwable
	{
		boolean blnStatus=false;
		Reporter.info("HOOQ Settings Screen","Verifying Settings Screen App Display Languge");
		try
		{
			mePage.fnSelectMESection("sett");
			Thread.sleep(10000);
			String strText=driver.findElement(lanText).getText();
			System.out.println(strText);
			if(fnVerifyText(strText, strLanguage))
			{
				Reporter.pass("App Display Language","App Display Languge : " + strText+" is Displayed" );
			}
			else
			{
				Reporter.fail("App Display Language","App Display Languge : " + strLanguage+" is not Displayed" );
				blnStatus=false;
			}
			driver.navigate().back();
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fnPrintException(e);
		}
		return blnStatus;
	}
	
	public void fnVerifyLanguageSettings(String strLanguage) throws Throwable
	{
		meSettingsPage.fnChangeLanguage(strLanguage);
		meSettingsPage.fnVerifyLanguage(strLanguage);
	}
	
	public void fnVerifyAudioLanguageSettings() throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		try
		{
		mePage.fnSelectMESection("sett");
		fnSelectSettingsModule("audiolang");
		Reporter.info("HOOQ Settings Screen","Verifying Settings Screen App Audio Languge");
		if(isElementDisplayed(parentPopuppannel))
		{
			List<WebElement> eleList=driver.findElement(parentPopuppannel).findElements(By.className("android.widget.TextView"));
			System.out.println(eleList.size());
			if(eleList.size()>0)
			{
				if(fnVerifyText(eleList.get(0).getText(), "Audio Language"))
				{
					Reporter.pass("App Audio Language","App Audio Languge Popup Text Audio Languag is Displayed" );
				}
				else
				{
					Reporter.fail("App Audio Language","App Audio Languge Popup Text Audio Languag is not Displayed" );
				}
			}
			List<WebElement> eleListContent=driver.findElement(appdisplayDisloglanTbl).findElements(By.className("android.widget.CheckedTextView"));
			System.out.println(eleListContent.size());
			if(eleListContent.size()>0)
			{
				for(int i=0;i<eleListContent.size();i++)
				{
					System.out.println(eleListContent.get(i).getText());
					Reporter.pass("App Audio Language","App Audio Languge "+ eleListContent.get(i).getText() +" is Displayed" );
				}
			}
			else
			{
				Reporter.fail("App Audio Language","App Audio Languge Popup Text Audio Languag List is not Displayed" );
			}
			click(popupCancel,"Cancel");
			Thread.sleep(5000);
			driver.navigate().back();
			mePage.fnSelectMESection("sett");
			fnSelectSettingsModule("audiolang");
			List<WebElement> eleListAudio=driver.findElement(appdisplayDisloglanTbl).findElements(By.className("android.widget.CheckedTextView"));
			String strFirstLang=eleListAudio.get(0).getText();
			eleListAudio.get(0).click();
			String strLanSel=getText(audioLanSel, "Audio Language Selected");
			System.out.println(strLanSel);
			if(fnVerifyText(strLanSel, strFirstLang))
			{
				Reporter.pass("App Audio Language","App Audio Languge "+ strFirstLang+" is Displayed" );
			}
			else
			{
				Reporter.fail("App Audio Language","App Audio Languge "+ strFirstLang+" is not Displayed" );
			}
			driver.navigate().back();
			mePage.fnSelectMESection("sett");
			fnSelectSettingsModule("audiolang");
			List<WebElement> eleListAudio1=driver.findElement(appdisplayDisloglanTbl).findElements(By.className("android.widget.CheckedTextView"));
			System.out.println(eleListAudio1.size());
			int intSelLang=CreditCardNumberGenerator.createRandomIntBetween(2,eleListAudio1.size());
			String strLanChoose=eleListAudio1.get(intSelLang).getText();
			System.out.println(strLanChoose);
			eleListAudio1.get(intSelLang).click();
			driver.navigate().back();
			mePage.fnSelectMESection("sett");
			String strLanSelection=getText(audioLanSel, "Audio Language Selected");
			System.out.println(strLanSelection);
			if(fnVerifyText(strLanSelection, strLanChoose))
			{
				Reporter.pass("App Audio Language","App Audio Languge "+ strLanChoose +" is Displayed" );
			}
			else
			{
				Reporter.fail("App Audio Language","App Audio Languge "+ strLanChoose +" is not Displayed" );
			}
			driver.navigate().back();
		}
		else
		{
			Reporter.fail("App Audio Language","App Audio Languge Popup is not Displayed" );
		}
		
		}
		catch(Exception e){Reporter.blnReportTempStatus=false;}
		if(Reporter.blnReportTempStatus)
		{
			Reporter.pass("App Audio Language","App Audio Languge is Changed Successfully" );
		}
		else
		{
			Reporter.fail("App Audio Language","App Audio Languge is not Changed Successfully" );
		}
	}
	
	public void fnVerifySubTitleLanguageSettings() throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		try
		{
		mePage.fnSelectMESection("sett");
		fnSelectSettingsModule("subtitlelang");
		Reporter.info("HOOQ Settings Screen","Verifying Settings Screen App SubTitle Languge");
		if(isElementDisplayed(parentPopuppannel))
		{
			List<WebElement> eleList=driver.findElement(parentPopuppannel).findElements(By.className("android.widget.TextView"));
			System.out.println(eleList.size());
			if(eleList.size()>0)
			{
				if(fnVerifyText(eleList.get(0).getText(), "SubTitle Language"))
				{
					Reporter.pass("App SubTitle Language","App SubTitle Languge Popup Text SubTitle Languag is Displayed" );
				}
				else
				{
					Reporter.fail("App SubTitle Language","App Audio Languge Popup Text SubTitle Languag is not Displayed" );
				}
			}
			List<WebElement> eleListContent=driver.findElement(appdisplayDisloglanTbl).findElements(By.className("android.widget.CheckedTextView"));
			System.out.println(eleListContent.size());
			if(eleListContent.size()>0)
			{
				for(int i=0;i<eleListContent.size();i++)
				{
					System.out.println(eleListContent.get(i).getText());
					Reporter.pass("App SubTitle Language","App SubTitle Languge "+ eleListContent.get(i).getText() +" is Displayed" );
				}
			}
			else
			{
				Reporter.fail("App SubTitle Language","App Audio Languge Popup Text SubTitle Languag List is not Displayed" );
			}
			click(popupCancel,"Cancel");
			Thread.sleep(5000);
			driver.navigate().back();
			mePage.fnSelectMESection("sett");
			fnSelectSettingsModule("subtitlelang");
			List<WebElement> eleListAudio=driver.findElement(appdisplayDisloglanTbl).findElements(By.className("android.widget.CheckedTextView"));
			String strFirstLang=eleListAudio.get(0).getText();
			eleListAudio.get(0).click();
			String strLanSel=getText(SubLanSel, "SubTitle Language Selected");
			System.out.println(strLanSel);
			if(fnVerifyText(strLanSel, strFirstLang))
			{
				Reporter.pass("App SubTitle Language","App SubTitle Languge "+ strFirstLang+" is Displayed" );
			}
			else
			{
				Reporter.fail("App SubTitle Language","App SubTitle Languge "+ strFirstLang+" is not Displayed" );
			}
			driver.navigate().back();
			mePage.fnSelectMESection("sett");
			fnSelectSettingsModule("subtitlelang");
			List<WebElement> eleListAudio1=driver.findElement(appdisplayDisloglanTbl).findElements(By.className("android.widget.CheckedTextView"));
			System.out.println(eleListAudio1.size());
			int intSelLang=CreditCardNumberGenerator.createRandomIntBetween(2,eleListAudio1.size());
			String strLanChoose=eleListAudio1.get(intSelLang).getText();
			System.out.println(strLanChoose);
			eleListAudio1.get(intSelLang).click();
			driver.navigate().back();
			mePage.fnSelectMESection("sett");
			String strLanSelection=getText(SubLanSel, "SubTitle Language Selected");
			System.out.println(strLanSelection);
			if(fnVerifyText(strLanSelection, strLanChoose))
			{
				Reporter.pass("App SubTitle Language","App SubTitle Languge "+ strLanChoose +" is Displayed" );
			}
			else
			{
				Reporter.fail("App SubTitle Language","App SubTitle Languge "+ strLanChoose +" is not Displayed" );
			}
			driver.navigate().back();
		}
		else
		{
			Reporter.fail("App SubTitle Language","App SubTitle Languge Popup is not Displayed" );
		}
		
		}
		catch(Exception e){Reporter.blnReportTempStatus=false;}
		if(Reporter.blnReportTempStatus)
		{
			Reporter.pass("App SubTitle Language","App SubTitle Languge is Changed Successfully" );
		}
		else
		{
			Reporter.fail("App SubTitle Language","App SubTitle Languge is not Changed Successfully" );
		}
	}
	
	public void fnVerifyPlaybackQualitySettings() throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		try
		{
		mePage.fnSelectMESection("sett");
		fnSelectSettingsModule("playbackquality");
		Reporter.info("HOOQ Settings Screen","Verifying Settings Screen Playback Quality");
		if(isElementDisplayed(parentPopuppannel))
		{
			List<WebElement> eleList=driver.findElement(parentPopuppannel).findElements(By.className("android.widget.TextView"));
			System.out.println(eleList.size());
			if(eleList.size()>0)
			{
				if(fnVerifyText(eleList.get(0).getText(), "Playback Quality"))
				{
					Reporter.pass("App Playback Quality","App Playback Quality Popup Text Playback Quality is Displayed" );
				}
				else
				{
					Reporter.fail("App Playback Quality","App Playback Quality Popup Text Playback Quality is not Displayed" );
				}
			}
			List<WebElement> eleListContent=driver.findElement(appdisplayDisloglanTbl).findElements(By.className("android.widget.CheckedTextView"));
			System.out.println(eleListContent.size());
			if(eleListContent.size()>0)
			{
				for(int i=0;i<eleListContent.size();i++)
				{
					System.out.println(eleListContent.get(i).getText());
					Reporter.pass("App Playback Quality","App Playback Quality "+ eleListContent.get(i).getText() +" is Displayed" );
				}
			}
			else
			{
				Reporter.fail("App Playback Quality","App Playback Quality Popup Text Playback Quality List is not Displayed" );
			}
			click(popupCancel,"Cancel");
			Thread.sleep(5000);
			driver.navigate().back();
			mePage.fnSelectMESection("sett");
			fnSelectSettingsModule("playbackquality");
			List<WebElement> eleListAudio=driver.findElement(appdisplayDisloglanTbl).findElements(By.className("android.widget.CheckedTextView"));
			String strFirstLang=eleListAudio.get(0).getText();
			eleListAudio.get(0).click();
			String strLanSel=getText(PlaybackQualitySel, "Playback Quality Selected");
			System.out.println(strLanSel);
			if(fnVerifyText(strLanSel, strFirstLang))
			{
				Reporter.pass("App Playback Quality","App Playback Quality "+ strFirstLang+" is Displayed" );
			}
			else
			{
				Reporter.fail("App Playback Quality","App Playback Quality "+ strFirstLang+" is not Displayed" );
			}
			driver.navigate().back();
			mePage.fnSelectMESection("sett");
			fnSelectSettingsModule("playbackquality");
			List<WebElement> eleListAudio1=driver.findElement(appdisplayDisloglanTbl).findElements(By.className("android.widget.CheckedTextView"));
			System.out.println(eleListAudio1.size());
			int intSelLang=CreditCardNumberGenerator.createRandomIntBetween(2,eleListAudio1.size());
			String strLanChoose=eleListAudio1.get(intSelLang).getText();
			System.out.println(strLanChoose);
			eleListAudio1.get(intSelLang).click();
			driver.navigate().back();
			mePage.fnSelectMESection("sett");
			String strLanSelection=getText(PlaybackQualitySel, "Playback Quality Selected");
			System.out.println(strLanSelection);
			if(fnVerifyText(strLanSelection, strLanChoose))
			{
				Reporter.pass("App Playback Quality","App Playback Quality "+ strLanChoose +" is Displayed" );
			}
			else
			{
				Reporter.fail("App Playback Quality","App Playback Quality "+ strLanChoose +" is not Displayed" );
			}
			driver.navigate().back();
		}
		else
		{
			Reporter.fail("App Playback Quality","App Playback Quality Popup is not Displayed" );
		}
		
		}
		catch(Exception e){Reporter.blnReportTempStatus=false;}
		if(Reporter.blnReportTempStatus)
		{
			Reporter.pass("App Playback Quality","App Playback Quality is Changed Successfully" );
		}
		else
		{
			Reporter.fail("App Playback Quality","App Playback Quality is not Changed Successfully" );
		}
	}
	
	public void fnVerifyDownloadQualitySettings() throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		try
		{
		mePage.fnSelectMESection("sett");
		fnSelectSettingsModule("downloadquality");
		Reporter.info("HOOQ Settings Screen","Verifying Settings Screen Download Quality");
		if(isElementDisplayed(parentPopuppannel))
		{
			List<WebElement> eleList=driver.findElement(parentPopuppannel).findElements(By.className("android.widget.TextView"));
			System.out.println(eleList.size());
			if(eleList.size()>0)
			{
				if(fnVerifyText(eleList.get(0).getText(), "Download Quality"))
				{
					Reporter.pass("App Download Quality","App Download Quality Popup Text Download Quality is Displayed" );
				}
				else
				{
					Reporter.fail("App Download Quality","App Download Quality Popup Text Download Quality is not Displayed" );
				}
			}
			List<WebElement> eleListContent=driver.findElement(appdisplayDisloglanTbl).findElements(By.className("android.widget.CheckedTextView"));
			System.out.println(eleListContent.size());
			if(eleListContent.size()>0)
			{
				for(int i=0;i<eleListContent.size();i++)
				{
					System.out.println(eleListContent.get(i).getText());
					Reporter.pass("App Download Quality","App Download Quality "+ eleListContent.get(i).getText() +" is Displayed" );
				}
			}
			else
			{
				Reporter.fail("App Download Quality","App Download Quality Popup Text Download Quality List is not Displayed" );
			}
			click(popupCancel,"Cancel");
			Thread.sleep(5000);
			driver.navigate().back();
			mePage.fnSelectMESection("sett");
			fnSelectSettingsModule("downloadquality");
			List<WebElement> eleListAudio=driver.findElement(appdisplayDisloglanTbl).findElements(By.className("android.widget.CheckedTextView"));
			String strFirstLang=eleListAudio.get(0).getText();
			eleListAudio.get(0).click();
			Thread.sleep(5000);
			driver.navigate().back();
			mePage.fnSelectMESection("sett");
			String strLanSel=getText(DownloadQualitySel, "Download Quality Selected");
			System.out.println(strLanSel);
			if(fnVerifyText(strLanSel, strFirstLang))
			{
				Reporter.pass("App Download Quality","App Download Quality "+ strFirstLang+" is Displayed" );
			}
			else
			{
				Reporter.fail("App Download Quality","App Download Quality "+ strFirstLang+" is not Displayed" );
			}
			driver.navigate().back();
			mePage.fnSelectMESection("sett");
			fnSelectSettingsModule("downloadquality");
			List<WebElement> eleListAudio1=driver.findElement(appdisplayDisloglanTbl).findElements(By.className("android.widget.CheckedTextView"));
			System.out.println(eleListAudio1.size());
			int intSelLang=CreditCardNumberGenerator.createRandomIntBetween(1,eleListAudio1.size());
			String strLanChoose=eleListAudio1.get(intSelLang).getText();
			System.out.println(strLanChoose);
			eleListAudio1.get(intSelLang).click();
			driver.navigate().back();
			mePage.fnSelectMESection("sett");
			String strLanSelection=getText(DownloadQualitySel, "Download Quality Selected");
			System.out.println(strLanSelection);
			if(fnVerifyText(strLanSelection, strLanChoose))
			{
				Reporter.pass("App Download Quality","App Download Quality "+ strLanChoose +" is Displayed" );
			}
			else
			{
				Reporter.fail("App Download Quality","App Download Quality "+ strLanChoose +" is not Displayed" );
			}
			driver.navigate().back();
		}
		else
		{
			Reporter.fail("App Download Quality","App PlaDownloadyback Quality Popup is not Displayed" );
		}
		
		}
		catch(Exception e){Reporter.blnReportTempStatus=false;}
		if(Reporter.blnReportTempStatus)
		{
			Reporter.pass("App Download Quality","App Download Quality is Changed Successfully" );
		}
		else
		{
			Reporter.fail("App Download Quality","App Download Quality is not Changed Successfully" );
		}
	}
	
	public void fnVerifyMobileDataUsageSettings() throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		try
		{
			mePage.fnSelectMESection("sett");
			Reporter.info("HOOQ Settings Screen","Verifying Settings Screen Mobile Data Usage");
			String strLanSel=getText(MobiledataSel, "Mobile Data Info");
			System.out.println(strLanSel);
			String strText1="HOOQ will use mobile data to stream and download videos.";
			if(fnVerifyText(strLanSel, strText1))
			{
				Reporter.pass("App Mobile Data Usage","App Mobile Data Info  "+ strText1+" is Displayed" );
			}
			else
			{
				Reporter.fail("App Mobile Data Usage","App Mobile Data Info  "+ strText1+" is not Displayed" );
			}
			String strTextBefore=driver.findElement(mobileDataSwitch).getAttribute("checked");
			System.out.println(strTextBefore);
			fnSelectSettingsModule("mobiledatausage");
			String strTextAfter=driver.findElement(mobileDataSwitch).getAttribute("checked");
			System.out.println(strTextAfter);
			if(fnVerifyText(strTextBefore, strTextAfter)==false)
			{
				Reporter.pass("App Mobile Data Usage","App Mobile Data Settings Change from "+ strTextBefore + " to " + strTextAfter+ " Successfully." );
			}
			else
			{
				Reporter.fail("App Mobile Data Usage","App Mobile Data Settings not Change from "+ strTextBefore + " to " + strTextAfter+ " Successfully." );
			}
		
			
			
		}
		catch(Exception e){Reporter.blnReportTempStatus=false;}
		if(Reporter.blnReportTempStatus)
		{
			Reporter.pass("App Download Quality","App Mobile Data Usage is Changed Successfully" );
		}
		else
		{
			Reporter.fail("App Download Quality","App Mobile Data Usage is not Changed Successfully" );
		}
	}
	
	
	public void fnVerifyParentalConrolSettings() throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		try
		{
			mePage.fnSelectMESection("sett");
			Reporter.info("HOOQ Settings Screen","Verifying Settings Screen Parental Control");
			String strLanSel=getText(ParentalControlSel, "Parental Control Info");
			System.out.println(strLanSel);
			String strText1="Control the access to content with restricted ratings.";
			if(fnVerifyText(strLanSel, strText1))
			{
				Reporter.pass("App Parental Control","App Parental Control Info  "+ strText1+" is Displayed" );
			}
			else
			{
				Reporter.fail("App Parental Control","App Parental Control Info  "+ strText1+" is not Displayed" );
			}
			fnSelectSettingsModule("parentalcontrol");
			Thread.sleep(5000);
			String strText=getText(pcHeaderTitle,"Page Title");
			if(fnVerifyText(strText, "Parental Controls"))
			{
				Reporter.pass("App Parental Control","App Parental Control Info Parental Controls is Displayed" );
			}
			else
			{
				Reporter.fail("App Parental Control","App Parental Control Info  Parental Controls is not Displayed" );
			}
			strText=getText(pcTitle,"Parental Controls Info");
			if(fnVerifyText(strText, "Are you above the age of 21?"))
			{
				Reporter.pass("App Parental Control","App Parental Control Info Are you above the age of 21? is Displayed" );
			}
			else
			{
				Reporter.fail("App Parental Control","App Parental Control Info Are you above the age of 21? is not Displayed" );
			}
			if(isElementDisplayed(btnOver21))
			{
				List<WebElement> eleListBtn=driver.findElement(btnOver21).findElements(By.className("android.widget.TextView"));
				strText=eleListBtn.get(0).getText();
				if(fnVerifyText(strText, "Yes, I am over 21"))
				{
					Reporter.pass("App Parental Control","App Parental Control Info Yes, I am over 21 is Displayed" );
				}
				else
				{
					Reporter.fail("App Parental Control","App Parental Control Info Yes, I am over 21 is not Displayed" );
				}	
				click(btnOver21,"Yes I am Over 21");
				Thread.sleep(5000);
				List<WebElement> eleLayoutText=driver.findElement(layoutParent).findElements(By.className("android.widget.TextView"));
				List<String> arrData=new ArrayList<String>();
				for(int i=0;i<eleLayoutText.size();i++)
				{
					System.out.println(eleLayoutText.get(i).getText());
					arrData=fnAddData(arrData, eleLayoutText.get(i).getText());
				}
				strText="Enter your date of birth to verify your age and create your PIN. This will allow access to restricted content.";
				if(fnVerifyTextInList(arrData,strText))
				{
					Reporter.pass("App Parental Control Verification","Info "+ strText+" is displayed");
				}
				else
				{
					Reporter.fail("App Parental Control Verification","Info "+ strText+" is not displayed");
				}
				strText="Date of birth:";
				if(fnVerifyTextInList(arrData,strText))
				{
					Reporter.pass("App Parental Control Verification","Info "+ strText+" is displayed");
				}
				else
				{
					Reporter.fail("App Parental Control Verification","Info "+ strText+" is not displayed");
				}
				strText="DD/MM/YYYY";
				if(fnVerifyTextInList(arrData,strText))
				{
					Reporter.pass("App Parental Control Verification","Info "+ strText+" is displayed");
				}
				else
				{
					Reporter.fail("App Parental Control Verification","Info "+ strText+" is not displayed");
				}
				strText="Set your PIN (4 Digits)";
				if(fnVerifyTextInList(arrData,strText))
				{
					Reporter.pass("App Parental Control Verification","Info "+ strText+" is displayed");
				}
				else
				{
					Reporter.fail("App Parental Control Verification","Info "+ strText+" is not displayed");
				}
				strText="Confirm";
				strText1=getText(confirmAge,"Confirm");
				if(fnVerifyText(strText, strText1))
				{
					Reporter.pass("App Parental Control Verification","Button Over 21 Info "+ strText+" is displayed");
				}
				else
				{
					Reporter.fail("App Parental Control Verification","Button Over 21 Info "+ strText+" is not displayed");
				}
				click(btnOver21,"Yes I am Over 21");
				Thread.sleep(5000);
			}
			else
			{
				Reporter.fail("App Parental Control","App Parental Control Info Are you above the age of 21? is not Displayed" );
			}
			if(isElementDisplayed(btnBelow21))
			{
				List<WebElement> eleListBtn=driver.findElement(btnBelow21).findElements(By.className("android.widget.TextView"));
				strText=eleListBtn.get(0).getText();
				if(fnVerifyText(strText, "No, I am not over 21"))
				{
					Reporter.pass("App Parental Control","App Parental Control Info No, I am not over 21 is Displayed" );
				}
				else
				{
					Reporter.fail("App Parental Control","App Parental Control Info No, I am not over 21 is not Displayed" );
				}	
				click(btnBelow21,"No, I am not over 21");
				Thread.sleep(5000);
				List<WebElement> eleLayoutText=driver.findElement(layoutnotOver).findElements(By.className("android.widget.TextView"));
				List<String> arrData=new ArrayList<String>();
				for(int i=0;i<eleLayoutText.size();i++)
				{
					System.out.println(eleLayoutText.get(i).getText());
					arrData=fnAddData(arrData, eleLayoutText.get(i).getText());
				}
				strText="You will not be able to access restricted content.";
				if(fnVerifyTextInList(arrData,strText))
				{
					Reporter.pass("App Parental Control Verification","Info "+ strText+" is displayed");
				}
				else
				{
					Reporter.fail("App Parental Control Verification","Info "+ strText+" is not displayed");
				}
				strText="Confirm";
				strText1=getText(confirmNotOver,"Confirm");
				if(fnVerifyText(strText, strText1))
				{
					Reporter.pass("App Parental Control Verification","Button Not Over 21 Info "+ strText+" is displayed");
				}
				else
				{
					Reporter.fail("App Parental Control Verification","Button Not Over 21 Info "+ strText+" is not displayed");
				}
			}
			else
			{
				Reporter.fail("App Parental Control","App Parental Control Info No, I am not over 21 is not Displayed" );
			}
			driver.navigate().back();
			Thread.sleep(5000);	
			driver.navigate().back();
			Thread.sleep(5000);	
		}
		catch(Exception e){Reporter.blnReportTempStatus=false;}
		if(Reporter.blnReportTempStatus)
		{
			Reporter.pass("App Parental Control","App Parental Control is displayed Successfully" );
		}
		else
		{
			Reporter.fail("App Parental Control","App Parental Control is not displayed Successfully" );
		}
	}
	
	public List<String> fnAddData(List<String> arrData,String strData)
	{
		boolean blnAdd=true;
		for(int i=0;i<arrData.size();i++)
		{
			if(arrData.get(i).equals(strData))
			{
				blnAdd=false;
			}
		}
		if(blnAdd)
		{
			arrData.add(strData);			
		}
		return arrData;
	}
}
