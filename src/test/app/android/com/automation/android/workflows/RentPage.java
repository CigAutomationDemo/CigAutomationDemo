package com.automation.android.workflows;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.accelerators.ActionEngine;
import com.automation.googledrive.GoogleDriveAPI;
import com.automation.reports.Reporter;
import io.appium.java_client.MobileElement;

public class RentPage extends BasePage{
//Locators
	By RentalPopUp=By.id("tv.hooq.android:id/okay");
	By RentHeaderTitle=By.id("tv.hooq.android:id/toolbarTitle");
	By RentPageTktInfo=By.id("tv.hooq.android:id/ticketText");
	By tblRent=By.id("tv.hooq.android:id/epoxyRecyclerView");
	By lblCollection=By.id("tv.hooq.android:id/tvTitle");
	By RentPageInnerTitle=By.id("tv.hooq.android:id/tvLabel");
	By btnFilter=By.id("tv.hooq.android:id/btnFilter");
	By filterCountLabel=By.id("tv.hooq.android:id/filterCountLabel");
	By rentbtn = By.xpath("//android.widget.RelativeLayout[@resource-id='tv.hooq.android:id/btnRent']");	
	By rent = By.id("tv.hooq.android:id/btnRent");
	By premium = By.id("tv.hooq.android:id/btnPremium");
	By rentwhatsnew = By.xpath("//android.widget.TextView[@text='WHAT'S NEW ON HOOQ']");
	By explorebtn = By.xpath("//android.widget.Button[@text='Explore Rental Movies']");
	By premiumbtn = By.xpath("//android.widget.Button[@text='Explore Rental Movies']");
	By subscriptionr = By.xpath("//android.widget.TextView[@text='Subscription']");
	By ticketscnt = By.xpath("//android.widget.TextView[@text='Tickets']");
	By renttc = By.xpath("//android.widget.TextView[@text='Terms of Use']");
	By rentpayment = By.xpath("//android.widget.TextView[@text='PAYMENT METHOD']");
	By phpprice = By.xpath("//android.widget.TextView[@text='PHP 125']");
	By latestmvtext = By.xpath("//android.widget.TextView[@text='Latest movies now available for rent!']");
	By ticketdesc = By.xpath("//android.widget.TextView[@text='Already on a monthly HOOQ subscription? Congratulations! Each month�s subscription comes with 1 ticket for a movie rental on us!']");
	By exploremovie = By.id("tv.hooq.android:id/okay");
	By ccmovie = By.id("tv.hooq.android:id/desc");
	By rentoptn = By.id("tv.hooq.android:id/fabbutton_ring");
	By renttvod = By.id("tv.hooq.android:id/rental");
	By rentoptn1 = By.id("tv.hooq.android:id/lbl_rent");
	By rentcollheader = By.id("tv.hooq.android:id/searchHeader");
	By anonrent = By.id("tv.hooq.android:id/btnRent");
	By tktredeem = By.id("tv.hooq.android:id/btnRedeem");
	By rentoptntab = By.id("tv.hooq.android:id/watchContainer");
	By tktpurchase = By.id("tv.hooq.android:id/btnSecond");
	By tktpurchase1 = By.id("tv.hooq.android:id/lblRedeem");
	By tktconfirm = By.id("tv.hooq.android:id/okay");
	By ticketconform = By.xpath("//android.widget.Button[@text='Confirm']");
	By tktwatchltr = By.xpath("//android.widget.Button[@text='Confirm']");
	By rentmakepayment = By.xpath("//android.widget.Button[@text='Make Payment']");
	By ccradio = By.id("tv.hooq.android:id/radioButton");
	By tvodcc = By.xpath("//android.widget.Button[@text='Rent for PHP 125']");
	By tvodConform = By.xpath("//android.widget.TextView[@text='Confirm']");
	By rentSubScripText = By.xpath("//android.widget.TextView[@text='Subscription']");
	By subscriptiondays = By.id("tv.hooq.android:id/subscription_days");
	By ticketredeem = By.xpath("//android.widget.TextView[@text='TICKET REDEEMED']");
	By rentticketsText = By.xpath("//android.widget.TextView[@text='Tickets']");
	By nooftickets = By.id("tv.hooq.android:id/tickets");
	By lapsedesc = By.id("tv.hooq.android:id/content");
	By lapsedsubs = By.id("tv.hooq.android:id/toolbarTitle");
	By ticketredeeminfo = By.id("tv.hooq.android:id/content");
	By lapsesubs = By.xpath("//android.widget.TextView[@text='Subscribe']");
	By watchnow = By.id("tv.hooq.android:id/okay");
	By rentheader = By.id("tv.hooq.android:id/toolbarTitle");
	By premiumheader = By.xpath("//android.widget.TextView[@text='Rent']");
    By rentticketdesc = By.id("tv.hooq.android:id/ticketText");
	By playButtonrent = By.id("tv.hooq.android:id/fabbutton_ring");
	By Trailer = By.id("tv.hooq.android:id/trailerButton"); 
	By Trailer1 = By.id("tv.hooq.android:id/watchTrailer");                                   
	By merentals = By.xpath("//android.widget.TextView[@text='Rentals']");
	By rentpurchasedes = By.xpath("//android.widget.TextView[@text='Start within 30 days, finish within 48 hours.']");
	By firstCollection1 = By.xpath("//android.widget.RelativeLayout[@resource-id='tv.hooq.android:id/collectionItem']");
	By rentpurchasedestc = By.xpath("//android.widget.TextView[@text='Terms of Use']");
	By myrentalsplay = By.id("tv.hooq.android:id/btnPlay");
	By rentimg = By.id("tv.hooq.android:id/imgRent");
	By renttabtext = By.id("tv.hooq.android:id/txtRent");
	By rentcollectionimg = By.id("tv.hooq.android:id/ribbon");
	By rentcollectionimgtab = By.id("tv.hooq.android:id/rent_flag");
	By rentflag = By.id("tv.hooq.android:id/rent_flag_portrait");
	By trailer = By.id("tv.hooq.android:id/btnTrailer");
	By Rentposter = By.id("tv.hooq.android:id/imgLeftPoster");
	By myrentalstitle = By.id("tv.hooq.android:id/title");
	By discrent = By.id("tv.hooq.android:id/btnRent");	 
	By rentsect = By.id("tv.hooq.android:id/ribbon");
	By tabPremium=By.id("tv.hooq.android:id/btnPremium");
	By ticketconfirm = By.id("tv.hooq.android:id/okay");
	By seeAll=By.id("tv.hooq.android:id/txt_see_all");
	By tblRentInner=By.id("tv.hooq.android:id/rvSeeAllContents");
	By rentPopup=By.id("tv.hooq.android:id/dialogContentLayout");
	By rentPopupMessage1=By.id("tv.hooq.android:id/title");
	By rentPopupMessage2=By.id("tv.hooq.android:id/content");
	By rentPopupMessage3=By.id("tv.hooq.android:id/footer");
	By rentPopupCancel=By.id("tv.hooq.android:id/btnSecond");
	By rentPopupConfirm=By.id("tv.hooq.android:id/okay");
	
	public boolean fnVerifyRentSection() throws Throwable {
		Reporter.info("HOOQ Android","Verifying Rent Section");
		boolean blnStatus=true;
		try
		{
			commonPage.fnSelectTab("rent");
			Thread.sleep(10000);
			if(isElementDisplayed(RentHeaderTitle,"Rent Page"))
			{
				Reporter.pass("Rent Page Screen", "Rent Page is displayed");
				getText(RentPageTktInfo,"Rent Page Ticket Info");
				WebElement eleTbl=driver.findElement(tblRent);
				List<WebElement> eleCat=eleTbl.findElements(By.className("android.widget.LinearLayout"));
				if(eleCat.size() >0)
				{
					Reporter.pass("Rent Page Screen",eleCat.size() +  " Collection Secton is displayed");
					List<String> arrData=new ArrayList<String>();
					System.out.println(eleCat.size());
					int intUp=0;
					for(int i=0;i<12;i++)
					{
						
						if(intUp==2)
						{
							swipeUpOrBottom(true);
							intUp=0;
						}
						else
						{
							intUp=intUp+1;
						}
						eleCat=eleTbl.findElements(By.className("android.widget.LinearLayout"));
						String strCollectionName =eleCat.get(i).findElement(lblCollection).getText();
						System.out.println(strCollectionName);
						String strSeeAll="NA";
						if(eleCat.get(i).findElement(seeAll).getText().toLowerCase().equals("see all"))
						{
							strSeeAll="Yes";
						}						
						int intMoviesCollection=eleCat.get(i).findElement(By.className("android.widget.LinearLayout")).findElements(By.id("tv.hooq.android:id/imgPoster")).size();
						String strData=strCollectionName+"/"+strSeeAll+"/"+intMoviesCollection;
						arrData=fnGetMoviesData(arrData, strData);
					}
					if(arrData.size()>0)
					{
						Reporter.pass("Rent Section", "Rent Section Total Section :- "+ arrData.size() +" is displayed");
						for(int i=0;i<arrData.size();i++)
						{
							String[] arrNewdata=arrData.get(i).split("/");
							Reporter.pass("Rent Section", "Rent Section :- "+ arrNewdata[0] +" is displayed");
							if(arrNewdata[1].toLowerCase().contains("na"))
							{
								Reporter.fail("Rent Section", "Rent Section :- "+ arrNewdata[0] +" See All is not displayed");
							}
							else
							{
								Reporter.pass("Rent Section", "Rent Section :- "+ arrNewdata[0] +" See All is displayed");
							}
							Reporter.pass("Rent Section", "Rent Section :- "+ arrNewdata[0] +" Total Rent Movie :- " + arrNewdata[2] +" is displayed");
						}
					}
					else
					{
						Reporter.fail("Rent Section", "Rent Section Total Section :- "+ arrData.size() +" is displayed");
					}
					for(int i=0;i<7;i++)
					{
						swipeUpOrBottom(false);
					}
					String strText1=eleCat.get(1).findElement(lblCollection).getText();
					if(eleCat.size()>0)
					{
						eleCat.get(1).findElement(seeAll).click();
						Thread.sleep(10000);
						String strText=driver.findElement(RentPageInnerTitle).getText();
						if(strText.equalsIgnoreCase(strText1))
						{
							Reporter.pass("Rent Content","Rent Page Content Title "+strText+" is displayed");	
						}
						else
						{
							Reporter.fail("Rent Content","Rent Page Content Title "+strText+" is not displayed");
						}
						String strTextCount=driver.findElement(RentPageInnerTitle).getText();
						if(strTextCount.length()>0)
						{
							Reporter.pass("Rent Content","Rent Page Result Count "+strTextCount+" is displayed");	
						}
						else
						{
							Reporter.fail("Rent Content","Rent Page Result Count is not displayed");
						}
						
						
						List<WebElement> eleContent=driver.findElement(tblRentInner).findElements(By.className("android.widget.FrameLayout"));
						if(eleContent.size()>0)
						{
							Reporter.pass("Rent Content","Rent Page Content List Total Collection : " + eleContent.size() +" is displayed");
						}
						else
						{
							Reporter.fail("Rent Content","Rent Page Content List is not displayed");
						}						
					}
					else
					{
						Reporter.fail("Rent Content","Rent Page Content List is not displayed");
					}
				}
			}
			
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			blnStatus=false;
		}
		return blnStatus;
	}

	/***
	 * Function Name :- fnDismissRentalPopUp
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public  boolean fnDismissRentalPopUp() throws Throwable
	{
		boolean blnPopup=false;
		try
		{
			if(isElementDisplayed(RentalPopUp))
			{
				click(RentalPopUp,"Explore Rental Movies Popup Dismiss");
				blnPopup=true;
			}
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
		}
		return blnPopup;
	}
	
	
	public boolean fnVerifyRentSectionExploreRentalPopUp() throws Throwable {
		Reporter.info("HOOQ Android","Verifying Rent Explore Rental PopUp Section");
		boolean blnStatus=true;
		try
		{
			commonPage.fnSelectTab("rent");
			Thread.sleep(10000);
			if(fnDismissRentalPopUp()==false)
			{
				blnStatus=false;
			}			
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
		}
		return blnStatus;
	}
	
	
	public List<String> fnGetMoviesData(List<String> arrData,String strData)
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
	
	public boolean fnVerifyRentSectionContentSelection() throws Throwable {
		Reporter.info("HOOQ Android","Verifying Rent Section Content Slection");
		boolean blnStatus=true;
		Reporter.blnReportTempStatus=true;
		try
		{
			commonPage.fnSelectTab("rent");
			Thread.sleep(10000);
			if(isElementDisplayed(RentHeaderTitle,"Rent Page"))
			{
				Reporter.pass("Rent Page Screen", "Rent Page is displayed");
				getText(RentPageTktInfo,"Rent Page Ticket Info");
				WebElement eleTbl=driver.findElement(tblRent);
				List<WebElement> eleCat=eleTbl.findElements(By.className("android.widget.LinearLayout"));
				if(eleCat.size() >0)
				{
					Reporter.pass("Rent Page Screen",eleCat.size() +  " Collection Secton is displayed");
					String strText1=eleCat.get(1).findElement(lblCollection).getText();
					if(eleCat.size()>0)
					{
						eleCat.get(1).findElement(seeAll).click();
						Thread.sleep(10000);
						String strText=driver.findElement(RentPageInnerTitle).getText();
						if(strText.equalsIgnoreCase(strText1))
						{
							Reporter.pass("Rent Content","Rent Page Content Title "+strText+" is displayed");	
						}
						else
						{
							Reporter.fail("Rent Content","Rent Page Content Title "+strText+" is not displayed");
						}
						String strTextCount=driver.findElement(RentPageInnerTitle).getText();
						if(strTextCount.length()>0)
						{
							Reporter.pass("Rent Content","Rent Page Result Count "+strTextCount+" is displayed");	
						}
						else
						{
							Reporter.fail("Rent Content","Rent Page Result Count is not displayed");
						}
						
						
						List<WebElement> eleContent=driver.findElement(tblRentInner).findElements(By.className("android.widget.FrameLayout"));
						if(eleContent.size()>0)
						{
							Reporter.pass("Rent Content","Rent Page Content List Total Collection : " + eleContent.size() +" is displayed");
							if(click(eleContent.get(0),"First Content From Rent"))
							{
								Reporter.pass("Rent Content","Rent Page Content First Content is selected");
							}
							else
							{
								Reporter.fail("Rent Content","Rent Page Content First Content is not selected");
							}
						}
						else
						{
							Reporter.fail("Rent Content","Rent Page Content List is not displayed");
						}						
					}
					else
					{
						Reporter.fail("Rent Content","Rent Page Content List is not displayed");
					}
				}
			}
			
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			Reporter.blnReportTempStatus=false;
		}
		blnStatus=Reporter.blnReportTempStatus;
		return blnStatus;
	}
	
	public boolean fnVerifyRentMoviePopup(String strContentName,boolean blnAction) throws Throwable {
		Reporter.info("HOOQ Android","Verifying Rent Movie PopUp Section");
		boolean blnStatus=true;
		try
		{
			if(isElementPresent(rentPopup))
			{
				Reporter.pass("Rent Content","Rent purchase Popup is displayed");
				String strText1=getText(rentPopupMessage1,"Rent Popup Title");
				String strPrice=fnGetTVODPrice();
				if(fnVerifyText(strText1, strPrice))
				{
					Reporter.pass("Rent Content","Rent Page Content Price :- " + strPrice + " is displayed");
				}
				else
				{
					Reporter.fail("Rent Content","Rent Page Content Price :- " + strPrice + " is not displayed");
				}
				if(fnVerifyText(strText1, strContentName))
				{
					Reporter.pass("Rent Content","Rent Page Content Price :- " + strContentName + " is displayed");
				}
				else
				{
					Reporter.fail("Rent Content","Rent Page Content Price :- " + strContentName + " is not displayed");
				}
				strText1=getText(rentPopupMessage2,"Rent Popup Title Info");
				if(fnVerifyText(strText1, "Start within 30 days, finish within 48 hours."))
				{
					Reporter.pass("Rent Content","Rent Page Content Price :- Start within 30 days, finish within 48 hours. is displayed");
				}
				else
				{
					Reporter.fail("Rent Content","Rent Page Content Price :- Start within 30 days, finish within 48 hours. is not displayed");
				}
				strText1=getText(rentPopupMessage3,"Rent Popup Footer");
				if(fnVerifyText(strText1, "Terms of Use"))
				{
					Reporter.pass("Rent Content","Rent Page Content Price :- Terms of Use is displayed");
				}
				else
				{
					Reporter.fail("Rent Content","Rent Page Content Price :- Terms of Use is not displayed");
				}
				strText1=getText(rentPopupCancel,"Rent Popup Cancel");
				if(fnVerifyText(strText1, "Cancel"))
				{
					Reporter.pass("Rent Content","Rent Page Content Price :- Cancel is displayed");
				}
				else
				{
					Reporter.fail("Rent Content","Rent Page Content Price :- Cancel is not displayed");
				}
				strText1=getText(rentPopupConfirm,"Rent Popup Confirm");
				if(fnVerifyText(strText1, "Confirm"))
				{
					Reporter.pass("Rent Content","Rent Page Content Price :- Confirm is displayed");
				}
				else
				{
					Reporter.fail("Rent Content","Rent Page Content Price :- Confirm is not displayed");
				}
				if(blnAction)
				{
					click(rentPopupConfirm, "Confirm");
				}
				else
				{
					click(rentPopupCancel, "Cancel");
				}
				Thread.sleep(10000);
			}
			else
			{
				Reporter.fail("Rent Content","Rent purchase Popup is not displayed");
			}
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
		}
		return blnStatus;
	}
	
	
	public String fnGetTVODPrice() throws Throwable
	{
		String strPrice="";
		boolean blnStatus=true;
		try
		{
			String spreadsheetId=objData.SHEET_ID;
			int intRowNo=2;
			String contentRange = "TVOD_Content"+"!F"+intRowNo+":F"+intRowNo;
			String strText=GoogleDriveAPI.fnGetData(spreadsheetId,contentRange);
			System.out.println("TVOD Price ==> " + strText);
			if(objData.COUNTRY.toLowerCase().equals("in"))
			{
				strPrice=strPrice+"INR";
			}
			else if(objData.COUNTRY.toLowerCase().equals("sg"))
			{
				strPrice=strPrice+"SGD";
			}
			else if(objData.COUNTRY.toLowerCase().equals("ph"))
			{
				strPrice=strPrice+"PHP";
			}
			else if(objData.COUNTRY.toLowerCase().equals("th"))
			{
				strPrice=strPrice+"THB";
			}
			else if(objData.COUNTRY.toLowerCase().equals("id"))
			{
				strPrice=strPrice+"IDR";
			}
			strPrice=strPrice+" "+strText;
		
		}
		catch(Exception e){blnStatus=false;}
		return strPrice;
	}
}
