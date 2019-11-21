package com.automation.ios.workflows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.reports.Reporter;

public class SearchPage extends BasePage{
	//Locators
	public static By searchTextField = By.id("HQSearchSuggestionStandaloneView"); 
	public static By SearchResultTable=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeImage");
	public static By searchContent=By.xpath("//XCUIElementTypeCell");
	public static By MovieContentName=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeStaticText[1]");
	public static By closeDetails = By.id("btn close details");
	public static By cancel = By.name("Cancel");
	public static By universalSearch = By.id("main nav search");
	
	/***
	 * Function Name :- clickAndSearch
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
	public  boolean clickAndSearch(String keyword) throws Throwable {
		Reporter.info("HOOQ IOS","Verifying Search for " + keyword);
		try {
			FnClickSearch();
			type(searchTextField, keyword, "Search Inputbox");
			Thread.sleep(5000);
			List<WebElement> eleList=driver.findElements(SearchResultTable);
			System.out.println("Total size ==> " + eleList.size() );
			if(eleList.size()>0)
			{
				click(searchContent, "Search Result Content");
			}
			else
			{
				return false;
			}
			
			//click(searchBtn, "Search Button");
			commonPage.waitForPleaseWaitDisappear();
			//verifyElementDisplayed(targetTVShow(keyword), keyword);
			String strCotentverify=getText(MovieContentName, "Content Name Search "+keyword);
			if(strCotentverify.toLowerCase().contains(keyword.toLowerCase()))
			{
				return true;
			}
			else
			{
				click(closeDetails, "Close button");
				click(cancel, "Cancel button");
				click(cancel, "Cancel button");
				if(eleList.size()>0)
				{
					FnClickSearch();
					type(searchTextField, keyword, "Search Inputbox");
					List<WebElement> ele2=driver.findElements(SearchResultTable);
					System.out.println(ele2.size());
					for(int i=1;i<ele2.size();i++)
					{
						ele2=driver.findElements(SearchResultTable);
						ele2.get(i).click();
						String strCotent=getText(MovieContentName, "Content Name Search "+keyword);
						if(strCotent.toLowerCase().contains(keyword.toLowerCase()))
						{
							return true;	
						}
						else
						{
							click(closeDetails, "Close button");
							click(cancel, "Cancel button");
							click(cancel, "Cancel button");
							click(universalSearch, "Universal Search Icon");
							type(searchTextField, keyword, "Search Inputbox");
						
						}
					}
				}
				else
				{
					return false;
				}
			}
		} catch (Exception e) {
			Reporter.fnPrintException(e);
			return false;
		}
		return true;
	}
	/***
	 * Function Name :- FnClickSearch
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
	public  boolean FnClickSearch()
	{
		boolean blnStatus=true;
		try
		{
			List<WebElement> eleList=driver.findElements(By.id("icon search"));
			System.out.println("Top List" + eleList.size());
			if(eleList.size()>0)
			{
				eleList.get(0).click();
			}
			
		}
		catch(Exception e)
		{
			try{
				List<WebElement> eleSearch=driver.findElements(universalSearch);
				if(eleSearch.size()>0)
				{
					eleSearch.get(0).click();
				}
				else
				{
					blnStatus=false;
				}
			}
			catch(Exception k)
			{
				k.printStackTrace();
			}
		}
		return blnStatus;
	}
}
