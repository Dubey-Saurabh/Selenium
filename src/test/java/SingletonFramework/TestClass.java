package SingletonFramework;

public class TestClass {

    //NOTE: In normal class, we use constructor to instantiate a class whereas in Singleton concept we use method like getObject in this class.

    public static void main(String[] args) {

        /*initialize runnable interface*/
        Runnable task = () -> {
            DriverInitialisation.getObject().getMessage();

        };


        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);
        Thread thread4 = new Thread(task);
        Thread thread5 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();


        /*Waiting for threads to complete*/
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            e.getMessage();
        }

    }
}
