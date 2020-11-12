package Geometries;

import Primitivs.*;

import java.util.Objects;

public class Plane extends Geometry
{
    Point3D point3D;
    Vector vector;

    public Plane(Point3D point3D, Vector vector) {
        this.point3D = point3D;
        this.vector = vector;
    }

    public Point3D getPoint3D() {
        return point3D;
    }

    public void setPoint3D(Point3D point3D) {
        this.point3D = point3D;
    }

    public Vector getVector() {
        return vector;
    }

    public void setVector(Vector vector) {
        this.vector = vector;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane)) return false;
        Plane plane = (Plane) o;
        return Objects.equals(getPoint3D(), plane.getPoint3D()) &&
                Objects.equals(getVector(), plane.getVector());
    }

    @Override
    public String toString() {
        return "Plane =" +
                "\npoint3D=" + point3D +
                "\n vector=" + vector;
    }
}
