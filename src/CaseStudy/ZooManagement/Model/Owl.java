package CaseStudy.ZooManagement.Model;

import java.time.LocalDate;

public class Owl extends ZooAnimal implements IAnimalSound {
    public Owl(String ID, String name, String gender, LocalDate birthDate,
               LocalDate moveInDate, LocalDate moveOutDate, String originFrom,
               String inchargeBy, String note) {
        super(ID, name, gender, birthDate, moveInDate, moveOutDate, originFrom,
                inchargeBy, note);
    }

    public Owl() {
    }


    @Override
    public String Sound() {
        return "Hoot Hoot....";
    }
}
