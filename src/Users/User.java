package Users;
//parent class

import java.util.Random;

import manager.UserManager;

public abstract class User {
    Random random = new Random();
    UserManager userManager;

    private int userId;
    private String name;
    private String email;
    private String password;
    private boolean isActive;

    public User(int userId, String name, String email, String password, boolean isActive){
        this.userId =  random.nextInt(99999);
        this.name = name;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
        this.userManager = new UserManager();
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void displayUserInfo(){
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Status: " + isActive());
    }

    public void updateProfile(String name, String email, String password){
        setName(name);
        setEmail(email);
        setPassword(password);

        System.out.println("Update Successful.");
    }

    public void login(){
        System.out.println("Login Successfull");
    }
}
