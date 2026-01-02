package subscription;

public class StudentDiscountSubscription extends Subscription{
    public StudentDiscountSubscription(String planName, double price, int durationInDays) {
        super(planName, price, durationInDays);
    }

    @Override
    double calculateFinalPrice() {
        return getPrice() - (getPrice() * .2);
    }

    @Override
    public
    void getPlanDetails() {
        System.out.println(calculateFinalPrice());
            }

}
