package geometries;

import primitivs.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import java.util.InputMismatchException;

public class Plane extends Geometry implements Cloneable {
    private Point3D pointOnPlane;
    private Vector vertical;

    public Plane(Point3D centralPoint, Vector vertical) {
        setPointOnPlane(centralPoint);
        setVertical(vertical.normalize());
    }

    public Plane(Point3D point1,Point3D point2,Point3D point3) {
        if (point1.equals(point2) || point1.equals(point3))
            throw new IllegalArgumentException("You can't send two identical points!");
        Vector v1 = point1.subtract(point2);
        Vector v2 = point1.subtract(point3);
        this.vertical = v1.crossProduct(v2).normalize();
        this.pointOnPlane = new Point3D(point1);
    }

    public Object clone() throws CloneNotSupportedException {
        return (Plane) super.clone();
    }

    public Point3D getPointOnPlane() {
        return pointOnPlane;
    }

    public Vector getVertical() {
        return vertical;
    }

    public void setPointOnPlane(Point3D pointOnPlane) {
        try {
            this.pointOnPlane = pointOnPlane;
        } catch (NullPointerException | InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setVertical(Vector vertical) {
        try {
            this.vertical = vertical;
        } catch (NullPointerException | InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return Objects.equals(pointOnPlane, plane.pointOnPlane) &&
                Objects.equals(vertical, plane.vertical);
    }

    @Override
    public String toString() {
        return "Plane, start point: " + pointOnPlane.toString() + ", natural: " + vertical.toString();

    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        List<Point3D> intersectionPoint = null;
        Vector direction = ray.getDirection();
        Point3D rayCenter = ray.getHeadPoint();

        double denomination = direction.dotProduct(vertical);
        if (!rayCenter.equals(pointOnPlane)) {
            if (denomination != 0) {
                Vector vector = pointOnPlane.subtract(rayCenter);
                double t = vertical.dotProduct(vector) / denomination;
                if (t > 0) {
                    intersectionPoint = new ArrayList<>();
                    intersectionPoint.add(rayCenter.add(direction.scale(t)));
                }
            }
        }
        return intersectionPoint;
    }

    public Vector getNormal() {
        return vertical;
    }
    @Override
    public Vector getNormal(Point3D point) {
        return getNormal();
    }


}
