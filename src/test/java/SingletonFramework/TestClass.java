package SingletonFramework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass {

    //NOTE: In normal class, we use constructor to instantiate a class whereas in Singleton concept we use method like getObject in this class.

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        DriverInitialisation instance = DriverInitialisation.getObject();
        driver = instance.openBrowser();

    }

    @Test
    public void getGoogleTitle() {

        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }


}
