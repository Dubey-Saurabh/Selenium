package SeleniumSessions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingAlertsOrPopupConcept {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(); // launch firefox

        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.name("proceed")).getAttribute("class");


        Alert alert = driver.switchTo().alert(); // To switch to alert or pop up window
        System.out.println(alert.getText()); // To get text from alert or pop up.

        Thread.sleep(5000); // to pause the script for 5 seconds.
        alert.accept(); // to accept alerts
//        alert.dismiss(); // To close popup

        driver.quit();

    }

}
