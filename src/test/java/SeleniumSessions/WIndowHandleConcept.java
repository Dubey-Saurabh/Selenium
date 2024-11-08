package SeleniumSessions;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WIndowHandleConcept {

	public static void main(String[] args) throws InterruptedException {


//		17. driver.switchTo().window(driver.getWindowHandles().iterator().next()): Switches to the first window in the list of window handles.
//		18. driver.switchTo().window(driver.getWindowHandles().toArray()[index]): Switches to a window using its index in the list of window handles.
//		19. driver.switchTo().window(driver.getWindowHandles().stream().filter(handle -> handle.equals(windowHandle)).findFirst().orElse(null)): Switches to a specific window handle using a stream filter.
//		20. driver.switchTo().window(driver.getWindowHandles().stream().reduce((first, second) -> second).orElse(null)): Switches to the last opened window handle.
//		21. driver.switchTo().window(driver.getWindowHandles().stream().findFirst().orElse(null)): Switches to the first opened window handle.

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
