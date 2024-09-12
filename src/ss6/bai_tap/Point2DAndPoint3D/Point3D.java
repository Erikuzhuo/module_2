package ss6.bai_tap.Point2DAndPoint3D;

public class Point3D extends Point2D {
    private float z;

    public Point3D(){

    }

    public Point3D(float x, float y, float z){
        super(x,y);
        this.z = z;
    }
    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x,float y,float z){
        setXY(x,y);
        this.z=z;
    }

    public float[] getXYZ(){
        return new float[]{getX(),getY(),z};
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x= " +getX()+
                ", y= " +getY()+
                ", z=" + z +
                "} ";
    }
}
