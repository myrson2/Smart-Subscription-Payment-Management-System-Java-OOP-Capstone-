package Users;

public class Customer extends User{
    public Customer(int userId, String name, String email, String password, boolean isActive){
        super(userId, name, email, password, isActive);
    }
}
