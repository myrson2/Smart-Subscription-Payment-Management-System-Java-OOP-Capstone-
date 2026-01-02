//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.ArrayList;
import java.util.Scanner;

import Users.Customer;
import Users.Admin;
import subscription.MonthlySubscription;
import subscription.StudentDiscountSubscription;
import subscription.Subscription;
import subscription.YearlySubscription;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Customer customer = null;
        Admin admin = null;

        ArrayList<Subscription> monthly = new ArrayList<>();
        ArrayList<Subscription> yearly = new ArrayList<>();
        ArrayList<Subscription> studentDiscount = new ArrayList<>();
        
        System.out.println("Smart Subscription & Payment Management System\n");

        System.out.println("==============================================");
        System.out.println("Login Form: \n");

        System.out.println("|| 1 - Customer || 2 - Admin ||");
        System.out.print("Select: ");
        int select = scan.nextInt();
        scan.nextLine();

        UserInput input;
        
        switch (select) {
            case 1:
                input = getUserInput(scan);
                customer = new Customer(
                        input.getId(),
                        input.getName(),
                        input.getEmail(),
                        input.getPassword(),
                        true
                );
                System.out.println(customer.getName() + " created successfully.");
                break;

                // Admin tasks =====================================================================================
            case 2:

                input = getUserInput(scan);
                admin = new Admin(
                        input.getId(),
                        input.getName(),
                        input.getEmail(),
                        input.getPassword(),
                        true
                );
                System.out.println(admin.getName() + " created successfully.");

                // Admin task 
                System.out.println("=================================================");
                System.out.println("Admin Server\n");
                System.out.println("Hello " + input.getName() + ".");

                int choice;
                String planName;
                double price;
                Subscription plans;
                do{
                    // menu
                    System.out.println("Menu: ");
                    System.out.println("1. Create Subscription Plan");
                    System.out.println("2. Update Subscription Plan");
                    System.out.println("3. View All User");
                    System.out.println("4. Exit");

                    System.out.println("Enter choice: ");
                    choice = scan.nextInt();
                    scan.nextLine();

                    switch (choice) {
                        case 1: // create subscription plan
                            System.out.println("PLan Name: ");
                            planName = scan.nextLine();

                            System.out.println("Price: ");
                            price = scan.nextDouble();

                            monthly.add(new MonthlySubscription(planName, price, 30));
                            yearly.add(new YearlySubscription(planName, price, 365));
                            studentDiscount.add(new StudentDiscountSubscription(planName, price, 30));

                            break;
                    case 2: // Updating the subscription plan
                            
                        default:
                            break;
                    }
                } while(choice != 4);
                break;

            default:
                System.out.println("1 or 2 only.");
                break;

            }
        scan.close();
    }

     public static UserInput getUserInput(Scanner scan) {
        System.out.print("ID: ");
        int id = scan.nextInt();
        scan.nextLine(); // consume newline

        System.out.print("Name: ");
        String name = scan.nextLine();

        System.out.print("Email: ");
        String email = scan.nextLine();

        System.out.print("Password: ");
        String password = scan.nextLine();

        return new UserInput(id, name, email, password);
    }
}