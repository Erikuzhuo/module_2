package ss6.bai_tap.Point2DAndPoint3D;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(2,3);
        System.out.println("Mảng 2D: "+ Arrays.toString((point2D.getXY())) + "Có giá trị: "+point2D.toString());
        Point3D point3D = new Point3D(2,3,4);
        point3D.setXYZ(7,8,9);
        System.out.println("Mảng 3D: "+ Arrays.toString((point3D.getXYZ())) + "Có giá trị: "+point3D.toString());
    }
}
