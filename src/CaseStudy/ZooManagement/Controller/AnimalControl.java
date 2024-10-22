package CaseStudy.ZooManagement.Controller;

import CaseStudy.ZooManagement.File.AnimalFile.AnimalFile;
import CaseStudy.ZooManagement.File.StaffFile.StaffFile;
import CaseStudy.ZooManagement.Model.Class.*;
import CaseStudy.ZooManagement.Pattern.PatternFormat;
import CaseStudy.ZooManagement.Support.checkDataIsExist;

import java.time.LocalDate;
import java.util.*;

public class AnimalControl {


    public static void createAninmal() {
        Scanner scanner = new Scanner(System.in);
        List<ZooAnimal> animalList = AnimalFile.readAnimalFromFile();
        List<Admin> staffs = StaffFile.readStaffFromFile();
        ZooAnimal[] animalTempList;
        boolean continueAdding = true, check = true;
        String confirm, tempID, tempGender, tempBirthDate, tempMoveInDate, tempInCharge;
        int choiceOption;
        String firstLetter = null;
        LocalDate today = LocalDate.now();

        if (!staffs.isEmpty()) {
            //vòng lặp xác nhận thông tin nhập trước khi đồng bộ
            do {
                System.out.println("How many new animal? ");
                int newAddNumber = Integer.parseInt(scanner.nextLine());
                while (newAddNumber < 0) { // số lượng luôn dương
                    System.out.println("Please re-input number of new animal: ");
                    newAddNumber = Integer.parseInt(scanner.nextLine());
                }

                // vòng lặp nhận thông tin cho từng đối tượng
                animalTempList = new ZooAnimal[newAddNumber];
                for (int i = 0; i < animalTempList.length; i++) {
                    // Phân Loại Động Vật
                    do {
                        System.out.println("What is the animal kind number: " +
                                "1. Elephant." +
                                "2. Monkey." +
                                "3. Owl." +
                                "4. Tiger." +
                                "5. Exit.");
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
                            case 5:
                                continueAdding = false;
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                                check = false;
                                break;
                        }
                    } while (!check);

                    // exit
                    if (!continueAdding) {
                        break;
                    }

                    // input ID
                    do {
                        System.out.println("Input ID of Animal number " + (i + 1) + ":\n" +
                                "(5 digit numbers or letters.)");
                        tempID = scanner.nextLine();
                        tempID = firstLetter + tempID;
                        if (!PatternFormat.animalID(tempID)) {
                            System.out.println("Invalid input. Kindly re-input.");
                            check = false;
                        } else if (!animalList.isEmpty()) {
                            if (checkDataIsExist.checkAnimalExist(animalTempList, tempID)
                                    || checkDataIsExist.checkAnimalExist(animalList, tempID)) {
                                System.out.println("ID already exist. Kindly re-input.");
                                check = false;
                            }
                        }


                    } while (!check);
                    animalTempList[i].setID(tempID);

                    // input name
                    System.out.println("Input name of Animal number " + (i + 1) + ":");
                    animalTempList[i].setName(scanner.nextLine());

                    // input gender
                    do {
                        System.out.println("Input gender of Animal number " + (i + 1) + ": (M/F)");
                        tempGender = scanner.nextLine();
                        if (!tempGender.equals("M") && !tempGender.equals("F")) {
                            check = false;
                            System.out.println("Invalid input. Kindly re-input.");
                        }
                    } while (!check);
                    animalTempList[i].setGender(tempGender);

                    // input BD
                    do {
                        System.out.println("Input birth date of Animal number " + (i + 1) + ": (YYYY/MM/DD)");
                        tempBirthDate = scanner.nextLine();
                        if (!PatternFormat.datePattern(tempBirthDate)) {
                            System.out.println("Date format not correct. Kindly re-input.");
                            check = false;
                        }
                    } while (!check);
                    animalTempList[i].setBirthDate(LocalDate.parse(tempBirthDate));

                    // input move in date
                    do {
                        System.out.println("Input move in date of Animal number " + (i + 1) + ": (YYYY/MM/DD)");
                        tempMoveInDate = scanner.nextLine();
                        if (!PatternFormat.datePattern(tempMoveInDate)) {
                            System.out.println("Date format not correct. Kindly re-input.");
                            check = false;
                        }
                    } while (!check);
                    animalTempList[i].setMoveInDate(LocalDate.parse(tempMoveInDate));

                    // input origin
                    System.out.println("Input origin of animal number " + (i + 1) + " from:");
                    animalTempList[i].setOriginFrom(scanner.nextLine());

                    // input in-charge
                    do {
                        System.out.println("Input in-charge person: | input 0 if you want to exit.");
                        tempInCharge = scanner.nextLine();
                        if (!Objects.equals(tempInCharge, "0")) {
                            for (Admin checkStaff : staffs) {
                                if (tempInCharge.isEmpty() || !Objects.equals(checkStaff.getName(), tempInCharge)) {
                                    check = false;
                                    System.out.println("Staff member not exist. Please re-input.");
                                }
                            }
                        } else {
                            continueAdding = false;
                            break;
                        }
                    } while (!check);
                    if (!continueAdding) break;
                    animalTempList[i].setInchargeBy(tempInCharge);

                    // input note
                    System.out.println("Input note of animal number " + (i + 1) + ":");
                    animalTempList[i].setNote(today + "Created Animal; Food need to prepare: " + animalTempList[i].eatFood()
                            + ". Other note: " + scanner.nextLine() + ".");
                }
                // exit
                if (!continueAdding) break;

                // confirm
                System.out.println("Did you confirm to add on below animal list: (Y/N) \n" +
                        Arrays.toString(animalTempList));
                confirm = scanner.nextLine();

            } while (!Objects.equals(confirm, "Y") || !Objects.equals(confirm, "y"));

            // nhập dữ liệ vào file và kết thúc.
            if (!continueAdding) {
                System.out.println("Exited and Deleted all editing.");
            } else {
                animalList.addAll(Arrays.asList(animalTempList));
                AnimalFile.writeAnimalToList(animalList);
                System.out.println("Add on Successfully.");
            }
        } else System.out.println("Kindly input staff information first.");
    }

    public static void displayAnimalList() {
        List<ZooAnimal> list = AnimalFile.readAnimalFromFile();
        for(ZooAnimal animal:list){
            System.out.println(animal.toString());
        }
    }

    public static void deleteAnimal() {
        Scanner scanner = new Scanner(System.in);
        List<ZooAnimal> animalList = AnimalFile.readAnimalFromFile();
        String confirm = "", tempID;
        ZooAnimal deleteAnimal = null;

        do {
            System.out.println("Input Animal ID: ");
            tempID = scanner.nextLine();
            while (tempID.isEmpty() || !checkDataIsExist.checkAnimalExist(animalList, tempID)) {
                System.out.println("Invalid ID. Please re-input. | Or input 0 to exit.");
                tempID = scanner.nextLine();
                if (tempID.equals("0")) break;
            }
            if (tempID.equals("0")) break;

            for (ZooAnimal animal : animalList) {
                if (Objects.equals(animal.getID(), tempID)) {
                    deleteAnimal = animal;
                    break;
                }
            }
            System.out.println("Are you sure want to delete this animal: (Y/N) \n"
                    + (deleteAnimal != null ? deleteAnimal.toString() : null));
            confirm = scanner.nextLine();

        } while (!Objects.equals(confirm, "Y") || !Objects.equals(confirm, "y"));
        if (tempID.equals("0")) {
            System.out.println("Exit and cancelled delete.");
        } else {
            animalList.remove(deleteAnimal);
            AnimalFile.clearList();
            AnimalFile.writeAnimalToList(animalList);
            System.out.println("Animal deleted successfully.");
        }
    }

    public static void updateAnimalList() {
        Scanner scanner = new Scanner(System.in);
        List<ZooAnimal> animalList = AnimalFile.readAnimalFromFile();
        String confirm = "", checkID, tempBirthDate, tempGender, tempMoveIn, tempInCharge;
        int option, index = 0;
        boolean check = true, continueEditing = true;
        ZooAnimal updateAnimal = null;
        LocalDate today = LocalDate.now();

        do {
            System.out.println("Input Animal ID need update: ");
            checkID = scanner.nextLine();
            if (!animalList.isEmpty()) {
                while (checkID.isEmpty() || !checkDataIsExist.checkAnimalExist(animalList, checkID)) {
                    System.out.println("Invalid ID. Please re-input. | Or input 0 to exit.");
                    checkID = scanner.nextLine();
                    if (Objects.equals(checkID, "0")) break;
                }
                if (checkID.equals("0")) break;

                for (ZooAnimal animal : animalList) {
                    if (Objects.equals(animal.getID(), checkID)) {
                        updateAnimal = animal;
                        index = animalList.indexOf(animal);
                        break;
                    }
                }

                do {
                    System.out.println("What's information number you want to update: " +
                            "1. Name." +
                            "2. Birthday." +
                            "3. Gender." +
                            "4. Origin place." +
                            "5. Move in date." +
                            "6. In-charge person." +
                            "7. note. " +
                            "8. exit.");

                    option = Integer.parseInt(scanner.nextLine());
                    switch (option) {
                        case 1:
                            System.out.println("Input new name of " + updateAnimal.getID());
                            updateAnimal.setName(scanner.nextLine());
                            break;
                        case 2:
                            do {
                                System.out.println("Input new BD of " + updateAnimal.getID());
                                tempBirthDate = scanner.nextLine();
                                if (!PatternFormat.datePattern(tempBirthDate)) {
                                    System.out.println("Date format not correct. Kindly re-input.");
                                    check = false;
                                }
                            } while (!check);
                            updateAnimal.setBirthDate(LocalDate.parse(tempBirthDate));
                            break;
                        case 3:
                            do {
                                System.out.println("Input gender of " + updateAnimal.getID() + ": (M/F)");
                                tempGender = scanner.nextLine();
                                if (!tempGender.equals("M") && !tempGender.equals("F")) {
                                    check = false;
                                    System.out.println("Invalid input. Kindly re-input.");
                                }
                            } while (!check);
                            updateAnimal.setGender(tempGender);
                            break;
                        case 4:
                            System.out.println("Input new origin place of " + updateAnimal.getID());
                            updateAnimal.setOriginFrom(scanner.nextLine());
                            break;
                        case 5:
                            do {
                                System.out.println("Input new move in date of " + updateAnimal.getID());
                                tempMoveIn = scanner.nextLine();
                                if (!PatternFormat.datePattern(tempMoveIn)) {
                                    System.out.println("Date format not correct. Kindly re-input.");
                                    check = false;
                                }
                            } while (!check);
                            updateAnimal.setMoveInDate(LocalDate.parse(tempMoveIn));
                            break;
                        case 6:
                            List<Admin> staffs = StaffFile.readStaffFromFile();
                            if (!staffs.isEmpty()) {
                                do {
                                    System.out.println("Input in-charge person: | input 0 if you want to exit.");
                                    tempInCharge = scanner.nextLine();
                                    if (tempInCharge != "0") {
                                        if (!staffs.isEmpty()) {
                                            for (Admin checkStaff : staffs) {
                                                if (tempInCharge.isEmpty() || !Objects.equals(checkStaff.getName(), tempInCharge)) {
                                                    check = false;
                                                    System.out.println("Staff member not exist. Please re-input.");
                                                }
                                            }
                                        } else {
                                            continueEditing = false;
                                            break;
                                        }
                                    } else {
                                        continueEditing = false;
                                        break;
                                    }
                                } while (!check);
                                if (!continueEditing) break;
                                else {
                                    updateAnimal.setInchargeBy(tempInCharge);
                                    break;
                                }
                            } else {
                                System.out.println("Kindly input staff information first.");
                                break;
                            }
                        case 7:
                            System.out.println("Input note of " + updateAnimal.getID());
                            updateAnimal.setNote(updateAnimal.getNote() + today + scanner.nextLine() + ".");
                            break;
                        case 8:
                            continueEditing = false;
                            break;
                    }
                    if (!continueEditing) break;
                    else {
                        System.out.println("New update as below. Do you still want to update other information? (Y/N)\n" +
                                updateAnimal.toString());
                        confirm = scanner.nextLine();
                    }
                } while (!Objects.equals(confirm, "Y") || !Objects.equals(confirm, "y"));

                if (!continueEditing) break;
                else {
                    System.out.println("Update completed. Do you want update other animal? (Y/N)");
                    confirm = "";
                    confirm = scanner.nextLine();
                }
            } else {
                System.out.println("List is empty.");
                continueEditing = false;
                break;
            }
        } while (!Objects.equals(confirm, "Y") || !Objects.equals(confirm, "y"));
        if (!continueEditing) {
            System.out.println("Cancelled Editing.");
        } else {
            animalList.set(index, updateAnimal);
            AnimalFile.clearList();
            AnimalFile.writeAnimalToList(animalList);
            System.out.println("Update completed.");
        }

    }
}
