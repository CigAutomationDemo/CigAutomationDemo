package com.automation.ios.workflows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.reports.Reporter;

public class MeWatchListPage extends BasePage{
	//Locators
	public static By locmePage = By.name("Me");
	public static By favoritesModule = By.name("Favorites");
	public static By navBackBtn = By.name("navbar back btn");
	public static By watchLaterModule = By.name("Watchlist");
	public static By editButton= By.name("Edit");
	public static By removeButton = By.xpath("//XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton");
	public static By popUpDeleteButton = By.name("Delete");
	public static By Message=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText");
	public static By lnkDiscover=By.name("Discover");
	public static By WatchLaterTitle = By.name("WATCHLIST");
	public static By meLabel = By.id("icon me");
	public static By watchlaterLogo=By.id("empState_WatchLater");
	public static By lstFavWatHistory=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView");
	public static By confirm = By.name("Confirm");
	/***
	 * Function Name :- verifyFavoriteAndWatchLaterVideoListIsEmpty
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public  boolean VerifyWatchList() throws Throwable {
		boolean blnStatus=true;
		try {
				mePage.fnSelectMESection("watch");
				WebElement eleCom=driver.findElement(lstFavWatHistory);
				List<WebElement> eleComList=eleCom.findElements(By.xpath("XCUIElementTypeCell"));
				if(eleComList.size()>0)
				{
					Reporter.pass("Watchlist Count ", eleComList.size()+" titles are available in Watchlist page");
				}
				else
				{
					Reporter.fail("Watchlist Count ", eleComList.size()+" titles are available in Watchlist page");
					blnStatus=false;
				}
			} catch (Exception e) {
				blnStatus=false;
			}
			click(navBackBtn, "Back button");
			return blnStatus;
	
	}
	/***
	 * Function Name :- downloadscontentPlayBack
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public  boolean deleteFavoritesAndWatchLaterVideo(String title) throws Throwable {
		try{
			click(editButton, "Edit button");
		//	clickOnFavoriteVideo(title);
			click(removeButton, "Remove button");
			click(popUpDeleteButton, "Popup Delete button");
		//	waitForPleaseWaitDisappear();
			click(navBackBtn, "Back button");
			return true;
		}catch (Exception e){
			Reporter.fnPrintException(e);
			return false;
		}
	}
	/***
	 * Function Name :- fnVerifyWatchLaterScreen
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public  boolean fnVerifyWatchLaterScreen(boolean blnAnnonymous) throws Throwable
	{
		boolean blnFound=true;
		try
		{
		//	fnSelectMESection("watch");
			//boolean blnEmptyDownload=isElementDisplayed(watchlaterLogo);
			String strMessage=getText(Message,"Watch Later Message");
			boolean blnLink=isElementDisplayed(lnkDiscover);
			boolean blnHeader=isElementDisplayed(WatchLaterTitle);
			if(blnHeader)
			{
				Reporter.pass("Watch Later Screen", "Watch Later Section is displayed");
			}
			else
			{
				Reporter.fail("Watch Later Screen", "Watch Later Section is not displayed");
			}
			/*if(blnEmptyDownload)
			{
				Reporter.pass("Watch Later Screen", "Watch Later Empty Logo is displayed");
			}
			else
			{
				Reporter.fail("Watch Later Screen", "Watch Later Empty Logo is not displayed");
			}*/
			if(strMessage.contains("Movies and TV Shows that you want to watch later appear here"))
			{
				System.out.println(strMessage);
				Reporter.pass("Watch Later Screen", "Default Empty Message is displayed");
			}
			else
			{
				Reporter.fail("Watch Later Screen", "Default Empty Message is  not displayed");		
			}
			if(blnLink)
			{
				Reporter.pass("Watch Later Screen", "Discover Link is displayed");
				click(lnkDiscover,"Discover Link");
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
				Reporter.fail("Watch Later Screen", "Browse Link is  not displayed");		
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
	 * Function Name :- fnClearFavWatchLater
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public  void fnClearWatchList() throws Throwable
	{
		Reporter.info("HOOQ IOS","Verifying Clear WatchLater");
		try
		{
			//Reporter.reportStep("Clear " + strItem +" List");
			//Go to the Specific Section
			
			mePage.fnSelectMESection("watch");
			//Count the Total No of Components
			boolean blnEmptyDownload=false;
			blnEmptyDownload=isElementDisplayed(watchlaterLogo);	
			if(blnEmptyDownload)
			{
				click(navBackBtn,"Back");
				fnVerifyWatchLaterScreen(false);
			}
			else
			{
					WebElement eleCom=driver.findElement(lstFavWatHistory);
					List<WebElement> eleComList=eleCom.findElements(By.xpath("XCUIElementTypeCell"));
					if(eleComList.size()>0)
					{
						//Click on Edit  Link
						click(editButton,"Edit");
						for(int i=0;i<eleComList.size();i++)
						{
							eleComList.get(i).click();
						}
						//Click on Remove Button
						click(removeButton,"Remove");
						//Confirm 
						click(confirm,"Confirm");
						//Again Confirm the 
						//Back the Page
						click(navBackBtn,"Back");
						//Select Section 
						mePage.fnSelectMESection("watch");
						//Verify the Content	
						List<WebElement> eleComListVerify=eleCom.findElements(By.xpath("XCUIElementTypeCell"));
						if(eleComListVerify.size()>0)
						{
							Reporter.fail("Clear the WatchList", "WatchList list  is not Empty");
						}
						else
						{
							Reporter.pass("Clear the WatchList","WatchList list  is Empty");
						}
					}
					else
					{
						Reporter.pass("Clear the WatchList" , "WatchList list  is Empty");
					}
					click(navBackBtn,"Back");
					fnVerifyWatchLaterScreen(false);							
			}		
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
		}
		
		
	}
}
