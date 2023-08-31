package com.teckArch.sfdc;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC14_CreateAccountReport extends ReUsableClass {

	
	// Login 
	@Test(priority = 1)
	void step1() {
		
		validLoginToSalesForce(driver);
		
	}
	
	// Click on Accounts link on the home page
	@Test(priority = 2)
	void step2() {
		
		WebElement acctTab=driver.findElement(By.cssSelector("#Account_Tab"));
		
		acctTab.click();
		
		String expectedTitle="Accounts: Home ~ Salesforce - Developer Edition";
		
		
		
	    boolean flag=wait.until(ExpectedConditions.titleIs(expectedTitle));
		
		Assert.assertTrue(flag);
		
		
		String actualUserName=driver.findElement(By.xpath("//div[@class='userBlock']//child::span[@class='mruText']")).getText();
		
		String expectedUserName="Anusha AB";
		
		Assert.assertEquals(actualUserName, expectedUserName);
		
	}
	
	//Create account report
	@Test(priority = 3)
	void step3() {
		
		
		WebElement lastActivity=driver.findElement(By.xpath("//div[@class='lbBody']//ul//li//a[contains(text(),'activity')]"));
		
		lastActivity.click();
		
	   String expectedReportPageTitle="Unsaved Report ~ Salesforce - Developer Edition";
	   
	  boolean flag=wait.until(ExpectedConditions.titleIs(expectedReportPageTitle));
	  
	  Assert.assertTrue(flag);
		
	}
	
	//Select report options
		@Test(priority = 4)
		void step4() throws InterruptedException {
			
			driver.findElement(By.cssSelector("#ext-gen20")).click();
			
			WebElement dateField=driver.findElement(By.xpath("//div[@class='x-combo-list-inner']//div[text()='Created Date']"));
			
			dateField.click();
			
//			driver.findElement(By.cssSelector("#ext-gen152")).click();
//			
//			Thread.sleep(2000);
//			
//			driver.findElement(By.xpath("//table[@id='ext-comp-1111']//td//button")).click();
//			Thread.sleep(2000);
//            driver.findElement(By.cssSelector("#ext-gen154")).click();
//            Thread.sleep(2000);
//			
//			
//			driver.findElement(By.xpath("//table[@id='ext-comp-1113']//td//button")).click();
			
			Thread.sleep(2000);
			
//			
			WebElement from=driver.findElement(By.xpath("//input[@name='startDate']"));
			from.clear();
			from.sendKeys("8/21/2023");
			
			
			
           WebElement endDate=driver.findElement(By.xpath("//input[@name='endDate']"));
           endDate.clear();
           endDate.sendKeys("8/21/2023");
           
           
           Actions act=new Actions(driver);
           act.keyDown(Keys.ENTER);
           
           act.keyUp(Keys.ENTER);
           
           act.perform();
           
           Thread.sleep(7000);
			
			WebElement tableHeader=driver.findElement(By.xpath("//div[@class='x-grid3-header-offset']//table[2]"));
			
			WebElement row=tableHeader.findElement(By.tagName("tr"));
			
			List<WebElement> column=row.findElements(By.tagName("td"));
			
			
			for(int i=0;i<column.size();i++) {
				
				System.out.print(column.get(i).getText()+"       ");
			}
			
			System.out.println();
			
			Thread.sleep(2000);
			
			//div[@class='x-grid3-row x-grid3-row-first']//table//tbody
			
			By tableLocator=By.xpath("//table[@class='x-grid3-row-table']");
			
			WebElement dataTable=wait.until(ExpectedConditions.visibilityOf(driver.findElement(tableLocator)));
			
			List<WebElement> rows=dataTable.findElements(By.tagName("tr"));
			
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"+rows.size());
			
			for(int i=0;i<rows.size();i++) {
				
				List<WebElement> columnData=rows.get(i).findElements(By.tagName("td"));
				
				for(int j=0;j<columnData.size();j++) {
					
					System.out.print(columnData.get(j).getText()+"       ");
					
				}
				
				
			}
			
			
		}

		
		
		//Save report
				@Test(priority = 5)
				void step5() throws InterruptedException {
					
					
					WebElement saveBtn=driver.findElement(By.xpath("//button[@id='ext-gen49']"));
					
					saveBtn.click();
					Thread.sleep(2000);
					
					WebElement reportName=driver.findElement(By.cssSelector("#saveReportDlg_reportNameField"));
					reportName.clear();
					Thread.sleep(2000);
					reportName.sendKeys("Repo1235");
					
					
					
					
                  WebElement reportUniqueName=driver.findElement(By.cssSelector("#saveReportDlg_DeveloperName"));
//				reportUniqueName.clear();
				
				Thread.sleep(2000);
					
                  reportUniqueName.sendKeys("1345");
                  
                //tbody//tr[2]//td[2]//em//button
//                  WebElement saveAndRunBtn=driver.findElement(By.xpath("//table[@id='dlgSaveAndRun']"));
//                  JavascriptExecutor js=(JavascriptExecutor) driver;
//                  
//                  js.executeScript("arguments[0].click();", saveAndRunBtn);
                  
                  WebElement saveAndRunBtn=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//table[@id='dlgSaveAndRun']"))));
//                  JavascriptExecutor js=(JavascriptExecutor) driver;
//                  js.executeScript("arguments[0].click()", saveAndRunBtn);
                  
                  saveAndRunBtn.click();
                  
                  
                  Thread.sleep(5000);
                  String expectedReportName="Repo1235";
                  
                  wait.until(ExpectedConditions.urlToBe("https://tekarch89-dev-ed.develop.my.salesforce.com/00OHu00000Axo8S"));
                  
//                  wait.until(ExpectedConditions.)
                  
                  By locator=By.xpath("//div[@class='content']//h1");
                  
                  boolean flag1=wait.until(ExpectedConditions.titleContains("Repo1235"));
                  
                  
//                  wait.until(ExpectedConditions.)
                  
                  boolean flag2=wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(locator), expectedReportName));
                  
//                driver.findElement(locator).getText();
//                  
//                  System.out.println(actualReportName+"**************8");
                  
                  Assert.assertTrue(flag1);
                  
                  Assert.assertTrue(flag2);
				}
		
		
}

