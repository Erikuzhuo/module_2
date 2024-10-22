package CaseStudy.ZooManagement.Service;

import CaseStudy.ZooManagement.Controller.AnimalControl;

import java.util.Scanner;

public class AnimalManagement {
    public static void animalControl(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choice your option number: \n" +
                "1. Create Animal Information. \n" +
                "2. Update Animal Information. \n" +
                "3. Delete Animal Information. \n" +
                "4. Display Animal Data. \n" +
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
            default:
                System.out.println("your option does not exist.");
                break;
        }
    }
}
