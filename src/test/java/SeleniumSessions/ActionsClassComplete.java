package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsClassComplete {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserName", "chrome");
        options.setCapability("browserVersion", "latest");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.instagram.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement artBtn = driver.findElement(By.xpath("//a[text()='Art']"));
        WebElement continueWithAmazon = driver.findElement(By.xpath("//div[text()='Continue with Amazon']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(artBtn).click().build().perform();
        actions.moveToElement(continueWithAmazon).build().perform();


    }


}
