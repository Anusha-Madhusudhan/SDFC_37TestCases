/**
 * 
 */
package com.teckArch.sfdc;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 
 */
public class TC21_LeadsSelectView extends ReUsableClass {

	// Login
	@Test(priority = 1)
	void step1() {

		validLoginToSalesForce(driver);

	}

	// Click leads tab link from Home Page
	@Test(priority = 2)
	void step2() {

		WebElement leads = driver.findElement(By.xpath("//li[@id='Lead_Tab']//a"));

		clickElement(leads);

		String expectedTitle = "Leads: Home ~ Salesforce - Developer Edition";

		boolean flag = wait.until(ExpectedConditions.titleIs(expectedTitle));

		Assert.assertTrue(flag);

	}

	// click drop down list
	@Test(priority = 3)
	void step3() {
		
		
		WebElement leadsList=driver.findElement(By.id("fcf"));
		
	    Select s=select(leadsList);
	    
	    List<WebElement> optionsList=s.getOptions();
	    
	    List<String> expectedList=new ArrayList<String>();
	    expectedList.add("All Open Leads");
	    expectedList.add("My Unread Leads");
	    expectedList.add("Recently Viewed Leads");
	    expectedList.add("Today's Leads");
	    expectedList.add("View - Custom 1");
	    expectedList.add("View - Custom 2");
	    
	    boolean flag=false;
	    int i=0;
	    
	    for(WebElement ele:optionsList) {
	    	if(ele.getText().equals(expectedList.get(i))) {
	    	i++;
	    	flag=true;
	    	continue;
	    	}
	    	else {
				flag=false;
				break;
			}
	    }
	    
	    
	   Assert.assertTrue(flag);
	   

	}

}
