/**
 * 
 */
package com.teckArch.sfdc;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 
 */
public class TC29_ContactPage extends ReUsableClass {
	
	// Login
				@Test(priority = 1)
				void step1() {

					validLoginToSalesForce(driver);
					String expectedTitle="Home Page ~ Salesforce - Developer Edition";
					Assert.assertTrue(wait.until(ExpectedConditions.titleIs(expectedTitle)));

				}

				// Click Contact Tab
				@Test(priority = 2)
				void step2() {
					
					WebElement contact=driver.findElement(By.id("Contact_Tab"));
					clickElement(contact);
					
					String expectedTitle="Contacts: Home ~ Salesforce - Developer Edition";
					
					boolean flag=wait.until(ExpectedConditions.titleIs(expectedTitle));
					
					Assert.assertTrue(flag);
					
				}
				
				//Click on a contact name
				@Test(priority = 3)
				void step3() {
					
				List<WebElement> contacts=driver.findElements(By.xpath("//table[@class='list']//tbody//tr[contains(@class,'dataRow')]//th"));
				
				String contactName="";
				
				for(WebElement ele:contacts) {
					
					if(ele.getText().equals(contactName)) {
						ele.click();
						break;
						
					}
					
				}
					
					
				boolean flag=wait.until(ExpectedConditions.titleContains(contactName));
				
				Assert.assertTrue(flag);
				
				
					
				}

}
