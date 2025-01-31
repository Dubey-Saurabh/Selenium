package TakingScreenshotForFailedTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class ScreenshotTestClass extends BaseClass {

    @BeforeMethod
    public void setUp() {
        initialization();
    }

    @Test
    public void failedTestCase() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Instigram", "Title not matched");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
