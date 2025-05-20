package designpatterns.singleton;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Singleton Pattern Demo ---");

        // Eager Initialization
        EagerInitializationSingleton eager1 = EagerInitializationSingleton.getInstance();
        EagerInitializationSingleton eager2 = EagerInitializationSingleton.getInstance();
        System.out.println("\nEager Initialization Singleton:");
        System.out.println("Instance 1 hash: " + eager1.hashCode());
        System.out.println("Instance 2 hash: " + eager2.hashCode());
        System.out.println("Are instances the same? " + (eager1 == eager2));

        // Lazy Initialization (Note: basic example, not inherently thread-safe)
        LazyInitializationSingleton lazy1 = LazyInitializationSingleton.getInstance();
        LazyInitializationSingleton lazy2 = LazyInitializationSingleton.getInstance();
        System.out.println("\nLazy Initialization Singleton:");
        System.out.println("Instance 1 hash: " + lazy1.hashCode());
        System.out.println("Instance 2 hash: " + lazy2.hashCode());
        System.out.println("Are instances the same? " + (lazy1 == lazy2));

        // Thread-Safe Singleton
        ThreadSafeSingleton threadSafe1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton threadSafe2 = ThreadSafeSingleton.getInstance();
        System.out.println("\nThread-Safe Singleton:");
        System.out.println("Instance 1 hash: " + threadSafe1.hashCode());
        System.out.println("Instance 2 hash: " + threadSafe2.hashCode());
        System.out.println("Are instances the same? " + (threadSafe1 == threadSafe2));
        
        // Double-Checked Locking Singleton
        DoubleCheckLockingSingleton dcl1 = DoubleCheckLockingSingleton.getInstance();
        DoubleCheckLockingSingleton dcl2 = DoubleCheckLockingSingleton.getInstance();
        System.out.println("\nDouble-Check Locking Singleton:");
        System.out.println("Instance 1 hash: " + dcl1.hashCode());
        System.out.println("Instance 2 hash: " + dcl2.hashCode());
        System.out.println("Are instances the same? " + (dcl1 == dcl2));

        System.out.println("\n--- End of Singleton Demo ---");
    }
}
