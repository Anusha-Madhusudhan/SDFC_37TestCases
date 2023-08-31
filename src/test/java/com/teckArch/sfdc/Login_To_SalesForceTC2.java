package com.teckArch.sfdc;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Login_To_SalesForceTC2 extends ReUsableClass {
	
	
	@Test
	void login() {
		validLoginToSalesForce(driver);
	}
	
	
	

//	public static void main(String[] args) {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
//		
//		driver.get("https://login.salesforce.com");
//		
//		try {
//			Thread.sleep(2000);
//			
//			
//		} catch (InterruptedException e) {
//			
//			e.printStackTrace();
//		}
//		
//		validLoginToSalesForce(driver);
//		
//		driver.close();
//
//
//	}

	}


