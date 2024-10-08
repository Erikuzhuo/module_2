package ss7.bai_tap.Resizable.Shape;

import ss7.bai_tap.Resizable.Management.Resizable;

import java.util.Random;

public class Rectangle extends Shape implements Resizable {
    private double width = 2.0;
    private double length = 1.0;

    Random random = new Random();

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * this.length;
    }

    public double getPerimeter() {
        return 2 * (width + this.length);
    }

    @Override
    public String toString() {
        return "A Rectangle with width="
                + getWidth()
                + " and length="
                + getLength()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize() {
        setLength(getLength()+(random.nextDouble()*100+1));
        setWidth(getWidth()+(random.nextDouble()*100+1));
    }
}