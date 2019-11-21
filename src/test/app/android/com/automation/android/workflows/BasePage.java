package com.automation.android.workflows;

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
	public static MeTransactionPage meTransactionPage=new MeTransactionPage();
	public static MoviesPage moviesPage=new MoviesPage();
	public static RentPage rentPage=new RentPage();
	public static TVShowsPage tvShowsPage=new TVShowsPage();
	public static LoginPage loginPage=new LoginPage();
	public static PlayerPage playerpage=new PlayerPage();
	public static ContentDetailsPage contentDetailsPage=new ContentDetailsPage();
	public static CommonPage commonPage=new CommonPage();
	public static MeSupportPage meSupportPage=new MeSupportPage();
	public static SearchPage searchPage=new SearchPage();
	public static Payment payment=new Payment();
	
	
	
}
