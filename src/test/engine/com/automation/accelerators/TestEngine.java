package com.automation.accelerators;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.automation.googledrive.ReportStatus;
import com.automation.reports.Reporter;
import com.automation.reports.ReportsExtent;
import com.automation.slack.SlackTest;
import com.automation.test.management.JiraAPI;
import com.automation.test.management.TestRailTestRunStatus;
import com.automation.utilities.FileUtilities;
import com.automation.utilities.HOOQInput;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import net.rcarz.jiraclient.JiraException;

public class TestEngine extends ReportsExtent{
	public static RemoteWebDriver driver=null;
	public static ConfigDetails objConfig=null;
	public static Map<String, String> DriverInfo = new HashMap<String, String>();
	public static String ExecutionType="Regression";
	public static HOOQInput objData;
	public static String strTestDataFilePath=FileUtilities.fnGetCurrentUserDir()+"/TestData/TestData.xlsx";
	public static String strSheetName=null;
	public static TestRailTestRunStatus testRailStatus=null;
	public static String strDescription=null;
	public static String strSummary=null;
	public static boolean RestartApp=true;
	public static SlackTest objSlackData=null; 
	
	@BeforeSuite(alwaysRun = true)
	public void fnBeforeSuite() throws InterruptedException, IOException
	{
		System.out.println("Before Suite");
		objConfig=ConfigDetails.fnGetConfigDetails(fnGetConfigFileName());
		System.out.println("Before Suite");
		extent=fnCreateExtentReport();
	}
	
	@AfterSuite(alwaysRun = true)
	public void fnAfterSuite()
	{
		System.out.println("After Suite");
		fnCloseExtentReports(extent);
		ReportsExtent.fnCopyReportToHistory();
		if(driver!=null)
		{
			driver.quit();
		}
	}
	
	
	@BeforeMethod(alwaysRun = true)
	@Parameters({"COUNTRY","ENV","ExType","Module"})
	public void fnBeforeTest(String COUNTRY,String ENV,String ExType,String Module,Method method) throws IOException
	{
		ReportStatus.blnStatus=true;
		System.out.println("Before Method");
		System.out.println("Country ==> " + COUNTRY);
		System.out.println("ENV ==> " + ENV);
		fnSetExecutionType(ExType);
		fnSetModule(Module);
		String strTestName=method.getName();
		objData=HOOQInput.getTestData(COUNTRY,strTestDataFilePath,strSheetName);
		objData.strScriptName=strTestName;
		if(ExType.toLowerCase().contains("internal"))
		{
			objData=HOOQInput.fnLoadInternalBuildTestdata(COUNTRY, Module, objData);
		}
		objData.ENV=ENV.toUpperCase();
		String MethodDescription="Description : " + fnGetTestDescription(objConfig,objData).replaceAll("_", " ");
		test=fnStartTest(extent, strTestName, MethodDescription);
		objData=fnGetGoogleSheetDeviceDetails(objConfig,objData);
		driver=fnGetDriver();
		if(Boolean.parseBoolean(objConfig.strTestRail))
		{
			String TestRailSuiteName=fnGetTestRailSuiteName();
			Reporter.pass("Before Test Test Rail Project " , TestRailSuiteName);
			String strTestRailFolder=TestRailTestRunStatus.fnGetTestRailRunInstance(objConfig,objData);
			Reporter.pass("Before Test RailStatus " , strTestRailFolder);
			String strProjectName=objConfig.strTestRailProject;
			testRailStatus=new TestRailTestRunStatus(strProjectName, TestRailSuiteName,strTestRailFolder);
		}
		fnAssignDetails();
	}
	
	@AfterMethod(alwaysRun = true)
	public void fnAfterTest()
	{
		System.out.println("After Method");
		fnEndTest(extent, test);
		/*if(objConfig.strDriverType.toLowerCase().contains("desktop")||objConfig.strDriverType.toLowerCase().contains("chromemobileview"))
		{
			if(driver!=null)
			{
				driver.close();
			}
		}*/
		if(Boolean.parseBoolean(objConfig.strGoogleSheet))
		{
			ReportStatus.fnUpdateDashboard(objData);
		}
		if(Boolean.parseBoolean(objConfig.strTestRail))
		{
			TestRailTestRunStatus.fnReportStatus(objData.TestRailID);
		}
		if(Boolean.parseBoolean(objConfig.strSlackMessage))
		{
			//Update Slack Data
			SlackTest.fnUpdateSanityChanel(objSlackData);
		}
	}
	
	public void fnAssignDetails()
	{
		strSummary=objData.strScriptName;
		strDescription=objData.strScriptName + " not working";
		strDescription=strDescription + "\n" + "Test Case Name : : " + objData.strScriptName;
		strDescription=strDescription + "\n" + "Country : " + objData.COUNTRY;
		strDescription=strDescription + "\n" + "Env : " + objData.ENV;
		strDescription=strDescription + "\n" + "Test Rail Project : " + objConfig.strTestRailProject;
	}
	
	public void fnAssignSlackData()
	{
		objSlackData=new SlackTest();
		objSlackData.strScriptName=objData.strScriptName;
		objSlackData.strBuildNo=objData.strBuildNo;
		if(ReportStatus.blnStatus==false)
        {
			objSlackData.strStatus="FAIL";
        }
		else
		{
			objSlackData.strStatus="PASS";
		}
		objSlackData.strBuildDate=FileUtilities.GetCurrentTimeStamp();
		objSlackData.strCountry=objData.COUNTRY;
		objSlackData.strEnv=objData.ENV;
	}
	
	public void fnSetExecutionType(String strType)
	{
		if(strType.toLowerCase().contains("sanity"))
			ExecutionType="Sanity";
		else if(strType.toLowerCase().contains("internal"))
			ExecutionType="Internal";
		else
			ExecutionType="Regression";
	}
	public void fnSetModule(String strModule)
	{
		if(strModule.toLowerCase().contains("pwa"))
			strSheetName="HOOQ_PWA";
		else if(strModule.toLowerCase().contains("android"))
			strSheetName="HOOQ_Android";
		else if(strModule.toLowerCase().contains("tablet"))
			strSheetName="HOOQ_Tablet";
		else if(strModule.toLowerCase().contains("iphone"))
			strSheetName="HOOQ_IPhone";
		else if(strModule.toLowerCase().contains("ipad"))
			strSheetName="HOOQ_IPad";
	}

	@SuppressWarnings("rawtypes")
	public static RemoteWebDriver fnGetDriver()
	{
		try
		{
			if(objConfig.strExecutionType.toLowerCase().equals("local"))
			{
				if(objConfig.strBaseOSName.toLowerCase().startsWith("win"))
				{
					if(objConfig.strApplicationType.toLowerCase().startsWith("browser"))
					{
						if(objConfig.strBrowserName.toLowerCase().equals("chrome"))
						{
							String strChromeDriverPath=FileUtilities.fnGetCurrentUserDir()+"/Tools/Driver/Windows/chromedriver.exe";
							System.setProperty("webdriver.chrome.driver", strChromeDriverPath);
							driver=new ChromeDriver();
							driver.manage().window().maximize();
							driver.manage().timeouts().implicitlyWait(12000, TimeUnit.SECONDS);
							objConfig.strDriverType="Desktop";
						}
						else if(objConfig.strBrowserName.toLowerCase().equals("firefox"))
						{
							objConfig.strDriverType="Desktop";
						}	
						else if(objConfig.strBrowserName.toLowerCase().equals("androidchrome"))
						{
							if(driver==null)
							{
								RestartApp=true;
							}
							if(RestartApp)
							{
								 String strChromeDriverPath=FileUtilities.fnGetCurrentUserDir()+"/Tools/Driver/Windows/chromedriver.exe";
								 DesiredCapabilities capabilities = new DesiredCapabilities();
								 capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
							     capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,objConfig.strPlatformName);
							     capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,objConfig.strPlatformVersion);
							     capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,objConfig.strDeviceName);
							     capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,objConfig.strNewCommandTimeOut);
							     capabilities.setCapability("autoGrantPermissions", "true");
							     capabilities.setCapability("chromedriverExecutable",strChromeDriverPath);
							     driver=new AndroidDriver(new URL(objConfig.strAppiumURL), capabilities);
							     driver.get(objConfig.strURL);
							     fnHandleAndroidChromePopup();
							     RestartApp=false;
							}
							else
							{
								driver.navigate().to(objConfig.strURL);
								fnHandleAndroidChromePopup();
							}
							objConfig.strDriverType="androidchrome";
						}
						else if(objConfig.strBrowserName.toLowerCase().equals("chromemobileview"))
						{
							if(driver==null)
							{
								RestartApp=true;
							}
							if(RestartApp)
							{
								String strChromeDriverPath=FileUtilities.fnGetCurrentUserDir()+"/Tools/Driver/Windows/chromedriver.exe";
								System.setProperty("webdriver.chrome.driver", strChromeDriverPath);
								DesiredCapabilities capabilities = new DesiredCapabilities();
				                Map<String, String> mobileEmulation = new HashMap<>();
				                mobileEmulation.put("deviceName", objConfig.strmobileEmulation);
				                ChromeOptions chromeoptions  = new ChromeOptions();
				                chromeoptions.addArguments("test-type");
				                chromeoptions.addArguments("disable-session-crashed-bubble");
				                chromeoptions.addArguments("disable-popup-blocking");
				                chromeoptions.addArguments("--incognito");
				                chromeoptions.setExperimentalOption("mobileEmulation", mobileEmulation);
				                capabilities.setCapability(ChromeOptions.CAPABILITY, chromeoptions);
				                capabilities.setCapability("browserName", "chrome");
				                driver = new ChromeDriver(capabilities);
				                driver.manage().window().maximize();
				                driver.manage().timeouts().implicitlyWait(12000, TimeUnit.SECONDS);
				                objConfig.strDriverType="chromemobileview";
				                RestartApp=false;
							}
						}
					}
					else if(objConfig.strApplicationType.toLowerCase().startsWith("app"))
					{
						objConfig.strDriverType="Mobile";
						System.out.println("In Android block");
						if(RestartApp)
						{
							startAppiumServerWindows();
							DesiredCapabilities capabilities = new DesiredCapabilities();
					        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,objConfig.strOSName);
					        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,objConfig.strOSVersion);
					        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,objConfig.strDeviceName);
					        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,objConfig.strNewCommandTimeOut);
					        if(Integer.parseInt(objConfig.strOSVersion)>6)
                            {
                                capabilities.setCapability("automationName","UiAutomator2");
                            }
                            capabilities.setCapability("appPackage",objConfig.strAppPackage);
                            capabilities.setCapability("appActivity",objConfig.strAppActivity);
                            capabilities.setCapability("noReset","true");
					        System.out.println("Test Started" );
					        System.out.println("Appium URL is Set ==> " + objConfig.strAppiumURL );
					        driver=new AndroidDriver(new URL(objConfig.strAppiumURL), capabilities);
					        Thread.sleep(10000);
						}
						if(Boolean.parseBoolean(objConfig.strRestartAppWithAppium)==false)
						{
							RestartApp=false;
						}
						((AndroidDriver) driver).closeApp();
						Thread.sleep(20000);
						try{((AndroidDriver) driver).runAppInBackground(1);}catch (Exception e) {}
						((AndroidDriver) driver).launchApp();
						Thread.sleep(20000);
				 }
				}
				else if(objConfig.strBaseOSName.toLowerCase().startsWith("mac"))
				{
					if(objConfig.strApplicationType.toLowerCase().startsWith("browser"))
					{
						if(objConfig.strBrowserName.toLowerCase().equals("chrome"))
						{
							System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
							driver = new ChromeDriver(); 
							objConfig.strDriverType="Desktop";
						}
						else if(objConfig.strBrowserName.toLowerCase().equals("firefox"))
						{
							
							objConfig.strDriverType="Desktop";
						}	
						else if(objConfig.strBrowserName.toLowerCase().equals("androidchrome"))
						{
							objConfig.strDriverType="Mobile";
						}
					}
					else if(objConfig.strApplicationType.toLowerCase().startsWith("app"))
					{
						if(RestartApp)
						{
							if(Boolean.parseBoolean(objConfig.strRunAppiumWithCode)==true)
							{
								startServer();
							}
						}
						if(objConfig.strAppiumAppType.toLowerCase().startsWith("apk"))
						{
							
						}
						else
						{
							System.out.println("In iphone block");
							if(RestartApp)
							{
								DesiredCapabilities capabilitiesForAppium = new DesiredCapabilities();
								capabilitiesForAppium.setCapability(MobileCapabilityType.PLATFORM_NAME, objConfig.strPlatformName);
								capabilitiesForAppium.setCapability(MobileCapabilityType.PLATFORM_VERSION, objConfig.strPlatformVersion);
								capabilitiesForAppium.setCapability(MobileCapabilityType.DEVICE_NAME,objConfig.strDeviceName);
								capabilitiesForAppium.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 10000);
								capabilitiesForAppium.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
								capabilitiesForAppium.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,8000);
								//capabilitiesForAppium.setCapability(MobileCapabilityType.NO_RESET, true);
								//capabilitiesForAppium.setCapability(MobileCapabilityType.FULL_RESET, false);
								capabilitiesForAppium.setCapability("useNewWDA", "true");
								capabilitiesForAppium.setCapability(IOSMobileCapabilityType.WAIT_FOR_APP_SCRIPT, "target.elements().length > 0; $.delay(6000); $.acceptAlert();");
								//capabilitiesForAppium.setCapability("autoAcceptAlerts", true);
								capabilitiesForAppium.setCapability(IOSMobileCapabilityType.BUNDLE_ID,objConfig.strBundleID);
								capabilitiesForAppium.setCapability(MobileCapabilityType.UDID, objConfig.strUDID);
								driver = new IOSDriver(new URL(objConfig.strAppiumURL+"/wd/hub"),capabilitiesForAppium);
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								//try{driver.switchTo().alert().accept();}catch(Exception g){Reporter.fnPrintException(g);}
								Thread.sleep(5000);
								List<WebElement> element=driver.findElements(By.name("Allow"));
								if(element.size()>0)
								{
									element.get(0).click();
								}
								objConfig.strDriverType="Mobile";
							}
							if(Boolean.parseBoolean(objConfig.strRestartAppWithAppium)==false)
							{
								RestartApp=false;
							}
							((IOSDriver) driver).closeApp();
							try{((IOSDriver) driver).runAppInBackground(1);}catch (Exception e) {}
							((IOSDriver) driver).launchApp();
							Thread.sleep(5000);
						}
					}
				}
				else if(objConfig.strBaseOSName.toLowerCase().startsWith("ubu"))
				{
					if(objConfig.strApplicationType.toLowerCase().startsWith("browser"))
					{
						if(objConfig.strBrowserName.toLowerCase().equals("chrome"))
						{
							objConfig.strDriverType="Desktop";
						}
						else if(objConfig.strBrowserName.toLowerCase().equals("firefox"))
						{
							objConfig.strDriverType="Desktop";
						}	
						else if(objConfig.strBrowserName.toLowerCase().equals("androidchrome"))
						{
							objConfig.strDriverType="Mobile";
						}
					}
					else if(objConfig.strApplicationType.toLowerCase().startsWith("app"))
					{
						
					}
				}
			}
			else
			{
				
			}
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
		}		
		return driver;
	}
	
	
	public static String fnGetConfigFileName()
	{
		String strConfigFile="Default";
		try
		{
			String strTest=System.getProperty("configfile");
			System.out.println("Config File Selected ==> " + strTest);
			if(strTest.equals("null")==false)
			{
				strConfigFile=strTest;
			}
		}
		catch(Exception e){}
		return strConfigFile;
	}
	
	public static String fnGetTestDescription(ConfigDetails objConfig,HOOQInput objData)
	{
		String TestDescription="";
		try
		{
			String strCountry=objData.COUNTRY;
			String strEnvironment=objData.ENV;
			String strOS=objConfig.strOSName.toUpperCase();
			String ExecutionType=TestEngine.ExecutionType.toUpperCase();
			if(objConfig.strApplicationType.toLowerCase().startsWith("browser"))
			{
				String Browser=objConfig.strBrowserName.toUpperCase();
				TestDescription="Country : " +strCountry+" ** Environment : "+strEnvironment+" ** Application : "+strSheetName+" ** OS : "+strOS+" ** Browser : "+Browser+" ** Execution Type : "+ExecutionType;
			}
			else
			{
				TestDescription=strCountry+"_"+strEnvironment+"_"+strSheetName+"_"+strOS+"_HOOQ_APP_"+ExecutionType;
			}
		}catch(Exception e){Reporter.fnPrintException(e);}
		return TestDescription;
	}
	
	public static HOOQInput fnGetGoogleSheetDeviceDetails(ConfigDetails objConfig,HOOQInput objData)
	{
		try
		{
			String strGoogleSheet="";
			String ExecutionType=TestEngine.ExecutionType.toUpperCase();
			if(ExecutionType.toLowerCase().equals("regression"))
			{
				strGoogleSheet=objData.SHEET_NMAE_REG;
			}
			else
			{
				strGoogleSheet=objData.SHEET_NAME_SANITY;
			}
			String strApplicationType=objConfig.strApplicationType.toLowerCase();
			String strPlatform=objConfig.strOSName.toUpperCase();
			String strDevice="";
			if(strApplicationType.equals("browser"))
			{
				strDevice=objConfig.strBrowserName.toUpperCase();
			}
			else
			{
				strDevice=strSheetName;
			}
			String strScriptName=objData.strScriptName;		
			objData.strGoogleSheet=strGoogleSheet;
			objData.strPlatform=strPlatform;
			objData.strDevice=strDevice;
			
		}catch(Exception e){Reporter.fnPrintException(e);}
		return objData;
	}
	
	public static String fnGetTestRailSuiteName()
	{
		String strTestRailSuiteName="";
		try
		{
			if(ExecutionType.toLowerCase().equals("sanity")||ExecutionType.toLowerCase().equals("internal"))
			{
				strTestRailSuiteName=strSheetName+"_Sanity";
			}
			else
			{
				strTestRailSuiteName=strSheetName+"_Regression";
			}
		}
		catch(Exception e){Reporter.fnPrintException(e);}
		return strTestRailSuiteName;
	}
	
	public static void stopServer() {
		String[] command = { "/usr/bin/killall", "-KILL", "node" };
		try {
			Runtime.getRuntime().exec(command);
			System.out.println("Appium server stopped.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void startServer() throws InterruptedException
	{
		stopServer();
		Thread.sleep(10000);
		Map<String, String> env = new HashMap<>(System.getenv());
		env.put("PATH", "/usr/local/bin:" + env.get("PATH"));
	    try
	    {
	    		AppiumServiceBuilder builder = new AppiumServiceBuilder()
	    				.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
	    				.usingDriverExecutable(new File("/usr/local/bin/node"))
	    				.withArgument(GeneralServerFlag.LOG_LEVEL, "info")
	    				.withIPAddress("127.0.0.1")
	    				.withEnvironment(env)
	    				.usingPort(4723);
	    		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
	    		service.start();
	    		System.out.println("**************************************************");
	    		System.out.println("			Appium is Started Successfully");
	    		System.out.println("**************************************************");
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    	System.out.println("**************************************************");
    		System.out.println("			Appium is not Started Successfully");
    		System.out.println("**************************************************");	    }
	}
	public void fnCloseTest()
    {
		fnAssignSlackData();
        if(ReportStatus.blnStatus==false)
        {
        	try{JiraAPI.fnAssignJIRADetails();} catch (JiraException e){}
        	Assert.fail();
        }
    }
	
	public static void stopAppiumServer() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("taskkill /F /IM node.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void startAppiumServerWindows()
	{
		try
		{
			stopAppiumServer();
			Thread.sleep(10000);
			String Appium_Node_Path="C:\\Program Files (x86)\\Appium\\node.exe";
			String Appium_JS_Path="C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js";
			AppiumDriverLocalService service;
			service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().
		               usingDriverExecutable(new File(Appium_Node_Path)).
		               withAppiumJS(new File(Appium_JS_Path))
		               .withIPAddress("127.0.0.1")
		               .usingPort(4723)
		             //  .withLogFile(new File("E:/Raja/LogAppium/LogTxt.txt"))
		               );
		    service.start();
		    Thread.sleep(10000);
		    String  service_url = service.getUrl().toString();
		    System.out.println(service_url);
		    System.out.println("**************************************************");
    		System.out.println("			Appium is Started Successfully");
    		System.out.println("**************************************************");
		}
		catch(Exception e)
		{
			e.printStackTrace();
	    	System.out.println("**************************************************");
    		System.out.println("			Appium is not Started Successfully");
    		System.out.println("**************************************************");	    
		}
	}
	
	public static void fnHandleAndroidChromePopup() throws InterruptedException
	{
		Thread.sleep(10000);
		String webContext = ((AppiumDriver) driver).getContext();
		try
		{
			Set<String> contexts = ((AppiumDriver) driver).getContextHandles();
		    for (String context: contexts)
		    {
		    	if (context.contains("NATIVE_APP"))
		    	{
			            ((AppiumDriver) driver).context(context);
			            break;
			    }
			}
		    driver.findElement(By.id("com.android.chrome:id/positive_button")).click();		
		}
		catch(Exception e){}
	    ((AppiumDriver) driver).context(webContext);
	}
}
