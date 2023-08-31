package com.teckArch.sfdc;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

// Select user menu for <username> drop down

public class TC05 extends ReUsableClass{
	
	
	@BeforeClass
	void startUp() {
		startConnLaunchBrowser();
	}
	
	@Test(priority = 1)
	void login() {
		validLoginToSalesForce(driver);
	}
	

//	public static void main(String[] args) throws InterruptedException {
//
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//
//		driver.get("https://login.salesforce.com");
//
//		driver.manage().window().maximize();
//
//		Thread.sleep(2000);
//
//	    validLoginToSalesForce(driver);
//
//		userNameMunuBtnDropDown(driver);
//
//		driver.close();
//	}
     @Test(priority = 2)
	   void userNameMunuBtnDropDown() throws InterruptedException {
		List<String> expectedMenuList = new ArrayList<String>();

		expectedMenuList.add("My Profile");
		expectedMenuList.add("My Settings");
		expectedMenuList.add("Developer Console");
		expectedMenuList.add("Switch to Lightning Experience");
		expectedMenuList.add("Logout");

		// div[@id='userNav-menuItems']

		Thread.sleep(2000);

		WebElement userNameMenu = driver.findElement(By.xpath("//div[@id='userNavButton']"));

		userNameMenu.click();

		// div[@id='userNavMenu']//descendant::a

		List<WebElement> actualMenuList = driver.findElements(By.xpath("//div[@id='userNavMenu']//descendant::a"));

		int i = 0;
		boolean flag = false;
		for (WebElement ele : actualMenuList) {

			System.out.println(ele.getText());

			if (ele.getText().equals(expectedMenuList.get(i))) {
				i++;
				flag = true;
			} else {
				flag = false;
				break;
			}

		}

		if (flag == true) {
			System.out.println("TEST PASSED");
		} else {
			System.out.println("TEST Failed");
		}

	}
     
     
     @AfterClass
     void closeConn() {
    	 driver.close();
     }

}
