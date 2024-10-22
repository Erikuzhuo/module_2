package CaseStudy.ZooManagement.Model.Class;

import java.time.LocalDate;

public class Admin extends Animal {
    private String address, position, email, note;
    private String phoneNumber;
    private double salary;
    private LocalDate hireDate;

    public Admin(String ID) {
    }

    public Admin(String ID, String name, String gender, LocalDate birthDate,
                 LocalDate hireDate, String position, double salary,
                 String email, String phoneNumber, String address, String note) {
        super(ID, name, gender, birthDate);
        this.address = address;
        this.position = position;
        this.email = email;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.note = note;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", Gender='" + gender + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", position='" + position + '\'' +
                ", hireDate='" + hireDate + '\'' +
                ", salary=" + salary + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", address='" + address + '\'' +
                ", note='" + note +
                "} ";
    }

    public String convertToLine() {
        return ID + "," + name + "," + gender + "," + birthDate + "," +
                position + "," + hireDate + "," + salary + "," + email + "," +
                phoneNumber + "," + address + "," + note;
    }
}
