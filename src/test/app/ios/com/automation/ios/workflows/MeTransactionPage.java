package com.automation.ios.workflows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.reports.Reporter;

public class MeTransactionPage extends BasePage{
	//Locators
	By TransationHistoryTitle=By.name("TRANSACTION HISTORY");
	By transactionHistoryLogo=By.id("empState_TransactionHistory");
	By transactionHistoryTable=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]");
	By navBackBtn = By.name("navbar back btn");
	By Message=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText");
	
	/***
	 * Function Name :- fnVerifyTransactionHistoryScreen
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public  boolean fnVerifyTransactionHistoryScreen(boolean blnAnnonymous) throws Throwable
	{
		Reporter.info("HOOQ IOS","Verifying Transaction History Page");
		boolean blnFound=true;
		try
		{
			mePage.fnSelectMESection("trans");
			if(blnAnnonymous==true)
			{
				fnVerifyTransactionHistoryEmpty();
			}
			else if(blnAnnonymous==false)
			{
					boolean blnHeader=isElementDisplayed(TransationHistoryTitle);
					if(blnHeader)
					{
						Reporter.pass("Transaction History Screen", "Transaction History Section is displayed");
					}
					else
					{
						Reporter.fail("Transaction History Screen", "Transaction History Section is not displayed");
					}
					List<WebElement> eleTbl=driver.findElements(transactionHistoryTable);
					System.out.println(eleTbl.size());
					List<WebElement> eleTable=driver.findElements(transactionHistoryTable);
					System.out.println(eleTable.size());
					List<WebElement> eleTableHistory=eleTable.get(0).findElements(By.xpath("XCUIElementTypeText"));
					System.out.println("Transaction Details for " + 1);
					for(int j=0;j<eleTableHistory.size();j++)
					{
						Reporter.pass("Transaction History Detail for Transaction : " + (1), "Text Displayed : " + eleTableHistory.get(j).getText());
					}
					
					
					/*if(eleTable.size()>0)
					{
						int intTransaction=3;
						if(eleTable.size()<3)
						{
							intTransaction=eleTable.size();
						}
						Reporter.pass("Transaction History Screen", "Transaction History Section is displayed Total Transaction found : " + eleTable.size());
						for(int i=0;i<intTransaction;i++)
						{
							List<WebElement> eleTableHistory=eleTable.get(i).findElements(By.xpath("XCUIElementTypeText"));
							System.out.println("Transaction Details for " + i);
							for(int j=0;j<eleTableHistory.size();j++)
							{
								Reporter.pass("Transaction History Detail for Transaction : " + (i+1), "Text Displayed : " + eleTableHistory.get(j).getText());
							}
						}
						
					}
					else
					{
						Reporter.fail("Transaction History Screen", "Transaction History Section is not displayed");
					}
	*/			}
				click(navBackBtn,"Back Button");
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			blnFound=false;
		}
		return blnFound;
	}
	/***
	 * Function Name :- fnVerifyTransactionHistoryEmpty
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public  boolean fnVerifyTransactionHistoryEmpty() throws Throwable
	{
		boolean blnFound=true;
		try
		{
			boolean blnEmptyDownload=isElementDisplayed(transactionHistoryLogo);
			String strMessage=getText(Message,"Transaction History Message");
			boolean blnDownladHeader=isElementDisplayed(TransationHistoryTitle);
			if(blnDownladHeader)
			{
				Reporter.pass("Transaction History Screen", "Transaction History Section is displayed");
			}
			else
			{
				Reporter.fail("Transaction History Screen", "Transaction History Section is not displayed");
			}
			if(blnEmptyDownload)
			{
				Reporter.pass("Transaction History Screen", "Transaction History Empty Logo is displayed");
			}
			else
			{
				Reporter.fail("Transaction History Screen", "Transaction History Empty Logo is not displayed");
			}
			if(strMessage.contains("Receipts from your transactions appear here"))
			{
				System.out.println(strMessage);
				Reporter.pass("Transaction History Screen", "Default Transaction History Empty Message :- "  +strMessage +" is displayed " );
			}
			else
			{
				Reporter.fail("Transaction History Screen", "Default Transaction History Empty Message :- "  +strMessage +" is  not displayed");		
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
