/**
 * 
 */
package com.teckArch.sfdc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 
 */
public class TC36_BlockingAnEventInTheCalender extends ReUsableClass {
	
	@Test
	void blockingAnEventInTheCalender() {
		
		validLoginToSalesForce(driver);
		
		WebElement homeTab=driver.findElement(By.linkText("Home"));
		clickElement(homeTab);
		
		String actualDate=driver.findElement(By.xpath("//span[@class='pageDescription']//a")).getText();
		
		// Thursday August 31, 2023
		
		String expecteddate=new SimpleDateFormat("EEEE MMMM dd, yyyy").format(new Date());
		
		System.out.println(expecteddate);
		
		Assert.assertEquals(actualDate, expecteddate);
		
		WebElement dateLink=driver.findElement(By.xpath("//span[@class='pageDescription']//a"));
		
		clickElement(dateLink);
		
		String actualDatePage=driver.findElement(By.cssSelector(".pageType")).getText();
		
		String userName="Anusha ABCD";
		
		if(actualDatePage.contains(userName)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
		
		driver.findElement(By.partialLinkText("8:00 PM")).click();
		
		String expectedCalenderEvenPageTitle="Calendar: New Event ~ Salesforce - Developer Edition";
		
		Assert.assertTrue(wait.until(ExpectedConditions.titleIs(expectedCalenderEvenPageTitle)));
		
		WebElement subjectCombo=driver.findElement(By.xpath("//a[@title='Combo (New Window)']"));
		
		clickElement(subjectCombo);
		
		Assert.assertTrue(wait.until(ExpectedConditions.numberOfWindowsToBe(2)));
		
		Set<String> windowHandles=driver.getWindowHandles();
		List<String> windowHandlesList=new ArrayList<>(windowHandles);
		
		driver.switchTo().window(windowHandlesList.get(1));
		
		WebElement other=driver.findElement(By.linkText("Other"));
		clickElement(other);
		
		Assert.assertTrue(wait.until(ExpectedConditions.numberOfWindowsToBe(1)));
		
		
		driver.switchTo().window(windowHandlesList.get(0));
		
		WebElement endTime=driver.findElement(By.id("EndDateTime_time"));
		
		clickElement(endTime);
		
		
//		driver.switchTo().frame("sessionserver");
		
        WebElement _9PM=driver.findElement(By.id("timePickerItem_42"));
		
		clickElement(_9PM);
        
       
		
//		driver.switchTo().parentFrame();
		
		Assert.assertEquals(endTime.getAttribute("value"), "9:00 PM");
		
		
		WebElement saveBtn=driver.findElement(By.xpath("//input[@value=' Save ']"));
		
		clickElement(saveBtn);
		
		
     String actualDatePage2=driver.findElement(By.cssSelector(".pageType")).getText();
		
//		String userName="Anusha ABCD";
		
		if(actualDatePage2.contains(userName)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
		
		WebElement eventDetails=driver.findElement(By.id("p:f:j_id25:j_id69:28:j_id71:0:j_id72:calendarEvent:j_id84"));
		
		Actions act=new Actions(driver);
		act.moveToElement(eventDetails).build().perform();
		
		WebElement eventDetailsTable=driver.findElement(By.xpath("//table[@class='detailList']//tbody"));
		
		List<WebElement> rows=eventDetailsTable.findElements(By.tagName("tr"));
		
		boolean flag1=false;
		boolean flag2=false;
		boolean flag3=false;
		for(WebElement row:rows) {
			
			List<WebElement> coloumns=row.findElements(By.tagName("td"));
			
			for(WebElement col:coloumns) {
				System.out.print(col.getText()+"       ");
				
				if(col.getText().equals("Other")) {
					flag1=true;
				}
				if(col.getText().contains("8:00 PM")) {
					flag2=true;
				}
				
				if(col.getText().contains("9:00 PM")) {
					flag3=true;
				}
				
			}
			System.out.println();
		}
	Assert.assertTrue(flag1&&flag2&&flag3);
	
	WebElement deleteEvent=driver.findElement(By.xpath("//input[@value='Delete']"));
	clickElement(deleteEvent);
	
	driver.switchTo().alert().accept();
	
	
	
	
	}

}
