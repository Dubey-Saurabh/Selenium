package SeleniumSessions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksConcept {

    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.browserstack.com/guide/how-to-find-broken-links-in-selenium");
        List<WebElement> list = driver.findElements(By.tagName("a"));
        System.out.println("Total links :" + list.size());

        for (int i = 0; i <= list.size(); i++) {
            WebElement element = list.get(i);

            String url = element.getAttribute("href"); // Will give url

            URL link = new URL(url); // Create an object of URL class object and pass above url value

            HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();  // Create HttpURLConnection class object and apply open connection method.

            Thread.sleep(3000);

            httpConn.connect();  // Connect the connection

            int resCode = httpConn.getResponseCode(); // get response code

            if (resCode >= 400) {
                System.out.println(url + " -" + " is broken link");
            }
        }

        driver.quit();

    }

}
