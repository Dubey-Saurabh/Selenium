package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CalanderHandlingViaJS {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        WebElement date = driver.findElement(By.xpath("//div[@data-testid='departure-date-dropdown-label-test-id']/div/div[@class='css-76zvg2 css-bfa6kz r-homxoj r-ubezar']"));
        String dateValue = "Thu, 12 Dec 2024";
        selectDate(driver, date, dateValue);

        driver.quit();


    }

    public static void selectDate(WebDriver driver, WebElement element, String dateValue) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','" + dateValue + "');", element);
    }

}
