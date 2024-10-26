package SeleniumSessions;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WIndowHandleConcept {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://demoqa.com/browser-windows");

		String parentWIndow = driver.getWindowHandle();

		driver.findElement(By.xpath("//button[text()='New Window']")).click();

		Set<String> allWindows = driver.getWindowHandles();

		for (String child : allWindows) {

			if (!parentWIndow.equalsIgnoreCase(child)) {

				driver.switchTo().window(child);

				Thread.sleep(3000);

				driver.close();
			}
		}
		driver.switchTo().window(parentWIndow);

		System.out.println("Parent Window title would be:" + driver.getTitle());

	}

}
