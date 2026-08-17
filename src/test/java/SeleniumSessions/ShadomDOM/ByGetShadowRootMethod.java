package SeleniumSessions.ShadomDOM;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ByGetShadowRootMethod extends BaseTest {

    @Test
    public void testShadowDOM() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html");
        WebElement content = driver.findElement(By.id("content"));

        SearchContext shadowRoot = content.getShadowRoot();
        WebElement textElement = shadowRoot.findElement(By.cssSelector("p"));
        Assert.assertEquals(textElement.getText(), "Hello Shadow DOM", "Text does not match!");
    }

}
