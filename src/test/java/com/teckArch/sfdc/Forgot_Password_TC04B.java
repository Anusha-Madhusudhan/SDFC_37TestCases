package com.teckArch.sfdc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Forgot_Password_TC04B {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://login.salesforce.com");
		
	
			Thread.sleep(2000);
			
			WebElement username=driver.findElement(By.xpath("//div[@id='username_container']//child::input[position()=1]"));
			
			WebElement pwd=driver.findElement(By.xpath("//div[@id='usernamegroup']//following-sibling::input[contains(@class,'password')]"));
			
			WebElement loginBtn=driver.findElement(By.xpath("//div[contains(@class,'remember')]//preceding-sibling::input[@id='Login']"));
			
			
			username.sendKeys("123");
			pwd.sendKeys("1234");
			loginBtn.click();
			
			String expectedErr="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
			
			String actual=driver.findElement(By.xpath("//div[@id='error']")).getText();
			
			if(expectedErr.equals(actual)) {
				System.out.println("TEst PASSED");
			}else {
				System.out.println("TEst Failed");
			}

			driver.close();
	}

}
