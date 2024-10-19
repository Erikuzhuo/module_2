package CaseStudy.ZooManagement.Model;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Animal implements Serializable {
    String ID, name, gender;
    LocalDate birthDate;

    public Animal(String ID, String name, String gender, LocalDate birthDate) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public Animal() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", Gender='" + gender + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }
}
