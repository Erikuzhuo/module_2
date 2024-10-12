package ss17.bai_tap.CopyFileNhiPhan.Service;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyFile myFile  = new MyFile();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Read File.\n" +
                    "2. Write File.\n" +
                    "3. Clear File.\n" +
                    "Kindly Choice Your Option Number: ");
            int option = Integer.parseInt(scanner.nextLine());
            System.out.println("Read from File.");
            String readFile = scanner.nextLine();
            System.out.println("File need to input.");
            String writeFile = scanner.nextLine();

            switch (option) {
                case 1:
                    myFile.readFromFile(readFile);
                    break;
                case 2:
                    List<Integer> dataList= new ArrayList<>();
                    System.out.println("How many int you want to input.");
                    int count = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < count; i++) {
                        System.out.println("Giá trị của "+i+".");
                        dataList.add(Integer.parseInt(scanner.nextLine()));
                    }
                    myFile.writeToFile(dataList,writeFile);
                case 3:
                    System.out.println("File muốn xóa dữ liệu: ");
                    String clearFile = scanner.nextLine();
                    MyFile.clearFile(clearFile);
                    break;
                default:
                    System.exit(0);
            }
        }
    }

    private static class MyFile {
        private static File PARENT_PATH = new File("src/ss17/bai_tap/CopyFileNhiPhan/File");

        private static void writeToFile(List<Integer> dataList, String fileName) {
            File file = new File(PARENT_PATH, fileName);
            try {
                if (!file.exists()) {
                    System.out.println("File does not exist! Creating now.");
                    file.createNewFile();
                    System.out.println("File Created.Writing...");
                }
                System.out.println("Existing File. Writing...");
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(dataList);
                System.out.println("File Already Update.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private static void readFromFile(String fileName) {
            File file = new File(PARENT_PATH, fileName);
            List dataList = new ArrayList<>();
            try {
                if (!file.exists()) {
                    System.out.println("File does not exist! Creating now.");
                    file.createNewFile();
                    System.out.println("File Created.Reading...");
                }
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                dataList = (List) objectInputStream.readObject();
                System.out.println("Already export the file.");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        private static void clearFile(String fileName) {
            File file = new File(PARENT_PATH, fileName);
            try {
                if (!file.exists()) {
                    System.out.println("File does not exist! Creating now.");
                    file.createNewFile();
                    System.out.println("File Created.Writing...");
                }
                System.out.println("Existing File. Writing...");
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeByte(0);
                System.out.println("File Already clear.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

