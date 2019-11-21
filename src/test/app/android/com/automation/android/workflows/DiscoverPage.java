package com.automation.android.workflows;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import com.automation.reports.Reporter;
import com.sun.javafx.scene.traversal.Direction;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class DiscoverPage extends BasePage{
//Locators
	 By btnSearch = By.id("tv.hooq.android:id/search");
	 By btnSearchcc = By.id("cardnumber");
	 By searchmov = By.id("tv.hooq.android:id/imagePortrait");
	 By edtSearch = By.id("tv.hooq.android:id/inputSearch");
	 By searchresult = By.id("tv.hooq.android:id/matchedTitlesSection");
	 By matchResult= By.id("tv.hooq.android:id/matchedTitlesListView");
	 By discoverTbl=By.id("tv.hooq.android:id/discover_feed_list");
	 By banner=By.id("tv.hooq.android:id/spotlightLayout");
	 By contniueWatching=By.xpath("//android.widget.TextView[@text='Continue Watching']");
	 By quickLink=By.id("tv.hooq.android:id/recycler_view");
	 By discoverfeed=By.id("tv.hooq.android:id/discover_feed_list");
	 By quickLinkName=By.className("android.widget.TextView");
	 By label=By.id("tv.hooq.android:id/tvLabel");
	 By contentTbl=By.id("tv.hooq.android:id/rvSeeAllContents");
	 By appBarLayout=By.id("tv.hooq.android:id/app_bar_layout");
	 By spotlightContainer=By.id("tv.hooq.android:id/spotlightContainer");
	 By spotlightList=By.id("tv.hooq.android:id/spotlight_list");
	 By spotlightRecycleView=By.id("tv.hooq.android:id/recycler_view");
	 By spotlightTitle=By.id("tv.hooq.android:id/tv_spotlight_title");
	 By spotlightTYpe=By.id("tv.hooq.android:id/tv_spotlight_title_type");
	 By spotlightPageIndicator=By.id("tv.hooq.android:id/pageIndicator");
	 By contentTitle=By.id("tv.hooq.android:id/txtAssetTitle");
	 
	public boolean fnVerifyDiscoverSection(boolean blnAnynomous) throws Throwable {
		Reporter.info("HOOQ Android","Verifying Discover Section");
		boolean blnStatus=true;
		try
		{
			commonPage.fnSelectTab("Discover");
			swipeUpOrBottom(false);
			boolean blnBanner=isElementDisplayed(banner);
			if(blnBanner)
			{
				Reporter.pass("Discover Page","Banner is displayed");	
			}
			else
			{
				Reporter.fail("Discover Page","Banner is not displayed");
			}
			//Discover Tab QuickLinks
			if(fnVerifyQuickLinksDiscover())
			{
				Reporter.pass("Discover Page","Quick Links Section is displayed");	
			}
			else
			{
				Reporter.fail("Discover Page","Quick Links Section is not displayed");
				blnStatus=false;
			}
			if(blnAnynomous==false)
			{
				Reporter.info("HOOQ Android","Verifying Discover Page Continue Page");
				boolean blnContinueWathingHeader=isElementDisplayed(contniueWatching);
				if(blnContinueWathingHeader)
				{
					Reporter.pass("Discover Page","Continue Watching Section is displayed");	
				}
				else
				{
					Reporter.fail("Discover Page","Continue Watching Section is not displayed");
					blnStatus=false;
				}
			}
			Reporter.info("HOOQ Android","Verifying Discover Page Genere");
			if(isElementDisplayed(discoverTbl))
			{
				boolean blnSwipe=true;
				List<String> arrData=new ArrayList<String>();
				for(int i=0;i<10;i++)
				{
					List<WebElement> eleTbl=driver.findElements(By.id("tv.hooq.android:id/title_text"));
					if(eleTbl.size()>0)
					{
						if(blnSwipe)
						{
							for(int j=0;j<eleTbl.size();j++)
							{
								String strText=eleTbl.get(j).getText();
								System.out.println(strText);
								arrData=fnGetDiscoverFeedData(arrData, strText);
							}
						}
					}
					swipeUpOrBottom(true);
				}
				if(arrData.size()>0)
				{
					Reporter.pass("Discover Page","Total Genere :- " + arrData.size() + " is displayed");
					for(int i=0;i<arrData.size();i++)
					{
						
						System.out.println(arrData.get(i));
						Reporter.pass("Discover Page","Discover Genere :-  " + arrData.get(i) + " is displayed");
					}
				}
				else
				{
					Reporter.fail("Discover Page","Total Genere :- " + arrData.size() + " is displayed");
				}
			}
			else
			{
				Reporter.fail("Discover Page","Discover Genere is not displayed");
				blnStatus=false;
			}
			
			
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			blnStatus=false;
		}
		return blnStatus;
	}

	public List<String> fnGetDiscoverFeedData(List<String> arrData,String strData)
	{
		boolean blnAdd=true;
		for(int i=0;i<arrData.size();i++)
		{
			if(arrData.get(i).equals(strData))
			{
				blnAdd=false;
			}
		}
		if(blnAdd)
		{
			arrData.add(strData);			
		}
		return arrData;
	}
	
	public boolean clickAndSearchPlay(String strContent) throws Throwable 
	{
		Reporter.info("HOOQ Sanity","Verifying HOOQ_IOS_MOBILE_Login");
		click(btnSearch, "Search button");
		type(edtSearch,strContent, "Enter Movie Details");
		if(isElementPresent(searchresult))
		{
			Reporter.pass("Search result match", "Search result match is displayed");
			MobileElement eleMobile=(MobileElement) driver.findElement(By.id("tv.hooq.android:id/matchedTitlesListView"));		
	 		List<MobileElement> eleEpisode=eleMobile.findElements(By.className("android.widget.LinearLayout"));
	 		System.out.println(eleEpisode.size());
	 		eleEpisode.get(0).click();
	 	
			
		} 
		else{
			Reporter.fail("Search result match", "Search result match is not displayed");
		}
		
		return false;
}
	public  boolean fnVerifyQuickLinksDiscover() throws Throwable
	{	
		Reporter.info("HOOQ Android","Verifying Quick Link Section");
		boolean blnStatus=true;
		try
		{
			List<WebElement> eleQuickLinks=driver.findElement(discoverTbl).findElements(By.className("android.widget.LinearLayout"));
			if(eleQuickLinks.size()>0)
			{
				List<WebElement> eleList=eleQuickLinks.get(0).findElement(By.id("tv.hooq.android:id/recycler_view")).findElements(By.className("android.widget.TextView"));
				System.out.println(eleList.size());
				if(eleList.size()>0)
				{
					Reporter.pass("Quick Link Section","Quick Link is displayed");
					for(int i=0;i<eleList.size()-1;i++)
					{
						System.out.println(eleList.get(i).getText());
						Reporter.pass("Quick Link Section","Quick Link :-  " +eleList.get(i).getText() + " is displayed");
					}
				}
				else
				{
					Reporter.fail("Quick Link Section","Quick Link is not displayed");
					blnStatus=false;
				}
			}
			else
			{
				Reporter.fail("Quick Link Section","Quick Link is not displayed");
				blnStatus=false;
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
		}
		return blnStatus;
	}
	
	public List<String> fnAdddataQuickinks(List<String> arrData,String strData)
	{
		boolean blnAdd=false;
		for(int i=0;i<arrData.size();i++)
		{
			if(arrData.get(i).equals(strData))
			{
				blnAdd=true;
				break;
			}
		}
		if(blnAdd==false)
		{
			arrData.add(strData);
		}
		return arrData;
	}

	public boolean fnCheckQuickLink(List<String> arrData,String strData)
	{
		boolean blnStatus=false;
		for(int i=0;i<arrData.size();i++)
		{
			if(arrData.get(i).startsWith(strData))
			{
				blnStatus=true;
				break;
			}
		}
		return blnStatus;
	}

	public boolean fnVerifyQuickLinks() throws Throwable
	{
		boolean blnStatus=true;
		Reporter.blnReportTempStatus=true;
		try
		{
			Thread.sleep(10000);
			List<WebElement> eleList=driver.findElements(discoverfeed);
		    List<WebElement> eleList1=eleList.get(0).findElements(By.className("android.widget.LinearLayout"));
		    boolean blnAction=true;
		    boolean blnFirst=true;
		    String strLast=null;
		    List<String> arrData=new ArrayList<String>();
		    int intCount=0;
		    List<String> arrDataQuickLink=new ArrayList<String>();
		    while(blnAction)
		    {
		    	 if(blnFirst==false)
		    	 {
		    		 int intCounteDatar=arrData.size()-1;
		    		 strLast=arrData.get(intCounteDatar);
		    	 }
		    	 List<WebElement> eleList2=eleList1.get(0).findElements(By.className("androidx.recyclerview.widget.RecyclerView"));
		    	 WebElement elem=eleList2.get(0);
		    	 List<WebElement> eleQuickLinkName=eleList2.get(0).findElements(quickLinkName);
		    	 int intCountLast=eleQuickLinkName.size();
		    	 if(blnFirst)
		    	 {
		    		 intCountLast=intCountLast-1;
		    	 }
		    	 for(int i=0;i<intCountLast;i++)
		    	 {
		    		 String strData=eleQuickLinkName.get(i).getText();
		    		 System.out.println("I==> " + i + "   " +strData);
		    		 if(strData.startsWith("S1 E"))
		    		 {
		    			 continue;
		    		 }
		    		 arrData=fnAdddataQuickinks(arrData,strData);
		    		 if(fnCheckQuickLink(arrDataQuickLink, strData)==false)
		    		 {
		    			 eleQuickLinkName.get(i).click();
		        		 Thread.sleep(5000);
		        		 if(isElementDisplayed(label))
		        		 {
		        			 String strLabel=driver.findElement(label).getText();
		        			 List<WebElement> eleListContent=driver.findElement(contentTbl).findElements(By.className("android.widget.FrameLayout"));
		        			 String strText1=strData+"*"+strLabel+"*"+eleListContent.size();
		        			 arrDataQuickLink=fnAdddataQuickinks(arrDataQuickLink,strText1);
		        		 }
		        		 driver.navigate().back();
		    		 }
		    	 }
		    	 if(blnFirst==false)
		    	 {
		    		 int intCounter=eleQuickLinkName.size()-1;
		    		 String strLastQuickLink=eleQuickLinkName.get(intCounter).getText();
		    		 if(strLastQuickLink.equals(strLast))
		    		 {
		    			 intCount=intCount+1;
		    		 }
		    		 else
		    		 {
		    			 intCount=0;
		    		 }
		    	 }
		    	 else
		    	 {
		    		 blnFirst=false;
		    	 }
		    	 scrollElement((AppiumDriver) driver,elem);
		    	 Thread.sleep(5000);
		    	 if(intCount>5)
		    	 {
		    		 blnAction=false;
		    	 }
		    }
		    Reporter.info("HOOQ Android", "Quick Link Details Verification");
		    for(int i=0;i<arrDataQuickLink.size();i++)
		    {
		    	//System.out.println(arrDataQuickLink.get(i));
		    	String[] strDetails=arrDataQuickLink.get(i).split("\\*");
		    	String strDiscoverQuickLinks=strDetails[0];
		    	String strQuickLinkslabel=strDetails[1];
		    	String strQuickLinksTable=strDetails[2];
		    	if(strDiscoverQuickLinks.equals(strQuickLinkslabel))
		    	{
		    		Reporter.pass("Quick Links Discover", "Quick Links ==> " + strDiscoverQuickLinks + " is working fine.");
		    		Reporter.pass("Quick Links Discover", "Quick Links ==> " + strDiscoverQuickLinks + " Total Item Count ==> "+strQuickLinksTable + " is displyed");
			   }
		    	else
		    	{
		    		Reporter.fail("Quick Links Discover", "Quick Links ==> " + strDiscoverQuickLinks + " is not working.");
		    	}
		    }
		}
		catch(Exception e){e.printStackTrace();return false;}
		blnStatus=Reporter.blnReportTempStatus;
		return blnStatus;

	}
	
	public boolean fnVerifySpotLight()
	{
		Reporter.info("HOOQ Android", "SpotLight Discover Verification");
		boolean blnStatus=true;
		Reporter.blnReportTempStatus=true;
		try
		{
			   	List<WebElement> eleAppBarLayout=driver.findElements(appBarLayout);
			    List<WebElement> elespotLightCont=eleAppBarLayout.get(0).findElements(spotlightContainer);
			    List<WebElement> elePageIndicator=elespotLightCont.get(0).findElements(spotlightPageIndicator);
			    System.out.println("Page Indicator ==> " +elePageIndicator.size());
			    if(elePageIndicator.size()>0)
		    	{
		    		Reporter.pass("SpotLight Discover", "SpotLight PageIndicator is displayed");		    		
		    	}
		    	else
		    	{
		    		Reporter.fail("SpotLight Discover", "SpotLight PageIndicator is not displayed");
		    	}
			    List<String> arrData=new ArrayList<String>();
			    boolean blnAction=true;
			    while(blnAction)
			    {
			    	List<WebElement> elespotlightList=elespotLightCont.get(0).findElements(spotlightList);
			        List<WebElement> elerecicycleview=elespotlightList.get(0).findElements(spotlightRecycleView);
			        List<WebElement> eleTitle=elerecicycleview.get(0).findElements(spotlightTitle);
			        String strTitle="";
			        String strType="";
			        if(eleTitle.size()>0)
			        {
			         	strTitle=eleTitle.get(0).getText();
			        }
			        List<WebElement> eleType=elerecicycleview.get(0).findElements(spotlightTYpe);
			        if(eleType.size()>0)
			        {
			         	strType=eleType.get(0).getText();
			        }
			        if(arrData!=null)
			        {
			        	if(arrData.size()>1)
			        	{
			        		if(fnVerifySpotLightData(arrData,strTitle))
			        		{
			        			blnAction=false;
			        			break;
			        		}
			        	}
			        }
			      	String contentDetailisTitle="";
			       	eleTitle.get(0).click();
			       	Thread.sleep(5000);
			       	List<WebElement> eleContentTitle=driver.findElements(contentTitle);
			       	if(eleContentTitle.size()>0)
			       	{
			       		contentDetailisTitle=eleContentTitle.get(0).getText();
			       	}
			       	driver.navigate().back();
			       	Thread.sleep(5000);
			        String strDetails=strTitle+"*"+strType+"*"+ contentDetailisTitle;
			        arrData=fnAddSpotLightData(arrData,strDetails);
			        WebElement elem=elespotlightList.get(0);
			        fnScrollSpotLight(elem);
			    }
			    Reporter.info("HOOQ Android", "Spotlight Details Verification");
			    for(int i=0;i<arrData.size();i++)
			    {
			    	//System.out.println(arrDataQuickLink.get(i));
			    	String[] strDetails=arrData.get(i).split("\\*");
			    	String strDiscoverSpotLight=strDetails[0];
			    	String strDiscoverSpotLightType=strDetails[1];
			    	String strContentDetailsTitle=strDetails[2];
			    	Reporter.info("HOOQ Android", "Spotlight Details Verification for " + strDiscoverSpotLight);
			    	Reporter.pass("SpotLight Discover", "SpotLight Details ==> " + strDiscoverSpotLight + " is displayed");
			    	Reporter.pass("SpotLight Discover", "SpotLight Type ==> " + strDiscoverSpotLightType + " is displayed");
			    	if(strDiscoverSpotLight.toLowerCase().equals(strContentDetailsTitle.toLowerCase()))
			    	{
			    		Reporter.pass("SpotLight Discover", "Details of SpotLight ==> " + strDiscoverSpotLight + " is displayed successfully");	    		
			    	}
			    	else
			    	{
			    		Reporter.fail("SpotLight Discover", "Details of SpotLight ==> " + strDiscoverSpotLight + " is not displayed");
			    	}
			    }
		}
		catch(Exception e){return false;}
		blnStatus=Reporter.blnReportTempStatus;
		return blnStatus;
	}
	
public static boolean fnVerifySpotLightData(List<String> arrData,String strData)
{
	boolean blnStatus=false;
	try
	{
		String[] arrText=arrData.get(0).split("\\*");
		if(arrText[0].toLowerCase().equals(strData.toLowerCase()))
		{
			blnStatus=true;
		}
		
	}
	catch(Exception e){}
	return blnStatus;
}

public boolean fnScrollSpotLight(WebElement elem)
{
	boolean blnStatus=true;
	try
	{
		 Dimension size = elem.getSize();
		    int startY = (int) (size.height / 2);
		    int startX = (int) (size.width * 0.90);
		    int endX = (int) (size.width * 0.05);
		    TouchAction touch=new TouchAction((MobileDriver) driver);
		    touch.press(startX, startY).waitAction(5000).moveTo(endX, startY).release().perform();
	}
	catch(Exception e){blnStatus=false;}
	return blnStatus;
}

public List<String> fnAddSpotLightData(List<String> arrData,String strData)
{
	boolean blnAdd=false;
	for(int i=0;i<arrData.size();i++)
	{
		if(arrData.get(i).equals(strData))
		{
			blnAdd=true;
			break;
		}
	}
	if(blnAdd==false)
	{
		arrData.add(strData);
	}
	return arrData;
}
	
}