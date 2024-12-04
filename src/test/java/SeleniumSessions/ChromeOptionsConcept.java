package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.time.Duration;

public class ChromeOptionsConcept {

    public static void main(String[] args) {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // maximize window
        options.addArguments("disable-popup-blocking"); //Disables popup blocking
        options.addArguments("incognito"); //incognito mode
        options.addArguments("headless"); // headless run
        options.addArguments("disable-extensions"); // Disables all extensions in the Chrome browser.
        options.addArguments("no-sandbox"); // No sandbox for testing use
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true); //Accepts SSL certificates in browser options.
//        options.setCapability("browserName","firefox");
        options.setCapability("browserVersion","latest"); // latest browser version



        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.instagram.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().logs().get("browser");

        driver.quit();




    }
}
