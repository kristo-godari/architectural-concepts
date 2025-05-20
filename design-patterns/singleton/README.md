# Singleton Design Pattern Examples

This directory contains various Java examples demonstrating the Singleton Design Pattern.

## Purpose of the Singleton Pattern

The Singleton Pattern is a creational design pattern that ensures a class has **only one instance** and provides a **global point of access** to that instance.

Its main purposes are:
*   To ensure that a class has exactly one instance.
*   To provide a well-known access point to that instance for any client code.
*   To control concurrent access to a shared resource (though thread-safety needs careful consideration).

This is useful for managing shared resources like database connections, logging facilities, or configuration settings, where having multiple instances could lead to inconsistent behavior or resource contention.

## How it Works

The Singleton pattern typically involves:

1.  **Private Constructor:** The constructor of the singleton class is made private to prevent direct instantiation from outside the class.
2.  **Static Instance Variable:** The class holds a static reference to its own unique instance.
3.  **Static Access Method (e.g., `getInstance()`):** The class provides a public static method that returns the single instance. This method is responsible for creating the instance if it doesn't exist yet (lazy initialization) or simply returning the existing instance.

## When to Use It

The Singleton Pattern should be used judiciously, as it can introduce global state into an application, making it harder to test and maintain. However, it is appropriate when:

*   You need exactly one instance of a class, and this instance must be accessible to clients from a well-known access point.
*   The single instance should be extensible by subclassing, and clients should be able to use an extended instance without modifying their code (though this can be complex).
*   You are managing a shared resource, like a database connection pool, a thread pool, a system configuration manager, or a logging service.

## Example Implementations in this Directory

This directory showcases several common ways to implement the Singleton pattern in Java, each with its own trade-offs regarding thread-safety, lazy initialization, and resilience against certain attacks (like reflection or serialization).

*   **`src/designpatterns/singleton/EagerInitializationSingleton.java`:** The instance is created when the class is loaded. Simplest form, inherently thread-safe.
*   **`src/designpatterns/singleton/LazyInitializationSingleton.java`:** The instance is created only when `getInstance()` is called for the first time. Not thread-safe by itself.
*   **`src/designpatterns/singleton/ThreadSafeSingleton.java`:** Modifies lazy initialization to make it thread-safe, typically by synchronizing the `getInstance()` method or a critical section within it.
*   **`src/designpatterns/singleton/DoubleCheckLockingSingleton.java`:** An optimization for thread-safe lazy initialization that aims to reduce the overhead of synchronization once the instance is created. Requires careful implementation (e.g., `volatile` keyword for the instance variable).
*   **`src/designpatterns/singleton/ReflectionSafeSingleton.java`:** Attempts to prevent the singleton contract from being broken via reflection (e.g., by throwing an exception in the constructor if an instance already exists).
*   **`src/designpatterns/singleton/SerializingTheSingleton.java`:** Addresses issues that can arise when a singleton class is serializable. Without special handling (like implementing `readResolve()`), deserialization can create new instances, breaking the singleton guarantee.

By examining these different implementations, you can understand the nuances of creating robust singleton objects in various scenarios, especially in multi-threaded environments or when dealing with Java features like serialization and reflection.

## How to Run the Main Demo

A `Main.java` file is provided in `src/designpatterns/singleton/Main.java` to demonstrate the basic behavior of a few of these singleton implementations.

1.  **Navigate to the `singleton` directory:**
    ```bash
    cd design-patterns/singleton
    ```

2.  **Compile the Java files:**
    All source files are located in `src/`. The `Main.java` is in `src/designpatterns/singleton/`.
    From within `design-patterns/singleton/`:
    ```bash
    javac -d out src/designpatterns/singleton/*.java
    ```
    This will compile all `.java` files from the `src/designpatterns/singleton` directory and place the `.class` files into a new directory named `out` (e.g., `out/designpatterns/singleton/Main.class`).

3.  **Run the `Main` class:**
    Make sure to specify the classpath to include the `out` directory.
    From within `design-patterns/singleton/`:
    ```bash
    java -cp out designpatterns.singleton.Main
    ```

    You should see output confirming that for each type of singleton demonstrated, multiple calls to `getInstance()` return the same object instance.
