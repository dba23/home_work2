package Geomteries;

import Primitives.Material;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.awt.*;
import java.util.List;
import java.util.Objects;

public class Triangle extends Geometry {

    private Point3D _p1 ;
    private Point3D _p2 ;

    public Triangle(Color _emission, Material material, Point3D _p1, Point3D _p2, Point3D _p3) {
        super(_emission, material);
        this._p1 = _p1;
        this._p2 = _p2;
        this._p3 = _p3;
    }

    public Triangle(Color _emission, Point3D _p1, Point3D _p2, Point3D _p3) {
        super(_emission);
        this._p1 = _p1;
        this._p2 = _p2;
        this._p3 = _p3;
    }

    private Point3D _p3 ;

    public Triangle(Point3D _p1, Point3D _p2, Point3D _p3, Color _emission) {
        super(_emission);
        this._p1 = _p1;
        this._p2 = _p2;
        this._p3 = _p3;
    }
    public Triangle(Point3D _p1, Point3D _p2, Point3D _p3) {
        super(Color.BLACK);
        this._p1 = _p1;
        this._p2 = _p2;
        this._p3 = _p3;
    }

    public Triangle() {
        super(Color.BLACK);
        int c1 = 1;
        int c2 = 0;
        this._p1 = new Point3D(c1,c1,c1);
        this._p2 = new Point3D(c2,c2,c2);
        this._p3 = new Point3D();
    }
    public Triangle(Triangle triangle) {
        super(Color.BLACK);
        this._p1 = triangle._p1;
        this._p2 = triangle._p2;
        this._p3 = triangle._p3;
    }

    public Point3D get_p1() {
        return _p1;
    }

    public void set_p1(Point3D _p1) {
        this._p1 = _p1;
    }

    public Point3D get_p2() {
        return _p2;
    }

    public void set_p2(Point3D _p2) {
        this._p2 = _p2;
    }

    public Point3D get_p3() {
        return _p3;
    }

    public void set_p3(Point3D _p3) {
        this._p3 = _p3;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(_p1, triangle._p1) &&
                Objects.equals(_p2, triangle._p2) &&
                Objects.equals(_p3, triangle._p3);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "_p1=" + _p1 +
                ", _p2=" + _p2 +
                ", _p3=" + _p3 +
                '}';
    }

    public List<Point3D> findIntersections(Ray ray){
        Point3D rayPoint = ray.get_P00();
        Vector direction = ray.get_direction();
        List<Point3D> intersectionPoint = null;

        Vector vector1 = _p1.subtract(rayPoint);
        Vector vector2 = _p2.subtract(rayPoint);
        Vector vector3 = _p3.subtract(rayPoint);

        Vector normal1 = vector1.crossProduct(vector2).normalized();
        Vector normal2 = vector2.crossProduct(vector3).normalized();
        Vector normal3 = vector3.crossProduct(vector1).normalized();

        double num1 = direction.dotProduct(normal1);
        double num2 = direction.dotProduct(normal2);
        double num3 = direction.dotProduct(normal3);

        if ((num1 > 0 && num2 > 0 && num3 > 0) || (num1 < 0 && num2 < 0 && num3 < 0)) {
            Plain triangleOnPlane = new Plain(_p1, _p2, _p3, Color.BLACK);
            intersectionPoint = triangleOnPlane.findIntersections(ray);
        }
        return intersectionPoint;
    }
    public Vector getNormal(Point3D point){
        Vector v1=new Vector();
        Vector v2=new Vector();
        v1=this._p1.subtract(this._p2);
        v2=this._p1.subtract(this._p3);
        return (v1.crossProduct(v2).normalized());
    }

}
