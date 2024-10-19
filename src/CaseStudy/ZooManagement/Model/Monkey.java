package CaseStudy.ZooManagement.Model;

import java.time.LocalDate;

public class Monkey extends ZooAnimal implements IAnimalSound {
    public Monkey(String ID, String name, String gender, LocalDate birthDate,
                  LocalDate moveInDate, LocalDate moveOutDate, String originFrom,
                  String inchargeBy, String note) {
        super(ID, name, gender, birthDate, moveInDate, moveOutDate, originFrom,
                inchargeBy, note);
    }

    public Monkey() {
    }


    @Override
    public String Sound() {
        return "Ooh Ooh Aah Aah";
    }
}
