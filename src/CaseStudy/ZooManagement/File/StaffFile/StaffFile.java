package CaseStudy.ZooManagement.File.StaffFile;

import CaseStudy.ZooManagement.Model.Class.ZooStaff;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StaffFile {
    public static final String PARENT_PATH = "src/CaseStudy/ZooManagement/File/StaffFile";

    public static List<ZooStaff> readStaffFromFile() {
        List<ZooStaff> staffList = new ArrayList<>();
        File staffFile = new File(PARENT_PATH, "StaffFile.CSV");
        try {
            if (!staffFile.exists()) {
                System.out.println("File not exist. Creating....");
                staffFile.createNewFile();
                System.out.println("Files created. Reading....");
            }
            System.out.println("Reading...");

            FileReader fileReader = new FileReader(staffFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] staffString = line.split(",");
                ZooStaff staff = getZooStaff(staffString);
                staffList.add(staff);
                bufferedReader.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return staffList;
    }

    private static ZooStaff getZooStaff(String[] staffString) {
        ZooStaff staff = null;
        if (staffString.length == 11) {
            String ID = staffString[0];
            String name = staffString[1];
            String gender = staffString[2];
            LocalDate birthDate = LocalDate.parse(staffString[3]);
            LocalDate hireDate = LocalDate.parse(staffString[4]);
            String position = staffString[5];
            double salary = Double.parseDouble(staffString[6]);
            String email = staffString[7];
            String phoneNumber = staffString[8];
            String address = staffString[9];
            String note = staffString[10];

            staff = new ZooStaff(ID, name, gender, birthDate, hireDate, position, salary, email, phoneNumber, address, note);

        }
        return staff;
    }

    public static void writeStaffToFile(List<ZooStaff> list) {
        File staffFile = new File(PARENT_PATH, "StaffFile.CSV");
        try {
            if (!staffFile.exists()) {
                System.out.println("File not exist. Creating....");
                staffFile.createNewFile();
                System.out.println("Files created. Writing....");
            }
            System.out.println("Writing...");

            FileWriter fileWriter = new FileWriter(staffFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null) {
                    bufferedWriter.write(list.get(i).convertToLine());
                    bufferedWriter.newLine();
                    System.out.println(bufferedWriter);
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void clearList() {
        File staffFile = new File(PARENT_PATH, "StaffFile.CSV");
        try {
            if (!staffFile.exists()) {
                System.out.println("File not exist. Creating....");
                staffFile.createNewFile();
                System.out.println("Files created. Writing....");
            }
            System.out.println("Writing...");
            FileWriter fileWriter = new FileWriter(staffFile, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("");
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

