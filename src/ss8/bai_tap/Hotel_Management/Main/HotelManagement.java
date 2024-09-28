package ss8.bai_tap.Hotel_Management.Main;

import ss8.bai_tap.Hotel_Management.Controller.CustomerControl;
import ss8.bai_tap.Hotel_Management.Model.Customer;

import java.util.Scanner;

public class HotelManagement {
    public static void main(String[] args) {
        Customer[] listOfCustomer = new Customer[5];
        Scanner scanner = new Scanner(System.in);
        int option;
        while(true){
        System.out.println("Kindly Choice Your Request: \n " +
                    "1. Add Customer Information;\n" +
                    "2. Delete Customer Information; \n" +
                    "3. Update Customer Information; \n" +
                    "4. Display Customer Name List \n" +
                    "5. Close");

            System.out.println("Input your number option:");
            option = Integer.parseInt(scanner.nextLine());
            CustomerControl customer = new CustomerControl();
            switch (option) {
                case 1:
                    System.out.println();
                    customer.addCustomer(listOfCustomer);
                    break;
                case 2:
                    customer.removeCustomer(listOfCustomer);
                    break;
                case 3:
                    customer.updateCustomer(listOfCustomer);
                    break;
                case 4:
                    customer.getListOfCustomer(listOfCustomer);
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}