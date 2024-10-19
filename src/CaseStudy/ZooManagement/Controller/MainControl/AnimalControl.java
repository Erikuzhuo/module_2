package CaseStudy.ZooManagement.Controller.MainControl;

import CaseStudy.ZooManagement.Model.*;
import CaseStudy.ZooManagement.Pattern.PatternFormat;
import CaseStudy.ZooManagement.Support.checkDataIsExist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalControl {
    Scanner scanner = new Scanner(System.in);

    public void createAninmal() {
        List<ZooAnimal> animalList = new ArrayList<>();
        //vòng lặp xác nhận thông tin nhập trước khi đồng bộ
        do {
            System.out.println("How many new animal? ");
            int newAddNumber = Integer.parseInt(scanner.nextLine());
            while (newAddNumber < 0) { // số lượng luôn dương
                System.out.println("Please re-input number of new animal: ");
                newAddNumber = Integer.parseInt(scanner.nextLine());
            }

            ZooAnimal[] animalTempList = new ZooAnimal[newAddNumber];
            boolean check = true;
            ZooAnimal animal;
            int choiceOption;
            String firstLetter = null;

            // vòng lặp nhận thông tin cho từng đối tượng
            for (int i = 0; i < animalTempList.length; i++) {
                do {
                    System.out.println("What is the animal kind number: " +
                            "1. Elephant." +
                            "2. Monkey." +
                            "3. Owl." +
                            "4. Tiger.");
                    choiceOption = Integer.parseInt(scanner.nextLine());
                    switch (choiceOption) {
                        case 1:
                            animalTempList[i] = new Elephant();
                            firstLetter = "E";
                            break;
                        case 2:
                            animalTempList[i] = new Monkey();
                            firstLetter = "M";
                            break;
                        case 3:
                            animalTempList[i] = new Owl();
                            firstLetter = "O";
                            break;
                        case 4:
                            animalTempList[i] = new Tiger();
                            firstLetter = "T";
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            check = false;
                            break;
                    }
                } while (!check);
                String tempID;
                do {
                    System.out.println("Input ID of Animal number " + (i + 1) + ":\n" +
                            "(5 digit numbers or letters.)");
                    tempID = scanner.nextLine();
                    tempID = firstLetter + tempID;
                    if (!PatternFormat.animalID(tempID)) {
                        System.out.println("Invalid input. Kindly re-input.");
                        check = false;
                    } else if (checkDataIsExist.checkAnimalExist(animalTempList, tempID)
                            || checkDataIsExist.checkAnimalExist(animalList, tempID)) {
                        System.out.println("ID already exist. Kindly re-input.");
                        check = false;
                    }
                } while (!check);
                animalTempList[i].setID(tempID);
            }
        }
    }
}
