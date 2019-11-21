package com.automation.ios.workflows;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.reports.Reporter;

public class PlayPage extends BasePage{
	//Locators
	By popupVideo=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther");
	//locators
	By navBackBtn = By.name("navbar back btn");
	By playerWindow=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther");
	By btnPause=By.id("HQPauseIcon");
	By btnPlay=By.id("HQPlayIcon");
	By btnRewind=By.id("HQRewind15Icon");
	By SubtitlesIcon=By.id("HQSubtitlesIcon");  	
	By timeCounter=By.xpath("//XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeStaticText[1]");
	By playerBack=By.id("Icon back");
	By btnForward=By.id("HQForward15Icon");
	By seekbar=By.xpath("//XCUIElementTypeSlider");
	By btnQuality=By.id("HQQuality");
	By qualitySelectedMovies=By.xpath("//XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[2]");
	By qualitySelectedTvshows=By.xpath("//XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[3]");
	By lblVideoQuality=By.id("VIDEO QUALITY");
	By qualityAuto=By.id("Auto");
	By qualityLow=By.id("Low");
	By qualityMedium=By.id("Medium");
	By qualityHigh=By.id("High");
	By Done=By.id("Done");
	By lblAudioTrack=By.id("AUDIO");
	By lblsubtitle=By.id("SUBTITLES");
	By videoTitle=By.xpath("//XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[1]");
	By episodeBtn=By.id("HQEpisodeIcon");
	By seasonText=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText");
	By seasonClose=By.id("Icon Close");
	By episodeText=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[2]");		
	By seasonTable=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTable");	
	By tblEpisode=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable");
			/***
		 * Function Name :- getMePage Developed By :- Pankaj Kumar Date :-
		 * 4-July-2019
			 * @throws Throwable 
		 */
		public boolean navigateBack() throws Throwable
		{
			boolean blnStatus=true;
			try {
				Thread.sleep(5000);
				driver.findElement(playerWindow).click();
				click(playerBack, "Back From Player page");
			} catch (Exception e) {blnStatus=false;}
			return blnStatus;
		}
		
		
		public boolean clickPause()
		{
			boolean blnStatus=true;
			try
			{
				Thread.sleep(5000);
				driver.findElement(playerWindow).click();
				driver.findElement(btnPause).click();	
			} catch (Exception e) {blnStatus=false;}
			return blnStatus;
		}
		
		public boolean clickSeasonClose()
		{
			boolean blnStatus=true;
			try
			{
				driver.findElement(seasonClose).click();	
			} catch (Exception e) {blnStatus=false;}
			return blnStatus;
		}
		
		public boolean clickEpisode()
		{
			boolean blnStatus=true;
			try
			{
				Thread.sleep(5000);
				driver.findElement(playerWindow).click();
				driver.findElement(episodeBtn).click();	
			} catch (Exception e) {blnStatus=false;}
			return blnStatus;
		}
		
		public boolean clickQuality()
		{
			boolean blnStatus=true;
			try
			{
				Thread.sleep(5000);
				driver.findElement(playerWindow).click();
				driver.findElement(btnQuality).click();	
			} catch (Exception e) {blnStatus=false;}
			return blnStatus;
		}
		
		public boolean clickSubtitle()
		{
			boolean blnStatus=true;
			try
			{
				Thread.sleep(5000);
				driver.findElement(playerWindow).click();
				driver.findElement(SubtitlesIcon).click();
			} catch (Exception e) {blnStatus=false;}
			return blnStatus;
		}
		public boolean clickDone()
		{
			boolean blnStatus=true;
			try
			{
				driver.findElement(Done).click();	
			} catch (Exception e) {blnStatus=false;}
			return blnStatus;
		}
		
		public boolean clickPlay()
		{
			boolean blnStatus=true;
			try
			{
				Thread.sleep(5000);
				driver.findElement(playerWindow).click();
				driver.findElement(btnPlay).click();
			} catch (Exception e) {blnStatus=false;}
			return blnStatus;
		}

		public boolean clickAuto()
		{
			boolean blnStatus=true;
			try
			{
				driver.findElement(qualityAuto).click();	
			} catch (Exception e) {blnStatus=false;}
			return blnStatus;
		}
		
		public boolean clickMedium()
		{
			boolean blnStatus=true;
			try
			{
				driver.findElement(qualityMedium).click();	
			} catch (Exception e) {blnStatus=false;}
			return blnStatus;
		}
		
		public boolean verifyQualityAuto()
		{
			boolean blnStatus=true;
			try
			{
				blnStatus=isElementDisplayedPlayerControl(qualityAuto);	
			} catch (Exception e) {blnStatus=false;}
			return blnStatus;
		}
		
		public boolean verifyQualityDone()
		{
			boolean blnStatus=true;
			try
			{
				blnStatus=isElementDisplayedPlayerControl(Done);	
			} catch (Exception e) {blnStatus=false;}
			return blnStatus;
		}
		private boolean isElementDisplayedPlayerControl(By loc) {
			boolean blnStatus=true;
			try
			{
				List<WebElement> eleList=driver.findElements(loc);
				if(eleList.size()==0)
					blnStatus=false;
			} catch (Exception e) {blnStatus=false;}
			return blnStatus;
			
		}
		
		
		public boolean verifyQualityHigh()
		{
			boolean blnStatus=true;
			try
			{
				blnStatus=isElementDisplayedPlayerControl(qualityHigh);	
			} catch (Exception e) {blnStatus=false;}
			return blnStatus;
		}
		
		public boolean verifyQualityMedium()
		{
			boolean blnStatus=true;
			try
			{
				blnStatus=isElementDisplayedPlayerControl(qualityMedium);	
			} catch (Exception e) {blnStatus=false;}
			return blnStatus;
		}
		
		public boolean verifyQualityLow()
		{
			boolean blnStatus=true;
			try
			{
				blnStatus=isElementDisplayedPlayerControl(qualityLow);	
			} catch (Exception e) {blnStatus=false;}
			return blnStatus;
		}
		
		public boolean verifyRewind()
		{
			boolean blnStatus=true;
			try
			{
				Thread.sleep(5000);
				driver.findElement(playerWindow).click();
				blnStatus=isElementDisplayedPlayerControl(btnRewind);	
			} catch (Exception e) {blnStatus=false;}
			return blnStatus;
		}
		
		public boolean verifyForward()
		{
			boolean blnStatus=true;
			try
			{
				Thread.sleep(5000);
				driver.findElement(playerWindow).click();
				blnStatus=isElementDisplayedPlayerControl(btnForward);
			} catch (Exception e) {blnStatus=false;}
			return blnStatus;
		}
		
		public boolean verifySeekBar()
		{
			boolean blnStatus=true;
			try
			{
				Thread.sleep(5000);
				driver.findElement(playerWindow).click();
				blnStatus=isElementDisplayedPlayerControl(seekbar);
			} catch (Exception e) {blnStatus=false;}
			return blnStatus;
		}
		
		
		public String verifyVideoTimeCounter()
		{
			String strText="";
			try
			{
				Thread.sleep(5000);
				driver.findElement(playerWindow).click();
				strText=getTextPlayerControl(timeCounter,"Video Playing Time");
			} catch (Exception e) {}
			return strText;
		}
		
		public String verifyVideoTitleName()
		{
			String strText="";
			try
			{
				Thread.sleep(5000);
				driver.findElement(playerWindow).click();
				strText=getTextPlayerControl(videoTitle,"Video Title Name");
			} catch (Exception e) {}
			return strText;
		}
		
		public String verifySubTitleLabel()
		{
			String strText="";
			try
			{
				strText=getTextPlayerControl(lblsubtitle,"Subtitle Label");
			} catch (Exception e) {}
			return strText;
		}
		
		public String verifyAudioLabel()
		{
			String strText="";
			try
			{
				strText=getTextPlayerControl(lblAudioTrack,"Audio Track Label");
			} catch (Exception e) {}
			return strText;
		}
		
		private String getTextPlayerControl(By loc, String string) 
		{
			String strText="";
			try
			{
				strText=driver.findElement(loc).getText();
			}
			catch(Exception e){}
			return strText;
		}
		
		
		public String verifyQualitySelectedMovies()
		{
			String strText="";
			try
			{
				Thread.sleep(5000);
				driver.findElement(playerWindow).click();
				strText=getTextPlayerControl(qualitySelectedMovies,"Selected Quality");
			} catch (Exception e) {}
			return strText;
		}
		public String verifyQualitySelectedTVShows()
		{
			String strText="";
			try
			{
				Thread.sleep(5000);
				driver.findElement(playerWindow).click();
				strText=getTextPlayerControl(qualitySelectedTvshows,"Selected Quality");
			} catch (Exception e) {}
			return strText;
		}
		
		public String verifyVideoQualityLabel()
		{
			String strText="";
			try
			{
				strText=getTextPlayerControl(lblVideoQuality,"Video Track Label");
			} catch (Exception e) {}
			return strText;
		}
		
		public String verifySeasonDetails()
		{
			String strText="";
			try
			{
				strText=getTextPlayerControl(seasonText,"seasonText");
			} catch (Exception e) {}
			return strText;
		}
		
		public String verifyEpisodeDetails()
		{
			String strText="";
			try
			{
				getTextPlayerControl(episodeText,"Episode Text");
			} catch (Exception e) {}
			return strText;
		}
		
		public boolean waitforPlay(int intCounter)
		{
			boolean blnStatus=true;
			try
			{
				Thread.sleep(intCounter);
			} catch (Exception e) {}
			return blnStatus;
		}
	
		public String fnGetQualitySelected(boolean blnEpisode)
		{
			String strText="";
			try
			{
				if(blnEpisode)
					strText=verifyQualitySelectedTVShows();
				else
					strText=verifyQualitySelectedMovies();
					
			}
			catch(Exception e){}
			return strText;
		}
		
	
	/***
	 * Function Name :- fnVerifyPlayback
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
	public  boolean fnVerifyPlayback(boolean blnEpisode,String strAction) throws Throwable
	{
		boolean blnStatus=true;
		try
		{
			Reporter.blnReportTempStatus=true;
			Thread.sleep(10000);
			String strAfter="NA";
			String strBefore="NA";
			//Get the Initial Player time
			//Click on Pause Button on Player
			clickPause();
			strBefore=verifyVideoTimeCounter();
			if(strAction.toLowerCase().equals("full"))
			{
				if(fnVerifyPlayerWindowElement(SubtitlesIcon))
				{
					Reporter.pass("Playback", "Settings Icon is display");
				}
				else
				{
					Reporter.fail("Playback", "Settings Icon is not display");
				}
				if(fnVerifyPlayerWindowElement(playerBack))
				{
					Reporter.pass("Playback", "Back Icon is display");
				}
				else
				{
					Reporter.fail("Playback", "Back Icon is not display");
				}
				String strPlayerContent=verifyVideoTitleName();
				if(strPlayerContent.length()>0)
				{	
					Reporter.pass("Playback", "Content : "+ strPlayerContent + " is display");
				}
				else
				{
					Reporter.fail("Playback", "Content : "+ strPlayerContent + " is not display");
				}	
				if(fnVerifyPlayerWindowElement(btnRewind))
				{
					Reporter.pass("Playback", "Rewind Icon is display");
				}
				else
				{
					Reporter.fail("Playback", "Rewind Icon is not display");
				}
				if(fnVerifyPlayerWindowElement(btnPlay))
				{
					Reporter.pass("Playback", "Play / Pause Icon is display");
				}
				else
				{
					Reporter.fail("Playback", "Play / Pause Icon is not display");
				}
				if(fnVerifyPlayerWindowElement(btnForward))
				{
					Reporter.pass("Playback", "Forward Icon is display");
				}
				else
				{
					Reporter.fail("Playback", "Forward Icon is not display");
				}
				if(fnVerifyPlayerWindowElement(seekbar))
				{
					Reporter.pass("Playback", "SeekBar is display");
				}
				else
				{
					Reporter.fail("Playback", "SeekBar is not display");
				}
				if(fnVerifyPlayerWindowElement(btnQuality))
				{
					Reporter.pass("Playback", "Quality icon is display");
				}
				else
				{
					Reporter.fail("Playback", "Quality icon is not display");
				}
				
				//Check the Player Quality and change the Player Quality
				String strQualitySelectedPrev=fnGetQualitySelected(blnEpisode);
				System.out.println("Playback Quality Selected " + strQualitySelectedPrev );
				//Click on the Player Quality Button
				clickQuality();
				if(verifyVideoQualityLabel().toLowerCase().contains("video quality"))
				{
					Reporter.pass("Playback Quality", "Playback Quality Details is display");
				}
				else
				{
					Reporter.fail("Playback Quality", "PlaybackQuality Details is not display");
				}
				if(verifyQualityAuto())
				{
					Reporter.pass("Playback Quality", "Playback Quality Auto is display");
				}
				else
				{
					Reporter.fail("Playback Quality", "Playback Quality Auto is not display");
				}
				if(verifyQualityLow())
				{
					Reporter.pass("Playback Quality", "Playback Quality Low is display");
				}
				else
				{
					Reporter.fail("Playback Quality", "Playback Quality Low is not display");
				}
				if(verifyQualityMedium())
				{
					Reporter.pass("Playback Quality", "Playback Quality Medium is display");
				}
				else
				{
					Reporter.fail("Playback Quality", "Playback Quality Medium is not display");
				}
				if(verifyQualityHigh())
				{
					Reporter.pass("Playback Quality", "Playback Quality High is display");
				}
				else
				{
					Reporter.fail("Playback Quality", "Playback Quality High is not display");
				}
				if(verifyQualityDone())
				{
					Reporter.pass("Playback Quality", "Playback Quality Done Button is display");
				}
				else
				{
					Reporter.fail("Playback Quality", "Playback Quality Done Button is not display");
				}	
				if(strQualitySelectedPrev.toLowerCase().equals("med")==false)
				{
					if(clickMedium())
					{
						Reporter.pass("Playback Quality", "Playback Quality Select Medium is Selected");
					}
					else
					{
						Reporter.fail("Playback Quality", "Playback Quality Select Medium  is not Selected");
					}
				}
				else
				{
					if(clickAuto())
					{
						Reporter.pass("Playback Quality", "Playback Quality Select Auto is Selected");
					}
					else
					{
						Reporter.fail("Playback Quality", "Playback Quality Select Auto  is not Selected");
					}
				}
				if(clickDone())
				{
					Reporter.pass("Playback Quality", "Playback Quality is changing the Quality");
				}
				
				clickPause();
				String strQualitySelected=fnGetQualitySelected(blnEpisode);
				if(strQualitySelected.equals(strQualitySelectedPrev)==false)
				{
					Reporter.pass("Playback Quality", "Playback Quality is Changed from " + strQualitySelectedPrev + " to " +strQualitySelected);
				}
				else
				{
					Reporter.fail("Playback Quality", "Playback Quality is not Changed from " + strQualitySelectedPrev + " to " +strQualitySelected);
				}
				if(clickSubtitle())
				{
					Reporter.pass("Playback Settings", "Playback Settings is Selected");
				}
				else
				{
					Reporter.fail("Playback Settings", "Playback Settings is not Selected");
				}
				if(verifyAudioLabel().toLowerCase().contains("audio"))
				{
					Reporter.pass("Playback Settings", "Playback Settings AUDIO TRACK is displayed");
				}
				else
				{
					Reporter.fail("Playback Settings", "Playback Settings AUDIO TRACK is not displayed");
				}
				if(verifySubTitleLabel().toLowerCase().contains("subtitles"))
				{
					Reporter.pass("Playback Settings", "Playback Settings SUBTITLES is displayed");
				}
				else
				{
					Reporter.fail("Playback Settings", "Playback Settings SUBTITLES is not displayed");
				}
				//Find the No of Audio Track Available
				List<WebElement> eleAudioTrack=driver.findElement(By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTable")).findElements(By.xpath("XCUIElementTypeCell"));
				Reporter.pass("Playback Settings Audio Track", "Playback Settings Total  "+ eleAudioTrack.size() +" Audio Track is displayed");
				for(int i=0;i<eleAudioTrack.size();i++)
				{
					String strAudioTrack=eleAudioTrack.get(i).findElement(By.xpath("XCUIElementTypeStaticText")).getText();
					Reporter.pass("Playback Settings Audio Track", "Playback Settings "+ strAudioTrack+" is displayed");
				}
				//Find the No of Subtitle Track Available
				List<WebElement> eleSubTitle=driver.findElement(By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable")).findElements(By.xpath("XCUIElementTypeCell"));
				Reporter.pass("Playback Settings Subtitle", "Playback Settings Total  "+ eleAudioTrack.size() +" Subtitle is displayed");
				for(int i=0;i<eleSubTitle.size();i++)
				{
					String strSubTitle= eleSubTitle.get(i).findElement(By.xpath("XCUIElementTypeStaticText")).getText();
					Reporter.pass("Playback Settings SubTitle", "Playback Settings "+ strSubTitle+" is displayed");
				}
				if(eleSubTitle.size()>1)
				{
					eleSubTitle.get(1).click();
				}
				clickDone();
				fnDefaultPopupVideo();
				if(blnEpisode)
				{
					clickPause();
					//Verify the Episode Details
					if(clickEpisode())
					{
						Reporter.pass("Playback Episode", "Playback Episode is Clicked Successfully");
						//Get The Season Details
						String strPlayerEpisode=verifySeasonDetails();
						if(strPlayerEpisode.length()>0)
						{
							Reporter.pass("Playback Seasons", "Playback Seasons "+ strPlayerEpisode +" is displayed");
						}
						else
						{
							Reporter.fail("Playback Seasons", "Playback Seasons "+ strPlayerEpisode +" is not displayed");
						}
						//Get The Full List of Seasons
						List<WebElement> eleSeason=driver.findElement(seasonTable).findElements(By.xpath("XCUIElementTypeCell"));
						if(eleSeason.size()>0)
						{
							Reporter.pass("Playback Seasons", "Playback Season "+ eleSeason.size() +" is displayed");
							for(int i=0;i<eleSeason.size();i++)
							{
								List<WebElement> eleSeasonDeatails=eleSeason.get(i).findElements(By.xpath("XCUIElementTypeStaticText"));
								if(eleSeasonDeatails.size()>1)
								{
									Reporter.pass("Playback Seasons", "Playback Season No "+ eleSeasonDeatails.get(0).getText() +" Season Name " + eleSeasonDeatails.get(1).getText() +" displayed");
								}
							}
						}
						else
						{
							Reporter.fail("Playback Seasons", "Playback Season "+ eleSeason.size() +" is not displayed");
						}
						
						List<WebElement> eleEpisode=driver.findElement(tblEpisode).findElements(By.xpath("XCUIElementTypeCell"));
						if(eleEpisode.size()>0)
						{
							Reporter.pass("Playback Episode", "Playback Episode "+ eleEpisode.size() +" is displayed");
							int intEpisodeCount=5;
							if(eleEpisode.size()<=5)
								intEpisodeCount=eleEpisode.size();
							for(int i=0;i<intEpisodeCount;i++)
							{
								List<WebElement> eleEpisodeDeatil=eleEpisode.get(i).findElements(By.xpath("XCUIElementTypeStaticText"));
								if(eleEpisodeDeatil.size()>1)
								{
									System.out.println("Episode List Details " + eleEpisodeDeatil.get(0).getText());
									System.out.println("Episode Details " + eleEpisodeDeatil.get(1).getText());
									Reporter.pass("Playback Episode", "Playback Episode No : "+ eleEpisodeDeatil.get(0).getText() +" Episode Name : " + eleEpisodeDeatil.get(1).getText() +" displayed");
								}
							}
						}
						else
						{
							Reporter.fail("Playback Episode", "Playback Episode "+ eleEpisode.size() +" is not displayed");
						}
						
						clickSeasonClose();
					}
					else
					{
						Reporter.fail("Playback Episode", "Playback Episode is Clicked Successfully");
					}
				}
				}
				clickPlay();
				waitforPlay(10000);
				clickPause();
				strAfter=verifyVideoTimeCounter();
				if(navigateBack())
				{
					Reporter.pass("Playback Settings", "Player Window is Close");
				}
				else
				{
					Reporter.fail("Playback Settings", "Player Window is not Close ");
				}
				String strData=StringUtils.difference(strBefore,strAfter);
		        System.out.println(strData);
		        System.out.println(strData.length());
		        if(strData.length()>0)
				{
					Reporter.pass("Playback Settings", "Movie is Playing Start Time : " + strBefore + " End Time : " + strAfter + " Remaning");
				}
				else
				{
					Reporter.fail("Video Playback", "Video is Playing ");
				}
			}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			System.out.println("Catch Block of Player");
		}
		blnStatus=Reporter.blnReportTempStatus;
		Reporter.blnReportTempStatus=true;
		return blnStatus;
	}
	
	/***
	 * Function Name :- fnClickPlayerWindow
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
	public  boolean fnClickPlayerWindow(By locator)
	{
		boolean blnFound=true;
		try
		{
			Thread.sleep(5000);
			driver.findElement(playerWindow).click();
			driver.findElement(locator).click();
		}
		catch(Exception e){blnFound=false;}
		return blnFound;
	}
	/***
	 * Function Name :- fnVerifyPlayerWindowElement
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
	public  boolean fnVerifyPlayerWindowElement(By locator)
	{
		boolean blnFound=false;
		try
		{
			Thread.sleep(5000);
			driver.findElement(playerWindow).click();
			blnFound=isElementDisplayedPlayerControl(locator);
		}
		catch(Exception e){}
		return blnFound;
	}
	
	/***
	 * Function Name :- fnGetPlayerWindowText
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
	public  String fnGetPlayerWindowText(By locator)
	{
		String strText="";
		try
			{
				Thread.sleep(5000);
				driver.findElement(playerWindow).click();
				strText=driver.findElement(locator).getText();
				System.out.println("Text Found ==> " +strText);
				return strText;
			}
			catch(Exception e){}
		return strText;
	}
	/***
	 * Function Name :- fnDefaultPopupVideo
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
	public  void fnDefaultPopupVideo() throws Throwable
	{
		try
		{
			boolean blnPopup=isElementDisplayed(popupVideo);
			if(blnPopup)
			{
				List<WebElement> eleList=driver.findElement(popupVideo).findElements(By.xpath("XCUIElementTypeText"));
				if(eleList.size()>0)
				{
					for(int i=0;i<eleList.size();i++)
					{
						Reporter.pass("Playback Popup Set Default","Message "+ eleList.get(i).getText() + " is displayed");
					}	
				}
				List<WebElement> eleButton=driver.findElement(popupVideo).findElements(By.xpath("XCUIElementTypeButton"));
				if(eleButton.size()>0)
				{
					for(int i=0;i<eleButton.size();i++)
					{
						Reporter.pass("Playback Popup Set Default","Button "+ eleButton.get(i).getText() + " is displayed");
					}	
					eleButton.get(0).click();
				}
						
			}
			
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
		}
	}
	
	/***
	 * Function Name :- fnVerifyPlaybackSubTitle
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
	public  boolean fnVerifyPlaybackSubTitle() throws Throwable
	{
		boolean blnStatus=true;
		try
		{
			Reporter.blnReportTempStatus=true;
			Thread.sleep(10000);
			String strAfter="NA";
			String strBefore="NA";
			clickPause();
			strBefore=verifyVideoTimeCounter();
			if(fnVerifyPlayerWindowElement(SubtitlesIcon))
			{
				Reporter.pass("Playback", "Settings Icon is display");
			}
			else
			{
				Reporter.fail("Playback", "Settings Icon is not display");
			}
			if(clickSubtitle())
			{
				Reporter.pass("Playback Settings", "Playback Settings is Selected");
			}
			else
			{
				Reporter.fail("Playback Settings", "Playback Settings is not Selected");
			}
			if(verifySubTitleLabel().toLowerCase().contains("subtitles"))
			{
				Reporter.pass("Playback Settings", "Playback Settings SUBTITLES is displayed");
			}
			else
			{
				Reporter.fail("Playback Settings", "Playback Settings SUBTITLES is not displayed");
			}
			//Find the No of Subtitle Track Available
			List<WebElement> eleSubTitle=driver.findElement(By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable")).findElements(By.xpath("XCUIElementTypeCell"));
			Reporter.pass("Playback Settings Subtitle", "Playback Settings Total  "+ eleSubTitle.size() +" Subtitle is displayed");
			for(int i=0;i<eleSubTitle.size();i++)
			{
				String strSubTitle= eleSubTitle.get(i).findElement(By.xpath("XCUIElementTypeStaticText")).getText();
				Reporter.pass("Playback Settings SubTitle", "Playback Settings "+ strSubTitle+" is displayed");
			}
			if(eleSubTitle.size()>1)
			{
				eleSubTitle.get(1).click();
			}
			clickDone();
			fnDefaultPopupVideo();
			clickPlay();
			waitforPlay(10000);
			clickPause();
			strAfter=verifyVideoTimeCounter();
			if(navigateBack())
			{
				Reporter.pass("Playback Settings", "Player Window is Close");
			}
			else
			{
				Reporter.fail("Playback Settings", "Player Window is not Close ");
			}
			String strData=StringUtils.difference(strBefore,strAfter);
		    System.out.println(strData);
		    System.out.println(strData.length());
		    if(strData.length()>0)
			{
				Reporter.pass("Playback Settings", "Movie is Playing Start Time : " + strBefore + " End Time : " + strAfter + " Remaning");
			}
			else
			{
				Reporter.fail("Video Playback", "Video is Playing ");
			}
			}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			System.out.println("Catch Block of Player");
		}
		blnStatus=Reporter.blnReportTempStatus;
		Reporter.blnReportTempStatus=true;
		return blnStatus;
	}
	
	
}
