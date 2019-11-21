package com.automation.ios.iphone.scripts;

import org.testng.annotations.Test;

import com.automation.accelerators.TestConfig;
import com.automation.ios.workflows.BasePage;
import com.automation.reports.Reporter;
import com.automation.utilities.HOOQInput;
public class HOOQ_IOS_IPhone_Sanity2 extends BasePage {
	/***
	 * Test Script Name :-HOOQ_IOS_MOBILE_Login
	 * Developed By 	:-Pankaj Kumar
	 * Date				:-20_may-2019
	 * Test Description :-
	 * Test Rail ID		:-14082
	 */
	@Test(priority = 1,groups={TestConfig.IPhone,"Sanity","HOOQ_IOS_MOBILE_Login"})
	public void HOOQ_IOS_MOBILE_Login() throws Throwable
	{
		//Add Test Rail ID
		HOOQInput.fnAddTestRailScriptID(14082);
		try 
		{
			Reporter.info("HOOQ Sanity","Verifying HOOQ_IOS_MOBILE_Login");
			//loginPage.fnVerifyReLoginStatus(objData.FREE_USER_ID, objData.COUNTRY, objData.ENV);
			meDownloadPage.fnClearDownloadEntry();
			if(searchPage.clickAndSearch(objData.FREE_CONTENT))
			{
				Reporter.pass("HOOQ IOS", "Search of Movies " + objData.FREE_CONTENT + "is displayed");
				if(contentDetails.fnClickPlay())
				{
					if(playPage.fnVerifyPlaybackSubTitle())
					{
						Reporter.pass("HOOQ IOS", "Playback Movies " + objData.FREE_CONTENT + " SubTitle is dispying successfully");
					}
					else
					{
						Reporter.fail("HOOQ IOS", "Playback Movies " + objData.FREE_CONTENT + " SubTitle is not dispying successfully");
					}
				}
				else
				{
					Reporter.fail("HOOQ IOS", "Playback Movies " + objData.FREE_CONTENT + "Play button is not displayed");
				}
			} else{
				Reporter.fail("HOOQ IOS", "Search of Movies " + objData.FREE_CONTENT + "is not displayed");
			}
		}
		catch(Exception e){Reporter.fnPrintException(e);}
		fnCloseTest();
	}
	
	
}
