package designpatterns.factory;

public class RegularUser implements User {
    private String username;

    public RegularUser(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPermissions() {
        return "Regular Permissions: Read, Write";
    }
}
