package subscription;

public abstract class Subscription{
    private String planName;
    private double price;
    private int durationInDays;

    public Subscription(String planName, double price, int durationInDays){
        this.planName = planName;
        this.price = price;
        this.durationInDays = durationInDays;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    abstract double calculateFinalPrice();
    public abstract void getPlanDetails();

    
}