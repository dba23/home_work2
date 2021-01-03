package Geomteries;

import Primitives.Material;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.awt.*;
import java.util.List;
import java.util.Objects;

public class Polygon extends Geometry {
    private List<Point3D>_points;

    public Polygon(List<Point3D> _points, Color _emission) {
        super(_emission);
        this._points = _points;
    }
    public Polygon(List<Point3D> _points) {
        super(Color.BLACK);
        this._points = _points;
    }

    public Polygon(Color _emission, Material material, List<Point3D> _points) {
        super(_emission, material);
        this._points = _points;
    }

    public Polygon(Color _emission, List<Point3D> _points) {
        super(_emission);
        this._points = _points;
    }

    public List<Point3D> get_points() {
        return _points;
    }

    public void set_points(List<Point3D> _points) {
        this._points = _points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polygon polygon = (Polygon) o;
        return Objects.equals(_points, polygon._points);
    }

    @Override
    public String toString() {
        return "Polygon{" +
                "_points=" + _points +
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
