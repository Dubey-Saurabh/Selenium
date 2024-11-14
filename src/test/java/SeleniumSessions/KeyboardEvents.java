package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class KeyboardEvents {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://en-gb.facebook.com/");
		
		Actions action = new Actions(driver);
		
		action.sendKeys(Keys.ENTER).build().perform();
		
		driver.findElement(By.id("email")).sendKeys("saurabhdubey@gmail.com");
		
		action.sendKeys(Keys.TAB).sendKeys("password").sendKeys(Keys.ENTER).build().perform();

		
	}

}
