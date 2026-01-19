package Payment;

public class CreditCardPayment implements PaymentMethod{
	@Override
	public double processPayment(double amount) {
		System.out.println("Processing Credit Card payment: PHP " + amount);
		return amount;
	}

	@Override
	public void generateReceipt() {
		System.out.println("Credit Card payment successful. Receipt generated.");
	}
}
