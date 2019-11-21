package com.automation.ios.workflows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.reports.Reporter;

import io.appium.java_client.ios.IOSDriver;

public class ContentDetailsPage extends BasePage{
	//Locators
		By contentImage=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeImage[2]");
		By contentMovieName=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeStaticText[1]");
		By contentMovieDuration=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeStaticText[2]");
		By contentMovieWatchLater=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeButton");
		By contentMovieLike=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeButton");
		By contentDownload=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeButton");
		By contentWatchNow=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton");
		By contentAudio=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeStaticText[3]");
		By contentSubTitle=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeStaticText[4]");
		By contentJonour=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[6]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[4]");
		By contentMovieDescription=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeStaticText");
		By contentDirector=By.id("Director");
		By contentDirectorDetails=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[6]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[2]");
		By contentActors=By.id("Actors");
		By contentActorsDetails=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[6]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[6]");
		By contentRating=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeStaticText[2]");
		By contentReleaseYear=By.xpath("/AppiumAUT/XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeStaticText[2]");
		By contentEpisodeDescription=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeTable/XCUIElementTypeCell[4]");
		By ContentEpisodeTable=By.xpath("//XCUIElementTypeTable");
		By contentEpisodeSeasonSelect=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeButton[1]");
		By contentEpisodeSeasonDetails=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeButton[2]");
		By lblSimilerTitles=By.xpath("//XCUIElementTypeCollectionView");
		By tblOtherWatch=By.xpath("//XCUIElementTypeCollectionView");
		By lblDirector=By.id("Director");
		By popupDownloaduality=By.id("Download Quality");
		By popupDownloadQualityCheckBox=By.id("ic_checkbox_save_preference_default");
		By popUpDownloadButton=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton");
		By seasonsList=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[2]");
		By EpisodeList=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeTable");
		By popUpSeasonList=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable");
		By tvShowDownload1=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeButton[1]");
		By tvShowPlay1=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeButton[3]");
		By tvShowDownload2=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeButton[1]");
		By tvShowPlay2=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeButton[2]");
		By watchVideoButton = By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton");
		By contentLikeStatus=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeStaticText");
		By contentWatchListSelected=By.id("details_greenTick");
		By contentWatchListButton=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeButton");
		/***
		 * Function Name :- fnClickPlay
		 * Developed By  :- Pankaj Kumar
		 * Date			 :- 23-May-2019 	
		 */	
		public boolean fnClickPlay() throws Throwable
		{
			boolean blnStatus=true;
			try
			{
				blnStatus=click(watchVideoButton,"Play Video");
			}
			catch(Exception e){blnStatus=false;}
			return blnStatus;
		}
		
		
	/***
	 * Function Name :- fnVerifyContentDetailsMovie
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public  boolean fnVerifyContentDetailsMovie() throws Throwable
	{
		Reporter.info("HOOQ IOS","Verifying Content Details Movie");
		boolean blnStatus=true;
		try
		{
			List<WebElement> eleList=driver.findElements(By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeImage[2]"));
			System.out.println(eleList.size());
			if(eleList.size()>0)
			{
				Reporter.pass("Content Details Verification", "Content Image is displayed");
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Image is not displayed");
				blnStatus=false;
			}
			if(isElementDisplayed(contentMovieName))
			{
				Reporter.pass("Content Details Verification", "Content Movie is displayed");
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Movie is not displayed");
				blnStatus=false;
			}
			if(isElementDisplayed(contentMovieDuration))
			{
				Reporter.pass("Content Details Verification", "Content Movie Duration is displayed");
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Movie Duration is not displayed");
				blnStatus=false;
			}
			if(isElementDisplayed(contentMovieWatchLater))
			{
				Reporter.pass("Content Details Verification", "Content WatchList Button is displayed");
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content WatchList Button is not displayed");
				blnStatus=false;
			}
			if(isElementDisplayed(contentMovieLike))
			{
				Reporter.pass("Content Details Verification", "Content Like Button is displayed");
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Like Button is not displayed");
				blnStatus=false;
			}
			if(isElementDisplayed(contentDownload))
			{
				Reporter.pass("Content Details Verification", "Content DownLoad Button is displayed");
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Download Button is not displayed");
				blnStatus=false;
			}
			if(isElementDisplayed(contentWatchNow))
			{
				Reporter.pass("Content Details Verification", "Content Watch Now is displayed");
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Watch Now is not displayed");
				blnStatus=false;
			}
			if(isElementDisplayed(contentAudio))
			{
				Reporter.pass("Content Details Verification", "Content Audio is displayed");
				String strText=getText(contentAudio,"Audio");
				if(strText.length()>0)
				{
					Reporter.pass("Content Details Verification", "Content Audio is displayed" + strText);
				}
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Audio is not displayed");
				blnStatus=false;
			}
			if(isElementDisplayed(contentSubTitle))
			{
				Reporter.pass("Content Details Verification", "Content SubTitle is displayed");
				String strText=getText(contentSubTitle,"Sub Title");
				if(strText.length()>0)
				{
					Reporter.pass("Content Details Verification", "Content SubTitle is displayed" + strText);
				}
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content SubTitle is not displayed");
				blnStatus=false;
			}
			commonPage.fnScroll();
			if(isElementDisplayed(contentJonour))
			{
				Reporter.pass("Content Details Verification", "Content Jonour is displayed");
				String strText=getText(contentJonour,"Jonour");
				if(strText.length()>0)
				{
					Reporter.pass("Content Details Verification", "Content Jonour is displayed" + strText);
				}
			}
			if(isElementDisplayed(contentMovieDescription))
			{
				Reporter.pass("Content Details Verification", "Content Movie Description is displayed");
				String strText=getText(contentMovieDescription,"Movie Description");
				if(strText.length()>0)
				{
					Reporter.pass("Content Details Verification", "Content Description is displayed" + strText);
				}
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Movie Description is not displayed");
				blnStatus=false;
			}
			if(isElementDisplayed(contentDirector))
			{
				Reporter.pass("Content Details Verification", "Content Director is displayed");
				String strText=getText(contentDirector,"Movie Director");
				if(strText.length()>0)
				{
					Reporter.pass("Content Details Verification", "Content Director is displayed" + strText);
				}
			}
			if(isElementDisplayed(contentDirectorDetails))
			{
				Reporter.pass("Content Details Verification", "Content Director Details is displayed");
				String strText=getText(contentDirectorDetails,"Movie Director");
				if(strText.length()>0)
				{
					Reporter.pass("Content Details Verification", "Content Director Details is displayed" + strText);
				}
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Director Details is not displayed");
				blnStatus=false;
			}
			if(isElementDisplayed(contentActors))
			{
				Reporter.pass("Content Details Verification", "Content Actor is displayed");
				String strText=getText(contentActors,"Movie Actors");
				if(strText.length()>0)
				{
					Reporter.pass("Content Details Verification", "Content Actors is displayed" + strText);
				}
			}
			if(isElementDisplayed(contentActorsDetails))
			{
				Reporter.pass("Content Details Verification", "Content Actor Details is displayed");
				String strText=getText(contentActorsDetails,"Movie Actors");
				if(strText.length()>0)
				{
					Reporter.pass("Content Details Verification", "Content Actors Details is displayed" + strText);
				}
			}
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			blnStatus=false;
		}
		return blnStatus;
	}
	
	/***
	 * Function Name :- fnVerifyOtherAlsoWatch
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
	@SuppressWarnings("rawtypes")
	public  boolean fnVerifySimilerTitles() throws Throwable
	{
		Reporter.info("HOOQ IOS","Verifying Similer Titles");
	boolean blnStatus=true;
	try
	{
		/*WebElement elem=driver.findElement(By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView"));
		org.openqa.selenium.Dimension dim =elem.getSize();
		int hight=dim.getHeight();
		int width=dim.getWidth();
		int x=width/2;
		int starty=(int) (hight*.80);
		int endy=(int) (hight*.20);
		((IOSDriver) driver).swipe(x, starty, x, endy, 500);
		((IOSDriver) driver).swipe(x, starty, x, endy, 500);
		((IOSDriver) driver).swipe(x, starty, x, endy, 500);
		((IOSDriver) driver).swipe(x, starty, x, endy, 500);
		((IOSDriver) driver).swipe(x, starty, x, endy, 500);*/
		for(int i=0;i<10;i++)
		{
			scrollJs("down");
		}
		if(isElementDisplayed(lblSimilerTitles))
		{
			Reporter.pass("Similer Titles", "Similer Titles is displayed");
			List<WebElement> eleList=driver.findElement(tblOtherWatch).findElements(By.xpath("XCUIElementTypeCell"));
			System.out.println(eleList.size());
			if(eleList.size()>0)
			{
				Reporter.pass("Similer Titles","Total :" +eleList.size() + " Similer Titles Movies is displayed");
			}
		}
		else
		{
			Reporter.fail("Similer Titles","Similer Titles is not displayed");
			blnStatus=false;
		}
	}
	catch(Exception e)
	{
		Reporter.fnPrintException(e);
		blnStatus=false;
		
	}
	return blnStatus;
}
	
	/***
	 * Function Name :- fnVerifyContentDetailsTVShows
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public  boolean fnVerifyContentDetailsTVShows() throws Throwable
	{
		Reporter.info("HOOQ IOS","Verifying Content Details TVShows");
		boolean blnStatus=true;
		try
		{
			List<WebElement> eleList1=driver.findElements(By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeImage[2]"));
			System.out.println(eleList1.size());
			if(eleList1.size()>0)
			{
				Reporter.pass("Content Details Verification", "Content Image is displayed");
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Image is not displayed");
				blnStatus=false;
			}
			if(isElementDisplayed(contentMovieName))
			{
				Reporter.pass("Content Details Verification", "Content Movie is displayed");
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Movie is not displayed");
				blnStatus=false;
			}
			if(isElementDisplayed(contentMovieDuration))
			{
				Reporter.pass("Content Details Verification", "Content Movie Duration is displayed");
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Movie Duration is not displayed");
				blnStatus=false;
			}
			if(isElementDisplayed(contentMovieWatchLater))
			{
				Reporter.pass("Content Details Verification", "Content Watch Later Button is displayed");
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Watch Later Button is not displayed");
				blnStatus=false;
			}
			if(isElementDisplayed(contentMovieLike))
			{
				Reporter.pass("Content Details Verification", "Content Favorite Button is displayed");
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Favorite Button is not displayed");
				blnStatus=false;
			}
			if(isElementDisplayed(contentAudio))
			{
				Reporter.pass("Content Details Verification", "Content Audio is displayed");
				String strText=getText(contentAudio,"Audio");
				if(strText.length()>0)
				{
					Reporter.pass("Content Details Verification", "Content Audio is displayed" + strText);
				}
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Audio is not displayed");
				blnStatus=false;
			}
			if(isElementDisplayed(contentSubTitle))
			{
				Reporter.pass("Content Details Verification", "Content SubTitle is displayed");
				String strText=getText(contentSubTitle,"Sub Title");
				if(strText.length()>0)
				{
					Reporter.pass("Content Details Verification", "Content SubTitle is displayed" + strText);
				}
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content SubTitle is not displayed");
				blnStatus=false;
			}
			commonPage.fnScroll();
			if(isElementDisplayed(contentJonour))
			{
				Reporter.pass("Content Details Verification", "Content Jonour is displayed");
				String strText=getText(contentJonour,"Jonour");
				if(strText.length()>0)
				{
					Reporter.pass("Content Details Verification", "Content Jonour is displayed" + strText);
				}
			}
			if(isElementDisplayed(contentMovieDescription))
			{
				Reporter.pass("Content Details Verification", "Content Movie Description is displayed");
				String strText=getText(contentMovieDescription,"Movie Description");
				if(strText.length()>0)
				{
					Reporter.pass("Content Details Verification", "Content Description is displayed" + strText);
				}
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Movie Description is not displayed");
				blnStatus=false;
			}
			if(isElementDisplayed(contentDirector))
			{
				Reporter.pass("Content Details Verification", "Content Director is displayed");
				String strText=getText(contentDirector,"Movie Director");
				if(strText.length()>0)
				{
					Reporter.pass("Content Details Verification", "Content Director is displayed" + strText);
				}
			}
			if(isElementDisplayed(contentDirectorDetails))
			{
				Reporter.pass("Content Details Verification", "Content Director Details is displayed");
				String strText=getText(contentDirectorDetails,"Movie Director");
				if(strText.length()>0)
				{
					Reporter.pass("Content Details Verification", "Content Director Details is displayed" + strText);
				}
			}
			if(isElementDisplayed(contentActors))
			{
				Reporter.pass("Content Details Verification", "Content Actor is displayed");
				String strText=getText(contentActors,"Movie Actors");
				if(strText.length()>0)
				{
					Reporter.pass("Content Details Verification", "Content Actors is displayed" + strText);
				}
			}
			if(isElementDisplayed(contentActorsDetails))
			{
				Reporter.pass("Content Details Verification", "Content Actor Details is displayed");
				String strText=getText(contentActorsDetails,"Movie Actors");
				if(strText.length()>0)
				{
					Reporter.pass("Content Details Verification", "Content Actors Details is displayed" + strText);
				}
			}
			//click(contentEpisodeSeasonSelect,"Season Details");
			List<WebElement> eleList=driver.findElement(ContentEpisodeTable).findElements(By.xpath("XCUIElementTypeCell"));
			if(eleList.size()>0)
			{
				Reporter.pass("Content Details Verification", "Content Episode Details is displayed " + eleList.size() + "Episode Displated");
				int intSize=3;
				if(eleList.size()<3)
				{
					intSize=eleList.size();
				}
				for(int i=0;i<intSize;i++)
				{
					List<WebElement> eleDetails=eleList.get(i).findElements(By.xpath("XCUIElementTypeStaticText"));
					List<WebElement> eleButton=eleList.get(i).findElements(By.xpath("XCUIElementTypeButton"));
					if(eleDetails.size()>1)
					{
						String strText=eleDetails.get(0).getText();
						Reporter.pass("Content Details Verification", "Episode No is displayed : " + strText);
						strText=eleDetails.get(1).getText();
						Reporter.pass("Content Details Verification", "Episode Name is displayed : " + strText);
					/*	strText=eleDetails.get(2).getText();
						Reporter.pass("Content Details Verification", "Episode Duration is displayed" + strText);
						strText=eleDetails.get(3).getText();
						Reporter.pass("Content Details Verification", "Episode Description is displayed" + strText);*/
					}
					if(eleButton.size()>1)
					{
						Reporter.pass("Content Details Verification", "Episode Download Buttton is displayed");
					}
				}
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Episode is not displayed");
				blnStatus=false;
			}		
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			blnStatus=false;
		}
		return blnStatus;
	}
	
	/***
	 * Function Name :- fnCloseDownloadQualityPopUp
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public  void fnCloseDownloadQualityPopUp() throws Throwable
	{
		Reporter.info("HOOQ IOS","Verifying Download Popup Quality");
		try
		{
			if(isElementDisplayed(popupDownloaduality))
			{
				System.out.println("Download Preference Close");
				try
				{
					if(isElementDisplayed(popupDownloadQualityCheckBox))
					{
							click(popupDownloadQualityCheckBox,"Save my Preferences");
					}
				}
				catch(Exception g){}
				click(popUpDownloadButton,"Save Download Quality");
			}
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
		}
	}
	
	
	/***
	 * Function Name :- fnDownloadAndPlay
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
	public  boolean fnDownloadAndPlay(String strTVSeries,int Seasons,int EpisodeNo,String strDownloadOrPlay) throws Throwable
	{
		boolean blnStatus=false;
		try
		{
			fnSwipe(contentMovieDescription,"Down");
			fnSwipe(contentMovieDescription,"Down");
			fnSwipe(contentMovieDescription,"Down");
			//Find the SeasonsList
			List<WebElement> eleSeasons=driver.findElements(seasonsList);
			System.out.println("Season List " + eleSeasons.size());
			if(eleSeasons.size()>0)
			{
				//Click on Desired Seasons
				eleSeasons.get(0).click();
				Thread.sleep(5000);
				fnSelectSeason(strTVSeries,Seasons);
				//Find the No of Episode
				if(EpisodeNo<=2)
				{
					if(EpisodeNo==1)
					{
						if(strDownloadOrPlay.toLowerCase().equals("play"))
						{
								click(tvShowPlay1,"Play TV Episode 1");
								
						}
						else if(strDownloadOrPlay.toLowerCase().equals("download"))
						{
							click(tvShowDownload1,"Download TV Episode 1");
							
						}
					}
					else if(EpisodeNo==2)
					{
						if(strDownloadOrPlay.toLowerCase().equals("play"))
						{
								click(tvShowPlay2,"Play TV Episode 2");
								if(isElementDisplayed(tvShowPlay2))
								{
									click(tvShowPlay2,"Play TV Episode 2");
								}
						}
						else if(strDownloadOrPlay.toLowerCase().equals("download"))
						{
								click(tvShowDownload2,"Download TV Episode 2");
								if(isElementDisplayed(tvShowDownload2))
								{
									click(tvShowDownload2,"Download TV Episode 2");
								}
						}
					}
				}
				else
				{
					WebElement eleEpList=driver.findElement(EpisodeList);
					List<WebElement> eleEpisodeList=eleEpList.findElements(By.xpath("XCUIElementTypeCell"));
					System.out.println("Episode list " + eleEpisodeList.size());
					if(eleEpisodeList.size()>0)
					{
						Reporter.pass("Episode List in " + strTVSeries, eleEpisodeList.size() +" Episodes are available");
						//Start Loop for the Selecting the Episode
						for(int i=0;i<eleEpisodeList.size();i++)
						{
							//Find the Episode Name
							List<WebElement> eleEPNameAndNo=eleEpisodeList.get(i).findElements(By.xpath("XCUIElementTypeText"));
							String strEPNo=eleEPNameAndNo.get(0).getText();
							System.out.println("Episode No " + strEPNo);
							if(strEPNo.trim().equals(String.valueOf(EpisodeNo)))
							{
								String strEPName=eleEPNameAndNo.get(1).getText();
								System.out.println("Episode Name " + strEPName);
								Reporter.pass("Episode No in " + strEPNo, strEPName +" Episodes Name is Selected");
								//For Download
								List<WebElement> elePlayDownload=eleEpisodeList.get(i).findElements(By.xpath("XCUIElementTypeButton"));
								System.out.println("Download / Play Button "+ elePlayDownload.size());
								if(elePlayDownload.size()>0)
								{
										if(strDownloadOrPlay.toLowerCase().equals("download"))
										{
											elePlayDownload.get(0).click();
											//Succssfully click on Download Episode
											Reporter.pass("Download Episode No in " + strEPNo, strEPName +" Episodes Name is Download");
										}
										// For Play
										else if(strDownloadOrPlay.toLowerCase().equals("play"))
										{
											elePlayDownload.get(1).click();
											//Succssfully click on Play Button
											Reporter.pass("Play Episode No in " + strEPNo, strEPName +" Episodes Name is Play");
										}	
										
								}
								else
								{
									Reporter.fail("Play / Downlaod Episode No in " + strEPNo, strEPName +" Episodes Name is No Downlaod / Play button is available");
								}
								break;
							}
						}
					}
							
					else
					{
						Reporter.fail("Episode List in " + strTVSeries, "No Episode is Available");
					}
				}
			}
			else
			{
				Reporter.fail("Season List in " + strTVSeries, "No Season is Available");
			}		
			blnStatus=true;
		}
		
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
		}
		commonPage.waitForPleaseWaitDisappear();
		return blnStatus;
		
	}
	
	/***
	 * Function Name :- fnSwipe
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
	@SuppressWarnings("rawtypes")
	public  void fnSwipe(By loc,String strUpDown)
	{
		try
		{
			WebElement elem=driver.findElement(loc);
			org.openqa.selenium.Dimension dim =elem.getSize();
			int hight=dim.getHeight();
			int width=dim.getWidth();
			int x=width/2;
			int starty=(int) (hight*.80);
			int endy=(int) (hight*.20);
			((IOSDriver) driver).swipe(x, starty, x, endy, 500);
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
		}
	}
	
	/***
	 * Function Name :- fnSelectSeason
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
	public  void fnSelectSeason(String strTVSeries,int intSeasonNo) throws Throwable
	{
		try
		{
			if(isElementDisplayed(popUpSeasonList))
			{
				List<WebElement> eleSeasonList=driver.findElement(popUpSeasonList).findElements(By.xpath("XCUIElementTypeCell"));
				if(eleSeasonList.size()>0)
				{
					eleSeasonList.get(intSeasonNo-1).click();
					Reporter.pass("Season List in " + strTVSeries, intSeasonNo +" seasons are available");
				}
			}
			else
			{
				Reporter.pass("Season List in " + strTVSeries, intSeasonNo +" seasons are available");
				
			}
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
		}
	}
	
	/***
	 * Function Name :- fnVerifyContentDetailsPremium
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public  boolean fnVerifyContentDetailsPremium() throws Throwable
	{
		Reporter.info("HOOQ IOS","Verifying Content Details Premium Movie");
		boolean blnStatus=true;
		try
		{
			List<WebElement> eleList=driver.findElements(By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeImage[2]"));
			System.out.println(eleList.size());
			if(eleList.size()>0)
			{
				Reporter.pass("Content Details Verification", "Content Premium Movie is displayed");
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Premium Movie is not displayed");
				blnStatus=false;
			}
			if(isElementDisplayed(contentMovieName))
			{
				Reporter.pass("Content Details Verification", "Content Premium Movie is displayed");
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Premium Movie is not displayed");
				blnStatus=false;
			}
			if(isElementDisplayed(contentMovieDuration))
			{
				Reporter.pass("Content Details Verification", "Content Premium Movie Duration is displayed");
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Premium Movie Duration is not displayed");
				blnStatus=false;
			}
			if(isElementDisplayed(contentMovieWatchLater))
			{
				Reporter.pass("Content Details Verification", "Content WatchList Button is displayed");
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content WatchList Button is not displayed");
				blnStatus=false;
			}
			if(isElementDisplayed(contentMovieLike))
			{
				Reporter.pass("Content Details Verification", "Content Like Button is displayed");
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Like Button is not displayed");
				blnStatus=false;
			}
			if(isElementDisplayed(contentDownload))
			{
				Reporter.pass("Content Details Verification", "Content DownLoad Button is displayed");
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Download Button is not displayed");
				blnStatus=false;
			}
			if(isElementDisplayed(contentWatchNow))
			{
				Reporter.pass("Content Details Verification", "Content Watch Now is displayed");
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Watch Now is not displayed");
				blnStatus=false;
			}
			if(isElementDisplayed(contentAudio))
			{
				Reporter.pass("Content Details Verification", "Content Audio is displayed");
				String strText=getText(contentAudio,"Audio");
				if(strText.length()>0)
				{
					Reporter.pass("Content Details Verification", "Content Audio is displayed" + strText);
				}
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Audio is not displayed");
				blnStatus=false;
			}
			if(isElementDisplayed(contentSubTitle))
			{
				Reporter.pass("Content Details Verification", "Content SubTitle is displayed");
				String strText=getText(contentSubTitle,"Sub Title");
				if(strText.length()>0)
				{
					Reporter.pass("Content Details Verification", "Content SubTitle is displayed" + strText);
				}
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content SubTitle is not displayed");
				blnStatus=false;
			}
			commonPage.fnScroll();
			if(isElementDisplayed(contentJonour))
			{
				Reporter.pass("Content Details Verification", "Content Jonour is displayed");
				String strText=getText(contentJonour,"Jonour");
				if(strText.length()>0)
				{
					Reporter.pass("Content Details Verification", "Content Jonour is displayed" + strText);
				}
			}
			if(isElementDisplayed(contentMovieDescription))
			{
				Reporter.pass("Content Details Verification", "Content Premium Movie Description is displayed");
				String strText=getText(contentMovieDescription,"Premium Description");
				if(strText.length()>0)
				{
					Reporter.pass("Content Details Verification", "Content Description is displayed" + strText);
				}
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Premium Movie Description is not displayed");
				blnStatus=false;
			}
			if(isElementDisplayed(contentDirector))
			{
				Reporter.pass("Content Details Verification", "Content Director is displayed");
				String strText=getText(contentDirector,"Premium Director");
				if(strText.length()>0)
				{
					Reporter.pass("Content Details Verification", "Content Director is displayed" + strText);
				}
			}
			if(isElementDisplayed(contentDirectorDetails))
			{
				Reporter.pass("Content Details Verification", "Content Director Details is displayed");
				String strText=getText(contentDirectorDetails,"Premium Director");
				if(strText.length()>0)
				{
					Reporter.pass("Content Details Verification", "Content Director Details is displayed" + strText);
				}
			}
			if(isElementDisplayed(contentActors))
			{
				Reporter.pass("Content Details Verification", "Content Actor is displayed");
				String strText=getText(contentActors,"Premium Actors");
				if(strText.length()>0)
				{
					Reporter.pass("Content Details Verification", "Content Actors is displayed" + strText);
				}
			}
			if(isElementDisplayed(contentActorsDetails))
			{
				Reporter.pass("Content Details Verification", "Content Actor Details is displayed");
				String strText=getText(contentActorsDetails,"Premium Movie Actors");
				if(strText.length()>0)
				{
					Reporter.pass("Content Details Verification", "Content Actors Details is displayed" + strText);
				}
			}
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			blnStatus=false;
		}
		return blnStatus;
	}
	/***
	 * Function Name :- fnVerifyLike
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public boolean fnVerifyLike() throws Throwable
	{
		Reporter.info("HOOQ IOS","Verifying Content Details Like");
		boolean blnStatus=true;
		try
		{
			String strStatus=getText(contentLikeStatus,"Content Like Status");
			if(strStatus.toLowerCase().contains("liked"))
			{
				click(contentMovieLike,"Liked to Like");
			}
			if(isElementDisplayed(contentMovieLike))
			{
				Reporter.pass("Content Details Like", "Like Button is displayed");
				click(contentMovieLike,"Like");
				String strStatusAfter=getText(contentLikeStatus,"Content Like Status");
				if(strStatusAfter.toLowerCase().contains("liked"))
				{
					Reporter.pass("Content Details Like", "Like Button change to Liked successfully.");
				}
				else
				{
					Reporter.fail("Content Details Like", "Like Button not change to Liked.");
					blnStatus=false;
				}
				
			}
			else
			{
				Reporter.fail("Content Details Like", "Like Button is not displayed");
				blnStatus=false;
			}
		}
		catch(Exception e){
			blnStatus=false;
		}
		return blnStatus;
		
	}
	
	/***
	 * Function Name :- fnVerifySeasonEpisode
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public boolean fnVerifySeasonEpisode(boolean blnEpisode) throws Throwable
	{
		Reporter.info("HOOQ IOS","Verifying Content Details Season Episode");
		boolean blnStatus=true;
		try
		{	
			commonPage.fnScroll();
			boolean blnEpisodeStatus=isElementDisplayed(ContentEpisodeTable);
			if(blnEpisode)
			{
				if(blnEpisodeStatus)
				{
					Reporter.pass("Content Details Season Episode", "Seasons and Episodes are displayed successfully.");
				}
				else
				{
					Reporter.fail("Content Details Season Episode", "Seasons and Episodes are not displayed.");
					blnStatus=false;
				}
			}
			else
			{
				if(blnEpisodeStatus==false)
				{
					Reporter.pass("Content Details Season Episode", "Seasons and Episodes are not displayed successfully.");
				}
				else
				{
					Reporter.fail("Content Details Season Episode", "Seasons and Episodes are displayed.");
					blnStatus=false;
				}
			}
		}
		catch(Exception e){
			blnStatus=false;
		}
		return blnStatus;
		
	}
	
	
	/***
	 * Function Name :- fnVerifyLike
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public boolean fnVerifyWatchList() throws Throwable
	{
		Reporter.info("HOOQ IOS","Verifying Content Details WatchList");
		boolean blnStatus=true;
		try
		{
			if(isElementDisplayed(contentWatchListSelected))
			{
				click(contentWatchListSelected,"WatchList Selected to Un-WatchList");
			}
			if(isElementDisplayed(contentWatchListSelected)==false)
			{
				Reporter.pass("Content Details Watchlist", "Watchlist Button is displayed");
				click(contentWatchListButton,"Make Watch List");
				if(isElementDisplayed(contentWatchListSelected))
				{
					Reporter.pass("Content Details Watchlist", "Watchlist Button change to Watchlist Selected successfully.");
				}
				else
				{
					Reporter.fail("Content Details Watchlist", "Watchlist Button not change to Watchlist Selected.");
					blnStatus=false;
				}
				
			}
			else
			{
				Reporter.fail("Content Details Watchlist", "Watchlist Button is not displayed");
				blnStatus=false;
			}
		}
		catch(Exception e){
			blnStatus=false;
		}
		return blnStatus;
		
	}
	
	
}
