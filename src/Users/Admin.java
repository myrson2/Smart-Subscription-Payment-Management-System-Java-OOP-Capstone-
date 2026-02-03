package Users;
import manager.SubscriptionManager;
import subscription.*;

public class Admin extends User{
    private static SubscriptionManager manager = new SubscriptionManager();

    public Admin(int userId, String name, String email, String password, boolean isActive){
        super(userId, name, email, password, isActive);
    }

    public void createSubscriptionPlan(String planName, double basePrice){
        int durationInDays = 0;
        Subscription[] variants = {
            new MonthlySubscription(planName, basePrice, durationInDays),
            new YearlySubscription(planName, basePrice, durationInDays),
            new StudentDiscountSubscription(planName, basePrice, durationInDays)
        };

    for (Subscription subscription : variants) {
        manager.addPlan(subscription);
      }
    }

    public boolean updateSubscriptionPlan(String prevName, String newPlanName, double newPrice){
       return manager.updatePLan(prevName, newPlanName, newPrice);
    }

    public boolean findName(String searchName){
        return manager.findPlanName(searchName);
    }

    public void viewPlans(){
        manager.viewSubsPlans();
    }
}
