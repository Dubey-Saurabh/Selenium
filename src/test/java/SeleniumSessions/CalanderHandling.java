package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalanderHandling {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.airbnb.com");
        driver.findElement(By.xpath("//div[contains(text(),'Add dates')]")).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#tabs")));
        String firstMonthInCalander = driver.findElement(By.xpath("//div[@aria-label='Calendar']/div[1]//h2[1]")).getText();
        String month = firstMonthInCalander.split(" ")[0].trim();
        String year = firstMonthInCalander.split(" ")[1].trim();

        while (!(month.equals("October") && year.equals("2026"))) {
            driver.findElement(By.xpath("//button[@aria-label='Move forward to change to the next month.']")).click();
             firstMonthInCalander = driver.findElement(By.xpath("//div[@aria-label='Calendar']/div[1]//h2[2]")).getText();
             month = firstMonthInCalander.split(" ")[0].trim();
             year = firstMonthInCalander.split(" ")[1].trim();
        }

        driver.findElement(By.xpath("//button[contains(@aria-label,'14, Wednesday, October 2026')]")).click();

        Thread.sleep(10000);


    }
}
