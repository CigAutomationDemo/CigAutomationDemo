package com.automation.ios.workflows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.reports.Reporter;

public class MeDownloadPage extends BasePage{
	//Locators
	By downloadSection = By.name("Downloads");
	By DownloadsTitle = By.name("DOWNLOADS");
	By navBackBtn = By.name("navbar back btn");
	By browseBtnInDownLoadSection = By.name("Browse");
	By DownloadsEditCancelbtn = By.name("Edit");
	By firstShowInDownloadSection = By.xpath("//XCUIElementTypeTableCell[1]/XCUIElementTypeButton[1]");
	By backButton = By.id("navbar back btn");
	By btnPendingDownload=By.id("icon delete pending download");
	By tblDownload=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable");
	By editButton= By.name("Edit");
	By removeButton = By.xpath("//XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton");
	By popUpDeleteButton = By.name("Delete");
	By confirm = By.name("Confirm");
	By popupDownloadLimit=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther");
	By popupDownloadLimitmsg1=By.name("Download Limit Reached");
	By popupDownloadLimitmsg2=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[2]");
	By popupDownloadLimitManageDownload=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton");
	By browsePage = By.xpath("//XCUIElementTypeTabBar/XCUIElementTypeButton[2]");
	By closeDetails = By.id("btn close details");
	By discoverCancelButton = By.id("Cancel");
	By Message=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText");
	By lnkDiscover=By.name("Discover");
	By downlloadTitle=By.id("DOWNLOADS");
	By meLabel = By.id("icon me");
	
	/***
	 * Function Name :- 
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public  boolean downloadscontentPlayBack(String description) throws Throwable
 	{
		//Reporter.reportStep(description);
		click(downloadSection,"Downloads button");
		if(isElementDisplayed(DownloadsTitle)){
 			Reporter.pass("Downloads Title", "Downloads Title  is displayed");
 		} else{
 			Reporter.fail("Downloads Title", " Downloads Title is not displayed");
 		}
 		if(isElementDisplayed(navBackBtn)){
 			Reporter.pass("DownloadsBackbtn ", "Downloads back button  is displayed");
 		} else {
 			Reporter.fail("Downloads back button", "Downloads back button is not displayed");
 		}
 		if(!isElementDisplayed(browseBtnInDownLoadSection)){
 			if(isElementDisplayed(DownloadsEditCancelbtn)){
 	 			Reporter.pass("Downloads EDIT button", "Downloads edit button  is displayed");
 	 		} else{
 	 			Reporter.fail("Downloads EDIT button", "Downloads edit button is not displayed");
 	 		}
 			click(firstShowInDownloadSection, "First show/movie in download section");
 		//	verifyVideoPlayback();
 		//	enablePlayerControl(false, true, false, false, null);
 		} else {
 			Reporter.pass("Downloads", "No videos to play in download section");
 			click(backButton,"Back button");
 		}
 		
		return true;
 	}
	
	/***
	 * Function Name :- fnClearDownloadEntry
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public  boolean fnClearDownloadEntry() throws Throwable
	{
		Reporter.info("HOOQ IOS","Verifying Clear Download");
		boolean blnClear=true;
		try
		{
			//Go to Me Section
			mePage.fnSelectMESection("down");
			if(isElementDisplayed(btnPendingDownload))
			{
				click(btnPendingDownload,"Clear Pending Downloads");
			}
			if(isElementDisplayed(navBackBtn))
			{
				//Back the Page
				click(navBackBtn,"Back");
			}
			//Go to Me Section
			mePage.fnSelectMESection("down");
			List<WebElement> eleList=driver.findElement(tblDownload).findElements(By.xpath("XCUIElementTypeCell"));
			if(eleList.size()>0)
			{
				if(isElementDisplayed(navBackBtn))
				{
					//Back the Page
					click(navBackBtn,"Back");
				}
				for(int i=0;i<eleList.size();i++)
				{
					//Go to Me Section
					mePage.fnSelectMESection("down");
					List<WebElement> eleList1=driver.findElement(tblDownload).findElements(By.xpath("XCUIElementTypeCell"));
					//Click on Edit  Link
					click(editButton,"Edit");
					eleList1.get(0).click();
					//Click on Remove Button
					click(removeButton,"Remove");
					//Confirm 
					click(confirm,"Confirm");
					//Back the Page
					click(navBackBtn,"Back");
				}				
				}
			if(isElementDisplayed(navBackBtn))
			{
				//Back the Page
				click(navBackBtn,"Back");
			}
			blnClear=fnVerifyEmpltyDownload();
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			blnClear=false;
		}
		return blnClear;
	}
	/***
	 * Function Name :- fnClearDownloadEntry
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public  boolean fnClearDownloadEntry(int intCount) throws Throwable
	{
		boolean blnClear=true;
		try
		{
			//Go to Me Section
			mePage.fnSelectMESection("down");
			if(isElementDisplayed(btnPendingDownload))
			{
				click(btnPendingDownload,"Clear Pending Downloads");
			}
			if(isElementDisplayed(navBackBtn))
			{
				//Back the Page
				click(navBackBtn,"Back");
			}
			//Go to Me Section
			mePage.fnSelectMESection("down");
			List<WebElement> eleList=driver.findElement(tblDownload).findElements(By.xpath("XCUIElementTypeCell"));
			if(eleList.size()>0)
			{
				if(isElementDisplayed(navBackBtn))
				{
					//Back the Page
					click(navBackBtn,"Back");
				}
				for(int i=0;i<intCount;i++)
				{
					//Go to Me Section
					mePage.fnSelectMESection("down");
					List<WebElement> eleList1=driver.findElement(tblDownload).findElements(By.xpath("XCUIElementTypeCell"));
					//Click on Edit  Link
					click(editButton,"Edit");
					eleList1.get(0).click();
					//Click on Remove Button
					click(removeButton,"Remove");
					//Confirm 
					click(confirm,"Confirm");
					//Back the Page
					click(navBackBtn,"Back");
				}				
				}
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			blnClear=false;
		}
		return blnClear;
	}
	
	/***
	 * Function Name :- fnCloaseDownloadScreen
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */		
	public  boolean fnCloaseDownloadScreen() throws Throwable
	{
		try
		{
			if(isElementDisplayed(popupDownloadLimit))
			{
				Reporter.pass("Downloads Screen Limit", "Downloads Limit Reached Section is displayed");
				String strText1=getText(popupDownloadLimitmsg1,"Download Limit Reached");
				String strText2=getText(popupDownloadLimitmsg2,"Download Limit Reached");
				System.out.println(strText1);
				System.out.println(strText2);
				Reporter.pass("Downloads Screen Limit",strText1 + " is displayed");
				Reporter.pass("Downloads Screen Limit",strText2 + " is displayed");
				click(popupDownloadLimitManageDownload,"Manage Download");
				click(navBackBtn,"Back From Download page");
				click(browsePage, "Browse Page");
			}
			else
			{
				if(isElementDisplayed(closeDetails))
				{
					click(closeDetails, "Close button");	
				}
				if(isElementDisplayed(discoverCancelButton))
				{
					click(discoverCancelButton,"Cancel");	
				}		
				if(isElementDisplayed(discoverCancelButton))
				{
					click(discoverCancelButton,"Cancel");	
				}	
				if(isElementDisplayed(backButton))
				{
					click(backButton,"Back");	
				}
				
			}	
		
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
		}
		return true;
	}
	/***
	 * Function Name :- fnVerifyEmpltyDownload
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public  boolean fnVerifyEmpltyDownload() throws Throwable
	{
		boolean blnFound=true;
		try
		{
			mePage.fnSelectMESection("down");
			commonPage.waitForPleaseWaitDisappear();
			//boolean blnEmptyDownload=isElementDisplayed(downloadLogo);
			String strMessage=getText(Message,"Download Message");
			boolean blnLink=isElementDisplayed(lnkDiscover);
			boolean blnHeader=isElementDisplayed(downlloadTitle);
			if(blnHeader)
			{
				Reporter.pass("Downloads Screen", "Downloads Section is displayed");
			}
			else
			{
				Reporter.fail("Downloads Screen", "Downloads Section is not displayed");
			}
			/*if(blnEmptyDownload)
			{
				Reporter.pass("Downloads Screen", "Downloads Empty Logo is displayed");
			}
			else
			{
				Reporter.fail("Downloads Screen", "Downloads Empty Logo is not displayed");
			}*/
			if(strMessage.contains("Total Downloads"))
			{
				System.out.println(strMessage);
				Reporter.pass("Downloads Screen", "Default Empty Message is displayed");
			}
			else
			{
				Reporter.fail("Downloads Screen", "Default Empty Message is  not displayed");		
			}
			if(blnLink)
			{
				Reporter.pass("Downloads Screen", "Discover Link is displayed");
				click(lnkDiscover,"Discover Link");
				commonPage.waitForPleaseWaitDisappear();
				if(isElementDisplayed(meLabel,"Discover Page"))
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
				Reporter.fail("Favorites Screen", "Browse Link is  not displayed");		
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
	 * Function Name :- fnVerifyDownloadEntry
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public  boolean fnVerifyDownloadEntry() throws Throwable
	{
		Reporter.info("HOOQ IOS","Verifying Download Screen");
		boolean blnDownload=true;
		try
		{
			mePage.fnSelectMESection("down");
			if(isElementDisplayed(btnPendingDownload))
			{
				click(btnPendingDownload,"Clear Pending Downloads");
			}
			click(navBackBtn,"Back From Download page");
			//Go to Me Section
			mePage.fnSelectMESection("down");
			List<WebElement> eleList=driver.findElement(tblDownload).findElements(By.xpath("XCUIElementTypeCell"));
			if(eleList.size()>0)
			{
				for(int j=0;j<eleList.size();j++)
				{
					String strMovieDownloadStatus="";
					List<WebElement> eleDetails=eleList.get(j).findElements(By.xpath("XCUIElementTypeText"));
					List<WebElement> eleDownloadButton=eleList.get(j).findElements(By.xpath("XCUIElementTypeButton"));
					if(eleDetails.size()>0)
					{
						String strMovieName=eleDetails.get(0).getText();
						String strMovieDetails=eleDetails.get(1).getText();
						if(eleDetails.size()>2)
						{
							strMovieDownloadStatus=eleDetails.get(2).getText();
							for(int i=0;i<5;i++)
							{
								if(strMovieDownloadStatus.contains("Watch now")==true)
								{
									break;
								}
								else
								{
									strMovieDownloadStatus=eleDetails.get(2).getText();
								}
							}
						}
						if(strMovieName.isEmpty()==false)
						{
							Reporter.pass("Verify Downloaded Movie",strMovieName + " is available in Download List");
						}
						else
						{
							Reporter.fail("Verify Downloaded Movie",strMovieName + " is not available in Download List");
							blnDownload=false;
						}
						if(strMovieDetails.isEmpty()==false)
						{
							Reporter.pass("Verify Downloaded Movie",strMovieDetails + " is available in Download List");
						}
						else
						{
							Reporter.fail("Verify Downloaded Movie",strMovieDetails + " is not available in Download List");	
							blnDownload=false;
						}
						if(eleDetails.size()>2)
						{
							if(strMovieDownloadStatus.isEmpty()==false)
							{
								Reporter.pass("Verify Movie Download Status",strMovieDownloadStatus + " is available in Download List");
							}
							else
							{
								Reporter.fail("Verify Movie Download Status",strMovieDownloadStatus + " is not available in Download List");	
								blnDownload=false;
							}
							if(eleDownloadButton.size() > 0)
							{
								Reporter.pass("Verify Downloaded Completed Button",strMovieName + " Downloaded Completed Button is available in Download List");
							}
							else
							{
								Reporter.pass("Verify Downloaded Completed Button",strMovieName + " Downloaded Completed Button is not available in Download List");	
							}
						}
					}			
			}
			}
			click(navBackBtn,"Back From Download page");
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			
		}
		return blnDownload;
	}
}
