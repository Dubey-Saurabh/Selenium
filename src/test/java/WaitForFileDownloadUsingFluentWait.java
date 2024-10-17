import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.time.Duration;

public class WaitForFileDownloadUsingFluentWait {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://get.jenkins.io/windows-stable/2.426.1/jenkins.msi");

        String downloadPath = "C:\\Users\\Saurabh_Dubey";
        String fileName = "jenkins.msi";

        File file = new File(downloadPath, fileName);

        FluentWait<File> wait = new FluentWait<>(file)
                .withTimeout(Duration.ofMinutes(5))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(Exception.class);

        boolean isDownloaded = wait.until(f -> f.exists() && f.canRead());
        if (isDownloaded) {
            System.out.println("file is 100% downloaded");
        } else {
            System.out.println("Not downloaded");
        }

    }
}
