/**
 * 
 */
package com.teckArch.sfdc;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 
 */
public class TC16_CreateANewOpty extends ReUsableClass {
	
	// Login
		@Test(priority = 1)
		void step1() {

			validLoginToSalesForce(driver);

		}

		//
		// Click on opportunities link
		@Test(priority = 2)
		void step2() {

			WebElement opportunities = driver.findElement(By.id("Opportunity_Tab"));

			clickElement(opportunities);

			String expectedTitle = "Opportunities: Home ~ Salesforce - Developer Edition";

			boolean flag = wait.until(ExpectedConditions.titleIs(expectedTitle));

			Assert.assertTrue(flag);

		}
		
		
		// Click on the New button to create new Opty
		
		@Test(priority = 3)
		void step3() throws InterruptedException {
			
			WebElement newBtn=driver.findElement(By.xpath("//input[@value=' New ']"));
			
			clickElement(newBtn);
			
			String expectedTitle="Opportunity Edit: New Opportunity ~ Salesforce - Developer Edition";
		boolean flag=wait.until(ExpectedConditions.titleIs(expectedTitle));
		
		assertTrue(flag);
		
		WebElement oppName=driver.findElement(By.id("opp3"));
		
		enterText(oppName,"XXX");
		
		WebElement accName=driver.findElement(By.id("opp4_lkwgt"));
		
		clickElement(accName);
		
//		String parentWin=swichToNewWindow(driver);
		
       Set<String> windowHandles=driver.getWindowHandles();
		 
		 List<String> list=new ArrayList<String>(windowHandles);
		 
		 String parentWindowHandle=list.get(0);
		 
		 String childWindowHandle=list.get(1);
		 
		 driver.switchTo().window(childWindowHandle);
		 
		 Thread.sleep(2000);
		 
		 driver.switchTo().frame("searchFrame");
		
		WebElement inputText=driver.findElement(By.xpath("//div[@class='pBody']//input[@id='lksrch']"));
		inputText.clear();
		enterText(inputText,"A1");
		 Thread.sleep(2000);
		
		WebElement goBtn=driver.findElement(By.xpath("//input[@value=' Go! ']"));
		
//		clickElement(goBtn);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", goBtn);
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("resultsFrame");
		
		List<WebElement> list2=driver.findElements(By.xpath("//table//tbody//tr//th//a"));
		
		for(WebElement ele:list2) {
			
			if(ele.getText().equals("A1")) {
				clickElement(ele);
				break;
			}
			
		}
		
		
//		driver.switchTo().defaultContent(); // Bcz child window will be closed after selecting the Account name.
		                                    // No need to switch
		
		driver.switchTo().window(parentWindowHandle);
		
		WebElement closedate=driver.findElement(By.id("opp9"));
		enterText(closedate, "8/23/2023");
		
		WebElement stage=driver.findElement(By.id("opp11"));
		
		select(stage,"Qualification");
		
		WebElement saveBtn=driver.findElement(By.xpath("//input[@value=' Save ']"));
		clickElement(saveBtn);
		
		String actualOppName=driver.findElement(By.className("pageDescription")).getText();
		
		String expectedOppName="XXX";
		
		Assert.assertEquals(actualOppName, expectedOppName);
		
		
		
		
		
		
		
			
		}

		

}
