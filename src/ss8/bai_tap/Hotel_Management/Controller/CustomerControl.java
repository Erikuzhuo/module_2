package ss8.bai_tap.Hotel_Management.Controller;

import ss8.bai_tap.Hotel_Management.Model.Customer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

public class CustomerControl {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    Scanner sc = new Scanner(System.in);

    public void addCustomer(Customer[] customers) {
        for (int i = 0; i < customers.length; i++) {
            if(customers[i]==null) {
                System.out.println("Customer's ID: ");
                String id = sc.nextLine();
                while (isCustomerIdExist(id, customers)) {
                    System.out.println("ID already exists. Kindly input new Customer's ID: ");
                    id = sc.nextLine();
                }
                System.out.println("Customer's Name: ");
                String name = sc.nextLine();
                System.out.println("Customer's Birthday (dd/mm/yyyy): ");
                LocalDate birthday = LocalDate.parse(sc.nextLine(), formatter);
                System.out.println("Customer's Address:");
                String address = sc.nextLine();

                customers[i] = new Customer(name, birthday, id, address);
                System.out.println("Customer add on successfully");
            }else  System.out.println("Customer add-on failed. No available space.");
        }
    }

    private boolean isCustomerIdExist(String id,Customer[] customer) {
        for (Customer check : customer) {
            if (check != null && Objects.equals(check.getId(), id)) {
                return true;
            }
        }
        return false;
    }

    public void getListOfCustomer(Customer[] customers) {
        for (Customer customer : customers) {
            if (customer != null) {
                System.out.println(customer.toString());
            }
        }
        ;
    }

    public void removeCustomer(Customer[] customers) {
        System.out.println("Kindly Input Delete Customer's ID: ");
        String removeID = sc.nextLine();
        boolean result = false;
        for (Customer customer : customers) {
            if (Objects.equals(customer.getId(), removeID)) {
                result = true;
                break;
            }
        }
        if (result) {
            System.out.println("Are you sure to delete customer id: " + removeID + " (Y/N)");
            String check = sc.nextLine();
            if (Objects.equals(check, "Y")) {
                for (int i = 0; i < customers.length; i++) {
                    customers[i] = customers[i + 1];
                }
                customers[customers.length - 1] = null;
                System.out.println("Already delete the customer's id: " + removeID);
            }
        }
    }

    public void updateCustomer(Customer[] customers) {
        System.out.println("Kindly Input Update Customer's ID: ");
        String updateID = sc.nextLine();
        boolean check = false;
        for (Customer customer : customers) {
            if (Objects.equals(customer.getId(), updateID)) {
                check = true;
                break;
            }
        }
        if (check) {
            for (int i = 0; i < customers.length; i++) {
                if (Objects.equals(customers[i].getId(), updateID)) {
                    System.out.println("Customer ID cannot update, kindly input update information below: ");
                    System.out.println("Customer's name " + customers[i].getName() + " update to: ");
                    customers[i].setName(sc.nextLine());
                    System.out.println("Customer's Birthday " + customers[i].getBirthday() + " update to: ");
                    customers[i].setBirthday(LocalDate.parse(sc.nextLine(),formatter));
                    System.out.println("Customer's Address " + customers[i].getAddress() + " update to: ");
                    customers[i].setAddress(sc.nextLine());
                    System.out.println("Customer's ID " + customers[i].getId() + " already updated. " + customers[i].toString());
                }
            }
        } else System.out.println("Customer's ID does not exist.");
    }
}
