package ss8.bai_tap.Hotel_Management.Main;

import ss8.bai_tap.Hotel_Management.Controller.CustomerControl;

import java.util.Scanner;

public class HotelManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        boolean check=false;
        do{
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
                    customer.addCustomer();
                    break;
                case 2:
                    customer.removeCustomer();
                    break;
                case 3:
                    customer.updateCustomer();
                    break;
                case 4:
                    customer.getListOfCustomer();
                    break;
                default: check = true;
            }
        }while (!check);
        System.out.close();
    }
}