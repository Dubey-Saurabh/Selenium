package SeleniumSessions.WindowTabFrameHandles;

import java.time.Duration;
import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowsAndAutoSuggestiveDropdown {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/"); //1
//		driver.manage().window().fullscreen();
//		driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(3000);
        driver.switchTo().newWindow(WindowType.WINDOW); //2
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.switchTo().newWindow(WindowType.WINDOW); //3
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.switchTo().newWindow(WindowType.WINDOW); //4
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        System.out.println(driver.manage().window().getSize());
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

        //Switching window on the basis of indexes
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);

        //Parent Window
       // driver.switchTo().window(driver.getWindowHandles().iterator().next());

        //last window
        driver.switchTo().window(driver.getWindowHandles().stream().reduce((first, second) -> second).orElse(null));

        driver.findElement(By.id("autosuggest")).sendKeys("ind");

        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        for (WebElement option : options) {

            if (option.getText().equalsIgnoreCase("India")) {

                option.click();

                break;
            }
        }
    }
}
