package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickByJavaScriptExecutor {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		driver.get("https://en-gb.facebook.com/");
		
		WebElement username = driver.findElement(By.id("email"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].value='saurabh@gmail.com'", username);      // ENter text in a field
		
		js.executeScript("document.getElementByName('login').click()");   // to click
		
		WebElement loginButton=driver.findElement(By.xpath("//button[@name='login']"));   
		
		js.executeScript("arguments[0].click()", loginButton);     // While using xpath
		
		

	}

}
