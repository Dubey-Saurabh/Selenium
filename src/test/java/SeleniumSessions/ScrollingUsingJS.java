package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ScrollingUsingJS {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        //Scroll by Pixel
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1600);");  // to scroll vertically down
        js.executeScript("window.scrollBy(0,-400);"); // to scroll vertically up

        //Scroll till element is find and click on that

        WebElement element = driver.findElement(By.xpath("//a[text()='Amazon Science']"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        element.click();

        // Scroll till bottom of the page

        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");




    }
}
