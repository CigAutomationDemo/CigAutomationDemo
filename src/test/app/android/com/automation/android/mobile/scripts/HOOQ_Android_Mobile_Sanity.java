package com.automation.android.mobile.scripts;

import org.testng.annotations.Test;

import com.automation.accelerators.TestConfig;
import com.automation.android.workflows.BasePage;
import com.automation.reports.Reporter;
import com.automation.utilities.HOOQInput;
import com.automation.utilities.Settings;
public class HOOQ_Android_MOBILE_Sanity extends BasePage {
	
	/***
	 * Test Script Name :-HOOQ_Android_MOBILE_ME
	 * Developed By 	:-Pankaj Kumar
	 * Date				:-20_may-2019
	 * Test Description :-Verify ME Section
	 * Test Rail ID		:-14083
	 */
	@Test(priority = 1,groups={TestConfig.Android,TestConfig.Sanity,"HOOQ_Android_MOBILE_ME"})
	public void HOOQ_Android_MOBILE_ME() throws Throwable
	{
		//Add Test Rail ID
		HOOQInput.fnAddTestRailScriptID(Settings.Android_Test_1);
		try 
		{		
			loginPage.fnVerifyReLoginStatus(objData.ACTIVE_USER_ID, objData.COUNTRY, objData.ENV);
			if(mePage.verifyingMePage(false))
			{
				Reporter.pass("HOOQ Android Sanity", "Me Section is displayed");
			} else{
				Reporter.fail("HOOQ Android Sanity", "Me Section is not  displayed");
			}
		}
		catch(Exception e){Reporter.fnPrintException(e);}
		fnCloseTest();
	}
	
	/***
	 * Test Script Name :-HOOQ_Android_Mobile_Content_Details_Movie
	 * Developed By 	:-Pankaj Kumar
	 * Date				:-20_may-2019
	 * Test Description :-Verify Content Details Movies
	 * Test Rail ID		:-14090
	 */
	@Test(priority = 2,groups={TestConfig.Android,TestConfig.Sanity,"HOOQ_Android_Mobile_Content_Details_Movie"})
	public void HOOQ_Android_Mobile_Content_Details_Movie() throws Throwable
	{
		//Add Test Rail ID
		HOOQInput.fnAddTestRailScriptID(Settings.Android_Test_2);
		try 
		{					
			loginPage.fnVerifyReLoginStatus(objData.ACTIVE_USER_ID, objData.COUNTRY, objData.ENV);
			if(searchPage.clickAndSearch(objData.FREE_CONTENT))
			{
				Reporter.pass("HOOQ Android Sanity", "Search of Movies " + objData.FREE_CONTENT + "is displayed");
				if(contentDetailsPage.fnVerifyContentDetailsMovie())
				{
					Reporter.pass("HOOQ Android Sanity", "Content Details of Movies " + objData.FREE_CONTENT + "is displayed");
				}
				else
				{
					Reporter.fail("HOOQ Android Sanity", "Content Details of Movies " + objData.FREE_CONTENT + "is not displayed");
				}
			} else{
				Reporter.fail("HOOQ Android Sanity", "Search of Movies " + objData.FREE_CONTENT + "is displayed");
			}
		}
		catch(Exception e){Reporter.fnPrintException(e);}
		fnCloseTest();
	}
	
	/***
	 * Test Script Name :-HOOQ_Android_MOBILE_TVShows_Play
	 * Developed By 	:-Pankaj Kumar
	 * Date				:-20_may-2019
	 * Test Description :-Verify Movie Play
	 * Test Rail ID		:-14092
	 ***/
	@Test(priority = 3,groups={TestConfig.Android,TestConfig.Sanity,"HOOQ_Android_MOBILE_TVShows_Play"})
	public void HOOQ_Android_MOBILE_TVShows_Play() throws Throwable
	{
		//Add Test Rail ID
		HOOQInput.fnAddTestRailScriptID(Settings.Android_Test_3);
		try 
		{		
			loginPage.fnVerifyReLoginStatus(objData.ACTIVE_USER_ID, objData.COUNTRY, objData.ENV);
			Reporter.info("HOOQ Android Sanity","Verifying HOOQ_Android_MOBILE_TVShows_Play");
			if(searchPage.clickAndSearch(objData.TV_SERIES))
			{
				Reporter.pass("HOOQ Android Sanity", "Search of TVShows " + objData.TV_SERIES + "is displayed");
				contentDetailsPage.playVideo();
				if(playerpage.fnVerifyPlayback(false,""))
				{
					Reporter.pass("HOOQ Android Sanity", "Playback TVShows " + objData.TV_SERIES + "is Playing successfully");
				}
				else
				{
					Reporter.fail("HOOQ Android Sanity", "Playback TVShows " + objData.TV_SERIES + "is not Playing successfully");
				}
			} else{
				Reporter.fail("HOOQ Android Sanity", "Search of TVShows " + objData.TV_SERIES + "is not displayed");
			}
		}
		catch(Exception e){Reporter.fnPrintException(e);}
		fnCloseTest();
	}
	
	/***
	 * Test Script Name :-HOOQ_Android_MOBILE_Verify_LogOut
	 * Developed By 	:-Pankaj Kumar
	 * Date				:-20_may-2019
	 * Test Description :-Verify Logout from HOOQ
	 * Test Rail ID		:-14107
	 */
	@Test(priority = 4,groups={TestConfig.Android,TestConfig.Sanity,"HOOQ_Android_MOBILE_Verify_LogOut"})
	public void HOOQ_Android_MOBILE_Verify_LogOut() throws Throwable
	{
		//Add Test Rail ID
		HOOQInput.fnAddTestRailScriptID(Settings.Android_Test_4);
		try 
		{		
			loginPage.fnVerifyReLoginStatus(objData.ACTIVE_USER_ID, objData.COUNTRY, objData.ENV);
			if(loginPage.logOut())
			{
				Reporter.pass("HOOQ Android Sanity", "Logout from HOOQ is successfully done");
			} else{
				Reporter.fail("HOOQ Android Sanity", "Logout from HOOQ is not successfully done");
			}
		}
		catch(Exception e){Reporter.fnPrintException(e);}
		fnCloseTest();
	}
}
