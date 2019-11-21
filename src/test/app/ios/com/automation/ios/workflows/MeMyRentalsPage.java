package com.automation.ios.workflows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.reports.Reporter;

public class MeMyRentalsPage extends BasePage{
	//Locators
	By rentalTbl=By.xpath("//XCUIElementTypeTable");
	By rentalsSection = By.id("My Rentals");
	By rentalsSectionHeader = By.id("MY RENTALS");
	By premiumTktInfo=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText");
	/***
	 * Function Name :- verifyingMePremiumPage
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 */
	public  boolean verifyingMeMyRentals(boolean anonymousUser) throws Throwable {
		Reporter.info("HOOQ IOS","Verifying ME My Rentals");
		boolean blnStatus=true;
		try {
			mePage.fnSelectME();
			scrollJs("up");
			if(isElementDisplayed(rentalsSection,"My Rentals"))
			{
				click(rentalsSection, "My Rentals");
				String strHeader=getText(rentalsSectionHeader, "My REntals");
				if(strHeader.toLowerCase().contains("my rentals"))
				{
					Reporter.pass("My Rentals page details", "My Rentals page Header is displayed");
				} else{
					Reporter.fail("My Rentals page details", "My Rentals page Header is not displayed");
				}
				String strTkt=getText(premiumTktInfo, "Ticket Info My Rentals Page");
				if(strTkt.length()>0)
				{
					Reporter.pass("My Rentals page details", "My Rentals page Ticket Info is displayed");
					Reporter.pass("My Rentals page details", strTkt +" Info is displayed");
				} else{
					Reporter.fail("My Rentals page details", "My Rentals page Ticket Info is not displayed");
				}
				List<WebElement> eleList=driver.findElement(rentalTbl).findElements(By.xpath("//XCUIElementTypeCell"));
				System.out.println(eleList.size());
				if(eleList.size()>0)
				{
					Reporter.pass("My Rentals page details", "My Rentals page Rental Details is displayed");
					try{
						List<WebElement> elebtn=eleList.get(0).findElements(By.xpath("//XCUIElementTypeButton"));
						System.out.println(elebtn.size());
						String strButton=elebtn.get(0).getText();
						System.out.println(strButton);
						Reporter.pass("My Rentals page details", "My Rentals page Play Button is displayed");
					}catch(Exception e){}
					List<WebElement> eletext=eleList.get(0).findElements(By.xpath("XCUIElementTypeStaticText"));
					System.out.println(eletext.size());
					String strText1=eletext.get(2).getText();
					System.out.println(strText1);
					Reporter.pass("My Rentals page details", "My Rentals page "+strText1+" is displayed");
					String strText2=eletext.get(3).getText();
					System.out.println(strText2);
					Reporter.pass("My Rentals page details", "My Rentals page "+strText2+" is displayed");
					String strText3=eletext.get(4).getText();
					System.out.println(strText3);
					Reporter.pass("My Rentals page details", "My Rentals page "+strText3+" is displayed");
					try
					{
						String strText4=eletext.get(5).getText();
						System.out.println(strText4);
						Reporter.pass("My Rentals page details", "My Rentals page "+strText4+" is displayed");
					}
					catch(Exception e){}
				}
			}
			
		} catch (Exception e) {
			Reporter.fnPrintException(e);
			blnStatus=false;
		}
		
		return blnStatus;
	}
}
