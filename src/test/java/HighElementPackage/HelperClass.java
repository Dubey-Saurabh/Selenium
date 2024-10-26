package HighElementPackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperClass {

	public static void highlightElement(WebDriver driver, WebElement username) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border : 2px solid red;');", username);

		try {

			Thread.sleep(5000);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		js.executeScript("arguments[0].setAttribute('style','border : 2px white;');", username);
	}

}
