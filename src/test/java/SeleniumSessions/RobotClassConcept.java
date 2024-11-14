package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class RobotClassConcept {

    public static void main(String[] args) throws AWTException, IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://tutorialsninja.com/demo/");

        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("HP");

        Robot robot = new Robot();

        //Press ENTER key from keyboard to search
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        //Taking screenshot way 1
        Rectangle rectangle = new Rectangle(25, 50, 1000, 300);
        BufferedImage image = robot.createScreenCapture(rectangle);
        ImageIO.write(image, "PNG", new File("./target/scByRobotClass.png"));

        //Taking screenshot way 2, to get the complete size of the page
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle1 = new Rectangle(d);
        BufferedImage image1= robot.createScreenCapture(rectangle1);
        ImageIO.write(image1, "PNG", new File("./target/scByRobotClass1.png"));

        //Scroll via Mouse wheel
        robot.mouseWheel(15);
        robot.delay(2000);
        robot.mouseWheel(-5);





        driver.quit();
    }

}
