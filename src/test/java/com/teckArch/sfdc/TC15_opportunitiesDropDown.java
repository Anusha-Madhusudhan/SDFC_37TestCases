package com.teckArch.sfdc;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC15_opportunitiesDropDown extends ReUsableClass {

	// Login
	@Test(priority = 1)
	void step1() {

		validLoginToSalesForce(driver);

	}

	//
	// Click on opportunities link
	@Test(priority = 2)
	void step2() {

		WebElement opportunities = driver.findElement(By.id("Opportunity_Tab"));

		clickElement(opportunities);

		String expectedTitle = "Opportunities: Home ~ Salesforce - Developer Edition";

		boolean flag = wait.until(ExpectedConditions.titleIs(expectedTitle));

		Assert.assertTrue(flag);

	}

	// Verify opportunities drop down is present
	@Test(priority = 3)
	void step3() {
		List<String> expectedOptions = new ArrayList<String>();
		expectedOptions.add("All Opportunities");
		expectedOptions.add("Closing Next Month");
		expectedOptions.add("Closing This Month");
		
		expectedOptions.add("My Opportunities");
		expectedOptions.add("New Last Week");
		expectedOptions.add("New This Week");
		expectedOptions.add("Opportunity Pipeline");
		expectedOptions.add("Private");
		expectedOptions.add("Recently Viewed Opportunities");
		expectedOptions.add("Won");

		WebElement selectOppDropDown = driver.findElement(By.id("fcf"));

		Select s = select(selectOppDropDown);

		boolean flag = false;
		int i = 0;

		List<WebElement> actualOptions = s.getOptions();

		for (WebElement ele : actualOptions) {
			
			System.out.println(ele.getText());
			

			if (expectedOptions.get(i).equals(ele.getText())) {

				flag = true;
				i++;
				continue;
			} else {
				flag = false;
				break;
			}

		}

		Assert.assertTrue(flag);

	}

}
