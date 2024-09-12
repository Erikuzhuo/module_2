package ss6.bai_tap.CircleAndCylinder;

public class Test {
    public static void main(String[] args) {
        Circle circle = new Circle(2,"yellow");
        System.out.println("Thông số hình tròn: "+circle.toString() +"\n Diện tích hình tròn: "+circle.getCircleArea());
        Cylinder cylinder = new Cylinder(5,10);
        System.out.println("Thông số hình trụ: "+cylinder.toString()+"\n Diện tích hình trụ: "+cylinder.getCylinderArea());
    }
}
