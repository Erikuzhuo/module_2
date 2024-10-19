package CaseStudy.ZooManagement.Model;

import java.time.LocalDate;

public class Tiger extends ZooAnimal implements IAnimalSound {
    public Tiger(String ID, String name, String gender, LocalDate birthDate,
                 LocalDate moveInDate, LocalDate moveOutDate, String originFrom,
                 String inchargeBy, String note) {
        super(ID, name, gender, birthDate, moveInDate, moveOutDate, originFrom,
                inchargeBy, note);
    }

    public Tiger() {
    }


    @Override
    public String Sound() {
        return "Growl....";
    }
}
