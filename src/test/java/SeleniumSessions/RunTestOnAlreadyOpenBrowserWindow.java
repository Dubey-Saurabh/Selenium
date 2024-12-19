package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class RunTestOnAlreadyOpenBrowserWindow {

    public static void main(String[] args) {

      /*  Go to chrome.exe location and make a folder chrome data and run chrome.exe --remote-debugging-port=9222 --user-data.dir=C:\AppData\Code\chromedata command
        set the same port address in chrome option script*/

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "localhost:9222");
        WebDriver driver = new ChromeDriver(options);
//        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.cssSelector("input#email")).sendKeys("Saurabh");

    }
}
