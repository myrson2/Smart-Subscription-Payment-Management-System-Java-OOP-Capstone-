import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import Users.Customer;
import Users.Admin;
import Payment.CreditCardPayment;
import Payment.GCashPayment;
import Payment.PaymentMethod;

public class Main {
    
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            Random random = new Random();

            Customer customer = null;
            Admin admin = null;
            PaymentMethod paymentMethod = null;
            
            System.out.println("==============================================");
            System.out.println("Smart Subscription & Payment Management System");
            System.out.println("==============================================");

            // System User Login 
            int id;
            String name,
                email,
                password;

            int isContinue = 0;
            do{
                System.out.println("Login Form: \n");

                id = userIdGenerator(random);
                System.out.printf("User ID: %d\n", id);
                
                System.out.print("Name: ");
                name = scan.nextLine();

                System.out.print("Email: ");
                email = scan.nextLine();
                
                if(!email.contains("@")){
                    System.out.println("Should have @");
                    break;
                }

                System.out.print("Password: ");
                password = scan.nextLine();

                if(password.length() < 8) {
                    System.out.println("Must contain up to 8 characters");
                    break;
                }
               
                System.out.println("");

                // End System User Login

                // User if Customer / Admin
                System.out.println("==============================================");
                System.out.println("1 - Customer || 2 - Admin");

                int choice; // choice if admin or customer
                System.out.print("> Select: ");
                choice = scan.nextInt();
                scan.nextLine(); // input buffer

                System.out.print("(Enter to Procede)");
                scan.nextLine();

                System.out.println(" ");
                switch (choice) {
                    case 1:
                        customer = new Customer(id, name, email, password, false);

                        System.out.println("==============================================");
                        System.out.println("Hello " + customer.getName() + "!. Welcome to Customer Dashboard.");
                        System.out.println("Status: " + customer.isActive());
                        System.out.println("==============================================\n");

                        int customerSelect = 0;
                        do{
                            customerMenuDashboard();
                            
                            System.out.print("\nSelect > ");
                            customerSelect = scan.nextInt();
                            scan.nextLine();

                            switch (customerSelect) {
                                // Displaying User Information
                                case 1: 
                                    customer.displayUserInfo();
                                    break;

                                // Updating User's Profile Information
                                case 2:
                                    System.out.print("Name: ");
                                    String upd_name = scan.nextLine();

                                    System.out.print("Email: ");
                                    String upd_email = scan.nextLine();
                                    
                                    if(!upd_email.contains("@")){
                                        System.out.println("Should have @");
                                        break;
                                    }

                                    System.out.print("Password: ");
                                    String upd_password = scan.nextLine();

                                    if(upd_password.length() < 8) {
                                        System.out.println("Must contain up to 8 characters");
                                        break;
                                    }

                                    customer.updateProfile(upd_name, upd_email, upd_password);
                                    break;
                                
                                case 3: // Subscribing to a plan
                                    listOfSubscriptionPlans(admin);
                                    
                                    System.out.print("Enter Plan > ");
                                    String plan = scan.nextLine();

                                    // use searchname function in admin to check if the plan type in customer is in object
                                    if(!admin.searchName(plan)){
                                        System.out.println("Error.");
                                    } 

                                    System.out.println("Type > ");
                                    String type = scan.nextLine();
                                    
                                    modeOfPayment();
                                    System.out.println("> ");
                                    int modeOfP = scan.nextInt();
                                    scan.nextInt();
                                    
                                    // Draft 

                                    System.out.println("Payment > ");
                                    double payment = scan.nextInt();
                                    scan.nextInt();
                                    // Payment Methods
                                    switch(modeOfP){
                                        case 1: // G-cash payment
                                            paymentMethod = new GCashPayment();
                                            paymentMethod.processPayment(payment);
                                            break;
                                        case 2: // Credit Card payment
                                            paymentMethod = new CreditCardPayment();
                                            paymentMethod.processPayment(payment);
                                            break;
                                    }

                                    break; 
                                default:
                                    break;
                            }
                        } while(customerSelect != 0);
                        
                        break;
                    case 2:
                        admin = new Admin(id, name, email, password, true);
                        
                        // Admin Dashboard 
                        int adminSelect = 0;
                        do{
                            System.out.println("==============================================");
                            System.out.println("Hello, Administrator! Welcome to Admin Dashboard.");
                            System.out.println("==============================================");

                            adminMenuDashboard();
                            
                            System.out.print("\nEnter your choice: ");
                            adminSelect = scan.nextInt();
                            scan.nextLine();

                            System.out.println(" ");

                            String planName;
                            double price;

                            switch (adminSelect) {
                                // Creating a Subscription Plan
                                case 1:
                                    System.out.println("==============================================");
                                    System.out.println("Creating a Subscription Plan");
                                    System.out.println("==============================================");

                                    int durationInDays = 0;

                                    System.out.print("Enter a Plan Name: ");
                                    planName = scan.nextLine();
                                    System.out.print("Enter Base Price: ");
                                    price = scan.nextDouble();
                                    scan.nextLine();

                                    admin.createSubscriptionPlan(planName, price, durationInDays);

                                    System.out.println("\nNotification: Subscription plans generated successfully!\n");
                                    break;
                                
                                // Updating the Plan Subscription
                                case 2:
                                    System.out.println("==============================================");
                                    System.out.println("Updating a Subscription Plan");
                                    System.out.println("==============================================");

                                    System.out.println("Search Name: ");
                                    String searchName = scan.nextLine();

                                    if(admin.searchName(searchName)){ 
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
                                    
                                // Viewing all Users
                                case 3:
                                    System.out.println("==============================================");
                                    System.out.println("View All Users: ");
                                    System.out.println("==============================================");
                                    System.out.println("\nSorry not Implemented Yet......\n");
                                    break;
                                
                                default:
                                    break;
                            }

                        } while (adminSelect != 0);
                        break;
                    default:
                        break;
                }

                // Continuing Validation 
                boolean isTrue;
                do{
                    System.out.print("Do you want to continue? (1 - Yes or 2 - No) > ");
                    isContinue = scan.nextInt();
                    scan.nextLine();

                    isTrue = isContinue > 2 || isContinue <= 0;
                    if (isTrue) {
                        System.out.println("1 and 2 only. Try Again.");
                    }
                }while(isTrue);
                
            } while (isContinue != 2);
        }    
    
    }

    // function for admin dashboard
    static void adminMenuDashboard(){
        System.out.println("Options: ");
        System.out.println("1 - Create Subscription Plan");
        System.out.println("2 - Update Subscription Plan");
        System.out.println("3 - View All Users");
        System.out.println("0 - Log out");
    }

    static int userIdGenerator(Random random){
        int num = random.nextInt(99999);
        
        return num;
    }
    // function for customer dashboard
    static void customerMenuDashboard(){
        System.out.println("Options: ");        
        System.out.println("1. View Profile");
        System.out.println("2. Update Profile");
        System.out.println("3. Subscribe a Plan");
        System.out.println("4. Transaction History");
        System.out.println("5. Cancel Subscription");
        System.out.println("0. Logout");
    }

    static void listOfSubscriptionPlans(Admin admin){
        admin.allSubscriptionPlans();
    }

    static void modeOfPayment(){
        System.out.println("Options: ");        
        System.out.println("1. Gcash");
        System.out.println("2. Credit Card");
    }
}