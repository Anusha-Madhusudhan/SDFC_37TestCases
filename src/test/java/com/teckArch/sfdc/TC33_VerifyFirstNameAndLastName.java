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
public class TC33_VerifyFirstNameAndLastName extends ReUsableClass {
	
	// Login
			@Test(priority = 1)
			void step1() {

				validLoginToSalesForce(driver);
				String expectedTitle="Home Page ~ Salesforce - Developer Edition";
				Assert.assertTrue(wait.until(ExpectedConditions.titleIs(expectedTitle)));
				
				WebElement home=driver.findElement(By.linkText("Home"));
				home.click();
				
				String expectedHomePageTitle="Salesforce - Developer Edition";
				Assert.assertTrue(wait.until(ExpectedConditions.titleIs(expectedHomePageTitle)));
				
				WebElement userName=driver.findElement(By.xpath("//h1[@class='currentStatusUserName']//a"));
				String expectedUserName=userName.getText();
				userName.click();
				
				
				
				String actualUserNAme=driver.findElement(By.id("tailBreadcrumbNode")).getText();
				
//				Assert.assertEquals(actualUserNAme, expectedUserName);
				
				if(actualUserNAme.contains(expectedUserName)) {
					Assert.assertTrue(true);
				}
				else {
					Assert.assertTrue(false);
				}
				
				Assert.assertTrue(wait.until(ExpectedConditions.titleContains(expectedUserName)));
				
				
				
				

			}

}
