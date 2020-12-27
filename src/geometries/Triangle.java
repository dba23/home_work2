package geometries;

import primitivs.*;

import java.util.List;
import java.util.Objects;

public class Triangle extends Geometry implements Cloneable{
    Point3D p1,p2,p3;

    public Triangle(Point3D p1, Point3D p2, Point3D p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }
    public Triangle()
    {
        this.p1=new Point3D(-1,0,0);
        this.p2 =new Point3D(0,1, 0);
        this.p3 =new Point3D(1,0, 0);
    }

    public Point3D getP1() {
        return p1;
    }

    public void setP1(Point3D p1) {
        this.p1 = p1;
    }

    public Point3D getP2() {
        return p2;
    }

    public void setP2(Point3D p2) {
        this.p2 = p2;
    }

    public Point3D getP3() {
        return p3;
    }

    public void setP3(Point3D p3) {
        this.p3 = p3;
    }

    public Object clone()throws CloneNotSupportedException{
        return (Triangle)super.clone();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(getP1(), triangle.getP1()) &&
                Objects.equals(getP2(), triangle.getP2()) &&
                Objects.equals(getP3(), triangle.getP3());
    }

    @Override
    public String toString() {
        return "Triangle =" +
                "\np1=" + p1 +
                "\n p2=" + p2 +
                "\n p3=" + p3 ;
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        Point3D rayPoint = ray.getHeadPoint();
        Vector direction = ray.getDirection();
        List<Point3D> intersectionPoint = null;

        Vector vector1 = p1.subtract(rayPoint);
        Vector vector2 = p2.subtract(rayPoint);
        Vector vector3 = p3.subtract(rayPoint);

        Vector normal1 = vector1.crossProduct(vector2).normalize();
        Vector normal2 = vector2.crossProduct(vector3).normalize();
        Vector normal3 = vector3.crossProduct(vector1).normalize();

        double num1 = direction.dotProduct(normal1);
        double num2 = direction.dotProduct(normal2);
        double num3 = direction.dotProduct(normal3);

        if ((num1 > 0 && num2 > 0 && num3 > 0) || (num1 < 0 && num2 < 0 && num3 < 0)) {
            Plane triangleOnPlane = new Plane(p1, p2, p3);
            intersectionPoint = triangleOnPlane.findIntersections(ray);
        }
        return intersectionPoint;
    }

    @Override
    public Vector getNormal(Point3D point) {
        Vector vector1 = p2.subtract(p1);
        Vector vector2 = p3.subtract(p1);
        return vector1.crossProduct(vector2).normalize();
    }
}
