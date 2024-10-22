package CaseStudy.ZooManagement.Controller;

import CaseStudy.ZooManagement.File.StaffFile.StaffFile;
import CaseStudy.ZooManagement.Model.Class.*;
import CaseStudy.ZooManagement.Pattern.PatternFormat;
import CaseStudy.ZooManagement.Support.checkDataIsExist;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class StaffControl {


    public static void createStaff() {
        Scanner scanner = new Scanner(System.in);
        List<ZooStaff> staffList = StaffFile.readStaffFromFile();
        ZooStaff[] staffTempList;
        boolean continueAdding = true, check = true;
        String confirm, tempID, tempGender, tempBirthDate, tempNumber, tempEmail, tempHireDate;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate today = LocalDate.now(), minBirthDate = LocalDate.of(1940, 1, 1),
                minHireDate = LocalDate.of(2010, 1, 1);

        //vòng lặp xác nhận thông tin nhập trước khi đồng bộ
        do {
            System.out.println("How many new staff? ");
            int newAddNumber = Integer.parseInt(scanner.nextLine());
            while (newAddNumber < 0) { // số lượng luôn dương
                System.out.println("Please re-input number of new staff: ");
                newAddNumber = Integer.parseInt(scanner.nextLine());
            }

            // vòng lặp nhận thông tin cho từng đối tượng
            staffTempList = new ZooStaff[newAddNumber];
            for (int i = 0; i < staffTempList.length; i++) {
                // input ID
                ZooStaff zooStaff = new ZooStaff();
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
                    } else check = true;
                } while (!check);
                zooStaff.setID(tempID);

                // input name
                System.out.println("Input name of staff number " + (i + 1) + ":");
                zooStaff.setName(scanner.nextLine());

                // input gender
                do {
                    System.out.println("Input gender of staff number " + (i + 1) + ": (M/F)");
                    tempGender = scanner.nextLine();
                    if (!tempGender.equals("M") && !tempGender.equals("F")) {
                        check = false;
                        System.out.println("Invalid input. Kindly re-input.");
                    } else check = true;
                } while (!check);
                zooStaff.setGender(tempGender);

                // input BD
                do {
                    System.out.println("Input birth date of staff number " + (i + 1) + ": (yyyy/MM/dd)");
                    tempBirthDate = scanner.nextLine();
                    try {
                        LocalDate parsedDate = LocalDate.parse(tempBirthDate, dateTimeFormatter);

                        if (parsedDate.isBefore(minBirthDate)) {
                            System.out.println("Date is too early. Only after 1940.");
                            check = false;
                        } else if (parsedDate.isAfter(today)) {
                            System.out.println("Date cannot be later than today.");
                            check = false;
                        } else if (today.getYear() - parsedDate.getYear() < 18) {
                            System.out.println("Staff must be at least 18 years old.");
                            check = false;
                        } else {
                            check = true;
                        }
                    } catch (DateTimeParseException e) {
                        System.out.println("Date format not correct. Kindly re-input.");
                        check = false;
                    }
                } while (!check);
                zooStaff.setBirthDate(LocalDate.parse(tempBirthDate, dateTimeFormatter));

                // input address
                System.out.println("Input address of staff number " + (i + 1) + ":");
                zooStaff.setAddress(scanner.nextLine());

                // input hire date
                do {
                    System.out.println("Input hire date of staff number " + (i + 1) + ": (YYYY/MM/DD)");
                    tempHireDate = scanner.nextLine();
                    try {
                        LocalDate parsedDate = LocalDate.parse(tempHireDate, dateTimeFormatter);

                        if (parsedDate.isBefore(minHireDate)) {
                            System.out.println("Date is too early. Only after 2010.");
                            check = false;
                        } else if (parsedDate.isAfter(today)) {
                            System.out.println("Date cannot be later than today.");
                            check = false;
                        } else {
                            check = true;
                        }
                    } catch (DateTimeParseException e) {
                        System.out.println("Date format not correct. Kindly re-input.");
                        check = false;
                    }
                } while (!check);
                zooStaff.setHireDate(LocalDate.parse(tempHireDate, dateTimeFormatter));

                // input position
                System.out.println("Input position of staff number " + (i + 1) + ":");
                zooStaff.setPosition(scanner.nextLine());

                // input phone number
                do {
                    System.out.println("Input phone number of staff number " + (i + 1) + ":");
                    tempNumber = scanner.nextLine();
                    if (!PatternFormat.phoneNumber(tempNumber)) {
                        System.out.println("Number format not correct. Kindly re-input.");
                        check = false;
                    } else check = true;
                } while (!check);
                zooStaff.setPhoneNumber(tempNumber);

                // input email
                do {
                    System.out.println("Input email of staff number " + (i + 1) + ":");
                    tempEmail = scanner.nextLine();
                    if (!PatternFormat.staffEmail(tempEmail)) {
                        System.out.println("Email format not correct. Kindly re-input.");
                        check = false;
                    } else check = true;
                } while (!check);
                zooStaff.setEmail(tempEmail);

                // input salary
                do {
                    System.out.println("Input salary of staff number " + (i + 1) + ":");

                    try {
                        zooStaff.setSalary(Double.parseDouble(scanner.nextLine()));
                        check = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Number format not correct. pls try again.");
                        check = false;
                    }
                } while (!check);

                // input note
                System.out.println("Input note of staff number " + (i + 1) + ":");
                zooStaff.setNote(today + "Created staff," + scanner.nextLine() + ".");

                staffTempList[i] = zooStaff;
            }
            // exit
            if (!continueAdding) break;

            // confirm
            System.out.println("Did you confirm to add on below staff list: (Y/N) \n" +
                    Arrays.toString(staffTempList));
            confirm = scanner.nextLine();

        } while (!confirm.equalsIgnoreCase("Y"));

        // nhập dữ liệu vào file và kết thúc.
        if (!continueAdding) {
            System.out.println("Exited and Deleted all editing.");
        } else {
            staffList.addAll(Arrays.asList(staffTempList));
            StaffFile.writeStaffToFile(staffList);
            System.out.println("Add on Successfully.");
        }
    }

    public static void displayStaffList() {
        List<ZooStaff> list = StaffFile.readStaffFromFile();
        for (ZooStaff staff : list) {
            System.out.println(staff.toString());
        }
    }

    public static void deleteStaff() {
        Scanner scanner = new Scanner(System.in);
        List<ZooStaff> staffList = StaffFile.readStaffFromFile();
        String confirm, tempID;
        ZooStaff deleteStaff = null;

        do {
            System.out.println("Input staff ID: ");
            tempID = scanner.nextLine();
            while (tempID.isEmpty() || !checkDataIsExist.checkStaffExist(staffList, tempID)) {
                System.out.println("Invalid ID. Please re-input. | Or input 0 to exit.");
                tempID = scanner.nextLine();
                if (tempID.equals("0")) break;
            }
            if (tempID.equals("0")) break;

            for (ZooStaff Staff : staffList) {
                if (Objects.equals(Staff.getID(), tempID)) {
                    deleteStaff = Staff;
                    break;
                }
            }
            System.out.println("Are you sure want to delete this staff: (Y/N) \n"
                    + (deleteStaff != null ? deleteStaff.toString() : null));
            confirm = scanner.nextLine();

        } while (!confirm.equalsIgnoreCase("Y"));
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
        List<ZooStaff> staffList = StaffFile.readStaffFromFile();
        String confirm, checkID, tempBirthDate, tempGender, tempEmail, tempNumber, tempHireDate;
        int option, index = 0;
        boolean check = true, continueEditing = true;
        ZooStaff updateStaff = null;
        LocalDate today = LocalDate.now(), minBirthDate = LocalDate.of(1940, 1, 1),
                minHireDate = LocalDate.of(2010, 1, 1);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

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

                for (ZooStaff staff : staffList) {
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
                                try {
                                    LocalDate parsedDate = LocalDate.parse(tempBirthDate, dateTimeFormatter);

                                    if (parsedDate.isBefore(minBirthDate)) {
                                        System.out.println("Date is too early. Only after 1940.");
                                        check = false;
                                    } else if (parsedDate.isAfter(today)) {
                                        System.out.println("Date cannot be later than today.");
                                        check = false;
                                    } else if (today.getYear() - parsedDate.getYear() < 18) {
                                        System.out.println("Staff must be at least 18 years old.");
                                        check = false;
                                    } else {
                                        check = true;
                                    }
                                } catch (DateTimeParseException e) {
                                    System.out.println("Date format not correct. Kindly re-input.");
                                    check = false;
                                }
                            } while (!check);
                            updateStaff.setBirthDate(LocalDate.parse(tempBirthDate, dateTimeFormatter));
                            break;
                        case 3:
                            do {
                                System.out.println("Input gender of " + updateStaff.getID() + ": (M/F)");
                                tempGender = scanner.nextLine();
                                if (!tempGender.equals("M") && !tempGender.equals("F")) {
                                    check = false;
                                    System.out.println("Invalid input. Kindly re-input.");
                                } else check = true;
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
                                tempHireDate = scanner.nextLine();
                                try {
                                    LocalDate parsedDate = LocalDate.parse(tempHireDate, dateTimeFormatter);

                                    if (parsedDate.isBefore(minHireDate)) {
                                        System.out.println("Date is too early. Only after 2010.");
                                        check = false;
                                    } else if (parsedDate.isAfter(today)) {
                                        System.out.println("Date cannot be later than today.");
                                        check = false;
                                    } else {
                                        check = true;
                                    }
                                } catch (DateTimeParseException e) {
                                    System.out.println("Date format not correct. Kindly re-input.");
                                    check = false;
                                }
                            } while (!check);
                            updateStaff.setHireDate(LocalDate.parse(tempHireDate, dateTimeFormatter));
                            break;
                        case 7:
                            System.out.println("Input new salary of " + updateStaff.getID());
                            do {
                                try {
                                    updateStaff.setSalary(Double.parseDouble(scanner.nextLine()));
                                    check = true;
                                } catch (NumberFormatException e) {
                                    System.out.println("Number format not correct. pls try again.");
                                    check = false;
                                }
                            } while (!check);
                            break;
                        case 8:
                            do {
                                System.out.println("Input new phone number of " + updateStaff.getID());
                                tempNumber = scanner.nextLine();
                                if (!PatternFormat.phoneNumber(tempNumber)) {
                                    System.out.println("Number format not correct. Kindly re-input.");
                                    check = false;
                                } else check = true;
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
                                } else check = true;
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
                        System.out.println("New update as below. Do you still want to update other information? (Y/N)\n"
                                + updateStaff.toString());
                        confirm = scanner.nextLine();
                    }
                } while (!confirm.equalsIgnoreCase("Y"));

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
        } while (!confirm.equalsIgnoreCase("Y"));
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
