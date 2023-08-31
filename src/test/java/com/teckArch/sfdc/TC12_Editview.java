/**
 * 
 */
package com.teckArch.sfdc;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *   TC12 Editview 
 */
public class TC12_Editview extends ReUsableClass {
	
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
			
			
			// Select the <view name> from the view drop down list on the account page to edit
			@Test(dependsOnMethods = {"step2"})
			void step3() throws InterruptedException{
				
				WebElement vieList=driver.findElement(By.xpath("//div[@class='bFilterView']//select"));
				
				Select selViewList=new Select(vieList);
				
				selViewList.selectByVisibleText("LMN11112");
				
				WebElement editLink=driver.findElement(By.xpath("//div[@class='bFilterView']//a[1]"));
				
				editLink.click();
				
				String expAccountEditPageTitle="Accounts: Edit View ~ Salesforce - Developer Edition";
				
				Thread.sleep(2000);
				
				String actualEditPageTitle=driver.getTitle();
				
				Assert.assertEquals(actualEditPageTitle, expAccountEditPageTitle);
				
			}

			// Select the <view name> from the view drop down list on the account page to edit
						@Test(dependsOnMethods = {"step3"})
						void step4() throws InterruptedException{
							WebElement vieName=driver.findElement(By.cssSelector("#fname"));
							
							vieName.clear();
							vieName.sendKeys("LMN1111222");
							
							WebElement selectField=driver.findElement(By.cssSelector("#fcol1"));
							Select selField=new Select(selectField);
							
							selField.selectByVisibleText("Account Name");
							
							WebElement selectOperator=driver.findElement(By.cssSelector("#fop1"));
							Select selOpr=new Select(selectOperator);
							
							selOpr.selectByVisibleText("contains");
							
							
							WebElement value=driver.findElement(By.cssSelector("#fval1"));
							
							value.clear();
							value.sendKeys("a");
							
							
							
							WebElement selectAvailFields=driver.findElement(By.cssSelector("#colselector_select_0"));
							Select selAvailField=new Select(selectAvailFields);
							
							
							
							selAvailField.selectByVisibleText("Last Activity");
							Thread.sleep(2000);
							
							WebElement addBtn=driver.findElement(By.xpath("(//div[@class='zen-mbs text']//a)[1]"));
							
							addBtn.click();
							Thread.sleep(2000);
							
							WebElement saveBtn=driver.findElement(By.xpath("//input[@value=' Save ']"));
							
							saveBtn.click();
							
							WebElement vieList=driver.findElement(By.xpath("//div[@class='controls']//select"));
							
							Select selViewList=new Select(vieList);
							
						  String actualSelOp=	selViewList.getFirstSelectedOption().getText();
							
							Assert.assertEquals(actualSelOp, "LMN1111222");
							
							//div[@class='x-grid3-header-offset']//table//thead//tr//td//div//a
							
							List<WebElement> list=driver.findElements(By.xpath("//div[@class='x-grid3-header-offset']//table//thead//tr//td//div"));
							
							String actualAvailField="Last Activity";
							
							boolean flag=false;
							
							for(WebElement ele:list) {
								
								if(ele.getText().equals(actualAvailField)) {
									
									System.out.println(ele.getText());
									flag=true;
									Assert.assertTrue(true,"Last Activity coloum added");
									break;
								}
							}
							
							if(flag==false) {
								Assert.assertTrue(false,"Last Activity coloum not added");
							}
							
							//table[@class='x-grid3-row-table']//tbody//tr//td[4]//div//a//span
							
							List<WebElement> accNameList=driver.findElements(By.xpath("//table[@class='x-grid3-row-table']//tbody//tr//td[4]//div//a//span"));
							
							boolean flag2=false;
							
							for(WebElement ele:accNameList) {
								
							if(ele.getText().contains("a")){
								flag2=true;
									continue;
								}
							else {
								flag2=false;
								break;
							}
								
							}
							
							
							Assert.assertTrue(flag2);
							
						}
			
}
