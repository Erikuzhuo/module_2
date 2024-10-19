package CaseStudy.ZooManagement.Model;

import java.time.LocalDate;

public abstract class ZooAnimal extends Animal {
    private String originFrom, inchargeBy, note;
    private LocalDate moveInDate, moveOutDate;

    public ZooAnimal() {
    }

    public ZooAnimal(String ID, String name, String gender, LocalDate birthDate,
                     LocalDate moveInDate, LocalDate moveOutDate, String originFrom,
                     String inchargeBy, String note) {
        super(ID, name, gender, birthDate);
        this.name = name;
        this.originFrom = originFrom;
        this.inchargeBy = inchargeBy;
        this.note = note;
        this.birthDate = birthDate;
        this.moveInDate = moveInDate;
        this.moveOutDate = moveOutDate;
    }

    public String getOriginFrom() {
        return originFrom;
    }

    public void setOriginFrom(String originFrom) {
        this.originFrom = originFrom;
    }

    public String getInchargeBy() {
        return inchargeBy;
    }

    public void setInchargeBy(String inchargeBy) {
        this.inchargeBy = inchargeBy;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getMoveInDate() {
        return moveInDate;
    }

    public void setMoveInDate(LocalDate moveInDate) {
        this.moveInDate = moveInDate;
    }

    public LocalDate getMoveOutDate() {
        return moveOutDate;
    }

    public void setMoveOutDate(LocalDate moveOutDate) {
        this.moveOutDate = moveOutDate;
    }


    @Override
    public String toString() {
        return "ZooAnimal{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate=" + birthDate +
                ", originFrom='" + originFrom + '\'' +
                ", moveInDate=" + moveInDate +
                ", moveOutDate=" + moveOutDate +
                ", inchargeBy='" + inchargeBy + '\'' +
                ", note='" + note + '\'' +
                "} ";
    }

    public String convertToLine() {
        return ID + "," + name + "," + gender + "," + birthDate + "," + originFrom + "," + moveInDate + "," +
                moveOutDate + "," + inchargeBy + note;
    }
}
