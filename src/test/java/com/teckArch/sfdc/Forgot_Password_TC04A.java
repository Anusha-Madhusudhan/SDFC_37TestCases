package com.teckArch.sfdc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Forgot_Password_TC04A {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://login.salesforce.com");
		
	
			Thread.sleep(2000);
			
			
	   WebElement forgotPsw=driver.findElement(By.xpath("//div[@class='w0 links bt pt16 mb20']//a"));
	   
	   forgotPsw.click();
	   
	 //div[@class='verifyform']//input[@type='email']
	   
	   WebElement usrName=driver.findElement(By.xpath("//div[@class='verifyform']//input[@type='email']"));
	   
	   usrName.sendKeys("anusha@tek.com");
	   
	 //div[@class='verifyform']//input[2]
	   
	 WebElement continueBtn=  driver.findElement(By.xpath("//div[@class='verifyform']//input[2]"));
	   continueBtn.click();
	   Thread.sleep(2000);
	   
	   
	   String expectedTitle="Check Your Email | Salesforce";
	   
	   if(expectedTitle.equals(driver.getTitle())) {
		   
		   System.out.println("Test Passed");
	   }
	   else {
		   System.out.println("Test FAiled");
	   }
		
	   driver.close();

	}

}
