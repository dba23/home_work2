package geometries;
import primitivs.*;

import java.util.List;
import java.util.Objects;

public class Cylinder extends Geometry
{
    //test
    double radius,height;
    Ray axis;

    public Cylinder(double radius, double height, Ray axis) {
        this.radius = radius;
        this.height = height;
        this.axis = axis;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Ray getAxis() {
        return axis;
    }

    public void setAxis(Ray axis) {
        this.axis = axis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cylinder)) return false;
        Cylinder cylinder = (Cylinder) o;
        return Double.compare(cylinder.getRadius(), getRadius()) == 0 &&
                Double.compare(cylinder.getHeight(), getHeight()) == 0 &&
                Objects.equals(getAxis(), cylinder.getAxis());
    }

    @Override
    public String toString() {
        return "Cylinder = " +
                "\nradius=" + radius +
                "\nheight=" + height +
                "\naxis=" + axis;
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        return null;
    }

    @Override
    public Vector getNormal(Point3D point) {
        return null;
    }
}
