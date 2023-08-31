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
public class TC24_CheckNewButtonOnLeadsHome extends ReUsableClass {
	
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
			
			//click on the new button displayed in the Recent Leads frame
			
			@Test(priority = 3)
			void step3() {
				
				WebElement newBtn=driver.findElement(By.xpath("//input[@value=' New ']"));
				
				clickElement(newBtn);
				
				String expectedTitle="Lead Edit: New Lead ~ Salesforce - Developer Edition";
				
				boolean flag=wait.until(ExpectedConditions.titleIs(expectedTitle));
				
				Assert.assertTrue(flag);
				
			}
			
     // Enter Last name and compant name
			
			@Test(priority = 4)
			void step4() {
				
				WebElement lastName=driver.findElement(By.id("name_lastlea2"));
				
				enterText(lastName, "ABCD");
				
               WebElement compnyName=driver.findElement(By.id("lea3"));
				
				enterText(compnyName, "XYZ");
				
				
				WebElement saveBtn=driver.findElement(By.xpath("//input[@value=' Save ']"));
				
				clickElement(saveBtn);
				
				
			boolean flag=wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//div[@class='textBlock']//h2")), "ABCD"));
				
			Assert.assertTrue(flag);
				
				
				
			}

}
