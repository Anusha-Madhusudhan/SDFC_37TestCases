/**
 * 
 */
package com.teckArch.sfdc;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 
 */
public class TC17_TestOpportunityPipelineReport extends ReUsableClass{
	
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
			
			
			// Click on Opportunity Pipeline link  
			
			@Test(priority = 3)
			void step3() {
				
				WebElement pipeline=driver.findElement(By.xpath("//div[@class='lbBody']//ul//li//a[contains(text(),'Pipeline')]"));
				
				clickElement(pipeline);
				
				String extectedPipelinePageTitle="Opportunity Pipeline ~ Salesforce - Developer Edition";
				
				boolean flag=wait.until(ExpectedConditions.titleIs(extectedPipelinePageTitle));
				
				Assert.assertTrue(flag);
				
				
				List<WebElement> tableHeaders=driver.findElements(By.xpath("//table[@class='reportTable tabularReportTable']//tbody//tr//th"));
				
				for(WebElement ele:tableHeaders) {
					
					System.out.print(ele.getText()+"      ");
				}
				
				System.out.println();
				
				
				
				List<WebElement> rows=driver.findElements(By.xpath("//table[@class='reportTable tabularReportTable']//tbody//tr[@class='even']"));
				
				
				for(int i=0;i<rows.size();i++) {
					
//					List<WebElement> columns=driver.findElements(By.xpath("(//table[@class='reportTable tabularReportTable']//tbody//tr[@class='even'])["+i+"]//td"));
					List<WebElement> columns=rows.get(i).findElements(By.tagName("td"));
					
					for(WebElement ele:columns) {
						
						System.out.print(ele.getText()+"   ");
					}
					System.out.println();
				}
				
			}

}
