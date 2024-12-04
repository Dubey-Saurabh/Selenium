package SeleniumSessions.DynamicTableHandling;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ColumnSortingValidationByStreams {

    public static void main(String[] args) throws IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.w3.org/WAI/ARIA/apg/patterns/table/examples/sortable-table/");

        driver.findElement(By.xpath("//table[@class='sortable']//button[1]")).click();

        //Capture all column elements
        List<WebElement> nameList = driver.findElements(By.xpath("//table[@class='sortable']/tbody/tr/td[1]"));

        //Capture text of all of them and store in original list
        List<String> originalList = nameList.stream().map(s -> s.getText()).collect(Collectors.toList());
        System.out.println(originalList);

        //Sorted in reverse or desc order
        List<String> sortedList = originalList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        //comparison
        Assert.assertTrue(originalList.equals(sortedList));

        //---------------------------------------

        //Find value of any row element from any specific column

        List<String> address = nameList.stream().filter(e -> e.getText().contains("Fred")).map(e -> getAddress(e)).collect(Collectors.toList());

        address.forEach(e -> System.out.println(e));


    }

    private static String getAddress(WebElement driver) {

        return driver.findElement(By.xpath("//table[@class='sortable']/tbody/tr[4]/td[4]")).getText();

    }

}
