package CaseStudy.ZooManagement.File.AnimalFile;

import CaseStudy.ZooManagement.Model.Animal;
import ss17.bai_tap.ProductManagement.Controller.MyFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalFile {
    public static final String PARENT_PATH = "src/CaseStudy/ZooManagement/File/AnimalFile";
    public static List<Animal> readFromFile(){
        List<Animal> animalList = new ArrayList<>();
        File animalFile = new File(PARENT_PATH,"AnimalFile.CSV");
        try{
            if(!animalFile.exists()){
                System.out.println("File not exist. Creating....");
                animalFile.createNewFile();
                System.out.println("Files created. Reading....");
            }
            System.out.println("Reading...");

            FileReader fileReader = new FileReader(animalFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }return animalList;
    }


}
