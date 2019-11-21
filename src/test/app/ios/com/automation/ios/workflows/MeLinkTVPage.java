package com.automation.ios.workflows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.reports.Reporter;

public class MeLinkTVPage extends BasePage{
	//Locators
	By LinkTV=By.name("Link TV");
	By linkTVHeaderTitle=By.name("Link TV");
	By LinkTVButton=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton");
	By linkTVMessage1=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[1]");
	By linkTVMessage2=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[2]");
	By ScanQRCode=By.id("Scan QR Code");
	By EnterTVCode=By.id("Enter TV Code");
	By qrcode_box_mobile=By.id("qrcode_box_mobile");
	By ScanMessage=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText");
	By TVCodeMessage=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText");
	By TVCodeEntryBox=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeStaticText[4]");
	By LinkButton=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeButton");
	By backbutton=By.id("navbar back btn");
	
	
	/***
	 * Function Name :- fnVerifyLinkTV
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public  boolean fnVerifyLinkTV(boolean blnUserType) throws Throwable
	{
		Reporter.info("HOOQ IOS","Verifying Verify LinkTV");
		boolean blnFound=true;
		try{
			mePage.fnSelectME();
			if(blnUserType)
			{
				if(isElementDisplayed(LinkTV)==false){
					Reporter.fail("Link TV", "Link TV is displayed");
				} else{
					Reporter.pass("Link TV", "Link TV is not displayed");
				}
			}
			else
			{
				if(isElementDisplayed(LinkTV))
				{
					click(LinkTV,"Link TV");
					Thread.sleep(5000);
					if(isElementDisplayed(linkTVHeaderTitle))
					{
						Reporter.pass("Link TV", "Link TV Header is displayed");
					}
					else
					{
						Reporter.fail("Link TV", "Link TV Header is not displayed");
					}
					/*if(isElementDisplayed(logoMobileLinkTV))
					{
						Reporter.pass("Link TV", "Link TV Logo is displayed");
					}
					else
					{
						Reporter.fail("Link TV", "Link TV Logo is  not displayed");
					}*/
					String strText1=getText(linkTVMessage1,"Link TV Message 1");
					String strText2=getText(linkTVMessage2,"Link TV Message 2");
					if(strText1.contains("Launch "))
					{
						Reporter.pass("Link TV", "Link TV Message 1 is displayed , Message :- " + strText1);
					}
					else
					{
						Reporter.fail("Link TV", "Link TV Message 1 is not displayed, Message :- " + strText1);
					}
					if(strText2.contains("Using your mobile "))
					{
						Reporter.pass("Link TV", "Link TV Message 2 is displayed , Message :- " + strText2);
					}
					else
					{
						Reporter.fail("Link TV", "Link TV Message 2 is not displayed, Message :- " + strText2);
					}
					if(isElementDisplayed(LinkTVButton))
					{
						Reporter.pass("Link TV", "Link TV Button is displayed");
						click(LinkTVButton,"LinkTV Button");
						List<WebElement> element=driver.findElements(By.name("OK"));
						if(element.size()>0)
						{
							element.get(0).click();
						}
						Thread.sleep(5000);
						if(isElementDisplayed(linkTVHeaderTitle))
						{
							Reporter.pass("Link TV", "Link TV Header is displayed");
						}
						else
						{
							Reporter.fail("Link TV", "Link TV Header is not displayed");
						}
						if(isElementDisplayed(ScanQRCode))
						{
							Reporter.pass("Link TV", "Link TV ScanQRCode is displayed");
							click(ScanQRCode,"Scan QR Code");
						/*	String strText3=getText(ScanMessage,"Link TV Message ScanQRCode");
							if(strText3.contains("Scan the QR"))
							{
								Reporter.pass("Link TV", "Link TV Message ScanQRCode is displayed, Message :- " + strText3);
							}
							else
							{
								Reporter.fail("Link TV", "Link TV Message ScanQRCode is not displayed, Message :- " + strText3);
							}
							if(isElementDisplayed(qrcode_box_mobile))
							{
								Reporter.pass("Link TV", "Link TV QR Scan Box is displayed");
							}
							else
							{
								Reporter.fail("Link TV", "Link TV QR Scan Box is not displayed");
							}*/
						}
						else
						{
							Reporter.fail("Link TV", "Link TV ScanQRCode is not displayed");
						}
						if(isElementDisplayed(EnterTVCode))
						{
							Reporter.pass("Link TV", "Link TV Enter TV Code is displayed");
							click(EnterTVCode,"Enter TV Code");
							Thread.sleep(5000);
						/*	String strText3=getText(ScanMessage,"Link TV Message ScanQRCode");
							if(strText3.contains("Please enter the 6"))
							{
								Reporter.pass("Link TV", "Link TV Message ScanQRCode is displayed, Message :- " + strText3);
							}
							else
							{
								Reporter.pass("Link TV", "Link TV Message ScanQRCode is not displayed, Message :- " + strText3);
							}
							if(isElementDisplayed(TVCodeEntryBox))
							{
								Reporter.pass("Link TV", "Link TV Code Entry Box is displayed");
							}
							else
							{
								Reporter.fail("Link TV", "Link TV Code Entry Box is not displayed");
							}
							if(isElementDisplayed(LinkButton))
							{
								Reporter.pass("Link TV", "Link TV Code Entry Box  Link Buttonn is displayed");
							}
							else
							{
								Reporter.fail("Link TV", "Link TV Code Entry Box Link Button is not displayed");
							}*/
							click(backbutton,"Back Button");
							click(backbutton,"Back Button");
						}
						else
						{
							Reporter.fail("Link TV", "Link TV Enter TV Code is not displayed");
						}
						
					}
					else
					{
						Reporter.fail("Link TV", "Link TV Button is not displayed");
					}
				}
				else
				{
					Reporter.fail("Link TV", "Link TV is not displayed");	
				}
				
			}
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			blnFound=false;
		}
		return blnFound;
	}
	
	/***
	 * Function Name :- fnVerifyLinkTVScanQRCode
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public  boolean fnVerifyLinkTVScanQRCode(boolean blnUserType) throws Throwable
	{
		Reporter.info("HOOQ IOS","Verifying Verify LinkTV Scan QR Code");
		boolean blnFound=true;
		try{
			mePage.fnSelectME();
			if(blnUserType)
			{
				if(isElementDisplayed(LinkTV)==false){
					Reporter.fail("Link TV", "Link TV is displayed");
				} else{
					Reporter.pass("Link TV", "Link TV is not displayed");
				}
			}
			else
			{
				if(isElementDisplayed(LinkTV))
				{
					click(LinkTV,"Link TV");
					Thread.sleep(5000);
					if(isElementDisplayed(linkTVHeaderTitle))
					{
						Reporter.pass("Link TV", "Link TV Header is displayed");
					}
					else
					{
						Reporter.fail("Link TV", "Link TV Header is not displayed");
					}
					/*if(isElementDisplayed(logoMobileLinkTV))
					{
						Reporter.pass("Link TV", "Link TV Logo is displayed");
					}
					else
					{
						Reporter.fail("Link TV", "Link TV Logo is  not displayed");
					}*/
					String strText1=getText(linkTVMessage1,"Link TV Message 1");
					String strText2=getText(linkTVMessage2,"Link TV Message 2");
					if(strText1.contains("Launch "))
					{
						Reporter.pass("Link TV", "Link TV Message 1 is displayed , Message :- " + strText1);
					}
					else
					{
						Reporter.fail("Link TV", "Link TV Message 1 is not displayed, Message :- " + strText1);
					}
					if(strText2.contains("Using your mobile "))
					{
						Reporter.pass("Link TV", "Link TV Message 2 is displayed , Message :- " + strText2);
					}
					else
					{
						Reporter.fail("Link TV", "Link TV Message 2 is not displayed, Message :- " + strText2);
					}
					if(isElementDisplayed(LinkTVButton))
					{
						Reporter.pass("Link TV", "Link TV Button is displayed");
						click(LinkTVButton,"LinkTV Button");
						List<WebElement> element=driver.findElements(By.name("OK"));
						if(element.size()>0)
						{
							element.get(0).click();
						}
						Thread.sleep(5000);
						if(isElementDisplayed(linkTVHeaderTitle))
						{
							Reporter.pass("Link TV", "Link TV Header is displayed");
						}
						else
						{
							Reporter.fail("Link TV", "Link TV Header is not displayed");
						}
						if(isElementDisplayed(ScanQRCode))
						{
							Reporter.pass("Link TV", "Link TV ScanQRCode is displayed");
							click(ScanQRCode,"Scan QR Code");
						/*	String strText3=getText(ScanMessage,"Link TV Message ScanQRCode");
							if(strText3.contains("Scan the QR"))
							{
								Reporter.pass("Link TV", "Link TV Message ScanQRCode is displayed, Message :- " + strText3);
							}
							else
							{
								Reporter.fail("Link TV", "Link TV Message ScanQRCode is not displayed, Message :- " + strText3);
							}
							if(isElementDisplayed(qrcode_box_mobile))
							{
								Reporter.pass("Link TV", "Link TV QR Scan Box is displayed");
							}
							else
							{
								Reporter.fail("Link TV", "Link TV QR Scan Box is not displayed");
							}*/
						}
						else
						{
							Reporter.fail("Link TV", "Link TV ScanQRCode is not displayed");
						}
					}
					else
					{
						Reporter.fail("Link TV", "Link TV Button is not displayed");
					}
				}
				else
				{
					Reporter.fail("Link TV", "Link TV is not displayed");	
				}
				
			}
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			blnFound=false;
		}
		return blnFound;
	}
	
	/***
	 * Function Name :- fnVerifyLinkTVEnterTVCode
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public  boolean fnVerifyLinkTVEnterTVCode(boolean blnUserType) throws Throwable
	{
		Reporter.info("HOOQ IOS","Verifying Verify LinkTV Enter TV Code");
		boolean blnFound=true;
		try{
			mePage.fnSelectME();
			if(blnUserType)
			{
				if(isElementDisplayed(LinkTV)==false){
					Reporter.fail("Link TV", "Link TV is displayed");
				} else{
					Reporter.pass("Link TV", "Link TV is not displayed");
				}
			}
			else
			{
				if(isElementDisplayed(LinkTV))
				{
					click(LinkTV,"Link TV");
					Thread.sleep(5000);
					if(isElementDisplayed(linkTVHeaderTitle))
					{
						Reporter.pass("Link TV", "Link TV Header is displayed");
					}
					else
					{
						Reporter.fail("Link TV", "Link TV Header is not displayed");
					}
					/*if(isElementDisplayed(logoMobileLinkTV))
					{
						Reporter.pass("Link TV", "Link TV Logo is displayed");
					}
					else
					{
						Reporter.fail("Link TV", "Link TV Logo is  not displayed");
					}*/
					String strText1=getText(linkTVMessage1,"Link TV Message 1");
					String strText2=getText(linkTVMessage2,"Link TV Message 2");
					if(strText1.contains("Launch "))
					{
						Reporter.pass("Link TV", "Link TV Message 1 is displayed , Message :- " + strText1);
					}
					else
					{
						Reporter.fail("Link TV", "Link TV Message 1 is not displayed, Message :- " + strText1);
					}
					if(strText2.contains("Using your mobile "))
					{
						Reporter.pass("Link TV", "Link TV Message 2 is displayed , Message :- " + strText2);
					}
					else
					{
						Reporter.fail("Link TV", "Link TV Message 2 is not displayed, Message :- " + strText2);
					}
					if(isElementDisplayed(LinkTVButton))
					{
						Reporter.pass("Link TV", "Link TV Button is displayed");
						click(LinkTVButton,"LinkTV Button");
						List<WebElement> element=driver.findElements(By.name("OK"));
						if(element.size()>0)
						{
							element.get(0).click();
						}
						Thread.sleep(5000);
						if(isElementDisplayed(linkTVHeaderTitle))
						{
							Reporter.pass("Link TV", "Link TV Header is displayed");
						}
						else
						{
							Reporter.fail("Link TV", "Link TV Header is not displayed");
						}
						if(isElementDisplayed(EnterTVCode))
						{
							Reporter.pass("Link TV", "Link TV Enter TV Code is displayed");
							click(EnterTVCode,"Enter TV Code");
							Thread.sleep(5000);
						/*	String strText3=getText(ScanMessage,"Link TV Message ScanQRCode");
							if(strText3.contains("Please enter the 6"))
							{
								Reporter.pass("Link TV", "Link TV Message ScanQRCode is displayed, Message :- " + strText3);
							}
							else
							{
								Reporter.pass("Link TV", "Link TV Message ScanQRCode is not displayed, Message :- " + strText3);
							}
							if(isElementDisplayed(TVCodeEntryBox))
							{
								Reporter.pass("Link TV", "Link TV Code Entry Box is displayed");
							}
							else
							{
								Reporter.fail("Link TV", "Link TV Code Entry Box is not displayed");
							}
							if(isElementDisplayed(LinkButton))
							{
								Reporter.pass("Link TV", "Link TV Code Entry Box  Link Buttonn is displayed");
							}
							else
							{
								Reporter.fail("Link TV", "Link TV Code Entry Box Link Button is not displayed");
							}*/
							click(backbutton,"Back Button");
							click(backbutton,"Back Button");
						}
						else
						{
							Reporter.fail("Link TV", "Link TV Enter TV Code is not displayed");
						}
						
					}
					else
					{
						Reporter.fail("Link TV", "Link TV Button is not displayed");
					}
				}
				else
				{
					Reporter.fail("Link TV", "Link TV is not displayed");	
				}
				
			}
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			blnFound=false;
		}
		return blnFound;
	}
	
	
}
