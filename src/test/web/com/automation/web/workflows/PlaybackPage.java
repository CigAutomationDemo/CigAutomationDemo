package com.automation.web.workflows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.reports.Reporter;

public class PlaybackPage extends BasePage{

	//Plaback
	By trailerWindow =null;
	By movieTitlefstTVShow=null;
	By contentTitleTxt =null;
	By watchNowbtn=null;
	By signupBtn =null;
	By playerwindow =null;
	By restrictedContent =null;
	By playerTitleName =null;
	By novaPageValidation=null;
	By hooqLogo=null;
	By footerSignUP =null;
	By hooqlogoNew=null;
	By titleTxt=null;

	// Playback TVshow
	By tvShowMenu =null;
	By episodeDuration=null;
	By playersettingReamingTime =null;
	By playerPauseBtn =null;
	By playerForwardBtn =null;
	By playerRewindBtn =null;	   
	By playersettingMaximizeBtn =null;
	By playerSeasonEpisodeNo  =null;
	By findEpisodeBtn  =null;
	By audioSubtitleBtn  =null;
	By closeaudioSubtitleBtn  =null;
	By durationContentdetailapge  =null;
	By seasonDropdown  =null;
	By seasonSelectorLst  =null;
	By playRndmEpisode  =null;
	By hamburgerMenu  =null;
	By hamburgerDiscoverMenu  =null;

	//Playback Movies
	By rentedContent  =null;
	By moviesMenu  =null;

	// Audio_Subtitle
	By contentPageAudio = null;
	By contentPageSubtitle = null;
	By contentDetails_PlayBtn = null;


	//Locators
	public void fnLoadLocators()
	{
		try{
			if(objConfig.strDriverType!=null)
			{
				if(objConfig.strDriverType.equals("chromemobileview"))
				{
					//Plaback
					trailerWindow = By.xpath("//div[@id='trailerPlayer']");
					movieTitlefstTVShow=By.xpath("((//*[@class='e2e-portraitCollection'])[1]//div[2]/a[1]//img)[1]");
					contentTitleTxt = By.xpath("//*[contains(@class,'e2e-titleHeader TitleBasicInfo__TitleHeader')]");
					watchNowbtn=By.xpath("//*[contains(@class,'TitleActionButtons__DesktopButtonContainer')]/a");
					signupBtn = By.tagName("label");
					playerwindow = By.xpath("//*[contains(@class,'VideoComponent__VideoWrapper-adotv8-0')]");
					restrictedContent = By.xpath("//*[contains(@class,'PromptModalBase__ModalHeader')]");
					playerTitleName = By.xpath("//*[contains(@class,'e2e-player-title')]");
					novaPageValidation=By.xpath("//div[@id='payment-mount']//ul");
					hooqLogo=By.xpath("(//a[contains(@class,'HOOQLogo__Wrapper-sc')])[1]");
					footerSignUP = By.xpath("(//*[@href='/auth/signup'])[2]");
					hooqlogoNew=By.xpath("//*[@id='payment-mount']/section/div/a");
					titleTxt=By.xpath("//*[contains(@class,'e2e-player-title VideoTitle__MainTitle')]");

					// Playback TVshow
					tvShowMenu = By.xpath("(//*[contains(@href,'/tv-shows')])[1]");
					episodeDuration=By.xpath("//div[contains(@class,'EpisodeList__EpisodeDetail')]//div[2]");
					playersettingReamingTime =By.xpath("//*[contains(@class,'RemainingTimeDisplay')]");
					playerPauseBtn=By.xpath("//*[contains(@class,'PlayerControlsBottomContainer')]/div[2]");//*[contains(@icon,'pause.svg')]");
					playerForwardBtn=By.xpath("//*[contains(@icon,'forward-15.svg')]");
					playerRewindBtn=By.xpath("//*[contains(@icon,'rewind-15.svg')]");	   
					playersettingMaximizeBtn=By.xpath("//*[contains(@icon,'maximize.svg')]");
					playerSeasonEpisodeNo = By.xpath("//*[contains(@class,'e2e-player-title')]/following-sibling::div");
					findEpisodeBtn = By.xpath("//*[contains(@class,'e2e-player-episodes')]");
					audioSubtitleBtn = By.xpath("(//div[contains(@class,'VideoTitle__VideoTitleWrapper')]//following-sibling::div[contains(@class,'e2e-player-subtitle-audio')])[2]");
					closeaudioSubtitleBtn = By.xpath("//div[contains(@class,'MobileModal__TopRightPosition')]/div");//div[contains(@icon,'close-white.svg')]");
					durationContentdetailapge = By.xpath("//div[contains(@class,'TitleBasicInfo__Container')]//div[1]");
					seasonDropdown = By.xpath("//div[@class='tab-label']/span");
					seasonSelectorLst = By.cssSelector("ul.SeasonModalSelector__List-h7ngy2-0 li:nth-of-type(2)");
					playRndmEpisode = By.cssSelector("(//*[contains(@class, 'EpisodeList__Episode')]//button[contains(@class,'PlayButton__Button')])[6]");
					hamburgerMenu = By.xpath("(//img[@title='Menu'])[1]");
					hamburgerDiscoverMenu = By.xpath("//ul[contains(@class, 'SideMenu__NavMenu')]//li[1]//a");

					//Playback Movies
					rentedContent = By.xpath("(//a[contains(@class,'e2e-card Card__CardContainer-sc-1')])[1]");
					moviesMenu = By.xpath("(//*[contains(@href,'/movies')])[1]");
				}
				else if(objConfig.strDriverType.equals("androidchrome"))
				{
					//Playback
					trailerWindow = By.xpath("//div[@id='trailerPlayer']");
					movieTitlefstTVShow=By.xpath("((//*[@class='e2e-portraitCollection'])[1]//div[2]/a[1]//img)[1]");
					contentTitleTxt = By.xpath("//*[contains(@class,'e2e-titleHeader TitleBasicInfo__TitleHeader')]");//*[contains(@class,'e2e-player-title VideoTitle')]
					watchNowbtn=By.xpath("//*[contains(@class,'TitleActionButtons__DesktopButtonContainer')]/a");
					signupBtn = By.tagName("label");
					playerwindow = By.xpath("//*[contains(@class,'VideoComponent__VideoWrapper-adotv8-0')]");
					restrictedContent = By.xpath("//*[contains(@class,'PromptModalBase__ModalHeader')]");
					playerTitleName = By.xpath("//*[contains(@class,'e2e-player-title')]");
					novaPageValidation=By.xpath("//div[@id='payment-mount']//ul");
					hooqLogo=By.xpath("(//a[contains(@class,'HOOQLogo__Wrapper')])[1]");
					footerSignUP = By.xpath("(//*[@href='/auth/signup'])[2]");
					hooqlogoNew=By.xpath("//*[@id='payment-mount']/section/div/a");
					titleTxt=By.xpath("//*[contains(@class,'e2e-player-title VideoTitle__MainTitle')]");

					// Playback TVshow
					tvShowMenu = By.xpath("(//*[contains(@href,'/tv-shows')])[1]");
					episodeDuration=By.xpath("//div[contains(@class,'EpisodeList__EpisodeDetail-sc-1d8ke12')]//div[2]");
					playersettingReamingTime =By.xpath("//*[contains(@class,'RemainingTimeDisplay')]");
					playerPauseBtn=By.xpath("//*[contains(@class,'PlayerControlsBottomContainer')]/div[2]");//*[contains(@icon,'pause.svg')]");
					playerForwardBtn=By.xpath("//*[contains(@icon,'forward-15.svg')]");
					playerRewindBtn=By.xpath("//*[contains(@icon,'rewind-15.svg')]");	   
					playersettingMaximizeBtn=By.xpath("//*[contains(@class,'RemainingTimeDisplay')]//following-sibling::div");
					playerSeasonEpisodeNo = By.xpath("//*[contains(@class,'e2e-player-title')]/following-sibling::div");
					findEpisodeBtn = By.xpath("//*[contains(@class,'e2e-player-episodes')]");
					audioSubtitleBtn = By.xpath("(//div[contains(@class,'VideoTitle__VideoTitleWrapper')]//following-sibling::div[contains(@class,'e2e-player-subtitle-audio')])[2]");
					closeaudioSubtitleBtn = By.xpath("//div[contains(@class,'MobileModal__TopRightPosition')]/div");//div[contains(@icon,'close-white.svg')]");
					durationContentdetailapge = By.xpath("//div[@class='TitleBasicInfo__Container']//div[2]");
					seasonDropdown = By.xpath("//div[@class='tab-label']/span");
					seasonSelectorLst = By.cssSelector("ul.SeasonModalSelector__List-h7ngy2-0 li:nth-of-type(2)");
					playRndmEpisode = By.cssSelector("(//*[contains(@class, 'EpisodeList__Episode')]//button[contains(@class,'PlayButton__Button')])[6]");
					hamburgerMenu = By.xpath("//*[@id='mount']/header[1]/div/a[2]/img");
					hamburgerDiscoverMenu = By.xpath("//ul[contains(@class, 'SideMenu__NavMenu')]//li[1]//a");

					//Playback Movies
					rentedContent = By.xpath("(//a[contains(@class,'e2e-card Card__CardContainer-sc-1')])[1]");
					moviesMenu = By.xpath("(//*[contains(@href,'/movies')])[1]");

					//Audio_Subtitles 
					contentPageAudio = By.xpath("//div[contains(@class,'TitleBasicInfo__Container')]//div[2]");
					contentPageSubtitle = By.xpath("//div[contains(@class,'TitleBasicInfo__Container')]//div[3]");
					//contentDetails_PlayBtn = By.xpath("//h1/../../div/a//following-sibling::div/button");

				}

				else if(objConfig.strDriverType.equals("desktopchrome"))
				{
					//Playback
					trailerWindow = By.xpath("//div[@id='trailerPlayer']");
					movieTitlefstTVShow=By.xpath("((//*[@class='slick-track'])[1]//div[1]//a[1]//img)[1]");
					contentTitleTxt = By.xpath("//*[contains(@class,'e2e-titleHeader TitleBasicInfo__TitleHeader')]");
					watchNowbtn=By.xpath("//*[contains(@class,'TitleActionButtons__DesktopButtonContainer')]/a");
					signupBtn = By.tagName("label");
					playerwindow = By.xpath("//*[contains(@class,'VideoComponent__VideoWrapper-adotv8-0')]");
					restrictedContent = By.xpath("//*[contains(@class,'PromptModalBase__ModalHeader')]");
					playerTitleName = By.xpath("//*[contains(@class,'e2e-player-title')]"); 
					novaPageValidation=By.xpath("//div[@id='payment-mount']//ul");
					hooqLogo=By.xpath("(//a[contains(@class,'HOOQLogo__Wrapper')])[1]");
					footerSignUP = By.xpath("(//*[@href='/auth/signup'])[2]");
					hooqlogoNew=By.xpath("//*[@id='payment-mount']/section/div/a");
					titleTxt=By.xpath("//*[contains(@class,'e2e-player-title VideoTitle__MainTitle')]");

					// Playback TVshow
					tvShowMenu = By.xpath("(//*[contains(@href,'/tv-shows')])[2]");
					episodeDuration=By.xpath("//div[contains(@class,'EpisodeList__EpisodeDetail-sc')]//div[2]");
					playersettingReamingTime =By.xpath("//*[contains(@class,'RemainingTimeDisplay')]");
					playerPauseBtn=By.xpath("//*[contains(@class,'PlayerControlsBottomContainer__PlayerControlsBottom')]//div[2]//div[contains(@class,'Container')][1]//div[2]");//*[contains(@icon,'pause.svg')]");
					playerForwardBtn=By.xpath("//*[contains(@class,'PlayerControlsBottomContainer__PlayerControlsBottom')]//div[2]//div[contains(@class,'Container')][1]//div[3]");
					playerRewindBtn=By.xpath("//*[contains(@class,'PlayerControlsBottomContainer__PlayerControlsBottom')]//div[2]//div[contains(@class,'Container')][1]//div[1]");	   
					playersettingMaximizeBtn=By.xpath("//*[contains(@class,'e2e-player-subtitle-audio QualityControl__QualityButton')]//following-sibling::div");
					playerSeasonEpisodeNo = By.xpath("//*[contains(@class,'e2e-player-title')]/following-sibling::div");
					findEpisodeBtn = By.xpath("//*[contains(@class,'e2e-player-episodes EpisodeSelectorControl')]");
					audioSubtitleBtn = By.xpath("//*[contains(@class,'e2e-player-subtitle-audio SubtitleAudioControl__SubtitleAudioButton')]");
					closeaudioSubtitleBtn = By.xpath("//div[contains(@class,'MobileModal__TopRightPosition')]/div");//div[contains(@icon,'close-white.svg')]");
					durationContentdetailapge = By.xpath("//div[contains(@class,'TitleBasicInfo__DesktopMetaContainer')]");
					seasonDropdown = By.xpath("//div[@class='tab-label']/span");
					seasonSelectorLst = By.cssSelector("div#seasonSelectorWrapper a:nth-of-type(2)");
					playRndmEpisode = By.cssSelector("(//*[contains(@class, 'EpisodeList__Episode')]//button[contains(@class,'PlayButton__Button')])[6]");
					hamburgerMenu = By.xpath("(//img[@title='Menu'])[2]");
					hamburgerDiscoverMenu = By.xpath("//header[contains(@class,'desktop Header__HeaderContainer')]//a[contains(@class,'HOOQLogo__Wrapper')]");

					//Playback Movies
					rentedContent = By.xpath("(//a[contains(@class,'e2e-card Card__CardContainer-sc-1')])[1]");
					moviesMenu = By.xpath("(//*[contains(@href,'/movies')])[2]");
				}
			}
		}
		catch(Exception e){}
	}


	public boolean verifyPlayBack_DiscoverContent(String userType) throws Throwable
	{
		fnLoadLocators();
		boolean result=false;
		try
		{
			Thread.sleep(5000);
			if(waitForElementPresent(movieTitlefstTVShow,""))
			{
				WebElement title = driver.findElement(movieTitlefstTVShow);
				String fstTitle=title.getAttribute("title");
				Reporter.pass("Verify Content Title on Movies page" , fstTitle + " is dispalyed successfully");				
				List<WebElement> Content = driver.findElements(By.xpath("(//*[@class='e2e-portraitCollection'])[1]//div[2]/a//img"));			
				for(int i=1;i<=Content.size();i++)
				{	
					/*WebElement title1 = driver.findElement(By.xpath("(//*[@class='e2e-portraitCollection'])[1]//div[2]/a["+i+"]/img"));
					String fstTitle1 =title.getAttribute("title");
					 */click(By.xpath("(//*[@class='e2e-portraitCollection'])[1]//div[2]/a["+i+"]"),"Click on content");
					 Thread.sleep(3000);
					 String contentName=getText(contentTitleTxt,"");
					 if(isElementDisplayed(contentTitleTxt))
					 {	
						 Thread.sleep(3000);
						 if(isElementDisplayed(watchNowbtn))
						 {
							 if(fstTitle.equalsIgnoreCase(contentName))
							 {
								 Reporter.pass("Verify content title in content details page" , ""+ fstTitle +"" +  ""+ contentName+"" + " is Matched successfully");
								 result=true;
							 }
							 else
							 {
								 Reporter.fail("Verify content title in content details page" ,  ""+ fstTitle +"" +  ""+ contentName+"" + " contents are not Matched");
							 }															
							 if(userType.equalsIgnoreCase("Vistor"))
							 {
								 Thread.sleep(3000);
								 Reporter.pass("Verify content details Play Btn ", "Play button is displayed in content details page");	
								 JSClick(watchNowbtn, "Clicked on Play button");
								 Thread.sleep(5000);
								 if(isElementDisplayed(signupBtn))
								 {
									 String signupPage=getText(signupBtn, "Sign UP Page");
									 Reporter.pass("Verify Sign up", "Redirected to '"+signupPage + "' and is displayed successfully for Vistor user");
									 driver.navigate().back();
									 driver.navigate().back();
									 result=true;
								 }								
								 else if(isElementDisplayed(By.xpath("//div[contains(@class,'PromptModalBase__ModalButtonGroup-sc')]/a[1]")))
								 {
									 Reporter.pass("Verify movie player for Vistor user", "Signup page is displayed successfully while playing the Movie for the Vistor user ");	
									 click(By.xpath("//div[contains(@class,'PromptModalBase__ModalButtonGroup-sc')]/a[2]"), "Click on continue watching");
									 Thread.sleep(3000);
									 driver.navigate().back();
									 result=true;
								 }
								 else if(isElementDisplayed(trailerWindow))
								 {	
									 String titleName = getText(titleTxt, "Get title");
									 Reporter.pass("Verify Movie for Vistor user", "Signup page is not displayed while playing the trailer "+ titleName +"" );
									 driver.navigate().back();
									 result=true;
								 }
								 else if(isElementDisplayed(playerwindow))
								 {
									 Reporter.pass("Verify video player", "Able to play the trailer");	
									 String titleName = getText(titleTxt, "Get title");
									 Reporter.pass("Verify trailer for Vistor user", "Signup page is not displayed while playing the trailer"+ titleName +"");
									 driver.navigate().back();
									 driver.navigate().back();
									 result=true;
								 }
								 else 
								 {
									 Reporter.fail("Verify Movie for Vistor user", "Signup page is not displayed while playing the content with Vistor user");
									 result=false;
								 }
								 break;
							 }
							 else if(userType.equalsIgnoreCase("Active"))
							 {
								 Thread.sleep(2000);
								 Reporter.pass("Verify content details Play Btn ", "Play button is displayed in content details page");	
								 JSClick(watchNowbtn, "Clicked on Play button");
								 Thread.sleep(4000);
								 if(isElementDisplayed(restrictedContent))
								 {
									 for (int j = 1;j <= 4; j++)
									 {
										 driver.findElement(By.xpath("(//*[@type='tel'])["+j+"]")).sendKeys(String.valueOf(j));
									 }
									 Thread.sleep(2000);
								 }
								 else
								 {
									 Reporter.pass("Verify restricted content for SG", "Restricted content is present for SG");
								 }

								 if(isElementDisplayed(trailerWindow))
								 {
									 Reporter.pass("Verify video player", "Able to play the trailer");	
									 String titleName = getText(titleTxt, "Get title");
									 Reporter.pass("Verify Movie for Active user", "Trailer window is displayed for Active user from discover page"+ titleName +"");
									 driver.navigate().back();
									 result=true;
								 }

								 else if(isElementDisplayed(playerwindow))
								 {
									 Thread.sleep(5000);	
									 //click(playerwindow,"Click on player window");
									 String playerName = getText(playerTitleName,"Content Name");
									 System.out.println(playerName);	
									 Reporter.pass("Verify movie player for Active user", "Player window is displayed successfully while playing the Movie");	
									 driver.navigate().back();
									 Thread.sleep(3000);
									 //driver.navigate().back();
									 result=true;
									 if(isElementDisplayed(watchNowbtn))
									 {
										 Reporter.pass("Verify content deatails", "content deatils page is displayed after clicking on back button");	
										 driver.navigate().back();
									 }
								 }
								 else 
								 {
									 Reporter.fail("Verify movie player for Active user", "Player window is not displayed while playing the Movie");
									 result=false;
								 }		
								 break;
							 }
							 else if(userType.equalsIgnoreCase("Lapsed"))
							 {
								 Thread.sleep(2000);
								 Reporter.pass("Verify content details Play Btn ", "Play button is displayed in content details page");	
								 JSClick(watchNowbtn, "Clicked on Play button");
								 Thread.sleep(4000);

								 if(isElementDisplayed(restrictedContent))
								 {
									 for (int j = 1;j <= 4; j++)
									 {
										 driver.findElement(By.xpath("(//*[@type='tel'])["+j+"]")).sendKeys(String.valueOf(j));
									 }
									 Thread.sleep(2000);
								 }
								 else
								 {
									 Reporter.pass("Verify restricted content for SG", "Restricted content is present for SG");
								 }
								 if(isElementDisplayed(novaPageValidation))
								 {
									 Reporter.pass("Verify movie player for Lapsed user", "Nova planselector page is displayed successfully while playing the Movie");	
									 JSClick(hooqlogoNew,"Click on HOOQ logo");
									 Thread.sleep(3000);
									 driver.navigate().to(objConfig.strURL);
									 result=true;
								 }
								 else if(isElementDisplayed(footerSignUP))
								 {
									 driver.navigate().to(objConfig.strURL);
									 Thread.sleep(4000);
									 String url= driver.getCurrentUrl();
									 Reporter.pass("Verify content details URL", url+" displayed successfully"); 	
									 result= true;
								 }
								 else if(isElementDisplayed(playerwindow))
								 {
									 Reporter.pass("Verify video player", "Able to play the trailer");	
									 String titleName = getText(titleTxt, "Get title");
									 Reporter.pass("Verify trailer for Lapsed user", "Signup page is not displayed while playing the trailer"+ titleName +"");
									 driver.navigate().back();
									 driver.navigate().back();
									 result=true;
								 }
								 else 
								 {
									 Reporter.fail("Verify movie player for Lapsed user", "Nova planselector page is not displayed while playing the Movie");
									 result=false;
								 }
								 break;
							 }
						 }
						 else
						 {
							 Reporter.fail("Verify content details Play Btn ", "Play button is not displayed in content details page");
							 result=false;
						 }

					 }
					 else 
					 {
						 Reporter.pass("Verify content details Play Btn ", "Navigating back to next content as it is rented content");
						 driver.navigate().back();
						 Thread.sleep(3000);
					 }	
				}	
			}
			else
			{
				Reporter.fail("Verify Content Title on Movies page" , "Content is not dispalyed");
				driver.navigate().back();
				Thread.sleep(3000);
			}	
			Thread.sleep(4000);
			click(hooqLogo,"click on HOOQ logo");

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

	public boolean verifyPlayBackTVShows(String userType) throws Throwable
	{
		fnLoadLocators();
		boolean result=false;
		try
		{
			Thread.sleep(10000);
			click(tvShowMenu, "TV SHOWS");
			Thread.sleep(7000);
			waitForElementPresent(movieTitlefstTVShow,"");
			WebElement title = driver.findElement(movieTitlefstTVShow);
			//String fstTitle= ("Name of the button is:- " +title.getAttribute("title"));
			String fstTitle=title.getAttribute("title");
			Reporter.pass("Verify Content Title on TV Shows page" , fstTitle + " is dispalyed successfully");
			click(movieTitlefstTVShow, "Click on content");
			Thread.sleep(10000);
			String contentName=getText(contentTitleTxt,"");
			if(fstTitle.equalsIgnoreCase(contentName))
			{
				Reporter.pass("Verify content title in content details page" , ""+ fstTitle +"" +  ""+ contentName+"" + " is Matched successfully");
				result=true;

			}
			else
			{
				Reporter.fail("Verify content title in content details page" ,  ""+ fstTitle +"" +  ""+ contentName+"" + " contents are not Matched");
			}

			if(isElementDisplayed(watchNowbtn))
			{
				Reporter.pass("Verify content details Play Btn ", "Play button is displayed in content details page");	
			}			
			Thread.sleep(2000);					
			String titleName = getText(contentTitleTxt, "Get title");
			Thread.sleep(3000);
			Reporter.pass("Verify content title: ", titleName+ "is displayed");
			String episodeDurationTxt=getText(episodeDuration, "Episode Duration");
			System.out.println(episodeDurationTxt);	
			String[] arrOfEpisodetime = episodeDurationTxt.split("m");  
			for (String Episodelen : arrOfEpisodetime) 
				System.out.println(Episodelen); 
			System.out.println(arrOfEpisodetime[0]); 
			Thread.sleep(2000);	
			if(userType.equalsIgnoreCase("Vistor"))
			{
				JSClick(watchNowbtn,"Click on Watch now");
				Thread.sleep(3000);				
				if(isElementDisplayed(signupBtn))
				{
					String signupPage=getText(signupBtn, "Sign UP Page");
					Reporter.pass("Verify Sign up", "Redirected to '"+signupPage + "' and is displayed successfully for Vistor user");
					driver.navigate().back();
					driver.navigate().back();
					result=true;
				}				
				else if(isElementDisplayed(By.xpath("//div[contains(@class,'PromptModalBase__ModalButtonGroup-sc-1')]/a[1]")))
				{
					Reporter.pass("Verify movie player for Vistor user", "Signup page is displayed successfully while playing the Movie for the Vistor user ");	
					click(By.xpath("//div[contains(@class,'PromptModalBase__ModalButtonGroup-sc-1')]/a[2]"), "Click on continue watching");
					Thread.sleep(3000);
					driver.navigate().back();
					result=true;
				}
				else if(isElementDisplayed(playerwindow))
				{
					Thread.sleep(10000);		
					//click(playerwindow,"Click on player window");
					String remainingtime = getText(playersettingReamingTime,"get test of Reaming Time in player window");							
					if(!arrOfEpisodetime.equals(remainingtime))
					{
						Reporter.pass("Verify duration of content in player window and content deatils page", "duration "+arrOfEpisodetime+" +" +remainingtime+" is matching");
						result=true;
					}
					else
					{
						Reporter.fail("Verify duration of content in player window and content deatils page", "duration "+arrOfEpisodetime+" +" +remainingtime+" is not matching");
						result=false;
					}
					Thread.sleep(6000);
					//click(playerwindow,"Click on player window");
					String TitleName = getText(playerTitleName,"Content Name");
					System.out.println(TitleName);	
					Thread.sleep(5000);		
					//click(playerwindow,"Click on player window");
					String seasonEpisodeNo = getText(playerSeasonEpisodeNo,"season episode Name");
					System.out.println(seasonEpisodeNo);	
					String[] arrOfEpisodelst = seasonEpisodeNo.split(":"); 
					String[] arrOfEpisode = arrOfEpisodelst[1].split(" "); 
					for (String EpisodeNo : arrOfEpisode) 
						System.out.println(EpisodeNo); 
					System.out.println(arrOfEpisode[0]); 
					Reporter.pass("Verify movie player for Active user", "Player window is displayed successfully while playing the Movie");	

					Thread.sleep(5000);
					//click(playerwindow,"Click on player window");
					JSClick(playerPauseBtn,"Click on pause button");
					Thread.sleep(5000);
					//click(playerwindow,"Click on player window");
					JSClick(playerPauseBtn,"Click on play button");
					Thread.sleep(5000);
					//click(playerwindow,"Click on player window");
					JSClick(findEpisodeBtn,"Click on Find episode list button");
					Thread.sleep(3000);
					JSClick(By.xpath("(//button[contains(@class,'PlayButton__Button')])[3]"), "Click on 3rd episode from find episode");
					Thread.sleep(10000);
					//click(playerwindow,"Click on player window");
					String seasonEpisodeNo2 = getText(playerSeasonEpisodeNo,"Content Name");
					System.out.println(seasonEpisodeNo2);	
					String[] arrOfEpisodelst2 = seasonEpisodeNo2.split(":"); 
					String[] arrOfEpisode2 = arrOfEpisodelst2[1].split(" "); 
					for (String EpisodeNo2 : arrOfEpisode2) 
						System.out.println(EpisodeNo2); 
					System.out.println(arrOfEpisode2[0]); 

					if(!arrOfEpisode[0].equalsIgnoreCase(arrOfEpisode2[0]))
					{
						Reporter.pass("Verify episode changing", ""+arrOfEpisode[0]+" +" +arrOfEpisode2[0]+" is matching");
						result=true;
					}
					else
					{
						Reporter.fail("Verify episode changing", "duration "+arrOfEpisode[0]+" +" +arrOfEpisode2[0]+" is not matching");
						result=false;
					}					
					Thread.sleep(4000);
					//click(playerwindow,"Click on player window");
					JSClick(audioSubtitleBtn,"Click on Audio and subtitle button");
					Thread.sleep(3000);
					click(closeaudioSubtitleBtn,"Click on close button in player window");
					Thread.sleep(2000);
					Reporter.pass("Verify movie player for Active user", "Player window is displayed successfully while playing the Movie");	
					driver.navigate().back();
				}	
				else 
				{
					Reporter.fail("Verify trailer for Vistor user", "Signup page is not displayed while playing the Movie");
					result=false;
				}
			}

			else if(userType.equalsIgnoreCase("Active"))
			{	
				JSClick(watchNowbtn,"Click on Watch now");			
				if(isElementDisplayed(playerwindow))
				{
					Thread.sleep(15000);		
					//click(playerwindow,"Click on player window");
					String remainingtime = getText(playersettingReamingTime,"get test of Reaming Time in player window");							
					if(!arrOfEpisodetime.equals(remainingtime))
					{
						Reporter.pass("Verify duration of content in player window and content deatils page", "duration "+arrOfEpisodetime+" +" +remainingtime+" is matching");
						result=true;
					}
					else
					{
						Reporter.fail("Verify duration of content in player window and content deatils page", "duration "+arrOfEpisodetime+" +" +remainingtime+" is not matching");
						result=false;
					}
					Thread.sleep(6000);
					//click(playerwindow,"Click on player window");
					String TitleName = getText(playerTitleName,"Content Name");
					System.out.println(TitleName);	
					Thread.sleep(5000);		
					//click(playerwindow,"Click on player window");
					String seasonEpisodeNo = getText(playerSeasonEpisodeNo,"season episode Name");
					System.out.println(seasonEpisodeNo);	
					String[] arrOfEpisodelst = seasonEpisodeNo.split(":"); 
					String[] arrOfEpisode = arrOfEpisodelst[1].split(" "); 
					for (String EpisodeNo : arrOfEpisode) 
						System.out.println(EpisodeNo); 
					System.out.println(arrOfEpisode[0]); 
					Reporter.pass("Verify movie player for Active user", "Player window is displayed successfully while playing the Movie");	
					Thread.sleep(5000);
					//click(playerwindow,"Click on player window");
					JSClick(playerPauseBtn,"Click on pause button");
					Thread.sleep(5000);
					//click(playerwindow,"Click on player window");
					JSClick(playerPauseBtn,"Click on play button");
					Thread.sleep(5000);
					//click(playerwindow,"Click on player window");
					JSClick(findEpisodeBtn,"Click on Find episode list button");
					Thread.sleep(3000);
					JSClick(By.xpath("(//button[contains(@class,'PlayButton__Button')])[5]"), "Click on 5th episode from find episode");
					Thread.sleep(40000);
					if(!(isElementDisplayed(playerTitleName)))
					{
						JSClick(playerwindow,"Click on player window");
						click(playerwindow,"Click on player window");
					}
					Thread.sleep(2000); 
					String seasonEpisodeNo2 = getText(playerSeasonEpisodeNo,"season episode Name");
					System.out.println(seasonEpisodeNo2);	
					String[] arrOfEpisodelst2 = seasonEpisodeNo2.split(":"); 
					String[] arrOfEpisode2 = arrOfEpisodelst2[1].split(" "); 
					for (String EpisodeNo2 : arrOfEpisode2) 
						System.out.println(EpisodeNo2); 
					System.out.println(arrOfEpisode2[0]); 

					if(!arrOfEpisode[0].equalsIgnoreCase(arrOfEpisode2[0]))
					{
						Reporter.pass("Verify episode changing", ""+arrOfEpisode[0]+" +" +arrOfEpisode2[0]+" is matching");
						result=true;
					}
					else
					{
						Reporter.fail("Verify episode changing", "duration "+arrOfEpisode[0]+" +" +arrOfEpisode2[0]+" is not matching");
						result=false;
					}					
					Thread.sleep(4000);
					click(playerwindow,"Click on player window");
					JSClick(audioSubtitleBtn,"Click on Audio and subtitle button");
					Thread.sleep(3000);
					click(closeaudioSubtitleBtn,"Click on close button in player window");
					Thread.sleep(2000);
					Reporter.pass("Verify movie player for Active user", "Player window is displayed successfully while playing the Movie");	
					driver.navigate().back();
					Thread.sleep(3000);

					//select season and episode
					/*if(isElementDisplayed(seasonDropdown))
					{
						click(seasonDropdown,"Click on season dropdown list");
						Thread.sleep(3000);
						click(seasonSelectorLst,"Click on season selector list");
						Thread.sleep(3000);
						WebElement element = driver.findElement(By.xpath("(//*[contains(@class, 'EpisodeList__Episode')]//button[contains(@class,'PlayButton__Button')])[6]"));
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
						Thread.sleep(500); 
						Actions action = new Actions(driver);
						action.sendKeys(Keys.ARROW_UP).build().perform();		
						Thread.sleep(2000);
						action.sendKeys(Keys.ARROW_UP).build().perform();		
						Thread.sleep(2000);
						JSClick(playRndmEpisode,"Click on random episode");
						Thread.sleep(10000);
						click(playerwindow,"Click on player window");
						String seasonEpisodeNo3 = getText(playerSeasonEpisodeNo,"Content Name");
						System.out.println(seasonEpisodeNo3);						
						driver.navigate().back();
						result=true;
					}
					else
					{
						Reporter.pass("Verify season list dropdown", "Season list dropdown button will not be displayed for all tv shows");	
					}*/
				}
				else 
				{
					Reporter.fail("Verify movie player for Active user", "Player window is not displayed while playing the Movie");
					result=false;
				}
				if(isElementDisplayed(watchNowbtn))
				{
					Reporter.pass("Verify content deatails", "content deatils page is displayed after clicking on back button");	
					driver.navigate().back();
				}

			}
			else if(userType.equalsIgnoreCase("Lapsed"))
			{
				JSClick(watchNowbtn,"Click on Watch now");
				if(isElementDisplayed(novaPageValidation))
				{
					Reporter.pass("Verify movie player for Lapsed user", "Nova planselector page is displayed successfully while playing the Movie");	
					JSClick(hooqlogoNew,"Click on HOOQ logo");
					Thread.sleep(3000);
					driver.navigate().to(objConfig.strURL);
					result=true;
				}
				else if(isElementDisplayed(playerwindow))
				{
					Reporter.pass("Verify TVShow player for Lapsed user pilot episodes", "Player window is displayed successfully while playing the pilot episodes");	
					driver.navigate().back();
					Thread.sleep(3000);
					driver.navigate().back();
					driver.navigate().to(objConfig.strURL);
					result=true;
				}				
				else 
				{
					Reporter.fail("Verify movie player for Lapsed user", "Nova planselector page is not displayed while playing the Movie");
					result=false;
				}
			}
			Thread.sleep(4000);
			click(hamburgerMenu,"click on HOOQ logo");	
			Thread.sleep(4000);
			click(hamburgerDiscoverMenu,"click on HOOQ logo");

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

	public boolean verifyPlayBackMovies(String userType) throws Throwable
	{
		fnLoadLocators();
		boolean result=false;
		try
		{
			Thread.sleep(5500);
			click(moviesMenu,"click on Movies Tab");
			Thread.sleep(5000);
			if(waitForElementPresent(movieTitlefstTVShow,""))
			{			
				WebElement title = driver.findElement(movieTitlefstTVShow);
				//String fstTitle= ("Name of the button is:- " +title.getAttribute("title"));
				String fstTitle=title.getAttribute("title");
				Reporter.pass("Verify Content Title on Movies page" , fstTitle + " is dispalyed successfully");			
				//click(movieTitlefstTVShow,"click on first content");	
				List<WebElement> Content = driver.findElements(By.xpath("(//*[@class='e2e-portraitCollection'])[1]//div[2]/a//img"));			
				for(int i=1;i<=Content.size();i++)
				{	
					WebElement title1 = driver.findElement(By.xpath("((//*[@class='e2e-portraitCollection'])[1]//div[2]/a["+i+(+1)+"]//img)[1]"));
					String fstTitle1 =title.getAttribute("title");
					click(By.xpath("((//*[@class='e2e-portraitCollection'])[1]//div[2]/a["+i+(+1)+"])[1]"),"Click on content");
					Thread.sleep(3000);
					String contentName=getText(contentTitleTxt,"");
					//String durationOfMovie=getText(durationContentdetailapge,"Get duration of movie content");			
					if(isElementDisplayed(contentTitleTxt))
					{	
						//click(BackArrow, "Cliked on back arrow button");
						Thread.sleep(3000);
						if(isElementDisplayed(watchNowbtn))
						{
							if(fstTitle.equalsIgnoreCase(contentName))
							{
								Reporter.pass("Verify content title in content details page" , ""+ fstTitle +"" +  ""+ contentName+"" + " is Matched successfully");
								result=true;
							}
							else
							{
								Reporter.fail("Verify content title in content details page" ,  ""+ fstTitle +"" +  ""+ contentName+"" + " contents are not Matched");
							}
						}															
						if(userType.equalsIgnoreCase("Vistor"))
						{
							Thread.sleep(3000);
							Reporter.pass("Verify content details Play Btn ", "Play button is displayed in content details page");	
							JSClick(watchNowbtn, "Clicked on Play button");
							Thread.sleep(5000);
							if(isElementDisplayed(signupBtn))
							{
								String signupPage=getText(signupBtn, "Sign UP Page");
								Reporter.pass("Verify Sign up", "Redirected to '"+signupPage + "' and is displayed successfully for Vistor user");
								driver.navigate().back();
								driver.navigate().back();
								result=true;
							}						
							else if(isElementDisplayed(By.xpath("//div[contains(@class,'PromptModalBase__ModalButtonGroup-sc-1')]/a[1]")))
							{
								Reporter.pass("Verify movie player for Vistor user", "Signup page is displayed successfully while playing the Movie for the Vistor user ");	
								click(By.xpath("//div[contains(@class,'PromptModalBase__ModalButtonGroup-sc-1')]/a[2]"), "Click on continue watching");
								Thread.sleep(3000);
								driver.navigate().back();
								result=true;
							}
							else if(isElementDisplayed(By.xpath("//div[@id='trailerPlayer']")))
							{
								Reporter.pass("Verify video player", "Able to play the trailer");	
								//String titleName = getText(titleTxt, "Get title");
								Reporter.pass("Verify Movie for Vistor user", "Signup page is not displayed while playing the trailer");
								driver.navigate().back();
								result=true;
							}
							else if(isElementDisplayed(playerwindow))
							{
								Reporter.pass("Verify video player", "Able to play the trailer");	
								//String titleName = getText(titleTxt, "Get title");
								Reporter.pass("Verify trailer for Lapsed user", "Signup page is not displayed while playing the trailer");
								driver.navigate().back();
								result=true;
							}
							else 
							{
								Reporter.fail("Verify Movie for Vistor user", "Signup page is not displayed while playing the content with Vistor user");
								result=false;
							}
							break;
						}
						else if(userType.equalsIgnoreCase("Active"))
						{
							Thread.sleep(5000);	
							Reporter.pass("Verify content details Play Btn ", "Play button is displayed in content details page");	
							JSClick(watchNowbtn, "Clicked on Play button");
							Thread.sleep(5000);
							if(isElementDisplayed(restrictedContent))
							{
								for (int j = 1;j <= 4; j++)
								{
									driver.findElement(By.xpath("(//*[@type='tel'])["+j+"]")).sendKeys(String.valueOf(j));
								}
								Thread.sleep(2000);
							}
							else
							{
								Reporter.pass("Verify restricted content for SG", "Restricted content is present for SG");
							}
							if(isElementDisplayed(playerwindow))
							{
								Thread.sleep(5000);										
								//click(playerwindow,"Click on player window");
								String playerName = getText(playerTitleName,"Content Name");
								System.out.println(playerName);
								Thread.sleep(4000);
								//click(playerwindow,"Click on player window");
								String remainingtime = getText(playersettingReamingTime,"get test of Reaming Time in player window");							
								/*Thread.sleep(40000);
								click(playerwindow,"Click on player window");
								String updatedtime = getText(playersettingReamingTime,"get test of Reaming Time in player window");							
								Thread.sleep(2000);
								if(remainingtime.(updatedtime))
								{
									Reporter.pass("Verify duration of content in player window and content deatils page", "duration "+remainingtime+" +" +updatedtime+" should not be matching");
									result=true;
								}
								else
								{
									Reporter.fail("Verify duration of content in player window and content deatils page", "duration "+durationOfMovie+" +" +remainingtime+" is not matching");
									result=false;
								}*/
								Thread.sleep(5000);
								//click(playerwindow,"Click on player window");
								JSClick(playerPauseBtn,"Click on pause button");
								Thread.sleep(5000);
								//click(playerwindow,"Click on player window");
								JSClick(playerPauseBtn,"Click on pause button");
								Thread.sleep(5000);
								//click(playerwindow,"Click on player window");
								JSClick(audioSubtitleBtn,"Click on Audio and subtitle button");
								Thread.sleep(3000);
								click(closeaudioSubtitleBtn,"Click on close button in player window");
								Thread.sleep(2000);
								Reporter.pass("Verify movie player for Active user", "Player window is displayed successfully while playing the Movie");	
								driver.navigate().back();
								Thread.sleep(5000);
								//driver.navigate().back();
								result=true;
							}
							if(isElementDisplayed(watchNowbtn))
							{
								Reporter.pass("Verify content deatails", "content deatils page is displayed after clicking on back button");	
								driver.navigate().back();
							}
							else 
							{
								Reporter.fail("Verify movie player for Active user", "Player window is not displayed while playing the Movie");
								result=false;
							}							
							break;
						}
						else if(userType.equalsIgnoreCase("Lapsed"))
						{
							Thread.sleep(2000);
							Reporter.pass("Verify content details Play Btn ", "Play button is displayed in content details page");	
							JSClick(watchNowbtn, "Clicked on Play button");
							Thread.sleep(5000);
							if(isElementDisplayed(restrictedContent))
							{
								for (int j = 1;j <= 4; j++)
								{
									driver.findElement(By.xpath("(//*[@type='tel'])["+j+"]")).sendKeys(String.valueOf(j));
								}
								Thread.sleep(2000);
							}
							else
							{
								Reporter.pass("Verify restricted content for SG", "Restricted content is present for SG");
							}
							if(isElementDisplayed(novaPageValidation))
							{
								Reporter.pass("Verify movie player for Lapsed user", "Nova planselector page is displayed successfully while playing the Movie");	
								JSClick(hooqlogoNew,"Click on HOOQ logo");
								Thread.sleep(3000);
								System.out.println(driver.getCurrentUrl());
								driver.navigate().to(objConfig.strURL);
								result=true;
							}
							else if(isElementDisplayed(footerSignUP))
							{
								driver.navigate().to(objConfig.strURL);
								Thread.sleep(4000);
								String url= driver.getCurrentUrl();
								Reporter.pass("Verify content details URL", url+" displayed successfully"); 	
								result= true;
							}
							else if(isElementDisplayed(playerwindow))
							{
								Reporter.pass("Verify video player", "Able to play the trailer");	
								//String titleName = getText(titleTxt, "Get title");
								Reporter.pass("Verify trailer for Lapsed user", "Signup page is not displayed while playing the trailer");
								driver.navigate().back();
								result=true;
							}
							else 
							{
								Reporter.fail("Verify movie player for Lapsed user", "Nova planselector page is not displayed while playing the Movie");
								result=false;
							}
							break;
						}
					}
					else 
					{
						Reporter.pass("Verify content details Play Btn ", "Navigating back to next content as it is rented content");
						driver.navigate().back();
						Thread.sleep(3000);
					}	
				}	
			}
			else
			{
				Reporter.fail("Verify Content Title on Movies page" , "Content is not dispalyed");
				driver.navigate().back();
				Thread.sleep(3000);
			}	
			Thread.sleep(4000);
			click(hooqLogo,"click on HOOQ logo");	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

	public boolean verifyAudio_Subitle(String struserID,String userType) throws Throwable
	{
		fnLoadLocators();
		boolean result=false;
		try
		{
			if(struserID.equalsIgnoreCase("tvshows"))
			{
				click(tvShowMenu, "TV SHOWS");
				Thread.sleep(7000);
				waitForElementPresent(movieTitlefstTVShow,"");
				WebElement title = driver.findElement(movieTitlefstTVShow);
				String fstTitle=title.getAttribute("title");
				Reporter.pass("Verify Content Title on TV Shows page" , fstTitle + " is dispalyed successfully");
				click(movieTitlefstTVShow, "Click on content");
				Thread.sleep(10000);
				String contentName=getText(contentTitleTxt,"");
				if(fstTitle.equalsIgnoreCase(contentName))
				{
					Reporter.pass("Verify content title in content details page" , ""+ fstTitle +"" +  ""+ contentName+"" + " is Matched successfully");
					result=true;
				}
				else
				{
					Reporter.fail("Verify content title in content details page" ,  ""+ fstTitle +"" +  ""+ contentName+"" + " contents are not Matched");
				}
			}
			else if(struserID.equalsIgnoreCase("movie"))
			{
				Thread.sleep(5500);
				click(moviesMenu,"click on Movies Tab");
				Thread.sleep(8000);
				waitForElementPresent(movieTitlefstTVShow,"");
				WebElement title = driver.findElement(movieTitlefstTVShow);
				String fstTitle=title.getAttribute("title");
				Reporter.pass("Verify Content Title on Movies page" , fstTitle + " is dispalyed successfully");										
				click(movieTitlefstTVShow, "Click on content");
				Thread.sleep(10000);
				String contentName=getText(contentTitleTxt,"");
				if(fstTitle.equalsIgnoreCase(contentName))
				{
					Reporter.pass("Verify content title in content details page" , ""+ fstTitle +"" +  ""+ contentName+"" + " is Matched successfully");
					result=true;
				}
				else
				{
					Reporter.fail("Verify content title in content details page" ,  ""+ fstTitle +"" +  ""+ contentName+"" + " contents are not Matched");
				}			
			}
			Thread.sleep(5000);
			List<WebElement> contentDetailsAudioList=driver.findElements(contentPageAudio);
			for(int i=0;i< contentDetailsAudioList.size();i++)
			{
				String contentTxt= contentDetailsAudioList.get(i).getText();	
				Reporter.pass("Verify Content Details " , contentTxt + "  is dispalyed successfully");
				String audioList = getText(contentPageAudio, "List of Audio titles in content details page");
				System.out.println(audioList);
			}
			List<WebElement> contentDetailsSubtitleList=driver.findElements(contentPageSubtitle);
			for(int i=0;i< contentDetailsSubtitleList.size();i++)
			{
				String contentTxt= contentDetailsSubtitleList.get(i).getText();	
				Reporter.pass("Verify Content Details " , contentTxt + "  is dispalyed successfully");
				String subtitleList = getText(contentPageSubtitle, "List of subtitles in content details page");
				System.out.println(subtitleList);
			}
			if(isElementDisplayed(watchNowbtn))
			{
				if(userType.equalsIgnoreCase("Active"))
				{
					Thread.sleep(2000);
					Reporter.pass("Verify content details Play Btn ", "Play button is displayed in content details page");	
					JSClick(watchNowbtn, "Clicked on Play button");
					Thread.sleep(3000);
					if(isElementDisplayed(trailerWindow))
					{
						Reporter.pass("Verify video player", "Able to play the trailer");	
						//String titleName = getText(titleTxt, "Get title");
						Reporter.pass("Verify Movie for Active user", "Trailer window is displayed for Active user from discover page");
						driver.navigate().back();
						result=true;
					}
					else if(isElementDisplayed(playerwindow))
					{
						Thread.sleep(10000);		
						//click(playerwindow,"Click on player window");
						String playerName = getText(playerTitleName,"Content Name");
						System.out.println(playerName);	
						//click(playerwindow,"Click on player window");
						click(audioSubtitleBtn,"Click onAudio & Subtitle Button");
						List<WebElement> playerAudioList=driver.findElements(By.xpath("(//div[contains(@class,'SubtitleAudioSelector')]//ul)[1]/li"));
						for(int i=0;i< playerAudioList.size();i++)
						{
							String contentTxt= playerAudioList.get(i).getText();	
							Reporter.pass("Verify Content Details " , contentTxt + "  is dispalyed successfully");
							/*String audioList = getText(By.xpath("(//div[contains(@class,'SubtitleAudioSelector')]//ul)[1]/li"), "List of Audio title in content details page");
						System.out.println(audioList);*/
						}
						List<WebElement> playerSubtitleList=driver.findElements(By.xpath("(//div[contains(@class,'SubtitleAudioSelector')]//ul)[2]/li"));
						for(int i=0;i< playerSubtitleList.size();i++)
						{
							String contentTxt= playerSubtitleList.get(i).getText();	
							Reporter.pass("Verify Content Details " , contentTxt + "  is dispalyed successfully");
							/*String subtitleList = getText(By.xpath("(//div[contains(@class,'SubtitleAudioSelector')]//ul)[2]/li"), "List of subtitles in content details page");
						System.out.println(subtitleList);*/
						}
						click(closeaudioSubtitleBtn,"Click on close button in player window");
						Thread.sleep(2000);
						Reporter.pass("Verify movie player for Active user", "Player window is displayed successfully while playing the Movie");	
						driver.navigate().back();
						Thread.sleep(3000);
						//driver.navigate().back();
						result=true;
						if(isElementDisplayed(watchNowbtn))
						{
							Reporter.pass("Verify content deatails", "content deatils page is displayed after clicking on back button");	
							driver.navigate().back();
						}
					}
					else 
					{
						Reporter.fail("Verify movie player for Active user", "Player window is not displayed while playing the Movie");
						result=false;
					}		
				}
				else if(userType.equalsIgnoreCase("Lapsed"))
				{
					Thread.sleep(2000);
					Reporter.pass("Verify content details Play Btn ", "Play button is displayed in content details page");	
					JSClick(watchNowbtn, "Clicked on Play button");
					Thread.sleep(3000);
					if(isElementDisplayed(novaPageValidation))
					{
						Reporter.pass("Verify movie player for Lapsed user", "Nova planselector page is displayed successfully while playing the Movie");	
						JSClick(hooqlogoNew,"Click on HOOQ logo");
						Thread.sleep(3000);
						driver.navigate().to(objConfig.strURL);
						result=true;
					}				
					else if(isElementDisplayed(playerwindow))
					{
						Thread.sleep(20000);		
						click(playerwindow,"Click on player window");
						String playerName = getText(playerTitleName,"Content Name");
						System.out.println(playerName);	
						click(playerwindow,"Click on player window");
						click(audioSubtitleBtn,"Click onAudio & Subtitle Button");
						List<WebElement> playerAudioList=driver.findElements(By.xpath("(//div[contains(@class,'SubtitleAudioSelector')]//ul)[1]/li"));
						for(int i=0;i< contentDetailsSubtitleList.size();i++)
						{
							String contentTxt= contentDetailsSubtitleList.get(i).getText();	
							Reporter.pass("Verify Content Details " , contentTxt + "  is dispalyed successfully");
							String audioList = getText(By.xpath("(//div[contains(@class,'SubtitleAudioSelector')]//ul)[1]/li"), "List of Audio title in content details page");
							System.out.println(audioList);
						}
						List<WebElement> playerSubtitleList=driver.findElements(By.xpath("(//div[contains(@class,'SubtitleAudioSelector')]//ul)[2]/li"));
						for(int i=0;i< contentDetailsSubtitleList.size();i++)
						{
							String contentTxt= contentDetailsSubtitleList.get(i).getText();	
							Reporter.pass("Verify Content Details " , contentTxt + "  is dispalyed successfully");
							String subtitleList = getText(By.xpath("(//div[contains(@class,'SubtitleAudioSelector')]//ul)[2]/li"), "List of subtitles in content details page");
							System.out.println(subtitleList);
						}
						click(closeaudioSubtitleBtn,"Click on close button in player window");
						Thread.sleep(2000);
						Reporter.pass("Verify movie player for Active user", "Player window is displayed successfully while playing the Movie");	
						driver.navigate().back();
						Thread.sleep(3000);
						//driver.navigate().back();
						result=true;
						if(isElementDisplayed(watchNowbtn))
						{
							Reporter.pass("Verify content deatails", "content deatils page is displayed after clicking on back button");	
							driver.navigate().back();
						}
					}
					else if(isElementDisplayed(footerSignUP))
					{
						driver.navigate().to(objConfig.strURL);
						Thread.sleep(4000);
						String url= driver.getCurrentUrl();
						Reporter.pass("Verify content details URL", url+" displayed successfully"); 	
						result= true;
					}
					else 
					{
						Reporter.fail("Verify movie player for Lapsed user", "Nova planselector page is not displayed while playing the Movie");
						result=false;
					}
				}	
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
}
