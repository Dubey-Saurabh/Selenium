package SeleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomInZoomOutViaJavaScriptExecutor {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.instagram.com/");

        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String zoomOut = "document.body.style.zoom='50%';";
        js.executeScript(zoomOut);

        String zoomIn = "document.body.style.zoom='400%';";
        js.executeScript(zoomIn);

        Thread.sleep(4000);
        driver.quit();
    }
}
