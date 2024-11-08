package ScreenshotPackage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import TakingScreenshotForFailedTests.BaseClass;
import org.apache.commons.io.FileUtils;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotCOncept {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Saurabh_Dubey\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		driver.get("https://en-gb.facebook.com/");
		
		UtilClass.captureScreenshot(driver, "Before entering any username");

		driver.findElement(By.id("email")).sendKeys("abc");

		UtilClass.captureScreenshot(driver, "After entering any username");

		driver.quit();
	}

}
