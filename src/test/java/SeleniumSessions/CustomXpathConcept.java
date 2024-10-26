package SeleniumSessions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpathConcept {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));;

		driver.findElement(By.xpath("//input [contains (@id, 'test')")).sendKeys("xyx");

		// a) -- //tagname[contains(@attribute,'values')]
		// 2) -- //tagname[contains(text(),'values')]

		driver.findElement(By.xpath("//input[starts-with(@id, 'test_')")).click(); // id = test_1254, id = test_3659874
																					
		driver.findElement(By.xpath("//input[ends-with(@id, '_test')")).click(); // id = 23654_test, id = 223665458_test

	}

}
