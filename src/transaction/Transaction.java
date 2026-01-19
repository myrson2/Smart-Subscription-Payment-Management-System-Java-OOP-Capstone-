package transaction;

import java.time.LocalDateTime;

public class Transaction {
    private int transactionId;
    private double amount;
    private LocalDateTime date;
    private String paymentType;
    private String planName;

    public Transaction(int transactionId, double amount, LocalDateTime date, String paymentType, String planName) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.date = date;
        this.paymentType = paymentType;
        this.planName = planName;
    }

    public int getTransactionId() { return transactionId; }
    public double getAmount() { return amount; }
    public LocalDateTime getDate() { return date; }
    public String getPaymentType() { return paymentType; }
    public String getPlanName() { return planName; }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionId + ", Plan: " + planName + ", Amount: " + amount + ", Payment: " + paymentType + ", Date: " + date;
    }
}
