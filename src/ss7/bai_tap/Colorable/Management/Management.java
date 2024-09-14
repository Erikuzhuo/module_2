package ss7.bai_tap.Colorable.Management;

import ss7.bai_tap.Colorable.Shape.Circle;
import ss7.bai_tap.Colorable.Shape.Rectangle;
import ss7.bai_tap.Colorable.Shape.Shape;
import ss7.bai_tap.Colorable.Shape.Square;

import java.util.Arrays;

public class Management {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Square square = new Square();
        Rectangle rectangle = new Rectangle();
        Shape[] shapes = {circle, square, rectangle, square};
        for (Shape shape : shapes) {
            if (shape == square) {
                System.out.println("Diện tích: " + shape.getArea() + ", Colorable: " + square.howToColour());
            } else {
                System.out.println("Diện tích: " + shape.getArea());
            }
        }


    }
}
