/**
 * 
 */
package com.teckArch.sfdc;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 
 */
public class TC22_DefaultView extends ReUsableClass {

	// Login
	@Test(priority = 1)
	void step1() {

		validLoginToSalesForce(driver);

	}

	// Click leads tab link from Home Page
	@Test(priority = 2)
	void step2() {

		WebElement leads = driver.findElement(By.xpath("//li[@id='Lead_Tab']//a"));

		clickElement(leads);

		String expectedTitle = "Leads: Home ~ Salesforce - Developer Edition";

		boolean flag = wait.until(ExpectedConditions.titleIs(expectedTitle));

		Assert.assertTrue(flag);

	}

	// Select 'Todays leads'
	// Select 'My unread leads' from the view drop down and logout from the
	// application
	// Todays leads' should be selected from the drop down and the salesforce login
	// page appears
	@Test(priority = 3)
	void step3() {

		WebElement leadsList = driver.findElement(By.id("fcf"));

		select(leadsList, "My Unread Leads");

		WebElement userMenuBtn = driver.findElement(By.id("userNavButton"));

		clickElement(userMenuBtn);

		WebElement logoutBtn = driver.findElement(By.xpath("//div[@id='userNav-menuItems']//a[@title='Logout']"));
		clickElement(logoutBtn);

		String expectedLoginPageTitle = "Login | Salesforce";

		boolean flag = wait.until(ExpectedConditions.titleIs(expectedLoginPageTitle));

		Assert.assertTrue(flag);

	}

	// Login to salesforce again
	@Test(priority = 4)
	void step4() {

		validLoginToSalesForce(driver);

		String expectedHomePageTitle = "Home Page ~ Salesforce - Developer Edition";

		boolean flag = wait.until(ExpectedConditions.titleIs(expectedHomePageTitle));

		Assert.assertTrue(flag);
	}

	// Click leads tab link from Home Page

	// Click leads tab link from Home Page
	@Test(priority = 5)
	void step5() {

		WebElement leads = driver.findElement(By.xpath("//li[@id='Lead_Tab']//a"));

		clickElement(leads);

		String expectedTitle = "Leads: Home ~ Salesforce - Developer Edition";

		boolean flag = wait.until(ExpectedConditions.titleIs(expectedTitle));

		Assert.assertTrue(flag);

	}

	// click Go button
	@Test(priority = 6)
	void step6() {

		WebElement goBtn = driver.findElement(By.xpath("//input[@value=' Go! ']"));

		clickElement(goBtn);

		WebElement title =wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//select[@class='title']"))));

		Select s = select(title);

		List<WebElement> selectedOpn = s.getAllSelectedOptions();

		String expectedSelectedOpn = "My Unread Leads";

		Assert.assertEquals(selectedOpn.get(0).getText(), expectedSelectedOpn);

	}

}
