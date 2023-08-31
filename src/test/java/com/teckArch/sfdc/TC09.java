package com.teckArch.sfdc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09 extends ReUsableClass{
	// Login to the Application
			@Test(priority = 1)
			void login() {

				validLoginToSalesForce(driver);

			}
			
			// Click on Logout option from the drop down
			@Test(priority = 2)
			void step2() throws InterruptedException {
				
				WebElement userMenuBtn=driver.findElement(By.cssSelector("#userNavButton"));
				userMenuBtn.click();
				
				WebElement logOut=driver.findElement(By.xpath("//div[@class='mbrMenuItems']//a[text()='Logout']"));
				
				logOut.click();
				Thread.sleep(2000);
				
				String expTitle="Login | Salesforce";
				
				String actualTitle=driver.getTitle();
				
				Assert.assertEquals(actualTitle, expTitle);
				
				
				
			}
}
