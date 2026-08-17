package SeleniumSessions.ShadomDOM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ByJavaScriptExecutor extends BaseTest {

    @Test
    public void testShadowDOMWithJSE() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html");
        WebElement content = driver.findElement(By.id("content"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        SearchContext shadowRoot = (SearchContext) jse.executeScript("return arguments[0].shadowRoot", content);
        WebElement textElement = shadowRoot.findElement(By.cssSelector("p"));
        Assert.assertEquals(textElement.getText(), "Hello Shadow DOM", "Text does not match!");
    }

}
