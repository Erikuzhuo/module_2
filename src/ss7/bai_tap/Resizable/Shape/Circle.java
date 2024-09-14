package ss7.bai_tap.Resizable.Shape;

import ss7.bai_tap.Resizable.Management.Resizable;

import java.util.Random;

public class Circle extends Shape implements Resizable {
    private double radius = 1.0;

    Random random = new Random();

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius="
                + getRadius()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize() {
        setRadius(getRadius()+(random.nextDouble()*100+1));
    }
}
