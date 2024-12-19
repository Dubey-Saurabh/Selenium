package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class DesiredCapabilityConcept {

    public static void main(String[] args) {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName","chrome");
        capabilities.setCapability("browserVersion", "129.0");
        capabilities.setCapability("platformName", "Windows 10");
        capabilities.setCapability("acceptInsecureCerts",true);
        capabilities.setCapability("javascriptEnabled",true);
        capabilities.setCapability("maxInstances",5); //Sets the maximum number of browser instances to be run concurrently.
//        capabilities.setCapability("browserName","firefox");
//        capabilities.setCapability("enableVideo",true); // record video of the test session


        WebDriver driver = new ChromeDriver();
        driver.get("https://www.instagram.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        driver.quit();

    }
}
