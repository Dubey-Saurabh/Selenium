package SeleniumSessions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationsConcept {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	     WebDriver driver  = new ChromeDriver();  
	     driver.manage().window().maximize();
	     driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	     
	     driver.get("https://www.amazon.in/");
	  // To navigate to other url
	     driver.navigate().to("https://www.facebook.com");   
	     // To navigate backward
	    driver.navigate().back();
	    // To navigate Forward
	    driver.navigate().forward();
	    //To refresh the page
	    driver.navigate().refresh();
	    
	     
	    
	     
	     
	     
	     
		
		
		
		
		
		
		
	}

}
