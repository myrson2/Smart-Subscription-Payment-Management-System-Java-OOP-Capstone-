package Users;

import java.util.ArrayList;
import subscription.*;

public class Admin extends User{
    public ArrayList<Subscription> allPlans = new ArrayList<>();
    public Admin(int userId, String name, String email, String password, boolean isActive){
        super(userId, name, email, password, isActive);
    }

    public void createSubscriptionPlan(String planName, double basePrice, int durationInDays){
        allPlans.add(new MonthlySubscription(planName, basePrice, 30));
        allPlans.add(new YearlySubscription(planName, basePrice, 365));
        allPlans.add(new StudentDiscountSubscription(planName, basePrice, 30));
    }

    public void updateSubscriptionPlan(String searchName, String newPlanName, double newPrice){
       for(Subscription subs : allPlans){
            if (subs.getPlanName().equalsIgnoreCase(searchName)) {
                subs.setPlanName(newPlanName);
                subs.setPrice(newPrice);
                break;
            }
        }
    }

    public boolean searchName(String searchName){
        boolean isfound = false;
        for(Subscription subs : allPlans){
            if (subs.getPlanName().equalsIgnoreCase(searchName)) {
                isfound = true;
                break;
            }
        }

        return isfound;
    }

    public void viewAllUsers(){

    }

    public void allSubscriptionPlans()
    {
        for (Subscription subscription : allPlans) {
            if(subscription instanceof MonthlySubscription){
                subscription.getPlanDetails();
            }
        }

        for (Subscription subscription : allPlans) {
            if(subscription instanceof YearlySubscription){
                subscription.getPlanDetails();
            }
        }

        for (Subscription subscription : allPlans) {
            if(subscription instanceof StudentDiscountSubscription){
                subscription.getPlanDetails();
            }
        }
    }
}
