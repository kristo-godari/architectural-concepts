public class DoubleCheckLockingSingleton {

    private static volatile DoubleCheckLockingSingleton singleton;

    private DoubleCheckLockingSingleton() {} //private constructor

    private static DoubleCheckLockingSingleton getInstance() {

        if (null == singleton) { // if no instance is created we create one

            synchronized (DoubleCheckLockingSingleton.class) { // we use synchronized block to make it thread safe
                if (null == singleton) { // we check again  to be sure that no other thread initialized  this variable
                    singleton = new DoubleCheckLockingSingleton();
                }
            }
        }

        return singleton;
    }
}
