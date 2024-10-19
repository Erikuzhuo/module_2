package CaseStudy.ZooManagement.Model;

import java.time.LocalDate;

public class ZooStaff extends Animal {
    private String address, position, email, note;
    private int phoneNumber;
    private double salary;
    private LocalDate hireDate;

    public ZooStaff() {
    }

    public ZooStaff(String ID, String name, String gender, LocalDate birthDate,
                    LocalDate hireDate, String position, double salary,
                    String email, int phoneNumber, String address, String note) {
        super(ID, name, gender, birthDate);
        this.name = name;
        this.address = address;
        this.position = position;
        this.email = email;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.birthDate = birthDate;
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
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
