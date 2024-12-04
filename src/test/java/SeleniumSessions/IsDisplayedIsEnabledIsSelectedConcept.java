package SeleniumSessions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class IsDisplayedIsEnabledIsSelectedConcept {

		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
		     WebDriver driver  = new ChromeDriver();  
		     
		     driver.manage().window().maximize();
		     driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		     
		     driver.get("https://freecrm.com/");
		     
		     // isDisplayed = to check if element is available on the page or not. 
		    boolean b1 = driver.findElement(By.xpath("//span[contains(text(),'Start Here')]")).isDisplayed();
		    Assert.assertTrue(b1);
		
		   // isEnabled = web element is enabled or not  
         // isSelected = only applicable for checkbox, dropdown, radiobutton		

	}

}
