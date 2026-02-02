package manager;

import java.util.ArrayList;
import subscription.*;

public class SubscriptionManager {
    private static ArrayList<Subscription> plans = new ArrayList<>();

    public void addPlan(Subscription s){
        plans.add(s);
    }

    public boolean findPlanName(String name){
        boolean indicator = false;
        
        if(plans.isEmpty()){
            return indicator;
        } else {
            for (Subscription subscription : plans) {
                if(subscription.getPlanName().equalsIgnoreCase(name)){
                    indicator = true;
                    break;
                }
            }
        }

         if(indicator){
            return indicator; // true
        }

        return indicator; // false
    }

    public boolean updatePLan(String name, String newName, double price){
        for (Subscription subscription : plans) {
            if(subscription.getPlanName().equalsIgnoreCase(name)){
                subscription.setPlanName(newName);
                subscription.setPrice(price);
            } else {
                return false;
            }
        }
        return true;
    }

    public void viewSubsPlans(){
         for (Subscription subscription : plans) {
            if(subscription instanceof MonthlySubscription){
                subscription.getPlanDetails();
            }
        }

        for (Subscription subscription : plans) {
            if(subscription instanceof YearlySubscription){
                subscription.getPlanDetails();
            }
        }

        for (Subscription subscription : plans) {
            if(subscription instanceof StudentDiscountSubscription){
                subscription.getPlanDetails();
            }
        }
    }
}
