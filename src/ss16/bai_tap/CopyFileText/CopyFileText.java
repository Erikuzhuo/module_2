package ss16.bai_tap.CopyFileText;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class CopyFileText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String check = "";
        while (!Objects.equals(check,"N")) {
            File sourceFile, destinationFile;
            try {
                System.out.println("Input Source File Path: ");
                final String SOURCEPATH = scanner.nextLine();
                sourceFile = new File(SOURCEPATH);
                FileReader readerFile = new FileReader(sourceFile);
                BufferedReader bufferedReader = new BufferedReader(readerFile);
                if (!sourceFile.exists()) {
                    System.out.println("File Not Found.");
                    return;
                }

                System.out.println("Input Destination File Path: ");
                final String DESTINATIONPATH = scanner.nextLine();
                destinationFile = new File(DESTINATIONPATH);
                FileWriter writerFile = new FileWriter(destinationFile, true);
                BufferedWriter bufferedWriter = new BufferedWriter(writerFile);
                if (destinationFile.exists()) {
                    System.out.println("Destination file already exists.");
                }

                String character;
                int characterCount = 0;
                while ((character = bufferedReader.readLine()) != null) {
                    bufferedWriter.write(character);
                    bufferedWriter.newLine();
                    characterCount += character.length();
                    System.out.println(writerFile);
                }
                bufferedReader.close();
                bufferedWriter.close();

                System.out.println("File copied successfully! Number of characters copied: " + characterCount);
            } catch (FileNotFoundException e) {
                System.out.println("File Not Found.");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Are you still continue? (Y/N): ");
            check = scanner.nextLine();
        }
    }
}
