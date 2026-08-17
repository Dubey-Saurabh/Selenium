package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CalendarHandlingViaJS {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        WebElement date = driver.findElement(By.xpath("//div[text()='Departure Date']/following-sibling::div/div[1]"));
        String dateValue = "Thu, 12 Dec 2024";
        selectDate(driver, date, dateValue);
        Thread.sleep(5000);
        driver.quit();

    }

    public static void selectDate(WebDriver driver, WebElement element, String dateValue) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','" + dateValue + "');", element);

    }

}
