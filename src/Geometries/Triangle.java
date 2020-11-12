package Geometries;

import Primitivs.*;

import java.util.Objects;

public class Triangle extends Geometry {
    Point3D p1,p2,p3;

    public Triangle(Point3D p1, Point3D p2, Point3D p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
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
}
