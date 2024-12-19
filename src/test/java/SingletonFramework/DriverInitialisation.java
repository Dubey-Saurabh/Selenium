package SingletonFramework;

import org.openqa.selenium.WebDriver;

public class DriverInitialisation {

    /*private static instance of the class
     * private constructor to avoid instantiation
     * public static method to provide access  to the instance/object
     * individual method of the class*/

    /*volatile keyword is to make sure all the method is able to perform read operation on the particular method*/
    private volatile static DriverInitialisation driverInitialisation = null;
    public static WebDriver driver;


    private DriverInitialisation() {
        if (driverInitialisation !=null){
            throw new IllegalArgumentException("Object is already created");
        }
    }

    /*we use synchronized keyword in order to maintain the thread attacks on the method and also to maintain the queue*/
    public static DriverInitialisation getObject() {

        if (driverInitialisation == null) {

            synchronized (DriverInitialisation.class) {
                if (driverInitialisation == null)
                    driverInitialisation = new DriverInitialisation();
            }

        }
        return driverInitialisation;
    }

    public void getMessage() {
        System.out.println("Browser Info");
    }


}
