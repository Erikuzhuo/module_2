package ss7.bai_tap.Colorable.Management;

import ss7.bai_tap.Colorable.Shape.Circle;
import ss7.bai_tap.Colorable.Shape.Rectangle;
import ss7.bai_tap.Colorable.Shape.Shape;
import ss7.bai_tap.Colorable.Shape.Square;

public class Management {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape square = new Square();
        Shape rectangle = new Rectangle();
        Shape[] shapes = {circle, square, rectangle, square};
        for (Shape shape : shapes) {
            if (shape instanceof Square) {
                System.out.println("Diện tích: " + shape.getArea() + ", Colorable: " + ((Square) shape).howToColour());
            } else {
                System.out.println("Diện tích: " + shape.getArea());
            }
        }
    }
}
