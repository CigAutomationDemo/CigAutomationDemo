package com.automation.android.workflows;

import java.time.LocalDateTime;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.reports.Reporter;

public class MeSupportPage extends BasePage{
	//Locators
	By navBackBtn=By.id("tv.hooq.android:id/backInMainActivity");
	By meLabel=By.id("tv.hooq.android:id/ivMeBtn");
	By buildNo=By.id("tv.hooq.android:id/detail");
	By supportTbl=By.id("tv.hooq.android:id/discover_feed_list");
	By title=By.id("tv.hooq.android:id/title");
	By TopLayout=By.id("tv.hooq.android:id/appBarLayout");
	By toolBarTitle=By.id("tv.hooq.android:id/toolbarTitle");
	By webView=By.id("tv.hooq.android:id/webviewContainer");
	
	public boolean fnSelectSupportSubSection(String strSubSection) throws InterruptedException
	{
		boolean blnStatus=true;
		try
		{
			List<WebElement> eleList1=driver.findElements(supportTbl);
			System.out.println(eleList1.size());
			int Size=eleList1.size();
			List<WebElement> eleList=eleList1.get(Size-1).findElements(By.className("android.widget.RelativeLayout"));
			if(strSubSection.toLowerCase().contains("about"))
			{
				eleList.get(0).click();
			}
			else if(strSubSection.toLowerCase().contains("faq"))
			{
				eleList.get(2).click();
			}
			else if(strSubSection.toLowerCase().contains("terms"))
			{
				eleList.get(4).click();
			}
			else if(strSubSection.toLowerCase().contains("priva"))
			{
				eleList.get(6).click();
			}
			else if(strSubSection.toLowerCase().contains("cont"))
			{
				eleList.get(8).click();
			}
			else if(strSubSection.toLowerCase().contains("open"))
			{
				eleList.get(10).click();
			}
		}
		catch(Exception e){blnStatus=false;}
		Thread.sleep(10000);
		return blnStatus;
	}			
			
	
	public String fnGetSupportSubSectionText(String strSubSection)
	{
		String strText="";
		try
		{
			List<WebElement> eleList1=driver.findElements(supportTbl);
			System.out.println(eleList1.size());
			int Size=eleList1.size();
			List<WebElement> eleList=eleList1.get(Size-1).findElements(By.className("android.widget.RelativeLayout"));
			System.out.println(eleList.size());
			if(strSubSection.toLowerCase().contains("about"))
			{
				strText=eleList.get(0).findElement(title).getText();
			}
			else if(strSubSection.toLowerCase().contains("faq"))
			{
				strText=eleList.get(2).findElement(title).getText();
			}
			else if(strSubSection.toLowerCase().contains("terms"))
			{
				strText=eleList.get(4).findElement(title).getText();
			}
			else if(strSubSection.toLowerCase().contains("priva"))
			{
				strText=eleList.get(6).findElement(title).getText();
			}
			else if(strSubSection.toLowerCase().contains("cont"))
			{
				strText=eleList.get(8).findElement(title).getText();
			}
			else if(strSubSection.toLowerCase().contains("open"))
			{
				strText=eleList.get(10).findElement(title).getText();
			}
			else if(strSubSection.toLowerCase().contains("app"))
			{
				strText=eleList.get(12).findElement(title).getText();
			}
		}
		catch(Exception e){}
		System.out.println(strText);
		return strText;
	}	
			
	public String fnGetTitle()
	{
		String strHeader="";
		try
		{
			strHeader=driver.findElement(TopLayout).findElement(toolBarTitle).getText();
			System.out.println(strHeader);
		}
		catch(Exception e){}
		return strHeader;
	}
	
	public boolean fnVerifyAboutUs()
	{
		boolean blnStatus=true;
		try
		{
			List<WebElement> eleList1=driver.findElements(webView);
			System.out.println(eleList1.size());
			int Size=eleList1.size()-1;
			List<WebElement> eleList=eleList1.get(Size).findElement(By.className("android.view.View"));
			System.out.println(eleList.size());
			if(eleList.size()>0)
			{
				for(int i=0;i<eleList.size();i++)
				{
					System.out.println(i + " ==> "+ eleList.get(i));
				}
			}
		}
		catch(Exception e){blnStatus=false;}
		return blnStatus;
	}
		
	
	
			
	public boolean verifySupportPage() throws Throwable {
		Reporter.info("HOOQ Android","Verifying Support");
		mePage.fnSelectMESection("supp");
		try {
			if(fnGetSupportSubSectionText("about").contains("About Us")){
				Reporter.pass("AboutUs", "About Us button is displayed");
				if(fnSelectSupportSubSection("about"))
				{
					if(fnGetTitle().contains("About Us"))
					{
						Reporter.pass("AboutUs", "About Us Header is displayed");						
					}
					else
					{
						Reporter.pass("AboutUs", "About Us Header is not displayed");
					}
					driver.navigate().back();
				}
			
			} else {
				Reporter.fail("AboutUs", "About Us button is not available");
			}
			
			if(fnGetSupportSubSectionText("faq").contains("FAQ")){
				Reporter.pass("FAQ", "FAQ Us button is displayed");
				if(fnSelectSupportSubSection("faq"))
				{
					if(fnGetTitle().contains("FAQ"))
					{
						Reporter.pass("FAQ", "FAQ Header is displayed");						
					}
					else
					{
						Reporter.pass("FAQ", "FAQ Header is not displayed");
					}
					driver.navigate().back();
				}
			
			} else {
				Reporter.fail("FAQ", "FAQ button is not available");
			}
			
			if(fnGetSupportSubSectionText("terms").contains("Terms of Use")){
				Reporter.pass("Terms of Use", "Terms of Use Us button is displayed");
				if(fnSelectSupportSubSection("terms"))
				{
					if(fnGetTitle().contains("Terms of Use"))
					{
						Reporter.pass("Terms of Use", "Terms of Use Header is displayed");						
					}
					else
					{
						Reporter.pass("Terms of Use", "Terms of Use Header is not displayed");
					}
					driver.navigate().back();
				}
			
			} else {
				Reporter.fail("Terms of Use", "Terms of Use button is not available");
			}
			
			if(fnGetSupportSubSectionText("priva").contains("Privacy Policy")){
				Reporter.pass("Privacy Policy", "Privacy Policy button is displayed");
				if(fnSelectSupportSubSection("priva"))
				{
					if(fnGetTitle().contains("Privacy Policy"))
					{
						Reporter.pass("Privacy Policy", "Privacy Policy Header is displayed");						
					}
					else
					{
						Reporter.pass("Privacy Policy", "Privacy Policy Header is not displayed");
					}
					driver.navigate().back();
				}
			
			} else {
				Reporter.fail("Privacy Policy", "Privacy Policy button is not available");
			}
			
			if(fnGetSupportSubSectionText("cont").contains("Contact Us")){
				Reporter.pass("Contact Us", "Contact Us button is displayed");			
			} else {
				Reporter.fail("Contact Us", "Contact Us button is not available");
			}
			

			if(fnGetSupportSubSectionText("open").contains("Open Source Licences")){
				Reporter.pass("Open Source Licences", "Open Source Licences button is displayed");	
				if(fnSelectSupportSubSection("open"))
				{
					if(fnGetTitle().contains("License Details"))
					{
						Reporter.pass("License Details", "License Details Header is displayed");						
					}
					else
					{
						Reporter.pass("License Details", "License Details Header is not displayed");
					}
					driver.navigate().back();
				}
			} else {
				Reporter.fail("Open Source Licences", "Open Source Licences button is not available");
			}
			
			if(fnGetSupportSubSectionText("app").contains("App Version")){
				Reporter.pass("App Version", "App Version is displayed");	
				strBuildNo=getText(buildNo,"HOOQ Build No");
				if(strBuildNo.length()>0)
				{
					Reporter.pass("App Version", "App Version "+ strBuildNo + " is displayed");						
				}
				else
				{
					Reporter.pass("App Version", "App Version is not displayed");
				}				
			} else {
				Reporter.fail("Open Source Licences", "Open Source Licences button is not available");
			}
			
			driver.navigate().back();
		
		} catch (Exception e) {
			Reporter.fnPrintException(e);
			return false;
		}
		return true;
	}
		
	

	public String fnGetBuildNo() throws Throwable {
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

}
