package com.teckArch.sfdc;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReUsableClass {
	
	    WebDriver driver;
	    WebDriverWait wait;
	
	    @BeforeClass
	    void startConnLaunchBrowser() {
		
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		 wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.get("https://login.salesforce.com");
		
		driver.manage().window().maximize();
		
	}
	
	
	
	/*
	 * Valid Login to SalesForce.com
	 * 
	 * 
	 * 
	 */
	   void validLoginToSalesForce(WebDriver driver) {

			WebElement userName=driver.findElement(By.xpath("//div[@id='username_container']//div//following-sibling::input[@id='username']"));
			
			//form[@name='login']//div[2]//following-sibling::input[@type='password']
			
			
			WebElement passWord=driver.findElement(By.xpath("//div[@id='pwcaps']//preceding-sibling::input[@type='password']"));
			
			
			WebElement loginBtn=driver.findElement(By.xpath("//div[@id='pwcaps']//following-sibling::input[@id='Login']"));
			
			userName.clear();
			
			userName.sendKeys("anusha@tek.com");
			
			passWord.clear();
			
			passWord.sendKeys("Sumedh@03");
			
			loginBtn.click();
			
			
			String expected="Home Page ~ Salesforce - Developer Edition";
			
			if(driver.getPageSource().contains(expected)) {
				System.out.println("Login Passed with valid Username and Password...!!!  Test case PASSED");
			}else {
				System.out.println("Test case Failed");
			}
			
	 }	
	
	   
	   @AfterClass
	    void closeConn() {
	   	 driver.close();
	    }
	   
	   
	   
	   void clickElement(WebElement element){
		   
		   if(element.isDisplayed()) {
			   element.click();
		   }
		   else {
			   System.out.println("Element is not displayed");
		   }
		   
	   }
	   
	   
	  Select select(WebElement element){
		  if(element.isDisplayed()) {
			  
			  
			  Select s=new Select(element);
			  return s;
		   }
		   else {
			   System.out.println("Element is not displayed");
			   return null;
		   }
		  
		   
	   }
	  
	  
	  void enterText(WebElement element,String str) {
            if(element.isDisplayed()&& element.isEnabled()) {
			  
			  element.sendKeys(str);
			  
			  
		   }
		   else {
			   System.out.println("Element is not displayed");
			   
		   }
		  
	  }
	  
	  
	 String swichToNewWindow() {
		 
		 Set<String> windowHandles=driver.getWindowHandles();
		 
		 List<String> list=new ArrayList<String>(windowHandles);
		 
		 String parentWindowHandle=list.get(0);
		 
		 String childWindowHandle=list.get(1);
		 
		 driver.switchTo().window(childWindowHandle);
		return parentWindowHandle;
		 
		 
	 }
	 
	 
	  void select(WebElement element, String string) {
             if(element.isDisplayed()) {
			  
            	 
			  
			  Select s=new Select(element);
			  
			  s.selectByVisibleText(string);
		   }
		   else {
			   System.out.println("Element is not displayed");
		   }
			
		}
	   
}
