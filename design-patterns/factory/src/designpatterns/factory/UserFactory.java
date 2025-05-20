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
