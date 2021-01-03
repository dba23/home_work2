package Geomteries;

import Primitives.Material;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.awt.*;
import java.util.List;
import java.util.Objects;

public class Cylinder extends Geometry {
    private double _radius;
    private Ray _axis;
    private double height;

    public Cylinder(double _radius, Ray _axis, double height, Color _emission) {
        super(_emission);
        this._radius = _radius;
        this._axis = _axis;
        this.height = height;
    }
    public Cylinder(double _radius, Ray _axis, double height) {
        super(Color.BLACK);
        this._radius = _radius;
        this._axis = _axis;
        this.height = height;
    }

    public Cylinder() {
        super(Color.BLACK);
        this._radius = 1;
        this._axis = new Ray();
        this.height = 2;
    }

    public Cylinder(Color _emission, Material material, double _radius, Ray _axis, double height) {
        super(_emission, material);
        this._radius = _radius;
        this._axis = _axis;
        this.height = height;
    }

    public Cylinder(Color _emission, double _radius, Ray _axis, double height) {
        super(_emission);
        this._radius = _radius;
        this._axis = _axis;
        this.height = height;
    }

    public double get_radius() {
        return _radius;
    }

    public void set_radius(double _radius) {
        this._radius = _radius;
    }

    public Ray get_axis() {
        return _axis;
    }

    public void set_axis(Ray _axis) {
        this._axis = _axis;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cylinder cylinder = (Cylinder) o;
        return Double.compare(cylinder._radius, _radius) == 0 &&
                Double.compare(cylinder.height, height) == 0 &&
                Objects.equals(_axis, cylinder._axis);
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "_radius=" + _radius +
                ", _axis=" + _axis +
                ", height=" + height +
                '}';
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
