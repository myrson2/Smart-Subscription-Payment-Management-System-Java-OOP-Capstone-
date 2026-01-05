package subscription;

public class YearlySubscription extends Subscription{
    
    public YearlySubscription(String planName, double basePrice, int durationInDays){
        super(planName, basePrice, durationInDays);
    }
    
    @Override
    double calculateFinalPrice() {
        double discount = super.getPrice() * .10;
        return super.getPrice() - discount;
    }

    @Override
    public void getPlanDetails() {
        System.out.println("========== Yearly Plans ==========\n");

        System.out.println("Name: " + super.getPlanName());
        System.out.println("Duration: " + super.getDurationInDays() + " days");
        System.out.println("Price: " + calculateFinalPrice());
        System.out.println("\n");
    }
}
