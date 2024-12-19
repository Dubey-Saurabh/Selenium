package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class GoogleSearchConcept {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.google.com");

        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("testing");

        Thread.sleep(4000);
        List<WebElement> list = driver.findElements(By.xpath("//ul[@role= 'listbox']"));
        int size = list.size();

        for (int i = 1; i <= size; i++) {

            WebElement element = driver.findElement(By.xpath("//ul[@role='listbox']/li[" + i + "]//span"));
            String string = element.getText();
            if (string.equalsIgnoreCase("Testing")) {
                element.click();
                break;
            }

        }

    }

}
