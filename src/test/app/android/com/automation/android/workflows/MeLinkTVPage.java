package com.automation.android.workflows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.reports.Reporter;

public class MeLinkTVPage extends BasePage{
	//Locators
	By linkTopLayout=By.id("tv.hooq.android:id/appBarLayout");
	By linkTVTitle=By.id("tv.hooq.android:id/toolbarTitle");
	By linkTVCont=By.id("tv.hooq.android:id/scroll_container");
	By btnlinkTV=By.id("tv.hooq.android:id/btn_link");
	By btnAllow=By.id("com.android.packageinstaller:id/permission_allow_button");
	By qrCodeTab=By.id("tv.hooq.android:id/scan_qr_code");
	By qrCodeInfo=By.id("tv.hooq.android:id/instruction");
	By qrCodeImg=By.id("tv.hooq.android:id/scanner_container");
	By enterTvCodeTab=By.id("tv.hooq.android:id/enterTvCode");
	By pinTbl=By.id("tv.hooq.android:id/pincode");
	By Linktbl=By.id("tv.hooq.android:id/container");
	
	public boolean fnVerifyLinkTV(boolean blnUserType,boolean blnQRCode,boolean blnTVCode) throws Throwable {
		Reporter.info("HOOQ IOS","Verifying Verify LinkTV");
		boolean blnFound=true;
		try{
			Reporter.info("HOOQ Link TV Screen","Verifying Link TV Screen");
			//Go to Me Section
			mePage.fnSelectMESection("linktv");
			if(blnUserType)
			{
				
			}
			else
			{
				String strHeader=driver.findElement(linkTopLayout).findElement(linkTVTitle).getText();
				System.out.println(strHeader);
				if(strHeader.toLowerCase().contains("link tv"))
				{
					Reporter.pass("Link TV Screen", "Link TV Section is displayed");
				}
				else
				{
					Reporter.fail("Link TV Screen", "Link TV Section is not displayed");
				}
				List<WebElement> eleLinkTbl=driver.findElements(linkTVCont);
				if(eleLinkTbl.size()>0)
				{
					List<WebElement> eleLogo=eleLinkTbl.get(0).findElements(By.className("android.widget.ImageView"));
					if(eleLogo.size()>0)
					{
						Reporter.pass("Link TV Screen", "Link TV Logo is displayed");
					}
					else
					{
						Reporter.fail("Link TV Screen", "Link TV Logo is not displayed");
					}
					List<WebElement> eleDetails=eleLinkTbl.get(0).findElements(By.className("android.widget.LinearLayout"));
					List<WebElement> infoDet=eleDetails.get(0).findElements(By.className("android.widget.TextView"));
					String strDet1=infoDet.get(0).getText();
					String strDet2=infoDet.get(1).getText();
					List<WebElement> infoDet2=eleDetails.get(1).findElements(By.className("android.widget.TextView"));
					String strDet3=infoDet2.get(0).getText();
					String strDet4=infoDet2.get(1).getText();
					if(strDet1.contains("1."))
					{
						if(strDet2.contains("Launch the HOOQ app on your TV."))
						{
							Reporter.pass("Link TV Screen", "Link TV Info : " + strDet1 + " "+ strDet2+" is displayed");
						}
						else
						{
							Reporter.fail("Link TV Screen", "Link TV Info Line 1 is not displayed");
						}
					}
					else
					{
						Reporter.fail("Link TV Screen", "Link TV info Line 1 is not displayed");
					}
					if(strDet3.contains("2."))
					{
						if(strDet4.contains("Using your mobile or tablet, scan the QR code or enter the TV code shown on your TV screen."))
						{
							Reporter.pass("Link TV Screen", "Link TV Info : " + strDet3 + " "+ strDet4+" is displayed");
						}
						else
						{
							Reporter.fail("Link TV Screen", "Link TV Info Line 2 is not displayed");
						}
					}
					else
					{
						Reporter.fail("Link TV Screen", "Link TV info Line 2 is not displayed");
					}
				}
				if(isElementDisplayed(btnlinkTV))
				{
					Reporter.pass("Link TV Screen", "Link TV Button is displayed");
				}
				else
				{
					Reporter.fail("Link TV Screen", "Link TV Button is not displayed");
				}
				if(blnQRCode)
				{
					click(btnlinkTV,"Link Tv Code");
					fnAllowAccess();
					if(fnVerifyQRCodeScreen())
					{
						Reporter.pass("Link TV Screen", "Link TV Scan QR Code is displayed");
					}
					else
					{
						Reporter.fail("Link TV Screen", "Link TV Scan QR Code is not displayed");
					}
					driver.navigate().back();
				}
				if(blnTVCode)
				{
					click(btnlinkTV,"Link Tv Code");
					fnAllowAccess();
					if(fnVerifyEnterTVCodeScreen())
					{
						Reporter.pass("Link TV Screen", "Link TV Enter TV Code is displayed");
					}
					else
					{
						Reporter.fail("Link TV Screen", "Link TV Enter TV Code is not displayed");
					}
					driver.navigate().back();
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

	public boolean fnAllowAccess()
	{
		boolean blnStatus=true;
		try
		{
			List<WebElement> eleList=driver.findElements(btnAllow);
			if(eleList.size()>0)
			{
				eleList.get(0).click();
				Thread.sleep(5000);
			}
		}
		catch(Exception e){blnStatus=false;}
		return blnStatus;
	}

	public boolean fnVerifyQRCodeScreen() throws Throwable
	{
		boolean blnStatus=true;
		Reporter.info("HOOQ Link TV Screen","Verifying Link TV QR Code Screen");
		try
		{
			String strTextTab=getText(qrCodeTab,"Scan QR Code Tab");
			if(strTextTab.contains("Scan QR Code"))
			{
				Reporter.pass("Link TV Screen", "Link TV Section Scan QR Code is displayed");
			}
			else
			{
				Reporter.fail("Link TV Screen", "Link TV Section Scan QR Code is not displayed");
			}
			List<WebElement> eleList=driver.findElement(qrCodeInfo).findElements(By.className("android.widget.TextView"));
			String strInfo=eleList.get(0).getText();
			if(strInfo.contains("Scan the QR code displayed on your TV to link it with your account."))
			{
				Reporter.pass("Link TV Screen", "Link TV Section info Scan the QR code displayed on your TV to link it with your account. is displayed");
			}
			else
			{
				Reporter.fail("Link TV Screen", "Link TV Section info Scan the QR code displayed on your TV to link it with your account. is not displayed");
			}
			if(isElementDisplayed(qrCodeImg))
			{
				Reporter.pass("Link TV Screen", "Link TV Section Scan QR Code Scanner Container is displayed");
			}
			else
			{
				Reporter.fail("Link TV Screen", "Link TV Section Scan QR Code Scanner Container is not displayed");
			}
			
		}
		catch(Exception e){blnStatus=false;}
		return blnStatus;
	}
	public boolean fnVerifyEnterTVCodeScreen() throws Throwable
	{
		boolean blnStatus=true;
		Reporter.info("HOOQ Link TV Screen","Verifying Link TV Enter TV Code Screen");
		try
		{
			click(enterTvCodeTab,"Enter TV Code");
			Thread.sleep(10000);
			String strTextTab=getText(enterTvCodeTab,"Enter TV Code Tab");
			if(strTextTab.contains("Enter TV Code"))
			{
				Reporter.pass("Link TV Screen", "Link TV Section Enter TV Code is displayed");
			}
			else
			{
				Reporter.fail("Link TV Screen", "Link TV Section Enter TV Code is not displayed");
			}
			List<WebElement> eleList=driver.findElement(qrCodeInfo).findElements(By.className("android.widget.TextView"));
			String strInfo=eleList.get(0).getText();
			if(strInfo.contains("Please enter the 6 digit code displayed on your TV to link it with your account."))
			{
				Reporter.pass("Link TV Screen", "Link TV Section info Please enter the 6 digit code displayed on your TV to link it with your account. is displayed");
			}
			else
			{
				Reporter.fail("Link TV Screen", "Link TV Section info Please enter the 6 digit code displayed on your TV to link it with your account. is not displayed");
			}
			if(isElementDisplayed(btnlinkTV))
			{
				String strText=getText(btnlinkTV,"Link TV Button");
				if(strText.contains("Link"))
				{
					Reporter.pass("Link TV Screen", "Link TV Section Link TV Button is displayed");
				}
				else
				{
					Reporter.fail("Link TV Screen", "Link TV Section Link TV Button is not displayed");
				}
			}
			else
			{
				Reporter.fail("Link TV Screen", "Link TV Section Link TV Button is not displayed");
			}
			if(isElementDisplayed(pinTbl))
			{
				List<WebElement> eleListPin=driver.findElement(pinTbl).findElements(By.className("android.widget.TextView"));
				if(eleListPin.size()>0)
				{
					Reporter.pass("Link TV Screen", "Link TV Section Enter Pin is displayed");
					Reporter.info("Link TV Screen", "Link TV Section Entered Pin");
					String strCode="asdert";
					eleListPin.get(0).sendKeys(strCode);
					Reporter.info("Link TV Screen", "Link TV Section Entered Pin Verify");
					
					for(int i=0;i<eleListPin.size();i++)
					{
						String strTxt=eleListPin.get(i).getText();
						if(strTxt.contains(String.valueOf(strCode.charAt(i))))
						{
							Reporter.pass("Link TV Screen", "Link TV Section Enter Pin Text " + strTxt+ " is displayed");
						}
						else
						{
							Reporter.fail("Link TV Screen", "Link TV Section Enter Pin Text " + strTxt+ " is not displayed");
						}
					}
					List<WebElement> eleLink=driver.findElements(Linktbl);
					System.out.println(eleLink.size());
					List<WebElement> eleBtn=eleLink.get(0).findElements(btnlinkTV);
					System.out.println(eleBtn.size());
					eleBtn.get(0).click();
					Thread.sleep(5000);
					Reporter.info("Link TV Screen", "Link TV Section Entered Pin Verify After LInk Wrong Code");
					for(int i=0;i<eleListPin.size();i++)
					{
						String strTxt=eleListPin.get(i).getText();
						if(strTxt.length()>0)
						{
							Reporter.fail("Link TV Screen", "Link TV Section Enter Pin Text Empty is displayed");
						}
						else
						{
							Reporter.pass("Link TV Screen", "Link TV Section Enter Pin Text is Empty is displayed");
						}
					}
				}
				else
				{
					Reporter.fail("Link TV Screen", "Link TV Section Enter Pin is not displayed");
				}
			}
			
		}
		catch(Exception e){blnStatus=false;}
		return blnStatus;
	}
}
