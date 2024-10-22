package CaseStudy.ZooManagement.Model.Class;

import java.time.LocalDate;

public class Monkey extends ZooAnimal {
    public Monkey(String ID, String name, String gender, LocalDate birthDate,
                  LocalDate moveInDate, String originFrom,
                  String inchargeBy, String note) {
        super(ID, name, gender, birthDate, moveInDate, originFrom,
                inchargeBy, note);
    }

    public Monkey() {
    }


    @Override
    public String eatFood() {
        return "Fruit.";
    }
}
