package com.automation.android.workflows;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import com.automation.reports.Reporter;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;

public class PlayerPage extends BasePage{
		//Player Co-Ordinates
		double Close_X=0.018750000000000000;
		double Close_Y=0.015277777777777800;
		double Video_Title_X=0.096875000000000000;
		double Video_Title_Y=0.022222222222222200;
		double Video_Desc_X=0.096875000000000000;
		double Video_Desc_Y=0.083333333333333300;
		double Icon_Play_List_X=0.735937500000000000;
		double Icon_Play_List_Y=0.012500000000000000;
		double Settings_X=0.810937500000000000;
		double Settings_Y=0.012500000000000000;
		double Quality_X=0.885937500000000000;
		double Quality_Y=0.011111111111111100;
		double iconRewind_X=0.018750000000000000;
		double iconRewind_Y=0.844444444444444000;
		double iconPlayPause_X=0.093750000000000000;
		double iconPlayPause_Y=0.844444444444444000;
		double iconForward_X=0.168750000000000000;
		double iconForward_Y=0.822222222222222000;
		double iconNextEpisode_X=0.243750000000000000;
		double iconNextEpisode_Y=0.822222222222222000;
		double seek_bar_X=0.318750000000000000;
		double seek_bar_Y=0.833333333333333000;
		double playTime_X=0.875000000000000000;
		double playTime_Y=0.858333333333333000;
	//Locators
		By popupVideo=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther");
		//locators
		By navBackBtn = By.name("navbar back btn");
		By playerWindow=By.id("tv.hooq.android:id/brightcoveVideoView");
		By btnPause=By.id("tv.hooq.android:id/iconPlayPause");
		By btnPlay=By.id("tv.hooq.android:id/iconPlayPause");
		By btnRewind=By.id("tv.hooq.android:id/iconRewind");
		By SubtitlesIcon=By.id("HQSubtitlesIcon");  	
		By timeCounter=By.id("tv.hooq.android:id/playTime");
		By playerBack=By.id("tv.hooq.android:id/btnClose");
		By btnForward=By.id("tv.hooq.android:id/iconForward");
		By seekbar=By.id("tv.hooq.android:id/seek_bar");
		By btnQuality=By.id("HQQuality");
		By qualitySelectedMovies=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[2]");
		By qualitySelectedTvshows=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[3]");
		By lblVideoQuality=By.id("tv.hooq.android:id/lblQuality");
		By qualityAuto=By.xpath("//android.widget.TextView[@text='Auto']");
		By qualityLow=By.xpath("//android.widget.TextView[@text='Low']");
		By qualityMedium=By.xpath("//android.widget.TextView[@text='Medium']");
		By qualityHigh=By.xpath("//android.widget.TextView[@text='High']");
		By Done=By.xpath("//android.widget.TextView[@text='Auto']");
		By lblAudioTrack=By.xpath("//android.widget.TextView[@text='AUDIO']");
		By lblsubtitle=By.xpath("//android.widget.TextView[@text='SUBTITLES']");
		By videoTitle=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[1]");
		By episodeBtn=By.id("HQEpisodeIcon");
		By seasonText=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText");
		By seasonClose=By.id("Icon Close");
		By episodeText=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[2]");		
		By qualityText=By.id("tv.hooq.android:id/iconQuality");	
		By movieTitle=By.id("tv.hooq.android:id/videoTitle");
		By settings=By.id("tv.hooq.android:id/iconSettings");
		By close=By.id("tv.hooq.android:id/close");
		By seasonCount=By.id("tv.hooq.android:id/seasonCount");
		By closeEpList=By.id("tv.hooq.android:id/episodeListCloseButton");
		
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
			
			public boolean clickClose()
			{
				boolean blnStatus=true;
				try
				{
					Thread.sleep(5000);
					Dimension dimensions = driver.manage().window().getSize();
					int screenWidth = dimensions.getWidth();
					int screenHeight = dimensions.getHeight();
					System.out.println("X Coordinates ==> " + screenWidth);
					System.out.println("Y Coordinates ==> " + screenHeight);
					int intXActual=(int) (screenWidth*Close_X);
					int intYActal=(int) (screenHeight*Close_Y);
					System.out.println(intXActual);
					System.out.println(intYActal);
					TouchAction action= new TouchAction((MobileDriver) driver);
					action.tap(intXActual, intYActal).perform();
					action.tap(intXActual, intYActal).perform();
				} catch (Exception e) {blnStatus=false;}
				return blnStatus;
			}
			
			
			
			public boolean clickPlayPause()
			{
				boolean blnStatus=true;
				try
				{
					Thread.sleep(5000);
					Dimension dimensions = driver.manage().window().getSize();
					int screenWidth = dimensions.getWidth();
					int screenHeight = dimensions.getHeight();
					System.out.println("X Coordinates ==> " + screenWidth);
					System.out.println("Y Coordinates ==> " + screenHeight);
					int intXActual=(int) (screenWidth*iconPlayPause_X);
					int intYActal=(int) (screenHeight*iconPlayPause_Y)+1;
					System.out.println(intXActual);
					System.out.println(intYActal);
					double t=608;
					double x=(double)(t/screenHeight);
					System.out.println(x);
					TouchAction action= new TouchAction((MobileDriver) driver);
					action.tap(intXActual, intYActal).perform();
					action.tap(intXActual, intYActal).perform();
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
					Dimension dimensions = driver.manage().window().getSize();
					int screenWidth = dimensions.getWidth();
					int screenHeight = dimensions.getHeight();
					System.out.println("X Coordinates ==> " + screenWidth);
					System.out.println("Y Coordinates ==> " + screenHeight);
					int intXActual=(int) (screenWidth*Icon_Play_List_X);
					int intYActal=(int) (screenHeight*Icon_Play_List_Y);
					System.out.println(intXActual);
					System.out.println(intYActal);
					TouchAction action= new TouchAction((MobileDriver) driver);
					action.tap(intXActual, intYActal).perform();
					action.tap(intXActual, intYActal).perform();
				} catch (Exception e) {blnStatus=false;}
				return blnStatus;
			}
			
			public boolean clickQuality()
			{
				boolean blnStatus=true;
				try
				{
					Thread.sleep(5000);
					Dimension dimensions = driver.manage().window().getSize();
					int screenWidth = dimensions.getWidth();
					int screenHeight = dimensions.getHeight();
					System.out.println("X Coordinates ==> " + screenWidth);
					System.out.println("Y Coordinates ==> " + screenHeight);
					int intXActual=(int) (screenWidth*Quality_X);
					int intYActal=(int) (screenHeight*Quality_Y)+1;
					System.out.println(intXActual);
					System.out.println(intYActal);
					TouchAction action= new TouchAction((MobileDriver) driver);
					action.tap(intXActual, intYActal).perform();
					action.tap(intXActual, intYActal).perform();
				} catch (Exception e) {blnStatus=false;}
				return blnStatus;
			}
			
			public boolean clickSettings()
			{
				boolean blnStatus=true;
				try
				{
					Thread.sleep(5000);
					Dimension dimensions = driver.manage().window().getSize();
					int screenWidth = dimensions.getWidth();
					int screenHeight = dimensions.getHeight();
					System.out.println("X Coordinates ==> " + screenWidth);
					System.out.println("Y Coordinates ==> " + screenHeight);
					int intXActual=(int) (screenWidth*Settings_X);
					int intYActal=(int) (screenHeight*Settings_Y);
					System.out.println(intXActual);
					System.out.println(intYActal);
					TouchAction action= new TouchAction((MobileDriver) driver);
					action.tap(intXActual, intYActal).perform();
					action.tap(intXActual, intYActal).perform();
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
			
			
			
			
			public boolean waitforPlay(int intCounter)
			{
				boolean blnStatus=true;
				try
				{
					Thread.sleep(intCounter);
				} catch (Exception e) {}
				return blnStatus;
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
				Thread.sleep(20000);
				String strAfter="NA";
				String strBefore="NA";
				//Get the Initial Player time
				//Click on Pause Button on Player
				clickPlayPause();
				strBefore=fnGetPlayerWindowText(timeCounter);
				String strContent=fnGetPlayerWindowText(movieTitle);
				if(strAction.toLowerCase().equals("full"))
				{
					boolean blnSettings=fnVerifyPlayerWindowElement(settings);
					if(blnSettings)
					{
						Reporter.pass("Playback", "Settings Icon is display");
					}
					else
					{
						Reporter.fail("Playback", "Settings Icon is not display");
					}
					if(strContent.length()>0)
					{	
						Reporter.pass("Playback", "Content Title : "+ strContent + " is display");
					}
					else
					{
						Reporter.fail("Playback", "Content Title is not display");
					}	
					boolean blnRewind=fnVerifyPlayerWindowElement(btnRewind);
					if(blnRewind)
					{
						Reporter.pass("Playback", "Rewind Icon is display");
					}
					else
					{
						Reporter.fail("Playback", "Rewind Icon is not display");
					}
					boolean blnPlayPause=fnVerifyPlayerWindowElement(btnPlay);
					if(blnPlayPause)
					{
						Reporter.pass("Playback", "Play / Pause Icon is display");
					}
					else
					{
						Reporter.fail("Playback", "Play / Pause Icon is not display");
					}
					boolean blnForward=fnVerifyPlayerWindowElement(btnRewind);
					if(blnForward)
					{
						Reporter.pass("Playback", "Forward Icon is display");
					}
					else
					{
						Reporter.fail("Playback", "Forward Icon is not display");
					}
					boolean blnSEEKBAR=fnVerifyPlayerWindowElement(seekbar);
					if(blnSEEKBAR)
					{
						Reporter.pass("Playback", "SeekBar is display");
					}
					else
					{
						Reporter.fail("Playback", "SeekBar is not display");
					}
					boolean blnQuality=fnVerifyPlayerWindowElement(qualityText);
					if(blnQuality)
					{
						Reporter.pass("Playback", "Quality icon is display");
					}
					else
					{
						Reporter.fail("Playback", "Quality icon is not display");
					}
					//Check the Player Quality and change the Player Quality
					String strQualitySelectedPrev=fnGetPlayerWindowText(qualityText);
					System.out.println("Playback Quality Selected " + strQualitySelectedPrev );
					//Click on the Player Quality Button
					clickQuality();
					boolean blnPlayerQuality=isElementDisplayed(lblVideoQuality);
					if(blnPlayerQuality)
					{
						Reporter.pass("Playback Quality", "Playback Quality Details is display");
					}
					else
					{
						Reporter.fail("Playback Quality", "PlaybackQuality Details is not display");
					}
					boolean blnPlayerQualityAuto=isElementDisplayed(qualityAuto);
					if(blnPlayerQualityAuto)
					{
						Reporter.pass("Playback Quality", "Playback Quality Auto is display");
					}
					else
					{
						Reporter.fail("Playback Quality", "Playback Quality Auto is not display");
					}
					boolean blnPlayerQualityLow=isElementDisplayed(qualityLow);
					if(blnPlayerQualityLow)
					{
						Reporter.pass("Playback Quality", "Playback Quality Low is display");
					}
					else
					{
						Reporter.fail("Playback Quality", "Playback Quality Low is not display");
					}
					boolean blnPlayerQualityMedium=isElementDisplayed(qualityMedium);
					if(blnPlayerQualityMedium)
					{
						Reporter.pass("Playback Quality", "Playback Quality Medium is display");
					}
					else
					{
						Reporter.fail("Playback Quality", "Playback Quality Medium is not display");
					}
					boolean blnPlayerQualityHigh=isElementDisplayed(qualityHigh);
					if(blnPlayerQualityHigh)
					{
						Reporter.pass("Playback Quality", "Playback Quality High is display");
					}
					else
					{
						Reporter.fail("Playback Quality", "Playback Quality High is not display");
					}
					if(strQualitySelectedPrev.toLowerCase().equals("med")==false)
					{
						//Click on Medium Quality
						boolean blnPlayerQualitySelected=click(qualityMedium,"Select Medium Quality");
						if(blnPlayerQualitySelected)
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
						boolean blnPlayerQualitySelected=click(qualityAuto,"Select Auto Quality");
						if(blnPlayerQualitySelected)
						{
							Reporter.pass("Playback Quality", "Playback Quality Select Auto is Selected");
						}
						else
						{
							Reporter.fail("Playback Quality", "Playback Quality Select Auto  is not Selected");
						}
					}
					boolean blnPlayerQualityDoneSelected=click(close,"Close");
					if(blnPlayerQualityDoneSelected)
					{
						Reporter.pass("Playback Quality", "Playback Quality is changing the Quality");
					}
					clickPlayPause();
					String strQualitySelected=fnGetPlayerWindowText(qualityText);
					if(strQualitySelected.equals(strQualitySelectedPrev)==false)
					{
						Reporter.pass("Playback Quality", "Playback Quality is Changed from " + strQualitySelectedPrev + " to " +strQualitySelected);
					}
					else
					{
						Reporter.fail("Playback Quality", "Playback Quality is not Changed from " + strQualitySelectedPrev + " to " +strQualitySelected);
					}
					clickSettings();
					boolean blnAudioTrack=isElementDisplayed(lblAudioTrack);
					if(blnAudioTrack)
					{
						Reporter.pass("Playback Settings", "Playback Settings AUDIO TRACK is displayed");
					}
					else
					{
						Reporter.fail("Playback Settings", "Playback Settings AUDIO TRACK is not displayed");
					}
					
					boolean blnSubTitle=isElementDisplayed(lblsubtitle);
					if(blnSubTitle)
					{
						Reporter.pass("Playback Settings", "Playback Settings SUBTITLES is displayed");
					}
					else
					{
						Reporter.fail("Playback Settings", "Playback Settings SUBTITLES is not displayed");
					}
					//Find the No of Audio Track Available
					List<WebElement> eleAudioTrack=driver.findElement(By.id("tv.hooq.android:id/spinnerAudioTrack")).findElements(By.className("android.widget.TextView"));
					Reporter.pass("Playback Settings Audio Track", "Playback Settings Total  "+ eleAudioTrack.size() +" Audio Track is displayed");
					for(int i=0;i<eleAudioTrack.size();i++)
					{
						String strAudioTrack=eleAudioTrack.get(i).getText();
						Reporter.pass("Playback Settings Audio Track", "Playback Settings "+ strAudioTrack+" is displayed");
					}
					//Find the No of Subtitle Track Available
					List<WebElement> eleSubTitle=driver.findElement(By.id("tv.hooq.android:id/spinnerSubtitles")).findElements(By.className("android.widget.TextView"));
					Reporter.pass("Playback Settings Subtitle", "Playback Settings Total  "+ eleSubTitle.size() +" Subtitle is displayed");
					for(int i=0;i<eleSubTitle.size();i++)
					{
						String strSubTitle= eleSubTitle.get(i).getText();
						Reporter.pass("Playback Settings SubTitle", "Playback Settings "+ strSubTitle+" is displayed");
					}
					if(eleSubTitle.size()>1)
					{
						eleSubTitle.get(1).click();
					}
					click(close,"Close");
					if(blnEpisode)
					{
						clickPlayPause();
						//Verify the Episode Details
						//Click on Episode Details Button
						clickEpisode();
						Reporter.pass("Playback Episode", "Playback Episode is Clicked Successfully");
						//Get The Season Details
						String strPlayerEpisode=fnGetPlayerWindowText(seasonCount);
						if(strPlayerEpisode.length()>0)
						{
							Reporter.pass("Playback Seasons", "Playback Seasons "+ strPlayerEpisode +" is displayed");
						}
						else
						{
							Reporter.fail("Playback Seasons", "Playback Seasons "+ strPlayerEpisode +" is not displayed");
						}
							//Get The Full List of Seasons
							List<WebElement> eleSeason=driver.findElement(By.id("tv.hooq.android:id/seasonList")).findElements(By.className("android.widget.TextView"));
							if(eleSeason.size()>0)
							{
								Reporter.pass("Playback Seasons", "Playback Season "+ eleSeason.size() +" is displayed");
							}
							else
							{
								Reporter.fail("Playback Seasons", "Playback Season "+ eleSeason.size() +" is not displayed");
							}
							for(int i=0;i<eleSeason.size();i++)
							{
								Reporter.pass("Playback Seasons", "Playback Season No "+ eleSeason.get(0).getText() +" Season Name " + eleSeason.get(1).getText() +" displayed");
								
							}
							List<WebElement> eleEpisode=driver.findElement(By.id("tv.hooq.android:id/container")).findElements(By.id("tv.hooq.android:id/episode_name"));
							List<WebElement> eleEpisodeNo=driver.findElement(By.id("tv.hooq.android:id/container")).findElements(By.id("tv.hooq.android:id/episode_number"));
							if(eleEpisode.size()>0)
							{
								Reporter.pass("Playback Episode", "Playback Episode "+ eleEpisode.size() +" is displayed");
							}
							else
							{
								Reporter.fail("Playback Episode", "Playback Episode "+ eleEpisode.size() +" is not displayed");
							}
							for(int i=0;i<eleEpisode.size();i++)
							{
								Reporter.pass("Playback Episode", "Playback Episode No "+ eleEpisodeNo.get(i).getText() +" Episode Name " + eleEpisode.get(i).getText() +" displayed");
							}
							click(closeEpList,"Close");
						}
						else
						{
							Reporter.fail("Playback Episode", "Playback Episode is Clicked Successfully");
						}
					}
					else
					{
						clickPlayPause();
					}
					waitforPlay(20000);
					clickPlayPause();
					strAfter=fnGetPlayerWindowText(timeCounter);
					driver.navigate().back();
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
			return blnStatus;
		}
		
		/***
		 * Function Name :- fnClickPlayerWindow
		 * Developed By  :- Pankaj Kumar
		 * Date			 :- 23-May-2019 	
		 ***/
		public  boolean fnClickPlayerWindow(By locator,boolean blnTouch)
		{
			boolean blnFound=false;
			for(int i=0;i<10;i++)
			{
				try
					{
					if(blnTouch)
					{
						Thread.sleep(5000);
						System.out.println("Iteration " + i +" Click on Player");
						WebElement el = driver.findElement(By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther"));
						el.click();
						//TouchAction touchAction = new TouchAction((MobileDriver) driver);
						//WebElement el = driver.findElement(By.xpath("//XCUIElementTypeScrollView"));
						//WebElement el = driver.findElement(By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther"));
						//touchAction.tap(el, el.getLocation().x, el.getLocation().y);
						//((PerformsTouchActions) driver).performTouchAction(touchAction);
						//el.click();
						//driver.findElement(By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView")).click();
					}
						driver.findElement(locator).click();
						return true;
					}
					catch(Exception e){System.out.println("Iteration " + i + " Fail to Click");}
				}
			return blnFound;
		}
		/***
		 * Function Name :- fnVerifyPlayerWindowElement
		 * Developed By  :- Pankaj Kumar
		 * Date			 :- 23-May-2019 	
		 ***/
		public  boolean fnVerifyPlayerWindowElement(By loc)
		{
			for(int i=0;i<10;i++)
			{	
				try
				{	
					Thread.sleep(5000);
					Dimension dimensions = driver.manage().window().getSize();
					int screenWidth = dimensions.getWidth();
					int screenHeight = dimensions.getHeight();
					System.out.println("X Coordinates ==> " + screenWidth);
					System.out.println("Y Coordinates ==> " + screenHeight);
					int intXActual=(int) (screenWidth/2);
					int intYActal=(int) (screenHeight/2);
					System.out.println(intXActual);
					System.out.println(intYActal);
					TouchAction action= new TouchAction((MobileDriver) driver);
					action.tap(intXActual, intYActal).perform();
					List<WebElement> eleList=driver.findElements(loc);
					if(eleList.size()>0)
					{
						return true;
					}
				}
				catch(Exception e){ System.out.println("Iteration " + i + " Fail to Read Text");}
			}
			return false;
		}
		
		/***
		 * Function Name :- fnGetPlayerWindowPageSource
		 * Developed By  :- Pankaj Kumar
		 * Date			 :- 23-May-2019 	
		 ***/
		public  String fnGetPlayerWindowPageSource()
		{
			String strText="";
			try
			{
				Thread.sleep(5000);
				WebElement el = driver.findElement(By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther"));
				el.click();
				strText=driver.getPageSource();
			}
			catch(Exception e)
			{
				Reporter.fnPrintException(e);
			}
			return strText;
		}
		
		/***
		 * Function Name :- fnGetPlayerWindowText
		 * Developed By  :- Pankaj Kumar
		 * Date			 :- 23-May-2019 	
		 ***/
		public  String fnGetPlayerWindowText(By loc)
		{
			String strText="";
			for(int i=0;i<10;i++)
			{	
				try
				{	
					Thread.sleep(5000);
					Dimension dimensions = driver.manage().window().getSize();
					int screenWidth = dimensions.getWidth();
					int screenHeight = dimensions.getHeight();
					System.out.println("X Coordinates ==> " + screenWidth);
					System.out.println("Y Coordinates ==> " + screenHeight);
					int intXActual=(int) (screenWidth/2);
					int intYActal=(int) (screenHeight/2);
					System.out.println(intXActual);
					System.out.println(intYActal);
					TouchAction action= new TouchAction((MobileDriver) driver);
					action.tap(intXActual, intYActal).perform();
					strText=driver.findElement(loc).getText();
					if(strText.length()>0)
					{
						return strText;
					}
				}
				catch(Exception e){ System.out.println("Iteration " + i + " Fail to Read Text");}
			}
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
		
		public boolean fnVerifyPlayer()
		{
			boolean blnStatus=true;
			try
			{
				System.out.println("");
				//Play pause
				clickPlayPause();
				boolean blnQualityChangeAudio=clickSettings();
				System.out.println(blnQualityChangeAudio);
				String strSource=driver.getPageSource();
				System.out.println(strSource);
				
			}
			catch(Exception e){blnStatus=false;}
			return blnStatus;
		}

		public boolean fnVerifyTrailerPlay() {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean fnVerifyDownloadPlay() {
			// TODO Auto-generated method stub
			return false;
		}
		
	}