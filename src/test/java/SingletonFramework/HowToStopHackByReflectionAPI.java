package SingletonFramework;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class HowToStopHackByReflectionAPI {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        DriverInitialisation instance1 = DriverInitialisation.getObject();
        DriverInitialisation instance2 = null;

        Constructor<DriverInitialisation> constructor = DriverInitialisation.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        instance2 = constructor.newInstance();

        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());


    }
}