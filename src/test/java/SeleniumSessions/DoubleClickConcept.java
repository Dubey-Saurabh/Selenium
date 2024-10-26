package SeleniumSessions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickConcept {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));;
		
		driver.get("https://api.jquery.com/dblclick/#entry-examples");
		
		driver.switchTo().frame(0);
		
		Actions action = new Actions(driver);
		
		action.doubleClick(driver.findElement(By.xpath("//span[text()='Double click the block']//parent::body/div"))).build().perform();


	}

}
