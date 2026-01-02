package Users;

import subscription.Subscription;

public class Admin extends User{
    Subscription activeSubscription;
    public Admin(int userId, String name, String email, String password, boolean isActive){
        super(userId, name, email, password, isActive);
    }

    /*
    Additional Methods:

        createSubscriptionPlan()
        updateSubscriptionPlan()
        viewAllUsers() 
        
        */
}
