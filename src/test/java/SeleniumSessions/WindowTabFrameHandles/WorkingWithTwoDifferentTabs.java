package SeleniumSessions.WindowTabFrameHandles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WorkingWithTwoDifferentTabs {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        String parentTabId = driver.getWindowHandle();
        System.out.println(parentTabId);

        WebDriver newTab1 = driver.switchTo().newWindow(WindowType.TAB);
        String newTabId = driver.getWindowHandle();
        System.out.println(newTabId);
        newTab1.get("https://www.google.com");
        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("BNP Paribas");
        Thread.sleep(2000);

        driver.close();
        driver.switchTo().window(parentTabId);
        driver.findElement(By.xpath("//*[@name='username']")).sendKeys("user");
        Thread.sleep(2000);

        driver.quit();


    }

}
