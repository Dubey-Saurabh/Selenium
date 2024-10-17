package SingletonFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverInitialisation {

    private static DriverInitialisation driverInitialisation = null;
    public static WebDriver driver;


    private DriverInitialisation() {
    }

    ;

    public static DriverInitialisation getObject() {
        if (driverInitialisation == null)
            driverInitialisation = new DriverInitialisation();
        return driverInitialisation;
    }

    public WebDriver openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }


}
