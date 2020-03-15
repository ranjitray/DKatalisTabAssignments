package com.qa.Utils;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.qa.Constant.Constants;

public class Utils {
	
		static DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy/MM/dd hh.mm.ss");
		static LocalDateTime currenttime = LocalDateTime.now();
		static String time =dateformat.format(currenttime);
		
		// Explicit timeout function for web element - Click Event
		public static void clicksWithExPlicitTimeOut(WebDriver driver,int timeout, WebElement element) 
		{

			 new WebDriverWait(driver, timeout)
			.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		}
		
		
		// Capturing Screenshot with specified name 
		
		public static String captureScreenshot(WebDriver driver, String screenShotName )
		{

			try {
				// Convert Webdriver Object to Screenshot
				TakesScreenshot ts = (TakesScreenshot)driver;
				
				// Calling getScreenshotAs method to create Image file
				File srcFile = ts.getScreenshotAs(OutputType.FILE);
				
				// Move Image file to New Destination path
				File DestFile = new File("./Screenshots/"+time+""+screenShotName+".png");
				
				// Copy the file at destination
				FileUtils.copyFile(srcFile, DestFile);
				
				Reporter.log("*******Screenshot captured for "+screenShotName+"*********", true);
			} catch (Exception e) {
				Reporter.log("Exeception while taking the Screenshot"+e.getMessage());
				e.printStackTrace();

			} 
			
			return screenShotName;

		}
		
		public static void explicitlyWait(WebDriver driver,WebElement element) {
			WebDriverWait wait=new WebDriverWait(driver,Constants.EXPLICIT_WAIT);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
}
