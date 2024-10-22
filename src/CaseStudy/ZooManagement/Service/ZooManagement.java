package CaseStudy.ZooManagement.Service;

import java.util.Scanner;

public class ZooManagement {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
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
            }
        }
    }
}
