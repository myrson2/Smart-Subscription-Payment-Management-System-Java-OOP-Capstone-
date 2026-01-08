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

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String isActive() {
        if(isActive == false){
            return "No plans";
        } 

        return "Active";
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
}
