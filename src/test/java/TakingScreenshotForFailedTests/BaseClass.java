package TakingScreenshotForFailedTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class BaseClass {

    public static WebDriver driver;

    public static void initialization() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.instagram.com/");

    }

    public static void takeScreenshotForFailedTests(String testMethodName) throws IOException {

        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("C:\\SeleniumProject\\target\\" + testMethodName + ".png"));

    }

}
