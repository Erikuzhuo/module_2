package ss7.bai_tap.Colorable.Shape;

import ss7.bai_tap.Colorable.Management.Colorable;

public class Square extends Shape implements Colorable {

    private double width = 1.0;

    public Square() {
    }

    public Square(double width) {
        this.width = width;
    }

    public Square(String color, boolean filled, double width) {
        super(color, filled);
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    public double getArea(){
        return Math.pow(width,2);
    }

    @Override
    public String toString() {
        return "Square{" +
                "width=" + width +
                "} " +
                ", which is a subclass of " +
                super.toString();
    }

    @Override
    public String howToColour() {
        return "Color all four sides.";

    }
}
