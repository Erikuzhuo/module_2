package ss7.bai_tap.Resizable.Management;

import ss7.bai_tap.Resizable.Shape.Circle;
import ss7.bai_tap.Resizable.Shape.Rectangle;
import ss7.bai_tap.Resizable.Shape.Shape;
import ss7.bai_tap.Resizable.Shape.Square;

import java.util.Random;

public class Management {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rec = new Rectangle();
        Shape square = new Square();
        System.out.println("Hình tròn trước Resize: " + circle.getArea());
        circle.resize();
        System.out.println("Hình tròn sau Resize: " + circle.getArea());

        System.out.println("Hình vuông trước Resize: " + square.getArea());
        square.resize();
        System.out.println("Hình vuông sau Resize: " + square.getArea());

        System.out.println("Hình tứ giác trước Resize: " + rec.getArea());
        rec.resize();
        System.out.println("Hình tứ giác sau Resize: " + rec.getArea());
    }
}
