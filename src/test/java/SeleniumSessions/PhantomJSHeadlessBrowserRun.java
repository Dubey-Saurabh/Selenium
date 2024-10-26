package SeleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class PhantomJSHeadlessBrowserRun {

    public static void main(String[] args) {

//        System.setProperty("phantomjs.binary.path", "C:/Users/Saurabh_Dubey/Downloads" +
//                "/phantomjs-2.1.1-windows/phantomjs-2.1.1-windows/bin/phantomjs.exe");

        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setJavascriptEnabled(true);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:/Users/Saurabh_Dubey/Downloads" +
                "/phantomjs-2.1.1-windows/phantomjs-2.1.1-windows/bin/phantomjs.exe");

//        WebDriver driver = new ChromeDriver();
        PhantomJSDriver driver = new PhantomJSDriver(caps);
        driver.get("https://www.instagram.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        System.out.println(driver.getTitle());


    }
}
