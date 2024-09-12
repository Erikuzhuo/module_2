package ss6.bai_tap.PointAndMoveablePoint;

public class Test {
    public static void main(String[] args) {
        Point point = new Point(1,2);
        System.out.println(point.toString());
        MoveablePoint movePoint = new MoveablePoint(3,4,5,6);
        movePoint.move();
        System.out.println(movePoint.toString());
    }
}
