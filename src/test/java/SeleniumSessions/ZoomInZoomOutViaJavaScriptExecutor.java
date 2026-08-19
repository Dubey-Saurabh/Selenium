package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomInZoomOutViaJavaScriptExecutor {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.instagram.com/");

        driver.manage().window().maximize();

        String zoomOut = "document.body.style.zoom='50%';";
        ((JavascriptExecutor) driver).executeScript(zoomOut);

        Thread.sleep(4000);

        String zoomIn = "document.body.style.zoom='400%';";
        ((JavascriptExecutor) driver).executeScript(zoomIn);

        Thread.sleep(4000);
        driver.quit();
    }
}
