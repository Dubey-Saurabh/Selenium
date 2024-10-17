import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class YoutubeTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.youtube.com/playlist?list=PLFGoYjJG_fqo4oVsa6l_V-_7-tzBnlulT");
        driver.manage().window().maximize();

        WebElement premiumButton= driver.findElement(By.cssSelector("yt-icon#logo-icon span"));
        premiumButton.click();

        driver.quit();

    }
}
