package com.test.azure;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class FreshWorksTest {
	WebDriver driver;

	@BeforeMethod
	
	public void setup() throws Exception {
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", System.getProperty("user.dir")+"\\Downloads");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		System.setProperty(
	            "webdriver.chrome.driver",
	            "Drivers\\chromedriver.exe");
		driver = new ChromeDriver(options);
		
	      
	        driver.manage().window().maximize();
			
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://sample-videos.com/download-sample-csv.php");
		

	}

	@Test(priority = 1)
	public void freshWorkslogoTest() throws InterruptedException {
		boolean flag = false;
//			flag = driver.findElement(By.xpath("//a[@download='SampleCSVFile_2kb.csv']")).isDisplayed();
		Thread.sleep(10000);
		File folder = new File(System.getProperty("user.dir")+"\\Downloads");
		File[] listOfFiles = folder.listFiles();
		driver.get("https://sample-videos.com/csv/Sample-Spreadsheet-10-rows.csv");
			//Assert.assertTrue(flag);
			Thread.sleep(3000);
			//File folder = new File(System.getProperty("user.dir")+"\\Downloads");
			File[] listOfFilesupdated = folder.listFiles();

//			for (int i = 0; i < listOfFiles.length; i++) {
//			  if (listOfFiles[i].isFile()) {
//			    System.out.println("File " + listOfFiles[i].getName());
//			  } else if (listOfFiles[i].isDirectory()) {
//			    System.out.println("Directory " + listOfFiles[i].getName());
//			  }
//			}
			if(listOfFiles.length+1==listOfFilesupdated.length)
				flag=true;
			Assert.assertTrue(flag);
	}

	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}

}
