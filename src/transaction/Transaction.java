package transaction;

import java.util.Random;

import Payment.PaymentMethod;

import java.time.LocalDateTime;

public class Transaction {
    private static Random random;

    private int transactionId;
    private double amount;
    private LocalDateTime date;
    private PaymentMethod payment;

    public Transaction(double amount, PaymentMethod payment) {
    this(random.nextInt(9999), amount, LocalDateTime.now(), payment); 
}

    public Transaction(int transactionId, double amount, LocalDateTime date, PaymentMethod payment) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.date = date;
        this.payment = payment;
    }

    public int getTransactionId() { return transactionId; }
    public double getAmount() { return amount; }
    public LocalDateTime getDate() { return date; }
    public PaymentMethod getPayment() { return payment; }

}
