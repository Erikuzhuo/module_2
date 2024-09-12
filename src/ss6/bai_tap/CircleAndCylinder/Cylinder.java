package ss6.bai_tap.CircleAndCylinder;

public class Cylinder extends Circle{
    private double height;

    public Cylinder(){

    }
    public Cylinder(double radius,double height){
        super(radius);
        this.height=height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getCylinderArea(){
        return (2*Math.PI*getRadius()*height)+2*getCircleArea();
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "raidus=" + getRadius() +
                ", height=" + height +
                "}";

    }
}
