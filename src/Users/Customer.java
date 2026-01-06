package Users;

import java.util.ArrayList;
import subscription.*;
import transaction.*;

public class Customer extends User{
    Subscription activSubscription;
    ArrayList<Transaction> transactionHistory = new ArrayList<>();

    public Customer(int userId, String name, String email, String password, boolean isActive){
        super(userId, name, email, password, isActive);
    }
}
