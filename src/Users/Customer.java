package Users;

import java.util.ArrayList;
import Payment.PaymentMethod;
import subscription.*;
import transaction.*;

public class Customer extends User{
    Transaction transaction;
    private Subscription activeSubscription;
    ArrayList<Transaction> transactionHistory = new ArrayList<>();

    public Customer(int userId, String name, String email, String password, boolean isActive){
        super(userId, name, email, password, isActive);
        this.activeSubscription = null;
    }

    public void addTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
    }

    public void viewTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("Transaction History:");
            for (Transaction t : transactionHistory) {
                System.out.println(t);
            }
        }
    }

    public void subscribePlan(Subscription plan, PaymentMethod payment){
        setActiveSubscription(plan);
        transaction = new Transaction(plan.getPrice(), payment);
        addTransaction(transaction);
        setActive(true);
    }

    public void setActiveSubscription(Subscription subscription) {
        this.activeSubscription = subscription;
    }

    public Subscription getActiveSubscription() {
        return activeSubscription;
    }
}
