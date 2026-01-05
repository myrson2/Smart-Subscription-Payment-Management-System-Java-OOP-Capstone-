import java.util.ArrayList;
import java.util.Scanner;
import Users.Customer;
import Users.Admin;

public class Main {
    
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            Customer customer = null;
            Admin admin;
            
            System.out.println("Smart Subscription & Payment Management System\n");

            System.out.println("==============================================");
            System.out.println("Login Form: \n");

            // System User Login 
            int id;
            String name,
                email,
                password;

            do{
                System.out.print("User ID: ");
                id = scan.nextInt();
                scan.nextLine();

                System.out.print("Name: ");
                name = scan.nextLine();

                System.out.print("Email: ");
                email = scan.nextLine();

                System.out.print("Password: ");
                password = scan.nextLine();

                System.out.println("==============================================");
                System.out.println("1 - Customer || 2 - Admin");

                int choice;
                System.out.println("Enter Choice: ");
                choice = scan.nextInt();
                scan.nextLine();

                switch (choice) {
                    case 1:
                        customer = new Customer(id, name, email, password, true);
                        break;
                    case 2:
                        admin = new Admin(id, name, email, password, true);
                        
                        // Admin Dashboard 
                        int adminSelect = 0;
                        do{
                            System.out.println("==============================================");
                            System.out.println("Hello " + admin.getName() + "!. Welcome to Admin Dashboard.");
                            System.out.println("==============================================\n");

                            adminMenuDashboard();
                            
                            System.out.print("Enter your choice: ");
                            adminSelect = scan.nextInt();
                            scan.nextLine();

                            String planName;
                            double price;

                            switch (adminSelect) {
                                case 1: // Creating Subscription Plan
                                    int durationInDays = 0;

                                    System.out.print("Enter a Plan Name: ");
                                    planName = scan.nextLine();
                                    System.out.print("Enter Base Price: ");
                                    price = scan.nextDouble();
                                    scan.nextLine();

                                    admin.createSubscriptionPlan(planName, price, durationInDays);

                                    System.out.println("Subscription plans generated successfully!\n");
                                    break;
                                
                                case 2:
                                    System.out.println("Search Name: ");
                                    String searchName = scan.nextLine();

                                    admin.updateSubscriptionPlan(searchName);
                                    
                                    break;
                            
                                default:
                                    break;
                            }
                        } while (adminSelect != 0);
                        break;
                    default:
                        break;
                }
            } while (true);
        }    
    
    }

    // function for admin dashboard
    static void adminMenuDashboard(){
        System.out.println("1 - Create Subscription Plan");
        System.out.println("2 - Update Subscription Plan");
        System.out.println("3 - View All Users");
        System.out.println("0 - Log out");
    }
    // function for customer dashboard
}