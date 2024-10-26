package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class SelectOrStaticDropdownConcept {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	     WebDriver driver  = new ChromeDriver();  
	     driver.get("https://m.facebook.com/reg/?cid=103&refsrc=https%3A%2F%2Fm.facebook.com%2F&soft=hjk");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	     
	     driver.findElement(By.name("firstname")).sendKeys("Test");
	     driver.findElement(By.name("lastname")).sendKeys("QA");
	     driver.findElement(By.xpath("//button[@type='submit']")).click();
	     
	     // To handle select drop down
	     Select select = new Select(driver.findElement(By.id("day")));
	     
	     select.selectByVisibleText("11");    
	     
	     Select select2 = new Select(driver.findElement(By.id("month")));
	     
	     select2.selectByIndex(4);
	     
	     Select select3 = new Select(driver.findElement(By.id("year")));
	     
	     select3.selectByVisibleText("1993");
	     
	     driver.findElement(By.xpath("//button[@type='submit']")).click();
	     
	     driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9971370912");
	     driver.findElement(By.xpath("//button[@type='submit']")).click();
	     driver.findElement(By.id("Male")).click();
	     driver.findElement(By.xpath("//button[@type='submit']")).click();
	     driver.findElement(By.name("reg_passwd__")).sendKeys("Password@13");
	     driver.findElement(By.name("submit")).click();
	    
	     

	}

}
