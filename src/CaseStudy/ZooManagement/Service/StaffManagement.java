package CaseStudy.ZooManagement.Service;

import CaseStudy.ZooManagement.Controller.StaffControl;

import java.util.Scanner;

public class StaffManagement {
    public static void staffControl() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choice your option number: \n" +
                "1. Create Staff Information.\n" +
                "2. Update Staff Information.\n" +
                "3. Delete Staff Information.\n" +
                "4. Display Staff Data.\n" +
                "5. Exit.");
        int staffOption = scanner.nextInt();
        switch (staffOption) {
            case 1:
                StaffControl.createStaff();
                break;
            case 2:
                StaffControl.updateStaffList();
                break;
            case 3:
                StaffControl.deleteStaff();
                break;
            case 4:
                StaffControl.displayStaffList();
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Your option does not exist.");
                break;
        }
    }
}
