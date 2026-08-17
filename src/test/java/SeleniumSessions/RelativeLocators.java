package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class RelativeLocators {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//        driver.get("https://demoqa.com/browser-windows");
//        driver.findElement(By.xpath("//span[text()='Alerts']")).click();
//        driver.switchTo().alert().accept();
//
//        WebElement alertButton= driver.findElement(By.cssSelector("#alertButton"));
//        WebElement relativeAlertButton = driver.findElement(RelativeLocator.with(By.cssSelector("#alertButton")).above(By.cssSelector("#timerAlertButton")));
//        relativeAlertButton.click();
//
//        driver.get("https://www.browserstack.com/");
//
//        WebElement appLive = driver.findElement(By.xpath("//h4[text()='App Live ']"));
//
//        WebElement getADemo = driver.findElement(RelativeLocator.with(By.xpath("//h4[text()='App Automate  ']"))
//                              .toRightOf(appLive));
//
//        getADemo.click();

        driver.get("https://www.epam.com/");

        Actions action = new Actions(driver);
//        action.moveToElement()

    }
}
