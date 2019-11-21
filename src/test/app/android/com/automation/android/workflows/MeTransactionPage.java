package com.automation.android.workflows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.reports.Reporter;

public class MeTransactionPage extends BasePage{
	By transaTopLayout=By.id("tv.hooq.android:id/appBarLayout");
	By transacTitle=By.id("tv.hooq.android:id/title");
	By transactionHistoryTbl=By.id("tv.hooq.android:id/listView");
	
	public boolean fnVerifyTransactionHistoryScreen(boolean blnAnnonymous) throws Throwable {
		Reporter.info("HOOQ Android","Verifying Transaction History Page");
		boolean blnFound=true;
		try
		{
			mePage.fnSelectMESection("trans");
			if(blnAnnonymous==true)
			{
				//fnVerifyTransactionHistoryEmpty();
			}
			else if(blnAnnonymous==false)
			{
				String strHeader=driver.findElement(transaTopLayout).findElement(transacTitle).getText();
				System.out.println(strHeader);
				if(strHeader.toLowerCase().contains("transaction history"))
				{
					Reporter.pass("Transaction History Screen", "Transaction History Section is displayed");
				}
				else
				{
					Reporter.fail("Settings Screen", "Settings Section is not displayed");
				}
				List<WebElement> eleTable=driver.findElements(transactionHistoryTbl);
				System.out.println(eleTable.size());
				List<WebElement> eleTableHistory=eleTable.get(0).findElements(By.className("android.widget.LinearLayout"));
				if(eleTableHistory.size()>0)
				{
					Reporter.pass("Transaction History Detail for Transaction", eleTableHistory.size()+ " Transation History Displayed");
					//Transaction ID Label
					Reporter.info("Transaction History Detail for Transaction","Details of First Transation History.");
					List<WebElement> eleLabel=eleTableHistory.get(0).findElements(By.className("android.widget.LinearLayout"));
					System.out.println(eleLabel.size());
					List<WebElement> eleTLabel=eleLabel.get(0).findElements(By.className("android.widget.TextView"));
					System.out.println(eleTable.size());
					if(eleTLabel.get(0).getText().contains("TRANSACTION DATE:"))
					{
						Reporter.pass("Transaction History Detail", "Label : TRANSACTION DATE is Displayed");
					}
					else
					{
						Reporter.fail("Transaction History Detail", "Label : TRANSACTION DATE is not Displayed");
					}
					if(eleTLabel.get(1).getText().contains("TRANSACTION ID:"))
					{
						Reporter.pass("Transaction History Detail", "Label : TRANSACTION ID: is Displayed");
					}
					else
					{
						Reporter.fail("Transaction History Detail", "Label : TRANSACTION ID: is not Displayed");
					}
					List<WebElement> eleDetailsLabel=eleLabel.get(1).findElements(By.className("android.widget.TextView"));
					String strTransactionDate=eleDetailsLabel.get(0).getText();
					String strTransactionID=eleDetailsLabel.get(1).getText();
					if(strTransactionDate.length()>0)
					{
						Reporter.pass("Transaction History Detail", "TRANSACTION DATE "+ strTransactionDate + " is Displayed");
					}
					else
					{
						Reporter.fail("Transaction History Detail", "TRANSACTION DATE Value is not Displayed");
					}
					if(strTransactionID.length()>0)
					{
						Reporter.pass("Transaction History Detail", "TRANSACTION ID "+ strTransactionID + " is Displayed");
					}
					else
					{
						Reporter.fail("Transaction History Detail", "TRANSACTION ID Value is not Displayed");
					}
					//Transaction Details
					List<WebElement> eleDetails=eleTableHistory.get(0).findElements(By.className("android.widget.RelativeLayout"));
					System.out.println(eleDetails.size());
					List<WebElement> eleposter=eleDetails.get(0).findElements(By.id("tv.hooq.android:id/poster"));
					if(eleposter.size()>0)
					{
						Reporter.pass("Transaction History Detail", "Poster is Displayed");
					}
					else
					{
						Reporter.fail("Transaction History Detail", "Poster is not Displayed");
					}
					List<WebElement> eleTransDet=eleDetails.get(0).findElements(By.className("android.widget.TextView"));
					if(eleTransDet.size()>0)
					{
						Reporter.pass("Transaction History Detail", "Transaction Details Info is Displayed");
						for(int i=0;i<eleTransDet.size();i++)
						{
							Reporter.pass("Transaction History Detail", "Transaction Details Info :- "+ eleTransDet.get(i).getText()+"  is Displayed");
						}
					}
					else
					{
						Reporter.fail("Transaction History Detail", "Transaction Details Info is not Displayed");
					}
				}
				
			}
			driver.navigate().back();
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			blnFound=false;
		}
		return blnFound;
	}

}
