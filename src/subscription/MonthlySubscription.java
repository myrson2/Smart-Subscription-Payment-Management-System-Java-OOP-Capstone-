package subscription;

public class MonthlySubscription extends Subscription{
    
    public MonthlySubscription(String planName, double basePrice, int durationInDays){
        super(planName, basePrice, durationInDays);
    }

    @Override
    public double calculateFinalPrice() {
        return super.getPrice();
    }

    @Override
    public void getPlanDetails() {
        System.out.println("========== Monthly Plans ==========\n");

        System.out.println("Name: " + super.getPlanName());
        System.out.println("Duration: " + super.getDurationInDays() + " days");
        System.out.println("Price: " + calculateFinalPrice());
        System.out.println("\n");
    }
}
