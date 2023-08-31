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
public class TC32_VerifySaveAndNewButton extends ReUsableClass{

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
		enterText(lastName, "Kavya");
		
		
		WebElement accountName=driver.findElement(By.id("con4_lkwgt"));
		enterText(accountName, "A2");
		
		
		WebElement saveAndNewBtn=driver.findElement(By.xpath("//input[@value='Save & New']"));
		saveAndNewBtn.click();
		
       String expectedNewContactTitle="Contact Edit: New Contact ~ Salesforce - Developer Edition";
		
		boolean flag=wait.until(ExpectedConditions.titleIs(expectedNewContactTitle));
		
		Assert.assertTrue(flag);
		
		
	}
}
