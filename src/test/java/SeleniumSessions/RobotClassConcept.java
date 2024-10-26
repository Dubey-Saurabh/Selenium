package SeleniumSessions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RobotClassConcept {

	public static void main(String[] args) throws AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://en-gb.facebook.com/");

		driver.findElement(By.id("email")).sendKeys("Abc");

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_TAB);

		driver.findElement(By.id("pass")).sendKeys("Pqr");

		robot.keyPress(KeyEvent.VK_ENTER);

	}

}
