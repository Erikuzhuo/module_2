package ss5.bai_tap.AccessModifier;

public class Circle {
    private double radius;
    private String color;

    public Circle() {
        double radius = 1.0;
        String color = "red";
    }

    public Circle(double radius){
        this.radius=radius;
    }

    public double getRadius() {
        return radius;
    }
    public double getArea(){
        return Math.PI*radius*radius;
    }
}
