package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;
import java.time.Duration;

public class CopyPasteByActionsClass {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String name = "Saurabh";

        Actions action = new Actions(driver);
        WebElement username = driver.findElement(By.cssSelector("input#email"));
        username.sendKeys(name);
        username.click();

        /*select all and copy*/
        action.keyDown(Keys.CONTROL).sendKeys("a", "c");

        WebElement password = driver.findElement(By.cssSelector("input#pass"));
        password.click();

        /*paste*/
        action.keyDown(Keys.CONTROL).sendKeys("v");

        /*release control key and build and perform*/
        action.keyUp(Keys.CONTROL).build().perform();


    }

}
