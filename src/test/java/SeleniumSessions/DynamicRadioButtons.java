package SeleniumSessions;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicRadioButtons {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));;

		driver.get("https://demoqa.com/radio-button");

		List<WebElement> radioButtons = driver.findElements(By.xpath("//label[@class='custom-control-label']"));

		for (int i = 0; i < radioButtons.size(); i++) {
			WebElement localRadio = radioButtons.get(i);

			String value = localRadio.getAttribute("value");

			if (value.equalsIgnoreCase("Impressive")) {
				localRadio.click();
			}
		}

	}

}
