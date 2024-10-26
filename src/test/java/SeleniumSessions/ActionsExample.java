package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsExample {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

//        WebDriver driver = new ChromeDriver();
        WebDriver driver = new HtmlUnitDriver();
        driver.get("https://www.instagram.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//        WebElement username = driver.findElement(By.cssSelector("input[name=username]"));

//        Actions action = new Actions(driver);
//        action.keyDown(username, Keys.SHIFT).keyUp(username, Keys.SHIFT).sendKeys(username, "saurabhdubey").build().perform();


    }

}
