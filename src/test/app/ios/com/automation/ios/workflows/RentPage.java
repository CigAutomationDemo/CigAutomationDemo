package com.automation.ios.workflows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.automation.reports.Reporter;

public class RentPage extends BasePage{
	//Locators
	By RentHeaderTitle=By.name("RENT");
	By RentPageTktInfo=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText");
	By RentPageTable=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeCollectionView");
	By RentPageInnerTable=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable");
	By BrowsePageInner=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView");
	By BrowsePageInnerHeader=By.xpath(" //XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeNavigationBar/XCUIElementTypeStaticText/XCUIElementTypeStaticText");
	By BrowsePageIneerCount=By.xpath(" //XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeNavigationBar/XCUIElementTypeStaticText[2]");
	By BrowsePageFilterButton=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeNavigationBar/XCUIElementTypeButton[2]");
	By BrowsePageFilterText=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeNavigationBar/XCUIElementTypeStaticText/XCUIElementTypeStaticText");
	By BrowseFilterHeader=By.id("FILTER");
	By BrowseFilterReset=By.id("Reset");
	By BrowseFilterSortByText=By.id("SORT BY");
	By BrowseFilterTypeText=By.id("TYPE");
	By BrowseFilterSubsText=By.id("SUBSCRIPTION/RENTAL");
	By BrowseFilterGenereText=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeStaticText[4]");
	By BrowseFilterSubTitle=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeStaticText");
	By BrowseFilterSortTbl=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[1]");
	By BrowseFilterTypeTbl=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]");
	By BrowseFilterSubsTbl=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[3]");
	By BrowseFilterGenreTbl=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]");
	By BrowseFilterSubTitleTbl=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]");
	By BrowseFilterApplyFilters=By.id("Apply Filters");
	By navBackBtn = By.name("navbar back btn");
	By RentalPopUp=By.name("Explore Rental Movies");
	By tblRent=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeCollectionView");
	By RentButton=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[1]");
	By contentMovieName=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeStaticText[1]");
	By RedeemTicketPopUp=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther");
	By TicketRedeemPopup=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther");
	By TicketLogo=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage");
	By RentPageInnerTitle=By.xpath("//XCUIElementTypeStaticText/XCUIElementTypeStaticText");
	By RedimTicket=By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[1]");
	/***
	 * Function Name :- fnVerifyRentSectionFilter
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
	public  boolean fnVerifyRentSectionFilter() throws Throwable
	{
		try
		{
			commonPage.fnSelectTab("rent");
			fnDismissRentalPopUp();
			if(isElementDisplayed(RentHeaderTitle,"Rent Page"))
			{
				Reporter.pass("Rent Page Screen", "Rent Page is displayed");
				String strTktInfo=getText(RentPageTktInfo,"Ticket Info");
				if(strTktInfo.contains("ticket"))
				{
					Reporter.pass("Rent Page Screen","Ticket Info is displayed successfully");			
				}
				else
				{
					Reporter.fail("Rent Page Screen","Ticket Info is not displayed");			
				}
				List<WebElement> eleTable=driver.findElement(RentPageTable).findElements(By.xpath("XCUIElementTypeCell"));
				if(eleTable.size()>0)
				{
					Reporter.pass("Rent Page Screen","TVOD Movie List is displayed successfully");	
					for(int i=0;i<eleTable.size();i++)
					{
						String strText=eleTable.get(i).findElement(By.xpath("XCUIElementTypeOther")).findElement(By.xpath("XCUIElementTypeText")).getText();
						Reporter.pass("Rent Page Screen",strText + " TVOD Movie is displayed successfully");	
					}
					eleTable.get(1).findElement(By.xpath("XCUIElementTypeOther")).findElement(By.xpath("XCUIElementTypeText")).click();
					List<WebElement> eleInnerTable=driver.findElement(BrowsePageInner).findElements(By.xpath("XCUIElementTypeCell"));
					if(eleInnerTable.size()>0)
					{
						String BrowseInnerHeader=getText(BrowsePageInnerHeader,"Rent Page Inner Header");
						System.out.println(BrowseInnerHeader);
						String BrowseInnerCount=getText(BrowsePageIneerCount,"Rent");
						System.out.println(BrowseInnerCount);
						if(isElementDisplayed(BrowsePageFilterButton))
						{
							String strFilterValue=getText(BrowsePageFilterText,"Filter Text");
							System.out.println(strFilterValue);
							click(BrowsePageFilterButton,"Rent Filter");
							if(isElementDisplayed(BrowseFilterHeader))
							{
								
								Reporter.pass("Rent Page Filter","Filter Header is displayed successfully");
							}
							else
							{
								Reporter.fail("Rent Page Filter","Filter Header is not displayed");
							}
							if(isElementDisplayed(BrowseFilterReset))
							{
								Reporter.pass("Rent Page Filter","Rest is displayed successfully");
							}
							else
							{
								Reporter.fail("Rent Page Filter","Reset is not displayed");
							}
							if(isElementDisplayed(BrowseFilterSortByText))
							{
								Reporter.pass("Rent Page Filter","Sort By is displayed successfully");
							}
							else
							{
								Reporter.fail("Rent Page Filter","Sort By is not displayed");
							}
							List<WebElement> eleSort=driver.findElement(BrowseFilterSortTbl).findElements(By.xpath("XCUIElementTypeButton"));
							if(eleSort.size()>0)
							{
								for(int i=0;i<eleSort.size();i++)
								{
									String strText=eleSort.get(i).getText();
									System.out.println(strText);
									Reporter.pass("Rent Page Filter","Sort By :- " + strText + "is displayed successfully");			
								}
								eleSort.get(1).click();
							}
							if(isElementDisplayed(BrowseFilterTypeText))
							{
								Reporter.pass("Rent Page Filter","Type is displayed successfully");
							}
							else
							{
								Reporter.fail("Rent Page Filter","Type is not displayed");
							}
							List<WebElement> eleFILTER=driver.findElement(BrowseFilterTypeTbl).findElements(By.xpath("XCUIElementTypeButton"));
							if(eleFILTER.size()>0)
							{
								for(int i=0;i<eleFILTER.size();i++)
								{
									String strText=eleFILTER.get(i).getText();
									System.out.println(strText);
									Reporter.pass("Rent Page Filter","Type By :- " + strText + "is displayed successfully");			
								}
								
							}
							
							if(isElementDisplayed(BrowseFilterSubsText))
							{
								Reporter.pass("Rent Page Filter","Subscription is displayed successfully");
							}
							else
							{
								Reporter.fail("Rent Page Filter","Subscription is not displayed");
							}
							List<WebElement> eleSUBS=driver.findElement(BrowseFilterSubsTbl).findElements(By.xpath("XCUIElementTypeButton"));
							if(eleSUBS.size()>0)
							{
								for(int i=0;i<eleSUBS.size();i++)
								{
									String strText=eleSUBS.get(i).getText();
									System.out.println(strText);
									Reporter.pass("Rent Page Filter","Subscription By :- " + strText + "is displayed successfully");			
								}
								
							}
							List<WebElement> eleGENRE=driver.findElement(BrowseFilterGenreTbl).findElements(By.xpath("XCUIElementTypeButton"));
							if(eleGENRE.size()>0)
							{
								Reporter.pass("Rent Page Filter","Genre is displayed successfully");
								for(int i=0;i<eleGENRE.size();i++)
								{
									String strText=eleGENRE.get(i).getText();
									System.out.println(strText);
									Reporter.pass("Rent Page Filter","GENRE By :- " + strText + "is displayed successfully");			
								}
								eleGENRE.get(1).click();
								eleGENRE.get(2).click();
								eleGENRE.get(3).click();
								eleGENRE.get(4).click();
								eleGENRE.get(5).click();
								eleGENRE.get(6).click();
							}
							else
							{
								Reporter.fail("Rent Page Filter","Genre is not displayed");
							}
							scrollJs("down");
							List<WebElement> eleSUBTITLE=driver.findElement(BrowseFilterSubTitleTbl).findElements(By.xpath("XCUIElementTypeButton"));
							if(eleSUBTITLE.size()>0)
							{
								Reporter.pass("Rent Page Filter","SubTitle is displayed successfully");
								for(int i=0;i<eleSUBTITLE.size();i++)
								{
									String strText=eleSUBTITLE.get(i).getText();
									System.out.println(strText);
									Reporter.pass("Rent Page Filter","Subtitle By :- " + strText + "is displayed successfully");			
								}
								eleSUBTITLE.get(1).click();
							}
							else
							{
								Reporter.fail("Rent Page Filter","SubTitle is not displayed");
							}
							click(BrowseFilterApplyFilters,"Apply Filter");
							String BrowseInnerCountAfter=getText(BrowsePageIneerCount,"Browse Page Inner Count");
							System.out.println(BrowseInnerCountAfter);
							
							String strFilterValueInnerAfter=getText(BrowsePageFilterText,"Filter Text");
							System.out.println(strFilterValueInnerAfter);
							if(BrowseInnerCount.equals(BrowseInnerCountAfter)==false )
							{
								Reporter.pass("Rent Page Filter","Filter is Applied successfully");			
								
							}
							else
							{
								Reporter.fail("Rent Page Filter","Filter is Applied successfully");			
								
							}
							click(navBackBtn,"Back");
						}
					
					
				}
				else
				{
					Reporter.fail("Rent Page Screen","TVOD Movie List is not displayed");			
				}
			}
			else
			{
				Reporter.fail("Rent Page Screen", "Rent Page is not displayed");
			}
			}
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			//blnStatus=false;
		}
		return true;
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
	/***
	 * Function Name :- fnVerifyRentSection
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
	public  boolean fnVerifyRentSection() throws Throwable
	{
		Reporter.info("HOOQ IOS","Verifying Rent Section");
		boolean blnStatus=true;
		try
		{
			commonPage.fnSelectTab("rent");
			Thread.sleep(10000);
			if(fnDismissRentalPopUp())
			{
				
				Reporter.pass("Rent Page Popup","Rent Page Popup is displayed");		
			}
			else
			{
				Reporter.fail("Rent Page Popup","Rent Page Popup is not displayed");		
			}
			if(isElementDisplayed(RentHeaderTitle,"Rent Page"))
			{
				Reporter.pass("Rent Page Screen", "Rent Page is displayed");
				getText(RentPageTktInfo,"Rent Page Ticket Info");
				WebElement eleTbl=driver.findElement(tblRent);
				List<WebElement> eleCat=eleTbl.findElements(By.xpath("XCUIElementTypeCell"));
				if(eleCat.size() >0)
				{
					Reporter.pass("Rent Page Screen",eleCat.size() +  " Collection Secton is displayed");
					for(int i=0;i<eleCat.size();i++)
					{
						String strCollectionName = eleCat.get(i).findElement(By.xpath("XCUIElementTypeStaticText")).getText();
						System.out.println(strCollectionName);
						Reporter.pass("Rent Page Screen",strCollectionName +  " Collection Secton is displayed");			
					}	
				}
				else
				{
					Reporter.fail("Rent Page Screen",eleCat.size() +  " Collection Secton is displayed");				
				}
			}
			else
			{
				Reporter.fail("Rent Page Screen", "Browse Page is not displayed");
				blnStatus=false;
			}
			commonPage.fnSelectTab("Discover");
			commonPage.fnSelectTab("Rent");
			if(fnDismissRentalPopUp())
			{
				Reporter.fail("Rent Page Popup","Rent Page Popup is displayed");		
			}
			else
			{
				Reporter.pass("Rent Page Popup","Rent Page Popup is not displayed");		
			}
			WebElement eleTbl=driver.findElement(tblRent);
			List<WebElement> eleCat=eleTbl.findElements(By.xpath("XCUIElementTypeCell"));
			String strText1=eleCat.get(1).findElement(By.xpath("XCUIElementTypeStaticText")).getText();
			if(eleCat.size()>0)
			{
				eleCat.get(1).click();
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
				List<WebElement> eleContent=driver.findElement(By.xpath("//XCUIElementTypeCollectionView")).findElements(By.xpath("XCUIElementTypeCell"));
				if(eleContent.size()>0)
				{
					Reporter.pass("Rent Content","Rent Page Content List Total Collection : " + eleContent.size() +" is displayed");
				}
				else
				{
					Reporter.fail("Rent Content","Rent Page Content List is not displayed");
				}
				click(navBackBtn,"Back");
			}
			else
			{
				Reporter.fail("Rent Content","Rent Page Content List is not displayed");
			}
			commonPage.fnSelectTab("Discover");
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			blnStatus=false;
		}
		return blnStatus;
	}
	/***
	 * Function Name :- fnVerifyRentWithCC
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
	public  boolean fnVerifyRentWithCC() throws Throwable
	{
		String strRentValue="INR 80";
		boolean blnStatus=true;
		try
		{
			commonPage.fnSelectTab("Rent");
			fnDismissRentalPopUp();
			WebElement eleTbl=driver.findElement(tblRent);
			List<WebElement> eleCat=eleTbl.findElements(By.xpath("XCUIElementTypeCell"));
			String strText1=eleCat.get(1).findElement(By.xpath("XCUIElementTypeOther")).findElement(By.xpath("XCUIElementTypeText")).getText();
			if(eleCat.size()>0)
			{
				eleCat.get(1).click();
				String strText=driver.findElement(By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeNavigationBar/XCUIElementTypeText/XCUIElementTypeText")).getText();
				if(strText.equalsIgnoreCase(strText1))
				{
					Reporter.pass("Rent Content","Rent Page Content Title "+strText+" is displayed");	
				}
				else
				{
					Reporter.fail("Rent Content","Rent Page Content Title "+strText+" is not displayed");
				}
				List<WebElement> eleContent=driver.findElement(By.xpath("//XCUIElementTypeCollectionView")).findElements(By.xpath("XCUIElementTypeCell"));
				if(eleContent.size()>0)
				{
					Reporter.pass("Rent Content","Rent Page Content List is displayed");
					eleContent.get(1).click();
					String strTextRent=getText(RentButton,"RentButton Text");
					System.out.println("Rent Value =>" + strTextRent);
					if(strTextRent.contains(strRentValue))
					{
						Reporter.pass("Rent Content Rent","Rent Page Rent "+ strTextRent+" is displayed");
					}
					else
					{
						Reporter.fail("Rent Content Rent","Rent Page Rent "+ strTextRent+" is not displayed");
					}
					String strTitle=getText(contentMovieName,"Content Title");
					click(RentButton,"Rent Button");
					List<WebElement> eleList=driver.findElements(RedeemTicketPopUp);
					if(eleList.size()>0)
					{
						Reporter.pass("Redeem Ticket Info","Redeem Ticket Popup is displayed");
						List<WebElement> eleListText=eleList.get(0).findElements(By.xpath("//XCUIElementTypeText"));
						if(eleListText.size()>0)
						{
							String strText4=eleListText.get(0).getText();
							String strText2=eleListText.get(1).getText();
							String strText3=eleListText.get(2).getText();
							if(strText4.contains(strTitle))
							{
								Reporter.pass("Redeem Ticket Info",strTitle+" is displayed");
							}
							else
							{
								Reporter.fail("Redeem Ticket Info",strTitle+" is not displayed");
							}
							Reporter.pass("Redeem Ticket Info",strText2+" is displayed");
							Reporter.pass("Redeem Ticket Info",strText3+" is displayed");
						}
						List<WebElement> eleListButton=eleList.get(0).findElements(By.xpath("//XCUIElementTypeOther/XCUIElementTypeButton"));
						if(eleListButton.size()>0)
						{
							String strButton1=eleListButton.get(0).getText();
							String strButton2=eleListButton.get(1).getText();
							if(strButton1.contains("Cancel"))
							{
								Reporter.pass("Redeem Ticket Info","Cancel Button is displayed");
							}
							else
							{
								Reporter.fail("Redeem Ticket Info","Cancel Button is not displayed");
							}
							if(strButton2.contains("Confirm"))
							{
								Reporter.pass("Redeem Ticket Info","Confirm Button is displayed");
							}
							else
							{
								Reporter.fail("Redeem Ticket Info","Confirm Button is not displayed");
							}
							eleListButton.get(0).click();
						}
				}
				else
				{
					Reporter.fail("Rent Content","Rent Page Content List is  not displayed");
				}
			}
			else
			{
				Reporter.fail("Rent Content","Rent Page Content List is not displayed");
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
	
	public String fnGetRedeemTicketInfo() throws Throwable
	{
		String strText="";
		try
		{
			strText=getText(RedimTicket, "Redeem Ticket Info");
			System.out.println(strText);
		}
		catch(Exception e){}
		return strText;
	}
	
	public boolean fnRedeemTicket() throws Throwable
	{
		boolean blnStatus=true;
		try
		{
			click(RedimTicket,"Redeem with your 1 Free Ticket");
		}
		catch(Exception e){blnStatus=false;}
		return blnStatus;
	}
	
	/***
	 * Function Name :- fnRedeemTicket
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
	public  boolean fnRedeemRentCollectionWithTicket() throws Throwable
	{
	boolean blnStatus=true;
	try
	{
		List<WebElement> eleList=driver.findElements(RedeemTicketPopUp);
		if(eleList.size()>0)
		{
			Reporter.pass("Redeem Ticket Info","Redeem Ticket Popup is displayed");
			List<WebElement> eleListText=eleList.get(0).findElements(By.xpath("//XCUIElementTypeText"));
			if(eleListText.size()>0)
			{
				String strText1=eleListText.get(0).getText();
				String strText2=eleListText.get(1).getText();
				String strText3=eleListText.get(2).getText();
				if(strText1.length()>0)
				{
					Reporter.pass("Redeem Ticket Info",strText1+" is displayed");
				}
				else
				{
					Reporter.fail("Redeem Ticket Info","Title is not displayed");
				}
				Reporter.pass("Redeem Ticket Info",strText2+" is displayed");
				Reporter.pass("Redeem Ticket Info",strText3+" is displayed");
			}
			List<WebElement> eleListButton=eleList.get(0).findElements(By.xpath("//XCUIElementTypeOther/XCUIElementTypeButton"));
			if(eleListButton.size()>0)
			{
				String strButton1=eleListButton.get(0).getText();
				String strButton2=eleListButton.get(1).getText();
				if(strButton1.contains("Cancel"))
				{
					Reporter.pass("Redeem Ticket Info","Cancel Button is displayed");
				}
				else
				{
					Reporter.fail("Redeem Ticket Info","Cancel Button is not displayed");
				}
				if(strButton2.contains("Confirm"))
				{
					Reporter.pass("Redeem Ticket Info","Confirm Button is displayed");
				}
				else
				{
					Reporter.fail("Redeem Ticket Info","Confirm Button is not displayed");
				}
				//Click On Confirm Button
				if(click(eleListButton.get(1),"Confirm"))
				{
					List<WebElement> eleListRedeem=driver.findElements(TicketRedeemPopup);
					if(eleListRedeem.size()>0)
					{
						List<WebElement> eleListTextRedeem=eleListRedeem.get(0).findElements(By.xpath("//XCUIElementTypeText"));
						if(eleListTextRedeem.size()>0)
						{
							String strRedeem1=eleListTextRedeem.get(0).getText();
							String strRedeem2=eleListTextRedeem.get(1).getText();
							if(strRedeem2.length()>0)
							{
								Reporter.pass("Redeem Ticket Info",strRedeem2+" is displayed");
							}
							else
							{
								Reporter.fail("Redeem Ticket Info","Title is not displayed");
							}
							Reporter.pass("Redeem Ticket Info",strRedeem1+" is displayed");
						}
						List<WebElement> eleListButtonRe=eleListRedeem.get(0).findElements(By.xpath("//XCUIElementTypeOther/XCUIElementTypeButton"));
						if(eleListButtonRe.size()>0)
						{
							String strButtonRe1=eleListButtonRe.get(0).getText();
							String strButtonRe2=eleListButtonRe.get(1).getText();
							if(strButtonRe1.contains("Watchlist"))
							{
								Reporter.pass("Redeem Ticket Info","Watchlist Button is displayed");
							}
							else
							{
								Reporter.fail("Redeem Ticket Info","Watchlist Button is not displayed");
							}
							if(strButtonRe2.contains("Watch Now"))
							{
								Reporter.pass("Redeem Ticket Info","Watch Now Button is displayed");
							}
							else
							{
								Reporter.fail("Redeem Ticket Info","Watch Now Button is not displayed");
							}
							//Click on Watch Now 
							if(click(eleListButtonRe.get(1), "Watch Now"))
							{
								Reporter.pass("Redeem Ticket Info","Watch Now Button is Clicked");
							}
							else
							{
								Reporter.fail("Redeem Ticket Info","Watch Now Button is not Clicked");
								blnStatus=false;
							}
						}
					}
					else
					{
						Reporter.fail("Redeem Ticket Info","Confirm Button is not Clicked");
						blnStatus=false;
					}
				}
				else
				{
					Reporter.fail("Redeem Ticket Info","Redeem Ticket Popup Watch Now is not displayed");
					blnStatus=false;
				}
			}
			
		}
		else
		{
			Reporter.fail("Redeem Ticket Info","Redeem Ticket Popup is not displayed");
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
	/***
	 * Function Name :- fnVerifyExploreRentalPopUp
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
	public  boolean fnVerifyExploreRentalPopUp() throws Throwable
	{
		Reporter.info("HOOQ IOS","Verifying Rent Section Explore Rental PopUp");
		boolean blnStatus=true;
		try
		{
			commonPage.fnSelectTab("rent");
			Thread.sleep(10000);
			if(fnDismissRentalPopUp())
			{
				
				Reporter.pass("Rent Page Popup","Rent Page Popup is displayed");		
			}
			else
			{
				Reporter.fail("Rent Page Popup","Rent Page Popup is not displayed");	
				blnStatus=false;
			}
			if(isElementDisplayed(RentHeaderTitle,"Rent Page"))
			{
				Reporter.pass("Rent Page Screen", "Rent Page is displayed");
			}
			else
			{
				Reporter.fail("Rent Page Screen", "Browse Page is not displayed");
				blnStatus=false;
			}
			commonPage.fnSelectTab("Discover");
			commonPage.fnSelectTab("Rent");
			if(fnDismissRentalPopUp())
			{
				Reporter.fail("Rent Page Popup","Rent Page Popup is displayed");		
			}
			else
			{
				Reporter.pass("Rent Page Popup","Rent Page Popup is not displayed");		
			}
			commonPage.fnSelectTab("Discover");
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			blnStatus=false;
		}
		return blnStatus;
	}
	
	/***
	 * Function Name :- fnVerifyRentSectionContentDetails
	 * Developed By  :- Pankaj Kumar
	 * Date			 :- 23-May-2019 	
	 ***/
	public  boolean fnVerifyRentSectionContentDetails() throws Throwable
	{
		Reporter.info("HOOQ IOS","Verifying Rent Section Content Details");
		boolean blnStatus=true;
		try
		{
			commonPage.fnSelectTab("rent");
			Thread.sleep(10000);
			if(fnDismissRentalPopUp())
			{
				
				Reporter.pass("Rent Page Popup","Rent Page Popup is displayed");		
			}
			else
			{
				Reporter.fail("Rent Page Popup","Rent Page Popup is not displayed");	
				blnStatus=false;
			}
			if(isElementDisplayed(RentHeaderTitle,"Rent Page"))
			{
				Reporter.pass("Rent Page Screen", "Rent Page is displayed");
			}
			else
			{
				Reporter.fail("Rent Page Screen", "Browse Page is not displayed");
				blnStatus=false;
			}
			commonPage.fnSelectTab("Discover");
			commonPage.fnSelectTab("Rent");
			if(fnDismissRentalPopUp())
			{
				Reporter.fail("Rent Page Popup","Rent Page Popup is displayed");	
				blnStatus=false;
			}
			else
			{
				Reporter.pass("Rent Page Popup","Rent Page Popup is not displayed");		
			}
			WebElement eleTbl=driver.findElement(tblRent);
			List<WebElement> eleCat=eleTbl.findElements(By.xpath("XCUIElementTypeCell"));
			String strText1=eleCat.get(1).findElement(By.xpath("XCUIElementTypeStaticText")).getText();
			if(eleCat.size()>0)
			{
				eleCat.get(1).click();
				Thread.sleep(10000);
				String strText=driver.findElement(RentPageInnerTitle).getText();
				if(strText.equalsIgnoreCase(strText1))
				{
					Reporter.pass("Rent Content","Rent Page Content Title "+strText+" is displayed");	
				}
				else
				{
					Reporter.fail("Rent Content","Rent Page Content Title "+strText+" is not displayed");
					blnStatus=false;
				}
				List<WebElement> eleContent=driver.findElement(By.xpath("//XCUIElementTypeCollectionView")).findElements(By.xpath("XCUIElementTypeCell"));
				if(eleContent.size()>0)
				{
					Reporter.pass("Rent Content","Rent Page Content List Total Collection : " + eleContent.size() +" is displayed");
					eleContent.get(0).click();
				}
				else
				{
					Reporter.fail("Rent Content","Rent Page Content List is not displayed");
					blnStatus=false;
				}
			}
			else
			{
				Reporter.fail("Rent Content","Rent Page Content List is not displayed");
			}
		}
		catch(Exception e)
		{
			Reporter.fnPrintException(e);
			blnStatus=false;
		}
		return blnStatus;
	}
	
}
