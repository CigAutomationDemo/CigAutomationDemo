package com.automation.utilities;

import java.io.IOException;
import java.time.LocalDateTime;

import com.automation.accelerators.TestEngine;
import com.automation.googledrive.GoogleDriveAPI;
import com.automation.reports.Reporter;

public class HOOQInput {
	public String COUNTRY;
	public String ENV;
	public String Visitor;
	public String FREE_USER_ID;
	public String FREE_USER_NUMBER;
	public String ACTIVE_USER_ID;
	public String ACTIVE_USER_NUMBER;
	public String LAPSED_USER_ID;
	public String LAPSED_USER_NUMBER;
	public String PASSWORD;
	public String R21_MOVIES;
	public String R21_TVSHOWS;
	public String R21_PREMIUM;
	public String TRAILER_MOVIES;
	public String TRAILER_TVSHOWS;
	public String TRAILER_PREMIUM;
	public String TRAILER_R21_MOVIES;
	public String TRAILER_R21_TVSHOWS;
	public String TRAILER_R21_PREMIUM;
	public String FREE_CONTENT;
	public String PREMIUM_CONTENT;
	public String TV_SERIES;
	public String TVOD_CONTENT;
	public String strBrowserName;
	public String strScriptName;
	public String strBuildNo =null;
	public String SHEET_ID;
	public String SHEET_NMAE_REG;
	public String SHEET_NAME_SANITY;
	public String ExecutionType;
	public int TestRailID;
	//Google Sheet Related Data
	public String strGoogleSheet;
	public String strPlatform;
	public String strDevice;
	public String strLiveTvSheet;
	public String strLiveTvChnnel;
	public String strGSheetPlatform;
	public String strGSheetDevice;
	public String strGSheetUserType;
	public String strGSheetModule;
	
	
	
	public static HOOQInput getTestData(String strCountry,String sheetPath,String sheetName) throws IOException {
		HOOQInput testData=new HOOQInput();
		try {
			int intRowNo=HOOQInput.fnGetSheetRowNo(strCountry);
			testData.COUNTRY = ExcelReader.fn_GetCellData(sheetPath, sheetName, intRowNo, "COUNTRY");
			testData.FREE_USER_ID= ExcelReader.fn_GetCellData(sheetPath, sheetName, intRowNo, "FREE_USER_ID");
			testData.FREE_USER_NUMBER= ExcelReader.fn_GetCellData(sheetPath, sheetName, intRowNo, "FREE_USER_NUMBER");
			testData.ACTIVE_USER_ID= ExcelReader.fn_GetCellData(sheetPath, sheetName, intRowNo, "ACTIVE_USER_ID");
			testData.ACTIVE_USER_NUMBER= ExcelReader.fn_GetCellData(sheetPath, sheetName, intRowNo, "ACTIVE_USER_NUMBER");
			testData.LAPSED_USER_ID= ExcelReader.fn_GetCellData(sheetPath, sheetName, intRowNo, "LAPSED_USER_ID");
			testData.LAPSED_USER_NUMBER= ExcelReader.fn_GetCellData(sheetPath, sheetName, intRowNo, "LAPSED_USER_NUMBER");
			testData.PASSWORD= ExcelReader.fn_GetCellData(sheetPath, sheetName, intRowNo, "PASSWORD");
			testData.R21_MOVIES= ExcelReader.fn_GetCellData(sheetPath, sheetName, intRowNo, "R21_MOVIES");
			testData.R21_TVSHOWS= ExcelReader.fn_GetCellData(sheetPath, sheetName, intRowNo, "R21_TVSHOWS");
			testData.R21_PREMIUM= ExcelReader.fn_GetCellData(sheetPath, sheetName, intRowNo, "R21_PREMIUM");
			testData.TRAILER_MOVIES= ExcelReader.fn_GetCellData(sheetPath, sheetName, intRowNo, "TRAILER_MOVIES");
			testData.TRAILER_TVSHOWS= ExcelReader.fn_GetCellData(sheetPath, sheetName, intRowNo, "TRAILER_TVSHOWS");
			testData.TRAILER_PREMIUM= ExcelReader.fn_GetCellData(sheetPath, sheetName, intRowNo, "TRAILER_PREMIUM");
			testData.FREE_CONTENT= ExcelReader.fn_GetCellData(sheetPath, sheetName, intRowNo, "FREE_CONTENT");
			testData.PREMIUM_CONTENT= ExcelReader.fn_GetCellData(sheetPath, sheetName, intRowNo, "PREMIUM_CONTENT");
			testData.TV_SERIES= ExcelReader.fn_GetCellData(sheetPath, sheetName, intRowNo, "TV_SERIES");
			testData.TVOD_CONTENT= ExcelReader.fn_GetCellData(sheetPath, sheetName, intRowNo, "TVOD_CONTENT");
			testData.SHEET_ID= ExcelReader.fn_GetCellData(sheetPath, sheetName, intRowNo, "SHEET_ID");
			testData.SHEET_NMAE_REG= ExcelReader.fn_GetCellData(sheetPath, sheetName, intRowNo, "SHEET_NMAE_REG");
			testData.SHEET_NAME_SANITY=ExcelReader.fn_GetCellData(sheetPath, sheetName, intRowNo, "SHEET_NAME_SANITY");
			testData.ExecutionType=TestEngine.ExecutionType;
		} catch (Exception e) {
				Reporter.fnPrintException(e);
		}
		return testData;
	}
	
	public static int fnGetSheetRowNo(String strCountry)
	{
		int intRowNo=0;
		if(strCountry.toLowerCase().contains("in"))
		{
			intRowNo=1;			
		}
		else if(strCountry.toLowerCase().contains("ph"))
		{
			intRowNo=2;	
		}
		else if(strCountry.toLowerCase().contains("th"))
		{
			intRowNo=3;	
		}
		else if(strCountry.toLowerCase().contains("id"))
		{
			intRowNo=4;	
		}
		else if(strCountry.toLowerCase().contains("sg"))
		{
			intRowNo=5;	
		}
		return intRowNo;
	}
	
	public static void fnAddTestRailScriptID(int intScriptID)
	{
		try
		{
			TestEngine.objData.TestRailID=intScriptID;
		}
		catch(Exception e){Reporter.fnPrintException(e);}
	}
	
	public static HOOQInput fnLoadInternalBuildTestdata(String strCountry,String strModule,HOOQInput objData)
	{
		try
		{
			String strSheetID="14dhBEH6C-dZKJFnVBx112eXoJfHSQ1oITmW4PbBUIBs";
			int intRowNo=0;
			objData.strScriptName=strCountry+"_"+objData.strScriptName;
			if(strModule.toLowerCase().contains("android") || strModule.toLowerCase().contains("tablet"))
			{
				if(strCountry.toLowerCase().contains("in"))
				{
					 intRowNo=2;
					 String rangeActive = strSheetID+"!C"+intRowNo+":C"+intRowNo;
				     objData.ACTIVE_USER_ID=GoogleDriveAPI.fnGetData(strSheetID,rangeActive);
				     String rangelapsed = strSheetID+"!D"+intRowNo+":D"+intRowNo;
				     objData.LAPSED_USER_ID=GoogleDriveAPI.fnGetData(strSheetID,rangelapsed);
				     String rangeSheet = strSheetID+"!E"+intRowNo+":E"+intRowNo;
				     objData.SHEET_NAME_SANITY=GoogleDriveAPI.fnGetData(strSheetID,rangeSheet);
				     String BuildNo = strSheetID+"!F"+intRowNo+":F"+intRowNo;
				     objData.SHEET_NAME_SANITY=GoogleDriveAPI.fnGetData(strSheetID,BuildNo);
				}
				else if(strCountry.toLowerCase().contains("sg"))
				{
					 intRowNo=3;
					 String rangeActive = strSheetID+"!C"+intRowNo+":C"+intRowNo;
				     objData.ACTIVE_USER_ID=GoogleDriveAPI.fnGetData(strSheetID,rangeActive);
				     String rangelapsed = strSheetID+"!D"+intRowNo+":D"+intRowNo;
				     objData.LAPSED_USER_ID=GoogleDriveAPI.fnGetData(strSheetID,rangelapsed);
				     String rangeSheet = strSheetID+"!E"+intRowNo+":E"+intRowNo;
				     objData.SHEET_NAME_SANITY=GoogleDriveAPI.fnGetData(strSheetID,rangeSheet);
				     String BuildNo = strSheetID+"!F"+intRowNo+":F"+intRowNo;
				     objData.SHEET_NAME_SANITY=GoogleDriveAPI.fnGetData(strSheetID,BuildNo);
				}
				else if(strCountry.toLowerCase().contains("ph"))
				{
					 intRowNo=4;
					 String rangeActive = strSheetID+"!C"+intRowNo+":C"+intRowNo;
				     objData.ACTIVE_USER_ID=GoogleDriveAPI.fnGetData(strSheetID,rangeActive);
				     String rangelapsed = strSheetID+"!D"+intRowNo+":D"+intRowNo;
				     objData.LAPSED_USER_ID=GoogleDriveAPI.fnGetData(strSheetID,rangelapsed);
				     String rangeSheet = strSheetID+"!E"+intRowNo+":E"+intRowNo;
				     objData.SHEET_NAME_SANITY=GoogleDriveAPI.fnGetData(strSheetID,rangeSheet);
				     String BuildNo = strSheetID+"!F"+intRowNo+":F"+intRowNo;
				     objData.SHEET_NAME_SANITY=GoogleDriveAPI.fnGetData(strSheetID,BuildNo);
				}
				else if(strCountry.toLowerCase().contains("th"))
				{
					 intRowNo=5;
					 String rangeActive = strSheetID+"!C"+intRowNo+":C"+intRowNo;
				     objData.ACTIVE_USER_ID=GoogleDriveAPI.fnGetData(strSheetID,rangeActive);
				     String rangelapsed = strSheetID+"!D"+intRowNo+":D"+intRowNo;
				     objData.LAPSED_USER_ID=GoogleDriveAPI.fnGetData(strSheetID,rangelapsed);
				     String rangeSheet = strSheetID+"!E"+intRowNo+":E"+intRowNo;
				     objData.SHEET_NAME_SANITY=GoogleDriveAPI.fnGetData(strSheetID,rangeSheet);
				     String BuildNo = strSheetID+"!F"+intRowNo+":F"+intRowNo;
				     objData.SHEET_NAME_SANITY=GoogleDriveAPI.fnGetData(strSheetID,BuildNo);
				}
				else if(strCountry.toLowerCase().contains("id"))
				{
					 intRowNo=6;
					 String rangeActive = strSheetID+"!C"+intRowNo+":C"+intRowNo;
				     objData.ACTIVE_USER_ID=GoogleDriveAPI.fnGetData(strSheetID,rangeActive);
				     String rangelapsed = strSheetID+"!D"+intRowNo+":D"+intRowNo;
				     objData.LAPSED_USER_ID=GoogleDriveAPI.fnGetData(strSheetID,rangelapsed);
				     String rangeSheet = strSheetID+"!E"+intRowNo+":E"+intRowNo;
				     objData.SHEET_NAME_SANITY=GoogleDriveAPI.fnGetData(strSheetID,rangeSheet);
				     String BuildNo = strSheetID+"!F"+intRowNo+":F"+intRowNo;
				     objData.SHEET_NAME_SANITY=GoogleDriveAPI.fnGetData(strSheetID,BuildNo);
				}
			}
			if(strModule.toLowerCase().contains("pwa"))
			{
				if(strCountry.toLowerCase().contains("in"))
				{
					intRowNo=12;
					 String rangeActive = strSheetID+"!C"+intRowNo+":C"+intRowNo;
				     objData.ACTIVE_USER_ID=GoogleDriveAPI.fnGetData(strSheetID,rangeActive);
				     String rangelapsed = strSheetID+"!D"+intRowNo+":D"+intRowNo;
				     objData.LAPSED_USER_ID=GoogleDriveAPI.fnGetData(strSheetID,rangelapsed);
				     String rangeSheet = strSheetID+"!E"+intRowNo+":E"+intRowNo;
				     objData.SHEET_NAME_SANITY=GoogleDriveAPI.fnGetData(strSheetID,rangeSheet);
				     String BuildNo = strSheetID+"!F"+intRowNo+":F"+intRowNo;
				     objData.SHEET_NAME_SANITY=GoogleDriveAPI.fnGetData(strSheetID,BuildNo);
				}
				else if(strCountry.toLowerCase().contains("sg"))
				{
					intRowNo=13;
					 String rangeActive = strSheetID+"!C"+intRowNo+":C"+intRowNo;
				     objData.ACTIVE_USER_ID=GoogleDriveAPI.fnGetData(strSheetID,rangeActive);
				     String rangelapsed = strSheetID+"!D"+intRowNo+":D"+intRowNo;
				     objData.LAPSED_USER_ID=GoogleDriveAPI.fnGetData(strSheetID,rangelapsed);
				     String rangeSheet = strSheetID+"!E"+intRowNo+":E"+intRowNo;
				     objData.SHEET_NAME_SANITY=GoogleDriveAPI.fnGetData(strSheetID,rangeSheet);
				     String BuildNo = strSheetID+"!F"+intRowNo+":F"+intRowNo;
				     objData.SHEET_NAME_SANITY=GoogleDriveAPI.fnGetData(strSheetID,BuildNo);
				}
				else if(strCountry.toLowerCase().contains("ph"))
				{
					intRowNo=14;
					 String rangeActive = strSheetID+"!C"+intRowNo+":C"+intRowNo;
				     objData.ACTIVE_USER_ID=GoogleDriveAPI.fnGetData(strSheetID,rangeActive);
				     String rangelapsed = strSheetID+"!D"+intRowNo+":D"+intRowNo;
				     objData.LAPSED_USER_ID=GoogleDriveAPI.fnGetData(strSheetID,rangelapsed);
				     String rangeSheet = strSheetID+"!E"+intRowNo+":E"+intRowNo;
				     objData.SHEET_NAME_SANITY=GoogleDriveAPI.fnGetData(strSheetID,rangeSheet);
				     String BuildNo = strSheetID+"!F"+intRowNo+":F"+intRowNo;
				     objData.SHEET_NAME_SANITY=GoogleDriveAPI.fnGetData(strSheetID,BuildNo);
				}
				else if(strCountry.toLowerCase().contains("th"))
				{
					intRowNo=15;
					 String rangeActive = strSheetID+"!C"+intRowNo+":C"+intRowNo;
				     objData.ACTIVE_USER_ID=GoogleDriveAPI.fnGetData(strSheetID,rangeActive);
				     String rangelapsed = strSheetID+"!D"+intRowNo+":D"+intRowNo;
				     objData.LAPSED_USER_ID=GoogleDriveAPI.fnGetData(strSheetID,rangelapsed);
				     String rangeSheet = strSheetID+"!E"+intRowNo+":E"+intRowNo;
				     objData.SHEET_NAME_SANITY=GoogleDriveAPI.fnGetData(strSheetID,rangeSheet);
				     String BuildNo = strSheetID+"!F"+intRowNo+":F"+intRowNo;
				     objData.SHEET_NAME_SANITY=GoogleDriveAPI.fnGetData(strSheetID,BuildNo);
				}
				else if(strCountry.toLowerCase().contains("id"))
				{
					intRowNo=16;
					 String rangeActive = strSheetID+"!C"+intRowNo+":C"+intRowNo;
				     objData.ACTIVE_USER_ID=GoogleDriveAPI.fnGetData(strSheetID,rangeActive);
				     String rangelapsed = strSheetID+"!D"+intRowNo+":D"+intRowNo;
				     objData.LAPSED_USER_ID=GoogleDriveAPI.fnGetData(strSheetID,rangelapsed);
				     String rangeSheet = strSheetID+"!E"+intRowNo+":E"+intRowNo;
				     objData.SHEET_NAME_SANITY=GoogleDriveAPI.fnGetData(strSheetID,rangeSheet);
				     String BuildNo = strSheetID+"!F"+intRowNo+":F"+intRowNo;
				     objData.SHEET_NAME_SANITY=GoogleDriveAPI.fnGetData(strSheetID,BuildNo);
				}
			}
			if(strModule.toLowerCase().contains("iphone") || strModule.toLowerCase().contains("ipad"))
			{
				if(strCountry.toLowerCase().contains("in"))
				{
					 intRowNo=7;
					 String rangeActive = strSheetID+"!C"+intRowNo+":C"+intRowNo;
				     objData.ACTIVE_USER_ID=GoogleDriveAPI.fnGetData(strSheetID,rangeActive);
				     String rangelapsed = strSheetID+"!D"+intRowNo+":D"+intRowNo;
				     objData.LAPSED_USER_ID=GoogleDriveAPI.fnGetData(strSheetID,rangelapsed);
				     String rangeSheet = strSheetID+"!E"+intRowNo+":E"+intRowNo;
				     objData.SHEET_NAME_SANITY=GoogleDriveAPI.fnGetData(strSheetID,rangeSheet);
				     String BuildNo = strSheetID+"!F"+intRowNo+":F"+intRowNo;
				     objData.SHEET_NAME_SANITY=GoogleDriveAPI.fnGetData(strSheetID,BuildNo);
				}
				else if(strCountry.toLowerCase().contains("sg"))
				{
					 intRowNo=8;
					 String rangeActive = strSheetID+"!C"+intRowNo+":C"+intRowNo;
				     objData.ACTIVE_USER_ID=GoogleDriveAPI.fnGetData(strSheetID,rangeActive);
				     String rangelapsed = strSheetID+"!D"+intRowNo+":D"+intRowNo;
				     objData.LAPSED_USER_ID=GoogleDriveAPI.fnGetData(strSheetID,rangelapsed);
				     String rangeSheet = strSheetID+"!E"+intRowNo+":E"+intRowNo;
				     objData.SHEET_NAME_SANITY=GoogleDriveAPI.fnGetData(strSheetID,rangeSheet);
				     String BuildNo = strSheetID+"!F"+intRowNo+":F"+intRowNo;
				     objData.SHEET_NAME_SANITY=GoogleDriveAPI.fnGetData(strSheetID,BuildNo);
				}
				else if(strCountry.toLowerCase().contains("ph"))
				{
					 intRowNo=9;
					 String rangeActive = strSheetID+"!C"+intRowNo+":C"+intRowNo;
				     objData.ACTIVE_USER_ID=GoogleDriveAPI.fnGetData(strSheetID,rangeActive);
				     String rangelapsed = strSheetID+"!D"+intRowNo+":D"+intRowNo;
				     objData.LAPSED_USER_ID=GoogleDriveAPI.fnGetData(strSheetID,rangelapsed);
				     String rangeSheet = strSheetID+"!E"+intRowNo+":E"+intRowNo;
				     objData.SHEET_NAME_SANITY=GoogleDriveAPI.fnGetData(strSheetID,rangeSheet);
				     String BuildNo = strSheetID+"!F"+intRowNo+":F"+intRowNo;
				     objData.SHEET_NAME_SANITY=GoogleDriveAPI.fnGetData(strSheetID,BuildNo);
				}
				else if(strCountry.toLowerCase().contains("th"))
				{
					 intRowNo=10;
					 String rangeActive = strSheetID+"!C"+intRowNo+":C"+intRowNo;
				     objData.ACTIVE_USER_ID=GoogleDriveAPI.fnGetData(strSheetID,rangeActive);
				     String rangelapsed = strSheetID+"!D"+intRowNo+":D"+intRowNo;
				     objData.LAPSED_USER_ID=GoogleDriveAPI.fnGetData(strSheetID,rangelapsed);
				     String rangeSheet = strSheetID+"!E"+intRowNo+":E"+intRowNo;
				     objData.SHEET_NAME_SANITY=GoogleDriveAPI.fnGetData(strSheetID,rangeSheet);
				     String BuildNo = strSheetID+"!F"+intRowNo+":F"+intRowNo;
				     objData.SHEET_NAME_SANITY=GoogleDriveAPI.fnGetData(strSheetID,BuildNo);
				}
				else if(strCountry.toLowerCase().contains("id"))
				{
					 intRowNo=11;
					 String rangeActive = strSheetID+"!C"+intRowNo+":C"+intRowNo;
				     objData.ACTIVE_USER_ID=GoogleDriveAPI.fnGetData(strSheetID,rangeActive);
				     String rangelapsed = strSheetID+"!D"+intRowNo+":D"+intRowNo;
				     objData.LAPSED_USER_ID=GoogleDriveAPI.fnGetData(strSheetID,rangelapsed);
				     String rangeSheet = strSheetID+"!E"+intRowNo+":E"+intRowNo;
				     objData.SHEET_NAME_SANITY=GoogleDriveAPI.fnGetData(strSheetID,rangeSheet);
				     String BuildNo = strSheetID+"!F"+intRowNo+":F"+intRowNo;
				     objData.SHEET_NAME_SANITY=GoogleDriveAPI.fnGetData(strSheetID,BuildNo);
				}
			}
		}
		catch(Exception e){}
		return objData;
	}
	
	
	
}
