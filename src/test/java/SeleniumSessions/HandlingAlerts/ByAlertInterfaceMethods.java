package SeleniumSessions.HandlingAlerts;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ByAlertInterfaceMethods {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(); // launch firefox

        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String ele = driver.findElement(By.name("proceed")).getAttribute("class");
        System.out.println(ele);

        Alert alert = driver.switchTo().alert(); // To switch to alert or pop up window
        System.out.println(alert.getText()); // To get text from alert or pop up.

        Thread.sleep(5000); // to pause the script for 5 seconds.
        alert.accept(); // to accept alerts
//        alert.dismiss(); // To close popup
//        alert.sendKeys();
        driver.quit();

    }

}
