package ScreenshotPackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class UtilClass {

/*	File source = ((Takescreenshot)driver.getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(source, new File(Path where we want to save the screenshot))*/

	public static void captureScreenshot(WebDriver driver, String screenshotname) {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;

			File source = ts.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(source, new File("./Screenshots/" + screenshotname + ".png"));
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
