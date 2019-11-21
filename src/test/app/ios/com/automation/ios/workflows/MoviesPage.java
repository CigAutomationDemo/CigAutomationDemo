package com.automation.ios.workflows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.reports.Reporter;

public class MoviesPage extends BasePage{
	//Locators
	By MoviesHeaderTitle=By.name("MOVIES");
	By tblMovies=By.xpath("//XCUIElementTypeTable");
	By navBackBtn = By.name("navbar back btn");
	By moviesCollection=By.xpath("//XCUIElementTypeCollectionView");
	
	/***
	 * Function Name :- fnVerifyMoviesSection
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
	public  boolean fnVerifyMoviesSection() throws Throwable
	{
		Reporter.info("HOOQ IOS","Verifying Movies Section");
		Reporter.blnReportTempStatus=true;
		try
		{
			commonPage.fnSelectTab("movies");
			if(isElementDisplayed(MoviesHeaderTitle,"Movies Page"))
			{
				Reporter.pass("Movies Page Screen", "Movies Page is displayed");
				WebElement eleTbl=driver.findElement(tblMovies);
				List<WebElement> eleCat=eleTbl.findElements(By.xpath("XCUIElementTypeCell"));
				if(eleCat.size() >0)
				{
					System.out.println(eleCat.size());
					Reporter.pass("Movies Page Screen",eleCat.size() +  " Collection Secton is displayed");
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
						Reporter.pass("Movies Page Screen",strCollectionName +  " Collection Secton is displayed");		
						if(eleCat.get(i).findElement(By.xpath("XCUIElementTypeButton")).getText().toLowerCase().equals("see all"))
						{
							Reporter.pass("Movies Page Screen",strCollectionName +  " Collection Secton  See All is displayed");		
						}
						else
						{
							Reporter.fail("Movies Page Screen",strCollectionName +  " Collection Secton  See All is not displayed");	
						}
						int intMoviesCollection=eleCat.get(i).findElement(By.xpath("XCUIElementTypeCollectionView")).findElements(By.xpath("XCUIElementTypeCell")).size();
						if(intMoviesCollection > 0)
						{
							Reporter.pass("Movies Page Screen",strCollectionName +  " Collection Secton Movies are displayed");
						}
						else
						{
							Reporter.fail("Movies Page Screen",strCollectionName +  " Collection Secton Movies are not displayed");	
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
						Reporter.pass("Movies Page Screen", "Section Title " + strText +" is displayed");
						List<WebElement> eleCollection=driver.findElement(moviesCollection).findElements(By.xpath("XCUIElementTypeCell"));
						if(eleCollection.size()>0)
						{
							Reporter.pass("Movies Page Screen",strText +  " Collection Secton Total Movies : "+eleCollection.size() +" is displayed");		
						}
						else
						{
							Reporter.fail("Movies Page Screen",strText +  " Collection Secton Total Movies : "+eleCollection.size() +" is displayed");	
						}
					}
					else
					{
						Reporter.fail("Movies Page Screen", "Section Title " + strText +" is displayed");
						
					}
					click(navBackBtn,"Back");
				}
			}
			else
			{
				Reporter.fail("Movies Page Screen", "Movies Page is not displayed");
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
	
	
	
	/***
	 * Function Name :- fnVerifyMoviesSectionContrntDetails() 
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
	public  boolean fnVerifyMoviesSectionContentDetails() throws Throwable
	{
		Reporter.info("HOOQ IOS","Verifying Movies Section");
		Reporter.blnReportTempStatus=true;
		try
		{
			commonPage.fnSelectTab("movies");
			if(isElementDisplayed(MoviesHeaderTitle,"Movies Page"))
			{
				Reporter.pass("Movies Page Screen", "Movies Page is displayed");
				WebElement eleTbl=driver.findElement(tblMovies);
				List<WebElement> eleCat=eleTbl.findElements(By.xpath("XCUIElementTypeCell"));
				if(eleCat.size() >0)
				{
					System.out.println(eleCat.size());
					Reporter.pass("Movies Page Screen",eleCat.size() +  " Collection Secton is displayed");
					eleCat.get(1).findElement(By.xpath("XCUIElementTypeButton")).click();
					String strText=driver.findElement(By.xpath("//XCUIElementTypeStaticText/XCUIElementTypeStaticText")).getText();
					if(strText.length()>0)
					{
						Reporter.pass("Movies Page Screen", "Section Title " + strText +" is displayed");
						List<WebElement> eleCollection=driver.findElement(moviesCollection).findElements(By.xpath("XCUIElementTypeCell"));
						if(eleCollection.size()>0)
						{
							Reporter.pass("Movies Page Screen",strText +  " Collection Secton Total Movies : "+eleCollection.size() +" is displayed");
							eleCollection.get(0).click();
						}
						else
						{
							Reporter.fail("Movies Page Screen",strText +  " Collection Secton Total Movies : "+eleCollection.size() +" is displayed");	
						}
					}
					else
					{
						Reporter.fail("Movies Page Screen", "Section Title " + strText +" is displayed");
					}
				}
			}
			else
			{
				Reporter.fail("Movies Page Screen", "Movies Page is not displayed");
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
