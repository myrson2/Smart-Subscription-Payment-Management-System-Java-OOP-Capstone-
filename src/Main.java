import java.util.Scanner;

import Payment.CreditCardPayment;
import Payment.GCashPayment;
import Payment.PaymentMethod;
import manager.SubscriptionManager;
import subscription.Subscription;
import Users.*;


public class Main {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
        System.out.println("======================================================");
        System.out.println("=== Smart Subscription & Payment Management System ===");
        System.out.println("======================================================\n");

        int authentication;
        SubscriptionManager manager = new SubscriptionManager();
        do{
            loginOrLogout();
            System.out.print("> ");
            authentication = scan.nextInt();
            scan.nextLine();

            if(authentication == 1){ // login
                
                System.out.println("== Login Form ==");

                System.out.print("Name: ");
                String name = scan.nextLine();

                System.out.print("Email: ");
                String email = scan.nextLine();

                System.out.print("Password: ");
                String password = scan.nextLine();

                System.out.println("== 1-Customer == 2-Admin ==");
                System.out.print("> ");
                int choice = scan.nextInt();
                scan.nextLine();

                if(choice == 2){
                    Admin admin = new Admin(choice, name, email, password, false);
                    admin.login();

                    boolean isContinue = false;

                    do{
                        adminMenuDashboard();

                    System.out.print("> ");
                    int admin_choice = scan.nextInt();
                    scan.nextLine();

                    switch (admin_choice) {
                        case 1:
                            System.out.println("==============================================");
                            System.out.println("==        Creating a Subscription Plan      ==");
                            System.out.println("==============================================");

                            System.out.print("Enter a Plan Name: ");
                            String planName = scan.nextLine();
                            System.out.print("Enter Base Price: ");
                            double price = scan.nextDouble();
                            scan.nextLine();

                            admin.createSubscriptionPlan(planName, price);

                            System.out.println("\nNotification: Subscription plans generated successfully!\n");
                            break;
                        case 2:
                            System.out.println("==============================================");
                            System.out.println("==        Update a Subscription Plan        ==");
                            System.out.println("==============================================");

                            System.out.println("Search Name: ");
                            String searchName = scan.nextLine();

                            if(admin.findName(searchName)){ 
                                System.out.println("Update Name: ");
                                planName = scan.nextLine();
                                System.out.println("Update Price: ");
                                price = scan.nextDouble();
                                scan.nextLine();

                                admin.updateSubscriptionPlan(searchName, planName, price);

                                System.out.println("\nNotification: Subscription plans successfully updated!\n");
                            } else {
                                System.out.println("Name not found. Try Again.");
                            }
                            break;
                        case 3:
                            System.out.println("Still working....");
                            admin.viewPlans(); // testing
                            break;
                    
                        default:
                            break;
                    }

                        System.out.println("Do you want to Continue? (Y/N): ");
                        String answer = scan.nextLine();
                        
                        isContinue = answer.equalsIgnoreCase("Y");
                    }while(isContinue);
                    
                } else if (choice == 1){
                    Customer customer = new Customer(choice, name, email, password, false);
                    customer.login();

                    boolean isContinue = false;

                    do{
                        customerMenuDashboard();

                        System.out.print("> ");
                        int customer_choice = scan.nextInt();
                        scan.nextLine();

                        switch (customer_choice) {
                            case 1:
                                System.out.println("== Subscription Plans ==");
                                manager.viewSubsPlans();

                                System.out.println("Enter a Plan Name: ");
                                String planName = scan.nextLine();
                                System.out.println("Yearly, Monthly, Student");
                                String type = scan.nextLine();

                                switch () {
                                    case "Yearly":
                                        Subscription subs = manager.returnSubscription(planName);
                            
                                        break;
                                
                                    default:
                                        break;
                                }

                                modeOfPayment();
                                System.out.println("Payment Method: ");
                                String paymentMethod = scan.nextLine().toLowerCase();

                                switch (paymentMethod) {
                                    case "gcash":
                                        PaymentMethod gcashPayment = new GCashPayment();
                                        gcashPayment.processPayment(subs.getPrice());
                                        customer.subscribePlan(subs, gcashPayment);
                                        gcashPayment.generateReceipt();
                                        break;
                                    
                                    case "credit card":
                                        PaymentMethod creditCardPayment = new CreditCardPayment();
                                        creditCardPayment.processPayment(subs.getPrice());
                                        customer.subscribePlan(subs, creditCardPayment);
                                        creditCardPayment.generateReceipt();
                                        break;
                                    default:
                                        break;
                                }

                                
                                break;
                            case 2:
                                
                                break;
                            case 3:
                                customer.displayUserInfo();
                                break;
                            default:
                                break;
                        }

                        System.out.println("Do you want to Continue? (Y/N): ");
                        String answer = scan.nextLine();
                        
                        isContinue = answer.equalsIgnoreCase("Y");
                    } while (isContinue);
                } else {
                    System.out.println("1 or 2 only");
                }

            } else if (authentication == 0){

            }
        } while (authentication != 0);
        }
    }
        
    static void loginOrLogout(){
        System.out.println("======================================================");
        System.out.println("==      1 - Login         ====        0 - Logout    ==");
        System.out.println("======================================================\n");
    }

    // function for admin dashboard
    static void adminMenuDashboard(){
        System.out.println("Options: ");
        System.out.println("1 - Create Subscription Plan");
        System.out.println("2 - Update Subscription Plan");
        System.out.println("3 - View All Users");
        System.out.println("0 - Log out");
    }
    // function for customer dashboard
    static void customerMenuDashboard(){
        System.out.println("Options: ");        
        System.out.println("1. Subscribe a Plan");
        System.out.println("2. Transaction History");
        System.out.println("3. Cancel Subscription");
        System.out.println("0. Logout");
    }

    static void modeOfPayment(){
        System.out.println("Options: ");        
        System.out.println("-> Gcash");
        System.out.println("-> Credit Card");
    }
}