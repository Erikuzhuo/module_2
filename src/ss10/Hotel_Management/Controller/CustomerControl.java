package ss10.Hotel_Management.Controller;
import ss10.Hotel_Management.Model.Customer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CustomerControl {
    Scanner scanner = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void createInfo(List<Customer> Customers) {
        String check;
        List<Customer> temp = new ArrayList<>();
        System.out.println("How Many New Customer: ");
        int numberCustomer = Integer.parseInt(scanner.nextLine());
        do {
            temp.clear();
            for (int i = 0; i < numberCustomer; i++) {
                Customer newCustomer = new Customer();
                System.out.println("Kindly Input Customer ID: ");
                String id = scanner.nextLine();

                while (isIDExist(Customers, id)) {
                    System.out.println("ID Duplicated. Kindly Input New Customer ID or Input 0 Back To Main: ");
                    String test = scanner.nextLine();
                    if (!Objects.equals(test, "0")) {
                        id = test;
                    } else return;
                }

                System.out.println("kindly Input Customer Name: ");
                String name = scanner.nextLine();
                System.out.println("Kindly Input Customer Birthday (dd/mm/yyyy): ");
                LocalDate birthday = LocalDate.parse(scanner.nextLine(), formatter);
                System.out.println("Kindly Input Customer Address: ");
                String address = scanner.nextLine();

                newCustomer.setId(id);
                newCustomer.setName(name);
                newCustomer.setBirthday(birthday);
                newCustomer.setAddress(address);
                temp.add(newCustomer);
            }

            System.out.println("Does Creating Information Correct? (Y/N) ");
            System.out.println(temp);
            check = scanner.nextLine();
        } while (!Objects.equals(check, "Y"));
        Customers.addAll(temp);
        System.out.println("Information Successfully Created.");
    }

    public boolean isIDExist(List<Customer> customers, String checkID) {
        boolean check = false;
        for (Customer checkCustomer : customers) {
            check = Objects.equals(checkCustomer.getId(), checkID);
        }
        return check;
    }

    public void displayInfo(List<Customer> customers) {
        System.out.println(customers);
    }

    public void removeInfo(List<Customer> customers) {
        String check;
        int index = 0;
        do {
            System.out.println("Kindly Input Customer ID That Need To Remove: ");
            String id = scanner.nextLine();
            while (!isIDExist(customers, id)) {
                System.out.println("ID not Exist, Kindly Re-Input or Input 0 Back to Main:");
                String test = scanner.nextLine();
                if (!Objects.equals(test, "0")) {
                    id = test;
                }  else return;
            }

            for (Customer checkIndex : customers) {
                if (Objects.equals(checkIndex.getId(), id)) {
                    index = customers.indexOf(checkIndex);
                }
            }
            System.out.println("Are You Want To Delete The Information Below: (Y/N)");
            System.out.println(customers.get(index));
            check = scanner.nextLine();
        } while (!Objects.equals(check, "Y"));
        customers.remove(index);
        System.out.println("Information Successfully Remove.");
    }


    public void updateInfo(List<Customer> customers) {
        String confirm;
        System.out.println("Kindly Input Customer ID That Need To Update: ");
        String updateID = scanner.nextLine();
        while (!isIDExist(customers, updateID)) {
            System.out.println("ID not Exist, Kindly Re-Input or Input 0 Back To Main:");
            String test = scanner.nextLine();
            if (!Objects.equals(test, "0")) {
                updateID = test;
            } else return;
        }
        int index = 0;
        for (Customer checkIndex : customers) {
            if (Objects.equals(checkIndex.getId(), updateID)) {
                index = customers.indexOf(checkIndex);
            }
        }
        Customer temp;
        do {
            temp = customers.get(index);
            System.out.println("Info Need to Adjust " + temp.toString());
            System.out.println("***ID CAN NOT BE ADJUST");
            System.out.println("kindly Input Customer Name: ");
            temp.setName(scanner.nextLine());
            System.out.println("Kindly Input Customer Birthday (dd/mm/yyyy): ");
            temp.setBirthday(LocalDate.parse(scanner.nextLine(), formatter));
            System.out.println("Kindly Input Customer Address: ");
            temp.setAddress(scanner.nextLine());
            System.out.println("Is The New Information Correct? (Y/N)" + temp.toString());
            confirm = scanner.nextLine();
        } while (!Objects.equals(confirm, "Y"));
        customers.get(index).setName(temp.getName());
        customers.get(index).setAddress(temp.getAddress());
        customers.get(index).setBirthday(temp.getBirthday());
        System.out.println("Information Updated.");
    }
}

