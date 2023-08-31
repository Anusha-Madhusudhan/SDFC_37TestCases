package com.teckArch.sfdc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_Error_Message_TC01 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://login.salesforce.com");
		
		Thread.sleep(2000);
		
		loginToSalesForce(driver);
		
		driver.close();

	}

	  static void loginToSalesForce(WebDriver driver) {
		
		
		
		WebElement userName=driver.findElement(By.xpath("//input[@id='username']"));
		
		WebElement passWord=driver.findElement(By.xpath("//input[contains(@class,'password')]"));
		
		
		WebElement loginBtn=driver.findElement(By.xpath("//input[@type='submit' and  @id='Login']"));
		
		userName.clear();
		
		userName.sendKeys("anusha@tek.com");
		
		passWord.clear();
		
		loginBtn.click();
		
		
		
		
		String expected="Please enter your password.";
		
	
		
		if(driver.getPageSource().contains(expected)) {
			System.out.println("Login Failed without valid Password...!!!  Test case PASSED");
		}else {
			System.out.println("Test case Failed");
		}
		
	}

}
