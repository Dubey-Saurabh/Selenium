import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class MonkeyTestingUsingSelenium {

    public static void main(String[] args) throws InterruptedException {

        //Using a heatmap concept : where a website is being accessed by user


        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        List<WebElement> footerList = driver.findElements(By.cssSelector("div.navFooterVerticalRow li a"));
        int footerElementsCount = footerList.size();
        System.out.println(footerElementsCount);

        for (int i = 0; i < footerElementsCount; i++) {

            int randomIndex = (int) Math.floor(Math.random() * footerElementsCount);
            WebElement element = footerList.get(randomIndex);
            System.out.println(element.getText());
            element.click();
            driver.navigate().back();
            Thread.sleep(1500);
            footerList = driver.findElements(By.cssSelector("div.navFooterVerticalRow li a"));


        }


    }
}
