package subscription;

public class MonthlySubscription extends Subscription{

    public MonthlySubscription(String planName, double price, int durationInDays) {
        super(planName, price, durationInDays);
    }

    @Override
    double calculateFinalPrice() {
        return getPrice();
    }

    @Override
    public
    void getPlanDetails() {
System.out.println(calculateFinalPrice());        
    }
}

