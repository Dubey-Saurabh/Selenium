package BonigarciaSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class MouseOver {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Actions action = new Actions(driver);
        List<String> imageList = Arrays.asList("compass", "calendar", "award", "landscape");

        for (String imageName : imageList) {
            String xPath = String.format("//img[@src='img/%s.png']", imageName);
            WebElement image = driver.findElement(By.xpath(xPath));
            action.moveToElement(image).build().perform();
            WebElement caption = driver.findElement(RelativeLocator.with(By.tagName("div")).near(image));
            assertThat(caption.getText()).containsIgnoringCase(imageName);
            Thread.sleep(4000);

        }
    }


}
