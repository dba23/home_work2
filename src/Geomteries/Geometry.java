package Geomteries;

import Primitives.*;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import java.awt.*;
import java.util.List;
import java.util.Objects;

public abstract class Geometry implements Cloneable {
    public Color _emission;
    Material material;

    public Geometry(Color _emission, Material material) {
        this._emission = _emission;
        this.material = material;
    }

    public abstract List<Point3D> findIntersections(Ray ray);
    public abstract Vector getNormal(Point3D point);

    public Geometry(Color _emission) {
        this._emission = _emission;
    }

    public Color get_emission() {
        return _emission;
    }

    public void set_emission(Color _emission) {
        this._emission = _emission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Geometry geometry = (Geometry) o;
        return Objects.equals(_emission, geometry._emission);
    }

    @Override
    public String toString() {
        return "Geometry{" +
                "_emission=" + _emission +
                '}';
    }

}
