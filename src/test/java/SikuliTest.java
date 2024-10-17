import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.sikuli.api.Screen;

import java.time.Duration;
import java.util.regex.Pattern;

public class SikuliTest {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.youtube.com/watch?v=56lkofpjOAs");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.quit();

//        Screen s = new Screen();
//
//        Pattern pauseImage = new Pattern("YT_pause.png");
//
//        s.wait(pauseImage,2000);
//
//        s.click();





    }
}
