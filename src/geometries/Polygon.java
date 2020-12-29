package geometries;
import primitivs.*;
import primitivs.Point3D;

import java.awt.*;
import java.util.List;
import java.util.Objects;


public class Polygon extends Geometry
{
    List<Point3D> points;

    public Polygon(List<Point3D> points, Color c) {
        super(c);
        this.points = points;
    }

    public List<Point3D> getPoints() {
        return points;
    }

    public void setPoints(List<Point3D> points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Polygon)) return false;
        Polygon polygon = (Polygon) o;
        return Objects.equals(getPoints(), polygon.getPoints());
    }

    @Override
    public String toString() {
        return "Polygon= " +
                "points =" + points ;
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
