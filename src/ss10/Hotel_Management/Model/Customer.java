package ss10.Hotel_Management.Model;

import java.time.LocalDate;

public class Customer extends Person {
    private String id;
    private String address;

    public Customer() {

    }

    public Customer(String name, LocalDate birthday, String id, String address) {
        super(name, birthday);
        this.id = id;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + getName() + '\'' +
                ", birthday='" + getBirthday() + '\'' +
                ", address='" + address + '\'' +
                "} ";
    }
}
