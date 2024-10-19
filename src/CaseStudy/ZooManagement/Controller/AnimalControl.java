package CaseStudy.ZooManagement.Controller;

import CaseStudy.ZooManagement.Model.Animal;
import CaseStudy.ZooManagement.Model.ZooAnimal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalControl {
    Scanner scanner = new Scanner(System.in);

    public void createAninmal(){
        List<ZooAnimal> animalList = new ArrayList<>();
//        do{
            System.out.println("How many new animal? ");
            int animalNumber = Integer.parseInt(scanner.nextLine());

//        }
    }
}
