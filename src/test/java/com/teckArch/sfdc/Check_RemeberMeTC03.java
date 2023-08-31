package com.teckArch.sfdc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Check_RemeberMeTC03 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://login.salesforce.com");
		
		try {
			Thread.sleep(2000);
			
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		validLoginToSalesForce(driver);
		
		
		Thread.sleep(2000);
		
		//div[@id='userNav']
		
		driver.findElement(By.xpath("//div[@id='userNav']")).click();
		
		//div[@id='userNav-menuItems']//child::a[last()]
		
		WebElement logOut=driver.findElement(By.xpath("//div[@id='userNav-menuItems']//a[@title='Logout']"));
		
		logOut.click();
		
		Thread.sleep(2000);
		
		//div[@id='idcard']//span
		
		
		String actual=driver.findElement(By.xpath("//div[@id='idcard']//span[@id='idcard-identity']")).getText();
		
		if(actual.equals("anusha@tek.com")) {
			System.out.println("User name is dispalyed on the Uaser name field: Test PASSED");
		}else {
			System.out.println("Test Failed..");
		}
		
		
		driver.close();

	}

	private static void validLoginToSalesForce(WebDriver driver) {
		WebElement userName=driver.findElement(By.xpath("//div[@id='username_container']//div//following-sibling::input[@id='username']"));
		
		//form[@name='login']//div[2]//following-sibling::input[@type='password']
		
		
		WebElement passWord=driver.findElement(By.xpath("//div[@id='pwcaps']//preceding-sibling::input[@type='password']"));
		
		
		WebElement loginBtn=driver.findElement(By.xpath("//div[@id='pwcaps']//following-sibling::input[@id='Login']"));
		
		userName.clear();
		
		userName.sendKeys("anusha@tek.com");
		
		passWord.clear();
		
		passWord.sendKeys("Sumedh@03");
		
		
		//div[substring-before(@class,'remember')]//child::input
		
				// Remember me
				
		driver.findElement(By.xpath("//div[substring-before(@class,'remember')]//child::input")).click();
		
		loginBtn.click();
		
		
		String expected="Home Page ~ Salesforce - Developer Edition";
		
		if(driver.getPageSource().contains(expected)) {
			System.out.println("Login Passed with valid Username and Password...!!!  Test case PASSED");
		}else {
			System.out.println("Test case Failed");
		}
		
		
	}

}
