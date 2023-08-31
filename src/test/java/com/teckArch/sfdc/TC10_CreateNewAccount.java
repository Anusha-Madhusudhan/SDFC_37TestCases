/**
 * TC10 CreateAccount
 */
package com.teckArch.sfdc;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 
 */
public class TC10_CreateNewAccount extends ReUsableClass {
	
	// Launch and Login 
	@Test(priority = 1)
	void login() {
		validLoginToSalesForce(driver);
	}
	
	
	// Click on Accounts link on the home page
	@Test(priority = 2)
	void step2() {
		
		WebElement accountTab=driver.findElement(By.cssSelector("#Account_Tab"));
		accountTab.click();
		
		String expAccPageTitle="Accounts: Home ~ Salesforce - Developer Edition";
		
		String actualAccPageTitle=driver.getTitle();
		
		Assert.assertEquals(actualAccPageTitle, expAccPageTitle);
		
		String expUserNAme="Anusha AB";
		
		String actualUserName=driver.findElement(By.xpath("//div[@class='userBlock']//span")).getText();
		
		Assert.assertEquals(actualUserName, expUserNAme);
		
		
		
	}
	
	
//  Click on the New button to create new account
	@Test(dependsOnMethods = {"step2"})
	void step3() {
WebElement newBtn=driver.findElement(By.xpath("//td[@class='pbButton']//input"));
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].click()", newBtn);
		
		
		
		String expAccEditPageTitle="Account Edit: New Account ~ Salesforce - Developer Edition";
		
		String actualAccEditPageTitle=driver.getTitle();
		
		Assert.assertEquals(actualAccEditPageTitle, expAccEditPageTitle);
		
		WebElement accName=driver.findElement(By.cssSelector("input#acc2"));
		accName.clear();
		accName.sendKeys("PQR");
		
		WebElement type=driver.findElement(By.cssSelector("select#acc6"));
		
		Select sType=new Select(type);
		
		sType.selectByValue("Technology Partner");
		
		
		
		WebElement custPriority=driver.findElement(By.xpath("(//table[@class='detailList'])[3]//tbody//tr//td[2]//span//select[@id='00NHu00000PEMLd']"));
		
		Select sCustPri=new Select(custPriority);
		
		sCustPri.selectByValue("High");
		
		WebElement saveBtn=driver.findElement(By.xpath("(//input[@value=' Save '])[2]"));
		saveBtn.click();
		
		String actualAccNAme=driver.findElement(By.xpath("//div[@class='textBlock']//h2")).getText();
		
		String expAccName="PQR";
		
		Assert.assertEquals(actualAccNAme, expAccName);
	}
	
	
	
	
	
	
	
	
	
	

}
