/**
 * 
 */
package com.teckArch.sfdc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * TC13 MergeAccounts
 */
public class TC13_MergeAccounts extends ReUsableClass {
	
	// Launch and Login 
				@Test(priority = 1)
				void login() {
					validLoginToSalesForce(driver);
				}
				
				
				// Click on Accounts link on the home page
				@Test(priority = 2)
				void step2() throws InterruptedException {
					
					WebElement accountTab=driver.findElement(By.cssSelector("#Account_Tab"));
					accountTab.click();
					
					String expAccPageTitle="Accounts: Home ~ Salesforce - Developer Edition";
					
					Thread.sleep(2000);
					
					String actualAccPageTitle=driver.getTitle();
					
					Assert.assertEquals(actualAccPageTitle, expAccPageTitle);
					
					String expUserNAme="Anusha AB";
					
					String actualUserName=driver.findElement(By.xpath("//div[@class='userBlock']//span")).getText();
					
					Assert.assertEquals(actualUserName, expUserNAme);
					
				}
				

				//Select accounts to merge
				@Test(dependsOnMethods = {"step2"})
				void step3() throws InterruptedException {
					
					WebElement mergeLink=driver.findElement(By.xpath("//div[@class='toolsContentRight']//ul//li//a[text()='Merge Accounts']"));
					mergeLink.click();
					
					String expMergePageTitle="Merge My Accounts ~ Salesforce - Developer Edition";
					
					Thread.sleep(2000);
					
					String actualMergerPageTitle=driver.getTitle();
					
					Assert.assertEquals(actualMergerPageTitle, expMergePageTitle);
					
					
					
					
				}
				

}
