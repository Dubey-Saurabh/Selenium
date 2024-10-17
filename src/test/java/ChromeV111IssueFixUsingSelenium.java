import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeV111IssueFixUsingSelenium {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions cp = new ChromeOptions();
        cp.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.get("https:\\www.google.com");
        System.out.println(driver.getTitle());
        Thread.sleep(4000);
        driver.quit();


    }
}
