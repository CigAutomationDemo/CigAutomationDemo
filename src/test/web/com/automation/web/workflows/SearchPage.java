package com.automation.web.workflows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.reports.Reporter;

public class SearchPage extends BasePage{

	By headerSearch = null;
    By txtSearch = null;
    By contentList = null;
    By contentTitleTxt = null;
    
  //Locators
  	public void fnLoadLocators()
  	{
  		try{
  			if(objConfig.strDriverType!=null)
  			{
  				if(objConfig.strDriverType.equals("chromemobileview"))
  				{
  					headerSearch = By.xpath("(//a[contains(@class,'e2e-iconButton IconButton__WrappedLink-sc')]//img)[1]");
  				    txtSearch = By.xpath("(//input[@type='text'])[1]");
  				    contentList = By.xpath("//*[contains(@class,'TitleCardWrapper')]//div//img[1]");
  				    contentTitleTxt = By.xpath("//*[contains(@class,'e2e-titleHeader TitleBasicInfo__TitleHeader')]");
  				}
  				else if(objConfig.strDriverType.equals("androidchrome"))
  				{
  					headerSearch = By.xpath("(//a[contains(@class,'e2e-iconButton IconButton__WrappedLink-sc')]//img)[1]");
  				    txtSearch = By.xpath("(//input[@type='text'])[1]");
  				    contentList = By.xpath("//*[contains(@class,'TitleCardWrapper')]//div//img[1]");
  				    contentTitleTxt = By.xpath("//*[contains(@class,'e2e-titleHeader TitleBasicInfo__TitleHeader')]");
  				}
  				
  				else if(objConfig.strDriverType.equals("desktopchrome"))
  				{
  					headerSearch = By.xpath("(//*[@title='Search'])[2]");
  				    txtSearch = By.xpath("(//input[@type='text'])[1]");
  				    contentList = By.xpath("//*[contains(@class,'TitleCardWrapper')]//div//img[1]");
  				    contentTitleTxt = By.xpath("//*[contains(@class,'e2e-titleHeader TitleBasicInfo__TitleHeader')]");
  				}
  			}
  		}
  		catch(Exception e){}
  	}
	public boolean SearchSpecificItem(String itemToSearch)throws Throwable
	{
		fnLoadLocators();
		boolean result = false;
		try {
			Thread.sleep(2000);
			click(headerSearch,"Search Button");
			Thread.sleep(4000);
			System.out.println(itemToSearch);
			type(txtSearch,itemToSearch,"Search Textbox");
			Thread.sleep(10000);
			if(isElementDisplayed(contentList))
			{
				WebElement contentName = driver.findElement(By.xpath("(//*[contains(@class,'PortraitTitleCard__TitleCardContainer')]//img)["+1+"]"));
				String strText=contentName.getAttribute("title");		
				System.out.println(strText);
				if(strText.contains("|"))
				{
					String[] strTD=strText.split("|");
					strText=strTD[1];
				}
				if(strText.toLowerCase().equals(itemToSearch.toLowerCase()))
				{
					System.out.println(strText);
					JSClick(contentList,strText);
					result=true;
				}
				Thread.sleep(5000);
				String titlename =getText(contentTitleTxt, "Heading of collection is displayed successfully");
				if(strText.contains(titlename))
				{
					Reporter.pass("Verify content title in content details page" ,  ""+ strText +"" +  ""+ titlename+"" + " is Matched successfully");
				}
				else
				{
					Reporter.fail("Verify content title in content details page" , ""+ strText +"" +  ""+ titlename+ ""+ " contents are not Matched");
				}							
				//driver.navigate().back();
			}
			else
			{
				String strText=getText(By.xpath("//*[contains(@class,'PageContentCenter__CenterImage-sc')]/..//h1"), "Search Result error");
				System.out.println(strText);
				Reporter.fail("Verify Search results ", strText+" is displayed");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean SearchSuggestionList()throws Throwable
	{
		fnLoadLocators();
		boolean res = false;
		try {
			Thread.sleep(2000);
			click(headerSearch,"Search Button");    
			Thread.sleep(2000);
			type(txtSearch,"Arr","Search Textbox");
			Thread.sleep(5000);
			if(isElementDisplayed(contentList))
			{
				String searchName ="Arr";
				List<WebElement> searchList =driver.findElements(contentList);
				for(int i=1;i<=searchList.size();i++)
				{
					WebElement contentName = driver.findElement(By.xpath("(//*[contains(@class,'e2e-card Card__CardContainer')]/img)["+i+"]"));
					String strText=contentName.getAttribute("title");		
					if(strText.contains(searchName))
					{
						System.out.println(strText);
						Reporter.pass("Verify search suggestion list  ", "search suggestion list contains "+strText);
					}
					else
					{
						Reporter.fail("Verify search suggestion list  ", "search suggestion list is not displayed");
					}
				}
			}
			else
			{
				String strText=getText(By.xpath("//*[contains(@class,'PageContentCenter__CenterImage-sc-1tepor9-1')]/..//h1"), "Search Result error");
				System.out.println(strText);
				Reporter.fail("Verify Search results ", strText+" is displayed");
			}
			driver.navigate().back();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	
}
