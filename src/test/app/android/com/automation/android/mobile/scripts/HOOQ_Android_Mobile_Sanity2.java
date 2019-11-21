package com.automation.android.mobile.scripts;

import org.testng.annotations.Test;

import com.automation.accelerators.TestConfig;
import com.automation.android.workflows.BasePage;
import com.automation.reports.Reporter;
import com.automation.utilities.HOOQInput;
public class HOOQ_Android_Mobile_Sanity2 extends BasePage {
	
	
	/***
	 * Test Script Name :-HOOQ_Android_Mobile_Free_User_Payment_Philippines_1_Year_GooglePlay
	 * Developed By 	:-Pankaj Kumar
	 * Date				:-20_may-2019
	 * Test Description :-
	 * Test Rail ID		:-14082
	 */
	@Test(priority = 1,groups={TestConfig.Android,TestConfig.Regression,"HOOQ_Android_Mobile_Free_User_Payment_Philippines_1_Year_GooglePlay"})
	public void HOOQ_Android_Mobile_Free_User_Payment_Philippines_1_Year_GooglePlay() throws Throwable
	{
		//Add Test Rail ID
		HOOQInput.fnAddTestRailScriptID(14061);
		try 
		{	
			FirstLogin=true;
			loginPage.fnVerifyReLoginStatus(objData.ACTIVE_USER_ID, objData.COUNTRY, objData.ENV);
			if(searchPage.clickAndSearch(objData.FREE_CONTENT))
			{
				Reporter.pass("HOOQ Search", "Search of Movies " + objData.FREE_CONTENT + "is displayed");
				if(contentDetailsPage.playVideo())
				{
					if(	playerpage.fnVerifyPlayback(false,"full"))
					{
						Reporter.pass("HOOQ Play", "Play of Movies " + objData.FREE_CONTENT + "is displayed");
					}
					else
					{
						Reporter.fail("HOOQ Play", "Play of Movies " + objData.FREE_CONTENT + "is displayed");
					}
				}
				else
				{
					Reporter.fail("HOOQ Play", "Play of Movies " + objData.FREE_CONTENT + " : Not able to Play");
				}
		
			} else{
				Reporter.fail("HOOQ Search", "Search of Movies " + objData.FREE_CONTENT + "is not displayed");
			}
		
			
				
		}
		catch(Exception e){Reporter.fnPrintException(e);}
		fnCloseTest();
	}
	
	
	}