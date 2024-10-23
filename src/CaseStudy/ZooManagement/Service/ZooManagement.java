package CaseStudy.ZooManagement.Service;

import java.util.Scanner;

public class ZooManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Kindly choice your option number:\n" +
                        "1. Staff Management.\n" +
                        "2. Animal Management.\n" +
                        "3. Exit. ");

                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        StaffManagement.staffControl();
                        break;
                    case 2:
                        AnimalManagement.animalControl();
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("Kindly input again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Number format error. Try again.");
            }
        }
    }
}
