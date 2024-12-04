package HeadlessBrowserConcept;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; // To run test cases without lanching a browser.
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HTMLUnitDriverConcept {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Saurabh_Dubey\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new HtmlUnitDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.facebook.com/");

		driver.getTitle();	

		driver.findElement(By.id("email")).sendKeys("sack.rd");
		driver.findElement(By.id("pass")).sendKeys("Facebook");

		driver.findElement(By.xpath("//button[@name='login' and @type = 'submit']")).click();

		driver.getTitle();

	}

}
