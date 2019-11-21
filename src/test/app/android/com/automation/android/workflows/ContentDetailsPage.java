package com.automation.android.workflows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.googledrive.GoogleDriveAPI;
import com.automation.reports.Reporter;

import io.appium.java_client.ios.IOSDriver;

public class ContentDetailsPage extends BasePage{
	//Locators
	 By playButton = By.id("tv.hooq.android:id/txtPlay");
	 By matchResult= By.id("tv.hooq.android:id/matchedTitlesListView");
	 By imagePoster=By.id("tv.hooq.android:id/imgPoster");
	 By contentMovieName=By.id("tv.hooq.android:id/txtAssetTitle");
	 By contentDuration=By.id("tv.hooq.android:id/txtDuration");
	 By contentWatchList=By.id("tv.hooq.android:id/txtWatchList");
	 By contentMovieLike=By.id("tv.hooq.android:id/txtRate");
	 By contentDownload=By.id("tv.hooq.android:id/txtDownload");
	 By contentWatchNow=By.id("tv.hooq.android:id/txtPlay");
	 By contentAudio=By.id("tv.hooq.android:id/txtAudio");
	 By contentSubTitle=By.id("tv.hooq.android:id/txtSubtitle");
	 By contentMovieDescription=By.id("tv.hooq.android:id/txtDescription");
	 By contentJonour=By.id("tv.hooq.android:id/txtCategoryList");
	 By contentDirector=By.id("tv.hooq.android:id/txtDirectoryLabel");
	 By contentDirectorDetails=By.id("tv.hooq.android:id/txtDirectorList");
	 By contentActors=By.id("tv.hooq.android:id/txtActorLabel");
	 By contentActorsDetails=By.id("tv.hooq.android:id/txtActorList");
	 By lblSimilerTitles=By.id("tv.hooq.android:id/txtSimilarTitileLabel");
	 By tblOtherWatch=By.id("tv.hooq.android:id/recycleSimilarTitleList");
	 By seasonDetails=By.id("tv.hooq.android:id/txtSeason");
	 By episodeList=By.id("tv.hooq.android:id/recycleSeasonList");
	 By episodeNumber=By.id("tv.hooq.android:id/episode_number");
	 By episodeName=By.id("tv.hooq.android:id/episode_name");
	 By episodeDownload=By.id("tv.hooq.android:id/button_download");
	 By episodePlay=By.id("tv.hooq.android:id/button_play");
	 By episodeDuration=By.id("tv.hooq.android:id/duration");
	 By episodeDescription=By.id("tv.hooq.android:id/description");
	 By downloadDialog=By.id("tv.hooq.android:id/dialogContentLayout");
	 By downloadPopupInfo=By.id("tv.hooq.android:id/title");
	 By qualityLow=By.id("tv.hooq.android:id/quality_low");
	 By qualityHigh=By.id("tv.hooq.android:id/quality_high");
	 By qualityMedium=By.id("tv.hooq.android:id/quality_medium");
	 By prefCheckBox=By.id("tv.hooq.android:id/pref_checkbox");
	 By prefCheckBoxInfo=By.id("tv.hooq.android:id/save_pref");
	 By prefDownload=By.id("tv.hooq.android:id/selection_done");
	 By playTrailer=By.id("tv.hooq.android:id/txtTrailer");
	 By rentPageWatchNow=By.id("tv.hooq.android:id/txtTvodRedeem");
	 
	 public boolean fnMakeWatchList() throws Throwable
	 {
		 boolean blnStatus=true;
		Reporter.info("HOOQ Android","Verifying Content Details Make WatchList");
		 try
		 {
			if(isElementDisplayed(contentWatchList))
			{
				click(contentWatchList,"Make WatchList");
			}
		 }
		 catch(Exception e){blnStatus=false;}
		 return blnStatus;
	 }
	 
	 public boolean fnDownloadMovies() throws Throwable
	 {
		 boolean blnStatus=true;
		Reporter.info("HOOQ Android","Verifying Content Details Make Download Movies");
		 try
		 {
			if(isElementDisplayed(contentDownload))
			{
				click(contentDownload,"Download Movies");
			}
		 }
		 catch(Exception e){blnStatus=false;}
		 return blnStatus;
	 }
	 
	 public boolean fnDownloadTVShows() throws Throwable
	 {
		 boolean blnStatus=true;
		Reporter.info("HOOQ Android","Verifying Content Details Make Download TVShows");
		 try
		 {
			swipeUpOrBottom(true);
			if(isElementDisplayed(episodeList))
			{
				List<WebElement> eleList=driver.findElement(episodeList).findElements(By.className("android.widget.RelativeLayout"));
				if(eleList.size()>0)
				{
					Reporter.pass("Content Details Verification", "Episode Details is displayed");
					String strEpisodeNo=eleList.get(0).findElement(episodeNumber).getText();
					String strEpisodeName=eleList.get(0).findElement(episodeName).getText();
					List<WebElement> eleDownload=eleList.get(0).findElements(episodeDownload);
					List<WebElement> elePlay=eleList.get(0).findElements(episodePlay);
					String strEpisodeDuration=eleList.get(0).findElement(episodeDuration).getText();
					String strEpisodeDescription=eleList.get(0).findElement(episodeDescription).getText();
					if(strEpisodeNo.length()>0)
					{
						Reporter.pass("Content Details Verification", "Episode No :- " + strEpisodeNo +" is displayed");
					}
					else
					{
						Reporter.fail("Content Details Verification", "Episode No is not displayed");
						blnStatus=false;
					}
					if(strEpisodeName.length()>0)
					{
						Reporter.pass("Content Details Verification", "Episode Name :- " + strEpisodeName +" is displayed");
					}
					else
					{
						Reporter.fail("Content Details Verification", "Episode Name is not displayed");
						blnStatus=false;
					}
					if(strEpisodeDuration.length()>0)
					{
						Reporter.pass("Content Details Verification", "Episode Duration :- " + strEpisodeDuration +" is displayed");
					}
					else
					{
						Reporter.fail("Content Details Verification", "Episode Duration is not displayed");
						blnStatus=false;
					}
					if(strEpisodeDescription.length()>0)
					{
						Reporter.pass("Content Details Verification", "Episode Description :- " + strEpisodeDescription +" is displayed");
					}
					else
					{
						Reporter.fail("Content Details Verification", "Episode Description is not displayed");
						blnStatus=false;
					}
					if(elePlay.size()>0)
					{
						Reporter.pass("Content Details Verification", "Episode Play Button is displayed");
					}
					else
					{
						Reporter.fail("Content Details Verification", "Episode Play Button is not displayed");
						blnStatus=false;
					}
					if(eleDownload.size()>0)
					{
						Reporter.pass("Content Details Verification", "Episode Download Button is displayed");
						eleDownload.get(0).click();
						Thread.sleep(10000);
					}
					else
					{
						Reporter.fail("Content Details Verification", "Episode Download Button is not displayed");
						blnStatus=false;
					}
					
				}
				else
				{
					Reporter.fail("Content Details Verification", "Episode Details is not displayed");
					blnStatus=false;
				}
			}
			else
			{
				Reporter.fail("Content Details Verification", "Episode Details is not displayed");
				blnStatus=false;
			}
		 }
		 catch(Exception e){blnStatus=false;}
		 return blnStatus;
	 }
	 
	 
	 
	 
	public boolean fnVerifyContentDetailsMovie() throws Throwable {
		Reporter.info("HOOQ Android","Verifying Content Details Movie");
		boolean blnStatus=true;
		try
		{
			if(isElementDisplayed(imagePoster))
			{
				Reporter.pass("Content Details Verification", "Content Image is displayed");
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Image is not displayed");
				blnStatus=false;
			}
			String strMovieName=getText(contentMovieName,"Movie Title");
			if(strMovieName.length()>0)
			{
				Reporter.pass("Content Details Verification", "Content Movie Title " + strMovieName + " is displayed");
				
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Movie Title is not displayed");
				blnStatus=false;
			}
			String strMovieDuration=getText(contentDuration,"Content Duration");
			if(strMovieDuration.length()>0)
			{
				Reporter.pass("Content Details Verification", "Content Movie Duration " + strMovieDuration + " is displayed");
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Movie Duration is not displayed");
				blnStatus=false;
			}
			if(isElementDisplayed(contentWatchList))
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
			swipeUpOrBottom(true);
			if(isElementDisplayed(contentJonour))
			{
				Reporter.pass("Content Details Verification", "Content Jonour is displayed");
				String strText=getText(contentJonour,"Jonour");
				if(strText.length()>0)
				{
					Reporter.pass("Content Details Verification", "Content Jonour is displayed" + strText);
				}
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Jonour is not displayed");
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
			else
			{
				Reporter.fail("Content Details Verification", "Content Director is not displayed");
				blnStatus=false;
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
			else
			{
				Reporter.fail("Content Details Verification", "Content Actor is not displayed");
				blnStatus=false;
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
			else
			{
				Reporter.fail("Content Details Verification", "Content Actor Details is not displayed");
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

	public boolean fnVerifyContentDetailsRent() throws Throwable {
		Reporter.info("HOOQ Android","Verifying Content Details Rent");
		boolean blnStatus=true;
		try
		{
			if(isElementDisplayed(imagePoster))
			{
				Reporter.pass("Content Details Verification", "Content Image is displayed");
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Image is not displayed");
				blnStatus=false;
			}
			String strMovieName=getText(contentMovieName,"Rent Movie Title");
			if(strMovieName.length()>0)
			{
				Reporter.pass("Content Details Verification", "Content Rent Movie Title " + strMovieName + " is displayed");
				
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Movie Title is not displayed");
				blnStatus=false;
			}
			String strMovieDuration=getText(contentDuration,"Content Duration");
			if(strMovieDuration.length()>0)
			{
				Reporter.pass("Content Details Verification", "Content Rent Movie Duration " + strMovieDuration + " is displayed");
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Rent Movie Duration is not displayed");
				blnStatus=false;
			}
			if(isElementDisplayed(contentWatchList))
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
			if(isElementDisplayed(rentPageWatchNow))
			{
				Reporter.pass("Content Details Verification", "Content Rent Button is displayed");
				String strText=getText(rentPageWatchNow,"Rent Info");
				System.out.println(strText);
				if(strText.toLowerCase().equals("redeem your ticket"))
				{
					Reporter.pass("Content Details Verification", "Redeem your ticket is displayed because Ticket is available.");
				}
				else
				{
					blnStatus=fnVerifyTVODPrice();
				}
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Rent Button is not displayed");
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
			swipeUpOrBottom(true);
			if(isElementDisplayed(contentJonour))
			{
				Reporter.pass("Content Details Verification", "Content Jonour is displayed");
				String strText=getText(contentJonour,"Jonour");
				if(strText.length()>0)
				{
					Reporter.pass("Content Details Verification", "Content Jonour is displayed" + strText);
				}
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Jonour is not displayed");
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
			else
			{
				Reporter.fail("Content Details Verification", "Content Director is not displayed");
				blnStatus=false;
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
			else
			{
				Reporter.fail("Content Details Verification", "Content Actor is not displayed");
				blnStatus=false;
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
			else
			{
				Reporter.fail("Content Details Verification", "Content Actor Details is not displayed");
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
	
	public boolean fnVerifyTVODPrice() throws Throwable
	{
		boolean blnStatus=true;
		try
		{
			String strRentText=getText(rentPageWatchNow,"Rent Info");
			System.out.println(strRentText);
			String spreadsheetId=objData.SHEET_ID;
			int intRowNo=2;
			String contentRange = "TVOD_Content"+"!F"+intRowNo+":F"+intRowNo;
			String strText=GoogleDriveAPI.fnGetData(spreadsheetId,contentRange);
			System.out.println("TVOD Price ==> " + strText);
			String strPrice="Rent for ";
			if(objData.COUNTRY.toLowerCase().equals("in"))
			{
				strPrice=strPrice+"INR";
			}
			else if(objData.COUNTRY.toLowerCase().equals("sg"))
			{
				strPrice=strPrice+"SGD";
			}
			else if(objData.COUNTRY.toLowerCase().equals("ph"))
			{
				strPrice=strPrice+"PHP";
			}
			else if(objData.COUNTRY.toLowerCase().equals("th"))
			{
				strPrice=strPrice+"THB";
			}
			else if(objData.COUNTRY.toLowerCase().equals("id"))
			{
				strPrice=strPrice+"IDR";
			}
			strPrice=strPrice+" "+strText;
			if(strRentText.toLowerCase().equals(strPrice.toLowerCase()))
			{
				Reporter.pass("TVOD Price Verification", "TVOD Expected Price :- " + strRentText + " TVOD Actual Price :- " + strPrice);
			}
			else
			{
				Reporter.fail("TVOD Price Verification", "TVOD Expected Price :- " + strRentText + " TVOD Actual Price :- " + strPrice);
				blnStatus=false;
			}
		}
		catch(Exception e){blnStatus=false;}
		return blnStatus;
	}
	
	
	public boolean fnVerifysimilartitles() throws Throwable {
		Reporter.info("HOOQ Android","Verifying Similer Titles");
		boolean blnStatus=true;
		try
		{
			for(int i=0;i<10;i++)
			{
				swipeUpOrBottom(true);
			}
			if(isElementDisplayed(lblSimilerTitles))
			{
				Reporter.pass("Similer Titles", "Similer Titles is displayed");
				List<WebElement> eleList=driver.findElement(tblOtherWatch).findElements(By.className("android.widget.RelativeLayout"));
				System.out.println(eleList.size());
				if(eleList.size()>0)
				{
					Reporter.pass("Similer Titles","Total :" +eleList.size() + " Similer Titles Movies is displayed");
				}
			}
			else
			{
				Reporter.fail("Similer Titles", "Similer Titles is not displayed");
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
	
	
	
	public boolean playVideo() throws Throwable
	{
		boolean blnStatus=true;
		try
		{
	 		click(playButton,"Watch Now");
	 		
		}
		catch(Exception e){blnStatus=false;}
		return blnStatus;
	}
	
	public boolean playTrailer() throws Throwable
	{
		boolean blnStatus=true;
		try
		{
	 		click(playTrailer,"Play Trailer");
	 		
		}
		catch(Exception e){blnStatus=false;}
		return blnStatus;
	}
	
	
	public boolean fnVerifyContentDetailsTVShows() throws Throwable {
		Reporter.info("HOOQ Android","Verifying Content Details TVShows");
		boolean blnStatus=true;
		try
		{
			if(isElementDisplayed(imagePoster))
			{
				Reporter.pass("Content Details Verification", "Content Image is displayed");
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Image is not displayed");
				blnStatus=false;
			}
			String strMovieName=getText(contentMovieName,"TVShows Title");
			if(strMovieName.length()>0)
			{
				Reporter.pass("Content Details Verification", "Content TVShows Title " + strMovieName + " is displayed");
				
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content TVShows Title is not displayed");
				blnStatus=false;
			}
			String strMovieDuration=getText(contentDuration,"Content Duration");
			if(strMovieDuration.length()>0)
			{
				Reporter.pass("Content Details Verification", "Content TVShows Duration " + strMovieDuration + " is displayed");
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content TVShows Duration is not displayed");
				blnStatus=false;
			}
			if(isElementDisplayed(contentWatchList))
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
			if(isElementDisplayed(contentMovieDescription))
			{
				Reporter.pass("Content Details Verification", "Content TVShows Description is displayed");
				String strText=getText(contentMovieDescription,"TVShows Description");
				if(strText.length()>0)
				{
					Reporter.pass("Content Details Verification", "Content Description is displayed" + strText);
				}
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content TVShows Description is not displayed");
				blnStatus=false;
			}
			swipeUpOrBottom(true);
			if(isElementDisplayed(contentJonour))
			{
				Reporter.pass("Content Details Verification", "Content Jonour is displayed");
				String strText=getText(contentJonour,"Jonour");
				if(strText.length()>0)
				{
					Reporter.pass("Content Details Verification", "Content Jonour is displayed" + strText);
				}
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Jonour is not displayed");
				blnStatus=false;
			}
			
			if(isElementDisplayed(contentDirector))
			{
				Reporter.pass("Content Details Verification", "Content Director is displayed");
				String strText=getText(contentDirector,"TVShows Director");
				if(strText.length()>0)
				{
					Reporter.pass("Content Details Verification", "Content Director is displayed" + strText);
				}
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Director is not displayed");
				blnStatus=false;
			}
			if(isElementDisplayed(contentDirectorDetails))
			{
				Reporter.pass("Content Details Verification", "Content Director Details is displayed");
				String strText=getText(contentDirectorDetails,"TVShows Director");
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
				String strText=getText(contentActors,"TVShows Actors");
				if(strText.length()>0)
				{
					Reporter.pass("Content Details Verification", "Content Actors is displayed" + strText);
				}
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Actor is not displayed");
				blnStatus=false;
			}
			if(isElementDisplayed(contentActorsDetails))
			{
				Reporter.pass("Content Details Verification", "Content Actor Details is displayed");
				String strText=getText(contentActorsDetails,"TVShows Actors");
				if(strText.length()>0)
				{
					Reporter.pass("Content Details Verification", "Content Actors Details is displayed" + strText);
				}
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Actor Details is not displayed");
				blnStatus=false;
			}
			//TV Shows Details
			if(isElementDisplayed(seasonDetails))
			{
				Reporter.pass("Content Details Verification", "Season Details is displayed");
				String strText=getText(contentActorsDetails,"TVShows Actors");
				if(strText.length()>0)
				{
					Reporter.pass("Content Details Verification", "Content Season Details is displayed" + strText);
				}
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Season Details is not displayed");
				blnStatus=false;
			}
			if(isElementDisplayed(episodeList))
			{
				List<WebElement> eleList=driver.findElement(episodeList).findElements(By.className("android.widget.RelativeLayout"));
				if(eleList.size()>0)
				{
					Reporter.pass("Content Details Verification", "Episode Details is displayed");
					String strEpisodeNo=eleList.get(0).findElement(episodeNumber).getText();
					String strEpisodeName=eleList.get(0).findElement(episodeName).getText();
					List<WebElement> eleDownload=eleList.get(0).findElements(episodeDownload);
					List<WebElement> elePlay=eleList.get(0).findElements(episodePlay);
					String strEpisodeDuration=eleList.get(0).findElement(episodeDuration).getText();
					String strEpisodeDescription=eleList.get(0).findElement(episodeDescription).getText();
					if(strEpisodeNo.length()>0)
					{
						Reporter.pass("Content Details Verification", "Episode No :- " + strEpisodeNo +" is displayed");
					}
					else
					{
						Reporter.fail("Content Details Verification", "Episode No is not displayed");
						blnStatus=false;
					}
					if(strEpisodeName.length()>0)
					{
						Reporter.pass("Content Details Verification", "Episode Name :- " + strEpisodeName +" is displayed");
					}
					else
					{
						Reporter.fail("Content Details Verification", "Episode Name is not displayed");
						blnStatus=false;
					}
					if(strEpisodeDuration.length()>0)
					{
						Reporter.pass("Content Details Verification", "Episode Duration :- " + strEpisodeDuration +" is displayed");
					}
					else
					{
						Reporter.fail("Content Details Verification", "Episode Duration is not displayed");
						blnStatus=false;
					}
					if(strEpisodeDescription.length()>0)
					{
						Reporter.pass("Content Details Verification", "Episode Description :- " + strEpisodeDescription +" is displayed");
					}
					else
					{
						Reporter.fail("Content Details Verification", "Episode Description is not displayed");
						blnStatus=false;
					}
					if(eleDownload.size()>0)
					{
						Reporter.pass("Content Details Verification", "Episode Download Button is displayed");
					}
					else
					{
						Reporter.fail("Content Details Verification", "Episode Download Button is not displayed");
						blnStatus=false;
					}
					if(elePlay.size()>0)
					{
						Reporter.pass("Content Details Verification", "Episode Play Button is displayed");
					}
					else
					{
						Reporter.fail("Content Details Verification", "Episode Play Button is not displayed");
						blnStatus=false;
					}
				}
				else
				{
					Reporter.fail("Content Details Verification", "Episode Details is not displayed");
					blnStatus=false;
				}
			}
			else
			{
				Reporter.fail("Content Details Verification", "Episode Details is not displayed");
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
	public boolean fnCloseDownloadQualityPopUp() throws Throwable {
		boolean blnStatus=true;
		Reporter.info("HOOQ Android","Verifying Download Popup");
		try
		{
			if(isElementDisplayed(downloadDialog))
			{
				Reporter.pass("Content Details Verification", "Download Quality Popup is displayed");
				String strInfo=getText(downloadPopupInfo,"Download Quality Popup Header");
				String strLow=getText(qualityLow,"Download Quality Popup Low");
				String strMedium=getText(qualityMedium,"Download Quality Popup Medium");
				String strHigh=getText(qualityHigh,"Download Quality Popup High");
				String strSavePref=getText(prefCheckBoxInfo,"Download Quality Popup Save Pref");
				if(strInfo.contains("Download Quality"))
				{
					Reporter.pass("Content Details Verification", "Download Quality Popup Header is displayed");
				}
				else
				{
					Reporter.fail("Content Details Verification", "Download Quality Popup Header is not displayed");
				}
				if(strLow.contains("Low Quality"))
				{
					Reporter.pass("Content Details Verification", "Download Quality Popup Low Quality is displayed");
				}
				else
				{
					Reporter.fail("Content Details Verification", "Download Quality Popup Low Quality is not displayed");
				}
				if(strMedium.contains("Medium Quality"))
				{
					Reporter.pass("Content Details Verification", "Download Quality Popup Medium Quality is displayed");
				}
				else
				{
					Reporter.fail("Content Details Verification", "Download Quality Popup Medium Quality is not displayed");
				}
				if(strHigh.contains("High Quality"))
				{
					Reporter.pass("Content Details Verification", "Download Quality Popup High Quality is displayed");
				}
				else
				{
					Reporter.fail("Content Details Verification", "Download Quality Popup High Quality is not displayed");
				}
				if(strSavePref.contains("Save my preferences"))
				{
					Reporter.pass("Content Details Verification", "Download Quality Popup Save my preferences is displayed");
				}
				else
				{
					Reporter.fail("Content Details Verification", "Download Quality Popup Save my preferences is not displayed");
				}
				click(prefCheckBox,"Save preference");
				Thread.sleep(5000);
				click(prefDownload,"Save preference And Download");
				Thread.sleep(10000);
			}
			else
			{
				Reporter.pass("Content Details Verification", "Download Quality Popup is not displayed");
			}		
		}
		catch(Exception e){blnStatus=false;}
			return blnStatus;
	}
	
	
	
	
	
	public boolean fnDownloadAndPlay(String strContentName, int intSeason, int intEpisode, String strAction) {
		boolean blnStatus=true;
		try
		{
			
		}
		catch(Exception e){blnStatus=false;}
			return blnStatus;
		
		
	}
	public boolean fnRedeemTicket(String strTVODContent) {
		boolean blnStatus=true;
		try
		{
			
		}
		catch(Exception e){blnStatus=false;}
			return blnStatus;
		
	}
	
	public boolean fnVerifySeasonAndEpisode(boolean blnTVSeries) throws Throwable
	{
		Reporter.info("HOOQ Android","Verifying Season and Episode Details");
		boolean blnStatus=true;
		try
		{
			if(blnTVSeries)
			{
				swipeUpOrBottom(true);
				if(isElementDisplayed(seasonDetails))
				{
					Reporter.pass("Season and Episode Details Verification", "Season Details is displayed");				
				}
				else
				{	
					Reporter.fail("Season and Episode Details Verification", "Season Details is not displayed");
					blnStatus=false;
				}
				if(isElementDisplayed(episodeList))
				{
					List<WebElement> eleList=driver.findElement(episodeList).findElements(By.className("android.widget.RelativeLayout"));
					if(eleList.size()>0)
					{
						Reporter.pass("Season and Episode Details Verification", "Episode Details is displayed");
						String strEpisodeNo=eleList.get(0).findElement(episodeNumber).getText();
						String strEpisodeName=eleList.get(0).findElement(episodeName).getText();
						List<WebElement> eleDownload=eleList.get(0).findElements(episodeDownload);
						List<WebElement> elePlay=eleList.get(0).findElements(episodePlay);
						String strEpisodeDuration=eleList.get(0).findElement(episodeDuration).getText();
						String strEpisodeDescription=eleList.get(0).findElement(episodeDescription).getText();
						if(strEpisodeNo.length()>0)
						{
							Reporter.pass("Season and Episode Details Verification", "Episode No :- " + strEpisodeNo +" is displayed");
						}
						else
						{
							Reporter.fail("Season and Episode Details Verification", "Episode No is not displayed");
							blnStatus=false;
						}
						if(strEpisodeName.length()>0)
						{
							Reporter.pass("Season and Episode Details Verification", "Episode Name :- " + strEpisodeName +" is displayed");
						}
						else
						{
							Reporter.fail("Season and Episode Details Verification", "Episode Name is not displayed");
							blnStatus=false;
						}
						if(strEpisodeDuration.length()>0)
						{
							Reporter.pass("Season and Episode Details Verification", "Episode Duration :- " + strEpisodeDuration +" is displayed");
						}
						else
						{
							Reporter.fail("Season and Episode Details Verification", "Episode Duration is not displayed");
							blnStatus=false;
						}
						if(strEpisodeDescription.length()>0)
						{
							Reporter.pass("Season and Episode Details Verification", "Episode Description :- " + strEpisodeDescription +" is displayed");
						}
						else
						{
							Reporter.fail("Season and Episode Details Verification", "Episode Description is not displayed");
							blnStatus=false;
						}
						if(eleDownload.size()>0)
						{
							Reporter.pass("Season and Episode Details Verification", "Episode Download Button is displayed");
						}
						else
						{
							Reporter.fail("Season and Episode Details Verification", "Episode Download Button is not displayed");
							blnStatus=false;
						}
						if(elePlay.size()>0)
						{
							Reporter.pass("Season and Episode Details Verification", "Episode Play Button is displayed");
						}
						else
						{
							Reporter.fail("Season and Episode Details Verification", "Episode Play Button is not displayed");
							blnStatus=false;
						}
					}
				else
				{
					Reporter.fail("Season and Episode Details Verification", "Episode Details is not displayed");
					blnStatus=false;
				}
				}
			}
			else
			{
				swipeUpOrBottom(true);
				if(isElementDisplayed(seasonDetails)==false)
				{
					Reporter.pass("Season and Episode Details Verification", "Season Details is not displayed");				
				}
				else
				{	
					Reporter.fail("Season and Episode Details Verification", "Season Season Details is displayed");
					blnStatus=false;
				}
				if(isElementDisplayed(episodeList)==false)
				{
					Reporter.pass("Season and Episode Details Verification", "Episode Details is not displayed");				
				}
				else
				{	
					Reporter.fail("Season and Episode Details Verification", "Episode Details Details is displayed");
					blnStatus=false;
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
	
	public boolean fnVerifyLike() throws Throwable {
		Reporter.info("HOOQ Android","Verifying Like");
		boolean blnStatus=true;
		try
		{
			if(isElementDisplayed(contentMovieLike))
			{
				Reporter.pass("Content Details Verification", "Content Like Button is displayed");
				String strText=getText(contentMovieLike,"Like");
				System.out.println(strText);
				if(strText.toLowerCase().equals("liked"))
				{
					click(contentMovieLike,"Liked");
					Thread.sleep(5000);
					Reporter.pass("Verifying Like", "Like Button is Changed from Liked to Like");		
				}
				String strTextInitial=getText(contentMovieLike,"Like");
				System.out.println(strTextInitial);
				if(strTextInitial.toLowerCase().equals("like"))
				{
					Reporter.pass("Verifying Like", "Like Button is displayed");
					click(contentMovieLike,"Liked");
					Thread.sleep(5000);
					String strTextChange=getText(contentMovieLike,"Liked");
					System.out.println(strTextChange);
					if(strTextChange.toLowerCase().equals("liked"))
					{
						Reporter.pass("Verifying Like", "Like Button is Changed from Like to Liked");	
					}
					else
					{
						Reporter.fail("Verifying Like", "Like Button is not Changed from Like to Liked");
					}
				}
				else
				{
					Reporter.fail("Verifying Like", "Like Button is not displayed");
				}
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Like Button is not displayed");
				blnStatus=false;
			}
		}
		catch(Exception e){blnStatus=false;}
			return blnStatus;
		
	}
	
	
}
