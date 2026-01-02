package subscription;

public abstract class Subscription{
    private String planName;
    protected double price;
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

    public int getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(int durationInDays) {
        this.durationInDays = durationInDays;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    abstract double calculateFinalPrice();
    abstract public void getPlanDetails();

    public boolean isActive(){
        return true;
    }
} 