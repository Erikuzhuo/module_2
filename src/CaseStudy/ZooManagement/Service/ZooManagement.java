package CaseStudy.ZooManagement.Service;

import java.util.Scanner;

public class ZooManagement {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Kindly choice your option number: " +
                    "1. Staff Management." +
                    "2. Animal Management." +
                    "3. Exist. ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Choice your option number: " +
                            "1. Create Staff Information." +
                            "2. Update Staff Information." +
                            "3. Delete Staff Information." +
                            "4. Display Staff Data." +
                            "5. Exist.");
                    break;
                case 2:
                    System.out.println("Choice your option number: " +
                            "1. Create Animal Information." +
                            "2. Update Animal Information." +
                            "3. Delete Animal Information." +
                            "4. Display Animal Data." +
                            "5. Exist.");
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}
