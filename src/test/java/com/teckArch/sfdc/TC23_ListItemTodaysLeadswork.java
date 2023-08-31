/**
 * 
 */
package com.teckArch.sfdc;

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
public class TC23_ListItemTodaysLeadswork extends ReUsableClass {
	
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
		
		// select Todays Leads from the view drop down
		//  click on Today's Leads from the view drop down click on go button
				@Test(priority = 3)
				void step3() {
					
					WebElement leadsList = driver.findElement(By.id("fcf"));
					
					select(leadsList, "Today's Leads");
					
					WebElement goBtn = driver.findElement(By.xpath("//input[@value=' Go! ']"));

					clickElement(goBtn);
					
					WebElement title =wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//select[@class='title']"))));
					
					 

					Select s = select(title);

					List<WebElement> selectedOpn = s.getAllSelectedOptions();

					String expectedSelectedOpn = "Today's Leads";

					Assert.assertEquals(selectedOpn.get(0).getText(), expectedSelectedOpn);

				}
		
		

}
