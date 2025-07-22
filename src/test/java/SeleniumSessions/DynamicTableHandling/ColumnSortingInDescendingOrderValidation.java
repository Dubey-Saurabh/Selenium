package SeleniumSessions.DynamicTableHandling;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.SocketHandler;

public class ColumnSortingInDescendingOrderValidation {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.w3.org/WAI/ARIA/apg/patterns/table/examples/sortable-table/");

        List<WebElement> columnName = driver.findElements(By.xpath("//table[@class='sortable']/tbody/tr/td[1]"));
        String beforeSort[] = new String[columnName.size()];

        for (int i = 0; i < columnName.size(); i++) {
            beforeSort[i] = columnName.get(i).getText().trim();
            System.out.print(beforeSort[i]+ " ");   
        }
        System.out.println("\n Sorted in descending order ___");
        for (int i = 0; i < columnName.size(); i++) {
            Arrays.sort(beforeSort, Collections.reverseOrder());
            System.out.print(beforeSort[i]+ " ");
        }

        driver.findElement(By.xpath("//table[@class='sortable']//button[1]")).click();
        columnName = driver.findElements(By.xpath("//table[@class='sortable']/tbody/tr/td[1]"));

        System.out.println("\n After clicking on sorting button ____");
        String afterSort[] = new String[columnName.size()];
        for (int i = 0; i < columnName.size(); i++) {
            afterSort[i] = columnName.get(i).getText().trim();
            System.out.print(afterSort[i] + " ");
        }

        Assert.assertEquals(beforeSort, afterSort, "Not Sorted");


    }
}
