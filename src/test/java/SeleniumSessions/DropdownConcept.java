package SeleniumSessions;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownConcept {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));;

		driver.get("https://en-gb.facebook.com/");

		driver.findElement(By.xpath("//a[@role='button' and @data-testid='open-registration-form-button']")).click();

		Select day = new Select(driver.findElement(By.xpath("//select[@name='birthday_day' and @title='Day']")));

		day.selectByVisibleText("16");

		List<WebElement> dayList = day.getOptions();         // to get all the options in a dropdown

		for (WebElement ele : dayList) {          
			
			String dayValues = ele.getText();

			System.out.println("Day values will be:" + dayValues);
		}

	}

}
