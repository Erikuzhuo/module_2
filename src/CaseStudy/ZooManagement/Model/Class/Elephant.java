package CaseStudy.ZooManagement.Model.Class;

import java.time.LocalDate;

public class Elephant extends ZooAnimal implements IAnimalSound {
    public Elephant(String ID, String name, String gender, LocalDate birthDate,
                    LocalDate moveInDate,  String originFrom,
                    String inchargeBy, String note) {
        super(ID, name, gender, birthDate, moveInDate, originFrom,
                inchargeBy, note);
    }

    public Elephant() {
    }


    @Override
    public String eatFood() {
        return "Grass and Fruit.";
    }
}
