import java.io.Serializable;

public class SerializingTheSingleton implements Serializable {

    private static volatile SerializingTheSingleton singleton;

    //private constructor
    private SerializingTheSingleton() {
        //Protection for Reflection api
        if (singleton != null){
            throw new RuntimeException("Please use getInstance() method for getting an instance,");
        }
    }

    private static SerializingTheSingleton getInstance() {

        if (null == singleton) { // if no instance is created we create one

            synchronized (SerializingTheSingleton.class) { // we use synchronized block to make it thread safe
                if (null == singleton) { // we check again  to be sure that no other thread initialized  this variable
                    singleton = new SerializingTheSingleton();
                }
            }
        }

        return singleton;
    }

    //Ensures that no new instance is created during the serialization and deserialization
    protected SerializingTheSingleton readResolve() {
        return getInstance();
    }
}
