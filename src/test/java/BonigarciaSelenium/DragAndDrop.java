package BonigarciaSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Point;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;

public class DragAndDrop {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/drag-and-drop.html");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Actions action = new Actions(driver);
        WebElement draggable = driver.findElement(By.id("draggable"));
        int offSet = 100;
        Point initLocation = draggable.getLocation();
        action.dragAndDropBy(draggable, offSet, 0).dragAndDropBy(draggable, 0, offSet).dragAndDropBy(draggable, -offSet, 0)
                .dragAndDropBy(draggable, 0, -offSet).build().perform();
        assertThat(initLocation).isEqualTo(draggable.getLocation());
        WebElement target = driver.findElement(By.id("target"));
        action.dragAndDrop(draggable, target).build().perform();
        assertThat(target.getLocation()).isEqualTo(draggable.getLocation());
        driver.close();

    }
}
