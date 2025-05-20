public class ReflectionSafeSingleton {

    private static volatile ReflectionSafeSingleton singleton;

    //private constructor
    private ReflectionSafeSingleton() {
        //Protection for Reflection api
        if (singleton != null){
            throw new RuntimeException("Please use getInstance() method for getting an instance,");
        }
    }

    private static ReflectionSafeSingleton getInstance() {

        if (null == singleton) { // if no instance is created we create one

            synchronized (ReflectionSafeSingleton.class) { // we use synchronized block to make it thread safe
                if (null == singleton) { // we check again  to be sure that no other thread initialized  this variable
                    singleton = new ReflectionSafeSingleton();
                }
            }
        }

        return singleton;
    }
}
