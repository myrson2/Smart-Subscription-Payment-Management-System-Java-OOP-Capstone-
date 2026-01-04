import java.util.Scanner;
import Users.Customer;
import Users.Admin;

public class Main {
    
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            Customer customer = null;
            Admin admin = null;
            
            System.out.println("Smart Subscription & Payment Management System\n");

            System.out.println("==============================================");
            System.out.println("Login Form: \n");

            // System User Login 
            int id;
            String name,
                email,
                password;

            do{
                System.out.println("User ID: ");
                id = scan.nextInt();
                scan.nextLine();

                System.out.println("Name: ");
                name = scan.nextLine();

                System.out.println("Email: ");
                email = scan.nextLine();

                System.out.println("Password: ");
                password = scan.nextLine();

                System.out.println("==============================================");
                System.out.println("1 - Customer || 2 - Admin");

                int choice = 0;
                System.out.println("Enter Choice: ");
                choice = scan.nextInt();
                scan.nextLine();

                switch (choice) {
                    case 1:
                        customer = new Customer(id, name, email, password, true);
                        break;
                    case 2:
                        admin = new Admin(id, name, email, password, true);                        break;
                    default:
                        break;
                }
            } while (true);
        }    
    
    }

    // function for admin dashboard
    // function for customer dashboard
}