public class ThreadSafeSingleton {

    private static volatile ThreadSafeSingleton singleton;

    private ThreadSafeSingleton() {} //private constructor

    private synchronized static ThreadSafeSingleton getInstance() { // we synchronize the method

        if (null == singleton) { // if no instance is created we create one
            singleton =  new ThreadSafeSingleton();
        }

        return singleton;
    }
}
