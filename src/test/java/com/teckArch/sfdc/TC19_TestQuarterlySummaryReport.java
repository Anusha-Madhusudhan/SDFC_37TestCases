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
public class TC19_TestQuarterlySummaryReport extends ReUsableClass{
	
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
			
			
			// Click on Stuck Opportunities link    
			
			@Test(priority = 3)
			void step3() {
				
				
				WebElement interval=driver.findElement(By.id("quarter_q"));
				
				select(interval, "Current FQ");
				
				
				WebElement include=driver.findElement(By.id("open"));
				
				select(include, "All Opportunities");
				
				WebElement runReport=driver.findElement(By.xpath("//input[@value='Run Report']"));
				
				clickElement(runReport);
				
				
				
				
				
				String extectedOpptyReportTitle="Opportunity Report ~ Salesforce - Developer Edition";
				
				boolean flag=wait.until(ExpectedConditions.titleIs(extectedOpptyReportTitle));
				
				Assert.assertTrue(flag);
				
				WebElement range=driver.findElement(By.id("quarter_q"));
				
			    Select s=select(range);
			    
			    List<WebElement> selectedList=s.getAllSelectedOptions();
			    
			    Assert.assertEquals(selectedList.get(0).getText(), "Current FQ");
			    
			    
			    
			 
			 
               WebElement show=driver.findElement(By.id("scope"));
				
			    Select s2=select(show);
			    
			    List<WebElement> selectedList2=s2.getAllSelectedOptions();
			    
			    Assert.assertEquals(selectedList2.get(0).getText(), "All opportunities");
				
				
				
				List<WebElement> tableHeaders=driver.findElements(By.xpath("//table[@class='reportTable tabularReportTable']//tr//th"));
				
				for(WebElement ele:tableHeaders) {
					
					System.out.print(ele.getText()+"        ");
				}
				
				System.out.println();
				
				System.out.println();
//				
				List<WebElement> rows=driver.findElements(By.xpath("//table[@class='reportTable tabularReportTable']//tr[@class='odd']"));
				
				
				for(int i=0;i<rows.size();i++) {
					
//					List<WebElement> columns=driver.findElements(By.xpath("//table[@class='reportTable tabularReportTable']//tr[@class='odd']//td"));
					List<WebElement> columns=rows.get(i).findElements(By.tagName("td"));
					
					for(WebElement ele:columns) {
						
						System.out.print(ele.getText()+"       ");
					}
					System.out.println();
				}
				
			}

}
