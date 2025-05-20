public class EagerInitializationSingleton {

    private static volatile EagerInitializationSingleton  singleton= new EagerInitializationSingleton();

    private EagerInitializationSingleton(){} //private constructor

    private static EagerInitializationSingleton getInstance(){
        return singleton;
    }
}
