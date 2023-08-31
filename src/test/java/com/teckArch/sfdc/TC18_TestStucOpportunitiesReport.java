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
public class TC18_TestStucOpportunitiesReport extends ReUsableClass{
	
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
			
			
			// Click on Quarterly Summary link      
			
			@Test(priority = 3)
			void step3() {
				
				//quarter_q
				
				WebElement interval=driver.findElement(By.id("quarter_q"));
				
				select(interval, "Next FQ");
				

				WebElement include=driver.findElement(By.id("open"));
				
				select(include, "Open Opportunities");
				
				
				WebElement runReportBtn=driver.findElement(By.xpath("//input[@value='Run Report']"));
				
				clickElement(runReportBtn);
				
				
				
				
				String extectedPipelinePageTitle="Opportunity Report ~ Salesforce - Developer Edition";
				
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
