package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleMoreConcept {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.instagram.com/"); // Parent Window
        String parentWindowId = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[@href='https://about.meta.com/']")).click();
        driver.findElement(By.xpath("//a[@href='https://about.instagram.com/']")).click();
        driver.findElement(By.xpath("//a[@href='https://about.instagram.com/blog/']")).click();
        driver.findElement(By.xpath("//a[@href='https://about.instagram.com/about-us/careers']")).click();

        //switch to first or parent window
        driver.switchTo().window(driver.getWindowHandles().iterator().next());

        //Switch to 3rd window Or can switch to any window using index
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[3]);

        //Switches to the last opened window handle.
        driver.switchTo().window(driver.getWindowHandles().stream().reduce((first, second) -> second).orElse(null));

        //Switches to the first opened window handle
        driver.switchTo().window(driver.getWindowHandles().stream().findFirst().orElse(null));

        Thread.sleep(5000);


        driver.quit();


    }
}
