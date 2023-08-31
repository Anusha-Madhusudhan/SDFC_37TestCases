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
public class TC35_VerifyTabCustomization extends ReUsableClass {
	
	
	@Test
	void verifyTabCustomization() {
		
		validLoginToSalesForce(driver);
		
		WebElement plusSignBtn=driver.findElement(By.id("AllTab_Tab"));
		
		clickElement(plusSignBtn);
		
		String expectedTitle1="All Tabs ~ Salesforce - Developer Edition";
		
	Assert.assertTrue(wait.until(ExpectedConditions.titleIs(expectedTitle1)));
	
	WebElement customizeTab=driver.findElement(By.xpath("//input[@value='Customize My Tabs']"));
	
	clickElement(customizeTab);
	
	String expectedTitle2="Customize My Tabs ~ Salesforce - Developer Edition";
		
	Assert.assertTrue(wait.until(ExpectedConditions.titleIs(expectedTitle2)));
	
	WebElement selectedTabs=driver.findElement(By.id("duel_select_1"));
	
	select(selectedTabs, "Opportunities");
	
	WebElement removeBtn=driver.findElement(By.id("duel_select_0_left"));
	clickElement(removeBtn);
	
	
	WebElement availableTabs=driver.findElement(By.id("duel_select_0"));
	
	Select s=new Select(availableTabs);
	
	List<WebElement> availableOps=s.getOptions();
	boolean isTabAvailable=false;
	
	for(WebElement op:availableOps) {
		
		if(op.getText().equals("Opportunities")) {
			isTabAvailable=true;
			break;
		}
		
	}
	
	Assert.assertTrue(isTabAvailable);
	
	WebElement saveBtn=driver.findElement(By.xpath("//input[@value=' Save ']"));
	
	clickElement(saveBtn);
	
	Assert.assertTrue(wait.until(ExpectedConditions.titleIs(expectedTitle1)));
	
	List<WebElement> tabBar=driver.findElements(By.xpath("//ul[@id='tabBar']//li//a"));
	
	
    boolean isTabAvailableInTabBar=true;
	
	for(WebElement op:tabBar) {
		
		if(op.getText().equals("Opportunities")) {
			isTabAvailable=false;
			break;
		}
		
	}
	
	Assert.assertTrue(isTabAvailableInTabBar);
	
	WebElement userMenuBtn=driver.findElement(By.cssSelector("#userNavButton"));
	clickElement(userMenuBtn);
	
	WebElement logout=driver.findElement(By.xpath("//div[@class='mbrMenuItems']//a[text()='Logout']"));
	
	clickElement(logout);
	
	String loginPageTitle="Login | Salesforce";
	
	Assert.assertTrue(wait.until(ExpectedConditions.titleIs(loginPageTitle)));
	
	validLoginToSalesForce(driver);
	
	List<WebElement> tabBar2=driver.findElements(By.xpath("//ul[@id='tabBar']//li//a"));
	
    boolean isTabAvailableInTabBar2=true;
	
	for(WebElement op:tabBar2) {
		
		if(op.getText().equals("Opportunities")) {
			isTabAvailable=false;
			break;
		}
		
	}
	
	Assert.assertTrue(isTabAvailableInTabBar2);
	
	// adding Tab code should be here
		
	}

}
