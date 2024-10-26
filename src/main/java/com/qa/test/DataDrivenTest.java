package com.qa.test;

import com.qa.util.XlsReader;

public class DataDrivenTest {

    public static void main(String[] args) {

        XlsReader xlsReader = new XlsReader("C:\\SeleniumProject\\src\\main\\java\\com\\qa\\testdata\\DataDriven.xlsx");
        String firstName = xlsReader.getCellData("Signup", "First Name", 2);
        System.out.println(firstName);


//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//
//        driver.get("https://formsmarts.com/html-form-example");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


    }
}
