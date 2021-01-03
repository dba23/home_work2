package Geomteries;

import Primitives.Material;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sphere extends Geometry {
    private Point3D _center;
    private double _radius;

    public Sphere(Point3D _center, double _radius, Color _emission) {
        super(_emission);
        this._center = _center;
        this._radius = _radius;
    }
    public Sphere(double _radius, Point3D _center , Color _emission) {
        super(_emission);
        this._center = _center;
        this._radius = _radius;
    }
    public Sphere(Point3D _center, double _radius) {
        super(Color.BLACK);
        this._center = _center;
        this._radius = _radius;
    }

    public Sphere(double _radius, Point3D _center) {
        super(Color.BLACK);
        this._center = _center;
        this._radius = _radius;
    }
    public Sphere() {
        super(Color.BLACK);
        this._center = new Point3D();
        this._radius =1;
    }

    public Sphere(Sphere sphere) {
        super(Color.BLACK);
        this._center = sphere._center;
        this._radius = sphere._radius;
    }

    public Sphere(Color _emission, Material material, Point3D _center, double _radius) {
        super(_emission, material);
        this._center = _center;
        this._radius = _radius;
    }

    public Sphere(Color _emission, Point3D _center, double _radius) {
        super(_emission);
        this._center = _center;
        this._radius = _radius;
    }

    public Point3D get_center() {
        return _center;
    }

    public void set_center(Point3D _center) {
        this._center = _center;
    }

    public double get_radius() {
        return _radius;
    }

    public void set_radius(double _radius) {
        this._radius = _radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sphere sphere = (Sphere) o;
        return Double.compare(sphere._radius, _radius) == 0 &&
                Objects.equals(_center, sphere._center);
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "_center=" + _center +
                ", _radius=" + _radius +
                ", _emission=" + _emission +
                '}';
    }

    public List<Point3D> findIntersections(Ray ray) {
        List<Point3D> intersectionPoints = null;
        Point3D point = ray.get_P00();
        Vector direction = ray.get_direction();

        Vector edgeU = _center.subtract(point);
        double tm = direction.dotProduct(edgeU);
        double distanceToRay;
        double distanceToRaySquared = Math.pow(edgeU.length(), 2) - Math.pow(tm, 2);
        if (distanceToRaySquared >= 0) {
            distanceToRay = Math.sqrt(distanceToRaySquared);
            if (distanceToRay <= _radius) {
                double th = Math.sqrt(Math.pow(_radius, 2) - Math.pow(distanceToRay, 2));
                double intersection1 = tm + th;
                if (intersection1 > 0) {
                    intersectionPoints = new ArrayList<>();
                    if (distanceToRay == _radius) {
                        Point3D intersectionPoint = ray.get_P00().add(ray.get_direction().scale(tm));
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
    public Vector getNormal(Point3D point){
        Vector vector=new Vector();
        vector=point.subtract(this._center);
        return vector.normalized();
    }
}
