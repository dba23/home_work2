package geometries;

import primitivs.*;
import primitivs.Point3D;

import java.awt.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;

public class Sphere extends Geometry implements Cloneable {

    private Point3D center;
    private double radius;




    public Sphere(Point3D point3D, double r, Color color) {
        super(color);

        this.center = point3D;
        this.radius = r;
    }

    public Object clone() throws CloneNotSupportedException {
        return (Sphere) super.clone();
    }

    public void setCenter(Point3D center) {
        try {
            this.center = center;
        } catch (NullPointerException | InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setRadius(double radius) {
        try {
            this.radius = radius;
        } catch (NullPointerException | InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }

    public Point3D getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Sphere: center: " + center.toString() + ", radius: " + radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sphere sphere = (Sphere) o;
        return Double.compare(sphere.radius, radius) == 0 &&
                Objects.equals(center, sphere.center);
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        List<Point3D> intersectionPoints = new ArrayList<Point3D>();
        Point3D point = ray.getHeadPoint();
        Vector direction = ray.getDirection();

        Vector edgeU = center.subtract(point);
        double tm = direction.dotProduct(edgeU);
        double distanceToRay;
        double distanceToRaySquared = Math.pow(edgeU.length(), 2) - Math.pow(tm, 2);
        if (distanceToRaySquared >= 0) {
            distanceToRay = Math.sqrt(distanceToRaySquared);
            if (distanceToRay <= radius) {
                double th = Math.sqrt(Math.pow(radius, 2) - Math.pow(distanceToRay, 2));
                double intersection1 = tm + th;
                if (intersection1 > 0) {
                    intersectionPoints = new ArrayList<>();
                    if (distanceToRay == radius) {
                        Point3D intersectionPoint = ray.getHeadPoint().add(ray.getDirection().scale(tm));
                        intersectionPoints.add(intersectionPoint);
                    } else {
                        Point3D intersectionPoint1 = point.add(direction.scale(intersection1));
                        intersectionPoints.add(intersectionPoint1);
                        double intersection2 = tm - th;
                        if (intersection2 > 0) {
                            Point3D intersectionPoint2 = point.add(direction.scale(intersection2));
                            intersectionPoints.add(intersectionPoint2);
                        }
                    }
                }
            }
        }
        return intersectionPoints;
    }

    @Override
    public Vector getNormal(Point3D point) {
        return point.subtract(center).normalize();
    }
}