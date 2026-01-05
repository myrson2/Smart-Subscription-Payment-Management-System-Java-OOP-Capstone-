package Users;

import java.util.ArrayList;
import subscription.*;

public class Admin extends User{
    ArrayList<Subscription> allPlans = new ArrayList<>();
    public Admin(int userId, String name, String email, String password, boolean isActive){
        super(userId, name, email, password, isActive);
    }

    public void createSubscriptionPlan(String planName, double basePrice, int durationInDays){
        allPlans.add(new MonthlySubscription(planName, basePrice, 30));
        allPlans.add(new YearlySubscription(planName, basePrice, 365));
        allPlans.add(new StudentDiscountSubscription(planName, basePrice, 30));
    }

    public void updateSubscriptionPlan(String searchName){
        String newName;
        double newPrice;
        
        for(Subscription subs : allPlans){
            subs.getPlanName().equalsIgnoreCase(searchName);
            System.out.print("Enter plan name: ");
            newName = scan.nextLine();
            subs.setPlanName(searchName);
            break;
        }
    }
}
