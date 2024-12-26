package SeleniumSessions.WindowTabFrameHandles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MainClass {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get("https://www.dezlearn.com/nested-iframes-example/");

        driver.switchTo().frame(driver.findElement(By.id("parent_iframe")).findElement(By.id("iframe1")));
        driver.findElement(By.xpath("//button[@id='u_5_6']")).click();


//        driver.get("https://docs.oracle.com/javase/8/docs/api/index.html");
//
//        By javAppletButton =By.xpath("//td[@class='colFirst']//a[text()='java.applet']");
//
//        WebDriver parentFrame = driver.switchTo().frame("classFrame");
//
//        WebElement element = driver.findElement(javAppletButton);
//        element.click();
//
//        driver.switchTo().defaultContent();
//
//        driver.switchTo().frame("packageFrame");
//        driver.findElement(By.xpath("//a[text()='AbstractAction']")).click();
//
//        driver.switchTo().defaultContent();
//
//        driver.switchTo().frame("classFrame");
//        driver.findElement(By.xpath("//li[@class='blockList']/dl/dd/a[text()='ActionListener']")).click();
//
//        driver.switchTo().defaultContent();
//
//        driver.switchTo().frame(driver.findElement(By.xpath("//frame[position()=1]")));
//        driver.findElement(By.linkText("java.awt.color")).click();


    }

}
