package Payment;

public class GCashPayment implements PaymentMethod{
    @Override
    public double processPayment(double amount) {
        System.out.println("Processing GCash payment: PHP " + amount);
        return amount;
    }

    @Override
    public void generateReceipt() {
        System.out.println("GCash payment successful. Receipt generated.");
    }

}
