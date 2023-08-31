package com.teckArch.sfdc;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07 extends ReUsableClass {

	// Login to the Application
	@Test(priority = 1)
	void login() {

		validLoginToSalesForce(driver);

	}

	// Select user menu for <username> drop down

//	@Test(priority = 2)
	void step1() throws InterruptedException {

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

	// Click "My Settings" option from user menu
	@Test(priority = 3)
	void step2() {

		WebElement userMenuBtn = driver.findElement(By.xpath("//div[@id='userNavButton']"));
		userMenuBtn.click();
		WebElement mySetting = driver.findElement(By.xpath("//div[@id='userNav-menuItems']//a[text()='My Settings']"));
		mySetting.click();

		String actualRes = driver.findElement(By.xpath("//a[@class='setupSection']//span[2]")).getText();

		String expectedRes = "My Settings";

		Assert.assertEquals(actualRes, expectedRes);

	}

	// Click on Display & Layout link
//	@Test(dependsOnMethods ={"step2"} )
	void step3() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement disLay = driver
				.findElement(By.xpath("//div[@id='DisplayAndLayout']//a//span[@class='accordionIcon expand_icon']"));
//		disLay.click();

		js.executeScript("arguments[0].click()", disLay);

		WebElement customTab = driver
				.findElement(By.xpath("//div[@id='DisplayAndLayout']//child::div//a[@id='CustomizeTabs_font']"));
		customTab.click();

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		WebElement customApp=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//select[@id='p4']"))));
		WebElement customApp = driver.findElement(By.xpath("//select[@id='p4']"));
		Select s = new Select(customApp);

		s.selectByVisibleText("Salesforce Chatter");

		// #duel_select_0

//		WebElement availTabs=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//select[@id='duel_select_0']"))));

		WebElement availTabs = driver.findElement(By.xpath("//select[@id='duel_select_0']"));

		Select s2 = new Select(availTabs);

		s2.selectByValue("report");

		WebElement add = driver.findElement(By.xpath("//div[@class='zen-mbs text']//a[@id='duel_select_0_right']"));

		add.click();

		WebElement save = driver.findElement(By.xpath("//input[@name='save']"));
		save.click();

		String expectedRes = "Reports";

		Assert.assertTrue(driver.getPageSource().contains(expectedRes));

	}

	// Click on Email link and click on my email settings link under that
//	@Test(dependsOnMethods = { "step2" })
	void step4() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement email = driver
				.findElement(By.xpath("//div[@id='EmailSetup']//a//span[@class='accordionIcon expand_icon']"));

		js.executeScript("arguments[0].click()", email);

		WebElement emailSettings = driver
				.findElement(By.xpath("//div[@id='EmailSetup']//child::div//a[@id='EmailSettings_font']"));

		emailSettings.click();

		WebElement emailName = driver.findElement(By.cssSelector("#sender_name"));

		emailName.clear();
		emailName.sendKeys("XYZ ABC");

		WebElement emailAddress = driver.findElement(By.cssSelector("#sender_email"));

		emailAddress.clear();
		emailAddress.sendKeys("xyz.abc@gamil.com");

		WebElement autoBcc = driver.findElement(By.cssSelector("#auto_bcc1"));

		if (autoBcc.isSelected()) {
			System.out.println("Auto Bcc is checked allready");
		} else {
			autoBcc.click();
		}

		WebElement save = driver.findElement(By.xpath("//input[@value=' Save ']"));

		save.click();

		Alert alert = driver.switchTo().alert();

		System.out.println(alert.getText());

		Thread.sleep(3000);

		alert.accept();

		String expectedRes = "Your settings have been successfully saved.";

		Assert.assertTrue(driver.getPageSource().contains(expectedRes));

	}

	// Click on Calendar & Remainders
	@Test(dependsOnMethods = { "step2" })
	void step5() throws InterruptedException {
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement calAndRem=driver.findElement(By.xpath("//div[@id='CalendarAndReminders']//a//span[@class='accordionIcon expand_icon']"));
		
//		calAndRem.click();
		js.executeScript("arguments[0].click()", calAndRem);
		
		WebElement actRem=driver.findElement(By.xpath("//div[@id='CalendarAndReminders_child']//child::a[@id='Reminders_font']"));
		actRem.click();
		
		WebElement opnTest=driver.findElement(By.cssSelector("#testbtn"));
		
		opnTest.click();
		
		Thread.sleep(2000);
		
		Set<String> windowsHandles=driver.getWindowHandles();
		
		System.out.println("********************"+windowsHandles.size());
		
		List<String> windowsHandlesList=new ArrayList<String>(windowsHandles);
		
		
		String parentWindowHandle=windowsHandlesList.get(0);
		
		String childWindowHandle=windowsHandlesList.get(1);
		
		
		driver.switchTo().window(childWindowHandle);
		
		String expectedRes="  Sample Event.";
		
		String actualRes=driver.findElement(By.xpath("(//div[@class='subject'])[1]")).getText();

		Assert.assertTrue(actualRes.equals(expectedRes));
		
		driver.close();
		
		driver.switchTo().window(parentWindowHandle);
	}

}
