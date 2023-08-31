package com.teckArch.sfdc;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC08 extends ReUsableClass{
	
	// Login to the Application
		@Test(priority = 1)
		void login() {

			validLoginToSalesForce(driver);

		}
	//Click on Developer Console link from the drop down	
		@Test(priority=2)
		void step2() throws InterruptedException {
			
			WebElement userMenuBtn=driver.findElement(By.cssSelector("#userNavButton"));
			userMenuBtn.click();
			
			WebElement devConsole=driver.findElement(By.xpath("//div[@class='mbrMenuItems']//a[text()='Developer Console']"));
			
			devConsole.click();
			
			Thread.sleep(2000);
			
			Set<String> windowHandles=driver.getWindowHandles();
			
			List<String> windowHandlesList=new ArrayList<String>(windowHandles); 
			
			String parentWindow=windowHandlesList.get(0);
			String childWindowHandle=windowHandlesList.get(1);
			
			driver.switchTo().window(childWindowHandle);
			
			String ExpTitle="Developer Console";
			
			String actualTitle=driver.getTitle();
			
			Assert.assertEquals(actualTitle, ExpTitle);
			
			System.out.println("&&&&&&&&&&&&&&&&&");
			
			driver.close();
			
			driver.switchTo().window(parentWindow);
		}

}
