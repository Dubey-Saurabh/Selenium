package SeleniumSessions.DynamicTableHandling;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FindValueInFrequentDynamicTable {

    public static WebDriver driver;

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://practice.expandtesting.com/dynamic-table");

        valueFound("Chrome");
        driver.quit();


    }

    public static void valueFound(String name) {

        int rowCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();

        for (int i = 1; i <= rowCount; i++) {
            String searchElement = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[1]")).getText();
            if (searchElement.equals(name)) {
                String cpuLoad = driver.findElement(By.xpath("//td[normalize-space()='Chrome']/following-sibling::*[contains(text(),'%')]")).getText();
                String cpuLoadValue = driver.findElement(By.xpath("//p[@id='chrome-cpu']")).getText();

                if (cpuLoadValue.contains(cpuLoad)) {
                    System.out.println("Both value matched");
                } else {
                    System.out.println("Unmatched");
                }
                break;

            }
        }

    }
}
