package com.teckArch.sfdc;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC27_RecentlyCreatedContacts extends ReUsableClass {

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
		
		
		//Select recently created 
		@Test(priority = 3)
		void step3() {
			
			WebElement recentCont=driver.findElement(By.id("hotlist_mode"));
			
			select(recentCont, "Recently Created");
			
			List<WebElement> contactList=driver.findElements(By.xpath("//table[@class='list']//tbody//tr[contains(@class,'dataRow')]//th"));
			for(WebElement ele:contactList) {
				System.out.println(ele.getText());
			}
			
		}

}
