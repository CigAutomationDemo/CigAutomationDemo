package com.automation.web.scripts;

import org.testng.annotations.Test;

import com.automation.accelerators.TestConfig;
import com.automation.reports.Reporter;
import com.automation.utilities.HOOQInput;
import com.automation.utilities.Settings;
import com.automation.web.workflows.BasePage;

public class HOOQ_PWA_Sanity_Scripts extends BasePage{
	
	
	
	/***
	 * Test Script Name :-HOOQ_PWA_ActiveUser_ContentsDetails
	 * Developed By 	:-Indraja
	 * Date				:-20_may-2019
	 * Test Description :-
	 * Test Rail ID		:-21754
	 */
	@Test(priority = 1,groups={TestConfig.PWA,TestConfig.Sanity,TestConfig.ActiveUser,"HOOQ_PWA_ActiveUser_ContentsDetails"})
	public void HOOQ_PWA_ActiveUser_ContentsDetails() throws Throwable
	{
		//Add Test Rail ID
		HOOQInput.fnAddTestRailScriptID(Settings.PWA_Test_1);
		try 
		{
			loginPage.verifyLoginWithEV(objData.ACTIVE_USER_ID,objData.PASSWORD,objData.ACTIVE_USER_NUMBER,"email");
			tvshowspage.verifyContentDetails();
		}
		catch(Exception e){Reporter.fnPrintException(e);}
		fnCloseTest();
	}
	
	/***
	 * Test Script Name :-HOOQ_PWA_ActiveUser_HamberMenu
	 * Developed By 	:-Indraja
	 * Date				:-20_may-2019
	 * Test Description :-
	 * Test Rail ID		:-21758
	 */
	@Test(priority = 2,groups={TestConfig.PWA,TestConfig.Sanity,TestConfig.ActiveUser,"HOOQ_PWA_ActiveUser_HamberMenu"})
	public void HOOQ_PWA_ActiveUser_HamberMenu() throws Throwable
	{
		//Add Test Rail ID
		HOOQInput.fnAddTestRailScriptID(Settings.PWA_Test_2);
		try 
		{
			loginPage.verifyLoginWithEV(objData.ACTIVE_USER_ID,objData.PASSWORD,objData.ACTIVE_USER_NUMBER,"email");
			if(hamburgerPage.verifyHamburgerMenu("Active"))
			{
				Reporter.pass("HOOQ PWA", "Hamburger Menu is displayed for Active user");
			} else
			{
				Reporter.fail("HOOQ PWA", "Hamburger Menu is not displayed for Active user");
			}			
		}
		catch(Exception e){Reporter.fnPrintException(e);}
		fnCloseTest();
	}
	
	/***
	 * Test Script Name :-HOOQ_PWA_ActiveUser_PlaybacKTVShow
	 * Developed By 	:-Indraja
	 * Date				:-20_may-2019
	 * Test Description :-
	 * Test Rail ID		:-21761
	 */
	@Test(priority = 3,groups={TestConfig.PWA,TestConfig.Sanity,TestConfig.ActiveUser,"HOOQ_PWA_ActiveUser_PlaybacKTVShow"})
	public void HOOQ_PWA_ActiveUser_PlaybacKTVShow() throws Throwable
	{
		//Add Test Rail ID
		HOOQInput.fnAddTestRailScriptID(Settings.PWA_Test_3);
		try 
		{
			loginPage.verifyLoginWithEV(objData.ACTIVE_USER_ID,objData.PASSWORD,objData.ACTIVE_USER_NUMBER,"email");
			playbackPage.verifyPlayBackTVShows("Active");
		}
		catch(Exception e){Reporter.fnPrintException(e);}
		fnCloseTest();
	}
	
	/***
	 * Test Script Name :-HOOQ_PWA_ActiveUser_Search_MovieContent
	 * Developed By 	:-Indraja
	 * Date				:-20_may-2019
	 * Test Description :-
	 * Test Rail ID		:-21763
	 */
	@Test(priority = 13,groups={TestConfig.PWA,TestConfig.Sanity,TestConfig.ActiveUser,"HOOQ_PWA_ActiveUser_Search_MovieContent"})
	public void HOOQ_PWA_ActiveUser_Search_MovieContent() throws Throwable
	{
		//Add Test Rail ID
		HOOQInput.fnAddTestRailScriptID(Settings.PWA_Test_4);
		try 
		{
			loginPage.verifyLoginWithEV(objData.ACTIVE_USER_ID,objData.PASSWORD,objData.ACTIVE_USER_NUMBER,"email");
			searchPage.SearchSpecificItem(objData.FREE_CONTENT);
		}
		catch(Exception e){Reporter.fnPrintException(e);}
		fnCloseTest();
	}
	
	/***
	 * Test Script Name :-HOOQ_PWA_ActiveUser_Logout
	 * Developed By 	:-Indraja
	 * Date				:-20_may-2019
	 * Test Description :-
	 * Test Rail ID		:-21766
	 */
	@Test(priority = 17,groups={TestConfig.PWA,TestConfig.Sanity,TestConfig.ActiveUser,"HOOQ_PWA_ActiveUser_Logout"})
	public void HOOQ_PWA_ActiveUser_Logout() throws Throwable
	{
		//Add Test Rail ID
		HOOQInput.fnAddTestRailScriptID(Settings.PWA_Test_5);
		try 
		{
			loginPage.verifyLoginWithEV(objData.ACTIVE_USER_ID,objData.PASSWORD,objData.ACTIVE_USER_NUMBER,"email");
			loginPage.logOut();			
		}
		catch(Exception e){Reporter.fnPrintException(e);}
		fnCloseTest();
	}
	
	
}
