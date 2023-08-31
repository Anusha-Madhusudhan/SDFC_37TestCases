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
public class TC26_CreateNewViewInTheContactPage extends ReUsableClass {
	
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
	
	
	//Click Create new View
	@Test(priority = 3)
	void step3() {
		
		WebElement newViewBtn=driver.findElement(By.linkText("Create New View"));
		
		clickElement(newViewBtn);
		
		String expectedTitle="Contacts: Create New View ~ Salesforce - Developer Edition";
		
		boolean flag=wait.until(ExpectedConditions.titleIs(expectedTitle));
		
		Assert.assertTrue(flag);
		
		
	}
	
	//Enter view name and unique view name
		@Test(priority = 4)
		void step4() {
			
			
			WebElement viewName=driver.findElement(By.id("fname"));
			enterText(viewName, "AAAA");
			
			WebElement viewUniqueName=driver.findElement(By.id("devname"));
			enterText(viewUniqueName, "AAAAAA");
			
			
			WebElement saveBtn=driver.findElement(By.xpath("//input[@value=' Save ']"));
			clickElement(saveBtn);
			
			// 
			
			String expectedTitle="Contacts ~ Salesforce - Developer Edition";
			
			boolean flag=wait.until(ExpectedConditions.titleIs(expectedTitle));
			
			Assert.assertTrue(flag);
			
			
			WebElement view=driver.findElement(By.xpath("//select[@class='title']"));
			
		Select s=select(view);
		
		List<WebElement> viewOps=s.getAllSelectedOptions();
		
		Assert.assertEquals(viewOps.get(0).getText(), "AAAA");
		
		
		
			
		}
	
	

}
