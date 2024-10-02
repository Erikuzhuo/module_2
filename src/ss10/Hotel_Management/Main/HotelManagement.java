package ss10.Hotel_Management.Main;

import ss10.Hotel_Management.Controller.CustomerControl;
import ss10.Hotel_Management.Model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelManagement {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int option;
        while (true) {
            System.out.println("Kindly Choice Your Request: \n " +
                    "1. Add Customer Information;\n" +
                    "2. Delete Customer Information; \n" +
                    "3. Update Customer Information; \n" +
                    "4. Display Customer Name List \n" +
                    "5. Close");

            System.out.println("Input your number option:");
            option = Integer.parseInt(scanner.nextLine());
            CustomerControl acting = new CustomerControl();
            switch (option) {
                case 1:
                    System.out.println();
                    acting.createInfo(customers);
                    break;
                case 2:
                    acting.removeInfo(customers);
                    break;
                case 3:
                    acting.updateInfo(customers);
                    break;
                case 4:
                    acting.displayInfo(customers);
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}