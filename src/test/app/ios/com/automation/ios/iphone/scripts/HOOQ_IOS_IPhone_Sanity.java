package com.automation.ios.iphone.scripts;

import org.testng.annotations.Test;

import com.automation.accelerators.TestConfig;
import com.automation.ios.workflows.BasePage;
import com.automation.reports.Reporter;
import com.automation.utilities.HOOQInput;
import com.automation.utilities.Settings;
public class HOOQ_IOS_IPhone_Sanity extends BasePage {
	
	/***
	 * Test Script Name :-HOOQ_IOS_MOBILE_ME
	 * Developed By 	:-Pankaj Kumar
	 * Date				:-20_may-2019
	 * Test Description :-Verify ME Section
	 * Test Rail ID		:-14083
	 */
	@Test(priority = 1,groups={TestConfig.IPhone,"Sanity","HOOQ_IOS_MOBILE_ME"})
	public void HOOQ_IOS_MOBILE_ME() throws Throwable
	{
		//Add Test Rail ID
		HOOQInput.fnAddTestRailScriptID(Settings.IOS_Test_1);
		try 
		{		
			loginPage.fnVerifyReLoginStatus(objData.ACTIVE_USER_ID, objData.COUNTRY, objData.ENV);
			if(mePage.verifyingMePage(false))
			{
				Reporter.pass("HOOQ Sanity", "Me Section is displayed");
			} else{
				Reporter.fail("HOOQ Sanity", "Me Section is not displayed");
			}
		}
		catch(Exception e){Reporter.fnPrintException(e);}
		fnCloseTest();
	}
	
	/***
	 * Test Script Name :-HOOQ_IOS_MOBILE_Content_Details_Movie
	 * Developed By 	:-Pankaj Kumar
	 * Date				:-20_may-2019
	 * Test Description :-Verify Content Details Movies
	 * Test Rail ID		:-14090
	 */
	@Test(priority = 2,groups={TestConfig.IPhone,"Sanity","HOOQ_IOS_MOBILE_Content_Details_Movie"})
	public void HOOQ_IOS_MOBILE_Content_Details_Movie() throws Throwable
	{
		//Add Test Rail ID
		HOOQInput.fnAddTestRailScriptID(Settings.IOS_Test_2);
		try 
		{		
			loginPage.fnVerifyReLoginStatus(objData.ACTIVE_USER_ID, objData.COUNTRY, objData.ENV);
			if(searchPage.clickAndSearch(objData.FREE_CONTENT))
			{
				Reporter.pass("HOOQ Sanity", "Search of Movies " + objData.FREE_CONTENT + "is displayed");
				if(contentDetails.fnVerifyContentDetailsMovie())
				{
					Reporter.pass("HOOQ Sanity", "Content Details of Movies " + objData.FREE_CONTENT + "is displayed");
				}
				else
				{
					Reporter.fail("HOOQ Sanity", "Content Details of Movies " + objData.FREE_CONTENT + "is not displayed");
				}
			} else{
				Reporter.fail("HOOQ Sanity", "Search of Movies " + objData.FREE_CONTENT + "is displayed");
			}
		}
		catch(Exception e){Reporter.fnPrintException(e);}
		fnCloseTest();
	}
	
	
	/***
	 * Test Script Name :-HOOQ_IOS_MOBILE_Movie_Play
	 * Developed By 	:-Pankaj Kumar
	 * Date				:-20_may-2019
	 * Test Description :-Verify Movie Play
	 * Test Rail ID		:-14092
	 ***/
	@Test(priority = 3,groups={TestConfig.IPhone,"Sanity","HOOQ_IOS_MOBILE_Movie_Play"})
	public void HOOQ_IOS_MOBILE_Movie_Play() throws Throwable
	{
		//Add Test Rail ID
		HOOQInput.fnAddTestRailScriptID(Settings.IOS_Test_3);
		try 
		{		
			loginPage.fnVerifyReLoginStatus(objData.ACTIVE_USER_ID, objData.COUNTRY, objData.ENV);
			meDownloadPage.fnClearDownloadEntry();
			if(searchPage.clickAndSearch(objData.FREE_CONTENT))
			{
				Reporter.pass("HOOQ Sanity", "Search of Movies " + objData.FREE_CONTENT + "is displayed");
				if(contentDetails.fnClickPlay())
				{
					if(playPage.fnVerifyPlayback(false,"full"))
					{
						Reporter.pass("HOOQ Sanity", "Playback Movies " + objData.FREE_CONTENT + "is Playing successfully");
					}
					else
					{
						Reporter.fail("HOOQ Sanity", "Playback Movies " + objData.FREE_CONTENT + "is not Playing successfully");
					}
				}
				else
				{
					Reporter.fail("HOOQ Sanity", "Playback Movies " + objData.FREE_CONTENT + "Play button is not displayed");
				}
			} else{
				Reporter.fail("HOOQ Sanity", "Search of Movies " + objData.FREE_CONTENT + "is not displayed");
			}
		}
		catch(Exception e){Reporter.fnPrintException(e);}
		fnCloseTest();
	}

	@Test(priority = 4,groups={TestConfig.IPhone,"Sanity","HOOQ_IOS_MOBILE_Verify_LogOut"})
	public void HOOQ_IOS_MOBILE_Verify_LogOut() throws Throwable
	{
		//Add Test Rail ID
		HOOQInput.fnAddTestRailScriptID(Settings.IOS_Test_4);
		try 
		{		
			loginPage.fnVerifyReLoginStatus(objData.ACTIVE_USER_ID, objData.COUNTRY, objData.ENV);
			if(mePage.logOut())
			{
				Reporter.pass("HOOQ Sanity", "Logout from HOOQ is successfully done");
			} else{
				Reporter.fail("HOOQ Sanity", "Logout from HOOQ is not successfully done");
			}
		}
		catch(Exception e){Reporter.fnPrintException(e);}
		fnCloseTest();
	}
}
