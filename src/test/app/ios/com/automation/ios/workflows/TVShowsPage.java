package com.automation.ios.workflows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.reports.Reporter;

public class TVShowsPage extends BasePage{
	//Locators
	By TVShowsHeaderTitle=By.name("TV SHOWS");
	By tblMovies=By.xpath("//XCUIElementTypeTable");
	By navBackBtn = By.name("navbar back btn");
	By moviesCollection=By.xpath("//XCUIElementTypeCollectionView");
	
	/***
	 * Function Name :- fnVerifyTVShowsSection
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
	public  boolean fnVerifyTVShowsSection() throws Throwable
	{
		Reporter.info("HOOQ IOS","Verifying TVShows Section");
		Reporter.blnReportTempStatus=true;
		try
		{
			commonPage.fnSelectTab("tvshows");
			if(isElementDisplayed(TVShowsHeaderTitle,"TVShows Page"))
			{
				Reporter.pass("TVShows Page Screen", "TVShows Page is displayed");
				WebElement eleTbl=driver.findElement(tblMovies);
				List<WebElement> eleCat=eleTbl.findElements(By.xpath("XCUIElementTypeCell"));
				if(eleCat.size() >0)
				{
					System.out.println(eleCat.size());
					Reporter.pass("TVShows Page Screen",eleCat.size() +  " Collection Secton is displayed");
					int intUp=0;
					for(int i=0;i<eleCat.size();i++)
					{
						if(intUp==2)
						{
							scrollJs("down");
							intUp=0;
						}
						else
						{
							intUp=intUp+1;
						}
						String strCollectionName =eleCat.get(i).findElement(By.xpath("XCUIElementTypeStaticText")).getText();
						System.out.println(strCollectionName);
						Reporter.pass("TVShows Page Screen",strCollectionName +  " Collection Secton is displayed");		
						if(eleCat.get(i).findElement(By.xpath("XCUIElementTypeButton")).getText().toLowerCase().equals("see all"))
						{
							Reporter.pass("TVShows Page Screen",strCollectionName +  " Collection Secton  See All is displayed");		
						}
						else
						{
							Reporter.fail("TVShows Page Screen",strCollectionName +  " Collection Secton  See All is not displayed");	
						}
						int intMoviesCollection=eleCat.get(i).findElement(By.xpath("XCUIElementTypeCollectionView")).findElements(By.xpath("XCUIElementTypeCell")).size();
						if(intMoviesCollection > 0)
						{
							Reporter.pass("TVShows Page Screen",strCollectionName +  " Collection Secton TVShows are displayed");
						}
						else
						{
							Reporter.fail("TVShows Page Screen",strCollectionName +  " Collection Secton TVShows are not displayed");	
						}
					}
					for(int i=0;i<4;i++)
					{
						scrollJs("up");
					}
					eleCat.get(1).findElement(By.xpath("XCUIElementTypeButton")).click();
					String strText=driver.findElement(By.xpath("//XCUIElementTypeStaticText/XCUIElementTypeStaticText")).getText();
					if(strText.length()>0)
					{
						Reporter.pass("TVShows Page Screen", "Section Title " + strText +" is displayed");
						List<WebElement> eleCollection=driver.findElement(moviesCollection).findElements(By.xpath("XCUIElementTypeCell"));
						if(eleCollection.size()>0)
						{
							Reporter.pass("TVShows Page Screen",strText +  " Collection Secton Total Movies : "+eleCollection.size() +" is displayed");		
						}
						else
						{
							Reporter.fail("TVShows Page Screen",strText +  " Collection Secton Total Movies : "+eleCollection.size() +" is displayed");	
						}
					}
					else
					{
						Reporter.fail("TVShows Page Screen", "Section Title " + strText +" is displayed");
					}
					click(navBackBtn,"Back");
				}
			}
			else
			{
				Reporter.fail("TVShows Page Screen", "TVShows Page is not displayed");
			}
			
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			Reporter.blnReportTempStatus=false;
		}
		commonPage.fnSelectTab("Discover");
		return 	Reporter.blnReportTempStatus=true;
	}
	
	
	/***
	 * Function Name :- fnVerifyTVShowsSectionContentDetails() 
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
	public  boolean fnVerifyTVShowsSectionContentDetails() throws Throwable
	{
		Reporter.info("HOOQ IOS","Verifying TVShows Section");
		Reporter.blnReportTempStatus=true;
		try
		{
			commonPage.fnSelectTab("tvshows");
			if(isElementDisplayed(TVShowsHeaderTitle,"TVShows Page"))
			{
				Reporter.pass("TVShows Page Screen", "TVShows Page is displayed");
				WebElement eleTbl=driver.findElement(tblMovies);
				List<WebElement> eleCat=eleTbl.findElements(By.xpath("XCUIElementTypeCell"));
				if(eleCat.size() >0)
				{
					System.out.println(eleCat.size());
					Reporter.pass("TVShows Page Screen",eleCat.size() +  " Collection Secton is displayed");
					eleCat.get(1).findElement(By.xpath("XCUIElementTypeButton")).click();
					String strText=driver.findElement(By.xpath("//XCUIElementTypeStaticText/XCUIElementTypeStaticText")).getText();
					if(strText.length()>0)
					{
						Reporter.pass("TVShows Page Screen", "Section Title " + strText +" is displayed");
						List<WebElement> eleCollection=driver.findElement(moviesCollection).findElements(By.xpath("XCUIElementTypeCell"));
						if(eleCollection.size()>0)
						{
							Reporter.pass("TVShows Page Screen",strText +  " Collection Secton Total TVShows : "+eleCollection.size() +" is displayed");
							eleCollection.get(0).click();
						}
						else
						{
							Reporter.fail("TVShows Page Screen",strText +  " Collection Secton Total TVShows : "+eleCollection.size() +" is displayed");	
						}
					}
					else
					{
						Reporter.fail("TVShows Page Screen", "Section Title " + strText +" is displayed");
					}
				}
			}
			else
			{
				Reporter.fail("TVShows Page Screen", "TVShows Page is not displayed");
			}
			
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			Reporter.blnReportTempStatus=false;
		}
		commonPage.fnSelectTab("Discover");
		return Reporter.blnReportTempStatus;
	}
}
