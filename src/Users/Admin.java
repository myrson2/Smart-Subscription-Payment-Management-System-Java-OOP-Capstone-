package Users;
import manager.SubscriptionManager;
import subscription.*;

public class Admin extends User{
    Subscription subs;
    SubscriptionManager manager = new SubscriptionManager();

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

//     public Subscription returnSubscriptionPlan(String planName, String subscriptionType){
//     switch(subscriptionType.toLowerCase()){
//         case "monthly":
//             for (Subscription subscription : allPlans) {
//                 if(subscription instanceof MonthlySubscription &&
//                    planName.equalsIgnoreCase(subscription.getPlanName())){
//                     return subscription;
//                 }
//             }
//             break;
//         case "yearly":
//             for (Subscription subscription : allPlans) {
//                 if(subscription instanceof YearlySubscription &&
//                    planName.equalsIgnoreCase(subscription.getPlanName())){
//                     return subscription;
//                 }
//             }
//             break;
//         case "student":
//             for (Subscription subscription : allPlans) {
//                 if(subscription instanceof StudentDiscountSubscription &&
//                    planName.equalsIgnoreCase(subscription.getPlanName())){
//                     return subscription;
//                 }
//             }
//             break;
//     }
//     return null;
// }

//     public void viewAllUsers(){

//     }

//     public void allSubscriptionPlans()
//     {
//         for (Subscription subscription : allPlans) {
//             if(subscription instanceof MonthlySubscription){
//                 subscription.getPlanDetails();
//             }
//         }

//         for (Subscription subscription : allPlans) {
//             if(subscription instanceof YearlySubscription){
//                 subscription.getPlanDetails();
//             }
//         }

//         for (Subscription subscription : allPlans) {
//             if(subscription instanceof StudentDiscountSubscription){
//                 subscription.getPlanDetails();
//             }
//         }
//     }
}
