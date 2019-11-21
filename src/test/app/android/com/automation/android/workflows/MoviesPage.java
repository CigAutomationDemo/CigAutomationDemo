package com.automation.android.workflows;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.automation.accelerators.ActionEngine;
import com.automation.reports.Reporter;

import io.appium.java_client.MobileElement;

public class MoviesPage extends BasePage{
	//locators
	By moviecollection=By.id("tv.hooq.android:id/discover_feed_list");
	By movieposter=By.id("tv.hooq.android:id/discover_feed_list");
	By btnmovies = By.id("tv.hooq.android:id/btnMovies");
    By playButton1 = By.id("tv.hooq.android:id/txtPlay");
    By content_poster = By.id("tv.hooq.android:id/imgPoster");
    By searchresult = By.id("tv.hooq.android:id/matchedTitlesSection");
    By content_detail = By.id("tv.hooq.android:id/txtDescription");
    By content_duration = By.id("tv.hooq.android:id/txtDuration");
    By youmayalso = By.xpath("//android.widget.TextView[@text='Similar titles']");
    By MoviesHeaderTitle=By.id("tv.hooq.android:id/toolbarTitle");
    By tblMovies=By.id("tv.hooq.android:id/epoxyRecyclerView");
    By moviesInnerHeader=By.id("tv.hooq.android:id/tvLabel");
    By innerTotalResult=By.id("tv.hooq.android:id/tvTotalResults");
    By innerHeaderLabel=By.id("tv.hooq.android:id/tvLabel");
    By seeAll=By.id("tv.hooq.android:id/txt_see_all");
    By genereTitle=By.id("tv.hooq.android:id/tvTitle");
    By innerSideTbl=By.id("tv.hooq.android:id/rvSeeAllContents");
    
	public boolean fnVerifyMoviesSection() throws Throwable {
		Reporter.info("HOOQ Android","Verifying Movies Section");
		Reporter.blnReportTempStatus=true;
		try
		{
			commonPage.fnSelectTab("movies");
			if(isElementDisplayed(MoviesHeaderTitle,"Movies Page"))
			{
				Reporter.pass("Movies Page Screen", "Movies Page is displayed");
				WebElement eleTbl=driver.findElement(tblMovies);
				List<WebElement> eleCat=eleTbl.findElements(By.className("android.widget.LinearLayout"));
				if(eleCat.size() >0)
				{
					List<String> arrData=new ArrayList<String>();
					System.out.println(eleCat.size());
					int intUp=0;
					for(int i=0;i<12;i++)
					{
						
						if(intUp==2)
						{
							swipeUpOrBottom(true);
							intUp=0;
						}
						else
						{
							intUp=intUp+1;
						}
						eleCat=eleTbl.findElements(By.className("android.widget.LinearLayout"));
						String strCollectionName =eleCat.get(i).findElement(genereTitle).getText();
						System.out.println(strCollectionName);
						String strSeeAll="NA";
						if(eleCat.get(i).findElement(seeAll).getText().toLowerCase().equals("see all"))
						{
							strSeeAll="Yes";
						}						
						int intMoviesCollection=eleCat.get(i).findElement(By.id("tv.hooq.android:id/recycler_view")).findElements(By.id("tv.hooq.android:id/image_container")).size();
						String strData=strCollectionName+"/"+strSeeAll+"/"+intMoviesCollection;
						arrData=fnGetMoviesData(arrData, strData);
					}
					if(arrData.size()>0)
					{
						Reporter.pass("Movies Section", "Movies Section Total Section :- "+ arrData.size() +" is displayed");
						for(int i=0;i<arrData.size();i++)
						{
							String[] arrNewdata=arrData.get(i).split("/");
							Reporter.pass("Movies Section", "Movies Section :- "+ arrNewdata[0] +" is displayed");
							if(arrNewdata[1].toLowerCase().contains("na"))
							{
								Reporter.fail("Movies Section", "Movies Section :- "+ arrNewdata[0] +" See All is not displayed");
							}
							else
							{
								Reporter.pass("Movies Section", "Movies Section :- "+ arrNewdata[0] +" See All is displayed");
							}
							Reporter.pass("Movies Section", "Movies Section :- "+ arrNewdata[0] +" Total Movies :- " + arrNewdata[2] +" is displayed");
						}
					}
					else
					{
						Reporter.fail("Movies Section", "Movies Section Total Section :- "+ arrData.size() +" is displayed");
					}
					for(int i=0;i<7;i++)
					{
						swipeUpOrBottom(false);
					}
					List<WebElement> eleCat1=eleTbl.findElements(By.className("android.widget.LinearLayout"));
					String strHeader1=eleCat1.get(0).findElement(genereTitle).getText();
					eleCat1.get(0).findElement(seeAll).click();
					Thread.sleep(5000);
					String strHeader2=driver.findElement(innerHeaderLabel).getText();
					if(strHeader1.toLowerCase().contains(strHeader2.toLowerCase()))
					{
						Reporter.pass("Movies Section", "Movies Section :- "+ strHeader1 +" Selected and Displayed Inner Header :- "+ strHeader2);
					}
					else
					{
						Reporter.fail("Movies Section", "Movies Section :- "+ strHeader1 +" Selected and not Displayed Inner Header :- "+ strHeader2);
					}
					String strTotalResult=driver.findElement(innerTotalResult).getText();
					if(strTotalResult.length()>0)
					{
						Reporter.pass("Movies Section", "Movies Section Total result :- " + strTotalResult +"  is displayed");
					}
					else
					{
						Reporter.fail("Movies Section", "Movies Section Total result :- " + strTotalResult +"  is not  displayed");
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
		return Reporter.blnReportTempStatus;
	}
	
	public boolean fnVerifyMoviesSectionSelectContent() throws Throwable {
		Reporter.info("HOOQ Android","Verifying Movies Section");
		Reporter.blnReportTempStatus=true;
		try
		{
			commonPage.fnSelectTab("movies");
			if(isElementDisplayed(MoviesHeaderTitle,"Movies Page"))
			{
				Reporter.pass("Movies Page Screen", "Movies Page is displayed");
				WebElement eleTbl=driver.findElement(tblMovies);
				List<WebElement> eleCat1=eleTbl.findElements(By.className("android.widget.LinearLayout"));
				String strHeader1=eleCat1.get(0).findElement(genereTitle).getText();
				eleCat1.get(0).findElement(seeAll).click();
				Thread.sleep(5000);
				String strHeader2=driver.findElement(innerHeaderLabel).getText();
				if(strHeader1.toLowerCase().contains(strHeader2.toLowerCase()))
				{
					Reporter.pass("Movies Section", "Movies Section :- "+ strHeader1 +" Selected and Displayed Inner Header :- "+ strHeader2);
				}
				else
				{
					Reporter.fail("Movies Section", "Movies Section :- "+ strHeader1 +" Selected and not Displayed Inner Header :- "+ strHeader2);
				}
				String strTotalResult=driver.findElement(innerTotalResult).getText();
				if(strTotalResult.length()>0)
				{
					Reporter.pass("Movies Section", "Movies Section Total result :- " + strTotalResult +"  is displayed");
				}
				else
				{
					Reporter.fail("Movies Section", "Movies Section Total result :- " + strTotalResult +"  is not  displayed");
				}
				List<WebElement> eleListInner=driver.findElement(innerSideTbl).findElements(By.className("android.widget.FrameLayout"));
				if(eleListInner.size()>0)
				{
					eleListInner.get(0).click();
					Reporter.pass("Movies Section", "Movies Section First TV Shows is Selected successfully.");
				}
				else
				{
					Reporter.fail("Movies Section", "Movies Section First TV Shows is not Selected");
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
		return Reporter.blnReportTempStatus;
	}


	
	

	public List<String> fnGetMoviesData(List<String> arrData,String strData)
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
