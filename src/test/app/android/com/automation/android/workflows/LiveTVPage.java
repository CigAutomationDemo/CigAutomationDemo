package com.automation.android.workflows;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import com.automation.googledrive.ReportStatus;
import com.automation.reports.Reporter;
import com.sun.javafx.scene.traversal.Direction;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.TouchShortcuts;

public class LiveTVPage extends BasePage{
	//Locators
		By btnFullScreen=By.id("tv.hooq.android:id/btnFullscreen");
		By videoScreen=By.id("tv.hooq.android:id/brightcove_video_view");
		By liveTvViewer=By.id("tv.hooq.android:id/liveTvViewPager");
		By viewer=By.id("tv.hooq.android:id/rlChannels");
		By channels=By.id("tv.hooq.android:id/ervChannels");
		By channelTitle=By.id("tv.hooq.android:id/channels_title");
		By currentlyWatching=By.id("tv.hooq.android:id/currentlyWatching");
		By txtYouAreWatching=By.id("tv.hooq.android:id/tvYoureWatching");
		By tvChannelTitle=By.id("tv.hooq.android:id/tvChannelTitle");
		By tvAddtoWatchList=By.id("tv.hooq.android:id/tvAddOrRemoveToFromWatchlist");
		By tvWatchList=By.id("tv.hooq.android:id/llAddToOrRemoveFromWatchlist");
		By channelListClose=By.id("tv.hooq.android:id/channelListClose");
		By playerInnerViewer=By.id("tv.hooq.android:id/epoxyRecyclerView");
		By overlayFooter=By.id("tv.hooq.android:id/overlay_container");
		By ChannelListButton=By.id("tv.hooq.android:id/channelListBtn");
		By ChannelListName=By.id("tv.hooq.android:id/currentChannelName");
		By ChennelCatagories=By.id("tv.hooq.android:id/categories_tab");
		By progressBar=By.id("tv.hooq.android:id/loadingProgress");
		By ErrorPopUp=By.id("tv.hooq.android:id/promptOkDesc");
		By ErrorPopupOK=By.id("tv.hooq.android:id/promptOkButton");
		
		
		
		public boolean fnVerifyLiveTV(String strUserType) throws Throwable {
			Reporter.info("HOOQ Android","Verifying Verify LiveTV");
			objData.strLiveTvSheet="LiveTV_Android";
			objData.strGSheetPlatform="Android";
			objData.strGSheetDevice="HOOQ_Android";
			objData.strGSheetUserType=strUserType;
			objData.strGSheetModule="Sanity";
			commonPage.fnSelectTab("livetv");
			boolean blnFound=true;
			try{
				Reporter.info("HOOQ Live TV Screen","Verifying Live TV Screen");
				if(isElementDisplayed(videoScreen))
				{
					Reporter.pass("Live TV Screen", "Live TV Player Screen is displayed");
				}
				else
				{
					Reporter.fail("Live TV Screen", "Live TV Player Screen is not displayed");
				}
				if(isElementDisplayed(btnFullScreen))
				{
					Reporter.pass("Live TV Screen", "Live TV Player Screen Full Screen Button is displayed");
				}
				else
				{
					Reporter.fail("Live TV Screen", "Live TV Player Screen  Full Screen Button is not displayed");
				}
				List<WebElement> eleList=driver.findElements(liveTvViewer);
				System.out.println(eleList.size());
				List<WebElement> eleList1=eleList.get(0).findElements(viewer);
				System.out.println(eleList1.size());
				List<WebElement> eleList2=eleList1.get(0).findElements(channels);
				System.out.println(eleList2.size());
				List<WebElement> eleTitle=eleList2.get(0).findElements(channelTitle);
				System.out.println(eleTitle.size());
				for(int i=0;i<eleTitle.size();i++)
				{
					System.out.println(eleTitle.get(i).getText());
					Reporter.pass("Live TV Screen","Live TV Chennel Title " + eleTitle.get(i).getText() +" is displayed");
				}
				List<WebElement> eleCurent=eleList1.get(0).findElements(currentlyWatching);
				System.out.println(eleCurent.size());
				String strText1=eleCurent.get(0).findElement(txtYouAreWatching).getText();
				System.out.println(strText1);
				String strText2=eleCurent.get(0).findElement(tvChannelTitle).getText();
				System.out.println(strText2);
				List<WebElement> eleWatchListAdd=eleCurent.get(0).findElements(tvWatchList);
				System.out.println(eleWatchListAdd.size());
				List<WebElement> eleWatchListAddRemove=eleWatchListAdd.get(0).findElements(tvAddtoWatchList);
				System.out.println(eleWatchListAddRemove.size());
				if(eleWatchListAddRemove.size()>0)
				{	
					System.out.println("Remove to Watch List Button is displayed");
					String strText3=eleWatchListAddRemove.get(0).getText();
					System.out.println(strText3);
					Reporter.pass("Live TV Screen","Live TV Chennel WatchList " + strText3 +" is displayed");
				}
				else
				{
					Reporter.pass("Live TV Screen","Live TV Chennel WatchList is not displayed");
				}
				List<String> arrData=fnGetLiveTVChannelList();
				Reporter.info("HOOQ Android","Verifying Verify LiveTV Chennel List");
				if(arrData.size()>0)
				{
					Reporter.pass("Live TV Chennel","Total ==> " +arrData.size() + " Live TV Chennel is displayed");
				}
				else
				{
					Reporter.fail("Live TV Chennel","Total ==> " +arrData.size() + " Live TV Chennel is displayed");
				}
				for(int i=0;i<arrData.size();i++)
				{
					System.out.println(arrData.get(i));
					Reporter.pass("Live TV Chennel","Live TV Channel Name ==> " + arrData.get(i) + " is displayed");
				}
				Reporter.info("HOOQ Android","Verify LiveTV Chennel Selection");
				//Select Live TV Chennel
				for(int i=0;i<arrData.size();i++)
				{
					boolean blnStatus=true;
					objData.strLiveTvChnnel=arrData.get(i);
					Reporter.info("HOOQ Android","Verify LiveTV Chennel ==> " + arrData.get(i));
					if(fnSelectLiveTVChannelInner(arrData.get(i)))
					{
						if(i==0)
						{
							driver.navigate().back();
							Thread.sleep(5000);
						}
						String strChennelName=fnGetSelectedChannelName();
						if(fnVerifyText(strChennelName, arrData.get(i)))
						{
							Reporter.pass("Live TV Chennel","Selected Chennel ==> "+ arrData.get(i) + " Chennal Displayed ==> "+ strChennelName);
							
						}
						else
						{
							Reporter.fail("Live TV Chennel","Selected Chennel ==> "+ arrData.get(i) + " Chennal Displayed ==> "+ strChennelName);
							blnStatus=false;
						}
					}
					else
					{
						Reporter.fail("Live TV Chennel",arrData.get(i) + " Live TV Player Screen is not displayed");
						blnStatus=false;
					}
					ReportStatus.fnUpdateLiveTVDashboard(objData, blnStatus);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				Reporter.fnPrintException(e);
				blnFound=false;
			}
			return blnFound;
			
		}
		
		public List<String> fnGetLiveTVChannelList() throws Throwable 
		{
			List<String> arrData=new ArrayList<String>();
			try
			{
				fnPlayerChannelControl();
				for(int k=0;k<=5;k++)
				{
						fnSelectChannelCatagories("All Channels");
						List<WebElement> eleList=driver.findElements(playerInnerViewer);
						System.out.println(eleList.size());
						List<WebElement> eleList1=eleList.get(0).findElements(By.className("androidx.recyclerview.widget.RecyclerView"));
						System.out.println(eleList1.size());
						List<WebElement> eleList2=eleList1.get(0).findElements(By.id("tv.hooq.android:id/channel"));
						System.out.println(eleList2.size());
						for(int i=0;i<eleList2.size();i++)
						{
							String strText=eleList2.get(i).findElement(By.id("tv.hooq.android:id/name")).getText();
							System.out.println(strText);
							arrData=fnGetChennelListData(arrData,strText);
						}
						fnScrollPlayerScreen();
				}
				click(channelListClose,"Channel List Close");
				driver.navigate().back();				
				}
			catch(Exception e){e.printStackTrace();}
			return arrData;
		}
		
		
		public String fnGetSelectedChannelName() throws Throwable
		{
			String strText="";
			try
			{
				click(btnFullScreen,"Full Screen Button");
				Thread.sleep(5000);
				//fnHandlePlayerControlError();
				Dimension dimensions = driver.manage().window().getSize();
				int screenWidth = dimensions.getWidth();
				int screenHeight = dimensions.getHeight();
				System.out.println("X Coordinates ==> " + screenWidth);
				System.out.println("Y Coordinates ==> " + screenHeight);
				int intXActual=screenWidth/2;
				int intYActal=screenHeight/2;
				TouchAction action= new TouchAction((MobileDriver) driver);
				action.press(intXActual, intYActal).release().perform();
				strText=driver.findElement(ChannelListName).getText();
				driver.navigate().back();
			}
			catch(Exception e){e.printStackTrace();}
			return strText;
		}
		
		public List<String> fnGetChennelListData(List<String> arrData,String strData)
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
		
		
		public boolean  fnSelectLiveTVChannelInner(String strChanneName) throws Throwable 
		{
			boolean blnStatus=false;
			try
			{
				fnPlayerChannelControl();
				boolean blnAction=true;
				for(int k=0;k<=5;k++)
				{
					List<WebElement> eleList=driver.findElements(playerInnerViewer);
					System.out.println(eleList.size());
					List<WebElement> eleList1=eleList.get(0).findElements(By.className("androidx.recyclerview.widget.RecyclerView"));
					System.out.println(eleList1.size());
					List<WebElement> eleList2=eleList1.get(0).findElements(By.id("tv.hooq.android:id/channel"));
					System.out.println(eleList2.size());
					for(int i=0;i<eleList2.size();i++)
					{
						String strText=eleList2.get(i).findElement(By.id("tv.hooq.android:id/name")).getText();
						System.out.println(strText);
						if(fnVerifyText(strText, strChanneName))
						{
							eleList2.get(i).click();
							blnStatus=true;
							blnAction=false;
							Thread.sleep(10000);
						//	fnHandlePlayerControlError();
							break;
						}
					}
					if(blnAction==false)
					{
						break;
					}
					fnScrollPlayerScreen();
				}
				driver.navigate().back();				
			}
			catch(Exception e){e.printStackTrace();}
			return blnStatus;
		}
		
		public boolean fnScrollPlayerScreen()
		{
			boolean blnStatus=true;
			try
			{
				System.out.println("Test1");
				List<WebElement> eleList=driver.findElements(playerInnerViewer);
				System.out.println(eleList.size());
				List<WebElement> eleList1=eleList.get(0).findElements(By.className("androidx.recyclerview.widget.RecyclerView"));
				System.out.println(eleList1.size());
				MobileElement topCharts=(MobileElement) eleList1.get(0);
				Point point = topCharts.getLocation();
	    	    int startY = point.y;
	    	    int endY = point.y;
	    	    int startX = (int) ((driver.manage().window().getSize().getWidth()) * 0.80);
	    	    int endX = (int) ((driver.manage().window().getSize().getWidth()) * 0.20);
	    	    TouchAction actions = new TouchAction((MobileDriver) driver);
	    	    actions.press(startX, startY).waitAction(500).moveTo(endX, endY).release().perform();
	    	    Thread.sleep(5000);
			}
			catch(Exception e){e.printStackTrace();}
			return blnStatus;
		}
		
		public List<String> fnGetChannelCatagories()
		{
			List<String> arrData=new ArrayList<String>();
			try
			{
				List<WebElement> eleList=driver.findElements(ChennelCatagories);
				System.out.println(eleList.size());
				List<WebElement> eleList1=eleList.get(0).findElements(By.className("android.widget.LinearLayout"));
				System.out.println(eleList1.size());
				List<WebElement> eleList2=eleList1.get(0).findElements(By.className("androidx.appcompat.app.ActionBar$Tab"));
				System.out.println(eleList2.size());
				for(int i=0;i<eleList2.size();i++)
				{
					String strText=eleList2.get(i).getAttribute("content-desc");
					System.out.println(strText);
					arrData=fnGetChennelListData(arrData,strText);
				}
			}
			catch(Exception e){e.printStackTrace();}
			return arrData;
		}
		
		public boolean fnSelectChannelCatagories(String strCatagories)
		{
			boolean blnStatus=true;
			try
			{
				List<WebElement> eleList=driver.findElements(ChennelCatagories);
				System.out.println(eleList.size());
				List<WebElement> eleList1=eleList.get(0).findElements(By.className("android.widget.LinearLayout"));
				System.out.println(eleList1.size());
				List<WebElement> eleList2=eleList1.get(0).findElements(By.className("androidx.appcompat.app.ActionBar$Tab"));
				System.out.println(eleList2.size());
				eleList2.get(0).click();
				Thread.sleep(5000);
				/*for(int i=0;i<eleList2.size();i++)
				{
					String strText=eleList2.get(i).getAttribute("content-desc");
					System.out.println(strText);
					if(fnVerifyText(strText, strCatagories))
					{
						eleList2.get(i).click();
						Thread.sleep(5000);
						break;
					}
				}*/
			}
			catch(Exception e){e.printStackTrace();blnStatus=false;}
			return blnStatus;
		}
		
		public boolean fnPlayerChannelControl() throws Throwable
		{
			boolean blnStatus=true;
			try
			{
				click(btnFullScreen,"Full Screen Button");
				Thread.sleep(5000);
				Dimension dimensions = driver.manage().window().getSize();
				int screenWidth = dimensions.getWidth();
				int screenHeight = dimensions.getHeight();
				System.out.println("X Coordinates ==> " + screenWidth);
				System.out.println("Y Coordinates ==> " + screenHeight);
				int intXActual=screenWidth/2;
				int intYActal=screenHeight/2;
				TouchAction action= new TouchAction((MobileDriver) driver);
				action.press(intXActual, intYActal).release().perform();
				driver.findElement(ChannelListButton).click();
			}
			catch(Exception e){e.printStackTrace();blnStatus=false;}
			return blnStatus;
		}
		
		
		public boolean fnHandlePlayerControlError()
		{
			boolean blnStatus=true;
			try
			{
				while(blnStatus)
				{
					List<WebElement> eleList=driver.findElements(ErrorPopupOK);
					System.out.println(eleList.size());
					if(eleList.size()>0)
					{
						eleList.get(0).click();
					}
					List<WebElement> eleList1=driver.findElements(progressBar);
					System.out.println(eleList1.size());
					if(eleList1.size()==0)
					{
						blnStatus=false;
					}
					Thread.sleep(5000);
				}
			}
			catch(Exception e){}
			return blnStatus;
		}
	
}
