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
public class TC25_CreateNewContact extends ReUsableClass {
	
	// Login
				@Test(priority = 1)
				void step1() {

					validLoginToSalesForce(driver);

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
				
				
				
				// Click New Button
				@Test(priority = 3)
				void step3() {
					
					
					WebElement newBtn=driver.findElement(By.xpath("//input[@value=' New ']"));
					
					clickElement(newBtn);
					
                   String expectedNewContactTitle="Contact Edit: New Contact ~ Salesforce - Developer Edition";
					
					boolean flag=wait.until(ExpectedConditions.titleIs(expectedNewContactTitle));
					
					Assert.assertTrue(flag);
					
				}
				
				
				// Enter Last Name and account name
				@Test(priority = 4)
				void step4() {
					
					WebElement lastName=driver.findElement(By.id("name_lastcon2"));
					enterText(lastName, "Indian");
					
					
					WebElement accountName=driver.findElement(By.id("con4_lkwgt"));
					clickElement(accountName);
					
				String parentWindow=swichToNewWindow();
				
				driver.switchTo().frame("searchFrame");
				
				WebElement text=driver.findElement(By.id("lksrch"));
				
				enterText(text, "A1");
				
				WebElement goBtn=driver.findElement(By.xpath("//input[@value=' Go! ']"));
				
				clickElement(goBtn);
				
				driver.switchTo().defaultContent();
				
				driver.switchTo().frame("resultsFrame");
				
				List<WebElement> list=driver.findElements(By.xpath("//table//tr//th"));
				
				for(WebElement ele:list) {
					
					if(ele.getText().equals("")) {
						clickElement(ele);
						break;
					}
					
				}
				
				driver.switchTo().window(parentWindow);
				
				WebElement saveBtn=driver.findElement(By.xpath("//input[@value=' Save ']"));
				
				clickElement(saveBtn);
				
				
				
				boolean flag=wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//div[@class='textBlock']//h2")), "Indian"));
				
				Assert.assertTrue(flag);
					
					
				}

}
