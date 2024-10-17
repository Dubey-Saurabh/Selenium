import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BrokenLinks {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();

        List<WebElement> links = driver.findElements(By.tagName("a"));  // Collect links with an anchor tag
        System.out.println("No of links would be: " + links.size());

        List<String> urlList = new ArrayList<>();  // Will store all link urls in the list

        for (WebElement e : links) {

            String url = e.getAttribute("href");  //get all Urls from links
            urlList.add(url); // added them in the list

        }
        long startTime = System.currentTimeMillis();
        urlList.parallelStream().forEach(x -> checkBrokenLink(x));  // Used parallel stream to execute code faster than usual stream
        long endTime = System.currentTimeMillis();

        System.out.println("Total time taken: " + (endTime - startTime));
        driver.quit();
    }

    public static void checkBrokenLink(String linkUrl) {

        try {

            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(); // hit the request to check broken links by open connection method
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.connect();

            if (httpURLConnection.getResponseCode() >= 400) {
                System.out.println(linkUrl + "-->" + httpURLConnection.getResponseMessage() + " is a broken link");
            } else {
                System.out.println(linkUrl + "-->" + httpURLConnection.getResponseMessage());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
