package designpatterns.factory;

public class AdminUser implements User {
    private String username;

    public AdminUser(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPermissions() {
        return "Admin Permissions: Read, Write, Execute, Delete";
    }
}
