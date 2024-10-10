package ss17.bai_tap.ProductManagement.Model;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String name;
    private double price;
    private String productType;
    private String description;

    public Product() {
    }

    public Product(String id, String name, double price, String productType, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productType = productType;
        this.description = description;
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String convertToLine() {
        return id + " , " + name + " , " + price + " , " + productType + " , " + description + ".";
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", productType='" + productType + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
