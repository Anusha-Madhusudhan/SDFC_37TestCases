/**
 * 
 */
package com.teckArch.sfdc;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;



/**
 * 
 */
public class TC34_VerifyUpdatedLastName extends ReUsableClass {
	
	@Test
	void verifyUpdatedLastName() throws InterruptedException {
		
		validLoginToSalesForce(driver);
		
		 WebElement userMenuBtn=driver.findElement(By.xpath("//div[@id='userNav']//child::div[substring-before(@class,'Button') and @id='userNavButton']"));
		 
		
		 
		 WebElement myProfile=driver.findElement(By.xpath("//div[@id='userNav']//child::div[substring-before(@class,'Button') and @id='userNavButton'] //following-sibling::div//child::div[@id='userNav-menuItems']//a[1]"));
         userMenuBtn.click();
		 
		 
		 myProfile.click();
		 
		 By profilePageLocator=By.id("profileTab_sfdc.ProfilePlatformFeed");
		 
		
		 
		 if(wait.until(ExpectedConditions.visibilityOfElementLocated(profilePageLocator)).isDisplayed()) {
			 

			 By locator=By.xpath("//a[@class='contactInfoLaunch editLink']//img[@title='Edit Profile']");
			 
			 WebElement editProfile=wait.until(ExpectedConditions.elementToBeClickable(locator));
			 
			 editProfile.click();
			 
		 }
		 
		 
		 
		 

		 
	  WebDriver driver=wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("contactInfoContentId"));
		 

		 
		 
		 
		 driver.findElement(By.xpath("//li[@id='aboutTab']")).click();
		 
		 WebElement lastName= driver.findElement(By.cssSelector("#lastName"));
		 
		 lastName.clear();
		 lastName.sendKeys("ABCD");
		 
		 driver.findElement(By.xpath("//div[@class='net-buttons zen-mtl']//input[1]")).click();
		 
		 driver.switchTo().parentFrame();
		 
		 String actualUserName=driver.findElement(By.id("tailBreadcrumbNode")).getText();
		 
		 Assert.assertTrue(actualUserName.contains("ABCD"));
		 
		 String actualUserNameInUserMenuBtn=driver.findElement(By.id("userNavLabel")).getText();
		 
		 Assert.assertTrue(actualUserNameInUserMenuBtn.contains("ABCD"));
		 
		 
		 
		
		
	}

}
