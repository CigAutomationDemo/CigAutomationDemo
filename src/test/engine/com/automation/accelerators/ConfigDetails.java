package com.automation.accelerators;

import java.util.Properties;

import com.automation.utilities.FileUtilities;

public class ConfigDetails {
	public String strURL=null;
	public String strExecutionType=null;
	public String strApplicationType=null;
	public String strBaseOSName=null;
	public String strOSName=null;
	public String strOSVersion=null;
	public String strBrowserName=null;
	public String strBrowserVersion=null;
	public String strDeviceType=null;
	public String strAppiumURL=null;
	public String strRunAppiumWithCode=null;
	public String strPlatformName=null;
	public String strPlatformVersion=null;
	public String strAutoWebView=null;
	public String strNewCommandTimeOut=null;
	public String strAutoWebViewTimeOut=null;
	public String strDisableWindowAnimation=null;
	public String strUDID=null;
	public String strFullReset=null;
	public String strNoReset=null;
	public String strAppPackage=null;
	public String strAppActivity=null;
	public String strDeviceName=null;
	public String strBundleID=null;
	public String strTakeScreenShoot=null;
	public String strLocationServicesAuthorized=null;
	public String strAutoLaunch=null;
	public String strwaitForAppScript=null;
	public String strAppiumAppType=null;
	public String strAppiumAppPath=null;
	public String strmobileEmulation=null;
	public String strPrintExceptionLog=null;
	public String strGlobalTimeOut=null;
	public String strRestartAppWithAppium=null;
	
	//ReportConfig
	public String strGoogleSheet=null;
	public String strScreenShot=null;
	public String strBrowserStackLinkVideo=null;
	public String strTestRail=null;
	public String strTestRailProject=null;
	public String strJira=null;
	public String strSlackMessage=null;
	public String strSendEmail=null;
	
	//Email Config
	public String strEmail_TO=null;
	public String strEmail_From=null;
	public String strEmail_Default=null;
	
	//BrowserStack Config
	public String strBS_Username=null;
	public String strBS_AccessKey=null;
	
	//For PWA automation
	public String strDriverType=null;
	
	static Properties prop=null;
	//Function to Get the ConfigDetails
	public static ConfigDetails fnGetConfigDetails(String strConfigFileName)
	{
		ConfigDetails objDetails=new ConfigDetails();
		prop=FileUtilities.fnGetPropertiesDetail(strConfigFileName);
		try
		{
			objDetails.strURL=fnGetPropertiesFileDetails("strURL");
			objDetails.strExecutionType=fnGetPropertiesFileDetails("strExecutionType");
			objDetails.strApplicationType=fnGetPropertiesFileDetails("strApplicationType");
			objDetails.strBaseOSName=fnGetPropertiesFileDetails("strBaseOSName");
			objDetails.strOSName=fnGetPropertiesFileDetails("strOSName");
			objDetails.strOSVersion=fnGetPropertiesFileDetails("strOSVersion");
			objDetails.strBrowserName=fnGetPropertiesFileDetails("strBrowserName");
			objDetails.strBrowserVersion=fnGetPropertiesFileDetails("strBrowserVersion");
			objDetails.strDeviceType=fnGetPropertiesFileDetails("strDeviceType");
			objDetails.strAppiumURL=fnGetPropertiesFileDetails("strAppiumURL");
			objDetails.strPlatformName=fnGetPropertiesFileDetails("strPlatformName");
			objDetails.strUDID=fnGetPropertiesFileDetails("strUDID");
			objDetails.strPlatformVersion=fnGetPropertiesFileDetails("strPlatformVersion");
			objDetails.strAutoWebView=fnGetPropertiesFileDetails("strAutoWebView");
			objDetails.strNewCommandTimeOut=fnGetPropertiesFileDetails("strNewCommandTimeOut");
			objDetails.strAutoWebViewTimeOut=fnGetPropertiesFileDetails("strAutoWebViewTimeOut");
			objDetails.strDisableWindowAnimation=fnGetPropertiesFileDetails("strDisableWindowAnimation");
			objDetails.strFullReset=fnGetPropertiesFileDetails("strFullReset");
			objDetails.strNoReset=fnGetPropertiesFileDetails("strNoReset");
			objDetails.strAppPackage=fnGetPropertiesFileDetails("strAppPackage");
			objDetails.strAppActivity=fnGetPropertiesFileDetails("strAppActivity");
			objDetails.strDeviceName=fnGetPropertiesFileDetails("strDeviceName");
			objDetails.strBundleID=fnGetPropertiesFileDetails("strBundleID");
			objDetails.strTakeScreenShoot=fnGetPropertiesFileDetails("strTakeScreenShoot");
			objDetails.strLocationServicesAuthorized=fnGetPropertiesFileDetails("strLocationServicesAuthorized");
			objDetails.strAutoLaunch=fnGetPropertiesFileDetails("strAutoLaunch");
			objDetails.strwaitForAppScript=fnGetPropertiesFileDetails("strwaitForAppScript");
			objDetails.strAppiumAppType=fnGetPropertiesFileDetails("strAppiumAppType");
			objDetails.strAppiumAppPath=fnGetPropertiesFileDetails("strAppiumAppPath");
			objDetails.strGoogleSheet=fnGetPropertiesFileDetails("strGoogleSheet");
			objDetails.strScreenShot=fnGetPropertiesFileDetails("strScreenShot");
			objDetails.strBrowserStackLinkVideo=fnGetPropertiesFileDetails("strBrowserStackLinkVideo");
			objDetails.strTestRail=fnGetPropertiesFileDetails("strTestRail");
			objDetails.strJira=fnGetPropertiesFileDetails("strJira");
			objDetails.strSlackMessage=fnGetPropertiesFileDetails("strSlackMessage");
			objDetails.strSendEmail=fnGetPropertiesFileDetails("strSendEmail");
			objDetails.strEmail_TO=fnGetPropertiesFileDetails("strEmail_TO");
			objDetails.strEmail_From=fnGetPropertiesFileDetails("strEmail_From");
			objDetails.strEmail_Default=fnGetPropertiesFileDetails("strEmail_Default");
			objDetails.strBS_Username=fnGetPropertiesFileDetails("strBS_Username");
			objDetails.strBS_AccessKey=fnGetPropertiesFileDetails("strBS_AccessKey");
			objDetails.strmobileEmulation=fnGetPropertiesFileDetails("strmobileEmulation");
			objDetails.strPrintExceptionLog=fnGetPropertiesFileDetails("strPrintExceptionLog");
			objDetails.strGlobalTimeOut=fnGetPropertiesFileDetails("strGlobalTimeOut");
			objDetails.strTestRailProject=fnGetPropertiesFileDetails("strTestRailProject");
			objDetails.strRunAppiumWithCode=fnGetPropertiesFileDetails("strRunAppiumWithCode");
			objDetails.strRestartAppWithAppium=fnGetPropertiesFileDetails("strRestartAppWithAppium");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return objDetails;
	}
	
	public static String fnGetPropertiesFileDetails(String strPropertyName)
	{	String strData=null;
		try
		{
			strData=prop.getProperty(strPropertyName);
			System.out.println(strData);
			if(strData.equals("null"))
			{
				strData=null;
			}
		}
	    catch(Exception e){}
	    return strData;
	}
	


}
