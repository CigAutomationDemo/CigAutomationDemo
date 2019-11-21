package com.automation.android.workflows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.automation.reports.Reporter;

public class MeDownloadPage extends BasePage{
	//Locators
	By downloadTopLayout=By.id("tv.hooq.android:id/appBarLayout");
	By DownloadTitle=By.id("tv.hooq.android:id/toolbarTitle");
	By EmptyDownload=By.id("tv.hooq.android:id/emptyStateIcon");
	By strEmptyDec=By.id("tv.hooq.android:id/emptyStateDesc");
	By blnLink=By.id("tv.hooq.android:id/btnAction");
	By headerLogo=By.id("tv.hooq.android:id/headerLogo");
	By lstDownload=By.id("tv.hooq.android:id/ervDownloadsList");
	By downloadCounter=By.id("tv.hooq.android:id/esDownloadCounter");		
	By editButton=By.id("tv.hooq.android:id/btnEdit");
	By removeButton=By.id("tv.hooq.android:id/btnRemove");
	By confirm=By.id("tv.hooq.android:id/okay");
	
	
	

	public boolean fnClearDownloadEntry() throws Throwable {
		boolean blnStatus=true;
		Reporter.info("HOOQ Android","Verifying Clear Download");
		try
		{
			mePage.fnSelectMESection("down");
			Thread.sleep(10000);
			//Count the Total No of Components
			String strHeader=driver.findElement(downloadTopLayout).findElement(DownloadTitle).getText();
			System.out.println(strHeader);
			if(strHeader.toLowerCase().contains("downloads"))
			{
				Reporter.pass("Downloads Screen", "Downloads Section is displayed");
			}
			else
			{
				Reporter.fail("Downloads Screen", "Downloads Section is not displayed");
			}
			if(isElementDisplayed(EmptyDownload))
			{
				driver.navigate().back();
				fnVerifyDownloadListScreen(false);
			}
			else
			{
					driver.navigate().back();
					boolean blnDelete=true;
					while(blnDelete)
					{
						mePage.fnSelectMESection("down");
						WebElement eleCom=driver.findElement(lstDownload);
						List<WebElement> eleComList=eleCom.findElements(By.className("android.widget.RelativeLayout"));
						if(eleComList.size()>0)
						{
							//Click on Edit  Link
							click(editButton,"Edit");
							eleComList.get(0).click();
							//Click on Remove Button
							click(removeButton,"Remove");
							//Confirm 
							click(confirm,"Confirm");
							//Back the Page
							driver.navigate().back();
						}
						else
						{
							blnDelete=false;
						}
					}
					//Verify the Content	
					WebElement eleCom=driver.findElement(lstDownload);
					List<WebElement> eleComListVerify=eleCom.findElements(By.className("android.widget.RelativeLayout"));
					if(eleComListVerify.size()>0)
					{
						Reporter.fail("Clear the Downloads", "Downloads list  is not Empty");
					}
					else
					{
						Reporter.pass("Clear the Downloads","Downloads list  is Empty");
					}
					driver.navigate().back();
					driver.navigate().back();
					fnVerifyDownloadListScreen(false);							
			}		
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
		}
		return blnStatus;
	}
		
	public boolean fnVerifyDownloadListCount(boolean anonyous) throws Throwable {
		boolean blnFound=true;
		try
		{
			Reporter.info("HOOQ Android","Verifying Download");
			mePage.fnSelectMESection("down");
			//Count the Total No of Components
			String strHeader=driver.findElement(downloadTopLayout).findElement(DownloadTitle).getText();
			System.out.println(strHeader);
			if(strHeader.toLowerCase().contains("downloads"))
			{
				Reporter.pass("Downloads Screen", "Downloads Section is displayed");
			}
			else
			{
				Reporter.fail("Downloads Screen", "Downloads Section is not displayed");
			}
			WebElement eleCom=driver.findElement(lstDownload);
			List<WebElement> eleComList=eleCom.findElements(By.className("android.widget.RelativeLayout"));
			if(eleComList.size()>0)
			{
				blnFound=true;
			}
			else
			{
				blnFound=false;
			}
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			blnFound=false;
		}
		return blnFound;
	}

	

	public boolean fnVerifyDownloadListScreen(boolean anonyous) throws Throwable {
		boolean blnFound=true;
		try
		{
			Reporter.info("HOOQ Android","Verifying Download Screen");
			mePage.fnSelectMESection("down");
			//Count the Total No of Components
			String strHeader=driver.findElement(downloadTopLayout).findElement(DownloadTitle).getText();
			System.out.println(strHeader);
			if(strHeader.toLowerCase().contains("downloads"))
			{
				Reporter.pass("Downloads Screen", "Downloads Section is displayed");
			}
			else
			{
				Reporter.fail("Downloads Screen", "Downloads Section is not displayed");
			}
			if(isElementDisplayed(EmptyDownload))
			{
				Reporter.pass("Downloads Screen", "Downloads Empty Logo is displayed");
			}
			else
			{
				Reporter.fail("Downloads Screen", "Downloads Empty Logo is not displayed");
			}
			String strMessage=getText(strEmptyDec,"Downloads Message");
			if(strMessage.contains("Movies and TV Shows that you download appear here."))
			{
				Reporter.pass("Downloads Screen", "Default Empty Message is displayed");
			}
			else
			{
				Reporter.fail("Downloads Screen", "Default Empty Message is  not displayed");		
			}
			if(isElementDisplayed(blnLink))
			{
				Reporter.pass("Downloads Screen", "Discover Link is displayed");
				click(blnLink,"Discover Link");
				if(isElementDisplayed(headerLogo))
				{
					Reporter.pass("Discover Page Screen", "Discover Page is displayed");
				}
				else
				{
					Reporter.fail("Discover Page Screen", "Discover Page is not displayed");
				}
			}
			else
			{
				Reporter.fail("Downloads Screen", "Discover Link is  not displayed");		
			}
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			blnFound=false;
		}
		return blnFound;
	}

	public boolean fnSelectDownloadContentFromDownloadSection() throws Throwable {
		boolean blnFound=true;
		try
		{
			Reporter.info("HOOQ Android","Selecting Content From Download Section");
			mePage.fnSelectMESection("down");
			//Count the Total No of Components
			String strHeader=driver.findElement(downloadTopLayout).findElement(DownloadTitle).getText();
			System.out.println(strHeader);
			if(strHeader.toLowerCase().contains("downloads"))
			{
				Reporter.pass("Downloads Screen", "Downloads Section is displayed");
			}
			else
			{
				Reporter.fail("Downloads Screen", "Downloads Section is not displayed");
			}
			WebElement eleCom=driver.findElement(lstDownload);
			List<WebElement> eleComList=eleCom.findElements(By.className("android.widget.RelativeLayout"));
			if(eleComList.size()>0)
			{
				eleComList.get(0).click();
				blnFound=true;
			}
			else
			{
				blnFound=false;
			}
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			blnFound=false;
		}
		return blnFound;
	}
	
	public boolean fnDownloadEntryEdit() throws Throwable {
		boolean blnStatus=true;
		Reporter.blnReportTempStatus=true;
		Reporter.info("HOOQ Android","Verifying Download Edit");
		try
		{
			mePage.fnSelectMESection("down");
			//Count the Total No of Components
			String strHeader=driver.findElement(downloadTopLayout).findElement(DownloadTitle).getText();
			System.out.println(strHeader);
			if(strHeader.toLowerCase().contains("downloads"))
			{
				Reporter.pass("Downloads Screen", "Downloads Section is displayed");
			}
			else
			{
				Reporter.fail("Downloads Screen", "Downloads Section is not displayed");
			}
			driver.navigate().back();			
			mePage.fnSelectMESection("down");
			WebElement eleCom=driver.findElement(lstDownload);
			List<WebElement> eleComList=eleCom.findElements(By.className("android.widget.RelativeLayout"));
			if(eleComList.size()>0)
			{
				//Click on Edit  Link
				if(click(editButton,"Edit"))
				{
					Reporter.pass("Download Edit","Download Edit Button is displayed and click Successfully");
					eleComList.get(0).click();
				}
				else
				{
					Reporter.fail("Download Edit","Download Edit Button is not displayed and not click");
				}
				//Click on Remove Button
				if(click(removeButton,"Remove"))
				{
					Reporter.pass("Download Remove","Download Remove Button is displayed and click Successfully");					
				}
				else
				{
					Reporter.fail("Download Remove","Download Remove Button is not displayed and not click");
				}
				//Confirm 
				if(click(confirm,"Confirm"))
				{
					Reporter.pass("Download Confirm","Download Confirm Button is displayed and click Successfully");					
				}
				else
				{
					Reporter.fail("Download Confirm","Download Confirm Button is not displayed and not click");
				}
				//Back the Page
				driver.navigate().back();
			}
			mePage.fnSelectMESection("down");
			//Verify the Content	
			WebElement eleComVerify=driver.findElement(lstDownload);
			List<WebElement> eleComListVerify=eleComVerify.findElements(By.className("android.widget.RelativeLayout"));
			if(eleComListVerify.size()>0)
			{
				Reporter.fail("Clear the Downloads", "Downloads list  is not Empty");
			}
			else
			{
				Reporter.pass("Clear the Downloads","Downloads list  is Empty");
			}
			driver.navigate().back();
			driver.navigate().back();										
		}
		catch(Exception e)
		{
			Reporter.blnReportTempStatus=false;
		}
		blnStatus=Reporter.blnReportTempStatus;
		return blnStatus;
	}
	
}
