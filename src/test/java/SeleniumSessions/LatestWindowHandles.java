package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LatestWindowHandles {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.instagram.com/"); // Parent Window
        String parentWindowId = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[@href='https://about.meta.com/']")).click();
        driver.findElement(By.xpath("//a[@href='https://about.instagram.com/']")).click();
        driver.findElement(By.xpath("//a[@href='https://about.instagram.com/blog/']")).click();
        driver.findElement(By.xpath("//a[@href='https://about.instagram.com/about-us/careers']")).click();

        Set<String> handles = driver.getWindowHandles();
        List<String> handleList = new ArrayList<>(handles);

        if (switchToRightWindow("Meta", handleList)) {
            System.out.println(driver.getCurrentUrl() + ", " + driver.getTitle());
        }

        closeAllWindowsExceptParentWindow(handleList, parentWindowId);
        switchToParentWindow(parentWindowId);
        System.out.println(driver.getCurrentUrl() + ", " + driver.getTitle());
    }

    public static void closeAllWindowsExceptParentWindow(List<String> handleList, String parentWindowId) {

        for (String window : handleList) {
            if (!window.equals(parentWindowId)) {
                driver.switchTo().window(window).close();
            }
        }

    }

    public static void switchToParentWindow(String parentWindowId) {
        driver.switchTo().window(parentWindowId);

    }

    //Switch to window we want to
    public static boolean switchToRightWindow(String windowTitle, List<String> handleList) throws InterruptedException {

        for (String element : handleList) {

            String title = driver.switchTo().window(element).getTitle();
            Thread.sleep(3000);

            if (title.contains(windowTitle)) {
                System.out.println("Return the right window");
                return true;
            }

        }

        return false;
    }
}
