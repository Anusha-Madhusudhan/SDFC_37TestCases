/**
 * 
 */
package com.teckArch.sfdc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 
 */
public class TC20_LeadsTab extends ReUsableClass {

	// Login
	@Test(priority = 1)
	void step1() {

		validLoginToSalesForce(driver);

	}
	
	// Click leads tab link from Home Page
		@Test(priority = 2)
		void step2() {
			
			WebElement leads=driver.findElement(By.xpath("//li[@id='Lead_Tab']//a"));
			
			clickElement(leads);
			
			String expectedTitle="Leads: Home ~ Salesforce - Developer Edition";
			
			boolean flag=wait.until(ExpectedConditions.titleIs(expectedTitle));
			
			Assert.assertTrue(flag);
			
		}
		
		

}
