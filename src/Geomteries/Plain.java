package Geomteries;
import Primitives.Material;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Plain extends Geometry {
    private Point3D _q;
    private Vector _v;

    public Plain(Point3D _q, Vector _v, Color _emission) {
        super(_emission);
        this._q = _q;
        this._v = _v;
    }
    public Plain(Point3D _q, Vector _v) {
        super(Color.BLACK);
        this._q = _q;
        this._v = _v;
    }

    public Plain(Point3D p1, Point3D p2, Point3D p3, Color _emission) {
        super(_emission);
        if (p1.equals(p2) || p1.equals(p3))
            throw new IllegalArgumentException("p1=p2 or p1=p3");
        Vector v1 = p1.subtract(p2);
        Vector v2 = p1.subtract(p3);
        _v = v1.crossProduct(v2).normalized();
        _q = new Point3D(p1);

    }
    public Plain(Point3D p1, Point3D p2, Point3D p3) {
        super(Color.BLACK);
        if (p1.equals(p2) || p1.equals(p3))
            throw new IllegalArgumentException("p1=p2 or p1=p3");
        Vector v1 = p1.subtract(p2);
        Vector v2 = p1.subtract(p3);
        _v = v1.crossProduct(v2).normalized();
        _q = new Point3D(p1);

    }

    public Plain() {
        super(Color.BLACK);
        int c1 = 1;
        int c2 = 2;
        this._q = new Point3D(c1, c2, c1);
        this._v = new Vector();
    }

    public Plain(Color _emission, Material material, Point3D _q, Vector _v) {
        super(_emission, material);
        this._q = _q;
        this._v = _v;
    }

    public Plain(Color _emission, Point3D _q, Vector _v) {
        super(_emission);
        this._q = _q;
        this._v = _v;
    }

    public Point3D get_q() {
        return _q;
    }

    public void set_q(Point3D _q) {
        this._q = _q;
    }

    public Vector get_v() {
        return _v;
    }

    public void set_v(Vector _v) {
        this._v = _v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plain plane = (Plain) o;
        return Objects.equals(_q, plane._q) &&
                Objects.equals(_v, plane._v);
    }


    @Override
    public String toString() {
        return "Plane{" +
                "_q=" + _q +
                ", _n=" + _v +
                '}';
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        List<Point3D> list = new ArrayList<>();
        Point3D p;
        double t = this._v.dotProduct(this._q.subtract(ray.get_P00())) / this._v.dotProduct(ray.get_direction());
        if (t > 0) {
            p = ray.get_P00().add(ray.get_direction().scale(t));
            list.add(p);
            return list;
        }
        return null;
    }

    @Override
    public Vector getNormal(Point3D point) {
        return this._v;
    }

}
