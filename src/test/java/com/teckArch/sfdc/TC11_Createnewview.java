/**
 * 
 */
package com.teckArch.sfdc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 
 */
public class TC11_Createnewview extends ReUsableClass {

	// Launch and Login 
		@Test(priority = 1)
		void login() {
			validLoginToSalesForce(driver);
		}
		
		
		// Click on Accounts link on the home page
		@Test(priority = 2)
		void step2() {
			
			WebElement accountTab=driver.findElement(By.cssSelector("#Account_Tab"));
			accountTab.click();
			
			String expAccPageTitle="Accounts: Home ~ Salesforce - Developer Edition";
			
			String actualAccPageTitle=driver.getTitle();
			
			Assert.assertEquals(actualAccPageTitle, expAccPageTitle);
			
			String expUserNAme="Anusha AB";
			
			String actualUserName=driver.findElement(By.xpath("//div[@class='userBlock']//span")).getText();
			
			Assert.assertEquals(actualUserName, expUserNAme);
			
		}
		
		// Click on create new view link on accounts page
				@Test(dependsOnMethods = {"step2"})
				void step3() throws InterruptedException {
					
					WebElement creatNewView=driver.findElement(By.xpath("//div[@class='bFilterView']//span[@class='fFooter']//a[2]"));
					
					creatNewView.click();
					Thread.sleep(2000);
					
					String expCreateNewViewTitle="Accounts: Create New View ~ Salesforce - Developer Edition";
					
					String actualNewViewTitle=driver.getTitle();
					
					Assert.assertEquals(actualNewViewTitle, expCreateNewViewTitle);
					
					WebElement viewName=driver.findElement(By.cssSelector("input#fname"));
					
					viewName.clear();
					viewName.sendKeys("LMN3");
					
                    WebElement viewUniqName=driver.findElement(By.cssSelector("input#devname"));
					
                    viewUniqName.clear();
                    viewUniqName.sendKeys("LMN_3");
                    
                    WebElement saveBtn=driver.findElement(By.xpath("//input[@value=' Save ']"));
                    
                    saveBtn.click();
                    
                    // Salesforce - Developer Edition
                    
                   // #errorTitle
                    
                    // #errorDesc
                    
                    
                    //Accounts ~ Salesforce - Developer Edition
                    
                    
                    if(driver.getTitle().equals("Salesforce - Developer Edition")) {
                    	
                    	System.out.println("*************");
                    	
                    	
                    	System.out.println(driver.findElement(By.xpath("//table[@cellspacing='10']//tbody//tr//td//span")).getText());
                    	
                    	System.out.println(driver.findElement(By.xpath("//table[@cellspacing='10']//tbody//tr[2]//td")).getText());
                    	
                    	Assert.assertTrue(false);
                    	
                    }else if(driver.getTitle().equals("Accounts ~ Salesforce - Developer Edition")) {
                    	
                    	 WebElement viewList=driver.findElement(By.xpath("//div[@class='controls']//select"));
                         
                         Select sViewList=new Select(viewList);
                         
                        String actualSelectedView= sViewList.getFirstSelectedOption().getText();
                        
                        String expSelectedView="LMN3";
                        
                        Assert.assertEquals(actualSelectedView, expSelectedView);
					}
                    
                    
                   
					
				}
		
		
		
		
		
		
		
}
