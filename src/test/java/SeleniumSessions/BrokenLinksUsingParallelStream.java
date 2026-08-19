package SeleniumSessions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksUsingParallelStream {

    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.instagram.com");
        List<WebElement> list = driver.findElements(By.tagName("a"));

        List<String> urlList = new ArrayList<>();
        for (WebElement element : list) {
            urlList.add(element.getAttribute("href"));
        }

        urlList.parallelStream().forEach(e -> checkBrokenLinks(e));
        driver.quit();

    }

    public static void checkBrokenLinks(String Link) {
        try {
            URL url = new URL(Link);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(20000);
            httpURLConnection.connect();

            if (httpURLConnection.getResponseCode() > 400) {
                System.out.println(Link + "->" + httpURLConnection.getResponseMessage() + "is a broken link");
            } else
                System.out.println(Link + "->" + httpURLConnection.getResponseMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
