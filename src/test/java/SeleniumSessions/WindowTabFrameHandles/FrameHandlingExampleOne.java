package SeleniumSessions.WindowTabFrameHandles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FrameHandlingExampleOne {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get("https://docs.oracle.com/javase/8/docs/api/index.html");

        driver.switchTo().frame("packageFrame").findElement(By.xpath("//a[text()='AbstractAction']")).click();

        driver.switchTo().defaultContent();

        driver.switchTo().frame("classFrame").findElement(By.xpath("//li[@class='blockList']/dl/dd/a[text()='ActionListener']")).click();

        driver.switchTo().defaultContent();

        driver.switchTo().frame(driver.findElement(By.xpath("//frame[position()=1]"))).findElement(By.linkText("java.awt.color")).click();


    }

}
