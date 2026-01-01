//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;
import Users.Customer;
import Users.Admin;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Customer customer = null;
        Admin admin = null;
        
        System.out.println("Smart Subscription & Payment Management System\n");

        System.out.println("==============================================");
        System.out.println("Login Form: \n");

        System.out.println("|| 1 - Admin || 2 - Customer ||");
        System.out.print("Select: ");
        int select = scan.nextInt();
        scan.nextLine();

        int id;
        String name, email, password;

        switch(select){
            case 1:
                System.out.print("ID: ");
                id = scan.nextInt();
                scan.nextLine();

                System.out.print("Name: ");
                name = scan.nextLine();

                System.out.print("Email: ");
                email = scan.nextLine();

                System.out.print("Password: ");
                password = scan.nextLine();

                customer = new Customer(id, name, email, password, true);
                break;

            case 2:
                System.out.print("ID: ");
                id = scan.nextInt();
                scan.nextLine();

                System.out.print("Name: ");
                name = scan.nextLine();

                System.out.print("Email: ");
                email = scan.nextLine();

                System.out.print("Password: ");
                password = scan.nextLine();

                admin = new Admin(id, name, email, password, true);
                break;
            default:
                System.out.println("1 or 2 only.");
                break;
        }
        scan.close();
    }
}