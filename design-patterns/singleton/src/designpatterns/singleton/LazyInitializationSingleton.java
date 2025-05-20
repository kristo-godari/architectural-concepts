public class LazyInitializationSingleton {

    private static volatile LazyInitializationSingleton singleton;

    private LazyInitializationSingleton() {} //private constructor

    private static LazyInitializationSingleton getInstance() {

        if (null == singleton) { // if no instance is created we create one
            singleton =  new LazyInitializationSingleton();
        }

        return singleton;
    }
}
