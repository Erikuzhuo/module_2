package ss12.bai_tap.Model;

import java.util.Comparator;

public class Product {
    private String id;
    private String name;
    private String unitType;
    private Double unitPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Product(String id, String name, String unitType, Double unitPrice) {
        this.id = id;
        this.name = name;
        this.unitType = unitType;
        this.unitPrice = unitPrice;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", status='" + unitType + '\'' +
                ", price=" + unitPrice +
                '}';
    }
}
