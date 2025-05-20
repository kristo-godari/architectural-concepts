# Factory Design Pattern Example

This directory contains a simple Java example demonstrating the Factory Design Pattern.

## Purpose of the Factory Pattern

The Factory Pattern is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created. Its main purpose is to **decouple the client code from the concrete classes** it needs to instantiate. Instead of the client creating objects directly using the `new` operator, it asks a factory object to create an object for it.

This pattern promotes loose coupling and makes the system more flexible and extensible, as new types of objects can be added to the factory without changing the client code.

## How it Works

The Factory Pattern typically involves the following components:

1.  **Product Interface/Abstract Class:** Defines the interface for the objects the factory method creates. (In our example: `User.java`)
2.  **Concrete Products:** Actual classes that implement the Product interface. (In our example: `AdminUser.java`, `RegularUser.java`)
3.  **Creator (Factory) Class:**
    *   Contains the factory method (`createUser` in our example).
    *   This method returns an object of the Product type.
    *   It can be an abstract class with an abstract factory method (forcing subclasses to implement it), or a concrete class with a default factory method.
    *   Sometimes, the factory method is `static`, allowing it to be called without creating an instance of the factory class (this is often called a Simple Factory, which is what we've implemented here).

## When to Use It

The Factory Pattern is particularly useful when:

*   A class cannot anticipate the class of objects it must create beforehand.
*   A class wants its subclasses to specify the objects it creates.
*   You want to provide users of your library or framework with a way to create objects without exposing the complex instantiation logic.
*   You want to centralize object creation to promote consistency and make it easier to manage and change creation logic.
*   You need to return various implementations of an interface or abstract class.

## Example Walkthrough

In this example, we have a system that needs to create different types of `User` objects.

1.  **`src/designpatterns/factory/User.java` (Product Interface):**
    *   This interface defines the common contract for all user types. It declares methods like `getUsername()` and `getPermissions()`.

    ```java
    package designpatterns.factory;

    public interface User {
        String getUsername();
        String getPermissions();
    }
    ```

2.  **`src/designpatterns/factory/AdminUser.java` and `src/designpatterns/factory/RegularUser.java` (Concrete Products):**
    *   These classes implement the `User` interface.
    *   `AdminUser` represents a user with administrative privileges.
    *   `RegularUser` represents a standard user with limited permissions.
    *   Each class provides its own implementation for `getUsername()` and `getPermissions()`.

    *Example: `src/designpatterns/factory/AdminUser.java`*
    ```java
    package designpatterns.factory;

    public class AdminUser implements User {
        // ... constructor and methods ...
        @Override
        public String getPermissions() {
            return "Admin Permissions: Read, Write, Execute, Delete";
        }
    }
    ```

3.  **`src/designpatterns/factory/UserFactory.java` (Creator/Factory Class):**
    *   This class contains the factory method `createUser(String userType, String username)`.
    *   The client code calls this method, passing the desired `userType` (e.g., "ADMIN", "REGULAR") and a `username`.
    *   Based on the `userType`, the factory instantiates and returns the appropriate concrete `User` object (`AdminUser` or `RegularUser`).
    *   If an unknown `userType` is provided, it throws an `IllegalArgumentException`.

    ```java
    package designpatterns.factory;

    public class UserFactory {
        public User createUser(String userType, String username) {
            if (userType == null || userType.isEmpty()) {
                return null;
            }
            switch (userType.toUpperCase()) {
                case "ADMIN":
                    return new AdminUser(username);
                case "REGULAR":
                    return new RegularUser(username);
                default:
                throw new IllegalArgumentException("Unknown user type: " + userType);
            }
        }
    }
    ```

**How to use the factory (conceptual):**

```java
// Client code
UserFactory factory = new UserFactory();

User admin = factory.createUser("ADMIN", "bossman");
System.out.println(admin.getUsername() + " has " + admin.getPermissions());
// Output: bossman has Admin Permissions: Read, Write, Execute, Delete

User regular = factory.createUser("REGULAR", "johndoe");
System.out.println(regular.getUsername() + " has " + regular.getPermissions());
// Output: johndoe has Regular Permissions: Read, Write
```

This example demonstrates how the client code doesn't need to know about `AdminUser` or `RegularUser` directly. It only interacts with the `UserFactory` and the `User` interface, leading to a more decoupled and flexible design.

## How to Run this Example

1.  **Navigate to the `factory` directory:**
    ```bash
    cd design-patterns/factory
    ```

2.  **Compile the Java files:**
    All source files are located in `src/`. The `Main.java` is in `src/designpatterns/factory/`.
    You need to be in the `design-patterns/factory/src` directory or specify it as the source path.
    From within `design-patterns/factory/`:
    ```bash
    javac -d out src/designpatterns/factory/*.java
    ```
    This will compile all `.java` files from the `src/designpatterns/factory` directory and place the `.class` files into a new directory named `out` (e.g., `out/designpatterns/factory/Main.class`).

3.  **Run the `Main` class:**
    Make sure to specify the classpath to include the `out` directory.
    From within `design-patterns/factory/`:
    ```bash
    java -cp out designpatterns.factory.Main
    ```

    You should see output demonstrating the creation of different user types and the handling of an unknown user type.
