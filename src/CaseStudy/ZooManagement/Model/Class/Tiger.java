package CaseStudy.ZooManagement.Model.Class;

import java.time.LocalDate;

public class Tiger extends ZooAnimal implements IAnimalSound {
    public Tiger(String ID, String name, String gender, LocalDate birthDate,
                 LocalDate moveInDate, String originFrom,
                 String inchargeBy, String note) {
        super(ID, name, gender, birthDate, moveInDate, originFrom,
                inchargeBy, note);
    }

    public Tiger() {
    }


    @Override
    public String eatFood() {
        return "Meat.";
    }
}
