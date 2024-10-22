package CaseStudy.ZooManagement.Service;

import CaseStudy.ZooManagement.Controller.AnimalControl;
import CaseStudy.ZooManagement.Controller.StaffControl;
import CaseStudy.ZooManagement.Model.Class.Monkey;
import CaseStudy.ZooManagement.Model.Class.ZooAnimal;

import java.util.Scanner;

public class ZooManagement {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Kindly choice your option number: " +
                    "1. Staff Management." +
                    "2. Animal Management." +
                    "3. Exit. ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Choice your option number: " +
                            "1. Create Staff Information." +
                            "2. Update Staff Information." +
                            "3. Delete Staff Information." +
                            "4. Display Staff Data." +
                            "5. Exit.");
                    int staffOption = scanner.nextInt();
                    switch (staffOption) {
                        case 1:
                            StaffControl.createStaff();
                            break;
                        case 2:
                            StaffControl.updateAnimalList();
                            break;
                        case 3:
                            StaffControl.deleteStaff();
                            break;
                        case 4:
                            StaffControl.displayStaffList();
                            break;
                        case 5:
                            System.exit(0);
                    }
                    break;
                case 2:
                    System.out.println("Choice your option number: " +
                            "1. Create Animal Information." +
                            "2. Update Animal Information." +
                            "3. Delete Animal Information." +
                            "4. Display Animal Data." +
                            "5. Exit.");
                    int animalOption = scanner.nextInt();
                    switch (animalOption) {
                        case 1:
                            AnimalControl.createAninmal();
                            break;
                        case 2:
                            AnimalControl.updateAnimalList();
                            break;
                        case 3:
                            AnimalControl.deleteAnimal();
                            break;
                        case 4:
                            AnimalControl.displayAnimalList();
                            break;
                        case 5:
                            System.exit(0);
                            break;
                    }
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}
