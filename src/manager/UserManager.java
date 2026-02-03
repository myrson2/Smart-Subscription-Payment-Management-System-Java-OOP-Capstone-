package manager;
import Users.Admin;
import Users.Customer;
import Users.User;

import java.util.ArrayList;

public class UserManager {
    private static ArrayList<User> allUsers = new ArrayList<>();

    public void registerCustomer(Customer customer){
        allUsers.add(customer);
    }

    public void registerAdmin(Admin admin){
        allUsers.add(admin);
    }
    
}
