package SeleniumSessions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadProperties {

	public static void main(String[] args) throws IOException {
		WebDriver driver = null;
		Properties prop = new Properties();

		FileInputStream fis = new FileInputStream(
				"C:\\SeleniumProject\\config.properties");

		prop.load(fis);

		System.out.println(prop.getProperty("browser"));

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}

		driver.get(prop.getProperty("url"));

		driver.findElement(By.id(prop.getProperty("id_locator"))).sendKeys(prop.getProperty("username"));
		driver.findElement(By.id(prop.getProperty("id_locator_pass"))).sendKeys(prop.getProperty("password"));

	}
}