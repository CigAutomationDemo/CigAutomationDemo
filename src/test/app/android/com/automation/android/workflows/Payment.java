package com.automation.android.workflows;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.googledrive.GoogleDriveAPI;
import com.automation.reports.Reporter;
import com.automation.utilities.CreditCardNumberGenerator;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import io.appium.java_client.AppiumDriver;

public class Payment extends BasePage{
	public String strPlatForm;
	public String strType;
	public String strPlanType;
	public String strPlanMethod;
	public String strCountry;
	public String strPrice;
	By subscribeNow=By.id("tv.hooq.android:id/manage");
	By alertTitle=By.id("android:id/alertTitle");
	By alertText1=By.id("android:id/message");
	By alertleaveThisPage=By.id("android:id/button1");
	By alertStayThisPage=By.id("android:id/button2");
	By seeMore=By.xpath(".//android.view.View[@text='See More Plans']");
	By contentMovieName=By.id("tv.hooq.android:id/txtAssetTitle");
	 By rentPageWatchNow=By.id("tv.hooq.android:id/txtTvodRedeem");
	
	public List<Payment> fnGetPlanTypeInfo(String strPlatform,String strType) throws IOException
	{
		Sheets service = GoogleDriveAPI.getSheetsService();
		List<Payment> arrData=new ArrayList<Payment>();
		String range = "Plan"+"!B2:G30";
		System.out.println(range);
		ValueRange response = service.spreadsheets().values()
		.get(objData.SHEET_ID, range)
		.execute();
		List<List<Object>> values = response.getValues();
		System.out.println(values.size());
		if (values == null || values.size() == 0) {
		System.out.println("No data found.");
		} else {
		System.out.println("Device, ScriptName");
		for (List row : values) {
		// Print columns A and E, which correspond to indices 0 and 4.
			Payment objPayment=new Payment();
			objPayment.strPlatForm=row.get(0).toString();
			objPayment.strType=row.get(1).toString();
			objPayment.strPlanType=row.get(2).toString();
			objPayment.strPlanMethod=row.get(3).toString();
			objPayment.strCountry=row.get(4).toString();
			objPayment.strPrice=row.get(5).toString();
			if(objPayment.strPlatForm.toLowerCase().equals(strPlatform.toLowerCase()))
			{
				if(objPayment.strType.toLowerCase().equals(strType.toLowerCase()))
				{
					arrData.add(objPayment);
				}
			}			
		}
		}
	return arrData;
}
	
	public List<String> fnGetPlanType(String strPlatform,String strType) throws IOException
	{
		List<String> arrPlan=new ArrayList<String>();
		List<Payment> arrData=fnGetPlanTypeInfo(strPlatform, strType);
		for(int i=0;i<arrData.size();i++)
		{
			arrPlan=fnAddData(arrPlan,arrData.get(i).strPlanType);
		}
		return arrPlan;
	}
	
	public List<String> fnAddData(List<String> arrData,String strData)
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
	
	
	public List<Payment> fnGetPlanMethod(String strPlatform,String strType,String strPlanType) throws IOException
	{
		List<Payment> arrData=fnGetPlanTypeInfo(strPlatform, strType);
		List<Payment> arrPlanDetails=new ArrayList<Payment>();
		for(int i=0;i<arrData.size();i++)
		{
			if(arrData.get(i).strPlanType.toLowerCase().equals(strPlanType.toLowerCase()))
			{
				arrPlanDetails.add(arrData.get(i));
			}
		}
		return arrPlanDetails;
	}
	
	public boolean fnVerifySubscriptionPlanIndia() throws Throwable
	{
		boolean blnStatus=true;
		try
		{
			
			fnVerifySubscriptionPlanIndia("Monthly","Google");
			/*	boolean blnStatusYearly=fnVerifyPlanInfoSG("Monthly");
			System.out.println("Yearly" + " Plan ==> " + blnStatusYearly);
			
			fnVerifySubscriptionPlanIndia("Yearly","Credit");
			fnVerifySubscriptionPlanIndia("Yearly","amazonpay");
			fnVerifySubscriptionPlanIndia("Yearly","paytm");
			fnVerifySubscriptionPlanIndia("Yearly","google");
			fnVerifySubscriptionPlanIndia("Yearly","olamoney");
			
			
			fnVerifySubscriptionPlanIndia("Monthly","Credit");
			fnVerifySubscriptionPlanIndia("Monthly","amazonpay");
			fnVerifySubscriptionPlanIndia("Monthly","paytm");
			fnVerifySubscriptionPlanIndia("Monthly","olamoney");
			
			fnVerifySubscriptionPlanIndia("onetime","Debit");
			fnVerifySubscriptionPlanIndia("onetime","Phonebill");
		*/	//fnVerifySubscriptionPlanIndia("Yearly","amazonpay");
			//fnVerifySubscriptionPlanIndia("Yearly","paytm");
			//fnVerifySubscriptionPlanIndia("Yearly","olamoney");
			//fnVerifySubscriptionPlanIndia("Monthly","olamoney");
			
			
		}
		catch(Exception e){blnStatus=false;}
		return true;
	}
	
	
	public boolean fnVerifySubscriptionPlanSG(String srPlanType,String strPaymentMethod) throws Throwable
	{
		boolean blnStatuus=true;
		try
		{
			boolean blnStatusYearly=fnVerifyPlanInfoSG(srPlanType);
			System.out.println(srPlanType + " Plan ==> " + blnStatusYearly);
			boolean blnStatusSelectYearly=fnSelectPlaymentPlanSG(srPlanType);
			System.out.println(blnStatusSelectYearly);
			boolean blnStatusOneYearPayment=fnVerifyPlanSG(srPlanType,strPaymentMethod);
			System.out.println(blnStatusOneYearPayment);
		}
		catch(Exception e){blnStatuus=false;}
		return blnStatuus;
	}
	
	public boolean fnVerifySubscriptionPlanPH(String srPlanType,String strPaymentMethod) throws Throwable
	{
		boolean blnStatuus=true;
		try
		{
			boolean blnStatusYearly=fnVerifyPlanInfoPH(srPlanType);
			System.out.println(srPlanType + " Plan ==> " + blnStatusYearly);
			boolean blnStatusSelectYearly=fnSelectPlaymentPlanPH(srPlanType);
			System.out.println(blnStatusSelectYearly);
			boolean blnStatusOneYearPayment=fnVerifyPlanPH(srPlanType,strPaymentMethod);
			System.out.println(blnStatusOneYearPayment);
			driver.navigate().back();
			Thread.sleep(5000);
		}
		catch(Exception e){blnStatuus=false;}
		return blnStatuus;
	}
	
	public boolean fnVerifySubscriptionPlanID(String srPlanType,String strPaymentMethod) throws Throwable
	{
		boolean blnStatuus=true;
		try
		{
			boolean blnStatusYearly=fnVerifyPlanInfoID(srPlanType);
			//System.out.println(srPlanType + " Plan ==> " + blnStatusYearly);
			boolean blnStatusSelectYearly=fnSelectPlaymentPlanID(srPlanType);
			System.out.println(blnStatusSelectYearly);
			boolean blnStatusOneYearPayment=fnVerifyPlanID(srPlanType,strPaymentMethod);
			//System.out.println(blnStatusOneYearPayment);
			driver.navigate().back();
			Thread.sleep(5000);
		}
		catch(Exception e){blnStatuus=false;}
		return blnStatuus;
	}
	
	public boolean fnVerifySubscriptionPlanTH(String srPlanType,String strPaymentMethod) throws Throwable
	{
		boolean blnStatuus=true;
		try
		{
			boolean blnStatusYearly=fnVerifyPlanInfoTH(srPlanType);
			System.out.println(srPlanType + " Plan ==> " + blnStatusYearly);
			boolean blnStatusSelectYearly=fnSelectPlaymentPlanTH(srPlanType);
			System.out.println(blnStatusSelectYearly);
			boolean blnStatusOneYearPayment=fnVerifyPlanTH(srPlanType,strPaymentMethod);
			System.out.println(blnStatusOneYearPayment);
			driver.navigate().back();
			Thread.sleep(5000);
		}
		catch(Exception e){blnStatuus=false;}
		return blnStatuus;
	}
	
	
	
	public boolean fnVerifySubscriptionPlanIndia(String srPlanType,String strPaymentMethod) throws Throwable
	{
		boolean blnStatuus=true;
		try
		{
			boolean blnStatusYearly=fnVerifyPlanInfoIndia(srPlanType);
			System.out.println(srPlanType + " Plan ==> " + blnStatusYearly);
			boolean blnStatusSelectYearly=fnSelectPlaymentPlanIndia(srPlanType);
			System.out.println(blnStatusSelectYearly);
			boolean blnStatusOneYearPayment=fnVerifyPlanIndia(srPlanType,strPaymentMethod);
			System.out.println(blnStatusOneYearPayment);
		}
		catch(Exception e){blnStatuus=false;}
		return blnStatuus;
	}
	
	
	public boolean fnSelectPlaymentPlanIndia(String strPaymentethod) throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		try
		{
			int intCount=0;
			if(strPaymentethod.toLowerCase().contains("onetime"))
			{
				intCount=14;
			}
			else if(strPaymentethod.toLowerCase().contains("monthly"))
			{
				intCount=8;
			}
			if(strPaymentethod.toLowerCase().contains("yearly")==false)
			{
				for(int i=0;i<4;i++)
				{
					swipeUpOrBottom(true);
				}
			}
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<WebElement> elePaymentList=elePayment1.get(0).findElements(By.className("android.widget.ListView"));
			System.out.println(elePaymentList.size());
			List<WebElement> eleViewPayment=elePaymentList.get(0).findElements(By.className("android.view.View"));
			System.out.println(eleViewPayment.size());
			List<WebElement> eleViewTest=eleViewPayment.get(intCount).findElements(By.className("android.view.View"));
			List<WebElement> elePaymentText=eleViewTest.get(0).findElements(By.className("android.view.View"));
			System.out.println(elePaymentText.size());
			if(elePaymentText.size()>0)
			{
				elePaymentText.get(0).click();
				Thread.sleep(10000);
			}
			else
			{
				Reporter.blnReportTempStatus=false;
			}
			}
		catch(Exception e){Reporter.blnReportTempStatus=false;}
		return Reporter.blnReportTempStatus;
	}
	
	
	public boolean fnSelectPlaymentPlanID(String strPaymentethod) throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		try
		{
			int intCount=0;
			if(strPaymentethod.toLowerCase().equals("Berlangganan VIP 1 Tahun".toLowerCase()))
			{
				intCount=4;
			}		
			else if(strPaymentethod.toLowerCase().equals("1 Bulan Akses VIP".toLowerCase()))
			{
				intCount=14;
			}
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<WebElement> elePaymentList=elePayment1.get(0).findElements(By.className("android.widget.ListView"));
			System.out.println(elePaymentList.size());
			List<WebElement> eleViewPayment=elePaymentList.get(0).findElements(By.className("android.view.View"));
			System.out.println(eleViewPayment.size());
			List<WebElement> eleViewTest=eleViewPayment.get(intCount).findElements(By.className("android.view.View"));
			List<WebElement> elePaymentText=eleViewTest.get(0).findElements(By.className("android.view.View"));
			System.out.println(elePaymentText.size());
			if(elePaymentText.size()>0)
			{
				elePaymentText.get(0).click();
				Thread.sleep(10000);
			}
			else
			{
				Reporter.blnReportTempStatus=false;
			}
			}
		catch(Exception e){Reporter.blnReportTempStatus=false;}
		return Reporter.blnReportTempStatus;
	}
	
	public boolean fnSelectPlaymentPlanTH(String strPaymentethod) throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		try
		{
			int intCount=0;
			if(strPaymentethod.toLowerCase().equals("1 Year".toLowerCase()))
			{
				intCount=4;
			}		
			else if(strPaymentethod.toLowerCase().equals("Weekly".toLowerCase()))
			{
				intCount=14;
				swipeUpOrBottom(true);
			}
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<WebElement> elePaymentList=elePayment1.get(0).findElements(By.className("android.widget.ListView"));
			System.out.println(elePaymentList.size());
			List<WebElement> eleViewPayment=elePaymentList.get(0).findElements(By.className("android.view.View"));
			System.out.println(eleViewPayment.size());
			List<WebElement> eleViewTest=eleViewPayment.get(intCount).findElements(By.className("android.view.View"));
			List<WebElement> elePaymentText=eleViewTest.get(0).findElements(By.className("android.view.View"));
			System.out.println(elePaymentText.size());
			if(elePaymentText.size()>0)
			{
				elePaymentText.get(0).click();
				Thread.sleep(10000);
			}
			else
			{
				Reporter.blnReportTempStatus=false;
			}
			}
		catch(Exception e){Reporter.blnReportTempStatus=false;}
		return Reporter.blnReportTempStatus;
	}
	
	
	public boolean fnSelectPlaymentPlanPH(String strPaymentethod) throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		try
		{
			int intCount=0;
			if(strPaymentethod.toLowerCase().equals("yearly"))
			{
				intCount=4;
			}		
			else if(strPaymentethod.toLowerCase().equals("one time monthly"))
			{
				intCount=14;
			}
			else if(strPaymentethod.toLowerCase().contains("weekly vip"))
			{
				intCount=20;
				for(int i=0;i<4;i++)
				{
					swipeUpOrBottom(true);
				}
			}	
			else if(strPaymentethod.toLowerCase().equals("1 day"))
			{
				intCount=26;
				for(int i=0;i<4;i++)
				{
					swipeUpOrBottom(true);
				}
			}
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<WebElement> elePaymentList=elePayment1.get(0).findElements(By.className("android.widget.ListView"));
			System.out.println(elePaymentList.size());
			List<WebElement> eleViewPayment=elePaymentList.get(0).findElements(By.className("android.view.View"));
			System.out.println(eleViewPayment.size());
			List<WebElement> eleViewTest=eleViewPayment.get(intCount).findElements(By.className("android.view.View"));
			List<WebElement> elePaymentText=eleViewTest.get(0).findElements(By.className("android.view.View"));
			System.out.println(elePaymentText.size());
			if(elePaymentText.size()>0)
			{
				elePaymentText.get(0).click();
				Thread.sleep(10000);
			}
			else
			{
				Reporter.blnReportTempStatus=false;
			}
			}
		catch(Exception e){Reporter.blnReportTempStatus=false;}
		return Reporter.blnReportTempStatus;
	}
	
	public boolean fnSelectPlaymentPlanSG(String strPaymentethod) throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		try
		{
			int intCount=0;
			if(strPaymentethod.toLowerCase().contains("yearly"))
			{
				intCount=4;
			}
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<WebElement> elePaymentList=elePayment1.get(0).findElements(By.className("android.widget.ListView"));
			System.out.println(elePaymentList.size());
			List<WebElement> eleViewPayment=elePaymentList.get(0).findElements(By.className("android.view.View"));
			System.out.println(eleViewPayment.size());
			List<WebElement> eleViewTest=eleViewPayment.get(intCount).findElements(By.className("android.view.View"));
			List<WebElement> elePaymentText=eleViewTest.get(0).findElements(By.className("android.view.View"));
			System.out.println(elePaymentText.size());
			if(elePaymentText.size()>0)
			{
				elePaymentText.get(0).click();
				Thread.sleep(10000);
			}
			else
			{
				Reporter.blnReportTempStatus=false;
			}
			}
		catch(Exception e){Reporter.blnReportTempStatus=false;}
		return Reporter.blnReportTempStatus;
	}
	
	
	public boolean fnVerifyPlanInfoIndia(String strPaymentethod) throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		mePage.fnSelectMESection("subscription");
		click(subscribeNow,"Subscribe Now");
		Thread.sleep(10000);
		List<String> arrPlan=new ArrayList<String>();
		List<Payment> objPayment=null;
		Reporter.info("Subscription Info Verification" , "Verify Subscription Info for " + strPaymentethod);
		try
		{
			int intCount=0;
			if(strPaymentethod.toLowerCase().contains("yearly"))
			{
				objPayment=fnGetPlanMethod("Android", "Subscription","1 Year");				
			}
			else if(strPaymentethod.toLowerCase().contains("onetime"))
			{
				objPayment=fnGetPlanMethod("Android", "Subscription","OneTime");		
				intCount=14;
			}
			else if(strPaymentethod.toLowerCase().contains("monthly"))
			{
				objPayment=fnGetPlanMethod("Android", "Subscription","Monthly");		
				intCount=8;
			}
			if(strPaymentethod.toLowerCase().contains("yearly")==false)
			{
				for(int i=0;i<4;i++)
				{
					swipeUpOrBottom(true);
				}
			}
			for(int i=0;i<objPayment.size();i++)
			{
				System.out.println(objPayment.get(i).strPlanMethod);
				arrPlan=fnAddData(arrPlan,objPayment.get(i).strPlanMethod);
			}
			String strCurrency=objPayment.get(0).strCountry;
			String strAmount=objPayment.get(0).strPrice;
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<WebElement> elePaymentList=elePayment1.get(0).findElements(By.className("android.widget.ListView"));
			System.out.println(elePaymentList.size());
			List<WebElement> eleViewPayment=elePaymentList.get(0).findElements(By.className("android.view.View"));
			System.out.println(eleViewPayment.size());
			List<WebElement> eleViewTest=eleViewPayment.get(intCount).findElements(By.className("android.view.View"));
			List<WebElement> elePaymentText=eleViewTest.get(0).findElements(By.className("android.view.View"));
			System.out.println(elePaymentText.size());
			List<String> arrPayment=new ArrayList<String>();
			for(int j=0;j<elePaymentText.size();j++)
			{
				System.out.println(elePaymentText.get(j).getText());
				String strText=elePaymentText.get(j).getText();
				if(strText.length()>0)
				{
					arrPayment=fnAddData(arrPayment,strText);
				}
			}
			if(strPaymentethod.toLowerCase().contains("yearly"))
			{
				String strVerifyText="1 Year VIP Subscription";
				if(arrPayment.get(0).toLowerCase().contains(strVerifyText.toLowerCase()))
				{
					Reporter.pass("Subscription Info for 1 Year", "Info :- 1 Year VIP Subscription is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for 1 Year", "Info :- 1 Year VIP Subscription is not displayed");
				}
				if(arrPayment.get(1).toLowerCase().contains(strCurrency.toLowerCase())&&arrPayment.get(1).toLowerCase().contains(strAmount.toLowerCase()))
				{
					Reporter.pass("Subscription Info for 1 Year", "Info :-  " + strCurrency+" " +strAmount+" is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for 1 Year", "Info :-  " + strCurrency+" " +strAmount+" is not displayed");
				}
				strVerifyText="Enjoy more than INR 600 in annual savings!";
				if(arrPayment.get(2).toLowerCase().contains(strVerifyText.toLowerCase()))
				{
					Reporter.pass("Subscription Info for 1 Year", "Info :- Enjoy more than INR 600 in annual savings! is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for 1 Year", "Info :- Enjoy more than INR 600 in annual savings! is not displayed");
				}
				strVerifyText="Includes 1 blockbuster movie rental ticket every month";
				if(arrPayment.get(3).toLowerCase().contains(strVerifyText.toLowerCase()))
				{
					Reporter.pass("Subscription Info for 1 Year", "Info :- Includes 1 blockbuster movie rental ticket every month is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for 1 Year", "Info :- Includes 1 blockbuster movie rental ticket every month is not displayed");
				}
				strVerifyText="Watch on 5 different devices";
				if(arrPayment.get(4).toLowerCase().contains(strVerifyText.toLowerCase()))
				{
					Reporter.pass("Subscription Info for 1 Year", "Info :- Watch on 5 different devices is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for 1 Year", "Info :- Watch on 5 different devices is not displayed");
				}
				strVerifyText="Pay with:";
				if(arrPayment.get(5).toLowerCase().contains(strVerifyText.toLowerCase()))
				{
					Reporter.pass("Subscription Info for 1 Year", "Info :- Pay with: is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for 1 Year", "Info :- Pay with: is not displayed");
				}
			}
			else if(strPaymentethod.toLowerCase().contains("monthly"))
			{
				String strVerifyText="Monthly VIP Subscription";
				if(arrPayment.get(0).toLowerCase().contains(strVerifyText.toLowerCase()))
				{
					Reporter.pass("Subscription Info for Monthly", "Info :- Monthly VIP Subscription");
				}
				else
				{
					Reporter.fail("Subscription Info for Monthly", "Info :- Monthly VIP Subscription is not displayed");
				}
			
				if(arrPayment.get(1).toLowerCase().contains(strCurrency.toLowerCase())&&arrPayment.get(1).toLowerCase().contains(strAmount.toLowerCase()))
				{
					Reporter.pass("Subscription Info for Monthly", "Info :-  " + strCurrency+" " +strAmount+" is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for Monthly", "Info :-  " + strCurrency+" " +strAmount+" is not displayed");
				}
				strVerifyText="First 90 days for INR 89 only - Less than 1 rupee a day";
				if(arrPayment.get(2).toLowerCase().contains(strVerifyText.toLowerCase()))
				{
					Reporter.pass("Subscription Info for Monthly", "Info :- First 90 days for INR 89 only - Less than 1 rupee a day is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for Monthly", "Info :- First 90 days for INR 89 only - Less than 1 rupee a day is not displayed");
				}
				strVerifyText="INR 89 only every month after the 3-month special offer";
				if(arrPayment.get(3).toLowerCase().contains(strVerifyText.toLowerCase()))
				{
					Reporter.pass("Subscription Info for Monthly", "Info :- INR 89 only every month after the 3-month special offer is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for Monthly", "Info :- INR 89 only every month after the 3-month special offer is not displayed");
				}
				strVerifyText="Includes 1 blockbuster movie rental ticket every month";
				if(arrPayment.get(4).toLowerCase().contains(strVerifyText.toLowerCase()))
				{
					Reporter.pass("Subscription Info for Monthly", "Info :- Includes 1 blockbuster movie rental ticket every month is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for Monthly", "Info :- Includes 1 blockbuster movie rental ticket every month is not displayed");
				}
				strVerifyText="Pay with:";
				if(arrPayment.get(5).toLowerCase().contains(strVerifyText.toLowerCase()))
				{
					Reporter.pass("Subscription Info for Monthly", "Info :- Pay with: is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for Monthly", "Info :- Pay with: is not displayed");
				}
			}
			else if(strPaymentethod.toLowerCase().contains("onetime"))
			{
				String strVerifyText="1 Month, One Time VIP Pass";
				System.out.println(arrPayment.get(0).toLowerCase());
				if(arrPayment.get(0).toLowerCase().contains(strVerifyText.toLowerCase()))
				{
					Reporter.pass("Subscription Info for onetime", "Info :- 1 Month, One Time VIP Pass");
				}
				else
				{
					Reporter.fail("Subscription Info for onetime", "Info :- 1 Month, One Time VIP Pass is not displayed");
				}
			
				if(arrPayment.get(1).toLowerCase().contains(strCurrency.toLowerCase())&&arrPayment.get(1).toLowerCase().contains(strAmount.toLowerCase()))
				{
					Reporter.pass("Subscription Info for onetime", "Info :-  " + strCurrency+" " +strAmount+" is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for onetime", "Info :-  " + strCurrency+" " +strAmount+" is not displayed");
				}
				strVerifyText="One-time payment, top-up anytime";
				if(arrPayment.get(2).toLowerCase().contains(strVerifyText.toLowerCase()))
				{
					Reporter.pass("Subscription Info for onetime", "Info :- One-time payment, top-up anytime is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for onetime", "Info :- One-time payment, top-up anytime is not displayed");
				}
				strVerifyText="Watch on 5 different devices";
				if(arrPayment.get(3).toLowerCase().contains(strVerifyText.toLowerCase()))
				{
					Reporter.pass("Subscription Info for onetime", "Info :- Watch on 5 different devices is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for onetime", "Info :- Watch on 5 different devices is not displayed");
				}
				strVerifyText="Pay with:";
				if(arrPayment.get(4).toLowerCase().contains(strVerifyText.toLowerCase()))
				{
					Reporter.pass("Subscription Info for onetime", "Info :- Pay with: is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for onetime", "Info :- Pay with: is not displayed");
				}
			}
		}
		catch(Exception e){Reporter.blnReportTempStatus=false;}
		boolean blnPlanPaymentMethod=fnVerifyPaymentMethodIndia(strPaymentethod,arrPlan);
		if(Reporter.blnReportTempStatus && blnPlanPaymentMethod)
		{
			Reporter.blnReportTempStatus=true;
		}
		else
		{
			Reporter.blnReportTempStatus=false;
		}
		if(strPaymentethod.toLowerCase().contains("yearly")==false)
		{
			for(int i=0;i<4;i++)
			{
				swipeUpOrBottom(false);
			}
		}
		Thread.sleep(10000);
		return Reporter.blnReportTempStatus;
	}
	
	
	
	
	public boolean fnVerifyPaymentMethodIndia(String strPaymentethod,List<String> arrData)
	{
		Reporter.blnReportTempStatus=true;
		Reporter.info("Subscription Info Verification", "Verify Subscription Payment Method Info for " + strPaymentethod);
		try
		{
			int intCount=0;
			if(strPaymentethod.toLowerCase().contains("onetime"))
			{
				intCount=13;
			}
			else if(strPaymentethod.toLowerCase().contains("monthly"))
			{
				intCount=8;
			}
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<WebElement> elePaymentList=elePayment1.get(0).findElements(By.className("android.widget.ListView"));
			System.out.println(elePaymentList.size());
			List<WebElement> eleViewPayment=elePaymentList.get(0).findElements(By.className("android.view.View"));
			System.out.println(eleViewPayment.size());
			List<WebElement> eleViewTest=eleViewPayment.get(intCount).findElements(By.className("android.view.View"));
			//Find Payment Image
			List<WebElement> elePaymentMethod=eleViewTest.get(0).findElements(By.className("android.widget.Image"));
			System.out.println(elePaymentMethod.size());
			List<String> arrPayment=new ArrayList<String>();
			for(int j=0;j<elePaymentMethod.size();j++)
			{
				System.out.println(elePaymentMethod.get(j).getText());
				String strText=elePaymentMethod.get(j).getText();
				if(strText.toLowerCase().contains("icon_tick_new")==false)
				{
					arrPayment=fnAddData(arrPayment,strText);
				}
			}
			for(int i=0;i<arrData.size();i++)
			{
				System.out.println(arrPayment.get(i).toLowerCase().trim().replaceAll(" ", ""));
				System.out.println(arrData.get(i).toLowerCase().trim());
				if(arrPayment.get(i).toLowerCase().trim().replaceAll(" ", "").contains(arrData.get(i).toLowerCase().trim().replaceAll(" ", "")))
				{
					Reporter.pass("Subscription Payment Method Verification","Payment Method : " + arrData.get(i) +" is displayed");
				}
				else
				{
					Reporter.fail("Subscription Payment Method Verification","Payment Method : " + arrData.get(i) +" is not displayed");
				}
			}
			
		}
		catch(Exception e){Reporter.blnReportTempStatus=false;}
		return Reporter.blnReportTempStatus;
	}
	
	public boolean fnVerifyPlanIndia(String strPlanType,String strPaymentMethod) throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		List<String> arrPlan=new ArrayList<String>();
		List<Payment> objPayment=null;
		try
		{
			if(strPlanType.toLowerCase().contains("yearly"))
			{
				objPayment=fnGetPlanMethod("Android", "Subscription","1 Year");		
			}
			else if(strPlanType.toLowerCase().contains("monthly"))
			{
				objPayment=fnGetPlanMethod("Android", "Subscription","monthly");		
			}
			else if(strPlanType.toLowerCase().contains("onetime"))
			{
				objPayment=fnGetPlanMethod("Android", "Subscription","onetime");		
			}
			for(int i=0;i<objPayment.size();i++)
			{
				System.out.println(objPayment.get(i).strPlanMethod);
				arrPlan=fnAddData(arrPlan,objPayment.get(i).strPlanMethod);
			}
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<WebElement> elePaymentList=elePayment1.get(0).findElements(By.className("android.widget.ListView"));
			System.out.println(elePaymentList.size());
			List<WebElement> eleViewPayment=elePaymentList.get(0).findElements(By.className("android.view.View"));
			System.out.println(eleViewPayment.size());
			//Find Payment Image
			List<WebElement> elePaymentMethod=elePaymentList.get(0).findElements(By.className("android.widget.Image"));
			System.out.println(elePaymentMethod.size());
			List<String> arrPayment=new ArrayList<String>();
			for(int j=0;j<elePaymentMethod.size();j++)
			{
				System.out.println(elePaymentMethod.get(j).getText());
				String strText=elePaymentMethod.get(j).getText();
				if(strText.contains("HOOQ logo")==false)
				{
					arrPayment=fnAddData(arrPayment,strText);
				}
			}
			for(int i=0;i<arrPlan.size();i++)
			{
				System.out.println(arrPayment.get(i).toLowerCase().trim().replaceAll(" ", ""));
				System.out.println(arrPlan.get(i).toLowerCase().trim());
				if(arrPayment.get(i).toLowerCase().trim().replaceAll(" ", "").contains(arrPlan.get(i).toLowerCase().trim().replaceAll(" ", "")))
				{
					Reporter.pass("Subscription Payment Method Verification","Payment Method : " + arrPlan.get(i) +" is displayed");
				}
				else
				{
					Reporter.fail("Subscription Payment Method Verification","Payment Method : " + arrPlan.get(i) +" is not displayed");
				}
			}
			for(int j=0;j<elePaymentMethod.size();j++)
			{
				System.out.println(elePaymentMethod.get(j).getText());
				String strText=elePaymentMethod.get(j).getText();
				if(strText.toLowerCase().contains(strPaymentMethod.toLowerCase()))
				{
					elePaymentMethod.get(j).click();
					Reporter.pass("Subscription Payment Method Verification","Payment Method : " + strPaymentMethod +" is Selected");
					break;
				}
			}
			
		}
		catch(Exception e){	Reporter.blnReportTempStatus=false;}
		Thread.sleep(10000);
		if(strPaymentMethod.toLowerCase().contains("credit") && strPlanType.toLowerCase().contains("yearly"))
		{
				
			boolean blnCreditCard=fnVerifyCreditDebitCard("Credit",objPayment.get(0).strCountry,objPayment.get(0).strPrice,"Yearly","ON",true);
			System.out.println(blnCreditCard);
		}
		else if(strPaymentMethod.toLowerCase().contains("amazonpay") && strPlanType.toLowerCase().contains("yearly"))
		{
				
			boolean blnCreditCard=fnVerifyAmazonPay();
			System.out.println(blnCreditCard);
		}
		else if(strPaymentMethod.toLowerCase().contains("paytm") && strPlanType.toLowerCase().contains("yearly"))
		{
				
			boolean blnCreditCard=fnVerifyPayTM("yearly",objPayment.get(0).strPrice);
			System.out.println(blnCreditCard);
		}
		else if(strPaymentMethod.toLowerCase().contains("google") && strPlanType.toLowerCase().contains("yearly"))
		{
				
			boolean blnCreditCard=fnVerifyGooglePlay("yearly",objPayment.get(0).strPrice,objPayment.get(0).strCountry);
			System.out.println(blnCreditCard);
		}
		else if(strPaymentMethod.toLowerCase().contains("olamoney") && strPlanType.toLowerCase().contains("yearly"))
		{
				
			boolean blnCreditCard=fnVerifyOlaMoney(objPayment.get(0).strCountry,objPayment.get(0).strPrice,"Yearly","ON");
			System.out.println(blnCreditCard);
		}
		else if(strPaymentMethod.toLowerCase().contains("paytm") && strPlanType.toLowerCase().contains("monthly"))
		{
				
			boolean blnCreditCard=fnVerifyPayTM("monthly",objPayment.get(0).strPrice);
			System.out.println(blnCreditCard);
		}
		else if(strPaymentMethod.toLowerCase().contains("amazonpay") && strPlanType.toLowerCase().contains("monthly"))
		{
				
			boolean blnCreditCard=fnVerifyAmazonPay();
			System.out.println(blnCreditCard);
		}
		else if(strPaymentMethod.toLowerCase().contains("credit") && strPlanType.toLowerCase().contains("monthly"))
		{
				
			boolean blnCreditCard=fnVerifyCreditDebitCard("Credit",objPayment.get(0).strCountry,objPayment.get(0).strPrice,"Monthly","ON",true);
			System.out.println(blnCreditCard);
		}
		else if(strPaymentMethod.toLowerCase().contains("olamoney") && strPlanType.toLowerCase().contains("monthly"))
		{
				
			boolean blnCreditCard=fnVerifyOlaMoney(objPayment.get(0).strCountry,objPayment.get(0).strPrice,"Monthly","ON");
			System.out.println(blnCreditCard);
		}
		else if(strPaymentMethod.toLowerCase().contains("debit") && strPlanType.toLowerCase().contains("onetime"))
		{
				
			boolean blnCreditCard=fnVerifyCreditDebitCard("Debit",objPayment.get(0).strCountry,objPayment.get(0).strPrice,"onetime","OFF",true);
			System.out.println(blnCreditCard);
		}
		else if(strPaymentMethod.toLowerCase().contains("phonebill") && strPlanType.toLowerCase().contains("onetime"))
		{
				
			boolean blnCreditCard=fnVerifyPhoneBill(objPayment.get(0).strCountry,objPayment.get(0).strPrice,"OFF");
			System.out.println(blnCreditCard);
		}
		else if(strPaymentMethod.toLowerCase().contains("netbanking") && strPlanType.toLowerCase().contains("onetime"))
		{
				
			boolean blnCreditCard=fnVerifyNetBanking(objPayment.get(0).strCountry,objPayment.get(0).strPrice,"OFF");
			System.out.println(blnCreditCard);
		}
		return Reporter.blnReportTempStatus;
	}
	
	public boolean fnVerifyPlanPH(String strPlanType,String strPaymentMethod) throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		List<String> arrPlan=new ArrayList<String>();
		List<Payment> objPayment=null;
		try
		{
			if(strPlanType.toLowerCase().equals("monthly"))
			{
				objPayment=fnGetPlanMethod("Android", "Subscription","Monthly");				
			}
			else if(strPlanType.toLowerCase().equals("yearly"))
			{
				objPayment=fnGetPlanMethod("Android", "Subscription","1 Year");	
			}		
			else if(strPlanType.toLowerCase().equals("one time monthly"))
			{
				objPayment=fnGetPlanMethod("Android", "Subscription","One Time Monthly");	
			}
			else if(strPlanType.toLowerCase().contains("weekly vip"))
			{
				objPayment=fnGetPlanMethod("Android", "Subscription","Weekly VIP");	
			}	
			else if(strPlanType.toLowerCase().equals("1 day"))
			{
				objPayment=fnGetPlanMethod("Android", "Subscription","1 day");	
			}
			for(int i=0;i<objPayment.size();i++)
			{
				System.out.println(objPayment.get(i).strPlanMethod);
				arrPlan=fnAddData(arrPlan,objPayment.get(i).strPlanMethod);
			}
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<WebElement> elePaymentList=elePayment1.get(0).findElements(By.className("android.widget.ListView"));
			System.out.println(elePaymentList.size());
			List<WebElement> eleViewPayment=elePaymentList.get(0).findElements(By.className("android.view.View"));
			System.out.println(eleViewPayment.size());
			//Find Payment Image
			List<WebElement> elePaymentMethod=elePaymentList.get(0).findElements(By.className("android.widget.Image"));
			System.out.println(elePaymentMethod.size());
			List<String> arrPayment=new ArrayList<String>();
			for(int j=0;j<elePaymentMethod.size();j++)
			{
				System.out.println(elePaymentMethod.get(j).getText());
				String strText=elePaymentMethod.get(j).getText();
				if(strText.contains("HOOQ logo")==false)
				{
					arrPayment=fnAddData(arrPayment,strText);
				}
			}
			for(int i=0;i<arrPlan.size();i++)
			{
				System.out.println(arrPayment.get(i).toLowerCase().trim().replaceAll(" ", ""));
				System.out.println(arrPlan.get(i).toLowerCase().trim());
				if(arrPayment.get(i).toLowerCase().trim().replaceAll(" ", "").contains(arrPlan.get(i).toLowerCase().trim().replaceAll(" ", "")))
				{
					Reporter.pass("Subscription Payment Method Verification","Payment Method : " + arrPlan.get(i) +" is displayed");
				}
				else
				{
					Reporter.fail("Subscription Payment Method Verification","Payment Method : " + arrPlan.get(i) +" is not displayed");
				}
			}
			for(int j=0;j<elePaymentMethod.size();j++)
			{
				System.out.println(elePaymentMethod.get(j).getText());
				String strText=elePaymentMethod.get(j).getText();
				if(strText.toLowerCase().contains(strPaymentMethod.toLowerCase()))
				{
					elePaymentMethod.get(j).click();
					Reporter.pass("Subscription Payment Method Verification","Payment Method : " + strPaymentMethod +" is Selected");
					break;
				}
			}
		}
		catch(Exception e){	Reporter.blnReportTempStatus=false;}
		Thread.sleep(10000);
		if(strPlanType.toLowerCase().contains("monthly") && strPaymentMethod.toLowerCase().contains("credit"))
		{
				
			boolean blnCreditCard=fnVerifyCreditDebitCard("Credit",objPayment.get(0).strCountry,"0.00","monthly","ON",true);
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("monthly") && strPaymentMethod.toLowerCase().contains("smart"))
		{
			Thread.sleep(10000);	
			boolean blnCreditCard=fnVerifySmartPayment(strPlanType,objPayment.get(0).strCountry,objPayment.get(0).strPrice);
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("monthly") && strPaymentMethod.toLowerCase().contains("google"))
		{
				
			boolean blnCreditCard=fnVerifyGooglePlay(strPlanType,objPayment.get(0).strPrice,objPayment.get(0).strCountry);
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("yearly") && strPaymentMethod.toLowerCase().contains("google"))
		{
				
			boolean blnCreditCard=fnVerifyGooglePlay(strPlanType,objPayment.get(0).strPrice,objPayment.get(0).strCountry);
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("yearly") && strPaymentMethod.toLowerCase().contains("credit"))
		{
				
			boolean blnCreditCard=fnVerifyCreditDebitCard("Credit",objPayment.get(0).strCountry,objPayment.get(0).strPrice,"Yearly","ON",true);
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("one time monthly") && strPaymentMethod.toLowerCase().contains("globe"))
		{
				
			boolean blnCreditCard=fnVerifyGlobePayment(strPlanType,objPayment.get(0).strCountry,objPayment.get(0).strPrice,"OFF");
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("one time monthly") && strPaymentMethod.toLowerCase().contains("gcash"))
		{
				
			boolean blnCreditCard=fnVerifyGCashPayment(objPayment.get(0).strCountry,objPayment.get(0).strPrice);
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("one time monthly") && strPaymentMethod.toLowerCase().contains("smart"))
		{
			Thread.sleep(10000);	
			boolean blnCreditCard=fnVerifySmartPayment(strPlanType,objPayment.get(0).strCountry,objPayment.get(0).strPrice);
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("weekly vip") && strPaymentMethod.toLowerCase().contains("globe"))
		{
				
			boolean blnCreditCard=fnVerifyGlobePayment(strPlanType,objPayment.get(0).strCountry,objPayment.get(0).strPrice,"OFF");
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("weekly vip") && strPaymentMethod.toLowerCase().contains("gcash"))
		{
				
			boolean blnCreditCard=fnVerifyGCashPayment(objPayment.get(0).strCountry,objPayment.get(0).strPrice);
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("weekly vip") && strPaymentMethod.toLowerCase().contains("smart"))
		{
				
			Thread.sleep(10000);	
			boolean blnCreditCard=fnVerifySmartPayment(strPlanType,objPayment.get(0).strCountry,objPayment.get(0).strPrice);
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("weekly vip") && strPaymentMethod.toLowerCase().contains("debit"))
		{
				
			boolean blnCreditCard=fnVerifyCreditDebitCard("Debit",objPayment.get(0).strCountry,objPayment.get(0).strPrice,"weekly","OFF",true);
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("weekly vip") && strPaymentMethod.toLowerCase().contains("zgold"))
		{
			Thread.sleep(10000);	
			boolean blnCreditCard=fnVerifyZGoldPayment(objPayment.get(0).strCountry,objPayment.get(0).strPrice);
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("1 day") && strPaymentMethod.toLowerCase().contains("gcash"))
		{
				
			boolean blnCreditCard=fnVerifyGCashPayment(objPayment.get(0).strCountry,objPayment.get(0).strPrice);
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("1 day") && strPaymentMethod.toLowerCase().contains("smart"))
		{
			Thread.sleep(10000);	
			boolean blnCreditCard=fnVerifySmartPayment(strPlanType,objPayment.get(0).strCountry,objPayment.get(0).strPrice);
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("1 day") && strPaymentMethod.toLowerCase().contains("google"))
		{
				
			boolean blnCreditCard=fnVerifyGooglePlay(strPlanType,objPayment.get(0).strPrice,objPayment.get(0).strCountry);
			System.out.println(blnCreditCard);			
		}
		else if(strPlanType.toLowerCase().contains("1 day") && strPaymentMethod.toLowerCase().contains("debit"))
		{
				
			boolean blnCreditCard=fnVerifyCreditDebitCard("Debit",objPayment.get(0).strCountry,objPayment.get(0).strPrice,"1 Day","OFF",true);
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("1 day") && strPaymentMethod.toLowerCase().contains("zgold"))
		{
			Thread.sleep(10000);	
			boolean blnCreditCard=fnVerifyZGoldPayment(objPayment.get(0).strCountry,objPayment.get(0).strPrice);
			System.out.println(blnCreditCard);
		}
		return Reporter.blnReportTempStatus;
	}
	
	
	public boolean fnVerifyPlanID(String strPlanType,String strPaymentMethod) throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		List<String> arrPlan=new ArrayList<String>();
		List<Payment> objPayment=null;
		try
		{
			if(strPlanType.toLowerCase().equals("Langganan VIP Bulanan".toLowerCase()))
			{
				objPayment=fnGetPlanMethod("Android", "Subscription","Langganan VIP Bulanan");				
			}
			else if(strPlanType.toLowerCase().equals("Berlangganan VIP 1 Tahun".toLowerCase()))
			{
				objPayment=fnGetPlanMethod("Android", "Subscription","Berlangganan VIP 1 Tahun");	
			}		
			else if(strPlanType.toLowerCase().equals("1 Bulan Akses VIP".toLowerCase()))
			{
				objPayment=fnGetPlanMethod("Android", "Subscription","1 Bulan Akses VIP");	
			}
			for(int i=0;i<objPayment.size();i++)
			{
				System.out.println(objPayment.get(i).strPlanMethod);
				arrPlan=fnAddData(arrPlan,objPayment.get(i).strPlanMethod);
			}
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<WebElement> elePaymentList=elePayment1.get(0).findElements(By.className("android.widget.ListView"));
			System.out.println(elePaymentList.size());
			List<WebElement> eleViewPayment=elePaymentList.get(0).findElements(By.className("android.view.View"));
			System.out.println(eleViewPayment.size());
			//Find Payment Image
			List<WebElement> elePaymentMethod=elePaymentList.get(0).findElements(By.className("android.widget.Image"));
			System.out.println(elePaymentMethod.size());
			List<String> arrPayment=new ArrayList<String>();
			for(int j=0;j<elePaymentMethod.size();j++)
			{
				System.out.println(elePaymentMethod.get(j).getText());
				String strText=elePaymentMethod.get(j).getText();
				if(strText.contains("HOOQ logo")==false)
				{
					arrPayment=fnAddData(arrPayment,strText);
				}
			}
			for(int i=0;i<arrPlan.size();i++)
			{
				System.out.println(arrPayment.get(i).toLowerCase().trim().replaceAll(" ", ""));
				System.out.println(arrPlan.get(i).toLowerCase().trim());
				if(arrPayment.get(i).toLowerCase().trim().replaceAll(" ", "").contains(arrPlan.get(i).toLowerCase().trim().replaceAll(" ", "")))
				{
					Reporter.pass("Subscription Payment Method Verification","Payment Method : " + arrPlan.get(i) +" is displayed");
				}
				else
				{
					Reporter.fail("Subscription Payment Method Verification","Payment Method : " + arrPlan.get(i) +" is not displayed");
				}
			}
			for(int j=0;j<elePaymentMethod.size();j++)
			{
				System.out.println(elePaymentMethod.get(j).getText());
				String strText=elePaymentMethod.get(j).getText();
				if(strText.toLowerCase().contains(strPaymentMethod.toLowerCase()))
				{
					elePaymentMethod.get(j).click();
					Reporter.pass("Subscription Payment Method Verification","Payment Method : " + strPaymentMethod +" is Selected");
					break;
				}
			}
		}
		catch(Exception e){	Reporter.blnReportTempStatus=false;}
		Thread.sleep(10000);
		if(strPlanType.toLowerCase().contains("Langganan VIP Bulanan".toLowerCase()) && strPaymentMethod.toLowerCase().contains("google"))
		{
			boolean blnCreditCard=fnVerifyGooglePlay(strPlanType,objPayment.get(0).strPrice,objPayment.get(0).strCountry);
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("Langganan VIP Bulanan".toLowerCase()) && strPaymentMethod.toLowerCase().contains("credit"))
		{
				
			boolean blnCreditCard=fnVerifyCreditDebitCard("Credit",objPayment.get(0).strCountry,"0.00","Monthly","ON",true);
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("Berlangganan VIP 1 Tahun".toLowerCase()) && strPaymentMethod.toLowerCase().contains("ovo"))
		{
			Thread.sleep(10000);
			boolean blnCreditCard=fnVerifyOVOPayment("Yearly",objPayment.get(0).strCountry,objPayment.get(0).strPrice, "ON");
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("Berlangganan VIP 1 Tahun".toLowerCase()) && strPaymentMethod.toLowerCase().contains("gopay"))
		{
			Thread.sleep(10000);
			boolean blnCreditCard=fnVerifyGoPayPayment("yearly",objPayment.get(0).strCountry,objPayment.get(0).strPrice);
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("Berlangganan VIP 1 Tahun".toLowerCase()) && strPaymentMethod.toLowerCase().contains("google"))
		{
				
			boolean blnCreditCard=fnVerifyGooglePlay(strPlanType,objPayment.get(0).strPrice,objPayment.get(0).strCountry);
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("Berlangganan VIP 1 Tahun".toLowerCase()) && strPaymentMethod.toLowerCase().contains("credit"))
		{
				
			boolean blnCreditCard=fnVerifyCreditDebitCard("Credit",objPayment.get(0).strCountry,objPayment.get(0).strPrice,"Yearly","ON",true);
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("1 Bulan Akses VIP".toLowerCase()) && strPaymentMethod.toLowerCase().contains("ovo"))
		{
				
			boolean blnCreditCard=fnVerifyOVOPayment("Monthly",objPayment.get(0).strCountry,objPayment.get(0).strPrice, "OFF");
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("1 Bulan Akses VIP".toLowerCase()) && strPaymentMethod.toLowerCase().contains("phonebill"))
		{
			boolean blnCreditCard=fnVerifyPhoneBill(objPayment.get(0).strCountry,objPayment.get(0).strPrice, "OFF");
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("1 Bulan Akses VIP".toLowerCase()) && strPaymentMethod.toLowerCase().contains("gopay"))
		{
			Thread.sleep(10000);
			boolean blnCreditCard=fnVerifyGoPayPayment("1 day",objPayment.get(0).strCountry,objPayment.get(0).strPrice);
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("1 Bulan Akses VIP".toLowerCase()) && strPaymentMethod.toLowerCase().contains("google"))
		{
				
			boolean blnCreditCard=fnVerifyGooglePlay(strPlanType,objPayment.get(0).strPrice,objPayment.get(0).strCountry);
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("1 Bulan Akses VIP".toLowerCase()) && strPaymentMethod.toLowerCase().contains("debit"))
		{
				
			boolean blnCreditCard=fnVerifyCreditDebitCard("Debit",objPayment.get(0).strCountry,objPayment.get(0).strPrice,"onetime","OFF",true);
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("1 Bulan Akses VIP".toLowerCase()) && strPaymentMethod.toLowerCase().contains("zgold"))
		{
			Thread.sleep(10000);
			boolean blnCreditCard=fnVerifyZGoldPayment(objPayment.get(0).strCountry,objPayment.get(0).strPrice);	
			System.out.println(blnCreditCard);
		}
		return Reporter.blnReportTempStatus;
	}
	
	public boolean fnVerifyPlanTH(String strPlanType,String strPaymentMethod) throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		List<String> arrPlan=new ArrayList<String>();
		List<Payment> objPayment=null;
		try
		{
			if(strPlanType.toLowerCase().equals("1 Year".toLowerCase()))
			{
				objPayment=fnGetPlanMethod("Android", "Subscription","1 Year");				
			}
			else if(strPlanType.toLowerCase().equals("Monthly".toLowerCase()))
			{
				objPayment=fnGetPlanMethod("Android", "Subscription","Monthly");	
			}		
			else if(strPlanType.toLowerCase().equals("Weekly".toLowerCase()))
			{
				objPayment=fnGetPlanMethod("Android", "Subscription","Weekly");	
			}
			for(int i=0;i<objPayment.size();i++)
			{
				System.out.println(objPayment.get(i).strPlanMethod);
				arrPlan=fnAddData(arrPlan,objPayment.get(i).strPlanMethod);
			}
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<WebElement> elePaymentList=elePayment1.get(0).findElements(By.className("android.widget.ListView"));
			System.out.println(elePaymentList.size());
			List<WebElement> eleViewPayment=elePaymentList.get(0).findElements(By.className("android.view.View"));
			System.out.println(eleViewPayment.size());
			//Find Payment Image
			List<WebElement> elePaymentMethod=elePaymentList.get(0).findElements(By.className("android.widget.Image"));
			System.out.println(elePaymentMethod.size());
			List<String> arrPayment=new ArrayList<String>();
			for(int j=0;j<elePaymentMethod.size();j++)
			{
				System.out.println(elePaymentMethod.get(j).getText());
				String strText=elePaymentMethod.get(j).getText();
				if(strText.contains("HOOQ logo")==false)
				{
					arrPayment=fnAddData(arrPayment,strText);
				}
			}
			for(int i=0;i<arrPlan.size();i++)
			{
				System.out.println(arrPayment.get(i).toLowerCase().trim().replaceAll(" ", ""));
				System.out.println(arrPlan.get(i).toLowerCase().trim());
				if(arrPayment.get(i).toLowerCase().trim().replaceAll(" ", "").contains(arrPlan.get(i).toLowerCase().trim().replaceAll(" ", "")))
				{
					Reporter.pass("Subscription Payment Method Verification","Payment Method : " + arrPlan.get(i) +" is displayed");
				}
				else
				{
					Reporter.fail("Subscription Payment Method Verification","Payment Method : " + arrPlan.get(i) +" is not displayed");
				}
			}
			for(int j=0;j<elePaymentMethod.size();j++)
			{
				System.out.println(elePaymentMethod.get(j).getText());
				String strText=elePaymentMethod.get(j).getText();
				if(strText.toLowerCase().contains(strPaymentMethod.toLowerCase()))
				{
					elePaymentMethod.get(j).click();
					Reporter.pass("Subscription Payment Method Verification","Payment Method : " + strPaymentMethod +" is Selected");
					break;
				}
			}
		}
		catch(Exception e){	Reporter.blnReportTempStatus=false;}
		Thread.sleep(10000);
		if(strPlanType.toLowerCase().contains("1 Year".toLowerCase()) && strPaymentMethod.toLowerCase().contains("google"))
		{
			boolean blnCreditCard=fnVerifyGooglePlay("yearly",objPayment.get(0).strPrice,objPayment.get(0).strCountry);
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("1 Year".toLowerCase()) && strPaymentMethod.toLowerCase().contains("credit"))
		{
			boolean blnCreditCard=fnVerifyCreditDebitCard("Credit",objPayment.get(0).strCountry,objPayment.get(0).strPrice,"Yearly","ON",true);
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("Monthly".toLowerCase()) && strPaymentMethod.toLowerCase().contains("google"))
		{
			boolean blnCreditCard=fnVerifyGooglePlay("Monthly",objPayment.get(0).strPrice,objPayment.get(0).strCountry);
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("Monthly".toLowerCase()) && strPaymentMethod.toLowerCase().contains("credit"))
		{
			boolean blnCreditCard=fnVerifyCreditDebitCard("Credit",objPayment.get(0).strCountry,"0.00","Monthly","ON",true);
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("Monthly".toLowerCase()) && strPaymentMethod.toLowerCase().contains("linerabbit"))
		{
			boolean blnCreditCard=fnVerifyLineRabbitPayment();
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("Weekly".toLowerCase()) && strPaymentMethod.toLowerCase().contains("google"))
		{
			boolean blnCreditCard=fnVerifyGooglePlay(strPlanType,objPayment.get(0).strPrice,objPayment.get(0).strCountry);
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("Weekly".toLowerCase()) && strPaymentMethod.toLowerCase().contains("debit"))
		{
			boolean blnCreditCard=fnVerifyCreditDebitCard("Debit",objPayment.get(0).strCountry,objPayment.get(0).strPrice,"Weekly","OFF",true);
			System.out.println(blnCreditCard);
		}
		else if(strPlanType.toLowerCase().contains("Weekly".toLowerCase()) && strPaymentMethod.toLowerCase().contains("zgold"))
		{
			Thread.sleep(10000);
			boolean blnCreditCard=fnVerifyZGoldPaymentTH(objPayment.get(0).strPrice);	
			System.out.println(blnCreditCard);
		}
		return Reporter.blnReportTempStatus;
	}
	
	
	
	
	public boolean fnVerifyCreditDebitCard(String strCardType,String strCurrency,String strAmount,String strSubscriptionDay,String strAutoRenew,boolean blnEntryCheck) throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		try
		{
			Reporter.info("Verify Subscription Payment", "Subscription Payment Useing " + strCardType +" Card");
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<String> arrPayment=new ArrayList<String>();
			for(int j=0;j<elePayment1.size();j++)
			{
				System.out.println(elePayment1.get(j).getText());
				String strText=elePayment1.get(j).getText();
				System.out.println(strText.length());
				if(strText.replaceAll(" ", "").length()>2)
				{
					arrPayment=fnAddData(arrPayment,strText);
				}
			}
			for(int i=0;i<arrPayment.size();i++)
			{
				System.out.println(arrPayment.get(i));
			}
			String strTextInfo="No payment required now. After the trial ends, you will be charged subscription fee.";
			if(fnVerifyTextInList(arrPayment, strTextInfo))
			{
				Reporter.pass("Subscription Payment Method "+strCardType+" Card Verification","Label : " + strTextInfo +" is displayed");
			}
			String strText="";
			if(strSubscriptionDay.toLowerCase().contains("yearly"))
			{
				if(strCurrency.toLowerCase().contains("sgd") )
				{
					strText="30 Days HOOQ All Access";
				}
				else if(strCurrency.toLowerCase().contains("php") || strCurrency.toLowerCase().contains("idr"))
				{
					strText="365 Days HOOQ All Access";
				}
				else
				{
					strText="365 Days HOOQ All Access";
				}	
				
			}
			else if(strSubscriptionDay.toLowerCase().contains("monthly"))
			{
				if(strCurrency.toLowerCase().contains("sgd") || strCurrency.toLowerCase().contains("php") || strCurrency.toLowerCase().contains("idr") || strCurrency.toLowerCase().contains("thb") )
				{
					strText="30 Days HOOQ All Access";
				}
				else
				{
					strText="90 Days HOOQ All Access";
				}				
			}
			else if(strSubscriptionDay.toLowerCase().contains("onetime"))
			{
				strText="30 Days HOOQ All Access";
			}
			if(strSubscriptionDay.toLowerCase().contains("weekly"))
			{
				if(strCurrency.toLowerCase().contains("php"))
				{
					strText="7 Days HOOQ All Access";
				}
				if(strCurrency.toLowerCase().contains("thb"))
				{
					strText="7 Days HOOQ All Access";
				}
			}
			else if(strSubscriptionDay.toLowerCase().contains("1 day"))
			{
				strText="1 Days HOOQ All Access";
			}
			
			
			if(fnVerifyTextInList(arrPayment, strText))
			{
				Reporter.pass("Subscription Payment Method "+strCardType+" Card Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method "+strCardType+" Card Verification","Label : " + strText +" is not displayed");
			}
			if(strAutoRenew.toLowerCase().contains("on"))
			{
				strText="Auto-renew: ON";
			}
			else
			{
				strText="Auto-renew: OFF";
			}
			if(fnVerifyTextInList(arrPayment, strText))
			{
				Reporter.pass("Subscription Payment Method "+strCardType+" Card Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method "+strCardType+" Card Verification","Label : " + strText +" is not displayed");
			}
			if(fnVerifyTextInList(arrPayment, strCurrency) && fnVerifyTextInList(arrPayment,strAmount))
			{
				Reporter.pass("Subscription Payment Method "+strCardType+" Card Verification","Currency : " + strCurrency +" is displayed");
				Reporter.pass("Subscription Payment Method "+strCardType+" Card Verification","Price : " + strAmount +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method "+strCardType+" Card Verification","Label : Currency and Price is not displayed");
				Reporter.fail("Subscription Payment Method "+strCardType+" Card Verification","Label : Currency and Price : " + arrPayment.get(2) +" displayed");
			}
			strText=strCardType+" CARD DETAILS";
			if(fnVerifyTextInList(arrPayment, strText))
			{
				Reporter.pass("Subscription Payment Method "+strCardType+" Card Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method "+strCardType+" Card Verification","Label : " + strText +" is not displayed");
			}
			strText="Card Number";
			if(fnVerifyTextInList(arrPayment, strText))
			{
				Reporter.pass("Subscription Payment Method "+strCardType+" Card Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method "+strCardType+" Card Verification","Label : " + strText +" is not displayed");
			}
			strText="Name on Card";
			if(fnVerifyTextInList(arrPayment, strText))
			{
				Reporter.pass("Subscription Payment Method "+strCardType+" Card Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method "+strCardType+" Card Verification","Label : " + strText +" is not displayed");
			}
			strText="Expiry Date";
			if(fnVerifyTextInList(arrPayment, strText))
			{
				Reporter.pass("Subscription Payment Method "+strCardType+" Card Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method "+strCardType+" Card Verification","Label : " + strText +" is not displayed");
			}
			strText="CVV";
			if(fnVerifyTextInList(arrPayment, strText))
			{
				Reporter.pass("Subscription Payment Method "+strCardType+" Card Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method "+strCardType+" Card Verification","Label : " + strText +" is not displayed");
			}
			List<WebElement> elePaymentEntry=elePayment.findElements(By.className("android.widget.EditText"));
			System.out.println(elePaymentEntry.size());
			for(int i=0;i<elePaymentEntry.size();i++)
			{
				System.out.println(elePaymentEntry.get(i).getText());
			}
			List<WebElement> elePaymentButton=elePayment.findElements(By.className("android.widget.Button"));
			System.out.println(elePaymentButton.size());
			System.out.println(elePaymentButton.get(0).getText());
			if(elePaymentButton.get(0).getText().toLowerCase().contains("cancel"))
			{
				Reporter.pass("Subscription Payment Method "+strCardType+" Card Verification","Button : Cancel is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method "+strCardType+" Card Verification","Button : Cancel is not displayed");
			}
			System.out.println(elePaymentButton.get(1).getText());
			if(elePaymentButton.get(1).getText().toLowerCase().contains("make payment"))
			{
				Reporter.pass("Subscription Payment Method "+strCardType+" Card Verification","Button : Make Payment is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method "+strCardType+" Card Verification","Button : Make Payment is not displayed");
			}
			if(blnEntryCheck)
			{
				CreditCardNumberGenerator objCCNumber=new CreditCardNumberGenerator();
				objCCNumber=objCCNumber.fnGetCardDetails();
				System.out.println("Name on Card ==> "+objCCNumber.strNameOnCard);
				System.out.println("Credit Card Number ==> " + objCCNumber.strCCNumber);
				System.out.println("Expire Date ==> " + objCCNumber.strExpireDate);
				System.out.println("CVV Number ==> " + objCCNumber.strCVVNumber);
				Reporter.info(strCardType+" Card Entry Details", "Credit Card Details Found");
				Reporter.pass(strCardType+" Card Entry Details","Name on Card ==> " + objCCNumber.strNameOnCard);
				Reporter.pass(strCardType+" Card Entry Details","Credit Card Number ==> " + objCCNumber.strCCNumber);
				Reporter.pass(strCardType+"Card Entry Details","Credit Card Expiry Date ==> " + objCCNumber.strExpireDate);
				Reporter.pass(strCardType+" Card Entry Details","Credit Card CVV Number ==> " + objCCNumber.strCVVNumber);
				elePaymentEntry.get(0).sendKeys(objCCNumber.strCCNumber);
				elePaymentEntry.get(1).sendKeys(objCCNumber.strNameOnCard);
				elePaymentEntry.get(2).sendKeys(objCCNumber.strExpireDate);
				elePaymentEntry.get(3).sendKeys(objCCNumber.strCVVNumber);
				Thread.sleep(5000);
				driver.navigate().back();
				Thread.sleep(5000);
				elePaymentButton.get(1).click();
				Thread.sleep(15000);
				List<WebElement> elePayment2=elePayment.findElements(By.className("android.view.View"));
				System.out.println(elePayment2.size());
				List<String> arrPaymentError=new ArrayList<String>();
				for(int j=0;j<elePayment2.size();j++)
				{
					System.out.println(elePayment2.get(j).getText());
					String strText1=elePayment2.get(j).getText();
					System.out.println(strText1.length());
					if(strText.replaceAll(" ", "").length()>2)
					{
						arrPaymentError=fnAddData(arrPaymentError,strText1);
					}
				}
				boolean blnErrorMessage=false;
				strText="card not supported";
				if(fnVerifyTextInList(arrPaymentError, strText))
				{
					Reporter.pass(strCardType+" Card Entry Details","Valid Error Messag is Displayed");
					blnErrorMessage=true;
				}
				strText="Sorry";
				if(fnVerifyTextInList(arrPaymentError, strText))
				{
					Reporter.pass(strCardType+" Card Entry Details","Valid Error Messag is Displayed");
					blnErrorMessage=true;
				}
				strText="Please enter a valid card number.";
				if(fnVerifyTextInList(arrPaymentError, strText))
				{
					Reporter.pass(strCardType+" Card Entry Details","Valid Error Messag is Displayed");
					driver.navigate().back();
					Thread.sleep(5000);
					blnErrorMessage=true;
				}
				if(blnErrorMessage==false)	
				{
					Reporter.fail(strCardType+" Card Entry Details","Valid Error Messag is not Displayed");
				}
				}
				elePaymentButton.get(0).click();
				Thread.sleep(5000);
				List<WebElement> elePaymentCancel=elePayment.findElements(By.className("android.view.View"));
				System.out.println(elePaymentCancel.size());
				if(elePaymentCancel.get(1).getText().toLowerCase().contains("payment cancelled"))
				{
					Reporter.pass(strCardType+" Card Payment Cancel","Info Payment Cancelled is Displayed");
				}
				else
				{
					Reporter.fail(strCardType+" Card Payment Cancel","Info Payment Cancelled is not Displayed");
				}
				if(elePaymentCancel.get(3).getText().toLowerCase().contains("done"))
				{
					Reporter.pass(strCardType+" Card Payment Cancel","Done Button is Displayed");					
				}
				else
				{
					Reporter.fail(strCardType+" Card Payment Cancel","Done Button is not Displayed");
				}
				elePaymentCancel.get(3).click();
				Thread.sleep(5000);
				if(isElementDisplayed(subscribeNow))
				{
					Reporter.pass(strCardType+" Card Payment Cancel","Subscribe Now Button is Displayed");	
					driver.navigate().back();
				}
				else
				{
					Reporter.fail(strCardType+" Card Payment Cancel","Subscribe Now Button is not Displayed");
				}
		}
		catch(Exception e){	Reporter.blnReportTempStatus=false;}
		Thread.sleep(10000);
		return Reporter.blnReportTempStatus;
	}
	
	public boolean fnVerifyAmazonPay() throws Throwable
	{
		boolean blnStatus=true;
		try
		{
			Reporter.info("Verify Subscription Payment", "Subscription Payment Useing Amazon Pay");
			List<WebElement> eleView=driver.findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(0).getText());
			WebElement elePayment=eleView.get(0).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<String> arrPayment=new ArrayList<String>();
			for(int j=0;j<elePayment1.size();j++)
			{
				System.out.println(elePayment1.get(j).getText());
				String strText=elePayment1.get(j).getText();
				System.out.println(strText.length());
				if(strText.replaceAll(" ", "").length()>2)
				{
					arrPayment=fnAddData(arrPayment,strText);
				}
			}
			for(int i=0;i<arrPayment.size();i++)
			{
				System.out.println(arrPayment.get(i));
			}
			String strText="Amazon";
			if(arrPayment.get(0).toLowerCase().contains(strText.toLowerCase()))
			{
				Reporter.pass("Subscription Payment Method Amazon Pay Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Amazon Pay Verification","Label : " + strText +" is not displayed");
			}
			strText="Sign-In using your Amazon account";
			if(arrPayment.get(1).toLowerCase().contains(strText.toLowerCase()))
			{
				Reporter.pass("Subscription Payment Method Amazon Pay Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Amazon Pay Verification","Label : " + strText +" is not displayed");
			}
			strText="Sign-In";
			if(arrPayment.get(2).toLowerCase().contains(strText.toLowerCase()))
			{
				Reporter.pass("Subscription Payment Method Amazon Pay Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Amazon Pay Verification","Label : " + strText +" is not displayed");
			}
			strText="Forgot password?";
			if(arrPayment.get(3).toLowerCase().contains(strText.toLowerCase()))
			{
				Reporter.pass("Subscription Payment Method Amazon Pay Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Amazon Pay Verification","Label : " + strText +" is not displayed");
			}
			strText="Email (phone for mobile accounts)";
			if(arrPayment.get(4).toLowerCase().contains(strText.toLowerCase()))
			{
				Reporter.pass("Subscription Payment Method Amazon Pay Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Amazon Pay Verification","Label : " + strText +" is not displayed");
			}
			strText="Amazon password";
			if(arrPayment.get(5).toLowerCase().contains(strText.toLowerCase()))
			{
				Reporter.pass("Subscription Payment Method Amazon Pay Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Amazon Pay Verification","Label : " + strText +" is not displayed");
			}
			List<WebElement> elePaymentEditBox=elePayment.findElements(By.className("android.widget.EditText"));
			System.out.println(elePaymentEditBox.size());
			if(elePaymentEditBox.size()>=2)
			{
				Reporter.pass("Subscription Payment Method Amazon Pay Verification","Amazon User ID and password Box is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Amazon Pay Verification","Amazon User ID and password Box is not displayed");
			}
			List<WebElement> elePaymentSignInButton=elePayment.findElements(By.className("android.widget.Button"));
			System.out.println(elePaymentSignInButton.size());
			System.out.println(elePaymentSignInButton.get(0).getText());
			if(elePaymentSignInButton.get(0).getText().toLowerCase().contains("sign-in"))
			{
				Reporter.pass("Subscription Payment Method Amazon Pay Verification","Amazon SignIn Button is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Amazon Pay Verification","Amazon SignIn Button is not displayed");
			}
			driver.navigate().back();
			Thread.sleep(5000);
			driver.navigate().back();
			Thread.sleep(5000);
			driver.navigate().back();
			Thread.sleep(5000);
			if(isElementDisplayed(subscribeNow))
			{
				Reporter.pass("Amazon Payment Cancel","Subscribe Now Button is Displayed");	
				driver.navigate().back();
			}
			else
			{
				Reporter.fail("Amazon Payment Cancel","Subscribe Now Button is Displayed");	
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
		}
		return blnStatus;
	}
	
	
	
	public boolean fnVerifyPayTM(String strPlanType,String strPrice) throws Throwable
	{
		boolean blnStatus=true;
		try
		{
			Reporter.info("Verify Subscription Payment", "Subscription Payment Useing PayTM");
			List<WebElement> eleView=driver.findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(0).getText());
			WebElement elePayment=eleView.get(0).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<String> arrPayment=new ArrayList<String>();
			for(int j=0;j<elePayment1.size();j++)
			{
				System.out.println(elePayment1.get(j).getText());
				String strText=elePayment1.get(j).getText();
				System.out.println(strText.length());
				if(strText.replaceAll(" ", "").length()>0)
				{
					arrPayment=fnAddData(arrPayment,strText);
				}
			}
			for(int i=0;i<arrPayment.size();i++)
			{
				System.out.println(arrPayment.get(i));
			}
				System.out.println(arrPayment.get(2));
				if(arrPayment.get(3).toLowerCase().contains(strPrice.toLowerCase()))
				{
					Reporter.pass("Subscription Payment Method PayTM Verification","Price : " + strPrice +" is displayed");
				}
				else
				{
					Reporter.fail("Subscription Payment Method PayTM Verification","Price is "+arrPayment.get(2)+" displayed");
				}
				String strText="Mobile number registered with Paytm";
				if(arrPayment.get(7).toLowerCase().contains(strText.toLowerCase()))
				{
					Reporter.pass("Subscription Payment Method PayTM Verification","Label : " + strText +" is displayed");
				}
				else
				{
					Reporter.fail("Subscription Payment Method PayTM Verification","Label : " + strText +" is not displayed");
				}
				strText="100% Secure Payments Powered by Paytm";
				if(arrPayment.get(9).toLowerCase().contains(strText.toLowerCase()))
				{
					Reporter.pass("Subscription Payment Method PayTM Verification","Label : " + strText +" is displayed");
				}
				else
				{
					Reporter.fail("Subscription Payment Method PayTM Verification","Label : " + strText +" is not displayed");
				}
				List<WebElement> elePaymentEditBox=elePayment.findElements(By.className("android.widget.EditText"));
				System.out.println(elePaymentEditBox.size());
				if(elePaymentEditBox.size()>0)
				{
					Reporter.pass("Subscription Payment Method PayTM Verification","PayTM Enter Mobile No Field is displayed");
				}
				else
				{	
					Reporter.fail("Subscription Payment Method PayTM Verification","PayTM Enter Mobile No Field is not displayed");
				}
				List<WebElement> elePaymentSignInButton=elePayment.findElements(By.className("android.widget.Button"));
				System.out.println(elePaymentSignInButton.size());
				System.out.println(elePaymentSignInButton.get(0).getText());
				if(elePaymentSignInButton.get(0).getText().toLowerCase().contains("proceed"))
				{
					Reporter.pass("Subscription Payment Method PayTM Verification","PayTM Proceed Button is displayed");
				}
				else
				{
					Reporter.fail("Subscription Payment Method PayTM Verification","PayTM Proceed Button is not displayed");
				}
			driver.navigate().back();
			Thread.sleep(10000);
			List<WebElement> elePaymentCancel=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePaymentCancel.size());
			if(elePaymentCancel.get(1).getText().toLowerCase().contains("payment cancelled"))
			{
				Reporter.pass("PayTM Payment Cancel","Info Payment Cancelled is Displayed");
			}
			else
			{
				Reporter.fail("PayTM Payment Cancel","Info Payment Cancelled is not Displayed");
			}
			if(elePaymentCancel.get(3).getText().toLowerCase().contains("done"))
			{
				Reporter.pass("PayTM Payment Cancel","Done Button is Displayed");					
			}
			else
			{
				Reporter.fail("PayTM Payment Cancel","Done Button is not Displayed");
			}
			elePaymentCancel.get(3).click();
			Thread.sleep(5000);
			if(isElementDisplayed(subscribeNow))
			{
				Reporter.pass("PayTM Payment Cancel","Subscribe Now Button is Displayed");	
				driver.navigate().back();
			}
			else
			{
				Reporter.fail("PayTM Payment Cancel","Subscribe Now Button is not Displayed");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
		}
		return blnStatus;
	}
	
	public boolean fnVerifyGooglePlay(String strPlanType,String strPrice,String strCurrency) throws Throwable
	{
		boolean blnStatus=true;
		try
		{
			Reporter.info("Verify Subscription Payment", "Subscription Payment Useing Google Play");
			List<WebElement> eleGooglePay=driver.findElements(By.className("android.widget.TextView"));
			System.out.println(eleGooglePay.size());
			List<String> arrPayment=new ArrayList<String>();
			for(int i=0;i<eleGooglePay.size();i++)
			{
				String strText=eleGooglePay.get(i).getText();
				System.out.println(strText);
				arrPayment=fnAddData(arrPayment,strText);
			}
			
			for(int i=0;i<arrPayment.size();i++)
			{
				System.out.println(arrPayment.get(i));
			}
			String strText="";
			if(strPlanType.toLowerCase().contains("yearly"))
			{
				strText="HOOQ Annual Pack";
			}
			else if(strPlanType.toLowerCase().contains("monthly"))
			{
				if(strCurrency.toLowerCase().contains("thb"))
				{
					strText="Recurring";
				}
				else
				{
					strText="30 Days Recurring";
				}
			}
			else if(strPlanType.toLowerCase().contains("1 day"))
			{
				strText="HOOQ One Day";
			}
			else if(strPlanType.toLowerCase().contains("Langganan VIP Bulanan".toLowerCase()))
			{
				strText="HOOQ 30D Recur Subscription";
			}
			if(fnVerifyTextInList(arrPayment, strText))
			{
				Reporter.pass("Subscription Payment Method Google Play Verification","Label : " + arrPayment.get(0) +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Google Play Verification","Label : " + strText +" is not displayed");
			}
			strText="HOOQ - Watch Movies, TV Shows, Live Channels, News";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method Google Play Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Google Play Verification","Label : " + strText +" is not displayed");
			}
			if(fnVerifyTextInList(arrPayment,strPrice))
			{
				Reporter.pass("Subscription Payment Method Google Play Verification","Price : " + strPrice +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Google Play Verification","strPrice : " + strPrice +" is not displayed");
			}
			strText="Cancel at any time";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method Google Play Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Google Play Verification","Label : " + strText +" is not displayed");
			}
			List<WebElement> eleGooglePaySubs=driver.findElements(By.className("android.widget.Button"));
			System.out.println(eleGooglePaySubs.size());
			System.out.println(eleGooglePaySubs.get(0).getText());
			strText="Subscribe";
			if(eleGooglePaySubs.get(0).getText().toLowerCase().contains(strText.toLowerCase()))
			{
				Reporter.pass("Subscription Payment Method Google Play Verification","Button : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Google Play Verification","Label : " + strText +" is not displayed");
			}
			driver.navigate().back();
			Thread.sleep(5000);
			driver.navigate().back();
			Thread.sleep(5000);
			driver.navigate().back();
			Thread.sleep(5000);
			if(isElementDisplayed(subscribeNow))
			{
				Reporter.pass("Google Play Payment Cancel","Subscribe Now Button is Displayed");	
				driver.navigate().back();
			}
			else
			{
				Reporter.fail("Google Play Payment Cancel","Subscribe Now Button is not Displayed");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
		}
		return blnStatus;
	}
	
	
	public boolean fnVerifyOlaMoney(String strCurrency,String strAmount,String strSubscriptionDay,String strAutoRenew) throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		try
		{
			Reporter.info("Verify Subscription Payment", "Subscription Payment Useing Ola Money");
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<String> arrPayment=new ArrayList<String>();
			for(int j=0;j<elePayment1.size();j++)
			{
				System.out.println(elePayment1.get(j).getText());
				String strText=elePayment1.get(j).getText();
				System.out.println(strText.length());
				if(strText.replaceAll(" ", "").length()>2)
				{
					arrPayment=fnAddData(arrPayment,strText);
				}
			}
			for(int i=0;i<arrPayment.size();i++)
			{
				System.out.println(arrPayment.get(i));
			}
			
			String strText="";
			if(strSubscriptionDay.toLowerCase().contains("yearly"))
			{
				strText="Ola Money - 365 days of HOOQ recurring subscription";
			}
			else if(strSubscriptionDay.toLowerCase().contains("monthly"))
			{
				strText="Ola Money INR 89 Promotion";
			}
			
			if(arrPayment.get(0).toLowerCase().contains(strText.toLowerCase()))
			{
				Reporter.pass("Subscription Payment Method Ola Money Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Ola Money Verification","Label : " + strText +" is not displayed");
			}
			if(strAutoRenew.toLowerCase().contains("on"))
			{
				strText="Auto-renew: ON";
			}
			else
			{
				strText="Auto-renew: OFF";
			}
			if(arrPayment.get(1).toLowerCase().contains(strText.toLowerCase()))
			{
				Reporter.pass("Subscription Payment Method Ola Money Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Ola Money Verification","Label : " + strText +" is not displayed");
			}
			
			if(arrPayment.get(2).toLowerCase().contains(strCurrency.toLowerCase()) && arrPayment.get(2).toLowerCase().contains(strAmount.toLowerCase()))
			{
				Reporter.pass("Subscription Payment Method Ola Money Verification","Currency : " + strCurrency +" is displayed");
				Reporter.pass("Subscription Payment Method Ola Money Verification","Price : " + strAmount +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Ola Money Verification","Label : Currency and Price is not displayed");
				Reporter.fail("Subscription Payment Method Ola Money Verification","Label : Currency and Price : " + arrPayment.get(2) +" displayed");
			}
			strText="Mobile Number";
			if(arrPayment.get(3).toLowerCase().contains(strText.toLowerCase()))
			{
				Reporter.pass("Subscription Payment Method Ola Money Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Ola Money Verification","Label : " + strText +" is not displayed");
			}
			strText="+91";
			if(arrPayment.get(4).toLowerCase().contains(strText.toLowerCase()))
			{
				Reporter.pass("Subscription Payment Method Ola Money Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Ola Money Verification","Label : " + strText +" is not displayed");
			}
			strText="Email Address";
			if(arrPayment.get(5).toLowerCase().contains(strText.toLowerCase()))
			{
				Reporter.pass("Subscription Payment Method Ola Money Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Ola Money Verification","Label : " + strText +" is not displayed");
			}
			List<WebElement> elePaymentButton=elePayment.findElements(By.className("android.widget.Button"));
			System.out.println(elePaymentButton.size());
			System.out.println(elePaymentButton.get(0).getText());
			if(elePaymentButton.get(0).getText().toLowerCase().contains("cancel"))
			{
				Reporter.pass("Subscription Payment Method Ola Money Verification","Button : Cancel is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Ola Money Verification","Button : Cancel is not displayed");
			}
			System.out.println(elePaymentButton.get(1).getText());
			if(elePaymentButton.get(1).getText().toLowerCase().contains("make payment"))
			{
				Reporter.pass("Subscription Payment Method Ola Money Verification","Button : Make Payment is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Ola Money Verification","Button : Make Payment is not displayed");
			}
			List<WebElement> elePaymentEntry=elePayment.findElements(By.className("android.widget.EditText"));
			if(elePaymentEntry.size()>=2)
			{
				Reporter.pass("Subscription Payment Method Ola Money Verification","Moble Number and Email Address Field is available");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Ola Money Verification","Moble Number and Email Address Field is not available");
			}
			elePaymentButton.get(0).click();
			Thread.sleep(5000);
			List<WebElement> elePaymentCancel=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePaymentCancel.size());
			if(elePaymentCancel.get(1).getText().toLowerCase().contains("payment cancelled"))
			{
				Reporter.pass("Ola Money Payment Cancel","Info Payment Cancelled is Displayed");
			}
			else
			{
				Reporter.fail("Ola Money Payment Cancel","Info Payment Cancelled is not Displayed");
			}
			if(elePaymentCancel.get(3).getText().toLowerCase().contains("done"))
			{
				Reporter.pass("Ola Money Card Payment Cancel","Done Button is Displayed");					
			}
			else
			{
				Reporter.fail("Ola Money Payment Cancel","Done Button is not Displayed");
			}
			elePaymentCancel.get(3).click();
			Thread.sleep(5000);
			if(isElementDisplayed(subscribeNow))
			{
				Reporter.pass("Ola Money Payment Cancel","Subscribe Now Button is Displayed");	
				driver.navigate().back();
			}
			else
			{
				Reporter.fail("Ola Money Payment Cancel","Subscribe Now Button is not Displayed");
			}
			
		}
		catch(Exception e){	Reporter.blnReportTempStatus=false;}
		Thread.sleep(10000);
		return Reporter.blnReportTempStatus;
	}

	public boolean fnVerifyPhoneBill(String strCurrency,String strAmount,String strAutoRenew) throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		try
		{
			Reporter.info("Verify Subscription Payment", "Subscription Payment Useing Phone Bill");
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<String> arrPayment=new ArrayList<String>();
			for(int j=0;j<elePayment1.size();j++)
			{
				System.out.println(elePayment1.get(j).getText());
				String strText=elePayment1.get(j).getText();
				System.out.println(strText.length());
				if(strText.replaceAll(" ", "").length()>2)
				{
					arrPayment=fnAddData(arrPayment,strText);
				}
			}
			for(int i=0;i<arrPayment.size();i++)
			{
				System.out.println(arrPayment.get(i));
			}
			
			String strText="30 Days HOOQ All Access";
			if(fnVerifyTextInList(arrPayment, strText))
			{
				Reporter.pass("Subscription Payment Method Phone Bill Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Phone Bill Verification","Label : " + strText +" is not displayed");
			}
			if(strAutoRenew.toLowerCase().contains("on"))
			{
				strText="Auto-renew: ON";
			}
			else
			{
				strText="Auto-renew: OFF";
			}
			if(fnVerifyTextInList(arrPayment, strText))
			{
				Reporter.pass("Subscription Payment Method Phone Bill Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Phone Bill Verification","Label : " + strText +" is not displayed");
			}
			
			if(fnVerifyTextInList(arrPayment,strCurrency) && fnVerifyTextInList(arrPayment,strAmount))
			{
				Reporter.pass("Subscription Payment Method Phone Bill Verification","Currency : " + strCurrency +" is displayed");
				Reporter.pass("Subscription Payment Method Phone Bill Verification","Price : " + strAmount +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Phone Bill Verification","Label : Currency and Price is not displayed");
				Reporter.fail("Subscription Payment Method Phone Bill Verification","Label : Currency and Price : " + arrPayment.get(2) +" displayed");
			}
			strText="MOBILE BILL PAYMENT";
			if(fnVerifyTextInList(arrPayment, strText))
			{
				Reporter.pass("Subscription Payment Method Phone Bill Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Phone Bill Verification","Label : " + strText +" is not displayed");
			}
			strText="The cost will be charged to your mobile phone bill.";
			if(fnVerifyTextInList(arrPayment, strText))
			{
				Reporter.pass("Subscription Payment Method Phone Bill Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Phone Bill Verification","Label : " + strText +" is not displayed");
			}
			strText="Mobile Number";
			if(fnVerifyTextInList(arrPayment, strText))
			{
				Reporter.pass("Subscription Payment Method Phone Bill Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Phone Bill Verification","Label : " + strText +" is not displayed");
			}
			if(strCurrency.toLowerCase().equals("inr"))
			{
				strText="+91";
			}
			else if(strCurrency.toLowerCase().equals("idr"))
			{
				strText="+62";
			}
			if(fnVerifyTextInList(arrPayment, strText))
			{
				Reporter.pass("Subscription Payment Method Phone Bill Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Phone Bill Verification","Label : " + strText +" is not displayed");
			}
			strText="Carrier";
			if(fnVerifyTextInList(arrPayment, strText))
			{
				Reporter.pass("Subscription Payment Method Phone Bill Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Phone Bill Verification","Label : " + strText +" is not displayed");
			}
			List<WebElement> elePaymentSpinner=elePayment.findElements(By.className("android.widget.Spinner"));
			System.out.println(elePaymentSpinner.size());
			if(elePaymentSpinner.size()>0)
			{
				Reporter.pass("Subscription Payment Method Phone Bill Verification","Carrier ComboBox is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Phone Bill Verification","Carrier ComboBox is not displayed");
			}
			List<WebElement> elePaymentButton=elePayment.findElements(By.className("android.widget.Button"));
			System.out.println(elePaymentButton.size());
			System.out.println(elePaymentButton.get(0).getText());
			if(elePaymentButton.get(0).getText().toLowerCase().contains("cancel"))
			{
				Reporter.pass("Subscription Payment Method Phone Bill Verification","Button : Cancel is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Phone Bill Verification","Button : Cancel is not displayed");
			}
			System.out.println(elePaymentButton.get(1).getText());
			if(elePaymentButton.get(1).getText().toLowerCase().contains("make payment"))
			{
				Reporter.pass("Subscription Payment Method Phone Bill Verification","Button : Make Payment is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Phone Bill Verification","Button : Make Payment is not displayed");
			}
			List<WebElement> elePaymentEntry=elePayment.findElements(By.className("android.widget.EditText"));
			if(elePaymentEntry.size()>0)
			{
				Reporter.pass("Subscription Payment Method Phone Bill Verification","Moble Number Field is available");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Phone Bill Verification","Moble Number Field is not available");
			}
			elePaymentButton.get(0).click();
			Thread.sleep(5000);
			List<WebElement> elePaymentCancel=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePaymentCancel.size());
			if(elePaymentCancel.get(1).getText().toLowerCase().contains("payment cancelled"))
			{
				Reporter.pass("Phone Bill Payment Cancel","Info Payment Cancelled is Displayed");
			}
			else
			{
				Reporter.fail("Phone Bill Payment Cancel","Info Payment Cancelled is not Displayed");
			}
			if(elePaymentCancel.get(3).getText().toLowerCase().contains("done"))
			{
				Reporter.pass("Phone Bill Card Payment Cancel","Done Button is Displayed");					
			}
			else
			{
				Reporter.fail("Phone Bill Payment Cancel","Done Button is not Displayed");
			}
			elePaymentCancel.get(3).click();
			Thread.sleep(5000);
			if(isElementDisplayed(subscribeNow))
			{
				Reporter.pass("Phone Bill Payment Cancel","Subscribe Now Button is Displayed");	
				driver.navigate().back();
			}
			else
			{
				Reporter.fail("Phone Bill Payment Cancel","Subscribe Now Button is not Displayed");
			}
		}
		catch(Exception e){	Reporter.blnReportTempStatus=false;}
		Thread.sleep(10000);
		return Reporter.blnReportTempStatus;
	}
	
	public boolean fnVerifyNetBanking(String strCurrency,String strAmount,String strAutoRenew) throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		try
		{
			Reporter.info("Verify Subscription Payment", "Subscription Payment Useing Net Banking");
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<String> arrPayment=new ArrayList<String>();
			for(int j=0;j<elePayment1.size();j++)
			{
				System.out.println(elePayment1.get(j).getText());
				String strText=elePayment1.get(j).getText();
				System.out.println(strText.length());
				if(strText.replaceAll(" ", "").length()>2)
				{
					arrPayment=fnAddData(arrPayment,strText);
				}
			}
			for(int i=0;i<arrPayment.size();i++)
			{
				System.out.println(arrPayment.get(i));
			}
			
			String strText="30 Days HOOQ All Access";
			if(arrPayment.get(0).toLowerCase().contains(strText.toLowerCase()))
			{
				Reporter.pass("Subscription Payment Method Net Banking Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Net Banking Verification","Label : " + strText +" is not displayed");
			}
			if(strAutoRenew.toLowerCase().contains("on"))
			{
				strText="Auto-renew: ON";
			}
			else
			{
				strText="Auto-renew: OFF";
			}
			if(arrPayment.get(1).toLowerCase().contains(strText.toLowerCase()))
			{
				Reporter.pass("Subscription Payment Method Net Banking Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Net Banking Verification","Label : " + strText +" is not displayed");
			}
			
			if(arrPayment.get(2).toLowerCase().contains(strCurrency.toLowerCase()) && arrPayment.get(2).toLowerCase().contains(strAmount.toLowerCase()))
			{
				Reporter.pass("Subscription Payment Method Net Banking Verification","Currency : " + strCurrency +" is displayed");
				Reporter.pass("Subscription Payment Method Net Banking Verification","Price : " + strAmount +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Net Banking Verification","Label : Currency and Price is not displayed");
				Reporter.fail("Subscription Payment Method Net Banking Verification","Label : Currency and Price : " + arrPayment.get(2) +" displayed");
			}
			strText="NET BANKING PAYMENT";
			if(arrPayment.get(3).toLowerCase().contains(strText.toLowerCase()))
			{
				Reporter.pass("Subscription Payment Method Net Banking Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Net Banking Verification","Label : " + strText +" is not displayed");
			}
			strText="Select your bank";
			if(arrPayment.get(4).toLowerCase().contains(strText.toLowerCase()))
			{
				Reporter.pass("Subscription Payment Method Net Banking Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Net Banking Verification","Label : " + strText +" is not displayed");
			}
			List<WebElement> elePaymentButton=elePayment.findElements(By.className("android.widget.Button"));
			System.out.println(elePaymentButton.size());
			System.out.println(elePaymentButton.get(0).getText());
			if(elePaymentButton.get(0).getText().toLowerCase().contains("cancel"))
			{
				Reporter.pass("Subscription Payment Method Net Banking Verification","Button : Cancel is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Net Banking Verification","Button : Cancel is not displayed");
			}
			System.out.println(elePaymentButton.get(1).getText());
			if(elePaymentButton.get(1).getText().toLowerCase().contains("make payment"))
			{
				Reporter.pass("Subscription Payment Method Net Banking Verification","Button : Make Payment is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Net Banking Verification","Button : Make Payment is not displayed");
			}
			List<WebElement> elePaymentSpinner=elePayment.findElements(By.className("android.widget.Spinner"));
			System.out.println(elePaymentSpinner.size());
			if(elePaymentSpinner.size()>0)
			{
				Reporter.pass("Subscription Payment Method Net Banking Verification","Net Banking ComboBox is displayed");
				elePaymentSpinner.get(0).click();
				Thread.sleep(10000);
				List<String> arrNetBank=new ArrayList<String>();
				List<WebElement> eleNetBank=driver.findElement(By.className("android.widget.ListView")).findElements(By.className("android.widget.CheckedTextView"));
				System.out.println(eleNetBank.size());
				for(int i=0;i<eleNetBank.size();i++)
				{
					String strNetBankText=eleNetBank.get(i).getText();
					System.out.println(strNetBankText);
					arrNetBank=fnAddData(arrNetBank, strNetBankText);
				}
				for(int i=0;i<arrNetBank.size();i++)
				{
					System.out.println(arrNetBank.get(i));
					Reporter.pass("Subscription Payment Method Net Banking Verification","Bank Name : " + arrNetBank.get(i) +" is displayed");
				}
				eleNetBank.get(1).click();
				Thread.sleep(10000);
				String strTextSelected=elePaymentSpinner.get(0).getText();
				if(strTextSelected.toLowerCase().contains("please select your bank")==false)
				{
					Reporter.pass("Subscription Payment Method Net Banking Verification","Bank Name : " + strTextSelected +" is Selected");
				}
				else
				{
					Reporter.fail("Subscription Payment Method Net Banking Verification","Bank Name : " + strTextSelected +" is Selected");
				}
				
			}
			else
			{
				Reporter.fail("Subscription Payment Method Net Banking Verification","Net Banking ComboBox is not displayed");
			}
			elePaymentButton.get(0).click();
			Thread.sleep(5000);
			List<WebElement> elePaymentCancel=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePaymentCancel.size());
			if(elePaymentCancel.get(1).getText().toLowerCase().contains("payment cancelled"))
			{
				Reporter.pass("Net Banking Payment Cancel","Info Payment Cancelled is Displayed");
			}
			else
			{
				Reporter.fail("Net Banking Payment Cancel","Info Payment Cancelled is not Displayed");
			}
			if(elePaymentCancel.get(3).getText().toLowerCase().contains("done"))
			{
				Reporter.pass("Net Banking Card Payment Cancel","Done Button is Displayed");					
			}
			else
			{
				Reporter.fail("Net Banking Payment Cancel","Done Button is not Displayed");
			}
			elePaymentCancel.get(3).click();
			Thread.sleep(5000);
			if(isElementDisplayed(subscribeNow))
			{
				Reporter.pass("Net Banking Payment Cancel","Subscribe Now Button is Displayed");	
				driver.navigate().back();
			}
			else
			{
				Reporter.fail("Net Banking Payment Cancel","Subscribe Now Button is not Displayed");
			}
		}
		catch(Exception e){	Reporter.blnReportTempStatus=false;}
		Thread.sleep(10000);
		return Reporter.blnReportTempStatus;
	}
	
	public boolean fnVerifyPlanInfoSG(String strPaymentethod) throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		mePage.fnSelectMESection("subscription");
		click(subscribeNow,"Subscribe Now");
		Thread.sleep(10000);
		List<String> arrPlan=new ArrayList<String>();
		List<Payment> objPayment=null;
		Reporter.info("Subscription Info Verification" , "Verify Subscription Info for " + strPaymentethod);
		try
		{
			int intCount=0;
			if(strPaymentethod.toLowerCase().contains("monthly"))
			{
				objPayment=fnGetPlanMethod("Android", "Subscription","Monthly");				
			}
			else if(strPaymentethod.toLowerCase().contains("yearly"))
			{
				objPayment=fnGetPlanMethod("Android", "Subscription","1 Year");	
				intCount=4;
			}			
			for(int i=0;i<objPayment.size();i++)
			{
				System.out.println(objPayment.get(i).strPlanMethod);
				arrPlan=fnAddData(arrPlan,objPayment.get(i).strPlanMethod);
			}
			String strCurrency=objPayment.get(0).strCountry;
			String strAmount=objPayment.get(0).strPrice;
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<WebElement> elePaymentList=elePayment1.get(0).findElements(By.className("android.widget.ListView"));
			System.out.println(elePaymentList.size());
			List<WebElement> eleViewPayment=elePaymentList.get(0).findElements(By.className("android.view.View"));
			System.out.println(eleViewPayment.size());
			List<WebElement> eleViewTest=eleViewPayment.get(intCount).findElements(By.className("android.view.View"));
			List<WebElement> elePaymentText=eleViewTest.get(0).findElements(By.className("android.view.View"));
			System.out.println(elePaymentText.size());
			List<String> arrPayment=new ArrayList<String>();
			for(int j=0;j<elePaymentText.size();j++)
			{
				System.out.println(elePaymentText.get(j).getText());
				String strText=elePaymentText.get(j).getText();
				if(strText.length()>0)
				{
					arrPayment=fnAddData(arrPayment,strText);
				}
			}
			for(int i=0;i<arrPayment.size();i++)
			{
				System.out.println(arrPayment.get(i));
			}
			
			
			if(strPaymentethod.toLowerCase().contains("yearly"))
			{
				String strVerifyText="BEST VALUE";
				if(arrPayment.get(0).toLowerCase().contains(strVerifyText.toLowerCase()))
				{
					Reporter.pass("Subscription Info for 1 Year", "Info :- BEST VALUE is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for 1 Year", "Info :- BEST VALUE is not displayed");
				}
				strVerifyText="Annual VIP Pass";
				if(arrPayment.get(0).toLowerCase().contains(strVerifyText.toLowerCase()))
				{
					Reporter.pass("Subscription Info for 1 Year", "Info :- Annual VIP Pass is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for 1 Year", "Info :- Annual VIP Pass is not displayed");
				}
				strVerifyText="Charged yearly, non-refundable";
				if(arrPayment.get(1).toLowerCase().contains(strVerifyText.toLowerCase()))
				{
					Reporter.pass("Subscription Info for 1 Year", "Info :- Charged yearly, non-refundable is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for 1 Year", "Info :- Charged yearly, non-refundable is not displayed");
				}
				if(arrPayment.get(3).toLowerCase().contains(strCurrency.toLowerCase())&&arrPayment.get(3).toLowerCase().contains(strAmount.toLowerCase()))
				{
					Reporter.pass("Subscription Info for 1 Year", "Info :-  " + strCurrency+" " +strAmount+" is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for 1 Year", "Info :-  " + strCurrency+" " +strAmount+" is not displayed");
				}
			}
			else if(strPaymentethod.toLowerCase().contains("monthly"))
			{
				String strVerifyText="Monthly VIP Pass";
				if(arrPayment.get(0).toLowerCase().contains(strVerifyText.toLowerCase()))
				{
					Reporter.pass("Subscription Info for Monthly", "Info :- Monthly VIP Pass Subscription");
				}
				else
				{
					Reporter.fail("Subscription Info for Monthly", "Info :- Monthly VIP Pass is not displayed");
				}
			
				if(arrPayment.get(2).toLowerCase().contains(strCurrency.toLowerCase())&&arrPayment.get(2).toLowerCase().contains(strAmount.toLowerCase()))
				{
					Reporter.pass("Subscription Info for Monthly", "Info :-  " + strCurrency+" " +strAmount+" is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for Monthly", "Info :-  " + strCurrency+" " +strAmount+" is not displayed");
				}
				strVerifyText="Charged monthly, cancel anytime";
				if(arrPayment.get(1).toLowerCase().contains(strVerifyText.toLowerCase()))
				{
					Reporter.pass("Subscription Info for Monthly", "Info :- Charged monthly, cancel anytime is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for Monthly", "Info :- Charged monthly, cancel anytime is not displayed");
				}				
			}
		}
		catch(Exception e){Reporter.blnReportTempStatus=false;}
		boolean blnPlanPaymentMethod=fnVerifyPaymentMethodSG(strPaymentethod,arrPlan);
		if(Reporter.blnReportTempStatus && blnPlanPaymentMethod)
		{
			Reporter.blnReportTempStatus=true;
		}
		else
		{
			Reporter.blnReportTempStatus=false;
		}
		Thread.sleep(10000);
		return Reporter.blnReportTempStatus;
	}
	
	
	public boolean fnVerifyPlanInfoPH(String strPaymentethod) throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		mePage.fnSelectMESection("subscription");
		click(subscribeNow,"Subscribe Now");
		Thread.sleep(10000);
		List<String> arrPlan=new ArrayList<String>();
		List<Payment> objPayment=null;
		Reporter.info("Subscription Info Verification" , "Verify Subscription Info for " + strPaymentethod);
		try
		{
			int intCount=0;
			if(strPaymentethod.toLowerCase().equals("monthly"))
			{
				objPayment=fnGetPlanMethod("Android", "Subscription","Monthly");				
			}
			else if(strPaymentethod.toLowerCase().equals("yearly"))
			{
				objPayment=fnGetPlanMethod("Android", "Subscription","1 Year");	
				intCount=4;
			}		
			else if(strPaymentethod.toLowerCase().equals("one time monthly"))
			{
				objPayment=fnGetPlanMethod("Android", "Subscription","One Time Monthly");	
				intCount=14;
			}
			else if(strPaymentethod.toLowerCase().contains("weekly vip"))
			{
				objPayment=fnGetPlanMethod("Android", "Subscription","Weekly VIP");	
				intCount=20;
			}	
			else if(strPaymentethod.toLowerCase().equals("1 day"))
			{
				objPayment=fnGetPlanMethod("Android", "Subscription","1 day");	
				intCount=26;
			}
			for(int i=0;i<objPayment.size();i++)
			{
				System.out.println(objPayment.get(i).strPlanMethod);
				arrPlan=fnAddData(arrPlan,objPayment.get(i).strPlanMethod);
			}
			String strCurrency=objPayment.get(0).strCountry;
			String strAmount=objPayment.get(0).strPrice;
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<WebElement> elePaymentList=elePayment1.get(0).findElements(By.className("android.widget.ListView"));
			System.out.println(elePaymentList.size());
			List<WebElement> eleViewPayment=elePaymentList.get(0).findElements(By.className("android.view.View"));
			System.out.println(eleViewPayment.size());
			List<WebElement> eleViewTest=eleViewPayment.get(intCount).findElements(By.className("android.view.View"));
			List<WebElement> elePaymentText=eleViewTest.get(0).findElements(By.className("android.view.View"));
			System.out.println(elePaymentText.size());
			List<String> arrPayment=new ArrayList<String>();
			for(int j=0;j<elePaymentText.size();j++)
			{
				System.out.println(elePaymentText.get(j).getText());
				String strText=elePaymentText.get(j).getText();
				if(strText.length()>0)
				{
					arrPayment=fnAddData(arrPayment,strText);
				}
			}
			for(int i=0;i<arrPayment.size();i++)
			{
				System.out.println(arrPayment.get(i));
			}
			if(strPaymentethod.toLowerCase().contains("yearly"))
			{
				String strVerifyText="BEST VALUE";
				if(arrPayment.get(0).toLowerCase().contains(strVerifyText.toLowerCase()))
				{
					Reporter.pass("Subscription Info for 1 Year", "Info :- BEST VALUE is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for 1 Year", "Info :- BEST VALUE is not displayed");
				}
				strVerifyText="Annual VIP Pass";
				if(arrPayment.get(0).toLowerCase().contains(strVerifyText.toLowerCase()))
				{
					Reporter.pass("Subscription Info for 1 Year", "Info :- Annual VIP Pass is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for 1 Year", "Info :- Annual VIP Pass is not displayed");
				}
				strVerifyText="Charged yearly, non-refundable";
				if(arrPayment.get(1).toLowerCase().contains(strVerifyText.toLowerCase()))
				{
					Reporter.pass("Subscription Info for 1 Year", "Info :- Charged yearly, non-refundable is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for 1 Year", "Info :- Charged yearly, non-refundable is not displayed");
				}
				if(arrPayment.get(3).toLowerCase().contains(strCurrency.toLowerCase())&&arrPayment.get(3).toLowerCase().contains(strAmount.toLowerCase()))
				{
					Reporter.pass("Subscription Info for 1 Year", "Info :-  " + strCurrency+" " +strAmount+" is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for 1 Year", "Info :-  " + strCurrency+" " +strAmount+" is not displayed");
				}
			}
			else if(strPaymentethod.toLowerCase().equals("monthly"))
			{
				String strVerifyText="Monthly VIP Subscription";
				if(arrPayment.get(0).toLowerCase().contains(strVerifyText.toLowerCase()))
				{
					Reporter.pass("Subscription Info for Monthly", "Info :- Monthly VIP Subscription Subscription");
				}
				else
				{
					Reporter.fail("Subscription Info for Monthly", "Info :- Monthly VIP Subscription is not displayed");
				}
			
				if(arrPayment.get(2).toLowerCase().contains(strCurrency.toLowerCase())&&arrPayment.get(2).toLowerCase().contains(strAmount.toLowerCase()))
				{
					Reporter.pass("Subscription Info for Monthly", "Info :-  " + strCurrency+" " +strAmount+" is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for Monthly", "Info :-  " + strCurrency+" " +strAmount+" is not displayed");
				}
				strVerifyText="Charged monthly, cancel anytime";
				if(arrPayment.get(1).toLowerCase().contains(strVerifyText.toLowerCase()))
				{
					Reporter.pass("Subscription Info for Monthly", "Info :- Charged monthly, cancel anytime is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for Monthly", "Info :- Charged monthly, cancel anytime is not displayed");
				}				
			}
			else if(strPaymentethod.toLowerCase().equals("one time monthly"))
			{
				String strVerifyText="OneTime Monthly VIP Subscription";
				if(arrPayment.get(0).toLowerCase().contains(strVerifyText.toLowerCase()))
				{
					Reporter.pass("Subscription Info for One Time Monthly", "Info :- OneTime Monthly VIP Subscription is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for One Time Monthly", "Info :- OneTime Monthly VIP Subscription is not displayed");
				}
				strVerifyText="Charged upfront, non-refundable";
				if(arrPayment.get(1).toLowerCase().contains(strVerifyText.toLowerCase()))
				{
					Reporter.pass("Subscription Info for One Time Monthly", "Info :- Charged upfront, non-refundable is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for One Time Monthly", "Info :- Charged upfront, non-refundable is not displayed");
				}
				if(arrPayment.get(2).toLowerCase().contains(strCurrency.toLowerCase())&&arrPayment.get(2).toLowerCase().contains(strAmount.toLowerCase()))
				{
					Reporter.pass("Subscription Info for One Time Monthly", "Info :-  " + strCurrency+" " +strAmount+" is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for One Time Monthly", "Info :-  " + strCurrency+" " +strAmount+" is not displayed");
				}
			}
			else if(strPaymentethod.toLowerCase().equals("weekly vip"))
			{
				String strVerifyText="Weekly VIP Subscription";
				if(arrPayment.get(0).toLowerCase().contains(strVerifyText.toLowerCase()))
				{
					Reporter.pass("Subscription Info for Weekly VIP", "Info :- Weekly VIP Subscription is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for Weekly VIP", "Info :- Weekly VIP Subscription is not displayed");
				}
				strVerifyText="Charged upfront, non-refundable";
				if(arrPayment.get(1).toLowerCase().contains(strVerifyText.toLowerCase()))
				{
					Reporter.pass("Subscription Info for Weekly VIP", "Info :- Charged upfront, non-refundable is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for Weekly VIP", "Info :- Charged upfront, non-refundable is not displayed");
				}
				if(arrPayment.get(2).toLowerCase().contains(strCurrency.toLowerCase())&&arrPayment.get(2).toLowerCase().contains(strAmount.toLowerCase()))
				{
					Reporter.pass("Subscription Info for Weekly VIP", "Info :-  " + strCurrency+" " +strAmount+" is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for Weekly VIP", "Info :-  " + strCurrency+" " +strAmount+" is not displayed");
				}
			}
			else if(strPaymentethod.toLowerCase().equals("1 day"))
			{
				String strVerifyText="1 Day, One Time VIP Pass";
				if(arrPayment.get(0).toLowerCase().contains(strVerifyText.toLowerCase()))
				{
					Reporter.pass("Subscription Info for Weekly VIP", "Info :- Weekly VIP Subscription is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for Weekly VIP", "Info :- Weekly VIP Subscription is not displayed");
				}
				strVerifyText="Charged upfront, non-refundable";
				if(arrPayment.get(1).toLowerCase().contains(strVerifyText.toLowerCase()))
				{
					Reporter.pass("Subscription Info for Weekly VIP", "Info :- Charged upfront, non-refundable is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for Weekly VIP", "Info :- Charged upfront, non-refundable is not displayed");
				}
				if(arrPayment.get(2).toLowerCase().contains(strCurrency.toLowerCase())&&arrPayment.get(2).toLowerCase().contains(strAmount.toLowerCase()))
				{
					Reporter.pass("Subscription Info for Weekly VIP", "Info :-  " + strCurrency+" " +strAmount+" is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for Weekly VIP", "Info :-  " + strCurrency+" " +strAmount+" is not displayed");
				}
			}
		}
		catch(Exception e){Reporter.blnReportTempStatus=false;}
		Thread.sleep(10000);
		return Reporter.blnReportTempStatus;
	}
	
	public boolean fnVerifyPlanInfoID(String strPaymentethod) throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		mePage.fnSelectMESection("subscription");
		click(subscribeNow,"Subscribe Now");
		Thread.sleep(10000);
		List<String> arrPlan=new ArrayList<String>();
		List<Payment> objPayment=null;
		Reporter.info("Subscription Info Verification" , "Verify Subscription Info for " + strPaymentethod);
		try
		{
			int intCount=0;
			if(strPaymentethod.toLowerCase().equals("Langganan VIP Bulanan".toLowerCase()))
			{
				objPayment=fnGetPlanMethod("Android", "Subscription","Langganan VIP Bulanan");				
			}
			else if(strPaymentethod.toLowerCase().equals("Berlangganan VIP 1 Tahun".toLowerCase()))
			{
				objPayment=fnGetPlanMethod("Android", "Subscription","Berlangganan VIP 1 Tahun");	
				intCount=4;
			}		
			else if(strPaymentethod.toLowerCase().equals("1 Bulan Akses VIP".toLowerCase()))
			{
				objPayment=fnGetPlanMethod("Android", "Subscription","1 Bulan Akses VIP");	
				intCount=14;
			}
			for(int i=0;i<objPayment.size();i++)
			{
				System.out.println(objPayment.get(i).strPlanMethod);
				arrPlan=fnAddData(arrPlan,objPayment.get(i).strPlanMethod);
			}
			String strCurrency=objPayment.get(0).strCountry;
			String strAmount=objPayment.get(0).strPrice;
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<WebElement> elePaymentList=elePayment1.get(0).findElements(By.className("android.widget.ListView"));
			System.out.println(elePaymentList.size());
			List<WebElement> eleViewPayment=elePaymentList.get(0).findElements(By.className("android.view.View"));
			System.out.println(eleViewPayment.size());
			List<WebElement> eleViewTest=eleViewPayment.get(intCount).findElements(By.className("android.view.View"));
			List<WebElement> elePaymentText=eleViewTest.get(0).findElements(By.className("android.view.View"));
			System.out.println(elePaymentText.size());
			List<String> arrPayment=new ArrayList<String>();
			for(int j=0;j<elePaymentText.size();j++)
			{
				System.out.println(elePaymentText.get(j).getText());
				String strText=elePaymentText.get(j).getText();
				if(strText.length()>0)
				{
					arrPayment=fnAddData(arrPayment,strText);
				}
			}
			for(int i=0;i<arrPayment.size();i++)
			{
				System.out.println(arrPayment.get(i));
			}
			if(strPaymentethod.toLowerCase().contains("Langganan VIP Bulanan".toLowerCase()))
			{
				String strVerifyText="Langganan VIP Bulanan";
				if(fnVerifyTextInList(arrPayment, strVerifyText))
				{
					Reporter.pass("Subscription Info for Monthly VIP", "Info :- Langganan VIP Bulanan is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for Monthly VIP", "Info :- Langganan VIP Bulanan is not displayed");
				}
				strVerifyText="Dikenakan biaya bulanan, batalkan kapan saja";
				if(fnVerifyTextInList(arrPayment,strVerifyText))
				{
					Reporter.pass("Subscription Info for Monthly VIP", "Info :- Dikenakan biaya bulanan, batalkan kapan saja  is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for Monthly VIP", "Info :- Dikenakan biaya bulanan, batalkan kapan saja is not displayed");
				}
				if(fnVerifyTextInList(arrPayment,strCurrency)&& fnVerifyTextInList(arrPayment,strAmount))
				{
					Reporter.pass("Subscription Info for Monthly VIP", "Info :-  " + strCurrency+" " +strAmount+" is displayed");					
				}
				else
				{
					Reporter.fail("Subscription Info for Monthly VIP", "Info :-  " + strCurrency+" " +strAmount+" is not displayed");
				}
			}
			else if(strPaymentethod.toLowerCase().equals("Berlangganan VIP 1 Tahun".toLowerCase()))
			{
				String strVerifyText="Berlangganan VIP 1 Tahun";
				if(fnVerifyTextInList(arrPayment, strVerifyText))
				{
					Reporter.pass("Subscription Info for VIP 1 year subscription", "Info :- Berlangganan VIP 1 Tahun is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for VIP 1 year subscription", "Info :- Berlangganan VIP 1 Tahun is not displayed");
				}
				strVerifyText="Dikenakan tahunan, tidak dapat diuangkan kembali";
				if(fnVerifyTextInList(arrPayment,strVerifyText))
				{
					Reporter.pass("Subscription Info for VIP 1 year subscription", "Info :- Dikenakan tahunan, tidak dapat diuangkan kembali  is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for VIP 1 year subscription", "Info :- Dikenakan tahunan, tidak dapat diuangkan kembali is not displayed");
				}
				if(fnVerifyTextInList(arrPayment,strCurrency)&& fnVerifyTextInList(arrPayment,strAmount))
				{
					Reporter.pass("Subscription Info for VIP 1 year subscription", "Info :-  " + strCurrency+" " +strAmount+" is displayed");					
				}
				else
				{
					Reporter.fail("Subscription Info for VIP 1 year subscription", "Info :-  " + strCurrency+" " +strAmount+" is not displayed");
				}			
			}
			else if(strPaymentethod.toLowerCase().equals("1 Bulan Akses VIP".toLowerCase()))
			{
				String strVerifyText="1 Bulan Akses VIP";
				if(fnVerifyTextInList(arrPayment, strVerifyText))
				{
					Reporter.pass("Subscription Info for 1 Month VIP Access subscription", "Info :- Berlangganan VIP 1 Tahun is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for 1 Month VIP Access subscription", "Info :- Berlangganan VIP 1 Tahun is not displayed");
				}
				strVerifyText="Dikenakan dimuka, tidak dapat diuangkan kembali";
				if(fnVerifyTextInList(arrPayment,strVerifyText))
				{
					Reporter.pass("Subscription Info for 1 Month VIP Access subscription", "Info :- Dikenakan tahunan, tidak dapat diuangkan kembali  is displayed");
				}
				else
				{
					Reporter.fail("Subscription Info for 1 Month VIP Access subscription", "Info :- Dikenakan tahunan, tidak dapat diuangkan kembali is not displayed");
				}
				if(fnVerifyTextInList(arrPayment,strCurrency)&& fnVerifyTextInList(arrPayment,strAmount))
				{
					Reporter.pass("Subscription Info for 1 Month VIP Access subscription", "Info :-  " + strCurrency+" " +strAmount+" is displayed");					
				}
				else
				{
					Reporter.fail("Subscription Info for 1 Month VIP Access subscription", "Info :-  " + strCurrency+" " +strAmount+" is not displayed");
				}	
			}			
		}
		catch(Exception e){Reporter.blnReportTempStatus=false;}
		Thread.sleep(10000);
		return Reporter.blnReportTempStatus;
	}
	
	public boolean fnVerifyPlanInfoTH(String strPaymentethod) throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		mePage.fnSelectMESection("subscription");
		click(subscribeNow,"Subscribe Now");
		Thread.sleep(10000);
		swipeUpOrBottom(true);
		List<WebElement> eleList=driver.findElements(seeMore);
		System.out.println(eleList.size());
		if(eleList.size()>0)
		{
			eleList.get(0).click();
		}
		Thread.sleep(5000);
		List<String> arrPlan=new ArrayList<String>();
		List<Payment> objPayment=null;
		Reporter.info("Subscription Info Verification" , "Verify Subscription Info for " + strPaymentethod);
		try
		{
			int intCount=0;
			if(strPaymentethod.toLowerCase().equals("Monthly".toLowerCase()))
			{
				objPayment=fnGetPlanMethod("Android", "Subscription","Monthly");				
			}
			else if(strPaymentethod.toLowerCase().equals("1 Year".toLowerCase()))
			{
				objPayment=fnGetPlanMethod("Android", "Subscription","1 Year");	
				intCount=4;
			}		
			else if(strPaymentethod.toLowerCase().equals("Weekly".toLowerCase()))
			{
				objPayment=fnGetPlanMethod("Android", "Subscription","Weekly");	
				intCount=14;
			}
			for(int i=0;i<objPayment.size();i++)
			{
				System.out.println(objPayment.get(i).strPlanMethod);
				arrPlan=fnAddData(arrPlan,objPayment.get(i).strPlanMethod);
			}
			String strCurrency=objPayment.get(0).strCountry;
			String strAmount=objPayment.get(0).strPrice;
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<WebElement> elePaymentList=elePayment1.get(0).findElements(By.className("android.widget.ListView"));
			System.out.println(elePaymentList.size());
			List<WebElement> eleViewPayment=elePaymentList.get(0).findElements(By.className("android.view.View"));
			System.out.println(eleViewPayment.size());
			List<WebElement> eleViewTest=eleViewPayment.get(intCount).findElements(By.className("android.view.View"));
			List<WebElement> elePaymentText=eleViewTest.get(0).findElements(By.className("android.view.View"));
			System.out.println(elePaymentText.size());
			List<String> arrPayment=new ArrayList<String>();
			for(int j=0;j<elePaymentText.size();j++)
			{
				System.out.println(elePaymentText.get(j).getText());
				String strText=elePaymentText.get(j).getText();
				if(strText.length()>0)
				{
					arrPayment=fnAddData(arrPayment,strText);
				}
			}
			for(int i=0;i<arrPayment.size();i++)
			{
				System.out.println(arrPayment.get(i));
			}
			if(strPaymentethod.toLowerCase().contains("1 Year".toLowerCase()))
			{
				if(fnVerifyTextInList(arrPayment,strCurrency))
				{
					Reporter.pass("Subscription Info for 1 Year", "Info :-  " + strCurrency+" " +strAmount+" is displayed");					
				}
				else
				{
					Reporter.fail("Subscription Info for 1 Year", "Info :-  " + strCurrency+" " +strAmount+" is not displayed");
				}
			}
			else if(strPaymentethod.toLowerCase().equals("Monthly".toLowerCase()))
			{
				if(fnVerifyTextInList(arrPayment,strCurrency))
				{
					Reporter.pass("Subscription Info for Monthly subscription", "Info :-  " + strCurrency+" " +strAmount+" is displayed");					
				}
				else
				{
					Reporter.fail("Subscription Info for Monthly subscription", "Info :-  " + strCurrency+" " +strAmount+" is not displayed");
				}			
			}
			else if(strPaymentethod.toLowerCase().equals("Weekly".toLowerCase()))
			{
				if(fnVerifyTextInList(arrPayment,strCurrency)&& fnVerifyTextInList(arrPayment,strAmount))
				{
					Reporter.pass("Subscription Info for Weekly Access subscription", "Info :-  " + strCurrency+" " +strAmount+" is displayed");					
				}
				else
				{
					Reporter.fail("Subscription Info for Weekly Access subscription", "Info :-  " + strCurrency+" " +strAmount+" is not displayed");
				}	
			}			
		}
		catch(Exception e){Reporter.blnReportTempStatus=false;}
		Thread.sleep(10000);
		return Reporter.blnReportTempStatus;
	}
	
	
	
	
	
	public boolean fnVerifyPaymentMethodSG(String strPaymentethod,List<String> arrData)
	{
		Reporter.blnReportTempStatus=true;
		Reporter.info("Subscription Info Verification", "Verify Subscription Payment Method Info for " + strPaymentethod);
		try
		{
			int intCount=0;
			if(strPaymentethod.toLowerCase().contains("yearly"))
			{
				intCount=4;
			}	
			
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<WebElement> elePaymentList=elePayment1.get(0).findElements(By.className("android.widget.ListView"));
			System.out.println(elePaymentList.size());
			List<WebElement> eleViewPayment=elePaymentList.get(0).findElements(By.className("android.view.View"));
			System.out.println(eleViewPayment.size());
			List<WebElement> eleViewTest=eleViewPayment.get(intCount).findElements(By.className("android.view.View"));
			//Find Payment Image
			List<WebElement> elePaymentMethod=eleViewTest.get(0).findElements(By.className("android.widget.Image"));
			System.out.println(elePaymentMethod.size());
			List<String> arrPayment=new ArrayList<String>();
			for(int j=0;j<elePaymentMethod.size();j++)
			{
				System.out.println(elePaymentMethod.get(j).getText());
				String strText=elePaymentMethod.get(j).getText();
				if(strText.toLowerCase().contains("icon_tick_new")==false)
				{
					arrPayment=fnAddData(arrPayment,strText);
				}
			}
			for(int i=0;i<arrData.size();i++)
			{
				System.out.println(arrPayment.get(i).toLowerCase().trim().replaceAll(" ", ""));
				System.out.println(arrData.get(i).toLowerCase().trim());
				if(arrPayment.get(i).toLowerCase().trim().replaceAll(" ", "").contains(arrData.get(i).toLowerCase().trim().replaceAll(" ", "")))
				{
					Reporter.pass("Subscription Payment Method Verification","Payment Method : " + arrData.get(i) +" is displayed");
				}
				else
				{
					Reporter.fail("Subscription Payment Method Verification","Payment Method : " + arrData.get(i) +" is not displayed");
				}
			}
			
		}
		catch(Exception e){Reporter.blnReportTempStatus=false;}
		return Reporter.blnReportTempStatus;
	}
	
	public boolean fnVerifyPaymentMethodPH(String strPaymentethod,List<String> arrData)
	{
		Reporter.blnReportTempStatus=true;
		Reporter.info("Subscription Info Verification", "Verify Subscription Payment Method Info for " + strPaymentethod);
		try
		{
			String strXPath=".//android.widget.ListView[1]/android.view.View[@index='4']";
			List<WebElement> elePaymentList=driver.findElements(By.xpath(strXPath));
			System.out.println(elePaymentList.size());
			List<WebElement> ele1=elePaymentList.get(0).findElements(By.className("android.view.View"));
			System.out.println(ele1.size());
			List<WebElement> ele2=ele1.get(0).findElements(By.className("android.view.View"));
			System.out.println(ele2.size());
			for(int i=0;i<ele2.size();i++)
			{
				System.out.println(ele2.get(i).getText());
			}
			
			
			List<WebElement> eleImg=ele2.get(2).findElements(By.className("android.widget.Image"));
			System.out.println(eleImg.size());
			
			
			
			
			
			
			
			
			
			
			
			
			/*int intCount=0;
			if(strPaymentethod.toLowerCase().contains("yearly"))
			{
				intCount=4;
			}	
			
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<WebElement> elePaymentList=elePayment1.get(0).findElements(By.className("android.widget.ListView"));
			System.out.println(elePaymentList.size());
			List<WebElement> eleViewPayment=elePaymentList.get(0).findElements(By.className("android.view.View"));
			System.out.println(eleViewPayment.size());
			for(int i=0;i<eleViewPayment.size();i++)
			{
				System.out.println("i==> " + i + eleViewPayment.get(i).getText());
			} 
			intCount=14;
			
			
			
			
			
			List<WebElement> eleViewTest=eleViewPayment.get(intCount).findElements(By.className("android.view.View"));
			System.out.println(eleViewTest.get(0).getText());
			//Find Payment Image
			List<WebElement> elePaymentMethod=eleViewTest.get(0).findElements(By.className("android.widget.Image"));
			System.out.println(elePaymentMethod.size());
			List<String> arrPayment=new ArrayList<String>();
			for(int j=0;j<elePaymentMethod.size();j++)
			{
				System.out.println(elePaymentMethod.get(j).getText());
				String strText=elePaymentMethod.get(j).getText();
				if(strText.toLowerCase().contains("icon_tick_new")==false)
				{
					arrPayment=fnAddData(arrPayment,strText);
				}
			}
			for(int i=0;i<arrPayment.size();i++)
			{
				System.out.println(arrPayment.get(i));
			}
			
			
			
			for(int i=0;i<arrData.size();i++)
			{
				System.out.println(arrPayment.get(i).toLowerCase().trim().replaceAll(" ", ""));
				System.out.println(arrData.get(i).toLowerCase().trim());
				if(arrPayment.get(i).toLowerCase().trim().replaceAll(" ", "").contains(arrData.get(i).toLowerCase().trim().replaceAll(" ", "")))
				{
					Reporter.pass("Subscription Payment Method Verification","Payment Method : " + arrData.get(i) +" is displayed");
				}
				else
				{
					Reporter.fail("Subscription Payment Method Verification","Payment Method : " + arrData.get(i) +" is not displayed");
				}
			}*/
			
		}
		catch(Exception e){
			e.printStackTrace();Reporter.blnReportTempStatus=false;}
		return Reporter.blnReportTempStatus;
	}
	
	
	public boolean fnVerifyPlanSG(String strPlanType,String strPaymentMethod) throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		List<String> arrPlan=new ArrayList<String>();
		List<Payment> objPayment=null;
		try
		{
			if(strPlanType.toLowerCase().contains("yearly"))
			{
				objPayment=fnGetPlanMethod("Android", "Subscription","1 Year");		
			}
			else if(strPlanType.toLowerCase().contains("monthly"))
			{
				objPayment=fnGetPlanMethod("Android", "Subscription","monthly");		
			}
			for(int i=0;i<objPayment.size();i++)
			{
				System.out.println(objPayment.get(i).strPlanMethod);
				arrPlan=fnAddData(arrPlan,objPayment.get(i).strPlanMethod);
			}
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<WebElement> elePaymentList=elePayment1.get(0).findElements(By.className("android.widget.ListView"));
			System.out.println(elePaymentList.size());
			List<WebElement> eleViewPayment=elePaymentList.get(0).findElements(By.className("android.view.View"));
			System.out.println(eleViewPayment.size());
			//Find Payment Image
			List<WebElement> elePaymentMethod=elePaymentList.get(0).findElements(By.className("android.widget.Image"));
			System.out.println(elePaymentMethod.size());
			List<String> arrPayment=new ArrayList<String>();
			for(int j=0;j<elePaymentMethod.size();j++)
			{
				System.out.println(elePaymentMethod.get(j).getText());
				String strText=elePaymentMethod.get(j).getText();
				if(strText.contains("HOOQ logo")==false)
				{
					arrPayment=fnAddData(arrPayment,strText);
				}
			}
			for(int i=0;i<arrPlan.size();i++)
			{
				System.out.println(arrPayment.get(i).toLowerCase().trim().replaceAll(" ", ""));
				System.out.println(arrPlan.get(i).toLowerCase().trim());
				if(arrPayment.get(i).toLowerCase().trim().replaceAll(" ", "").contains(arrPlan.get(i).toLowerCase().trim().replaceAll(" ", "")))
				{
					Reporter.pass("Subscription Payment Method Verification","Payment Method : " + arrPlan.get(i) +" is displayed");
				}
				else
				{
					Reporter.fail("Subscription Payment Method Verification","Payment Method : " + arrPlan.get(i) +" is not displayed");
				}
			}
			for(int j=0;j<elePaymentMethod.size();j++)
			{
				System.out.println(elePaymentMethod.get(j).getText());
				String strText=elePaymentMethod.get(j).getText();
				if(strText.toLowerCase().contains(strPaymentMethod.toLowerCase()))
				{
					elePaymentMethod.get(j).click();
					Reporter.pass("Subscription Payment Method Verification","Payment Method : " + strPaymentMethod +" is Selected");
					break;
				}
			}
			
		}
		catch(Exception e){	Reporter.blnReportTempStatus=false;}
		Thread.sleep(10000);
		if(strPaymentMethod.toLowerCase().contains("credit") && strPlanType.toLowerCase().contains("yearly"))
		{
			boolean blnCreditCard=fnVerifyCreditDebitCard("Credit",objPayment.get(0).strCountry,objPayment.get(0).strPrice,"Yearly","ON",true);
			System.out.println(blnCreditCard);
		}
		else if(strPaymentMethod.toLowerCase().contains("google") && strPlanType.toLowerCase().contains("yearly"))
		{
			boolean blnCreditCard=fnVerifyGooglePlay("yearly",objPayment.get(0).strPrice,objPayment.get(0).strCountry);
			System.out.println(blnCreditCard);
		}
		else if(strPaymentMethod.toLowerCase().contains("credit") && strPlanType.toLowerCase().contains("monthly"))
		{
			boolean blnCreditCard=fnVerifyCreditDebitCard("Credit",objPayment.get(0).strCountry,"0.00","Monthly","ON",true);
			System.out.println(blnCreditCard);
		}
		else if(strPaymentMethod.toLowerCase().contains("google") && strPlanType.toLowerCase().contains("monthly"))
		{
			boolean blnCreditCard=fnVerifyGooglePlay("monthly",objPayment.get(0).strPrice,objPayment.get(0).strCountry);
			System.out.println(blnCreditCard);
		}
		return Reporter.blnReportTempStatus;
	}
	
	public boolean fnVerifySmartPayment(String strPlan,String strCurrency,String strAmount) throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		try
		{
			Reporter.info("Verify Subscription Payment", "Subscription Payment Useing Smart Payment");
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<String> arrPayment=new ArrayList<String>();
			for(int j=0;j<elePayment1.size();j++)
			{
				System.out.println(elePayment1.get(j).getText());
				String strText=elePayment1.get(j).getText();
				System.out.println(strText.length());
				if(strText.replaceAll(" ", "").length()>2)
				{
					arrPayment=fnAddData(arrPayment,strText);
				}
			}
			for(int i=0;i<arrPayment.size();i++)
			{
				System.out.println(arrPayment.get(i));
			}
			String strText="";
			if(strPlan.toLowerCase().equals("monthly"))
			{
				strText="30 Days";
				if(fnVerifyTextInList(arrPayment,strText))
				{
					Reporter.pass("Subscription Payment Method Smart Verification","Label : " + strText +" is displayed");
				}
				else
				{
					Reporter.fail("Subscription Payment Method Smart Verification","Label : " + strText +" is not displayed");
				}
			}
			if(fnVerifyTextInList(arrPayment,strCurrency) && fnVerifyTextInList(arrPayment,strAmount))
			{
				Reporter.pass("Subscription Payment Method Smart Verification","Currency : " + strCurrency +" is displayed");
				Reporter.pass("Subscription Payment Method Smart Verification","Price : " + strAmount +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Smart Verification","Label : Currency and Price is not displayed");
				Reporter.fail("Subscription Payment Method Smart Verification","Label : Currency and Price : " + arrPayment.get(2) +" displayed");
			}
			if(strPlan.toLowerCase().equals("monthly"))
			{
				if(strCurrency.toLowerCase().equals("php"))
				{
					strText="Monthly VIP Subscription";
				}
			}
			if(strPlan.toLowerCase().equals("one time monthly"))
			{
				if(strCurrency.toLowerCase().equals("php"))
				{
					strText="OneTime Monthly VIP Subscription";
				}
			}
			if(strPlan.toLowerCase().equals("weekly vip"))
			{
				if(strCurrency.toLowerCase().equals("php"))
				{
					strText="Weekly VIP Subscription";
				}
			}
			if(strPlan.toLowerCase().equals("1 day"))
			{
				if(strCurrency.toLowerCase().equals("php"))
				{
					strText="1 Day, One Time VIP Pass";
				}
			}
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method Smart Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Smart Verification","Label : " + strText +" is not displayed");
			}
			List<WebElement> elePaymentButton=elePayment.findElements(By.className("android.widget.Button"));
			System.out.println(elePaymentButton.size());
			System.out.println(elePaymentButton.get(0).getText());
			if(elePaymentButton.get(0).getText().toLowerCase().contains("continue"))
			{
				Reporter.pass("Subscription Payment Method Smart Verification","Button : Cancel is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Smart Verification","Button : Cancel is not displayed");
			}
			List<WebElement> elePaymentSpinner=elePayment.findElements(By.className("android.widget.Spinner"));
			System.out.println(elePaymentSpinner.size());
			if(elePaymentSpinner.size()>0)
			{
				Reporter.pass("Subscription Payment Method Smart Verification","Select Network ComboBox is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Smart Verification","Select Network ComboBox is not displayed");
			}
			List<WebElement> elePaymentMobileNo=elePayment.findElements(By.className("android.widget.EditText"));
			System.out.println(elePaymentMobileNo.size());
			if(elePaymentMobileNo.size()>0)
			{
				Reporter.pass("Subscription Payment Method Smart Verification","Mobile Number Field is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Smart Verification","Mobile Number Field is not displayed");
			}
			driver.navigate().back();
			Thread.sleep(5000);
			driver.navigate().back();
			Thread.sleep(5000);
			driver.navigate().back();
			Thread.sleep(5000);
			if(isElementDisplayed(subscribeNow))
			{
				Reporter.pass("Smart Payment Cancel","Subscribe Now Button is Displayed");	
				driver.navigate().back();
			}
			else
			{
				Reporter.fail("Smart Payment Cancel","Subscribe Now Button is not Displayed");
			}
		}
		catch(Exception e){	Reporter.blnReportTempStatus=false;}
		Thread.sleep(10000);
		return Reporter.blnReportTempStatus;
	}
	
	
	public boolean fnVerifyGlobePayment(String strPlan,String strCurrency,String strAmount,String strAutoRenew) throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		try
		{
			Reporter.info("Verify Subscription Payment", "Subscription Payment Useing Globe Payment");
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<String> arrPayment=new ArrayList<String>();
			for(int j=0;j<elePayment1.size();j++)
			{
				System.out.println(elePayment1.get(j).getText());
				String strText=elePayment1.get(j).getText();
				System.out.println(strText.length());
				if(strText.replaceAll(" ", "").length()>2)
				{
					arrPayment=fnAddData(arrPayment,strText);
				}
			}
			for(int i=0;i<arrPayment.size();i++)
			{
				System.out.println(arrPayment.get(i));
			}
			String strText="";
			if(strPlan.toLowerCase().equals("one time monthly"))
			{
				strText="30 Days HOOQ All Access";
			}
			else if(strPlan.toLowerCase().equals("weekly vip"))
			{
				strText="7 Days HOOQ All Access";
				
			}
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method Globe Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Globe Verification","Label : " + strText +" is not displayed");
			}
			if(fnVerifyTextInList(arrPayment,strCurrency) && fnVerifyTextInList(arrPayment,strAmount))
			{
				Reporter.pass("Subscription Payment Method Globe Verification","Currency : " + strCurrency +" is displayed");
				Reporter.pass("Subscription Payment Method Globe Verification","Price : " + strAmount +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Globe Verification","Label : Currency and Price is not displayed");
				Reporter.fail("Subscription Payment Method Globe Verification","Label : Currency and Price : " + arrPayment.get(2) +" displayed");
			}
			if(strAutoRenew.toLowerCase().contains("on"))
			{
				strText="Auto-renew: ON";
			}
			else
			{
				strText="Auto-renew: OFF";
			}
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method Globe Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Globe Verification","Label : " + strText +" is not displayed");
			}
			List<WebElement> elePaymentEdit=elePayment.findElements(By.className("android.widget.EditText"));
			System.out.println(elePaymentEdit.size());
			if(elePaymentEdit.size()>0)
			{
				Reporter.pass("Subscription Payment Method Globe Verification","Mobile Number Field is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Globe Verification","Mobile Number Field is not displayed");
			}
			List<WebElement> elePaymentButton=elePayment.findElements(By.className("android.widget.Button"));
			System.out.println(elePaymentButton.size());
			System.out.println(elePaymentButton.get(0).getText());
			if(elePaymentButton.get(0).getText().toLowerCase().contains("cancel"))
			{
				Reporter.pass("Subscription Payment Method Globe Verification","Button : Cancel is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Globe Verification","Button : Cancel is not displayed");
			}
			System.out.println(elePaymentButton.get(1).getText());
			if(elePaymentButton.get(1).getText().toLowerCase().contains("make payment"))
			{
				Reporter.pass("Subscription Payment Method Globe Verification","Button : Make Payment is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Globe Verification","Button : Make Payment is not displayed");
			}
			elePaymentButton.get(0).click();
			Thread.sleep(5000);
			List<WebElement> elePaymentCancel=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePaymentCancel.size());
			if(elePaymentCancel.get(1).getText().toLowerCase().contains("payment cancelled"))
			{
				Reporter.pass("Globe Payment Cancel","Info Payment Cancelled is Displayed");
			}
			else
			{
				Reporter.fail("Globe Payment Cancel","Info Payment Cancelled is not Displayed");
			}
			if(elePaymentCancel.get(3).getText().toLowerCase().contains("done"))
			{
				Reporter.pass("Globe Card Payment Cancel","Done Button is Displayed");					
			}
			else
			{
				Reporter.fail("Globe Payment Cancel","Done Button is not Displayed");
			}
			elePaymentCancel.get(3).click();
			Thread.sleep(5000);
			if(isElementDisplayed(subscribeNow))
			{
				Reporter.pass("Globe Payment Cancel","Subscribe Now Button is Displayed");	
				driver.navigate().back();
			}
			else
			{
				Reporter.fail("Globe Payment Cancel","Subscribe Now Button is not Displayed");
			}
			
		}
		catch(Exception e){	Reporter.blnReportTempStatus=false;}
		Thread.sleep(10000);
		return Reporter.blnReportTempStatus;
	}
	
	
	public boolean fnVerifyGCashPayment(String strCurrency,String strAmount) throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		try
		{
			Reporter.info("Verify Subscription Payment", "Subscription Payment Useing GCash Payment");
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<String> arrPayment=new ArrayList<String>();
			for(int j=0;j<elePayment1.size();j++)
			{
				System.out.println(elePayment1.get(j).getText());
				String strText=elePayment1.get(j).getText();
				System.out.println(strText.length());
				if(strText.replaceAll(" ", "").length()>2)
				{
					arrPayment=fnAddData(arrPayment,strText);
				}
			}
			for(int i=0;i<arrPayment.size();i++)
			{
				System.out.println(arrPayment.get(i));
			}
			String strText="Merchant";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method GCash Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method GCash Verification","Label : " + strText +" is not displayed");
			}
			strText="HOOQ DIGITAL PTE LTD";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method GCash Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method GCash Verification","Label : " + strText +" is not displayed");
			}
			strText="Amount Due";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method GCash Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method GCash Verification","Label : " + strText +" is not displayed");
			}
			if(fnVerifyTextInList(arrPayment,strCurrency) && fnVerifyTextInList(arrPayment,strAmount))
			{
				Reporter.pass("Subscription Payment Method GCash Verification","Currency : " + strCurrency +" is displayed");
				Reporter.pass("Subscription Payment Method GCash Verification","Price : " + strAmount +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method GCash Verification","Label : Currency and Price is not displayed");
				Reporter.fail("Subscription Payment Method GCash Verification","Label : Currency and Price : " + arrPayment.get(2) +" displayed");
			}
			strText="Login to pay with GCash";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method GCash Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method GCash Verification","Label : " + strText +" is not displayed");
			}
			strText="Input your Mobile number";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method GCash Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method GCash Verification","Label : " + strText +" is not displayed");
			}
			if(strCurrency.toLowerCase().contains("php"))
			{
				strText="+63";
			}
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method GCash Verification","Country Code Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method GCash Verification","Country Code Label : " + strText +" is not displayed");
			}
			strText="Mobile number";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method GCash Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method GCash Verification","Label : " + strText +" is not displayed");
			}
			strText="Create an account";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method GCash Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method GCash Verification","Label : " + strText +" is not displayed");
			}
			List<WebElement> elePaymentEdit=elePayment.findElements(By.className("android.widget.EditText"));
			System.out.println(elePaymentEdit.size());
			if(elePaymentEdit.size()>0)
			{
				Reporter.pass("Subscription Payment Method GCash Verification","Mobile Number Field is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method GCash Verification","Mobile Number Field is not displayed");
			}
			List<WebElement> elePaymentButton=elePayment.findElements(By.className("android.widget.Button"));
			System.out.println(elePaymentButton.size());
			System.out.println(elePaymentButton.get(0).getText());
			if(elePaymentButton.get(0).getText().toLowerCase().contains("next"))
			{
				Reporter.pass("Subscription Payment Method Globe Verification","Button : NEXT is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Globe Verification","Button : NEXT is not displayed");
			}
		}
		catch(Exception e){	Reporter.blnReportTempStatus=false;}
		Thread.sleep(10000);
		return Reporter.blnReportTempStatus;
	}
	
	
	public boolean fnVerifyZGoldPayment(String strCurrency,String strAmount) throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		try
		{
			Reporter.info("Verify Subscription Payment", "Subscription Payment Useing ZGold Payment");
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<String> arrPayment=new ArrayList<String>();
			for(int j=0;j<elePayment1.size();j++)
			{
				System.out.println(elePayment1.get(j).getText());
				String strText=elePayment1.get(j).getText();
				System.out.println(strText.length());
				if(strText.replaceAll(" ", "").length()>2)
				{
					arrPayment=fnAddData(arrPayment,strText);
				}
			}
			for(int i=0;i<arrPayment.size();i++)
			{
				System.out.println(arrPayment.get(i));
			}
			String strText="1 e-WALLET";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method ZGold Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method ZGold Verification","Label : " + strText +" is not displayed");
			}
			strText="Email";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method ZGold Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method ZGold Verification","Label : " + strText +" is not displayed");
			}
			strText="Password";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method ZGold Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method ZGold Verification","Label : " + strText +" is not displayed");
			}
			if(fnVerifyTextInList(arrPayment,strCurrency) && fnVerifyTextInList(arrPayment,strAmount))
			{
				Reporter.pass("Subscription Payment Method ZGold Verification","Currency : " + strCurrency +" is displayed");
				Reporter.pass("Subscription Payment Method ZGold Verification","Price : " + strAmount +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method ZGold Verification","Label : Currency and Price is not displayed");
				Reporter.fail("Subscription Payment Method ZGold Verification","Label : Currency and Price : " + arrPayment.get(2) +" displayed");
			}
			strText="Forgot password?";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method ZGold Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method ZGold Verification","Label : " + strText +" is not displayed");
			}
			List<WebElement> elePaymentEdit=elePayment.findElements(By.className("android.widget.EditText"));
			System.out.println(elePaymentEdit.size());
			if(elePaymentEdit.size()==2)
			{
				Reporter.pass("Subscription Payment Method ZGold Verification","Email Field is displayed");
				Reporter.pass("Subscription Payment Method ZGold Verification","Password Field is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method ZGold Verification","Mobile Number Field is not displayed");
			}
			List<WebElement> elePaymentButton=elePayment.findElements(By.className("android.widget.Button"));
			System.out.println(elePaymentButton.size());
			System.out.println(elePaymentButton.get(0).getText());
			System.out.println(elePaymentButton.get(1).getText());
			if(elePaymentButton.get(2).getText().toLowerCase().contains("sign in"))
			{
				Reporter.pass("Subscription Payment Method ZGold Verification","Button : SIGN IN is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method ZGold Verification","Button : SIGN IN is not displayed");
			}
			driver.navigate().back();
			Thread.sleep(5000);
			driver.navigate().back();
			Thread.sleep(5000);
			driver.navigate().back();
			Thread.sleep(5000);
			if(isElementDisplayed(subscribeNow))
			{
				Reporter.pass("ZGold Payment Cancel","Subscribe Now Button is Displayed");	
				driver.navigate().back();
			}
			else
			{
				Reporter.fail("ZGold Payment Cancel","Subscribe Now Button is not Displayed");
			}
		}
		catch(Exception e){	Reporter.blnReportTempStatus=false;}
		Thread.sleep(10000);
		return Reporter.blnReportTempStatus;
	}
	
	public boolean fnVerifyZGoldPaymentTH(String strAmount) throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		try
		{
			Reporter.info("Verify Subscription Payment", "Subscription Payment Useing ZGold Payment");
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<String> arrPayment=new ArrayList<String>();
			for(int j=0;j<elePayment1.size();j++)
			{
				System.out.println(elePayment1.get(j).getText());
				String strText=elePayment1.get(j).getText();
				System.out.println(strText.length());
				if(strText.replaceAll(" ", "").length()>2)
				{
					arrPayment=fnAddData(arrPayment,strText);
				}
			}
			for(int i=0;i<arrPayment.size();i++)
			{
				System.out.println(arrPayment.get(i));
			}
			String strText="Log In Razer ID";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method ZGold Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method ZGold Verification","Label : " + strText +" is not displayed");
			}
			strText="Payment amount";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method ZGold Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method ZGold Verification","Label : " + strText +" is not displayed");
			}
			strText="Razer.com";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method ZGold Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method ZGold Verification","Label : " + strText +" is not displayed");
			}
			if(fnVerifyTextInList(arrPayment,strAmount))
			{
				Reporter.pass("Subscription Payment Method ZGold Verification","Price : " + strAmount +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method ZGold Verification","Label : Currency and Price : " + arrPayment.get(2) +" displayed");
			}
			List<WebElement> elePaymentEdit=elePayment.findElements(By.className("android.widget.EditText"));
			System.out.println(elePaymentEdit.size());
			if(elePaymentEdit.size()==2)
			{
				Reporter.pass("Subscription Payment Method ZGold Verification","Email Field is displayed");
				Reporter.pass("Subscription Payment Method ZGold Verification","Password Field is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method ZGold Verification","Mobile Number Field is not displayed");
			}
			List<WebElement> elePaymentButton=elePayment.findElements(By.className("android.widget.Button"));
			System.out.println(elePaymentButton.size());
			System.out.println(elePaymentButton.get(0).getText());
			if(elePaymentButton.get(0).getText().toLowerCase().contains("sign in"))
			{
				Reporter.pass("Subscription Payment Method ZGold Verification","Button : SIGN IN is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method ZGold Verification","Button : SIGN IN is not displayed");
			}
			driver.navigate().back();
			Thread.sleep(5000);
			driver.navigate().back();
			Thread.sleep(5000);
			driver.navigate().back();
			Thread.sleep(5000);
			if(isElementDisplayed(subscribeNow))
			{
				Reporter.pass("ZGold Payment Cancel","Subscribe Now Button is Displayed");	
				driver.navigate().back();
			}
			else
			{
				Reporter.fail("ZGold Payment Cancel","Subscribe Now Button is not Displayed");
			}
		}
		catch(Exception e){	Reporter.blnReportTempStatus=false;}
		Thread.sleep(10000);
		return Reporter.blnReportTempStatus;
	}
	
	
	public boolean fnVerifyOVOPayment(String strPlan,String strCurrency,String strAmount,String strAutoRenew) throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		try
		{
			Reporter.info("Verify Subscription Payment", "Subscription Payment Useing OVO Payment");
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<String> arrPayment=new ArrayList<String>();
			for(int j=0;j<elePayment1.size();j++)
			{
				System.out.println(elePayment1.get(j).getText());
				String strText=elePayment1.get(j).getText();
				System.out.println(strText.length());
				if(strText.replaceAll(" ", "").length()>2)
				{
					arrPayment=fnAddData(arrPayment,strText);
				}
			}
			for(int i=0;i<arrPayment.size();i++)
			{
				System.out.println(arrPayment.get(i));
			}
			String strText="";
			if(strPlan.toLowerCase().equals("yearly"))
			{
				strText="365 Days HOOQ All Access";
			}
			else if(strPlan.toLowerCase().equals("monthly"))
			{
				strText="30 Days HOOQ All Access";
				
			}
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method OVO Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method OVO Verification","Label : " + strText +" is not displayed");
			}
			strText="Payment via OVO";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method OVO Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method OVO Verification","Label : " + strText +" is not displayed");
			}
			strText="Make sure you enter the mobile number registered in the OVO application";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method OVO Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method OVO Verification","Label : " + strText +" is not displayed");
			}
			strText="Mobile Number";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method OVO Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method OVO Verification","Label : " + strText +" is not displayed");
			}
			if(fnVerifyTextInList(arrPayment,strCurrency) && fnVerifyTextInList(arrPayment,strAmount))
			{
				Reporter.pass("Subscription Payment Method OVO Verification","Currency : " + strCurrency +" is displayed");
				Reporter.pass("Subscription Payment Method OVO Verification","Price : " + strAmount +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method OVO Verification","Label : Currency and Price is not displayed");
				Reporter.fail("Subscription Payment Method OVO Verification","Label : Currency and Price : " + arrPayment.get(2) +" displayed");
			}
			if(strAutoRenew.toLowerCase().contains("on"))
			{
				strText="Auto-renew: ON";
			}
			else
			{
				strText="Auto-renew: OFF";
			}
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method OVO Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method OVO Verification","Label : " + strText +" is not displayed");
			}
			List<WebElement> elePaymentEdit=elePayment.findElements(By.className("android.widget.EditText"));
			System.out.println(elePaymentEdit.size());
			if(elePaymentEdit.size()>0)
			{
				Reporter.pass("Subscription Payment Method OVO Verification","Mobile Number Field is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method OVO Verification","Mobile Number Field is not displayed");
			}
			List<WebElement> elePaymentButton=elePayment.findElements(By.className("android.widget.Button"));
			System.out.println(elePaymentButton.size());
			System.out.println(elePaymentButton.get(0).getText());
			if(elePaymentButton.get(0).getText().toLowerCase().contains("cancel"))
			{
				Reporter.pass("Subscription Payment Method OVO Verification","Button : Cancel is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method OVO Verification","Button : Cancel is not displayed");
			}
			System.out.println(elePaymentButton.get(1).getText());
			if(elePaymentButton.get(1).getText().toLowerCase().contains("make payment"))
			{
				Reporter.pass("Subscription Payment Method OVO Verification","Button : Make Payment is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method OVO Verification","Button : Make Payment is not displayed");
			}
			elePaymentButton.get(0).click();
			Thread.sleep(5000);
			List<WebElement> elePaymentCancel=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePaymentCancel.size());
			if(elePaymentCancel.get(1).getText().toLowerCase().contains("payment cancelled"))
			{
				Reporter.pass("OVO Payment Cancel","Info Payment Cancelled is Displayed");
			}
			else
			{
				Reporter.fail("OVO Payment Cancel","Info Payment Cancelled is not Displayed");
			}
			if(elePaymentCancel.get(3).getText().toLowerCase().contains("done"))
			{
				Reporter.pass("OVO Card Payment Cancel","Done Button is Displayed");					
			}
			else
			{
				Reporter.fail("OVO Payment Cancel","Done Button is not Displayed");
			}
			elePaymentCancel.get(3).click();
			Thread.sleep(5000);
			if(isElementDisplayed(subscribeNow))
			{
				Reporter.pass("OVO Payment Cancel","Subscribe Now Button is Displayed");	
				driver.navigate().back();
			}
			else
			{
				Reporter.fail("OVO Payment Cancel","Subscribe Now Button is not Displayed");
			}
			
		}
		catch(Exception e){	Reporter.blnReportTempStatus=false;}
		Thread.sleep(10000);
		return Reporter.blnReportTempStatus;
	}
	
	public boolean fnVerifyGoPayPayment(String strPlan,String strCurrency,String strAmount) throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		try
		{
			Reporter.info("Verify Subscription Payment", "Subscription Payment Useing GoPay Payment");
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<String> arrPayment=new ArrayList<String>();
			for(int j=0;j<elePayment1.size();j++)
			{
				System.out.println(elePayment1.get(j).getText());
				String strText=elePayment1.get(j).getText();
				System.out.println(strText.length());
				if(strText.replaceAll(" ", "").length()>2)
				{
					arrPayment=fnAddData(arrPayment,strText);
				}
			}
			for(int i=0;i<arrPayment.size();i++)
			{
				System.out.println(arrPayment.get(i));
			}
			String strText="HOOQ";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method GoPay Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method GoPay Verification","Label : " + strText +" is not displayed");
			}
			strText="Rincian Belanja";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method GoPay Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method GoPay Verification","Label : " + strText +" is not displayed");
			}
			if(fnVerifyTextInList(arrPayment,strAmount))
			{
				Reporter.pass("Subscription Payment Method GoPay Amount Verification","Amount : " + strAmount +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method GoPay Amount Verification","Amount : " + strAmount +" is not displayed");
			}
			strText="Rincian Belanja";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method GoPay Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method GoPay Verification","Label : " + strText +" is not displayed");
			}
			strText="jumlah";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method GoPay Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method GoPay Verification","Label : " + strText +" is not displayed");
			}
			strText="Order ID";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method GoPay Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method GoPay Verification","Label : " + strText +" is not displayed");
			}
			strText="Email";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method GoPay Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method GoPay Verification","Label : " + strText +" is not displayed");
			}
			strText="@";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method GoPay Verification","Email is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method GoPay Verification","Email is not displayed");
			}
			driver.navigate().back();
			Thread.sleep(5000);
			driver.navigate().back();
			Thread.sleep(5000);
			driver.navigate().back();
			Thread.sleep(5000);
			if(isElementDisplayed(subscribeNow))
			{
				Reporter.pass("GoPay Payment Cancel","Subscribe Now Button is Displayed");	
				driver.navigate().back();
			}
			else
			{
				Reporter.fail("GoPay Payment Cancel","Subscribe Now Button is not Displayed");
			}
			
		}
		catch(Exception e){	Reporter.blnReportTempStatus=false;}
		Thread.sleep(10000);
		return Reporter.blnReportTempStatus;
	}
	
	public boolean fnVerifyLineRabbitPayment() throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		try
		{
			Reporter.info("Verify Subscription Payment", "Subscription Payment Useing Rabbit LINE Pay Payment");
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<String> arrPayment=new ArrayList<String>();
			for(int j=0;j<elePayment1.size();j++)
			{
				System.out.println(elePayment1.get(j).getText());
				String strText=elePayment1.get(j).getText();
				System.out.println(strText.length());
				if(strText.replaceAll(" ", "").length()>2)
				{
					arrPayment=fnAddData(arrPayment,strText);
				}
			}
			for(int i=0;i<arrPayment.size();i++)
			{
				System.out.println(arrPayment.get(i));
			}
			String strText="Rabbit LINE Pay";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method Rabbit LINE Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Rabbit LINE Verification","Label : " + strText +" is not displayed");
			}
			strText="Log in using your LINE account or by scanning a QR code.";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method Rabbit LINE Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Rabbit LINE Verification","Label : " + strText +" is not displayed");
			}
			strText="LINE Log in";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method Rabbit LINE Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Rabbit LINE Verification","Label : " + strText +" is not displayed");
			}
			strText="Email address";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method Rabbit LINE Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Rabbit LINE Verification","Label : " + strText +" is not displayed");
			}
			strText="Password";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Subscription Payment Method Rabbit LINE Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Rabbit LINE Verification","Label : " + strText +" is not displayed");
			}
			List<WebElement> elePaymentEdit=elePayment.findElements(By.className("android.widget.EditText"));
			System.out.println(elePaymentEdit.size());
			if(elePaymentEdit.size()==2)
			{
				Reporter.pass("Subscription Payment Method Rabbit LINE Verification","Email Field is displayed");
				Reporter.pass("Subscription Payment Method Rabbit LINE Verification","Password Field is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Rabbit LINE Verification","Mobile Number Field is not displayed");
			}
			List<WebElement> elePaymentButton=elePayment.findElements(By.className("android.widget.Button"));
			System.out.println(elePaymentButton.size());
			System.out.println(elePaymentButton.get(0).getText());
			if(elePaymentButton.get(0).getText().toLowerCase().contains("log in"))
			{
				Reporter.pass("Subscription Payment Method Rabbit LINE Verification","Button : Log in is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method Rabbit LINE Verification","Button : Log in is not displayed");
			}
			driver.navigate().back();
			Thread.sleep(5000);
			driver.navigate().back();
			Thread.sleep(5000);
			driver.navigate().back();
			Thread.sleep(5000);
			if(isElementDisplayed(subscribeNow))
			{
				Reporter.pass("Rabbit LINE Payment Cancel","Subscribe Now Button is Displayed");	
				driver.navigate().back();
			}
			else
			{
				Reporter.fail("ZGold Payment Cancel","Subscribe Now Button is not Displayed");
			}
		}
		catch(Exception e){	Reporter.blnReportTempStatus=false;}
		Thread.sleep(10000);
		return Reporter.blnReportTempStatus;
	}
	
	public boolean fnVerifyRentPlan(String strPaymentMethod) throws Throwable
	{
		boolean blnStatuus=true;
		try
		{
			String strContentName=fnVerifyRentContentPaymentMethod();
			swipeUpOrBottom(true);
			fnSelectRentContentPaymentMethod(strPaymentMethod,strContentName);
			
			//boolean blnStatusSelectYearly=fnSelectPlaymentPlanTH(srPlanType);
		//	System.out.println(blnStatusSelectYearly);
		//	boolean blnStatusOneYearPayment=fnVerifyPlanTH(srPlanType,strPaymentMethod);
			//System.out.println(blnStatusOneYearPayment);
			driver.navigate().back();
			Thread.sleep(5000);
		}
		catch(Exception e){blnStatuus=false;}
		return blnStatuus;
	}
	
	public String fnVerifyRentContentPaymentMethod() throws Throwable
	{
		String strMovieName="";
		try
		{
			boolean blnStatusYearly=rentPage.fnVerifyRentSectionContentSelection();
			System.out.println(blnStatusYearly);	
			Thread.sleep(10000);
			strMovieName=getText(contentMovieName,"Rent Movie Title");
			if(strMovieName.length()>0)
			{
				Reporter.pass("Content Details Verification", "Content Rent Movie Title : " + strMovieName + " is displayed");
			}
			else
			{
				Reporter.fail("Content Details Verification", "Content Movie Title is not displayed");				
			}
			contentDetailsPage.fnVerifyTVODPrice();
			click(rentPageWatchNow,"Rent a Movie");
			Thread.sleep(10000);
			rentPage.fnVerifyRentMoviePopup(strMovieName, true);
			Thread.sleep(10000);
			String strPrice=rentPage.fnGetTVODPrice();
			fnVerifyRentContent(strMovieName,strPrice);
		}
		catch(Exception e){}
		return strMovieName;
	}
	
	public boolean fnSelectRentContentPaymentMethod(String strPaymentMethod,String strContentName) throws Throwable
	{
		boolean blnStatus=true;
		try
		{
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePaymentImag=elePayment.findElements(By.className("android.widget.Image"));
			System.out.println(elePaymentImag.size());
			List<String> arrPaymentImage=new ArrayList<String>();
			for(int j=2;j<elePaymentImag.size();j++)
			{
				System.out.println(elePaymentImag.get(j).getText());
				String strText=elePaymentImag.get(j).getText();
				System.out.println(strText.length());
				if(strText.replaceAll(" ", "").length()>2)
				{
					arrPaymentImage=fnAddData(arrPaymentImage,strText);
				}
			}
			for(int i=2;i<arrPaymentImage.size();i++)
			{
				System.out.println(arrPaymentImage.get(i));
			}
			if(arrPaymentImage.size()>2)
			{
				List<Payment> objPayment=fnGetPlanMethod("Android", "BTVOD","Rent Movie");	
				List<String> arrPlan=new ArrayList<String>();
				for(int i=0;i<objPayment.size();i++)
				{
					System.out.println(objPayment.get(i).strPlanMethod);
					arrPlan=fnAddData(arrPlan,objPayment.get(i).strPlanMethod);
				}
				for(int i=0;i<arrPlan.size();i++)
				{
					System.out.println(arrPaymentImage.get(i).toLowerCase().trim().replaceAll(" ", ""));
					System.out.println(arrPlan.get(i).toLowerCase().trim());
					if(arrPaymentImage.get(i).toLowerCase().trim().replaceAll(" ", "").contains(arrPlan.get(i).toLowerCase().trim().replaceAll(" ", "")))
					{
						Reporter.pass("Subscription Payment Method Verification For Renr","Payment Method : " + arrPlan.get(i) +" is displayed");
					}
					else
					{
						Reporter.fail("Subscription Payment Method Verification For Rent","Payment Method : " + arrPlan.get(i) +" is not displayed");
					}
				}
				for(int j=0;j<elePaymentImag.size();j++)
				{
					System.out.println(elePaymentImag.get(j).getText());
					String strText=elePaymentImag.get(j).getText();
					if(strText.toLowerCase().contains(strPaymentMethod.toLowerCase()))
					{
						elePaymentImag.get(j).click();
						Reporter.pass("Rent Payment Method Verification","Rent Payment Method : " + strPaymentMethod +" is Selected");
						break;
					}
				}
				Thread.sleep(10000);
				String strPrice=rentPage.fnGetTVODPrice();
				if(strPaymentMethod.toLowerCase().contains("credit"))
				{
					boolean blnCreditCard=fnVerifyRentCreditDebitCard("credit",strContentName,strPrice);
					System.out.println(blnCreditCard);
				}
				else if(strPaymentMethod.toLowerCase().contains("debit"))
				{
					boolean blnCreditCard=fnVerifyRentCreditDebitCard("debit",strContentName,strPrice);
					System.out.println(blnCreditCard);
				}
				else if(strPaymentMethod.toLowerCase().contains("LineRabbit".toLowerCase()))
				{
					Thread.sleep(10000);
					boolean blnCreditCard=fnVerifyLineRabbitPaymentRent();
					System.out.println(blnCreditCard);
				}
				else if(strPaymentMethod.toLowerCase().contains("ZGold".toLowerCase()))
				{
					Thread.sleep(10000);
					boolean blnCreditCard=fnVerifyZGoldPaymentRent(objPayment.get(0).strPrice);
					System.out.println(blnCreditCard);
				}
				
				
				
				
				
				
				
				
				
				
				
				
			}
			
			
			
		}
		catch(Exception e){blnStatus=false;}
		return blnStatus;
	}	
			
	
	
	public boolean fnVerifyRentContent(String strContentName,String strPrice)
	{
		boolean blnStatus=true;
		try
		{
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<String> arrPayment=new ArrayList<String>();
			for(int j=0;j<elePayment1.size();j++)
			{
				System.out.println(elePayment1.get(j).getText());
				String strText=elePayment1.get(j).getText();
				System.out.println(strText.length());
				if(strText.replaceAll(" ", "").length()>2)
				{
					arrPayment=fnAddData(arrPayment,strText);
				}
			}
			for(int i=0;i<arrPayment.size();i++)
			{
				System.out.println(arrPayment.get(i));
			}
			if(fnVerifyTextInList(arrPayment,"You are renting"))
			{
				Reporter.pass("Rent Page Content Details Verification", "Content Rent Movie You are renting is displayed");
			}
			else
			{
				Reporter.fail("Rent Page Content Details Verification", "Content Rent Movie You are renting is not displayed");
				blnStatus=false;
			}
			if(fnVerifyTextInList(arrPayment,"RENT"))
			{
				Reporter.pass("Rent Page Content Details Verification", "Content Rent Movie RENT is displayed");
			}
			else
			{
				Reporter.fail("Rent Page Content Details Verification", "Content Rent Movie RENT is not displayed");
				blnStatus=false;
			}
			
			if(fnVerifyTextInList(arrPayment,strContentName))
			{
				Reporter.pass("Rent Page Content Details Verification", "Content Rent Movie Title " + strContentName + " is displayed");
			}
			else
			{
				Reporter.fail("Rent Page Content Details Verification", "Content Rent Movie Title " + strContentName + " is not displayed");
				blnStatus=false;
			}
			if(fnVerifyTextInList(arrPayment,strPrice))
			{
				Reporter.pass("Rent Page Content Details Verification", "Content Rent Movie Price " + strPrice + " is displayed");
			}
			else
			{
				Reporter.fail("Rent Page Content Details Verification", "Content Movie Price " + strPrice+" is not displayed");
				blnStatus=false;
			}
			List<WebElement> elePaymentImag=elePayment.findElements(By.className("android.widget.Image"));
			System.out.println(elePaymentImag.size());
			List<String> arrPaymentImage=new ArrayList<String>();
			for(int j=0;j<elePaymentImag.size();j++)
			{
				System.out.println(elePaymentImag.get(j).getText());
				String strText=elePaymentImag.get(j).getText();
				System.out.println(strText.length());
				if(strText.replaceAll(" ", "").length()>2)
				{
					arrPaymentImage=fnAddData(arrPaymentImage,strText);
				}
			}
			for(int i=0;i<arrPaymentImage.size();i++)
			{
				System.out.println(arrPaymentImage.get(i));
			}
			if(fnVerifyTextInList(arrPaymentImage,"HOOQ logo"))
			{
				Reporter.pass("Rent Page Content Details Verification", "Content Rent Movie HOOQ Logo is displayed");
			}
			else
			{
				Reporter.fail("Rent Page Content Details Verification", "Content Rent Movie HOOQ Logo is not displayed");
				blnStatus=false;
			}
			if(fnVerifyTextInList(arrPaymentImage,strContentName))
			{
				Reporter.pass("Rent Page Content Details Verification", "Content Rent Movie Image " + strContentName + " is displayed");
			}
			else
			{
				Reporter.pass("Rent Page Content Details Verification", "Content Rent Movie Image " + strContentName + " is displayed");
				blnStatus=false;
			}
			
		}
		catch(Exception e){blnStatus=false;}
		return blnStatus;
	}
	
	
	public boolean fnVerifyRentCreditDebitCard(String strCardType,String strContentName,String strPrice) throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		try
		{
			Reporter.info("Verify Rent Payment", "Subscription Payment Useing " + strCardType +" Card");
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<String> arrPayment=new ArrayList<String>();
			for(int j=0;j<elePayment1.size();j++)
			{
				System.out.println(elePayment1.get(j).getText());
				String strText=elePayment1.get(j).getText();
				System.out.println(strText.length());
				if(strText.replaceAll(" ", "").length()>2)
				{
					arrPayment=fnAddData(arrPayment,strText);
				}
			}
			for(int i=0;i<arrPayment.size();i++)
			{
				System.out.println(arrPayment.get(i));
			}
			String strText="Movie Rental";
			if(fnVerifyTextInList(arrPayment, strText))
			{
				Reporter.pass("Rent Payment Method "+strCardType+" Card Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Rent Payment Method "+strCardType+" Card Verification","Label : " + strText +" is not displayed");
			}
			if(fnVerifyTextInList(arrPayment, strContentName))
			{
				Reporter.pass("Rent Payment Method "+strCardType+" Card Verification","Label : " + strContentName +" is displayed");
			}
			else
			{
				Reporter.fail("Rent Payment Method "+strCardType+" Card Verification","Label : " + strContentName +" is not displayed");
			}
			if(fnVerifyTextInList(arrPayment, strPrice))
			{
				Reporter.pass("Rent Payment Method "+strCardType+" Card Verification","Price : " + strPrice +" is displayed");
			}
			else
			{
				Reporter.fail("Rent Payment Method "+strCardType+" Card Verification","Price : " + strPrice +" is not displayed");
			}
			strText=strCardType+" CARD PAYMENT";
			if(fnVerifyTextInList(arrPayment, strText))
			{
				Reporter.pass("Rent Payment Method "+strCardType+" Card Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Rent Payment Method "+strCardType+" Card Verification","Label : " + strText +" is not displayed");
			}
			strText="Card Number";
			if(fnVerifyTextInList(arrPayment, strText))
			{
				Reporter.pass("Rent Payment Method "+strCardType+" Card Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Rent Payment Method "+strCardType+" Card Verification","Label : " + strText +" is not displayed");
			}
			strText="Name on Card";
			if(fnVerifyTextInList(arrPayment, strText))
			{
				Reporter.pass("Rent Payment Method "+strCardType+" Card Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Rent Payment Method "+strCardType+" Card Verification","Label : " + strText +" is not displayed");
			}
			strText="Expiry Date";
			if(fnVerifyTextInList(arrPayment, strText))
			{
				Reporter.pass("Rent Payment Method "+strCardType+" Card Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Rent Payment Method "+strCardType+" Card Verification","Label : " + strText +" is not displayed");
			}
			strText="CVV";
			if(fnVerifyTextInList(arrPayment, strText))
			{
				Reporter.pass("Rent Payment Method "+strCardType+" Card Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Rent Payment Method "+strCardType+" Card Verification","Label : " + strText +" is not displayed");
			}
			List<WebElement> elePaymentEntry=elePayment.findElements(By.className("android.widget.EditText"));
			System.out.println(elePaymentEntry.size());
			for(int i=0;i<elePaymentEntry.size();i++)
			{
				System.out.println(elePaymentEntry.get(i).getText());
			}
			List<WebElement> elePaymentButton=elePayment.findElements(By.className("android.widget.Button"));
			System.out.println(elePaymentButton.size());
			System.out.println(elePaymentButton.get(0).getText());
			if(elePaymentButton.get(0).getText().toLowerCase().contains("cancel"))
			{
				Reporter.pass("Rent Payment Method "+strCardType+" Card Verification","Button : Cancel is displayed");
			}
			else
			{
				Reporter.fail("Rent Payment Method "+strCardType+" Card Verification","Button : Cancel is not displayed");
			}
			System.out.println(elePaymentButton.get(1).getText());
			if(elePaymentButton.get(1).getText().toLowerCase().contains("make payment"))
			{
				Reporter.pass("Rent Payment Method "+strCardType+" Card Verification","Button : Make Payment is displayed");
			}
			else
			{
				Reporter.fail("Rent Payment Method "+strCardType+" Card Verification","Button : Make Payment is not displayed");
			}
			CreditCardNumberGenerator objCCNumber=new CreditCardNumberGenerator();
			objCCNumber=objCCNumber.fnGetCardDetails();
			System.out.println("Name on Card ==> "+objCCNumber.strNameOnCard);
			System.out.println("Credit Card Number ==> " + objCCNumber.strCCNumber);
			System.out.println("Expire Date ==> " + objCCNumber.strExpireDate);
			System.out.println("CVV Number ==> " + objCCNumber.strCVVNumber);
			Reporter.info(strCardType+" Card Entry Details", "Credit Card Details Found");
			Reporter.pass(strCardType+" Card Entry Details","Name on Card ==> " + objCCNumber.strNameOnCard);
			Reporter.pass(strCardType+" Card Entry Details","Credit Card Number ==> " + objCCNumber.strCCNumber);
			Reporter.pass(strCardType+"Card Entry Details","Credit Card Expiry Date ==> " + objCCNumber.strExpireDate);
			Reporter.pass(strCardType+" Card Entry Details","Credit Card CVV Number ==> " + objCCNumber.strCVVNumber);
			elePaymentEntry.get(0).sendKeys(objCCNumber.strCCNumber);
			elePaymentEntry.get(1).sendKeys(objCCNumber.strNameOnCard);
			elePaymentEntry.get(2).sendKeys(objCCNumber.strExpireDate);
			elePaymentEntry.get(3).sendKeys(objCCNumber.strCVVNumber);
			Thread.sleep(5000);
			driver.navigate().back();
			Thread.sleep(5000);
			elePaymentButton.get(1).click();
			Thread.sleep(15000);
			List<WebElement> elePayment2=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment2.size());
			List<String> arrPaymentError=new ArrayList<String>();
			for(int j=0;j<elePayment2.size();j++)
			{
				System.out.println(elePayment2.get(j).getText());
				String strText1=elePayment2.get(j).getText();
				System.out.println(strText1.length());
				if(strText.replaceAll(" ", "").length()>2)
				{
					arrPaymentError=fnAddData(arrPaymentError,strText1);
				}
			}
			boolean blnErrorMessage=false;
			strText="card not supported";
			if(fnVerifyTextInList(arrPaymentError, strText))
			{
				Reporter.pass(strCardType+" Card Entry Details","Valid Error Messag is Displayed");
				blnErrorMessage=true;
			}
			strText="Sorry";
			if(fnVerifyTextInList(arrPaymentError, strText))
			{
				Reporter.pass(strCardType+" Card Entry Details","Valid Error Messag is Displayed");
				blnErrorMessage=true;
			}
			strText="Please enter a valid card number.";
			if(fnVerifyTextInList(arrPaymentError, strText))
			{
				Reporter.pass(strCardType+" Card Entry Details","Valid Error Messag is Displayed");
				driver.navigate().back();
				Thread.sleep(5000);
				blnErrorMessage=true;
			}
			if(blnErrorMessage==false)	
			{
				Reporter.fail(strCardType+" Card Entry Details","Valid Error Messag is not Displayed");
			}
			elePaymentButton.get(0).click();
			Thread.sleep(5000);
			List<WebElement> elePaymentCancel=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePaymentCancel.size());
			if(elePaymentCancel.get(1).getText().toLowerCase().contains("payment cancelled"))
			{
				Reporter.pass(strCardType+" Card Payment Cancel","Info Payment Cancelled is Displayed");
			}
			else
			{
				Reporter.fail(strCardType+" Card Payment Cancel","Info Payment Cancelled is not Displayed");
			}
			if(elePaymentCancel.get(3).getText().toLowerCase().contains("done"))
			{
				Reporter.pass(strCardType+" Card Payment Cancel","Done Button is Displayed");					
			}
			else
			{
				Reporter.fail(strCardType+" Card Payment Cancel","Done Button is not Displayed");
			}
			elePaymentCancel.get(3).click();
			Thread.sleep(5000);
			if(isElementDisplayed(contentMovieName))
			{
				Reporter.pass(strCardType+" Card Payment Cancel","Content Details Page is Displayed");	
				driver.navigate().back();
			}
			else
			{
				Reporter.fail(strCardType+" Card Payment Cancel","Content Details Page is not Displayed");
			}
		}
		catch(Exception e){	Reporter.blnReportTempStatus=false;}
		Thread.sleep(10000);
		return Reporter.blnReportTempStatus;
	}
	
	
	public boolean fnVerifyLineRabbitPaymentRent() throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		try
		{
			Reporter.info("Verify Rent Payment", "Rent Payment Useing Rabbit LINE Pay Payment");
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<String> arrPayment=new ArrayList<String>();
			for(int j=0;j<elePayment1.size();j++)
			{
				System.out.println(elePayment1.get(j).getText());
				String strText=elePayment1.get(j).getText();
				System.out.println(strText.length());
				if(strText.replaceAll(" ", "").length()>2)
				{
					arrPayment=fnAddData(arrPayment,strText);
				}
			}
			for(int i=0;i<arrPayment.size();i++)
			{
				System.out.println(arrPayment.get(i));
			}
			String strText="Rabbit LINE Pay";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Rent Payment Method Rabbit LINE Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Rent Payment Method Rabbit LINE Verification","Label : " + strText +" is not displayed");
			}
			strText="Log in using your LINE account or by scanning a QR code.";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Rent Payment Method Rabbit LINE Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Rent Payment Method Rabbit LINE Verification","Label : " + strText +" is not displayed");
			}
			strText="LINE Log in";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Rent Payment Method Rabbit LINE Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Rent Payment Method Rabbit LINE Verification","Label : " + strText +" is not displayed");
			}
			strText="Email address";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Rent Payment Method Rabbit LINE Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Rent Payment Method Rabbit LINE Verification","Label : " + strText +" is not displayed");
			}
			strText="Password";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Rent Payment Method Rabbit LINE Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Rent Payment Method Rabbit LINE Verification","Label : " + strText +" is not displayed");
			}
			List<WebElement> elePaymentEdit=elePayment.findElements(By.className("android.widget.EditText"));
			System.out.println(elePaymentEdit.size());
			if(elePaymentEdit.size()==2)
			{
				Reporter.pass("Rent Payment Method Rabbit LINE Verification","Email Field is displayed");
				Reporter.pass("Rent Payment Method Rabbit LINE Verification","Password Field is displayed");
			}
			else
			{
				Reporter.fail("Rent Payment Method Rabbit LINE Verification","Mobile Number Field is not displayed");
			}
			List<WebElement> elePaymentButton=elePayment.findElements(By.className("android.widget.Button"));
			System.out.println(elePaymentButton.size());
			System.out.println(elePaymentButton.get(0).getText());
			if(elePaymentButton.get(0).getText().toLowerCase().contains("log in"))
			{
				Reporter.pass("Rent Payment Method Rabbit LINE Verification","Button : Log in is displayed");
			}
			else
			{
				Reporter.fail("Rent Payment Method Rabbit LINE Verification","Button : Log in is not displayed");
			}			
			driver.navigate().back();
			Thread.sleep(5000);
			driver.navigate().back();
			Thread.sleep(5000);
			if(isElementDisplayed(contentMovieName))
			{
				Reporter.pass("Rent Payment Method Rabbit LINE Verification Cancel","Content Details Page is Displayed");	
				driver.navigate().back();
			}
			else
			{
				Reporter.fail("Rent Payment Method Rabbit LINE Verification Cancel","Content Details Page is Displayed");	
			}
		}
		catch(Exception e){	Reporter.blnReportTempStatus=false;}
		Thread.sleep(10000);
		return Reporter.blnReportTempStatus;
	}
	
	
	public boolean fnVerifyZGoldPaymentRent(String strAmount) throws Throwable
	{
		Reporter.blnReportTempStatus=true;
		try
		{
			Reporter.info("Verify Rent Payment", "Rent Payment Useing ZGold Payment");
			List<WebElement> eleLayout=driver.findElements(By.id("tv.hooq.android:id/swipeRefreshLayout"));
			System.out.println(eleLayout.size());
			List<WebElement> eleView=eleLayout.get(0).findElements(By.className("android.webkit.WebView"));
			System.out.println(eleView.size());
			System.out.println(eleView.get(1).getText());
			WebElement elePayment=eleView.get(1).findElement(By.className("android.view.View"));
			List<WebElement> elePayment1=elePayment.findElements(By.className("android.view.View"));
			System.out.println(elePayment1.size());
			List<String> arrPayment=new ArrayList<String>();
			for(int j=0;j<elePayment1.size();j++)
			{
				System.out.println(elePayment1.get(j).getText());
				String strText=elePayment1.get(j).getText();
				System.out.println(strText.length());
				if(strText.replaceAll(" ", "").length()>2)
				{
					arrPayment=fnAddData(arrPayment,strText);
				}
			}
			for(int i=0;i<arrPayment.size();i++)
			{
				System.out.println(arrPayment.get(i));
			}
			String strText="1 Standard TVOD MOL purchase";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Rent Payment Method ZGold Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Rent Payment Method ZGold Verification","Label : " + strText +" is not displayed");
			}
			strText="Log In Razer ID";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Rent Payment Method ZGold Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Rent Payment Method ZGold Verification","Label : " + strText +" is not displayed");
			}
			strText="Password";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Rent Payment Method ZGold Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Rent Payment Method ZGold Verification","Label : " + strText +" is not displayed");
			}
			if(fnVerifyTextInList(arrPayment,strAmount))
			{
				Reporter.pass("Rent Payment Method ZGold Verification","Price : " + strAmount +" is displayed");
			}
			else
			{
				Reporter.fail("Rent Payment Method ZGold Verification","Label : Currency and Price is not displayed");
			}
			strText="Forgot password?";
			if(fnVerifyTextInList(arrPayment,strText))
			{
				Reporter.pass("Rent Payment Method ZGold Verification","Label : " + strText +" is displayed");
			}
			else
			{
				Reporter.fail("Rent Payment Method ZGold Verification","Label : " + strText +" is not displayed");
			}
			List<WebElement> elePaymentEdit=elePayment.findElements(By.className("android.widget.EditText"));
			System.out.println(elePaymentEdit.size());
			if(elePaymentEdit.size()==2)
			{
				Reporter.pass("Rent Payment Method ZGold Verification","Email Field is displayed");
				Reporter.pass("Rent Payment Method ZGold Verification","Password Field is displayed");
			}
			else
			{
				Reporter.fail("Rent Payment Method ZGold Verification","Mobile Number Field is not displayed");
			}
			List<WebElement> elePaymentButton=elePayment.findElements(By.className("android.widget.Button"));
			System.out.println(elePaymentButton.size());
			System.out.println(elePaymentButton.get(0).getText());
			if(elePaymentButton.get(0).getText().toLowerCase().contains("sign in"))
			{
				Reporter.pass("Subscription Payment Method ZGold Verification","Button : SIGN IN is displayed");
			}
			else
			{
				Reporter.fail("Subscription Payment Method ZGold Verification","Button : SIGN IN is not displayed");
			}
			driver.navigate().back();
			Thread.sleep(5000);
			driver.navigate().back();
			Thread.sleep(5000);
			driver.navigate().back();
			Thread.sleep(5000);
			if(isElementDisplayed(contentMovieName))
			{
				Reporter.pass("Rent Payment Method ZGold Verification Cancel","Content Details Page is Displayed");	
				driver.navigate().back();
			}
			else
			{
				Reporter.fail("Rent Payment Method ZGold Verification Cancel","Content Details Page is Displayed");	
			}
		}
		catch(Exception e){	Reporter.blnReportTempStatus=false;}
		Thread.sleep(10000);
		return Reporter.blnReportTempStatus;
	}
}

