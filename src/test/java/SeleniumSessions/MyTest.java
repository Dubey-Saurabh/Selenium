package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class MyTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();

        List<WebElement> linksList = driver.findElements(By.tagName("a"));
        System.out.println(linksList.size());

        //1.
        linksList.forEach(e -> System.out.println(e.getText()));

        //2.
        List<String> newList = linksList.stream().filter(e -> !e.getText().equals(" ")).map(e -> e.getText()).collect(Collectors.toList());
        newList.forEach(e -> System.out.println(e));

        //3
        String firstText = linksList.stream().filter(e -> !e.getText().equals(" ")).findFirst().get().getText();
        System.out.println(firstText);

        //4
        String findAny = linksList.stream().filter(e -> !e.getText().equals(" ")).findAny().get().getText();
        System.out.println(findAny);

        //5 exclude blank text and which starts with Amazon
        List<String> textStartsWithAmazon = linksList.stream().filter(e -> !e.getText().equals("") && e.getText().startsWith("Amazon"))
                .map(e -> e.getText()).collect(Collectors.toList());
        textStartsWithAmazon.forEach(e -> System.out.println(e));

        //6 text contains Amazon
        List<String> textContainsAmazon = linksList.stream().filter(e -> !e.getText().equals("") && e.getText().contains("Amazon"))
                .map(e -> e.getText()).collect(Collectors.toList());
        textContainsAmazon.forEach(e -> System.out.println(e));

        //7 double filter

        List<String> properList = linksList.stream().filter(e -> !e.getText().isEmpty()).filter(e -> !e.getText().startsWith(" "))
                .map(e -> e.getText().trim()).collect(Collectors.toList());

        properList.forEach(e -> System.out.println(e));


        driver.quit();
    }
}
