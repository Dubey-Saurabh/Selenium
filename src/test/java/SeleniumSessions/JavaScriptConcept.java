package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JavaScriptConcept {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
//        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20)); Configures maximum time for script execution.

        driver.get("https://www.amazon.in/");
        WebElement mxPlayer = driver.findElement(By.xpath("//a[text()='MX Player']"));
//        System.out.println(driver.getPageSource());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println(js.executeScript("return document.title")); // current webpage title
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); //Scrolls to the bottom of the page.
        js.executeScript("window.scrollTo(0,0)"); ////Scrolls to the extreme top of the page.
        WebElement langBtn = driver.findElement(By.xpath("//div[@class='layoutToolbarPadding']/a[@id='icp-nav-flyout']"));
        js.executeScript("arguments[0].style.backgroundColor = 'yellow';", langBtn);
        Thread.sleep(3000);
        js.executeScript("arguments[0].click();", mxPlayer); // Click on any element
        Thread.sleep(2000);
//        System.out.println(js.executeScript("return arguments[0].innerHTML",mxPlayer));; // Returns the inner HTML of the specified element.
//        System.out.println( js.executeScript("return arguments[0].value;",mxPlayer));
        js.executeScript("window.location.href='https://www.amazon.in/';"); //Navigates to the specified URL.
        System.out.println(js.executeScript("return document.readyState")); //Returns the current state of the document
        System.out.println(js.executeScript("return window.performance.timing")); //Returns performance timing information of the current page

        driver.quit();
    }
}
