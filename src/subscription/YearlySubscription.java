package subscription;

public class YearlySubscription extends Subscription{
    public YearlySubscription(String planName, double price, int durationInDays) {
        super(planName, price, durationInDays);
    }

    @Override
    double calculateFinalPrice() {
        return getPrice() - (getPrice() * .1);
    }

    @Override
    public
    void getPlanDetails() {
        System.out.println(calculateFinalPrice());
        }

}

