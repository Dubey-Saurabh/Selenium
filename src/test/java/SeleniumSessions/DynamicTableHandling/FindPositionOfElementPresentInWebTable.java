package SeleniumSessions.DynamicTableHandling;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FindPositionOfElementPresentInWebTable {

    public static WebDriver driver;

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.w3schools.com/html/html_tables.asp");

        System.out.println(getRowColumnPosition("Germany"));

    }

    public static boolean getRowColumnPosition(String name) {
        int rowCount = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
        int columnCount = driver.findElements(By.xpath("//table[@id='customers']//th")).size();
        boolean flag = false;
        for (int i = 1; i < rowCount; i++) {
            for (int j = 1; j <= columnCount; j++) {
                String elementValue = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" +(i + 1)+ "]/td[" + j + "]")).getText();
                if (elementValue.equals(name)) {
                    flag = true;
                    System.out.println(i + " : " + j);
                    break;
                }
            }
        }
        if (flag) {
            return true;
        }
        return flag;
    }


}
