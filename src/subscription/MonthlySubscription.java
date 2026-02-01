package subscription;

public class MonthlySubscription extends Subscription{
    
    public MonthlySubscription(String planName, double basePrice, int durationInDays){
        super(planName, basePrice, 30);
    }

    @Override
    public double calculateFinalPrice() {
        return super.getPrice();
    }

    @Override
    public void getPlanDetails() {
        System.out.println("=====================================================");
        System.out.println("==                   Monthly Plans                 ==");
        System.out.println("=====================================================\n");

        System.out.println("Name: " + super.getPlanName());
        System.out.println("Duration: " + super.getDurationInDays() + " days");
        System.out.println("Price: " + calculateFinalPrice());
        System.out.println("\n");
    }
}
