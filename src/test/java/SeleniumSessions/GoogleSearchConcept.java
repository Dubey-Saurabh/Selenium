package SeleniumSessions;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchConcept {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	     WebDriver driver  = new ChromeDriver();  
	     driver.manage().window().maximize();
	     driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	     
	     driver.get("https://www.google.com");
	     
	     driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("testing");

		 Thread.sleep(4000);
	     List<WebElement> List = driver.findElements(By.xpath("//ul[@role= 'listbox']"));
	     System.out.println("Total Suggestions: " + List.size());

	}

}
