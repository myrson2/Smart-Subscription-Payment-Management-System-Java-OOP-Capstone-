package Users;
//parent class
public class User {
    private int userId;
    private String name;
    private String email;
    private String password;
    private boolean isActive;

    User(int userId, String name, String email, String password, boolean isActive){
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    public boolean isActive() {
        return isActive;
    }

    /*
    Methods:

        login()
        logout()
        updateProfile()
        displayUserInfo() 
        
        */
}
