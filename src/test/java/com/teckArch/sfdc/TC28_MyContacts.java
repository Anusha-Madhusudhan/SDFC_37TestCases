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
public class TC28_MyContacts extends ReUsableClass{
	
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
			
			
			//Select 'My Contacts'
			@Test(priority = 3)
			void step3() {
				
				WebElement viewSelect=driver.findElement(By.id("fcf"));
				
				select(viewSelect, "My Contacts");
				
//				WebElement goBtn
				WebElement goBtn=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@value=' Go! ']"))));
				
				
				goBtn.click();
				
				WebElement tableHeaderRow=driver.findElement(By.xpath("//table//thead//tr"));
				
				List<WebElement> coloumns=tableHeaderRow.findElements(By.tagName("td"));
				
				for(WebElement ele:coloumns) {
					
					System.out.print(ele.getText()+"   ");
				}
				
				System.out.println();
				
				//table[@class='x-grid3-row-table']//tbody//tr//td
				
				List<WebElement> tableBodyRow=driver.findElements(By.xpath("//table[@class='x-grid3-row-table']//tbody//tr"));
				
				
				
				for(WebElement row:tableBodyRow) {
					
					List<WebElement> colms=row.findElements(By.tagName("td"));
					
					for(WebElement colm:colms) {
						
						System.out.print(colm.getText()+"   ");
						
					}
					System.out.println();
					
				}
				
			}

}
