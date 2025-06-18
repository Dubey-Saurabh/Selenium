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

		/*1. driver.switchTo().frame(frame): Switches focus to a frame using its name or ID.
		2. driver.switchTo().frame(int index): Switches focus to a frame using its index number.
		3. driver.switchTo().frame(webElement): Switches focus to a frame using a WebElement reference.
		4. driver.switchTo().defaultContent(): Switches back to the main document from a frame.
		5. driver.switchTo().parentFrame(): Switches to the parent frame of the currently focused frame.
		6. driver.switchTo().frame("frameName"): Switches focus to a frame using its name.
		7. driver.switchTo().frame("frameId"): Switches focus to a frame using its ID.
		8. driver.switchTo().frame(0): Switches focus to the first frame on the page (index 0).
		9. driver.switchTo().frame(1): Switches focus to the second frame on the page (index 1).
		driver.switchTo().frame(driver.findElement(By.id("nestedFrameId")).findElement(By.tagName("iframe"))): Switches to an iframe inside another frame.
		21. driver.switchTo().frame(driver.findElement(By.xpath("//iframe[1]"))): Switches focus to the first iframe found on the page.
		22. driver.switchTo().frame(driver.findElement(By.xpath("//iframe[last()]"))): Switches focus to the last iframe found on the page.
		23. driver.switchTo().frame(driver.findElement(By.xpath("//iframe[position()=2]"))): Switches focus to the second iframe on the page using XPath.
		24. driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'frameName')]"))): Switches focus to a frame based on a partial match of the src attribute.
		25. driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@id, 'frameIdPrefix')]"))): Switches focus to a frame based on a prefix match of the ID attribute.
		26. driver.switchTo().frame(driver.findElement(By.xpath("//iframe[not(@id='excludedFrameId')]"))): Switches focus to a frame excluding a specific ID.
		27. driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class*='frameClassName']"))): Switches focus to a frame based on a partial class name match.
		28. driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[id^='frameIdPrefix']"))): Switches focus to a frame based on an ID prefix match using CSS selector.
		29. driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[id$='frameIdSuffix']"))): Switches focus to a frame based on an ID suffix match using CSS selector.
		30. driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class~='frameClassName']"))): Switches focus to a frame based on a class name containing a specific value using CSS selector.*/

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

		driver.quit();

	}

}
