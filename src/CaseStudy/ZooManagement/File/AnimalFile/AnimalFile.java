package CaseStudy.ZooManagement.File.AnimalFile;

import CaseStudy.ZooManagement.Model.Class.*;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AnimalFile {
    public static final String PARENT_PATH = "src/CaseStudy/ZooManagement/File/AnimalFile";
    public static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public static List<ZooAnimal> readAnimalFromFile() {
        List<ZooAnimal> animalList = new ArrayList<>();
        File animalFile = new File(PARENT_PATH, "AnimalFile.CSV");
        try {
            if (!animalFile.exists()) {
                System.out.println("File not exist. Creating....");
                animalFile.createNewFile();
                System.out.println("Files created. Reading....");
            }
            System.out.println("Reading...");

            FileReader fileReader = new FileReader(animalFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] animalString = line.split(",");
                ZooAnimal animal = getZooAnimal(animalString);
                animalList.add(animal);
                bufferedReader.close();
                fileReader.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return animalList;
    }

    private static ZooAnimal getZooAnimal(String[] animalString) {
        ZooAnimal animal = null;
        if (animalString.length == 9) {
            String ID = animalString[0];
            String name = animalString[1];
            String gender = animalString[2];
            LocalDate birthDate = LocalDate.parse(animalString[3].replace("-","/"),dateTimeFormatter);
            String originFrom = animalString[4];
            LocalDate moveInDate = LocalDate.parse(animalString[5].replace("-","/"),dateTimeFormatter);
            String inchargeBy = animalString[6];
            String note = animalString[7];

            if (Objects.equals(ID.charAt(0), "E")) {
                animal = new Elephant(ID, name, gender, birthDate, moveInDate, originFrom, inchargeBy, note);
            } else if (Objects.equals(ID.charAt(0), "M")) {
                animal = new Monkey(ID, name, gender, birthDate, moveInDate, originFrom, inchargeBy, note);
            } else if (Objects.equals(ID.charAt(0), "O")) {
                animal = new Owl(ID, name, gender, birthDate, moveInDate, originFrom, inchargeBy, note);
            } else if (Objects.equals(ID.charAt(0), "T")) {
                animal = new Tiger(ID, name, gender, birthDate, moveInDate, originFrom, inchargeBy, note);
            }
        }
        return animal;
    }

    public static void writeAnimalToList(List<ZooAnimal> list) {
        File animalFile = new File(PARENT_PATH, "AnimalFile.CSV");
        try {
            if (!animalFile.exists()) {
                System.out.println("File not exist. Creating....");
                animalFile.createNewFile();
                System.out.println("Files created. Writing....");
            }
            System.out.println("Writing...");

            FileWriter fileWriter = new FileWriter(animalFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null) {
                    bufferedWriter.write(list.get(i).convertToLine());
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void clearList() {
        File animalFile = new File(PARENT_PATH, "AnimalFile.CSV");
        try {
            if (!animalFile.exists()) {
                System.out.println("File not exist. Creating....");
                animalFile.createNewFile();
                System.out.println("Files created. Writing....");
            }
            System.out.println("Writing...");
            FileWriter fileWriter = new FileWriter(animalFile, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("");
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}