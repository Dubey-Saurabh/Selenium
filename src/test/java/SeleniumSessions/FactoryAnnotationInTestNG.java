package SeleniumSessions;

import org.testng.annotations.Factory;

public class FactoryAnnotationInTestNG {

    /*To run a class multiple times so that multiple instances of that class can be created we use Factory annotation
    * Which ever methods are there in that class will run accordingly */

    @Factory
    public Object[] factoryGeneration() {

        Object[] objects = {

                new FactoryAnnotationUsedClass(),
                new FactoryAnnotationUsedClass(),
                new FactoryAnnotationUsedClass()

        };
        return objects;

    }

}
