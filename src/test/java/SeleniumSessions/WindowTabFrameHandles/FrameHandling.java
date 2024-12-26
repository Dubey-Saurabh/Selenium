package SeleniumSessions.WindowTabFrameHandles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FrameHandling {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://ui.vision/demo/webtest/frames/");

        driver.switchTo().frame(driver.findElement(By.xpath("//*[contains(@src,'frame_2.html')]")));
        driver.findElement(By.name("mytext2")).sendKeys("Saurabh");

        driver.switchTo().defaultContent();
//        driver.switchTo().parentFrame();

        //nested frames
        driver.switchTo().frame(driver.findElement(By.xpath("//*[contains(@src,'frame_3.html')]")).findElement(By.xpath("//p[contains(text(),'iframe inside frame:')]/following-sibling::iframe")));
        driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();

        //last iframe
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[last()]")));

        //Second iframe
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[position()=2]")));

        //Check no of frames
        List<WebElement> iframeCount = driver.findElements(By.tagName("iframe"));
        System.out.println(iframeCount.size());


    }

}
