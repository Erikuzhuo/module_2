package CaseStudy.ZooManagement.Service;

import CaseStudy.ZooManagement.Controller.StaffControl;

import java.util.Scanner;

public class StaffManagement {
    public static void staffControl() {
        Scanner scanner = new Scanner(System.in);
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
        }
    }
}
