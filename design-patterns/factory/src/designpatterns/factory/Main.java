package designpatterns.factory;

public class Main {
    public static void main(String[] args) {
        UserFactory factory = new UserFactory();

        System.out.println("--- Factory Pattern Demo ---");

        User admin = factory.createUser("ADMIN", "AliceAdmin");
        if (admin != null) {
            System.out.println("Created User: " + admin.getUsername());
            System.out.println("Permissions: " + admin.getPermissions());
        }
        System.out.println();

        User regular = factory.createUser("REGULAR", "BobRegular");
        if (regular != null) {
            System.out.println("Created User: " + regular.getUsername());
            System.out.println("Permissions: " + regular.getPermissions());
        }
        System.out.println();

        try {
            System.out.println("Attempting to create an unknown user type...");
            User unknown = factory.createUser("GUEST", "CarolGuest");
            if (unknown == null) { // Should not happen if exception is thrown
                 System.out.println("Unknown user type resulted in null.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
        System.out.println("--------------------------");
    }
}
