package SeleniumSessions;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsConcept {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// 1. To get total no of links on the page and print all those links.

		List<WebElement> LinkList = driver.findElements(By.tagName("a"));

		System.out.println(LinkList.size()); // To get total no of links on the page

		for (int i = 0; i < LinkList.size(); i++) { // print all those links.
			String LinkTexts = LinkList.get(i).getText();
			System.out.println(LinkTexts);
		}

	}

}
