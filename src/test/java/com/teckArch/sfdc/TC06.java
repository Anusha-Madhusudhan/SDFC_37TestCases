package com.teckArch.sfdc;
// Select "My Profile" option from user menu for <username> drop down

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC06 extends ReUsableClass{

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://login.salesforce.com");

		driver.manage().window().maximize();

		Thread.sleep(2000);

		validLoginToSalesForce2(driver);

		 WebElement userMenuBtn=driver.findElement(By.xpath("//div[@id='userNav']//child::div[substring-before(@class,'Button') and @id='userNavButton']"));
		 Thread.sleep(2000);
		 
		
		 
		 WebElement myProfile=driver.findElement(By.xpath("//div[@id='userNav']//child::div[substring-before(@class,'Button') and @id='userNavButton'] //following-sibling::div//child::div[@id='userNav-menuItems']//a[1]"));
         userMenuBtn.click();
		 
		 
		 myProfile.click();
		 
		 Thread.sleep(2000);
		 
		 //div[@class='editPen']//a[contains(@class,'contactIn')]
		 WebElement editContact=driver.findElement(By.xpath("//div[@class='editPen']//a[contains(@class,'contactIn')]"));
		 
		
		 
		
		 editContact.click();
		 
		 Thread.sleep(2000);
		 
		 
		 WebElement iFrame=driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']"));
		 
//		 driver.switchTo().frame(iFrame);
		 
		 driver.switchTo().frame("contactInfoContentId");
		 
		 
		 Thread.sleep(2000);
		 
		 driver.findElement(By.xpath("//li[@id='aboutTab']")).click();
		 
		 WebElement lastName= driver.findElement(By.cssSelector("#lastName"));
		 
		 lastName.clear();
		 lastName.sendKeys("AB");
		 
		 driver.findElement(By.xpath("//div[@class='net-buttons zen-mtl']//input[1]")).click();
		 
		 driver.switchTo().defaultContent();
		 
		 String actualLastName=driver.findElement(By.cssSelector("#tailBreadcrumbNode")).getAttribute("title");
		 
		 String[] s=actualLastName.split(" ");
		 
		 if(s[1].equals("AB")) {
			 System.out.println("Test Passed...!!! LAst NAme matches");
		 }else {
			 System.out.println("Test Failed...!!! LAst NAme not matches");
		 }
		 
		 
		 WebElement post=driver.findElement(By.cssSelector(".publisherattachtext "));
		 post.click();
		 
		 WebElement iFrame2=driver.findElement(By.cssSelector(".cke_wysiwyg_frame.cke_reset"));
		 
		 driver.switchTo().frame(iFrame2);
		 
		
		 
		 
		 Thread.sleep(2000);
		 WebElement text= driver.findElement(By.xpath("/html/body"));
		 text.click();
		 text.sendKeys("ABCDEFGH***");
		 driver.switchTo().defaultContent();
		 Thread.sleep(2000);
		 
		 driver.findElement(By.cssSelector("#publishersharebutton")).click();
		 
		
		 
		 String actualStr=driver.findElement(By.xpath("(//div[@class='cxfeeditemtextadditional']//span//p)[1]")).getText();
		 
		 if(actualStr.equals("ABCDEFGH***")) {
			 System.out.println("Tset passed....!!! Posted text available on the page");
		 }else {
			 System.out.println("Tset Failed....!!! Posted text not  available on the page");
		}
		 
		 
		 // UPLOAD file
		 
		 
		 Thread.sleep(2000);
		 
		 driver.findElement(By.xpath("//li[@class='publisherFeedItemTypeChoice']//a[@title='File']")).click();
		 
		 driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']")).click();
		 
		 
//		 driver.switchTo().frame("chatterFileForm");
		 Thread.sleep(2000);
		 String filePath="C:\\Users\\anush\\OneDrive\\Desktop\\TekArch\\Dummy files\\dummy.txt";
		 WebElement chooseFile=  driver.findElement(By.xpath("//input[@class='file']"));
		 
		 chooseFile.sendKeys(filePath);
		 
//		 JavascriptExecutor js=(JavascriptExecutor) driver;
		 
//		 js.executeScript("arguments[0].value='C:\\\\Users\\\\anush\\\\OneDrive\\\\Desktop\\\\TekArch\\\\Dummy files\\\\dummy.txt'", chooseFile);
		 
		 
		 
//		 Robot rb=new Robot();
//		 rb.delay(2000);
//		 
//		 StringSelection sSle=new StringSelection(filePath);
//		 
//		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sSle, null);
//		 
//		 
//		 rb.keyPress(KeyEvent.VK_CONTROL);
//		 rb.keyPress(KeyEvent.VK_V);
//		 
//		 rb.keyRelease(KeyEvent.VK_CONTROL);
//		 rb.keyRelease(KeyEvent.VK_V);
//		 
//		 
//		 rb.keyPress(KeyEvent.VK_ENTER);
//		 
//		 rb.keyRelease(KeyEvent.VK_ENTER);
		 
		 Thread.sleep(2000);
		 driver.findElement(By.cssSelector("#publishersharebutton")).click();
		 Thread.sleep(4000);
		 String fileName=driver.findElement(By.xpath("(//table[@class='contentdetails']//tbody//tr//td)[1]//div//a//span")).getAttribute("title");
		 
		 if(fileName.equals("dummy")) {
			 System.out.println("Test Passed...!!! file uploaded");
		 }else {
			 System.out.println("Test Failed...!!! file not uploaded");
		}
		 
		 
		 // ADD PHOTO
		 Thread.sleep(2000);
		 
		 
		WebElement addPhoto= driver.findElement(By.xpath("//div[@class='photoUploadSection']//a[@id='uploadLink']"));
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].click()", addPhoto);
		Thread.sleep(2000);
		 
		 driver.switchTo().frame("uploadPhotoContentId");
		 Thread.sleep(2000);
		 
		 WebElement choosePhotoFile=driver.findElement(By.xpath("//form[@id='j_id0:uploadFileForm']//input[@class='fileInput']"));
		 
		 choosePhotoFile.sendKeys("C:\\Users\\anush\\OneDrive\\Desktop\\th.jpg");
		 
//		 js.executeScript("arguments[0].value='C:\\\\Users\\\\anush\\\\OneDrive\\\\Desktop\\\\th.jpg'", choosePhotoFile);
		 
//		 Thread.sleep(2000);
//		 
//		 Robot rb2=new Robot();
//		 rb2.delay(2000);
//		 
//		 StringSelection sl=new StringSelection("C:\\Users\\anush\\OneDrive\\Desktop\\th.jpg");
//		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sl, null);
//		 
//		 rb.delay(2000);
//		 
//		 rb2.keyPress(KeyEvent.VK_CONTROL);
//		 rb2.keyPress(KeyEvent.VK_V);
//		 
//		 rb2.keyRelease(KeyEvent.VK_CONTROL);
//		 rb2.keyRelease(KeyEvent.VK_V);
//		 
//		 
//		 rb2.keyPress(KeyEvent.VK_ENTER);
//		 
//		 rb2.keyRelease(KeyEvent.VK_ENTER);
//		 Thread.sleep(2000);
		 
		WebElement saveBtn= driver.findElement(By.xpath("(//input[@id='j_id0:uploadFileForm:uploadBtn'])[1]"));
		
		saveBtn.click();
		
//		js.executeScript("arguments[0].click()", saveBtn);
		 
//		 Thread.sleep(2000);
		 
//		 driver.switchTo().defaultContent();
		 
//		 Thread.sleep(2000);
		 
//		 driver.switchTo().frame("uploadPhotoContentId");
		 
//		 Thread.sleep(2000);
		 
		 driver.findElement(By.xpath("//input[@id='j_id0:j_id7:save']")).click();
		 
		// driver.findElement(By.linkText("")).click();
		 
	}

	private static void validLoginToSalesForce2(WebDriver driver) {
		WebElement userName=driver.findElement(By.xpath("//div[@id='username_container']//div//following-sibling::input[@id='username']"));
		
		//form[@name='login']//div[2]//following-sibling::input[@type='password']
		
		
		WebElement passWord=driver.findElement(By.xpath("//div[@id='pwcaps']//preceding-sibling::input[@type='password']"));
		
		
		WebElement loginBtn=driver.findElement(By.xpath("//div[@id='pwcaps']//following-sibling::input[@id='Login']"));
		
		userName.clear();
		
		userName.sendKeys("anusha@tek.com");
		
		passWord.clear();
		
		passWord.sendKeys("Sumedh@03");
		
		loginBtn.click();
		
		
		String expected="Home Page ~ Salesforce - Developer Edition";
		
		if(driver.getPageSource().contains(expected)) {
			System.out.println("Login Passed with valid Username and Password...!!!  Test case PASSED");
		}else {
			System.out.println("Test case Failed");
		}
		
	}

}
