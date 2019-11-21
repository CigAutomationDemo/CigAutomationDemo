package com.automation.ios.workflows;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.automation.accelerators.ActionEngine;

public class BasePage extends ActionEngine{
	String strBuildNo="";
	public enum DIRECTION {
	    DOWN, UP, LEFT, RIGHT;
	}
	public static  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static Date dt =null;
	public static String beforelogin = null;
	public static String afterLogin = null;
	public static boolean FirstLogin = true;
	public static DiscoverPage discoverPage=new DiscoverPage();
	public static LiveTVPage liveTVPage=new LiveTVPage();
	public static MeDownloadPage meDownloadPage=new MeDownloadPage();
	public static MeHistoryPage meHistoryPage=new MeHistoryPage();
	public static MeLinkTVPage meLinkTvPage=new MeLinkTVPage();
	public static MeMyRentalsPage meMyRentalPage=new MeMyRentalsPage();
	public static MEPage mePage=new MEPage();
	public static MeSettingsPage meSettingsPage=new MeSettingsPage();
	public static MeSubscriptionPage meSubscriptionPage=new MeSubscriptionPage();
	public static MeTransactionPage meTransactionPage=new MeTransactionPage();
	public static MeWatchListPage meWatchListPage=new MeWatchListPage();
	public static MoviesPage moviesPage=new MoviesPage();
	public static RentPage rentPage=new RentPage();
	public static TVShowsPage tvShowsPage=new TVShowsPage();
	public static LoginPage loginPage=new LoginPage();
	public static MeSupportPage meSupportPage=new MeSupportPage();
	public static SignUpPage signUpPage=new SignUpPage();
	public static CommonPage commonPage=new CommonPage();
	public static SearchPage searchPage=new SearchPage();
	public static ContentDetailsPage contentDetails=new ContentDetailsPage();
	public static PlayPage playPage=new PlayPage();
}
