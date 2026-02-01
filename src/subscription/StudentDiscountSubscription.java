package subscription;

public class StudentDiscountSubscription extends Subscription{
    public StudentDiscountSubscription(String planName, double basePrice, int durationInDays){
        super(planName, basePrice, 30);
    }

    @Override
    double calculateFinalPrice() {
        double discount = super.getPrice() * .20;
        return super.getPrice() - discount;
    }

    @Override
    public void getPlanDetails() {
        System.out.println("=====================================================");
        System.out.println("==          Monthly Plans (Student Discount)       ==");
        System.out.println("=====================================================\n");

        System.out.println("Name: " + super.getPlanName());
        System.out.println("Duration: " + super.getDurationInDays() + " days");
        System.out.println("Price: " + calculateFinalPrice());
        System.out.println("\n");
    }
}
