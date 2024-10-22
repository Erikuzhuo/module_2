package CaseStudy.ZooManagement.Controller;

import CaseStudy.ZooManagement.File.StaffFile.StaffFile;
import CaseStudy.ZooManagement.Model.Class.*;
import CaseStudy.ZooManagement.Pattern.PatternFormat;
import CaseStudy.ZooManagement.Support.checkDataIsExist;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class StaffControl {


    public static void createStaff() {
        Scanner scanner = new Scanner(System.in);
        List<Admin> staffList = StaffFile.readStaffFromFile();
        Admin[] staffTempList;
        boolean continueAdding = true, check = true;
        String confirm, tempID, tempGender, tempBirthDate, tempNumber, tempEmail, tempHireDate;
        String firstLetter = null;
        LocalDate today = LocalDate.now();

        //vòng lặp xác nhận thông tin nhập trước khi đồng bộ
        do {
            System.out.println("How many new staff? ");
            int newAddNumber = Integer.parseInt(scanner.nextLine());
            while (newAddNumber < 0) { // số lượng luôn dương
                System.out.println("Please re-input number of new staff: ");
                newAddNumber = Integer.parseInt(scanner.nextLine());
            }

            // vòng lặp nhận thông tin cho từng đối tượng
            staffTempList = new Admin[newAddNumber];
            for (int i = 0; i < staffTempList.length; i++) {
                // input ID
                do {
                    System.out.println("Input ID of Staff number " + (i + 1) + ":\n" +
                            "(letter Z + 5 digit numbers or letters.)");
                    tempID = scanner.nextLine();
                    if (!PatternFormat.staffID(tempID)) {
                        System.out.println("Invalid input. Kindly re-input.");
                        check = false;
                    } else if (!staffList.isEmpty()) {
                        if (checkDataIsExist.checkStaffExist(staffTempList, tempID)
                                || checkDataIsExist.checkStaffExist(staffList, tempID)) {
                            System.out.println("ID already exist. Kindly re-input.");
                            check = false;
                        }
                    }
                } while (!check);
                staffTempList[i].setID(tempID);

                // input name
                System.out.println("Input name of staff number " + (i + 1) + ":");
                staffTempList[i].setName(scanner.nextLine());

                // input gender
                do {
                    System.out.println("Input gender of staff number " + (i + 1) + ": (M/F)");
                    tempGender = scanner.nextLine();
                    if (!tempGender.equals("M") && !tempGender.equals("F")) {
                        check = false;
                        System.out.println("Invalid input. Kindly re-input.");
                    }
                } while (!check);
                staffTempList[i].setGender(tempGender);

                // input BD
                do {
                    System.out.println("Input birth date of staff number " + (i + 1) + ": (YYYY/MM/DD)");
                    tempBirthDate = scanner.nextLine();
                    if (!PatternFormat.datePattern(tempBirthDate)) {
                        System.out.println("Date format not correct. Kindly re-input.");
                        check = false;
                    }
                } while (!check);
                staffTempList[i].setBirthDate(LocalDate.parse(tempBirthDate));

                // input address
                System.out.println("Input address of staff number " + (i + 1) + ":");
                staffTempList[i].setAddress(scanner.nextLine());

                // input hire date
                do {
                    System.out.println("Input hire date of staff number " + (i + 1) + ": (YYYY/MM/DD)");
                    tempHireDate = scanner.nextLine();
                    if (!PatternFormat.datePattern(tempHireDate)) {
                        System.out.println("Date format not correct. Kindly re-input.");
                        check = false;
                    }
                } while (!check);
                staffTempList[i].setHireDate(LocalDate.parse(tempHireDate));

                // input position
                System.out.println("Input position of staff number " + (i + 1) + ":");
                staffTempList[i].setPosition(scanner.nextLine());

                // input phone number
                do {
                    System.out.println("Input phone number of staff number " + (i + 1) + ":");
                    tempNumber = scanner.nextLine();
                    if (!PatternFormat.phoneNumber(tempNumber)) {
                        System.out.println("Number format not correct. Kindly re-input.");
                        check = false;
                    }
                } while (!check);
                staffTempList[i].setPhoneNumber(tempNumber);

                // input email
                do {
                    System.out.println("Input email of staff number " + (i + 1) + ":");
                    tempEmail = scanner.nextLine();
                    if (!PatternFormat.staffEmail(tempEmail)) {
                        System.out.println("Email format not correct. Kindly re-input.");
                        check = false;
                    }
                } while (!check);
                staffTempList[i].setEmail(tempEmail);

                // input salary
                System.out.println("Input salary of staff number " + (i + 1) + ":");
                staffTempList[i].setSalary(Double.parseDouble(scanner.nextLine()));

                // input note
                System.out.println("Input note of staff number " + (i + 1) + ":");
                staffTempList[i].setNote(today + "Created Animal," + scanner.nextLine() + ".");
            }
            // exit
            if (!continueAdding) break;

            // confirm
            System.out.println("Did you confirm to add on below staff list: (Y/N) \n" +
                    Arrays.toString(staffTempList));
            confirm = scanner.nextLine();

        } while (!Objects.equals(confirm, "Y") || !Objects.equals(confirm, "y"));

        // nhập dữ liệ vào file và kết thúc.
        if (!continueAdding) {
            System.out.println("Exited and Deleted all editing.");
        } else {
            staffList.addAll(Arrays.asList(staffTempList));
            StaffFile.writeStaffToFile(staffList);
            System.out.println("Add on Successfully.");
        }
    }

    public static void displayStaffList() {
        List<Admin> list = StaffFile.readStaffFromFile();
        for(Admin staff:list){
            System.out.println(staff.toString());
        }
    }

    public static void deleteStaff() {
        Scanner scanner = new Scanner(System.in);
        List<Admin> staffList = StaffFile.readStaffFromFile();
        String confirm, tempID;
        Admin deleteStaff = null;

        do {
            System.out.println("Input staff ID: ");
            tempID = scanner.nextLine();
            while (tempID.isEmpty() || !checkDataIsExist.checkStaffExist(staffList, tempID)) {
                System.out.println("Invalid ID. Please re-input. | Or input 0 to exit.");
                tempID = scanner.nextLine();
                if (tempID.equals("0")) break;
            }
            if (tempID.equals("0")) break;

            for (Admin Staff : staffList) {
                if (Objects.equals(Staff.getID(), tempID)) {
                    deleteStaff = Staff;
                    break;
                }
            }
            System.out.println("Are you sure want to delete this staff: (Y/N) \n"
                    + (deleteStaff != null ? deleteStaff.toString() : null));
            confirm = scanner.nextLine();

        } while (!Objects.equals(confirm, "Y") || !Objects.equals(confirm, "y"));
        if (tempID.equals("0")) {
            System.out.println("Exit and cancelled delete.");
        } else {
            staffList.remove(deleteStaff);
            StaffFile.clearList();
            StaffFile.writeStaffToFile(staffList);
            System.out.println("Staff deleted successfully.");
        }
    }

    public static void updateStaffList() {
        Scanner scanner = new Scanner(System.in);
        List<Admin> staffList = StaffFile.readStaffFromFile();
        String confirm, checkID, tempBirthDate, tempGender, tempEmail, tempNumber;
        int option, index = 0;
        boolean check = true, continueEditing = true;
        Admin updateStaff = null;
        LocalDate today = LocalDate.now();

        do {
            if (!staffList.isEmpty()) {
                System.out.println("Input staff ID need update: ");
                checkID = scanner.nextLine();
                while (checkID.isEmpty() || !checkDataIsExist.checkStaffExist(staffList, checkID)) {
                    System.out.println("Invalid ID. Please re-input. | Or input 0 to exit.");
                    checkID = scanner.nextLine();
                    if (Objects.equals(checkID, "0")) break;
                }
                if (checkID.equals("0")) break;

                for (Admin staff : staffList) {
                    if (Objects.equals(staff.getID(), checkID)) {
                        updateStaff = staff;
                        index = staffList.indexOf(staff);
                        break;
                    }
                }

                do {
                    System.out.println("What's information number you want to update: \n" +
                            "1. Name.\n" +
                            "2. Birthday.\n" +
                            "3. Gender.\n" +
                            "4. address.\n" +
                            "5. Position.\n" +
                            "6. Hire Date.\n" +
                            "7. Salary.\n" +
                            "8. Phone Number.\n" +
                            "9. Email.\n " +
                            "10. note.\n " +
                            "11. exit.");

                    option = Integer.parseInt(scanner.nextLine());
                    switch (option) {
                        case 1:
                            System.out.println("Input new name of " + updateStaff.getID());
                            updateStaff.setName(scanner.nextLine());
                            break;
                        case 2:
                            do {
                                System.out.println("Input new BD of " + updateStaff.getID());
                                tempBirthDate = scanner.nextLine();
                                if (!PatternFormat.datePattern(tempBirthDate)) {
                                    System.out.println("Date format not correct. Kindly re-input.");
                                    check = false;
                                }
                            } while (!check);
                            updateStaff.setBirthDate(LocalDate.parse(tempBirthDate));
                            break;
                        case 3:
                            do {
                                System.out.println("Input gender of " + updateStaff.getID() + ": (M/F)");
                                tempGender = scanner.nextLine();
                                if (!tempGender.equals("M") && !tempGender.equals("F")) {
                                    check = false;
                                    System.out.println("Invalid input. Kindly re-input.");
                                }
                            } while (!check);
                            updateStaff.setGender(tempGender);
                            break;
                        case 4:
                            System.out.println("Input new address of " + updateStaff.getID());
                            updateStaff.setAddress(scanner.nextLine());
                            break;
                        case 5:
                            System.out.println("Input new position of " + updateStaff.getID());
                            updateStaff.setPosition(scanner.nextLine());
                            break;
                        case 6:
                            do {
                                System.out.println("Input new hire date of " + updateStaff.getID());
                                tempEmail = scanner.nextLine();
                                if (!PatternFormat.datePattern(tempEmail)) {
                                    System.out.println("Date format not correct. Kindly re-input.");
                                    check = false;
                                }
                            } while (!check);
                            updateStaff.setHireDate(LocalDate.parse(tempEmail));
                            break;
                        case 7:
                            System.out.println("Input new salary of " + updateStaff.getID());
                            updateStaff.setSalary(Double.parseDouble(scanner.nextLine()));
                            break;
                        case 8:
                            do {
                                System.out.println("Input new phone number of " + updateStaff.getID());
                                tempNumber = scanner.nextLine();
                                if (!PatternFormat.phoneNumber(tempNumber)) {
                                    System.out.println("Number format not correct. Kindly re-input.");
                                    check = false;
                                }
                            } while (!check);
                            updateStaff.setPhoneNumber(tempNumber);
                            break;
                        case 9:
                            do {
                                System.out.println("Input new email of " + updateStaff.getID());
                                tempEmail = scanner.nextLine();
                                if (!PatternFormat.staffEmail(tempEmail)) {
                                    System.out.println("Email format not correct. Kindly re-input.");
                                    check = false;
                                }
                            } while (!check);
                            updateStaff.setEmail(tempEmail);
                            break;
                        case 10:
                            System.out.println("Input note of " + updateStaff.getID());
                            updateStaff.setNote(updateStaff.getNote() + today + scanner.nextLine() + ".");
                            break;
                        case 11:
                            continueEditing = false;
                            break;

                    }
                    if (!continueEditing) break;
                    else {
                        System.out.println("New update as below. Do you still want to update other information? (Y/N)\n" +
                                updateStaff.toString());
                        confirm = scanner.nextLine();
                    }
                } while (!Objects.equals(confirm, "Y") || !Objects.equals(confirm, "y"));

                if (!continueEditing) break;
                else {
                    System.out.println("Update completed. Do you want update other staff? (Y/N)");
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
            staffList.set(index, updateStaff);
            StaffFile.clearList();
            StaffFile.writeStaffToFile(staffList);
            System.out.println("Update completed.");
        }
    }
}
