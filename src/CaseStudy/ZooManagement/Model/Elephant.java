package CaseStudy.ZooManagement.Model;

import CaseStudy.ZooManagement.Services.ISound;

import java.time.LocalDate;

public class Elephant extends ZooAnimal implements ISound {
    public Elephant(String ID, String name, String gender, LocalDate birthDate,
                    LocalDate moveInDate, LocalDate moveOutDate, String originFrom,
                    String inchargeBy, String note) {
        super(ID, name, gender, birthDate, moveInDate, moveOutDate, originFrom,
                inchargeBy, note);
    }

    public Elephant() {
    }


    @Override
    public String Sound() {
        return "whoom....";
    }
}
