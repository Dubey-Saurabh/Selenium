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

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.instagram.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement username = driver.findElement(By.cssSelector("input[name=username]"));
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));

        Actions action = new Actions(driver);
        action.keyDown(username, Keys.SHIFT).sendKeys(username, "saurabhdubey").build().perform(); //Sent text in Upper case
        action.moveToElement(password).sendKeys("saurabhdubey").keyDown(password,Keys.SHIFT).sendKeys("3").build().perform();



    }

}
