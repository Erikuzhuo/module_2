package ss8.bai_tap.Hotel_Management.Controller;

import ss8.bai_tap.Hotel_Management.Model.Customer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class CustomerControl {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    Scanner sc = new Scanner(System.in);
    Customer[] listOfCustomer = new Customer[20];

    public void addCustomer() {
        System.out.println("Customer's ID: ");
        String id = sc.nextLine();
        System.out.println("Customer's Name: ");
        String name = sc.nextLine();
        System.out.println("Customer's Birthday (dd/mm/yyyy): ");
        LocalDate birthday = LocalDate.parse(sc.nextLine(), formatter);
        System.out.println("Customer's Address:");
        String address = sc.nextLine();
        Customer newCustomer = new Customer(name,birthday,id,address);
        while (isCustomerIdExist(newCustomer.getId())) {
            System.out.println("ID already exists. Kindly input new Customer's ID: ");
            newCustomer.setId(sc.nextLine());
        }
        boolean added = false;
        for (int i = 0; i < listOfCustomer.length; i++) {
            if (listOfCustomer[i] == null) {
                listOfCustomer[i] = newCustomer;
                System.out.println("Customer add on successfully");
                added = true;
                break;
            } else System.out.println("Customer add on failure");
        }
        if (!added) {
            System.out.println("Customer add-on failed. No available space.");
        }
    }

    private boolean isCustomerIdExist(String id) {
        for (Customer customer : listOfCustomer) {
            if (customer != null && Objects.equals(customer.getId(), id)) {
                return true;
            }
        }
        return false;
    }

    public void getListOfCustomer() {
        System.out.println(Arrays.toString(listOfCustomer));
    }

    public void removeCustomer() {
        System.out.println("Kindly Input Delete Customer's ID: ");
        String removeID = sc.nextLine();
        boolean result = false;
        for (Customer customer : listOfCustomer) {
            if (Objects.equals(customer.getId(), removeID)) {
                result = true;
                break;
            }
        }
        if (result) {
            System.out.println("Are you sure to delete customer id: " + removeID + " (Y/N)");
            String check = sc.nextLine();
            if (Objects.equals(check, "Y")) {
                for (int i = 0; i < listOfCustomer.length; i++) {
                    listOfCustomer[i] = listOfCustomer[i + 1];
                }
                listOfCustomer[listOfCustomer.length - 1] = null;
                System.out.println("Already delete the customer's id: " + removeID);
            }
        }
    }

    public void updateCustomer() {
        System.out.println("Kindly Input Update Customer's ID: ");
        String updateID = sc.nextLine();
        boolean check = false;
        for (Customer customer : listOfCustomer) {
            if (Objects.equals(customer.getId(), updateID)) {
                check = true;
                break;
            }
        }
        if (check) {
            for (int i = 0; i < listOfCustomer.length; i++) {
                if (Objects.equals(listOfCustomer[i].getId(), updateID)) {
                    System.out.println("Customer ID cannot update, kindly input update information below: ");
                    System.out.println("Customer's name " + listOfCustomer[i].getName() + " update to: ");
                    listOfCustomer[i].setName(sc.nextLine());
                    System.out.println("Customer's Birthday " + listOfCustomer[i].getBirthday() + " update to: ");
                    listOfCustomer[i].setBirthday(LocalDate.parse(sc.nextLine()));
                    System.out.println("Customer's Address " + listOfCustomer[i].getAddress() + " update to: ");
                    listOfCustomer[i].setAddress(sc.nextLine());
                    System.out.println("Customer's ID " + listOfCustomer[i].getId() + " already updated. " + listOfCustomer[i].toString());
                }
            }
        } else System.out.println("Customer's ID does not exist.");
    }
}
