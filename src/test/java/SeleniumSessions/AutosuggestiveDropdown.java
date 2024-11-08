package SeleniumSessions;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutosuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
//		driver.manage().window().fullscreen();
//		driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().window().getSize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));;

		//driver.switchTo().window(driver.getWindowHandles().iterator().next()): Switches to the first window in the list of window handles.
		//driver.switchTo().window(driver.getWindowHandles().toArray()[index]): Switches to a window using its index in the list of window handles.

//		driver.findElement(By.id("autosuggest")).sendKeys("ind");
//
//		Thread.sleep(3000);
//
//		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
//
//		for (WebElement option : options)
//
//		{
//
//			if (option.getText().equalsIgnoreCase("India"))
//
//			{
//
//				option.click();
//
//				break;
//
//
//			}
//
//
//		}
//
	}

}
