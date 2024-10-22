package CaseStudy.ZooManagement.Model.Class;

import java.time.LocalDate;

public class Owl extends ZooAnimal {
    public Owl(String ID, String name, String gender, LocalDate birthDate,
               LocalDate moveInDate,  String originFrom,
               String inchargeBy, String note) {
        super(ID, name, gender, birthDate, moveInDate, originFrom,
                inchargeBy, note);
    }

    public Owl() {
    }


    @Override
    public String eatFood() {
        return "Insect.";
    }
}
